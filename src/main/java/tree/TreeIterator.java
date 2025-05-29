package tree;

import static java.util.Objects.requireNonNull;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Iterator for our binary search trees {@link Tree}.
 *
 * @param <T> parametric type of the node data
 */
public class TreeIterator<T extends Comparable<T>> implements Iterator<T> {
    // stack data structure
    // Last In, First Out principle
    // contains the unvisited nodes
    private final Stack<Tree<T>> stack;

    /**
     * Create a new Iterator for a given tree.
     *
     * @param root top-level node of the tree
     */
    public TreeIterator(Tree<T> root) {
        // Ensures that the root node is not null
        requireNonNull(root);

        // initializes the stack which will store all nodes
        stack = new Stack<>();
        pushAllLeftNodes(root);
    }

    // checks for further nodes after the left tree
    @Override
    // If that returns false the traversal finished
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // next() Method
    @Override
    public T next() {
        // Checks if stack is empty
        if (hasNext()) {
            // deletes and returns the top element of the stack
            Tree<T> node = stack.pop();
            // fetch the attribute of the record class node
            // if rightChild == null, the stack doesn't get changed
            pushAllLeftNodes(node.rightChild());
            // returns the value of the node
            return node.data();
        } else {
            throw new NoSuchElementException();
        }
    }

    private void pushAllLeftNodes(Tree<T> node) {
        requireNonNull(node);

        while (!node.isEmpty()) {
            // adds element to the stack
            stack.push(node);
            // gets the left child of the node
            // adds the left follower/child of the node
            // repeats that until we don't have an left child anymore
            node = node.leftChild();
        }
    }
}




//      4
//    /   \
//   2     6
//  / \   / \
// 1   3 5   7
// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
// visits first the left tree, than the root and than the right tree
