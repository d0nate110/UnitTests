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
    private Recipe rec4;
    private Recipe rec5;
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
        rec2.setAmtCoffee("3");
        rec2.setAmtChocolate("4");
        rec2.setPrice("30");
        rec2.setAmtMilk("3");
        rec2.setAmtSugar("4");

        rec3 = new Recipe();
        rec3.setName("Latte");
        rec3.setAmtCoffee("3");
        rec3.setAmtChocolate("4");
        rec3.setPrice("70");
        rec3.setAmtMilk("3");
        rec3.setAmtSugar("4");

    }

    @Test
    public void test_Name_Input() {
        Throwable exception =
                assertThrows( // should throw an exception but none are thrown
                RecipeException.class, () -> {
                    cm.addRecipe(rec1);
                }
                );
    }

    @Test
    public void test_Name_IsNumber() {
        Throwable exception =
                assertThrows( // should throw an exception but none are thrown
                        RecipeException.class, () -> {
                            rec3.setName("12345#5-");
                            cm.addRecipe(rec3);
                        }
                );
    }

    @Test
    public void test_Recipe_NotNull() {
        assertNotNull(rec2);
    }

    @Test
    public void test_Negative_Input() {
        try {
            rec3.setAmtCoffee("-1");
            cm.addRecipe(rec3);
        } catch(Exception e) {
            fail("Amount of coffee cannot be negative"); // should throw an exception
        }
    }

    @Test
    public void test_Big_Input() {

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
    public void test_Input_Zero() {
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
    public void test_Set_Price() {

        try{
            rec3.setPrice("-1");
        } catch(RecipeException e) {
            fail("Price cannot be negative"); // should throw an exception
        }
    }


    @Test
    public void test_Set_Erroneous_Input() {
        Throwable exception =
                assertThrows( // should throw an exception but none are thrown
                        RecipeException.class, () -> {

                            rec3.setPrice("000");
                            rec3.setAmtChocolate("000");
                            rec3.setAmtMilk("100");
                            rec3.setAmtCoffee("1");
                            rec3.setAmtSugar("100");
                            cm.addRecipe(rec3);
                        }
                );
    }

    @Test
    public void test_Normal_Recipe() {
        try {
            cm.addRecipe(rec2);
        } catch (Exception e) {
            fail("Failed to add recipe."); // should not throw an exception
        }
    }


    @Test
    public void test_Negative_Values() {
        Recipe rec4 = new Recipe();

        try {
            rec4.setName("");
            rec4.setAmtSugar("-1");
            rec4.setPrice("1");
            rec4.setAmtChocolate("-1");
            rec4.setAmtMilk("-1");
            rec4.setAmtSugar("-1");
            cm.addRecipe(rec4);
        } catch (Exception e) {
            fail("Recipe values cannot be negative"); // should throw an exception
        }
    }





}
