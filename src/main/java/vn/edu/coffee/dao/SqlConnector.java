/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ngoc Anh
 */
public class SqlConnector {
    
    final String CONN_URL = "jdbc:sqlserver://;servername=LAPTOP-09VI68L4\\PC;databaseName=coffee_pos;username=sa;password=Abc!1234;encrypt=true;trustServerCertificate=true;useUnicode=true;characterEncoding=UTF-8;";
//    final String CONN_URL = "jdbc:sqlserver://84.247.162.137:1433;databaseName=cfpos;encrypt=true;trustServerCertificate=true;useUnicode=true;characterEncoding=UTF-8";
    public SqlConnector() throws SQLException {
    }

    private Connection connection;

    private Connection createInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(CONN_URL, "sa", "Abc!1234");
        }

        return connection;
    }

    public Connection getInstance() throws SQLException {
        return createInstance();
    }

    public Statement getStatement() throws SQLException {
        Connection conn = createInstance();
        return conn.createStatement();
    }

    public PreparedStatement getPreStatement(String sql) throws SQLException {
        Connection conn = createInstance();
        return conn.prepareStatement(sql);
    }
    
    public PreparedStatement getPreStatement(String sql, int auto) throws SQLException {
        Connection conn = createInstance();
        return conn.prepareStatement(sql, auto);
    }
    
    public ResultSet select(String sql) throws Exception {
        Statement statement = getStatement();
        return statement.executeQuery(sql);
    }
}
