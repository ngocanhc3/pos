/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vn.edu.coffee.views.menuitem;

import java.util.List;
import vn.edu.coffee.views.*;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import vn.edu.coffee.controllers.MenuItemCtrl;
import vn.edu.coffee.events.MyActionEvent;
import vn.edu.coffee.models.MenuItem;

/**
 *
 * @author Ngoc Anh
 */
public class MenuItemUI extends BaseFrame {

    /**
     * Creates new form TableFoodUI
     */
    public MenuItemUI() {
        initComponents();
        afterInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        lblInfo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItems = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MenuItem Management");
        setResizable(false);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setFloatable(true);

        lblInfo.setText("jLabel2");
        lblInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        jToolBar1.add(lblInfo);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.BorderLayout(0, 4));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnAdd.setBackground(new java.awt.Color(255, 102, 102));
        btnAdd.setText("Add New");
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdd);

        btnUpdate.setBackground(new java.awt.Color(0, 255, 153));
        btnUpdate.setText("Update");
        btnUpdate.setActionCommand("");
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUpdate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate);

        btnDel.setBackground(new java.awt.Color(255, 255, 153));
        btnDel.setText("Delete");
        btnDel.setToolTipText("");
        btnDel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        jPanel2.add(btnDel);

        jLabel1.setText("Search");
        jPanel2.add(jLabel1);

        txtSearch.setPreferredSize(new java.awt.Dimension(180, 22));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        jPanel2.add(txtSearch);

        btnSearch.setText("Search");
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel2.add(btnSearch);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tbItems.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tbItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Status"
            }
        ));
        tbItems.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tbItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbItems.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbItems.setShowGrid(true);
        tbItems.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tbItems);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        onAdd();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        onUpdate();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        onDelete();
    }//GEN-LAST:event_btnDelActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        onLoadData();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        onLoadData();
    }//GEN-LAST:event_btnSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTable tbItems;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel tableModel;
    private MenuItem itemUpdate;
    private MenuItemCtrl ctrl;

    private void afterInitComponents() {
        ctrl = new MenuItemCtrl();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.tableModel = (DefaultTableModel) tbItems.getModel();
        this.tbItems.getSelectionModel().addListSelectionListener(new OnTableSelect());
        HelperUI.setRowEditDisable(tbItems);
        HelperUI.setTbColAlignment(tbItems, 0, SwingConstants.CENTER, 50);
        HelperUI.setTbColAlignment(tbItems, 1, SwingConstants.LEFT, 0);
        HelperUI.setTbColAlignment(tbItems, 2, SwingConstants.RIGHT, 0);    
        HelperUI.setTbColAlignment(tbItems, 3, SwingConstants.CENTER, 80);
        onLoadData();
    }

    private void onLoadData() {
        
        this.itemUpdate = null;
        setEnabledButton();
        this.tbItems.removeAll();
        this.tableModel.setRowCount(0);
        List<MenuItem> list = ctrl.find(txtSearch.getText());
        for (MenuItem item : list) {
            tableModel.addRow(new Object[]{
                item.getId(), item.getName(),
                String.format("%(,.0f", item.getPrice()),
                item.isStatus() ? "Available" : "Unavailable"
            });
        }
        lblInfo.setText(String.format("Total: %d items", list.size()));
        this.tbItems.revalidate();
        this.tbItems.repaint();
    }

    private void onUpdate() {
        FormMenuItem form = new FormMenuItem(this, this.itemUpdate);
        form.addEvent = new MyActionEvent<MenuItem>() {
            @Override
            public void onAction(MenuItem item) {
                ctrl.update(item.getId(), item);
                onLoadData();
            }
        };
        form.setVisible(true);
    }

    private void onDelete() {
        if (itemUpdate != null) {
            ctrl.remove(itemUpdate.getId());
            showSuccess();
            onLoadData();
        }
    }

    private void onAdd() {
        FormMenuItem form = new FormMenuItem(this, null);
        form.addEvent = new MyActionEvent<MenuItem>() {
            @Override
            public void onAction(MenuItem item) {
                ctrl.add(item);
                onLoadData();
            }
        };
        form.setVisible(true);
    }

    private class OnTableSelect implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int inx = tbItems.getSelectedRow();
                if (inx != -1) {
                    long id = Long.parseLong(tableModel.getValueAt(inx, 0).toString());
                    itemUpdate = ctrl.findById(id);
                    setEnabledButton();
                }
            }
        }
    }

    private void setEnabledButton() {
        boolean enabled = itemUpdate != null;
        btnUpdate.setEnabled(enabled);
        btnDel.setEnabled(enabled);
    }

}
