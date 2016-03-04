package org.idey.algo.iterator.tree;

import org.idey.algo.ds.tree.TreeNode;

import java.util.NoSuchElementException;

public class PreOrderTraversalIterator<E> extends AbstractTreeDFSIterator<E> {
    public PreOrderTraversalIterator(TreeNode<E> root) {
        super(root);
        stack.push(root);
    }

    @Override
    public E next() {
        if(!hasNext()){
            throw new NoSuchElementException("No more elements....");
        }
        TreeNode<E> node = this.stack.pop();
        E data = node.getData();
        TreeNode<E> left = node.getLeft();
        TreeNode<E> right = node.getRight();

        if(right!=null){
            stack.push(right);
        }
        if(left!=null){
            stack.push(left);
        }
        return data;
    }
}
