package tree;

/**
 * Interface to implement the visitor pattern for a binary search tree.
 *
 * @param <T> parametric type of the binary search tree elements
 */

// Visitor method which must be implemented at classes which store the functionality
public interface TreeVisitor<T extends Comparable<T>> {

    /**
     * Visit an empty node.
     *
     * @param node to visit
     * @return the result of visiting the node (recursively)
     */
    String visit(Empty<T> node);

    /**
     * Visit a node.
     *
     * @param node to visit
     * @return the result of visiting the node (recursively)
     */
    String visit(Node<T> node);
}
