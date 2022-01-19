package com.item;

public class Item {
    private String itemName;
    private int itemPrice;

    public Item(String name, int price){
        this.itemName = name;
        this.itemPrice = price;
    }

    public String getItemName(){
        return this.itemName;
    }

    public int getItemPrice(){
        return this.itemPrice;
    }
}
