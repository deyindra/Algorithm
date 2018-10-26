package org.idey.algo.iterator.tree;

import org.idey.algo.ds.tree.TreeNode;

import java.util.NoSuchElementException;
/**
 * @author indranildey
 * Level Order search iterator for Tree till certain depth
 */
public class AdvanceLevelOrderTraversalIterator<E> extends AbstrackBFSIterator<E> {
    private int currentLevel;
    private int maxLevel;
    private int nodeInCurrentLevel;
    private int nodeInNextLevel;

    public AdvanceLevelOrderTraversalIterator(TreeNode<E> root
            , int maxLevel) {
        super(root);
        this.maxLevel = maxLevel;
        this.currentLevel=0;
        this.nodeInCurrentLevel=1;
        this.nodeInNextLevel=0;
    }

    @Override
    public boolean hasNext() {
        return super.hasNext() && currentLevel<=maxLevel;
    }

    @Override
    public E next() {
        if(!hasNext()){
            throw new NoSuchElementException("No more element....");
        }
        TreeNode<E> node = queue.poll();
        E data = node.getData();
        nodeInCurrentLevel--;
        TreeNode<E> left = node.getLeft();
        TreeNode<E> right = node.getRight();

        if(left!=null){
            queue.offer(left);
            nodeInNextLevel++;
        }
        if(right!=null){
            queue.offer(right);
            nodeInNextLevel++;
        }
        if(nodeInCurrentLevel==0){
            nodeInCurrentLevel=nodeInNextLevel;
            nodeInNextLevel=0;
            currentLevel++;
        }
        return data;
    }
}
