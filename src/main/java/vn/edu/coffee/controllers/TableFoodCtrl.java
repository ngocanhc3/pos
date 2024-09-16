/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.controllers;

import java.util.List;
import vn.edu.coffee.models.TableFood;

/**
 *
 * @author Ngoc Anh
 */
public class TableFoodCtrl extends BaseController implements IController<TableFood, Long> {

    static TableFoodCtrl instance;

    public static TableFoodCtrl getInstance() {
        if (instance == null) {
            instance = new TableFoodCtrl();
        }
        
        return instance;
    }
    
    public TableFoodCtrl() {
        super();
    }
   
    @Override
    public boolean add(TableFood item) {
        return this.getDb().getTableFoods().add(item);
    }

    @Override
    public boolean update(Long id, TableFood item) {
        return this.getDb().getTableFoods().update(id, item);
    }

    @Override
    public boolean remove(Long id) {
        return this.getDb().getTableFoods().remove(id);
    }

    @Override
    public TableFood findById(Long id) {
        return this.getDb().getTableFoods().findById(id);
    }

    @Override
    public List<TableFood> all() {
        return this.getDb().getTableFoods().all();
    }
    
    public List<TableFood> find(String name) {
        if (name != null && !name.isEmpty())
            return this.getDb().getTableFoods().find(String.format(" LOWER(name) LIKE '%%%s%%'", name.toLowerCase()));
        return all();
    }
    
    
}
