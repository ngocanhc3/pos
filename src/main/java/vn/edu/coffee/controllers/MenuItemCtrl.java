/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.controllers;

import java.util.List;
import vn.edu.coffee.models.MenuItem;

/**
 *
 * @author Ngoc Anh
 */
public class MenuItemCtrl extends BaseController implements IController<MenuItem, Long> {

    public MenuItemCtrl() {
        super();
    }
   
    @Override
    public boolean add(MenuItem item) {
        return this.getDb().getMenuItems().add(item);
    }

    @Override
    public boolean update(Long id, MenuItem item) {
        return this.getDb().getMenuItems().update(id, item);
    }

    @Override
    public boolean remove(Long id) {
        return this.getDb().getMenuItems().remove(id);
    }

    @Override
    public MenuItem findById(Long id) {
        return this.getDb().getMenuItems().findById(id);
    }

    @Override
    public List<MenuItem> all() {
        return this.getDb().getMenuItems().all();
    }
    
    public List<MenuItem> find(String name) {
        if (name != null && !name.isEmpty())
            return this.getDb().getMenuItems().find(String.format(" LOWER(name) LIKE '%%%s%%'", name.toLowerCase()));
        return all();
    }
}
