package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class InventoryTest {

  private Inventory inventory;
  private Recipe shortRecipe;
  private Recipe longRecipe;
  private Recipe nullRecipe;
  private InventoryException inventoryException;

  // ********************************************************************
  // ********************* FIRST TASK **********************************
  // ********************************************************************

  @Before
  public void setUp() throws Exception {

    shortRecipe = new Recipe();
    longRecipe = new Recipe();
    nullRecipe = new Recipe();

    shortRecipe.setAmtChocolate("5");
    shortRecipe.setAmtCoffee("5");
    shortRecipe.setAmtMilk("5");
    shortRecipe.setAmtSugar("5");

    longRecipe.setAmtChocolate("20");
    longRecipe.setAmtCoffee("20");
    longRecipe.setAmtMilk("20");
    longRecipe.setAmtSugar("20");

    nullRecipe = null;


  }

  //--------------CHOCOLATE-----------------------------------//
  @Test
  public void testConstructor() {
    inventory = new Inventory();

    assertEquals(15, inventory.getChocolate());
    assertEquals(15, inventory.getCoffee());
    assertEquals(15, inventory.getMilk());
    assertEquals(15, inventory.getSugar());

    System.out.println(inventory.toString());
  }

  @Test
  public void testGetChocolateNormal() {
    inventory = new Inventory();
    assertEquals(15, inventory.getChocolate());
  }

  @Test
  public void testSetChocolateNormal() {
    inventory = new Inventory();
    try {
      inventory.setChocolate(5);
      assertEquals(5, inventory.getChocolate());
      System.out.println("Inventory chocolate set to: " + 5);
    } catch (Exception e) {
      fail("Exception thrown");
    }
  }

  @Test
  public void testSetChocolateException() {
    inventory = new Inventory();

    Exception exception = assertThrows(InventoryException.class, () -> {
      inventory.setChocolate(-5);
    });

    System.out.println(exception.getMessage());
  }

  @Test
  public void testAddChocolateNormal() throws Exception {
    try {
      inventory = new Inventory();

      inventory.addChocolate("5");

      assertEquals(20, inventory.getChocolate());

    } catch (Exception e) {
      fail("Exception thrown");
    }
  }

  @Test
  public void testAddChocolateException() {
    inventory = new Inventory();

    Exception firstException = assertThrows(InventoryException.class, () -> {
      inventory.addChocolate("number");
    });
    Exception secondException = assertThrows(InventoryException.class, () -> {
      inventory.addChocolate("-5");
    });

    System.out.println(firstException.getMessage());
    System.out.println(secondException.getMessage());
  }

  //--------------COFFEE-----------------------------------//

  @Test
  public void testGetCoffeeNormal() {
    Inventory inventory = new Inventory();
    assertEquals(15, inventory.getCoffee());
  }

  @Test
  public void testSetCoffeeNormal() {
    inventory = new Inventory();
    try {
      inventory.setCoffee(5);
      assertEquals(5, inventory.getCoffee());
      System.out.println("Inventory coffee set to: " + 5);
    } catch (Exception e) {
      fail("Exception thrown");
    }
  }

  @Test
  public void testSetCoffeeException() {
    inventory = new Inventory();

    Exception exception = assertThrows(InventoryException.class, () -> {
      inventory.setCoffee(-5);
    });

    System.out.println(exception.getMessage());
  }

  @Test
  public void testAddCoffeeNormal() throws Exception {
    try {
      inventory = new Inventory();

      inventory.addCoffee("5");

      assertEquals(20, inventory.getCoffee());

    } catch (Exception e) {
      fail("Exception thrown");
    }
  }

  @Test
  public void testAddCoffeeException() {
    inventory = new Inventory();

    Exception firstException = assertThrows(InventoryException.class, () -> {
      inventory.addCoffee("number");
    });
    Exception secondException = assertThrows(InventoryException.class, () -> {
      inventory.addCoffee("-5");
    });

    System.out.println(firstException.getMessage());
    System.out.println(secondException.getMessage());
  }

  //--------------MILK-----------------------------------//

  @Test
  public void testGetMilkNormal() {
    inventory = new Inventory();
    assertEquals(15, inventory.getMilk());
  }

  @Test
  public void testSetMilkNormal() {
    inventory = new Inventory();
    try {
      inventory.setMilk(5);
      assertEquals(5, inventory.getMilk());
      System.out.println("Inventory milk set to: " + 5);
    } catch (Exception e) {
      fail("Exception thrown");
    }
  }

  @Test
  public void testSetMilkException() {
    inventory = new Inventory();

    Exception exception = assertThrows(InventoryException.class, () -> {
      inventory.setMilk(-5);
    });

    System.out.println(exception.getMessage());
  }

  @Test
  public void testAddMilkNormal() throws Exception {
    try {
      inventory = new Inventory();

      inventory.addMilk("5");

      assertEquals(20, inventory.getMilk());

    } catch (Exception e) {
      fail("Exception thrown");
    }
  }

  @Test
  public void testAddMilkException() {
    inventory = new Inventory();

    Exception firstException = assertThrows(InventoryException.class, () -> {
      inventory.addMilk("number");
    });
    Exception secondException = assertThrows(InventoryException.class, () -> {
      inventory.addMilk("-5");
    });

    System.out.println(firstException.getMessage());
    System.out.println(secondException.getMessage());
  }

  //--------------SUGAR-----------------------------------//

  @Test
  public void testGetSugarNormal() {
    inventory = new Inventory();
    assertEquals(15, inventory.getSugar());
  }

  @Test
  public void testSetSugarNormal() {
    inventory = new Inventory();
    try {
      inventory.setSugar(5);
      assertEquals(5, inventory.getSugar());
      System.out.println("Inventory milk set to: " + 5);
    } catch (Exception e) {
      fail("Exception thrown");
    }
  }

  @Test
  public void testSetSugarException() {
    inventory = new Inventory();

    Exception exception = assertThrows(InventoryException.class, () -> {
      inventory.setSugar(-5);
    });

    System.out.println(exception.getMessage());
  }

  @Test
  public void testAddSugarNormal() {
    try {
      inventory = new Inventory();

      inventory.addSugar("5");

      assertEquals(20, inventory.getSugar());

    } catch (Exception e) {
      fail("Exception thrown");
    }
  }

  @Test
  public void testAddSugarException() {
    inventory = new Inventory();

    Exception firstException = assertThrows(InventoryException.class, () -> {
      inventory.addSugar("number");
    });
    Exception secondException = assertThrows(InventoryException.class, () -> {
      inventory.addSugar("-5");
    });

    System.out.println(firstException.getMessage());
    System.out.println(secondException.getMessage());
  }

  //--------------INGREDIENTS-----------------------------------//

  @Test
  public void testEnoughIngredientsNormal() {
    inventory = new Inventory();
    assertTrue(inventory.enoughIngredients(shortRecipe));
    assertFalse(inventory.enoughIngredients(longRecipe));
  }

  @Test
  public void testEnoughIngredientsException() {
    inventory = new Inventory();
    NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> {
      inventory.enoughIngredients(nullRecipe);
    });

    System.out.println(nullPointerException.getMessage());
  }

  @Test
  public void testUseIngredientsNormal() {
    inventory = new Inventory();

    try {
      inventory.useIngredients(shortRecipe);

      assertEquals(15, inventory.getCoffee());
      assertEquals(15, inventory.getMilk());
      assertEquals(15, inventory.getSugar());
      assertEquals(15, inventory.getChocolate());

    } catch (Exception e) {
      fail("Exception thrown");
    }
  }

  @Test
  public void testUseIngredientsException() throws Exception {

    //Case insufficient inventory: not enough ingredients
    Inventory insufficientInventory = new Inventory();

    insufficientInventory.setChocolate(15);
    insufficientInventory.setCoffee(15);
    insufficientInventory.setMilk(15);
    insufficientInventory.setSugar(15);

    Exception insufficientInventoryException = assertThrows(InventoryException.class, () -> {
      insufficientInventory.useIngredients(longRecipe);
    });

    System.out.println(insufficientInventoryException.getMessage());

    //Case empty inventory: no ingredients
    Inventory emptyInventory = new Inventory();

    insufficientInventory.setChocolate(0);
    insufficientInventory.setCoffee(0);
    insufficientInventory.setMilk(0);
    insufficientInventory.setSugar(0);

    Exception emptyInventoryException = assertThrows(InventoryException.class, () -> {
      insufficientInventory.useIngredients(longRecipe);
    });

    System.out.println(emptyInventoryException.getMessage());

    //Case Invalid recipe: null recipe
    inventory = new Inventory();

    NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> {
      inventory.useIngredients(nullRecipe);
    });

    System.out.println(nullPointerException.getMessage());
  }

  //To string
  @Test
  public void testToStringNormal() {
    inventory = new Inventory();
    String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
    assertEquals(expected, inventory.toString());
    System.out.println(inventory.toString());
  }

  @Test
  public void testToStringException() {
    inventory = null;
    NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> {
      inventory.toString();
    });

    System.out.println(nullPointerException.getMessage());
  }

  // ********************************************************************
  // ********************* SECOND TASK **********************************
  // ********************************************************************

  //First Condition: False
  @Test
  public void testAddSugarFirstBranch() {
    try {
      inventory = new Inventory();

      //First Condition: false - Number format exception
      InventoryException inventoryException = assertThrows(InventoryException.class, () -> {
        inventory.addSugar("Number");
      });
      System.out.println(inventoryException.toString());

    } catch (Exception e) {
      fail("Exception thrown");
    }
  }

  //First Condition: true - SecondCondition: True
  @Test
  public void testAddSugarSecondBranch() {
    try {
      inventory = new Inventory();

      InventoryException inventoryException1 = assertThrows(InventoryException.class, () -> {
        inventory.addSugar("-5");
      });
      System.out.println(inventoryException1.toString());

    } catch (Exception e) {
      fail("Exception thrown");
    }
  }

  //First Condition: true - SecondCondition: False
  @Test
  public void testAddSugarThirdBranch() {
    try {
      inventory = new Inventory();
      inventory.addSugar("5");
      assertEquals(20, inventory.getSugar());

    } catch (Exception e) {
      fail("Exception thrown");
    }
  }


}
