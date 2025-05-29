package tree;

import catcafe.FelineOverLord;

public class PostOrder implements TreeVisitor<FelineOverLord> {

    @Override
    public String visit(Empty<FelineOverLord> node) {
        return "";
    }

    @Override
    public String visit(Node<FelineOverLord> node) {
        // fetching the data from node recursive
        // calls itself
        String leftSubtree = node.leftChild().accept(this);
        String root = node.data().toString();
        String rightSubtree = node.rightChild().accept(this);
        return leftSubtree + " " + rightSubtree + root;
    }
}
