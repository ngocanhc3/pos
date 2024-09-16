/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import vn.edu.coffee.models.Bill;

/**
 *
 * @author Ngoc Anh
 */
public class BillDao extends BaseDao implements IGeneric<Bill, Long> {

    public BillDao(SqlConnector _connector) throws Exception {
        super(_connector);
    }

    @Override
    public Bill findById(Long id) {
        try {
            PreparedStatement preparedStatement = this.connector.getPreStatement("Select * from Bill WHERE Id = ?");
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                return new Bill(result);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Bill> all() {
        try {
            return find(null);
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    public List<Bill> find(String whereClause) throws Exception {
        List<Bill> ls = new ArrayList<>();
        String SQL = "Select * from Bill ";
        if (whereClause != null && !whereClause.isEmpty()) {
            SQL = String.format("%s WHERE 1 = 1 AND %s", SQL, whereClause);
        }
        ResultSet result = this.connector.select(SQL);
        while (result.next()) {
            ls.add(new Bill(result));
        }

        return ls;
    }

    @Override
    public boolean add(Bill item) {
        try {
            String sql = "INSERT INTO Bill (amount, total, checkinAt) VALUES (?, ?, ?)";
            PreparedStatement spStatement = this.connector.getPreStatement(sql);
            spStatement.setInt(1, item.getAmount());
            spStatement.setFloat(2, item.getTotal());
            spStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            int result = spStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Long id) {
        try {
            PreparedStatement preparedStatement = this.connector.getPreStatement("DELETE FROM Bill WHERE Id = ?");
            preparedStatement.setLong(1, id);
            int rows = preparedStatement.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Long id, Bill model) {
        try {
            String sql = "UPDATE Bill SET amount = ?, total = ?, checkoutAt = ? WHERE id = ?";
            PreparedStatement spStatement = this.connector.getPreStatement(sql);
            spStatement.setInt(1, model.getAmount());
            spStatement.setFloat(2, model.getTotal());
            spStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            spStatement.setLong(4, id);
            int result = spStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public long checkin(long idTable, Bill item) {
        long id = -1;
        try {
            String sql = "INSERT INTO Bill (amount, total, checkinAt) VALUES (?, ?, ?)";
            PreparedStatement spStatement = this.connector.getPreStatement(sql, Statement.RETURN_GENERATED_KEYS);
            spStatement.setInt(1, item.getAmount());
            spStatement.setFloat(2, item.getTotal());
            spStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            int result = spStatement.executeUpdate();
            if (result > 0) {
                try (ResultSet rs = spStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                }
            }

            if (id > 0) {
                PreparedStatement spUpdate = this.connector.getPreStatement("UPDATE TableFood SET idBill = ? WHERE id = ?");
                spUpdate.setLong(1, id);
                spUpdate.setLong(2, idTable);
                spUpdate.executeUpdate();
            }

            return id;

        } catch (Exception e) {
            e.printStackTrace();
            return id;
        }
    }

    public boolean checkout(final long tableId, final long billId) {
        try {
            System.out.println("vn.edu.coffee.dao.BillDao.checkout() " + tableId + " = > " + billId);
            PreparedStatement preparedStatement = this.connector.getPreStatement("select sum(amount) as amount, SUM( amount * price) as total from OrderDetail WHERE  billid = ?");
            preparedStatement.setLong(1, billId);
            ResultSet result = preparedStatement.executeQuery();
            int rs = 0;
            while (result.next()) {
                int amount = result.getInt("amount");
                float total = result.getFloat("total");
                String sql = "UPDATE Bill SET total = ?, amount = ?, checkoutAt = ? WHERE id = ?";
                PreparedStatement spStatement = this.connector.getPreStatement(sql);
                spStatement.setFloat(1, total);
                spStatement.setInt(2, amount);
                spStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                spStatement.setLong(4, billId);
                rs = spStatement.executeUpdate();
            }

            if (rs > 0) {
                PreparedStatement spUpdate = this.connector.getPreStatement("UPDATE TableFood SET idBill = 0 WHERE id = ?");
                spUpdate.setLong(1, tableId);
                return spUpdate.executeUpdate() > 0;
            }
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Object[]> orderReport(String whereClause) {
        try {
            List<Object[]> ls = new ArrayList<>();
            if (!(whereClause != null && !whereClause.isEmpty())) {
                whereClause = " 1 = 1 ";
            }

            String SQL = String.format("select CAST(checkoutAt AS DATE) as timeAt, count(*) amount, SUM(total) total FROM Bill WHERE checkoutAt is not NULL AND %s group by CAST(checkoutAt AS DATE)",
                    whereClause
            );
            ResultSet result = this.connector.select(SQL);
            while (result.next()) {
                ls.add(new Object[]{
                    result.getString("timeAt"),
                    result.getInt("amount"),
                    result.getFloat("total"),});
            }

            return ls;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
