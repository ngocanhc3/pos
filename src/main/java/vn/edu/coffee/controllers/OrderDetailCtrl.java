/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.controllers;

import java.util.List;
import vn.edu.coffee.models.OrderDetail;

/**
 *
 * @author Ngoc Anh
 */
public class OrderDetailCtrl extends BaseController implements IController<OrderDetail, Long> {

    public OrderDetailCtrl() {
        super();
    }

    @Override
    public boolean add(OrderDetail item) {
        return this.getDb().getOrders().add(item);
    }

    @Override
    public boolean update(Long id, OrderDetail item) {
        return this.getDb().getOrders().update(id, item);
    }

    @Override
    public boolean remove(Long id) {
        return this.getDb().getOrders().remove(id);
    }

    @Override
    public OrderDetail findById(Long id) {
//        return this.getDb().getOrders().findById(id);
        return null;
    }

    @Override
    public List<OrderDetail> all() {
        return this.getDb().getOrders().all();
    }

    public List<OrderDetail> findByBillId(long id) {
        return this.getDb().getOrders().findByBillId(id);
    }

}
