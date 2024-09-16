/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.controllers;

import java.util.List;
import vn.edu.coffee.models.Bill;

/**
 *
 * @author Ngoc Anh
 */
public class BillCtrl extends BaseController implements IController<Bill, Long> {

    @Override
    public boolean add(Bill item) {
        return this.getDb().getBills().add(item);
    }

    @Override
    public boolean update(Long id, Bill item) {
        return this.getDb().getBills().update(id, item);
    }

    @Override
    public boolean remove(Long id) {
        return this.getDb().getBills().remove(id);
    }

    @Override
    public List<Bill> all() {
        return this.getDb().getBills().all();
    }

    @Override
    public Bill findById(Long id) {
        return this.getDb().getBills().findById(id);
    }

    public long checkin(long tableId, Bill item) {
        return this.getDb().getBills().checkin(tableId, item);
    }

    public boolean checkout(final long tableId, final long billId) {
        return this.getDb().getBills().checkout(tableId, billId);
    }
    
     public List<Object[]> orderReport(String whereClause) {
         return this.getDb().getBills().orderReport(whereClause);
     }
}
