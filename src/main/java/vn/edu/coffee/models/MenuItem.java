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
public class MenuItem {

    private long id;
    private String name;
    private float price;
    private boolean status;

    public MenuItem() {
    }

    public MenuItem(long id, String name, float price, boolean status) {
        this(name, price, status);
        this.id = id;
    }

    public MenuItem(String name, float price, boolean status) {
        this.name = name;
        this.price = price;
        this.status = status;
    }
    
    public MenuItem(String name, float price) {
        this(name, price, true);
    }

    public MenuItem(ResultSet result) throws Exception {
        this(
                result.getLong("id"),
                result.getString("name"),
                result.getFloat("price"),
                result.getBoolean("status")
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
