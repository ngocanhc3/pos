/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.models;

import java.sql.ResultSet;

/**
 *
 * @author Ngoc Anh
 */
public class OrderDetail {

    private long billId;
    private long itemId;
    private float price;
    private int amount;
    private String name;

    public OrderDetail() {
        price = 0;
        amount = 0;
    }

    public OrderDetail(ResultSet result) throws Exception {
        billId = result.getLong("billId");
        itemId = result.getLong("itemId");
        price = result.getFloat("price");
        amount = result.getInt("amount");
    }
    
    public OrderDetail(long billId, MenuItem item, int amout) {
        this.billId = billId;
        this.itemId = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.amount = amout;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return amount * price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
