package softuni.OOP.oop_exam_prep.JavaOOPExam12Dec2020.BankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankVaultTest {

    private BankVault bankVault;

    @Before
    public void setUp() {
        bankVault = new BankVault();
    }

    @Test
    public void testGetVaultCellsShouldReturnCells() {
        Map<String, Item> expectedMap = new LinkedHashMap<>();
        expectedMap.put("A1", null);
        expectedMap.put("A2", null);
        expectedMap.put("A3", null);
        expectedMap.put("A4", null);
        expectedMap.put("B1", null);
        expectedMap.put("B2", null);
        expectedMap.put("B3", null);
        expectedMap.put("B4", null);
        expectedMap.put("C1", null);
        expectedMap.put("C2", null);
        expectedMap.put("C3", null);
        expectedMap.put("C4", null);
        Map<String, Item> actualMap = bankVault.getVaultCells();
        Assert.assertEquals(expectedMap, actualMap);

    }

    //AddItem tests
    //OK
    @Test(expected = IllegalArgumentException.class)
    public void testAddItemInNonExistingCellShouldThrowEx() throws OperationNotSupportedException {

        Item item = new Item("Peter", "1");
        this.bankVault.addItem("C5", item);
    }

    //OK
    @Test(expected = IllegalArgumentException.class)
    public void testAddItemInNonEmptyCellShouldThrowEx() throws OperationNotSupportedException {

        Item itemPeter = new Item("Peter", "1");
        Item itemJohn = new Item("John", "2");
        this.bankVault.addItem("C4", itemPeter);
        this.bankVault.addItem("C4", itemJohn);
    }

    //OK
    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemThatAlreadyExistShouldThrowEx() throws OperationNotSupportedException {

        Item itemPeter = new Item("Peter", "1");

        bankVault.addItem("C3", itemPeter);
        bankVault.addItem("C4", itemPeter);
    }

    //OK
    @Test
    public void testAddItemShouldAddItemIntoVault() throws OperationNotSupportedException {

        Item itemPeter = new Item("Peter", "1");

        String expected = "Item:1 saved successfully!";
        String actual = this.bankVault.addItem("C4", itemPeter);

        Assert.assertEquals(expected, actual);
    }

    //RemoveItem tests
    //OK
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldThrowExIfSuchCellDoesNotExists() throws OperationNotSupportedException {

        Item itemPeter = new Item("Peter", "1");
        this.bankVault.addItem("C1", itemPeter);
        this.bankVault.removeItem("C24", itemPeter);
    }

    //OK
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldThrowExIfTheItemInTheCellIsDifferent() throws OperationNotSupportedException {

        Item itemDavid = new Item("David", "4");
        Item itemSheldon = new Item("Sheldon", "5");
        bankVault.addItem("A3", itemDavid);
        bankVault.removeItem("A3", itemSheldon);
    }

    @Test
    public void testRemoveItemShouldRemoveItAndSetTheItemToNull() throws OperationNotSupportedException {

        Item itemDavid = new Item("David", "4");
        bankVault.addItem("A3", itemDavid);
        String actual = bankVault.removeItem("A3", itemDavid);
        String expected = "Remove item:4 successfully!";
        Assert.assertEquals(expected, actual);
        Assert.assertNull(bankVault.getVaultCells().get("A3"));
    }
}