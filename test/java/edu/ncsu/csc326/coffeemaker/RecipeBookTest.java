package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

public class RecipeBookTest {

  private RecipeBook recipeBook;
  private Recipe firstRecipe;
  private Recipe secondRecipe;
  private Recipe thirdRecipe;
  private Recipe fourthRecipe;
  private Recipe fifthRecipe;

  // ********************************************************************
  // ********************* FIRST TASK **********************************
  // ********************************************************************

  @Before
  public void setUp() throws RecipeException {

    firstRecipe = new Recipe();
    firstRecipe.setName("Caramel Macchiato");
    firstRecipe.setPrice("5");
    firstRecipe.setAmtCoffee("2");
    firstRecipe.setAmtMilk("4");
    firstRecipe.setAmtSugar("2");
    firstRecipe.setAmtChocolate("0");

    secondRecipe = new Recipe();
    secondRecipe.setName("Latte");
    secondRecipe.setPrice("4");
    secondRecipe.setAmtCoffee("3");
    secondRecipe.setAmtMilk("3");
    secondRecipe.setAmtSugar("2");
    secondRecipe.setAmtChocolate("0");

    thirdRecipe = new Recipe();
    thirdRecipe.setName("Mocha");
    thirdRecipe.setPrice("6");
    thirdRecipe.setAmtCoffee("2");
    thirdRecipe.setAmtMilk("3");
    thirdRecipe.setAmtSugar("2");
    thirdRecipe.setAmtChocolate("2");

    fourthRecipe = new Recipe();
    fourthRecipe.setName("Americano");
    fourthRecipe.setPrice("3");
    fourthRecipe.setAmtCoffee("4");
    fourthRecipe.setAmtMilk("0");
    fourthRecipe.setAmtSugar("0");
    fourthRecipe.setAmtChocolate("0");

    fifthRecipe = new Recipe();
    fifthRecipe.setName("Cappuccino");
    fifthRecipe.setPrice("5");
    fifthRecipe.setAmtCoffee("2");
    fifthRecipe.setAmtMilk("4");
    fifthRecipe.setAmtSugar("1");
    fifthRecipe.setAmtChocolate("2");
  }

  @Test
  public void testConstructor() {
    recipeBook = new RecipeBook();
  }

  @Test
  public void testGetRecipesNormal() {
    recipeBook = new RecipeBook();
    Recipe[] recipes = {null, null, null, null};
    assertArrayEquals(recipes, recipeBook.getRecipes());
    System.out.println(Arrays.toString(recipeBook.getRecipes()));
  }

  @Test
  public void testAddRecipeNormal() {
    recipeBook = new RecipeBook();
    assertTrue(recipeBook.addRecipe(firstRecipe));
    assertTrue(recipeBook.addRecipe(secondRecipe));
    assertTrue(recipeBook.addRecipe(thirdRecipe));
    assertTrue(recipeBook.addRecipe(fourthRecipe));
    System.out.println(Arrays.toString(recipeBook.getRecipes()));
  }

  @Test
  public void testAddRecipeException() {
    recipeBook = new RecipeBook();

    //Adding two same recipes into the book
    assertTrue(recipeBook.addRecipe(firstRecipe));
    assertFalse(recipeBook.addRecipe(firstRecipe));

    //Adding a null recipe
    Exception exception = assertThrows(NullPointerException.class, () -> {
      recipeBook.addRecipe(null);
    });
    System.out.println(exception);
    //assertFalse(recipeBook.addRecipe(null));

    //Adding more than four recipes into the book
    assertTrue(recipeBook.addRecipe(secondRecipe));
    assertTrue(recipeBook.addRecipe(thirdRecipe));
    assertTrue(recipeBook.addRecipe(fourthRecipe));
    assertFalse(recipeBook.addRecipe(fifthRecipe));

    System.out.println(Arrays.toString(recipeBook.getRecipes()));

  }

