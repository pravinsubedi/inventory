/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncit.InventoryManagement.beans;

/**
 *
 * @author pravin
 */
public class Inventory {
        private int id;
    private String item;
    private String type;
    private String brand;
    private int price;

    public Inventory() {
    }
    

    public Inventory(int id, String item, String type, String brand, int price) {
        this.id = id;
        this.item = item;
        this.type = type;
        this.brand = brand;
        this.price = price;
    }
    

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
        @Override
    public String toString() {
        return "Invemtory{" + "id=" + id + ", item=" + item + ", type=" + type + ", brand=" + brand + ", price=" + price + '}';
    }
    public String toCSV(){
        return id+ "," +item+ "," +type+ "," +brand+ "," +price;
    }

    
}
