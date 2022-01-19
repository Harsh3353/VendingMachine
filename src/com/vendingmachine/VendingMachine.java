package com.vendingmachine;

import com.item.Item;

public interface VendingMachine {
    public void showAllItemDetails();
    public void addItemToInventory(Item item);
    public void insertCash(int cash);
    public void selectItem(String iteName);
    public int isChangeMatched();
    public void dispenseItemAndChange();
    public void cancelTransaction();
}
