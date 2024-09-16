/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vn.edu.coffee.controllers;

import java.util.List;

/**
 *
 * @author Ngoc Anh
 */
public interface IController<T, ID> {

    boolean add(T item);

    boolean update(ID id, T item);

    boolean remove(ID id);

    List<T> all();

    T findById(ID id);

}
