/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import vn.edu.coffee.models.OrderDetail;

/**
 *
 * @author Ngoc Anh
 */
public class OrderDetailDao extends BaseDao {

    public OrderDetailDao(SqlConnector _connector) throws Exception {
        super(_connector);
    }

    public OrderDetail findById(Long billId, long itemId) {
        try {
            PreparedStatement preparedStatement = this.connector.getPreStatement("Select * from OrderDetail WHERE billId = ? AND itemId = ?");
            preparedStatement.setLong(1, billId);
            preparedStatement.setLong(2, itemId);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                return new OrderDetail(result);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<OrderDetail> all() {
        try {
            List<OrderDetail> ls = new ArrayList<>();
            ResultSet result = this.connector.select("Select * from OrderDetail");

            while (result.next()) {
                ls.add(new OrderDetail(result));
            }

            return ls;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<OrderDetail> findByBillId(Long id) {
        try {
            List<OrderDetail> ls = new ArrayList<>();
            String sql = "SELECT T.*, M.name as name FROM OrderDetail T "
                    + "LEFT JOIN MenuItem M ON T.itemId = M.id "
                    + "WHERE T.billId = ?";
            PreparedStatement spStatement = this.connector.getPreStatement(sql);
            spStatement.setLong(1, id);
            ResultSet result = spStatement.executeQuery();
            while (result.next()) {
                OrderDetail tmp = new OrderDetail(result);
                tmp.setName(result.getString("name"));
                ls.add(tmp);
            }

            return ls;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public boolean add(OrderDetail item) {
        try {
            OrderDetail tmp = this.findById(item.getBillId(), item.getItemId());
            PreparedStatement spStatement;
            if (tmp == null) {
                String sql = "INSERT INTO OrderDetail (billId, itemId, price, amount) VALUES (?, ?, ?, ?)";
                spStatement = this.connector.getPreStatement(sql);
                spStatement.setLong(1, item.getBillId());
                spStatement.setLong(2, item.getItemId());
                spStatement.setFloat(3, item.getPrice());
                spStatement.setInt(4, 1);

            } else {
                String sql = "UPDATE OrderDetail SET amount = ? WHERE billId = ? AND itemId = ? ";
                spStatement = this.connector.getPreStatement(sql);
                spStatement.setInt(1, tmp.getAmount() + 1);
                spStatement.setLong(2, item.getBillId());
                spStatement.setLong(3, item.getItemId());
            }

            int result = spStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remove(Long id) {
        try {
            PreparedStatement preparedStatement = this.connector.getPreStatement("DELETE FROM OrderDetail WHERE Id = ?");
            preparedStatement.setLong(1, id);
            int rows = preparedStatement.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Long id, OrderDetail model) {
        try {
            String sql = "UPDATE OrderDetail SET total = ?, price = ?, checkoutAt = ? WHERE id = ?";
            PreparedStatement spStatement = this.connector.getPreStatement(sql);
//            spStatement.setInt(1, model.getTotal());
            spStatement.setFloat(2, model.getPrice());
            spStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            spStatement.setLong(4, id);
            int result = spStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
