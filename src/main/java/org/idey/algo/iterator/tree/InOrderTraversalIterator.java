package org.idey.algo.iterator.tree;

import org.idey.algo.ds.tree.TreeNode;

import java.util.NoSuchElementException;
/**
 * @author indranildey
 * In Order search iterator for Tree
 */
public class InOrderTraversalIterator<E> extends AbstractTreeDFSIterator<E> {
    public InOrderTraversalIterator(TreeNode<E> root) {
        super(root);
        for(TreeNode<E> current=root;current!=null;current=current.getLeft()){
            stack.push(current);
        }
    }

    @Override
    public E next() {
        if(!hasNext()){
            throw new NoSuchElementException("No more elements....");
        }
        TreeNode<E> left = stack.pop();
        E data = left.getData();
        for(TreeNode<E> child=left.getRight();child!=null;child=child.getLeft()){
            stack.push(child);
        }
        return data;
    }
}
