package org.idey.algo.ds.tree;

public class TreeUtil {
    public static <T> TreeNode<T> buildTree(T[] array, final int low, final int high){
        if(low>high){
            return null;
        }
        int mid = low+(high-low)/2;
        TreeNode<T> node = new TreeNode<>(array[mid]);
        node.setLeft(buildTree(array,low, mid-1));
        node.setRight(buildTree(array, mid + 1, high));
        return node;
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,5,6};
        Tree<Integer> tree = new Tree<>(buildTree(array,0,array.length-1));

    }
}
