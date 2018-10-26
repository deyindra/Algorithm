package org.idey.algo.iterator.generic.function;

import java.util.*;
import java.util.stream.Collectors;

public class MinMaxFunction<T extends Comparable<T>> extends AggregateFunction<T> {
    private boolean isMin;

    public MinMaxFunction(boolean isMin) {
        this.isMin = isMin;
    }



    @Override
    public T apply(Map<Long, List<T>> listMap) {
        Comparator<T> newComparator = (o1, o2) -> {
            if(o1==null && o2==null){
                return 0;
            }else if(o1==null){
                return -1;
            }else{
                return o1.compareTo(o2);
            }
        };
        Collection<List<T>> lists = listMap.values();
        List<T> finalArrayList = new ArrayList<>();
        lists.parallelStream().forEach(list -> addToFinalList(finalArrayList, list));

        Optional<T> object;
        if(isMin) {
            object = finalArrayList.parallelStream().collect(Collectors.minBy(newComparator));
        }else {
            object = finalArrayList.parallelStream().collect(Collectors.maxBy(newComparator));
        }
        if(object.isPresent()){
            return object.get();
        }else{
            return null;
        }
    }

    private synchronized void addToFinalList(List<T> finalList, List<T> originalList){
        finalList.addAll(originalList);
    }

}
