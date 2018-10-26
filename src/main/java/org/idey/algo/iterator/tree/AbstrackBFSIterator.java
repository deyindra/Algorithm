package org.idey.algo.iterator.tree;

import org.idey.algo.ds.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public abstract class AbstrackBFSIterator<E> extends AbstractTreeIterator<E> {
    protected Queue<TreeNode<E>> queue;

    protected AbstrackBFSIterator(TreeNode<E> root) {
        super(root);
        this.queue = new LinkedList<>();
        queue.offer(root);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
