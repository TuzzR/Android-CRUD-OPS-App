package com.example.mysupermarket;

public class SupermarketModel{

    private String itemName;
    private String itemPrice;
    private String itemQuantity;
    private String itemCat;
    private int id;

    // creating getter and setter methods
    public String getitemName() {
        return itemName;
    }

    public void setitemName(String itemName) {
        this.itemName = itemName;
    }

    public String getitemPrice() {
        return itemPrice;
    }

    public void setitemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getitemQuantity() {
        return itemQuantity;
    }

    public void setitemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getitemCat() {
        return itemCat;
    }

    public void setitemCat(String itemCat) {
        this.itemCat = itemCat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public SupermarketModel(String itemName, String itemPrice, String itemQuantity, String itemCat) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemCat = itemCat;
    }
}

