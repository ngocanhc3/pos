/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.edu.coffee.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Ngoc Anh
 */
public class HelperUI {

    public static void showMessage(JFrame frame, String message) {
        JOptionPane.showConfirmDialog(frame, message, "Infomarion", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showSuccess(JFrame frame) {
        JOptionPane.showConfirmDialog(frame, "Successfully!", "Infomarion", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(JFrame frame) {
        JOptionPane.showConfirmDialog(frame, "An error has occurred.", "Error", JOptionPane.ERROR_MESSAGE, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void setTbColAlignment(JTable tb, int col, int alignment, int width) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(alignment);
        TableColumn column = tb.getColumnModel().getColumn(col);
        
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        int hAlignment = JLabel.LEFT;
        switch (alignment) {
            case SwingConstants.RIGHT:
                hAlignment = JLabel.RIGHT;
                break;
            case SwingConstants.CENTER:
                hAlignment = JLabel.CENTER;
                break;
        }
        cellRenderer.setBackground(tb.getTableHeader().getBackground());
        cellRenderer.setHorizontalAlignment(hAlignment);
        column.setHeaderRenderer(cellRenderer);
        if (width > 0)
            column.setMaxWidth(width);
        column.setCellRenderer(renderer);
    }
    
    public static void setRowEditDisable(JTable tbItems) {
        tbItems.setDefaultEditor(Object.class, null);
    }
}
