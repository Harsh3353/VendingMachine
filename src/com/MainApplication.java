package com;

import com.inventory.InventoryImplementation;
import com.inventory.Inventory;
import com.item.Item;
import com.vendingmachine.VendingMachineImplementation;
import com.vendingmachine.VendingMachine;
import java.util.Scanner;

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

        //Simulating the Vending Machine Functions
        Scanner inp = new Scanner(System.in);
        showMenu();
        int choice = inp.nextInt();
        while(choice!=6) {
            switch (choice) {
                case 1: {
                    machine.showAllItemDetails();
                    break;
                }

                case 2: {
                    System.out.println("Enter the item name for selection:");
                    String itemName = inp.next();
                    machine.selectItem(itemName);
                    break;
                }
                case 3: {
                    System.out.println("Enter the cash amount:");
                    int cashAmount = inp.nextInt();
                    machine.insertCash(cashAmount);
                    break;
                }
                case 4: {
                    machine.dispenseItemAndChange();
                    break;
                }

                case 5: {
                    machine.cancelTransaction();
                    break;
                }
                case 6:
                    break;
            }

            showMenu();
            choice = inp.nextInt();
        }

    }

    public static void showMenu(){
        System.out.println("\nEnter any choice from below for the Vending Machine Operations");
        System.out.println("1. Display All Items with Count");
        System.out.println("2. Select Item");
        System.out.println("3. Insert Cash");
        System.out.println("4. Dispense Item and Change");
        System.out.println("5. Cancel Transaction");
        System.out.println("6. Exit");
    }
}
