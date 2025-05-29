package tree;

import static java.util.Objects.requireNonNull;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/**
 * Empty node in a binary search tree.
 *
 * @param <T> parametric type of the node data
 */

// Record class which implements the tree interface
// stable immutable class which doesn't change
// represents an empty tree
public record Empty<T extends Comparable<T>>() implements Tree<T> {
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Tree<T> addData(T data) {
        requireNonNull(data);

        return new Node<>(new Empty<>(), data, new Empty<>());
    }

    @Override
    public String accept(TreeVisitor<T> visitor) {
        requireNonNull(visitor);

        return visitor.visit(this);
    }

    // This method returns an iterator object
    // that allows to iterate through the elements of the tree
    @Override
    public Iterator<T> iterator() {
        return new TreeIterator<>(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        requireNonNull(action);

        for (T t : this) {
            action.accept(t);
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED);
    }
}
