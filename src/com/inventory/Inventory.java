package com.inventory;

import com.item.Item;

public interface Inventory {
    public void addItem(Item item, int count);
    public boolean isAvailable(String itemName);
    public void decrementItemCount(String itemName);
    public int getItemPrice(String selectedItemName);
    public void showAllItemDetails();
}
