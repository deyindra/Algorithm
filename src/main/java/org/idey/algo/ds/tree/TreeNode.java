package org.idey.algo.ds.tree;

public class TreeNode<E> {
    private E data;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(E data) {
        this.data = data;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public TreeNode<E> addLeft(TreeNode<E> left){
        this.left = left;
        return this;
    }

    public TreeNode<E> addRight(TreeNode<E> right){
        this.right = right;
        return this;
    }

    public E getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode<?> treeNode = (TreeNode<?>) o;

        return !(data != null ? !data.equals(treeNode.data) : treeNode.data != null);

    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TreeNode{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
