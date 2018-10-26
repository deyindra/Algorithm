package org.idey.algo.iterator.tree;


import org.idey.algo.ds.tree.TreeNode;

import java.util.Iterator;

public abstract class AbstractTreeIterator<E> implements Iterator<E> {
    protected AbstractTreeIterator(TreeNode<E> root){
        if(root==null){
            throw new IllegalArgumentException("Invalid Tree root");
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove is not supported");
    }

}
