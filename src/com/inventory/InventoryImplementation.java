package com.inventory;

import com.item.Item;
import java.util.*;

public class InventoryImplementation implements Inventory {
    private Map<String,Integer> inventoryPriceMap;
    private Map<String,Integer> inventoryItemCount;

    public InventoryImplementation(){
        this.inventoryItemCount = new HashMap<>();
        this.inventoryPriceMap = new HashMap<>();
    }
    @Override
    public void addItem(Item item, int count) {
        this.inventoryPriceMap.put(item.getItemName(), item.getItemPrice());
        this.inventoryItemCount.put(item.getItemName(), this.inventoryItemCount.getOrDefault(item.getItemName(), 0)+count);
    }

    @Override
    public void showAllItemDetails(){
        for(Map.Entry<String, Integer> item : this.inventoryPriceMap.entrySet()){
            System.out.println(String.format("The item name is %s with price %d and having quantity %d.", item.getKey(), item.getValue(), this.inventoryItemCount.get((item.getKey()))));
        }
    }

    @Override
    public boolean isAvailable(String itemName) {
        if(this.inventoryPriceMap.containsKey(itemName) && this.inventoryItemCount.get(itemName)>0){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void decrementItemCount(String itemName) throws NullPointerException{
        this.inventoryItemCount.put(itemName, this.inventoryItemCount.get(itemName)-1);
    }

    @Override
    public int getItemPrice(String selectedItemName) throws NullPointerException{
        return this.inventoryPriceMap.get(selectedItemName);
    }
}
