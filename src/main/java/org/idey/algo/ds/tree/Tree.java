package org.idey.algo.ds.tree;

public class Tree<E> {
    private TreeNode<E> root;

    public Tree(TreeNode<E> root) {
        this.root = root;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }
}
