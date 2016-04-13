package org.idey.algo.iterator.tree;

import org.idey.algo.ds.tree.TreeNode;

import java.util.NoSuchElementException;
/**
 * @author indranildey
 * Post Order search iterator for Tree
 */
public class PostOrderTraversalIterator<E> extends AbstractTreeDFSIterator<E> {
    public PostOrderTraversalIterator(TreeNode<E> root) {
        super(root);
        setNextObject(root);
    }

    private void setNextObject(TreeNode<E> root){
        TreeNode<E> current = root;
        while (current!=null){
            stack.push(current);
            TreeNode<E> left = current.getLeft();
            if(left!=null){
                current=left;
            }else{
                current=current.getRight();
            }
        }
    }

    @Override
    public E next() {
        if(!hasNext()){
            throw new NoSuchElementException("No More elements....");
        }

        TreeNode<E> res = stack.pop();
        E data = res.getData();
        if(!stack.isEmpty()){
            TreeNode<E> top = stack.peek();
            if(res==top.getLeft()){
                setNextObject(top.getRight());
            }
        }
        return data;
    }
}
