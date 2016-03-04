package org.idey.algo.iterator.tree;

import org.idey.algo.ds.tree.TreeNode;

import java.util.NoSuchElementException;

public class LevelOrderTraversalIterator<E> extends AbstrackBFSIterator<E> {
    public LevelOrderTraversalIterator(TreeNode<E> root) {
        super(root);
    }

    @Override
    public E next() {
        if(!hasNext()){
            throw new NoSuchElementException("No more element....");
        }
        TreeNode<E> node = queue.poll();
        E data = node.getData();

        TreeNode<E> left = node.getLeft();
        TreeNode<E> right = node.getRight();

        if(left!=null){
            queue.offer(left);
        }
        if(right!=null){
            queue.offer(right);
        }
        return data;
    }
}
