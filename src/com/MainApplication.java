package com;

import com.inventory.InventoryImplementation;
import com.inventory.Inventory;
import com.item.Item;
import com.vendingmachine.VendingMachineImplementation;
import com.vendingmachine.VendingMachine;

public class MainApplication {
    public static void main(String[] args){

        //Initialize the inventory
        Inventory inventory = new InventoryImplementation();

        Item coke = new Item("Coke", 45);
        Item popcorns = new Item("Popcorns", 35);
        Item pepsi = new Item("Pepsi", 20);
        Item biscuits = new Item("GoodDay", 20);

        //Adding Items to the inventory
        inventory.addItem(coke, 10);
        inventory.addItem(pepsi, 20);
        inventory.addItem(popcorns, 15);
        inventory.addItem(biscuits, 20);

        //Initialize the Vending Machine
        VendingMachine machine = new VendingMachineImplementation(inventory);

        machine.showAllItemDetails();

        //Simulating the Vending Machine Functions
        machine.insertCash(5);
        machine.selectItem("Pepsi");
        machine.dispenseItemAndChange();
        machine.insertCash(5);
        machine.dispenseItemAndChange();
        machine.insertCash(10);
        machine.dispenseItemAndChange();

        machine.showAllItemDetails();
    }
}
