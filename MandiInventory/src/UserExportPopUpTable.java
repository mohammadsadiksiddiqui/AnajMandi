
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sadik
 */
public class UserExportPopUpTable extends javax.swing.JDialog {

    /**
     * Creates new form UserExportPopUpTable
     */
    Connection con;
    PreparedStatement pst;
    AdminControl ac;
    DefaultTableModel model;
    ResultSet rs;
    static int cntr;
    public UserExportPopUpTable(java.awt.Frame parent, boolean modal,int cntr) {
        super(parent, modal);
        initComponents();
        this.cntr=cntr;
        con=DBConnection.getConnection();
        if(cntr==2){
            exportCounter2();
        }
        else if(cntr==3){
            exportCounter3();
        }
    }

    
    
    public void exportCounter2(){
        con = DBConnection.getConnection();
        ResultSetMetaData rsmt;
        int columnCounter;
        
        String sql = "select * from transport";
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            //rsmt = rs.getMetaData();
            //columnCounter = rsmt.getColumnCount();
            columnCounter=11;
            Vector<String> column = new Vector<String>();
            
            //column.addElement("Token");
            column.addElement("Truck Number");
            column.addElement("RST");
            column.addElement("Date of Entry");
            column.addElement("Tare Weight");
            column.addElement("Gross Weight");
            column.addElement("Net Weight with Bag");
            column.addElement("Net Weight without Bag");
            column.addElement("Driver Name");
            //column.addElement("Exporting Place");
            column.addElement("Number of Bags");
            column.addElement("Bags Type");
//            column.addElement("Builty");
//            column.addElement("Labour Group");


            column.addElement("Load verified");
            
            

            Vector data = new Vector();
            Vector row = new Vector();
            while(rs.next()){
                row = new Vector(columnCounter);
                for(int i=1;i<=columnCounter;i++){
                    switch (i) {
                        case 1:
                            row.add(rs.getString(i));
                            break;
                        case 2:
                            row.add(rs.getString(i));
                            break;
                        case 3:
                            row.add(rs.getString(i));
                            break;
                        case 4:
                            if(rs.getString("unloaded_truck_weight").equals("0.0000")){
                                row.add("");
                            }else{
                                row.add(rs.getString("unloaded_truck_weight"));
                            }
                            break;
                        case 5:
                            if(rs.getString("loaded_truck_weight").equals("0.0000")){
                                row.add("");
                            }else{
                                row.add(rs.getString("loaded_truck_weight"));
                            }
                            break;
                        case 6:
                            if(rs.getString("net_weight_with_bag").equals("0.0000")){
                                row.add("");
                            }else{
                                row.add(rs.getString("net_weight_with_bag"));
                            }
                            break;
                        case 7:
                            if(rs.getString("net_weight_without_bag").equals("0.0000")){
                                row.add("");
                            }else{
                                row.add(rs.getString("net_weight_without_bag"));
                            }
                            break;
                        case 8:
                            row.add(rs.getString("driver_name"));
                            break;
                        case 9:
                            row.add(rs.getString("number_of_bags"));
                            break;
                        case 10:
                            row.add(rs.getString("bags_type"));
                            break;
                        case 11:
                            if(rs.getInt("truck_loaded_verify")==1){
                                row.add("Yes");
                            }else{
                                row.add("No");
                            }
                            break;
                    }
                    
                }
                data.add(row);
            }
            DefaultTableModel model = (DefaultTableModel) userExportJTable.getModel();
            model.setDataVector(data, column);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exportCounter3(){
        con = DBConnection.getConnection();
        ResultSetMetaData rsmt;
        int columnCounter;
        
        String sql = "select * from transport";
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            //rsmt = rs.getMetaData();
            //columnCounter = rsmt.getColumnCount();
            columnCounter=8;
            Vector<String> column = new Vector<String>();
            
            //column.addElement("Token");column.addElement("Truck Number");
            column.addElement("Truck Number");
            column.addElement("RST");
            column.addElement("Date of Entry");
            column.addElement("Tare Weight");
            //column.addElement("Gross Weight");
            //column.addElement("Net Weight with Bag");
            //column.addElement("Net Weight without Bag");
            column.addElement("Driver Name");
            //column.addElement("Exporting Place");
            column.addElement("Number of Bags");
            column.addElement("Bag Type");
            //column.addElement("Builty");
            //column.addElement("Labour Group");
            column.addElement("Load verified");
            
            
            
            Vector data = new Vector();
            Vector row = new Vector();
            while(rs.next()){
                row = new Vector(columnCounter);
                for(int i=1;i<=columnCounter;i++){
                    switch (i) {
                        case 1:
                            row.add(rs.getString(i));
                            break;
                        case 2:
                            row.add(rs.getString(i));
                            break;
                        case 3:
                            row.add(rs.getString(i));
                            break;
                        case 4:
                            if(rs.getString("unloaded_truck_weight").equals("0.0000")){
                                row.add("");
                            }else{
                                row.add(rs.getString("unloaded_truck_weight"));
                            }
                            break;
//                        case 5:
//                            if(rs.getString("loaded_truck_weight").equals("0.0000")){
//                                row.add("");
//                            }else{
//                                row.add(rs.getString("loaded_truck_weight"));
//                            }
//                            break;
//                        case 6:
//                            if(rs.getString("net_weight_with_bag").equals("0.0000")){
//                                row.add("");
//                            }else{
//                                row.add(rs.getString("net_weight_with_bag"));
//                            }
//                            break;
//                        case 7:
//                            if(rs.getString("net_weight_without_bag").equals("0.0000")){
//                                row.add("");
//                            }else{
//                                row.add(rs.getString("net_weight_without_bag"));
//                            }
//                            break;
                        case 5:
                            row.add(rs.getString("driver_name"));
                            break;
//                        case 9:
//                            row.add(rs.getString("exporting_place"));
//                            break;
                        case 6:
                            row.add(rs.getString("number_of_bags"));
                            break;
                        case 7:
                            row.add(rs.getString("bags_type"));
                            break;
//                        case 12:
//                            row.add(rs.getString("builty_number"));
//                            break;
//                        case 13:
//                            row.add(rs.getString("labour_group"));
//                            break;
                        case 8:
                            if(rs.getInt("truck_loaded_verify")==1){
                                row.add("Yes");
                            }else{
                                row.add("No");
                            }
                            break;
                        }
                }
                data.add(row);
            }
            DefaultTableModel model = (DefaultTableModel) userExportJTable.getModel();
            model.setDataVector(data, column);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        userExportJTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        userExportSearchTF = new javax.swing.JTextField();
        counterReportBTN = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        userExportJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(userExportJTable);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\sadik\\Desktop\\icon\\if_search_173095.png")); // NOI18N
        jLabel14.setText("Search");

        userExportSearchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userExportSearchTFKeyReleased(evt);
            }
        });

        counterReportBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        counterReportBTN.setText("Generate Report");
        counterReportBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counterReportBTNActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("* Bag Type: 1 means jute ,2 means PP");

        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("* To generate Excel Report file close old report Excel file first, if it's already opened!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(counterReportBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(64, 64, 64)
                .addComponent(userExportSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(94, 94, 94)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(467, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(userExportSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(counterReportBTN))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userExportSearchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userExportSearchTFKeyReleased
        model = (DefaultTableModel)userExportJTable.getModel();
        String search = userExportSearchTF.getText();//.toLowerCase();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        userExportJTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_userExportSearchTFKeyReleased

    private void counterReportBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counterReportBTNActionPerformed
        model = (DefaultTableModel) userExportJTable.getModel();
        RowSorter rs = userExportJTable.getRowSorter();
        int row = model.getRowCount();
        if(rs!=null){
            row=rs.getViewRowCount();
        }
        
        File file1 = new File("c:\\mandiReport");
        if(!file1.exists()){
            file1.mkdir();

        }
        File file = new File("c:\\mandiReport\\exportCounterReport.xls");
        try {
            FileWriter out = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(out);
            for(int i=0;i<model.getColumnCount();i++){
                bw.write(model.getColumnName(i)+"\t");
            }
            bw.write("\n");
            int r=0;
            for(int i=0;i<row;i++){
                for(int j=0;j<model.getColumnCount();j++){
                    if(null==model.getValueAt(i,j)){
                        bw.write(""+"\t");
                    }else{
                        if(null==rs){
                            bw.write(model.getValueAt(i,j)+"\t");
                        }
                        else{
                            r = rs.convertRowIndexToModel(i);
                            bw.write(model.getValueAt(r,j)+"\t");
                        }
                    }
                }
//                if(r==0){
//                    totalBag+=Integer.parseInt(model.getValueAt(i,7).toString());
//                    tWWithBag+=Double.parseDouble(model.getValueAt(i,11).toString());
//                    tWWithoutBag+=Double.parseDouble(model.getValueAt(i,12).toString());
//                }else{
//                    totalBag+=Integer.parseInt(model.getValueAt(r,7).toString());
//                    tWWithBag+=Double.parseDouble(model.getValueAt(r,11).toString());
//                    tWWithoutBag+=Double.parseDouble(model.getValueAt(r,12).toString());
//                }
//
                bw.write("\n");
            }
            bw.write("\n");
//            for(int i=0;i<model.getColumnCount();i++){
//                if(i==6){
//                    bw.write("Total");
//                }
//                else if(i==7){
//                    bw.write(totalBag+"");
//                }else if(i==11){
//                    bw.write(tWWithBag+"");
//                }else if(i==12){
//                    bw.write(tWWithoutBag+"");
//                }
//                bw.write("\t");
//            }
            bw.close();
            JOptionPane.showMessageDialog(null,"File saved in c:\\mandiReport\\exportCounterReport.xls");
        } catch (IOException ex) {
            Logger.getLogger(ImportPopUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_counterReportBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserExportPopUpTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserExportPopUpTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserExportPopUpTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserExportPopUpTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserExportPopUpTable dialog = new UserExportPopUpTable(new javax.swing.JFrame(), true,cntr);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton counterReportBTN;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable userExportJTable;
    private javax.swing.JTextField userExportSearchTF;
    // End of variables declaration//GEN-END:variables
}
