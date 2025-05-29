package tree;

import catcafe.FelineOverLord;

public class InOrderVisitor implements TreeVisitor<FelineOverLord>{

    // Changes the method based on the value because of overloading
    @Override
    public String visit(Empty<FelineOverLord> node) {
        return "";
    }

    @Override
    public String visit(Node<FelineOverLord> node) {
        // node objects have basically already the functionality
        String leftSubtree = node.leftChild().accept(this);
        String root = node.data().toString();
        String rightSubtree = node.rightChild().accept(this);
        return leftSubtree + " " + root + rightSubtree;
    }
}
