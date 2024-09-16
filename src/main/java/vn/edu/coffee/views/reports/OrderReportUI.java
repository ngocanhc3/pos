/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vn.edu.coffee.views.reports;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import vn.edu.coffee.controllers.BillCtrl;
import vn.edu.coffee.views.BaseFrame;
import vn.edu.coffee.views.HelperUI;

/**
 *
 * @author Ngoc Anh
 */
public class OrderReportUI extends BaseFrame {

    /**
     * Creates new form OrderReportUI
     */
    public OrderReportUI() {
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

        jPanel1 = new javax.swing.JPanel();
        jpanels = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        dtpFrom = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dtpTo = new javax.swing.JFormattedTextField();
        lblInfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbItems = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Order Report");
        setAlwaysOnTop(true);

        jPanel1.setLayout(new java.awt.BorderLayout());

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        dtpFrom.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jLabel1.setText("From");

        jLabel2.setText("To");

        dtpTo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        lblInfo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(255, 51, 51));
        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jpanelsLayout = new javax.swing.GroupLayout(jpanels);
        jpanels.setLayout(jpanelsLayout);
        jpanelsLayout.setHorizontalGroup(
            jpanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jpanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelsLayout.createSequentialGroup()
                        .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jpanelsLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtpFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtpTo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addComponent(btnSearch)
                        .addGap(36, 36, 36))))
        );
        jpanelsLayout.setVerticalGroup(
            jpanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelsLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jpanelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(dtpFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(dtpTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblInfo)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel1.add(jpanels, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));

        tbItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Amount", "Total"
            }
        ));
        jScrollPane1.setViewportView(tbItems);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        onLoadData();
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JFormattedTextField dtpFrom;
    private javax.swing.JFormattedTextField dtpTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanels;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTable tbItems;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel tableModel;
    private BillCtrl billCtrl;
    private final String DATE_FORMAT = "dd/MM/yyyy";
    private final String DATE_FORMAT_SQL = "yyyy-MM-dd";

    private void afterInitComponents() {
        setLocationRelativeTo(null);
        billCtrl = new BillCtrl();
        this.tableModel = (DefaultTableModel) tbItems.getModel();
        HelperUI.setTbColAlignment(tbItems, 0, SwingConstants.CENTER, 0);
        HelperUI.setTbColAlignment(tbItems, 1, SwingConstants.CENTER, 0);
        HelperUI.setTbColAlignment(tbItems, 2, SwingConstants.RIGHT, 0);
        HelperUI.setRowEditDisable(tbItems);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime from = now.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
        LocalDateTime to = now.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        dtpFrom.setText(from.format(formatter));
        dtpTo.setText(to.format(formatter));
        onLoadData();
    }

    private void onLoadData() {

        final String sql = String.format(" checkoutAt BETWEEN '%s' AND '%s'",
                getDateSql(dtpFrom.getText()),
                getDateSql(dtpTo.getText())
        );
        
        List<Object[]> list = billCtrl.orderReport(sql);
        tableModel.setRowCount(0);
        tbItems.removeAll();
        float total = 0f;
        for (Object[] objects : list) {
            total += (Float) objects[2];
            tableModel.addRow(new Object[]{
                objects[0],
                objects[1],
                String.format("%(,.0f", objects[2])
            });
        }
        tbItems.revalidate();
        tbItems.repaint();
        lblInfo.setText(String.format("Total: %(,.0f", total));
        tbItems.revalidate();
        tbItems.repaint();
    }

    private String getDateSql(String val) {
        return LocalDate.parse(val, DateTimeFormatter.ofPattern(DATE_FORMAT))
                .format(DateTimeFormatter.ofPattern(DATE_FORMAT_SQL));
    }

}