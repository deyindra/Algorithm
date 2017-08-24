package org.idey.algo.ds.tree;


import java.util.Stack;

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

    private static <E> boolean print(TreeNode<E> root, TreeNode<E> target){
        if(root == null)
            return false;
        if(root.equals(target)){
            return true;
        }
        if(print(root.getLeft(), target) || print(root.getRight(), target)){
            System.out.println(root);
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,5,6};
        Tree<Integer> tree = new Tree<>(buildTree(array,0,array.length-1));
        System.out.println(tree);
        System.out.println(getNthSmallestOrLargestElement(tree.getRoot(),2, false));
        System.out.println(isBST(tree.getRoot()));
        TreeNode<Integer> root = new TreeNode<>(4);
        root.addLeft(new TreeNode<>(2)).addRight(new TreeNode<>(5));
        root.getLeft().addLeft(new TreeNode<>(2));
        root.getLeft().addRight(new TreeNode<>(7));

        System.out.println(isBST(root));
        print(root,new TreeNode<>(8));

    }

    public static class TreeNodeWrapper<E>{
        private TreeNode<E> node;

        public TreeNode<E> getNode() {
            return node;
        }

        public void setNode(TreeNode<E> node) {
            this.node = node;
        }
    }


    public static <E extends Comparable<E>> boolean isBST(TreeNode<E> node, TreeNodeWrapper<E> wrapper){
        if(node==null){
            return true;
        }else{
            if(!isBST(node.getLeft(), wrapper)){
                return false;
            }
            if(wrapper.getNode()!=null && node.getData().compareTo(wrapper.getNode().getData())<0){
                return false;
            }
            wrapper.setNode(node);
            return isBST(node.getRight(),wrapper);
        }
    }

    public static <E extends Comparable<E>> E getNthSmallestOrLargestElement(TreeNode<E> root, int k, boolean isSmallest){
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> value = root;
        int count=1;
        E result = root.getData();
        while (!stack.isEmpty() || value!=null){
            if(value != null) {
                stack.push(value);
                value = isSmallest ? value.getLeft() : value.getRight();
            } else {
                value = stack.pop();
                result = value.getData();
                if(count++ == k) break;
                value = isSmallest? value.getRight() : value.getLeft();
            }
        }
        return result;
    }

    public static <E extends Comparable<E>> boolean isBST(TreeNode<E> root){
        TreeNodeWrapper<E> wrapper = new TreeNodeWrapper<>();
        wrapper.setNode(null);
        return isBST(root,wrapper);
    }



}
