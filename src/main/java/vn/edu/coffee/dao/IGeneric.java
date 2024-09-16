/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vn.edu.coffee.dao;

import java.util.List;

/**
 *
 * @author Ngoc Anh
 */
public interface IGeneric<T, ID> {
    T findById(ID id);
    List<T> all();
    boolean add(T item);
    boolean remove(ID id);
    boolean update(ID id, T item);
    
    
}
