package org.idey.algo.iterator.tree;

import org.idey.algo.ds.tree.Tree;
import org.idey.algo.ds.tree.TreeNode;
import org.junit.Before;

public abstract class AbstractTreeTraversalIteratorTest {
    protected Tree<Integer> tree;
    protected Integer[] expectedOutput;
    protected TraversalType type;

    public AbstractTreeTraversalIteratorTest(Integer[] expectedOutput, TraversalType type) {
        this.expectedOutput = expectedOutput;
        this.type = type;
    }

    @Before
    public void init(){
        if(this instanceof SuccessTreeTraversalIteratorTest) {
            TreeNode<Integer> root = new TreeNode<>(1);
            TreeNode<Integer> left = new TreeNode<>(2);
            TreeNode<Integer> right = new TreeNode<>(3);
            TreeNode<Integer> leftOfLeft = new TreeNode<>(4);
            TreeNode<Integer> leftOfRight = new TreeNode<>(5);
            left.setLeft(leftOfLeft);
            left.setRight(leftOfRight);
            root.setLeft(left);
            root.setRight(right);
            tree = new Tree<>(root);
        }else{
            tree = new Tree<>(null);
        }
    }

    protected enum TraversalType{


        PREORDER {
            @Override
            AbstractTreeIterator<Integer> getIterator(Tree<Integer> tree) {
                return new PreOrderTraversalIterator<>(tree.getRoot());
            }
        },
        INORDER {
            @Override
            AbstractTreeIterator<Integer> getIterator(Tree<Integer> tree) {
                return new InOrderTraversalIterator<>(tree.getRoot());
            }
        },
        POSTORDER {
            @Override
            AbstractTreeIterator<Integer> getIterator(Tree<Integer> tree) {
                return new PostOrderTraversalIterator<>(tree.getRoot());
            }
        },
        LEVELORDER {
            @Override
            AbstractTreeIterator<Integer> getIterator(Tree<Integer> tree) {
                return new LevelOrderTraversalIterator<>(tree.getRoot());
            }
        },
        ADVANCELEVELORDER_TILL_LEVEL_1(1) {
            @Override
            AbstractTreeIterator<Integer> getIterator(Tree<Integer> tree) {
                return new AdvanceLevelOrderTraversalIterator<>(tree.getRoot(),this.depth);
            }
        },
        ADVANCELEVELORDER_TILL_LEVEL_10(10) {
            @Override
            AbstractTreeIterator<Integer> getIterator(Tree<Integer> tree) {
                return new AdvanceLevelOrderTraversalIterator<>(tree.getRoot(),this.depth);
            }
        };

        protected int depth;

        TraversalType(int depth) {
            this.depth = depth;
        }

        TraversalType() {
            this(0);
        }

        abstract AbstractTreeIterator<Integer> getIterator(Tree<Integer> tree);
    }


}
