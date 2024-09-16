/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vn.edu.coffee.models.MenuItem;

/**
 *
 * @author Ngoc Anh
 */
public class MenuItemDao extends BaseDao implements IGeneric<MenuItem, Long> {

    public MenuItemDao(SqlConnector _connector) throws Exception {
        super(_connector);
    }

    @Override
    public boolean add(MenuItem model) {
         try {
            String sql = "INSERT INTO MenuItem (name, price, status) VALUES (?, ?, ?)";
            PreparedStatement spStatement = this.connector.getPreStatement(sql);
            spStatement.setString(1, model.getName());
            spStatement.setDouble(2, model.getPrice());
            spStatement.setBoolean(3, model.isStatus());
            int result = spStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Long id, MenuItem model) {
        try {
            String sql = "UPDATE MenuItem SET name = ?, price = ?, status = ? WHERE id = ?";
            PreparedStatement spStatement = this.connector.getPreStatement(sql);
            spStatement.setString(1, model.getName());
            spStatement.setDouble(2, model.getPrice());
            spStatement.setBoolean(3, model.isStatus());
            spStatement.setLong(4, id);
            int result = spStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(Long id) {
        try {
            PreparedStatement preparedStatement = this.connector.getPreStatement("DELETE FROM MenuItem WHERE Id = ?");
            preparedStatement.setLong(1, id);
            int rows = preparedStatement.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public MenuItem findById(Long id) {
        try {
            PreparedStatement preparedStatement = this.connector.getPreStatement("Select * from MenuItem WHERE Id = ?");
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                return new MenuItem(result);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

     @Override
    public List<MenuItem> all() {
        return find(null);
    }
    
    public List<MenuItem> find(String whereClause) {
        try {
            List<MenuItem> ls = new ArrayList<>();
            String SQL = "Select * from MenuItem ";
            if (whereClause != null && ! whereClause.isEmpty()) {
                SQL = String.format("%s WHERE 1 = 1 AND %s ", SQL, whereClause);
            }
//            SQL = String.format("%s ORDER BY name", SQL);
            ResultSet result = this.connector.select(SQL);
            while (result.next()) {
                ls.add(new MenuItem(result));
            }

            return ls;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
