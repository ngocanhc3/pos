/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.dao;

import com.microsoft.sqlserver.jdbc.StringUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vn.edu.coffee.models.TableFood;

/**
 *
 * @author Ngoc Anh
 */
public class TableFoodDao implements IGeneric<TableFood, Long> {

    private final SqlConnector connector;
    public TableFoodDao(SqlConnector _connector) throws Exception {
        super();
        connector = _connector;
    }

    @Override
    public boolean add(TableFood model) {
         try {
            String sql = "INSERT INTO TableFood (name, idBill, status) VALUES (?, ?, ?)";
            PreparedStatement spStatement = this.connector.getPreStatement(sql);
            spStatement.setString(1, model.getName());
            spStatement.setLong(2, model.getIdBill());
            spStatement.setBoolean(3, model.isStatus());
            int result = spStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Long id, TableFood model) {
        try {
            String sql = "UPDATE TableFood SET name = ?, idBill = ?, status = ? WHERE id = ?";
            PreparedStatement spStatement = this.connector.getPreStatement(sql);
            spStatement.setString(1, model.getName());
            spStatement.setLong(2, model.getIdBill());
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
            PreparedStatement preparedStatement = this.connector.getPreStatement("DELETE FROM TableFood WHERE Id = ?");
            preparedStatement.setLong(1, id);
            int rows = preparedStatement.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public TableFood findById(Long id) {
        try {
            PreparedStatement preparedStatement = this.connector.getPreStatement("Select * from TableFood WHERE Id = ?");
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                return new TableFood(result);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TableFood> all() {
        return find(null);
    }
    
    public List<TableFood> find(String whereClause) {
        try {
            List<TableFood> ls = new ArrayList<>();
            String SQL = "Select * from TableFood ";
            if (whereClause != null && ! whereClause.isEmpty()) {
                SQL = String.format("%s WHERE 1 = 1 AND %s", SQL, whereClause);
            }
            ResultSet result = this.connector.select(SQL);
            while (result.next()) {
                ls.add(new TableFood(result));
            }

            return ls;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
}
