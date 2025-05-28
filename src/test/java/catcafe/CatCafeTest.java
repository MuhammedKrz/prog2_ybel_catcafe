package catcafe;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
class CatCafeTest {

    // Test addCat function
    @Test
    void addCat() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("TestCat", 2));
        Optional<FelineOverLord> cat = cafe.getCatByName("TestCat");
        String name = cat.map(FelineOverLord::name)
            // if the value don't exists
            .orElse("Don't exists!");

        // then
        assertEquals("TestCat", name);
    }

    // Test getCatCount() method
    // Right number of cats?
    @Test
    void getCatCount() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("TestCat", 2));

        // then
        assertEquals(1,cafe.getCatCount());
    }

    // Test if the right optional gets returned
    @Test
    void getCatByName() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("Feline", 2));
        cafe.addCat(new FelineOverLord("Over", 5));
        cafe.addCat(new FelineOverLord("Lord", 4));
        Optional<FelineOverLord> cat = cafe.getCatByName("Over");
        String name = cat.map(FelineOverLord::name)
            // if the value don't exists
            .orElse("Don't exists!");

        // then
        assertEquals("Over", name);
    }

    // Check if the method fetches the right cat by the weight
    @Test
    void getCatByWeight() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("Feline", 2));
        cafe.addCat(new FelineOverLord("Over", 5));
        cafe.addCat(new FelineOverLord("Lord", 4));
        // searches for the first cat within weight limits
        Optional<FelineOverLord> cat = cafe.getCatByWeight(3,5);
        String name = cat.map(FelineOverLord::name)
            // if the value don't exists
            .orElse("Don't exists!");

        // then
        assertEquals("Lord", name);
    }

    // Check, what is the value of the Optional
    // if no cat with the weight we are looking for exists
    @Test
    void getNotExistingCatByWeight() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("Feline", 2));
        cafe.addCat(new FelineOverLord("Over", 5));
        cafe.addCat(new FelineOverLord("Lord", 4));
        // searches for cat with weight between the given values
        Optional<FelineOverLord> cat = cafe.getCatByWeight(6,7);
        String name = cat.map(FelineOverLord::name)
            // if the value don't exists
            .orElse("Don't exists!");

        // then
        assertEquals("Don't exists!", name);
    }

    // Test whether the method throws a NullPointerException if the visitor is null
    @Test
    void accept() {
        CatCafe cafe = new CatCafe();
        assertThrows(java.lang.NullPointerException.class, () -> {
            cafe.accept(null);
        });
    }

    // Calling multiple times the number of cats after adding cats
    @Test
    void multipleCallsOfTheGetCatCountMethod() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("TestCat", 2));

        // then
        assertEquals(1,cafe.getCatCount());

        // when
        cafe.addCat(new FelineOverLord("TestCat2", 6));

        // then
        assertEquals(2,cafe.getCatCount());

        // when
        cafe.addCat(new FelineOverLord("TestCat3", 8));

        // then
        assertEquals(3,cafe.getCatCount());
    }

    // Adding two cats with the same weight
    // Class FelineOverLord compares elements after weight
    // counts cats as duplicates if they have the same weight
    @Test
    void addCatsTwice() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("Feline", 2));
        cafe.addCat(new FelineOverLord("Over", 2));
        cafe.addCat(new FelineOverLord("Lord", 5));

        // then
        assertEquals(2,cafe.getCatCount());
    }

    // Adding a null instead of a cat
    // Expected is a NullPointerException
    @Test
    void addNullAsACat() {
        // given
        CatCafe cafe = new CatCafe();

        // then
        assertThrows(java.lang.NullPointerException.class, () -> {
            cafe.addCat(null);
        });
    }

    // Add two cats with the same Names and check if the don't count as duplicates
    @Test
    void addCatWithTheSameNames() {
        // Adding two cats with the same weight
        // given
        CatCafe cafe = new CatCafe();

        // when
        cafe.addCat(new FelineOverLord("Feline", 4));
        cafe.addCat(new FelineOverLord("Feline", 6));

        // then
        assertEquals(2,cafe.getCatCount());
    }
}
