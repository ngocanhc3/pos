/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.models;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author Ngoc Anh
 */
public class Bill {

    private long id;
    private float total;
    private int amount;
    private String note;
    private LocalDateTime checkinAt;
    private LocalDateTime checkoutAt;

    public Bill() {
        amount = 0;
        total = 0;
        checkinAt = LocalDateTime.now();
    }

    public Bill(ResultSet result) throws Exception {
        id = result.getLong("id");
        amount = result.getInt("amount");
        total = result.getFloat("total");
        Timestamp checkin = result.getTimestamp("checkinAt");
        if (checkin != null) 
            checkinAt = checkin.toLocalDateTime();
        
        Timestamp checkout = result.getTimestamp("checkoutAt");
        if (checkout != null) 
            checkinAt = checkout.toLocalDateTime();
        note = result.getString("note");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getCheckinAt() {
        return checkinAt;
    }

    public void setCheckinAt(LocalDateTime checkinAt) {
        this.checkinAt = checkinAt;
    }

    public LocalDateTime getCheckoutAt() {
        return checkoutAt;
    }

    public void setCheckoutAt(LocalDateTime checkoutAt) {
        this.checkoutAt = checkoutAt;
    }

}
