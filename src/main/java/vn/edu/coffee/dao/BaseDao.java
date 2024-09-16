/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.dao;

/**
 *
 * @author Ngoc Anh
 */
public class BaseDao {
    public final SqlConnector connector;
    public BaseDao(SqlConnector _connector) throws Exception {
        connector = _connector;
    }
}
