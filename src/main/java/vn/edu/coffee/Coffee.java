/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package vn.edu.coffee;

import vn.edu.coffee.controllers.MenuItemCtrl;
import vn.edu.coffee.controllers.TableFoodCtrl;
import vn.edu.coffee.models.MenuItem;
import vn.edu.coffee.models.TableFood;
import vn.edu.coffee.views.orders.MainUI;

/**
 *
 * @author Ngoc Anh
 */
public class Coffee {

    public static void main(String[] args) {
        // initFakeData();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    private static void initFakeData() {
        try {
//            Table
            TableFoodCtrl tableFoodCtrl = new TableFoodCtrl();
            for (int i = 1; i < 10; i++) {
                tableFoodCtrl.add(new TableFood(String.format("Table %d", i + 1)));
            }

//            Menu item
            MenuItem[] menus = {
                new MenuItem("Espresso", 60000),
                new MenuItem("Cappuccino", 85000),
                new MenuItem("Latte", 95000),
                new MenuItem("Mocha", 110000),
                new MenuItem("Americano", 65000),
                new MenuItem("Macchiato", 90000),
                new MenuItem("Flat White", 92000),
                new MenuItem("Iced Coffee", 75000),
                new MenuItem("Cold Brew", 100000),
                new MenuItem("Matcha Latte", 110000),
                new MenuItem("Chai Latte", 95000),
                new MenuItem("Hot Chocolate", 70000),
                new MenuItem("Iced Tea", 65000),
                new MenuItem("Smoothies", 120000),
                new MenuItem("Frappuccino", 125000)
            };
            
            MenuItemCtrl menuItemCtrl = new MenuItemCtrl();
            
            for (int i = 0; i < menus.length; i++) {
                menuItemCtrl.add(menus[i]);
            }
            
        } catch (Exception e) {
        }

    }
}
