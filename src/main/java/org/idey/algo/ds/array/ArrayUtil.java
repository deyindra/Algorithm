package org.idey.algo.ds.array;

import java.util.Arrays;

public class ArrayUtil {



    public static <T> void separate(T[] array, Filter<T> filter){
        int i=0, j=array.length-1, numberOfMatching,numberOfNonMatching,k;

        while (i<j){
            while (filter.validate(array[i])){
                i++;
            }

            while ((!filter.validate(array[j]))){
                j--;
            }

            if(i<j){
                T object = array[i];
                array[i] = array[j];
                array[j] = object;
            }
        }
        numberOfMatching = i;
        numberOfNonMatching = array.length - j -1;
        if(numberOfMatching==0 || numberOfNonMatching==0){
            return;
        }

        k=0;
        j = array.length - numberOfNonMatching;

        while (k<array.length-1){
            if((k%2!=0) && (k!=array.length-1)){
                T object = array[k];
                array[k] = array[j];
                array[j] = object;
                j++;
            }
            k++;
        }




    }

    public interface Filter<T>{
        boolean validate(T object);
    }

    public static void main(String[] args) {
        Integer[] array = {1,3,-4,2,-5};
        separate(array, new Filter<Integer>() {
            @Override
            public boolean validate(Integer object) {
                return object>=0;
            }
        });

        System.out.println(Arrays.deepToString(array));
    }
}
