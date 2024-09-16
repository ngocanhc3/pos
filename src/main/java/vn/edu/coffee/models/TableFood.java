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
public class TableFood {

    private long id;
    private String name;
    private boolean status;
    private long idBill;

    public TableFood() {
    }

    public TableFood(long id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
    
    public TableFood(String name) {
        this.name = name;
        this.status = true;
    }

    public TableFood(ResultSet result) throws Exception {
        this(
                result.getLong("id"),
                result.getString("name"),
                result.getBoolean("status")
        );
        setIdBill( result.getLong("idBill"));
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getIdBill() {
        return idBill;
    }

    public void setIdBill(long idBill) {
        this.idBill = idBill;
    }
}
