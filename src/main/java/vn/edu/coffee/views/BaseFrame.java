/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.views;

import javax.swing.JOptionPane;

/**
 *
 * @author Ngoc Anh
 */
public class BaseFrame extends javax.swing.JFrame {

    public void showSuccess() {
        JOptionPane.showConfirmDialog(this, "Successfully!", "Infomarion", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    public void showError(String message) {
        JOptionPane.showConfirmDialog(this, "An error has occurred.", "Error", JOptionPane.ERROR_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
    }
}


