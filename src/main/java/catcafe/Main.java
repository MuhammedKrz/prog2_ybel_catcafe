package catcafe;

import tree.InOrderVisitor;
import tree.PostOrder;
import tree.TreeIterator;
import tree.TreeVisitor;

import java.util.Optional;

/** Starter for the cat-café task. */
public class Main {
    /**
     * And go.
     *
     * @param args command line parameters, not used
     */
    public static void main(String... args) {
        CatCafe cafe = new CatCafe();

        cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));
        cafe.addCat(new FelineOverLord("Gwenapurr Esmeralda", 3));
        cafe.addCat(new FelineOverLord("Morticia", 3));
        cafe.addCat(new FelineOverLord("Fitzby Darnsworth", 5));

        System.out.println("Es schnurren " + cafe.getCatCount() + " Samtpfötchen.");

        Optional<FelineOverLord> meow = cafe.getCatByWeight(3, 4);

        if (meow.isPresent()) System.out.println("Gewicht [3,4]: " + meow);

        meow = cafe.getCatByName("Morticia");
        if (meow.isPresent()) System.out.println("Name 'Morticia': " + meow);

        meow = cafe.getCatByName("Miss Chief Sooky");
        if (meow.isPresent()) System.out.println("Name 'Miss Chief Sooky': " + meow);


        // Test for postorder and inorder
        CatCafe cafe2 = new CatCafe();
        cafe2.addCat(new FelineOverLord("Cat1", 4));
        cafe2.addCat(new FelineOverLord("cat2", 2));
        cafe2.addCat(new FelineOverLord("Cat3", 6));
        cafe2.addCat(new FelineOverLord("cat4", 1));
        cafe2.addCat(new FelineOverLord("Cat5", 3));
        cafe2.addCat(new FelineOverLord("cat6", 5));
        cafe2.addCat(new FelineOverLord("Cat7", 7));

        // Test Inorder Visitor
        TreeVisitor<FelineOverLord> inorder = new InOrderVisitor();

        String test = cafe2.accept(inorder);
        System.out.println("InOrder: " + test);

        TreeVisitor<FelineOverLord> postorder = new PostOrder();

        String test2 = cafe2.accept(postorder);
        System.out.println("Postorder: " + test2);

    }
}