  @Test
  public void testDeleteRecipeNormal() {
    recipeBook = new RecipeBook();

    assertTrue(recipeBook.addRecipe(firstRecipe));
    assertTrue(recipeBook.addRecipe(secondRecipe));
    System.out.println(Arrays.toString(recipeBook.getRecipes()));

    assertEquals(firstRecipe.getName(), recipeBook.deleteRecipe(0));

    System.out.println(Arrays.toString(recipeBook.getRecipes()));
  }

  @Test
  public void testDeleteRecipeException() {
    recipeBook = new RecipeBook();

    //Trying to delete a recipe from an empty recipe book
    assertNull(recipeBook.deleteRecipe(0));
    System.out.println(Arrays.toString(recipeBook.getRecipes()));

    recipeBook.addRecipe(firstRecipe);
    recipeBook.addRecipe(secondRecipe);

    System.out.println(Arrays.toString(recipeBook.getRecipes()));

    //Trying to delete a recipe that has already been deleted
    assertEquals(firstRecipe.getName(), recipeBook.deleteRecipe(0));
    assertNull(recipeBook.deleteRecipe(0));

    //Trying to add a recipe after it has been deleted
    assertTrue(recipeBook.addRecipe(fifthRecipe));
    assertTrue(recipeBook.addRecipe(fourthRecipe));
    assertTrue(recipeBook.addRecipe(thirdRecipe));

    System.out.println(Arrays.toString(recipeBook.getRecipes()));
  }

  @Test
  public void testEditRecipeNormal() {
    recipeBook = new RecipeBook();

    recipeBook.addRecipe(firstRecipe);

    System.out.println(Arrays.toString(recipeBook.getRecipes()));

    assertEquals(firstRecipe.getName(), recipeBook.editRecipe(0, secondRecipe));
    assertEquals(secondRecipe.getName(), recipeBook.getRecipes()[0].getName());

    System.out.println(Arrays.toString(recipeBook.getRecipes()));
  }

  @Test
  public void testEditRecipeException() {
    recipeBook = new RecipeBook();

    //Editing a recipe that is null
    System.out.println(Arrays.toString(recipeBook.getRecipes()));
    assertNull(recipeBook.editRecipe(0, firstRecipe));

    recipeBook.addRecipe(firstRecipe);
    recipeBook.addRecipe(secondRecipe);

    System.out.println(Arrays.toString(recipeBook.getRecipes()));

    Exception exception = assertThrows(NullPointerException.class, () -> {
      recipeBook.editRecipe(0, null);
    });
    System.out.println(exception);
  }

  // ********************************************************************
  // ********************* SECOND TASK **********************************
  // ********************************************************************

  //First Condition: true/false - Second Condition: false - Third Condition: true - Forth Condition: true/false - Fifth Condition: true
  @Test
  public void addRecipeFirstBranch(){
    recipeBook = new RecipeBook();
    assertTrue(recipeBook.addRecipe(firstRecipe));
    System.out.println(Arrays.toString(recipeBook.getRecipes()));
  }

  //First Condition: true/false - Second Condition: true - Third Condition: false
  @Test
  public void addRecipeSecondBranch(){
    recipeBook = new RecipeBook();
    recipeBook.addRecipe(firstRecipe);
    assertFalse(recipeBook.addRecipe(firstRecipe));
    System.out.println(Arrays.toString(recipeBook.getRecipes()));
  }

  //First Condition: true/false - Second Condition: false - Third Condition: true - Forth Condition: true/false - Fifth Condition: false
  @Test
  public void addRecipeThirdBranch(){
    recipeBook = new RecipeBook();

    recipeBook.addRecipe(firstRecipe);
    recipeBook.addRecipe(secondRecipe);
    recipeBook.addRecipe(thirdRecipe);
    recipeBook.addRecipe(fourthRecipe);

    assertFalse(recipeBook.addRecipe(fifthRecipe));
    System.out.println(Arrays.toString(recipeBook.getRecipes()));
  }

}

