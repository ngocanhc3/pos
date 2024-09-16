/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.controllers;

import vn.edu.coffee.dao.DBContext;

/**
 *
 * @author Ngoc Anh
 */
public class BaseController {

    private DBContext db;
    
    public BaseController() {
        db = DBContext.getInstance();
    }
    
    public DBContext getDb() {
        return db;
    }
}
