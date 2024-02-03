
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
public class UserImportPopUpTable extends javax.swing.JDialog {

    Connection con;
    PreparedStatement pst;
    AdminControl ac;
    DefaultTableModel model;
    ResultSet rs;
    static int cntr;
    
    public UserImportPopUpTable(java.awt.Frame parent, boolean modal,int cntr) {

        super(parent, modal);
        this.cntr=cntr;
        con=DBConnection.getConnection();
        initComponents();
        if(cntr==1){
            importCounter1();
        }
        else if(cntr==2){
            importCounter2();
        }
        else if(cntr==3){
            importCounter3();
        }
    }
    
    
    public void importCounter1(){
                
        //ResultSetMetaData rsmt;
     
        int columnCount;
        
        String sql = "select * from counter2";
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            //rsmt = rs.getMetaData();
            //columnCount = rsmt.getColumnCount();
            columnCount=7;
            Vector<String> column = new Vector<String>();
            
            column.addElement("Token");
            column.addElement("Farmer Reg.");
            column.addElement("Name");
            column.addElement("Village");
            column.addElement("Tractor");
            column.addElement("Trolley Colour");
//            column.addElement("RST");
            column.addElement("Date of Entry");
//            column.addElement("Anubandh Kr.");
//            column.addElement("Gross Weight");
//            column.addElement("Tare Weight");
//            column.addElement("Net Weight");
//            column.addElement("Unload Verified");
            
            
            
            

            Vector data = new Vector();
            Vector row = new Vector();
            while(rs.next()){
                String sql2="select * from counter1 where regno =?";
                PreparedStatement pst2=con.prepareStatement(sql2);
                pst2.setString(1,rs.getString("farmer_reg"));
                ResultSet rs2=pst2.executeQuery();
                rs2.next();
                row = new Vector(columnCount);
                
                for(int i=1;i<=columnCount;i++){
                    
                    switch (i) {
                        case 1:
                            row.add("n"+rs.getString(i));
                            break;
                        case 2://row.add(rs2.getString("farmername"));
                            row.add(rs.getString(i));
                            break;
                        case 3:
                            row.add(rs2.getString("farmername"));
                            break;
                        case 4:
                            row.add(rs2.getString("village"));
                            break;
                        case 5:
                            row.add(rs.getString(3));
                            break;
                        case 6:
                            row.add(rs.getString(4));
                            break;
                        case 7:
                            row.add(rs.getString(6));
                            break;
                    }
                    
                }
                data.add(row);
            }
            
            model = (DefaultTableModel) counterJTable.getModel();
            model.setDataVector(data, column);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void importCounter2(){
                
        //ResultSetMetaData rsmt;
        int columnCount;
        
        String sql = "select * from counter2";
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            //rsmt = rs.getMetaData();
            //columnCount = rsmt.getColumnCount();
            columnCount=11;
            Vector<String> column = new Vector<String>();
            
            column.addElement("Token");
            column.addElement("Farmer Reg.");
            column.addElement("Name");
            column.addElement("Village");
            column.addElement("Tractor");
            column.addElement("Trolley Colour");
            column.addElement("Date of Entry");
            column.addElement("RST");
//            column.addElement("Anubandh Kr.");
            column.addElement("Gross Weight");
            column.addElement("Tare Weight");
            column.addElement("Net Weight");
//            column.addElement("Unload Verified");
            
            Vector data = new Vector();
            Vector row = new Vector();
            while(rs.next()){
                String sql2="select * from counter1 where regno =?";
                PreparedStatement pst2=con.prepareStatement(sql2);
                pst2.setString(1,rs.getString("farmer_reg"));
                ResultSet rs2=pst2.executeQuery();
                rs2.next();
                row = new Vector(columnCount);
                
                for(int i=1;i<=columnCount;i++){
                    
                    switch (i) {
                        case 1:
                            row.add("n"+rs.getString(i));
                            break;
                        case 2://row.add(rs2.getString("farmername"));
                            row.add(rs.getString(i));
                            break;
                        case 3:
                            row.add(rs2.getString("farmername"));
                            break;
                        case 4:
                            row.add(rs2.getString("village"));
                            break;
                        case 5:
                            row.add(rs.getString(3));
                            break;
                        case 6:
                            row.add(rs.getString(4));
                            break;
                        case 7:
                            row.add(rs.getString(6));//date
                            break;
                        case 8:
                            row.add(rs.getString(5));//rst
                            break;
                        case 9:
//                            if(rs.getString(8).equals("0.0000")){
//                                row.add("");
//                            }else{
//                                //row.add(rs.getString(8));
//                                //System.out.println(rs.getString(8));
//                            }
                            row.add(rs.getString(8));
                            break;
                        case 10:
//                            if(rs.getString(9).equals("0.0000")){
//                                row.add("");
//                            }else{
//                                row.add(rs.getString(9));
//                            }
                            row.add(rs.getString(9));
                            break;
                        case 11:
//                            if(rs.getString(10).equals("0.0000")){
//                                row.add("");
//                            }else{
//                                row.add(rs.getString(10));
//                            }
                            row.add(rs.getString(10));
                            break;
                    }
                    
                }
                data.add(row);
            }
            
            model = (DefaultTableModel) counterJTable.getModel();
            model.setDataVector(data, column);
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public void importCounter3(){
                
        //ResultSetMetaData rsmt;
        int columnCount;
        
        String sql = "select * from counter2";
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            //rsmt = rs.getMetaData();
            //columnCount = rsmt.getColumnCount();
            columnCount=13;
            Vector<String> column = new Vector<String>();
            
            column.addElement("Token");
            column.addElement("Farmer Reg.");
            column.addElement("Name");
            column.addElement("Village");
            column.addElement("Tractor");
            column.addElement("Trolley Colour");
            column.addElement("Date of Entry");
            column.addElement("RST");
            column.addElement("Anubandh Kr.");
            column.addElement("Gross Weight");
            column.addElement("Tare Weight");
            column.addElement("Net Weight");
            column.addElement("Unload Verified");
            
            Vector data = new Vector();
            Vector row = new Vector();
            while(rs.next()){
                String sql2="select * from counter1 where regno =?";
                PreparedStatement pst2=con.prepareStatement(sql2);
                pst2.setString(1,rs.getString("farmer_reg"));
                ResultSet rs2=pst2.executeQuery();
                rs2.next();
                row = new Vector(columnCount);
                
                for(int i=1;i<=columnCount;i++){
                    
                    switch (i) {
                        case 1:
                            row.add("n"+rs.getString(i));
                            break;
                        case 2://row.add(rs2.getString("farmername"));
                            row.add(rs.getString(i));
                            break;
                        case 3:
                            row.add(rs2.getString("farmername"));
                            break;
                        case 4:
                            row.add(rs2.getString("village"));
                            break;
                        case 5:
                            row.add(rs.getString(3));
                            break;
                        case 6:
                            row.add(rs.getString(4));
                            break;
                        case 7:
                            row.add(rs.getString(6));
                            break;
                        case 8:
                            row.add(rs.getString(5));
                            break;
                        case 9:
                            row.add(rs.getString(7));
                            break;
                        case 10:
//                            if(rs.getString(8).equals("0.0000")){
//                                row.add("");
//                            }else{
//                                row.add(rs.getString(8));
//                            }
                            row.add(rs.getString(8));
                            break;
                        case 11:
//                            if(rs.getString(9).equals("0.0000")){
//                                row.add("");
//                            }else{
//                                row.add(rs.getString(9));
//                            }
                            row.add(rs.getString(9));
                            break;
                        case 12:
//                            if(rs.getString(10).equals("0.0000")){
//                                row.add("");
//                            }else{
//                                row.add(rs.getString(10));
//                            }
                            row.add(rs.getString(10));
                            break;
                        case 13:
                            if(rs.getString(11).equals("1")){
                                row.add("Yes");
                            }else{
                                row.add("No");
                            }   break;

                    }
                    
                }
                data.add(row);
            }
            
            model = (DefaultTableModel) counterJTable.getModel();
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
        counterJTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        counterJTableSearchTF = new javax.swing.JTextField();
        counterReportBTN = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        counterJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(counterJTable);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\sadik\\Desktop\\icon\\if_search_173095.png")); // NOI18N
        jLabel14.setText("Search");

        counterJTableSearchTF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        counterJTableSearchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                counterJTableSearchTFKeyReleased(evt);
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
        jLabel2.setText("* To generate Excel Report file close old report Excel file first, if it's already open!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(counterReportBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 644, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(64, 64, 64)
                .addComponent(counterJTableSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(counterJTableSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(counterReportBTN))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void counterJTableSearchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_counterJTableSearchTFKeyReleased
        model = (DefaultTableModel)counterJTable.getModel();
        String search = counterJTableSearchTF.getText();//.toLowerCase();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
        counterJTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_counterJTableSearchTFKeyReleased

    private void counterReportBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counterReportBTNActionPerformed
//        double tWWithBag=0,tWWithoutBag=0;
//        int totalBag=0;
        model = (DefaultTableModel) counterJTable.getModel();
        RowSorter rs = counterJTable.getRowSorter();
        int row = model.getRowCount();
        if(rs!=null){
            row=rs.getViewRowCount();
        }
        
        File file1 = new File("c:\\mandiReport");
        if(!file1.exists()){
            file1.mkdir();

        }
        File file = new File("c:\\mandiReport\\importCounterReport.xls");
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
            JOptionPane.showMessageDialog(null,"File saved in c:\\mandiReport\\importCounterReport.xls");
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
            java.util.logging.Logger.getLogger(UserImportPopUpTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserImportPopUpTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserImportPopUpTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserImportPopUpTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserImportPopUpTable dialog = new UserImportPopUpTable(new javax.swing.JFrame(), true,cntr);
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
    private javax.swing.JTable counterJTable;
    private javax.swing.JTextField counterJTableSearchTF;
    private javax.swing.JButton counterReportBTN;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
