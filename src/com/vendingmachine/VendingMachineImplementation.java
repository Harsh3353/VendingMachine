package com.vendingmachine;

import com.inventory.Inventory;
import com.inventory.InventoryImplementation;
import com.item.Item;
import java.util.*;

public class VendingMachineImplementation implements VendingMachine{

    private Item itemSelected;
    private Integer cashInserted;
    private Inventory inventory;

    public VendingMachineImplementation(Inventory inventory){
        this.inventory = inventory;
        this.cashInserted = 0;
        this.itemSelected = null;
    }

    @Override
    public void showAllItemDetails() {
        this.inventory.showAllItemDetails();
    }

    @Override
    public void addItemToInventory(Item item) {
        this.inventory.addItem(item, 1);
    }

    @Override
    public void insertCash(int cash) {
        if((int)(this.cashInserted) == 0){
            this.cashInserted =  cash;
        } else{
            this.cashInserted = this.cashInserted + cash;
        }
    }

    @Override
    public void selectItem(String itemName) {
        if(this.inventory.isAvailable(itemName)){
            this.itemSelected = new Item(itemName, this.inventory.getItemPrice(itemName));
            System.out.println(String.format("The item selected is : %s", itemName));
        } else{
            System.out.println(String.format("The item %s, does not exist in inventory", itemName));
        }
    }

    @Override
    public int isChangeMatched() {
        int cashRequired = this.itemSelected.getItemPrice();
        if(cashRequired <= this.cashInserted){
            return 0;
        } else{
            if(cashRequired>this.cashInserted){
                System.out.println(String.format("Please insert %d more for the item to dispense from the machine", cashRequired-this.cashInserted));
            }
            return 1;
        }
    }

    @Override
    public void dispenseItemAndChange(){
        if(this.isChangeMatched() == 0){
            System.out.println(String.format("The requested item : %s is dispatched. Please collect %d change.", this.itemSelected.getItemName(), this.cashInserted - this.itemSelected.getItemPrice()));

            this.inventory.decrementItemCount(this.itemSelected.getItemName());
            this.itemSelected = null;
            this.cashInserted = null;
        }
    }


    @Override
    public void cancelTransaction() {
        if(this.cashInserted>0){
            System.out.println(String.format("Please take back the inserted cash : %d", this.cashInserted));
        }
        this.itemSelected = null;
        this.cashInserted = 0;
    }
}
