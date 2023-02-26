package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CoffeeMakerTests {
    private CoffeeMaker coffeeMaker;
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;

    @Before
    public void setup() throws RecipeException {
        coffeeMaker = new CoffeeMaker();

        recipe1 = new Recipe();
        recipe1.setName("Latte");
        recipe1.setAmtCoffee("50");
        recipe1.setAmtChocolate("10");
        recipe1.setAmtMilk("20");
        recipe1.setAmtSugar("15");
        recipe1.setPrice("10");

        recipe2 = new Recipe();
        recipe2.setName("Cappuccino");
        recipe2.setAmtCoffee("40");
        recipe2.setAmtChocolate("5");
        recipe2.setAmtMilk("30");
        recipe2.setAmtSugar("10");
        recipe2.setPrice("12");

        recipe3 = new Recipe();
        recipe3.setName("Black Coffee");
        recipe3.setAmtCoffee("70");
        recipe3.setAmtChocolate("0");
        recipe3.setAmtMilk("0");
        recipe3.setAmtSugar("0");
        recipe3.setPrice("7");

        recipe4 = new Recipe();
        recipe4.setName("Espresso");
        recipe4.setAmtCoffee("35");
        recipe4.setAmtChocolate("15");
        recipe4.setAmtMilk("10");
        recipe4.setAmtSugar("8");
        recipe4.setPrice("11");
    }

    // ********************************************************************
    // ********************* First TASK ***********************************
    // ********************************************************************

    @Test
    public void CoffeeMakerConstructor(){
        String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";

        assertEquals(coffeeMaker.checkInventory(), expected);
        assertNull(coffeeMaker.getRecipes()[0]);
        assertNull(coffeeMaker.getRecipes()[1]);
        assertNull(coffeeMaker.getRecipes()[2]);
        assertNull(coffeeMaker.getRecipes()[3]);
    }

    @Test
    public void AddRecipeNormal(){
        try{
            coffeeMaker.addRecipe(recipe1);
            Recipe expected = coffeeMaker.getRecipes()[0];

            assertEquals(expected, recipe1);
        } catch (Exception e) {
            fail("Exception Thrown");
        }
    }

    @Test
    public void AddRecipeException(){
        Recipe recipe5 = null;

        Exception exception = assertThrows(NullPointerException.class, () -> {
            coffeeMaker.addRecipe(recipe5);
        });

        assertEquals(null, exception.getMessage());
    }

    @Test
    public void DeleteRecipeNormal(){
        try{
            coffeeMaker.addRecipe(recipe1);
            coffeeMaker.addRecipe(recipe2);
            coffeeMaker.addRecipe(recipe3);
            coffeeMaker.addRecipe(recipe4);

            String expected = "Cappuccino";
            assertEquals(expected, coffeeMaker.deleteRecipe(1));
        } catch (Exception e) {
            fail("Exception Thrown");
        }
    }

    @Test
    public void DeleteRecipeException(){
        try{
            coffeeMaker.addRecipe(recipe1);
            coffeeMaker.addRecipe(recipe2);
            coffeeMaker.addRecipe(recipe3);

            assertNull(coffeeMaker.deleteRecipe(3));
        } catch (Exception e) {
            fail("Exception Thrown");
        }
    }

    @Test
    public void EditRecipeNormal() throws RecipeException {
        try{
            coffeeMaker.addRecipe(recipe1);
            coffeeMaker.addRecipe(recipe2);
            coffeeMaker.addRecipe(recipe3);

            Recipe newRecipe = new Recipe();
            newRecipe.setName("Flat White");
            newRecipe.setAmtCoffee("40");
            newRecipe.setAmtChocolate("0");
            newRecipe.setAmtMilk("40");
            newRecipe.setAmtSugar("5");
            newRecipe.setPrice("9");

            String expected = "Black Coffee";
            assertEquals(expected, coffeeMaker.editRecipe(2, newRecipe));
        } catch (Exception e) {
            fail("Exception Thrown");
        }
    }

    @Test
    public void EditRecipeException() throws RecipeException {
        try{
            Recipe newRecipe = new Recipe();
            newRecipe.setName("Flat White");
            newRecipe.setAmtCoffee("40");
            newRecipe.setAmtChocolate("0");
            newRecipe.setAmtMilk("40");
            newRecipe.setAmtSugar("5");
            newRecipe.setPrice("9");

            assertNull(coffeeMaker.editRecipe(2, newRecipe));
        } catch (Exception e) {
            fail("Exception Thrown");
        }
    }

    @Test
    public void AddInventoryNormal() throws InventoryException {
        coffeeMaker.addInventory("5", "3" , "10", "0");
        String expected = "Coffee: 20\nMilk: 18\nSugar: 25\nChocolate: 15\n";
        assertEquals(expected, coffeeMaker.checkInventory());
    }

    @Test
    public void AddInventoryException() throws InventoryException {
        Exception exception = assertThrows(InventoryException.class, () -> {
            coffeeMaker.addInventory("-10", "-5" , "-2", "0");
        });

        String expected = "Units of coffee must be a positive integer";
        assertEquals(expected, exception.getMessage());
    }

    @Test
    public void CheckInventoryNormal() throws InventoryException {
        String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(expected, coffeeMaker.checkInventory());
    }

    @Test
    public void CheckInventoryException() throws InventoryException {
        CoffeeMaker coffeeMaker1 = null;


        Exception exception = assertThrows(NullPointerException.class, () -> {
            coffeeMaker1.checkInventory();
        });

        assertNull(exception.getMessage());
    }

    @Test
    public void MakeCoffeeNormal() throws InventoryException {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        coffeeMaker.addRecipe(recipe4);
        coffeeMaker.addInventory("100", "100", "0", "100");
        int expectedChange = 3;

        assertEquals(expectedChange, coffeeMaker.makeCoffee(2, 10));
    }

    @Test
    public void MakeCoffeeExceptionSubcase1() throws InventoryException {
        try{
            coffeeMaker.addRecipe(recipe1);
            coffeeMaker.addRecipe(recipe2);
            coffeeMaker.addRecipe(recipe3);
            coffeeMaker.addInventory("100", "100", "0", "100");
            int expectedChange = 10;

            assertEquals(expectedChange, coffeeMaker.makeCoffee(3, 10));
        } catch (Exception e) {
            fail("Exception Thrown");
        }
    }

    @Test
    public void MakeCoffeeExceptionSubcase2() throws InventoryException {
        try{
            coffeeMaker.addRecipe(recipe1);
            coffeeMaker.addRecipe(recipe2);
            coffeeMaker.addRecipe(recipe3);
            coffeeMaker.addRecipe(recipe4);
            int expectedChange = 15;

            assertEquals(expectedChange, coffeeMaker.makeCoffee(1, 15));
        } catch (Exception e) {
            fail("Exception Thrown");
        }
    }

    @Test
    public void MakeCoffeeExceptionSubcase3() throws InventoryException {
        try{
            coffeeMaker.addRecipe(recipe1);
            coffeeMaker.addRecipe(recipe2);
            coffeeMaker.addRecipe(recipe3);
            coffeeMaker.addRecipe(recipe4);
            int expectedChange = 10;

            assertEquals(expectedChange, coffeeMaker.makeCoffee(1, 10));
        } catch (Exception e) {
            fail("Exception Thrown");
        }
    }

    @Test
    public void GetRecipesNormal() throws InventoryException {
        try{
            coffeeMaker.addRecipe(recipe1);
            coffeeMaker.addRecipe(recipe2);
            coffeeMaker.addRecipe(recipe3);
            coffeeMaker.addRecipe(recipe4);

            assertEquals(recipe1, coffeeMaker.getRecipes()[0]);
            assertEquals(recipe2, coffeeMaker.getRecipes()[1]);
            assertEquals(recipe3, coffeeMaker.getRecipes()[2]);
            assertEquals(recipe4, coffeeMaker.getRecipes()[3]);
        } catch (Exception e) {
            fail("Exception Thrown");
        }
    }

    @Test
    public void GetRecipesException() throws InventoryException {
        coffeeMaker = null;

        Exception exception = assertThrows(NullPointerException.class, () -> {
            coffeeMaker.addRecipe(recipe1);
        });

        assertNull(exception.getMessage());
    }


    // ********************************************************************
    // ********************* SECOND TASK **********************************
    // ********************************************************************

    //This first test covers the first branch where the recipe we try to make is not null,
    // where the price of the recipe is less than or equal to the amount we're paying,
    // and where we have enough ingredients to make the recipe.
    @Test
    public void MakeCoffeeFirstBranch() throws InventoryException {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        coffeeMaker.addRecipe(recipe4);
        coffeeMaker.addInventory("40", "10", "0", "5");
        int expectedChange = 0;

        assertEquals(expectedChange, coffeeMaker.makeCoffee(0, 10));
    }

    //This second test covers the second branch where the recipe we try to make is not null,
    // where the price of the recipe is less than or equal to the amount we're paying,
    // however, we do not have enough ingredients hence why our payment is returned.
    @Test
    public void MakeCoffeeSecondBranch() throws InventoryException {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        coffeeMaker.addRecipe(recipe4);
        coffeeMaker.addInventory("20", "15", "0", "5");
        int expectedChange = 14;

        assertEquals(expectedChange, coffeeMaker.makeCoffee(1, 14));
    }

    //This third test covers the third branch where the recipe we try to make is not null,
    // where we have enough ingredients for the recipe, however, we pay less than the price
    // of the recipe, hence why our payment is again returned.
    @Test
    public void MakeCoffeeThirdBranch() throws InventoryException {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        coffeeMaker.addRecipe(recipe4);
        coffeeMaker.addInventory("30", "30", "0", "20");
        int expectedChange = 9;

        assertEquals(expectedChange, coffeeMaker.makeCoffee(3, 9));
    }

    //This final test covers the final branch where the recipe we try to make is simply null and our payment
    // is returned.
    @Test
    public void MakeCoffeeFourthBranch() throws InventoryException {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);

        coffeeMaker.addInventory("30", "30", "0", "20");
        int expectedChange = 15;

        assertEquals(expectedChange, coffeeMaker.makeCoffee(3, 15));
    }

}
