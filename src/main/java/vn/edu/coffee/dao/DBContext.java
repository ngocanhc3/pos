/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.dao;

/**
 *
 * @author Ngoc Anh
 */
public class DBContext {

    static DBContext instance;

    private MenuItemDao menuItems;
    private TableFoodDao tableFoods;
    private BillDao bills;
    private OrderDetailDao orders;

    protected DBContext() {
        try {
            SqlConnector connector = new SqlConnector();
            this.menuItems = new MenuItemDao(connector);
            this.tableFoods = new TableFoodDao(connector);
            this.bills = new BillDao(connector);
            this.orders = new OrderDetailDao(connector);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBContext getInstance() {
        if (instance == null) {
            instance = new DBContext();
        }

        return instance;
    }

    public MenuItemDao getMenuItems() {
        return menuItems;
    }

    public TableFoodDao getTableFoods() {
        return tableFoods;
    }

    public BillDao getBills() {
        return bills;
    }

    public OrderDetailDao getOrders() {
        return orders;
    }
}
