/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vn.edu.coffee.views.orders;

import vn.edu.coffee.controllers.TableFoodCtrl;
import vn.edu.coffee.events.MyActionEvent;
import vn.edu.coffee.models.TableFood;

/**
 *
 * @author Ngoc Anh
 */
public class TableFoodPUI extends javax.swing.JPanel {

    /**
     * Creates new form TableFoodPUI
     */
    public TableFoodPUI() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pTable = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tables");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 1, 6, 1));

        pTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pTable.setLayout(new java.awt.GridLayout(0, 4, 10, 10));
        jScrollPane1.setViewportView(pTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private TableFoodCtrl ctrl;
    
    private MyActionEvent<TableFood> onTableItemClick;
    
    private void afterInitComponents() {
        ctrl = TableFoodCtrl.getInstance();
        onLoadData();
    }
    
    public void onLoadData() {
        pTable.removeAll();
        for (TableFood tableFood : ctrl.all()) {
            TableItemCard card = new TableItemCard(tableFood);
            card.onClick = new OnTableClick();
            pTable.add(card);
        }
        pTable.revalidate();
        pTable.repaint();
    }
    
    private class OnTableClick implements MyActionEvent<TableFood> {

        @Override
        public void onAction(TableFood item) {
            if(onTableItemClick != null) {
                onTableItemClick.onAction(item);
            }
        }
    }
    
    public void addTableClick(MyActionEvent<TableFood> evt) {
        onTableItemClick = evt;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pTable;
    // End of variables declaration//GEN-END:variables
}