package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class RecipeTest {
    private Recipe rec1;
    private Recipe rec2;
    private Recipe rec3;

    private CoffeeMaker cm;
    @Before
    public void setup() throws RecipeException {

        cm = new CoffeeMaker();

        rec1 = new Recipe();
        rec1.setName("");
        rec1.setAmtCoffee("0");
        rec1.setAmtChocolate("0");
        rec1.setPrice("0");
        rec1.setAmtMilk("0");
        rec1.setAmtSugar("0");

        rec2 = new Recipe();
        rec2.setName("Ristretto");
        rec2.setAmtCoffee("1");
        rec2.setAmtChocolate("1");
        rec2.setPrice("1");
        rec2.setAmtMilk("1");
        rec2.setAmtSugar("1");

        rec3 = new Recipe();
        rec3.setName("Latte");
        rec3.setAmtCoffee("3");
        rec3.setAmtChocolate("4");
        rec3.setPrice("70");
        rec3.setAmtMilk("3");
        rec3.setAmtSugar("4");

    }

    @Test
    public void testEmptyNameInput() {
        Throwable exception =
                assertThrows( // should throw an exception but none are thrown
                RecipeException.class, () -> {
                    cm.addRecipe(rec1);
                }
                );
    }

    @Test
    public void testNameIsNumber() {

        Throwable exception =
                assertThrows( // should throw an exception but none are thrown
                        RecipeException.class, () -> {
                            rec3.setName("12345#5-");
                            cm.addRecipe(rec3);
                        }
                );
    }

    @Test
    public void testRecipeNotNull() {
        assertNotNull(rec2);
    }

    @Test
    public void testNegativeAmtCoffee() {
        Throwable exception =
                assertThrows(
                        RecipeException.class, () -> {
                            rec3.setAmtCoffee("-1");
                            cm.addRecipe(rec3);
                        }
                );

    }

    @Test
    public void testBigInputValues() {

        Throwable exception =
                assertThrows( // should throw an exception but none are thrown
                        RecipeException.class, () -> {
                            rec3.setAmtCoffee("100");
                            rec3.setPrice("100");
                            rec3.setAmtMilk("100");
                            rec3.setAmtSugar("100");
                            rec3.setAmtChocolate("100");
                            cm.addRecipe(rec3);
                        }
                );
    }

    @Test
    public void testInputPriceZero() {

        Throwable exception =
                assertThrows( // should throw an exception but none are thrown
                        RecipeException.class, () -> {
                            rec3.setPrice("0");
                            rec3.setAmtChocolate("1");
                            rec3.setAmtMilk("1");
                            rec3.setAmtSugar("1");
                            rec3.setAmtCoffee("1");
                            cm.addRecipe(rec3);
                        }
                );

    }

    @Test
    public void testSetPrice() {

        Throwable exception =
                assertThrows(
                        RecipeException.class, () -> {
                            rec3.setPrice("-1");
                        }
                );
    }

    @Test
    public void testNegativeValues() {

        Throwable exception =
                assertThrows(
                        RecipeException.class, () -> {
                            rec3.setAmtSugar("-1");
                        }
                );
    }

    // Problem 2,  tests
    @Test
    public void testThrowExceptionPrice() {
        Throwable exception =
                assertThrows(
                        RecipeException.class, () -> {
                            rec1.setPrice("price");
                        }
                );

    }
    @Test
    public void testTestNormalPrice() throws RecipeException {
        rec1.setPrice("20");
        assertTrue(rec1.getPrice() >= 0);
    }
    // line coverage for Recipe is 52% so far
    @Test
    public void testNormalAddSugar() throws RecipeException {
        rec1.setAmtSugar("3");
        assertEquals(3, rec1.getAmtSugar());
    }
    @Test
    public void testNormalAddCoffee() throws RecipeException {
        rec1.setAmtCoffee("2");
        assertEquals(2, rec1.getAmtCoffee());
    }
    @Test
    public void testSetStringMilk() throws RecipeException {
      Throwable exception =
              assertThrows(
                      RecipeException.class, () -> {
                          rec1.setAmtMilk("milk");
                      }
              );

    }

    @Test
    public void testSetNegativeMilk() throws RecipeException {
        Throwable exception =
                assertThrows(
                        RecipeException.class, () -> {
                            rec1.setAmtMilk("-10");
                        }
                );

    }
    @Test
    public void testGetSugar() {
        assertEquals(0, rec1.getAmtSugar());
    }
    @Test
    public void testGetAmtChocolate() {
        assertEquals(1, rec2.getAmtChocolate());
    }
    @Test
    public void testExceptionCoffee() {
        Throwable exception =
                assertThrows(
                        RecipeException.class, () -> {
                            rec1.setAmtCoffee("coffee");
                        }
                );

    }
    @Test
    public void testExceptionChocolate() {
        Throwable exception =
                assertThrows(
                        RecipeException.class, () -> {
                            rec1.setAmtChocolate("chocolate");
                        }
                );

    }
    @Test
    public void testNegativeChocolate() {
        Throwable exception =
                assertThrows(
                        RecipeException.class, () -> {
                            rec1.setAmtChocolate("-1");
                        }
                );

    }
    @Test
    public void testExceptionSugar() {
        Throwable exception =
                assertThrows(
                        RecipeException.class, () -> {
                            rec1.setAmtSugar("sugar");
                        }
                );

    }
    @Test
    public void testHashCode() {
        Recipe rec5 = new Recipe();
        Recipe rec6 = new Recipe();
        assertEquals(rec5.hashCode(), rec6.hashCode());
    }
    // testing equals() method
    @Test
    public void testRecipeEquals() {
        Recipe rec7 = new Recipe();
        Recipe rec8 = new Recipe();
        assertEquals(rec7.equals(rec8), rec8.equals(rec7));
    }
    @Test
    public void testRecipeNotEquals() {
        CoffeeMaker cm1 = new CoffeeMaker();
        assertNotEquals(rec1, cm1);
    }
    @Test
    public void testSameRecipe() {
        assertEquals(rec1, rec1);
    }
    @Test
    public void testNotSameName() {
        assertNotEquals(rec1.getName(), rec2.getName());
    }
    @Test
    public void testGetMilk() { assertEquals(0, rec1.getAmtMilk()); }
    @Test
    public void testGetName() { assertEquals("Ristretto", rec2.toString()); }

    // 97% coverage, equals cannot be covered 100% because the name cannot be set to null

}
