package org.idey.algo.util;

import org.idey.algo.ds.Pair;
import org.idey.algo.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Util {

    //Time complexity O(N), Space Complexity O(1)
    public static List<Pair<Integer, Integer>> getPairs(int[] array, final int sum){
        int start = 0;
        int end = array.length-1;
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        while (start < end){
            int resultSum = array[start] + array[end];
            if(resultSum < sum){
                start++;
            }else if (resultSum > sum){
                end --;
            }else{
                list.add(Pair.of(array[start], array[end]));
                start ++ ;
                end --;
            }

        }
        return list;
    }

    //Time O(n) and Space O(longN)
    public static List<Pair<Integer, Integer>> getPairs(final TreeNode<Integer> tree, final int sum){
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        Stack<TreeNode<Integer>> left = new Stack<>();
        Stack<TreeNode<Integer>> right = new Stack<>();

        TreeNode<Integer> leftCurrent = tree;
        TreeNode<Integer> rightCurrent = tree;

        while (!left.isEmpty() || !right.isEmpty() || leftCurrent!=null || rightCurrent!=null){
            if (leftCurrent != null || rightCurrent != null) {
                if (leftCurrent != null) {
                    left.push(leftCurrent);
                    leftCurrent = leftCurrent.getLeft();
                }

                if (rightCurrent != null) {
                    right.push(rightCurrent);
                    rightCurrent = rightCurrent.getRight();
                }
            }else{
                TreeNode<Integer> leftValue = left.peek();
                TreeNode<Integer> rightValue = right.peek();

                int leftVal = leftValue.getData() ;
                int rightVal = rightValue.getData();

                if(leftValue==rightValue){
                    break;
                }

                if(leftVal + rightVal == sum){
                    list.add(Pair.of(leftVal, rightVal));
                    leftCurrent = left.pop();
                    leftCurrent = leftCurrent.getRight();
                    rightCurrent = right.pop();
                    rightCurrent = rightCurrent.getLeft();
                }else if(leftVal + rightVal < sum){
                    leftCurrent = left.pop();
                    leftCurrent = leftCurrent.getRight();
                }else{
                    rightCurrent = right.pop();
                    rightCurrent = rightCurrent.getLeft();
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[] {0,1,2,3,4,6};
        System.out.println(getPairs(array,5));
    }


}
