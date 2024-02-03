
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
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
public class ImportPopUp extends javax.swing.JDialog {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    AdminControl ac;
    DefaultTableModel model;
    public ImportPopUp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        con = DBConnection.getConnection();
        initComponents();
        generatePopUpTable();
        ac = (AdminControl)parent;
        //sortTable();
    }
    
    public void sortTable(){
        importPopUpTable.getRowSorter().addRowSorterListener(new RowSorterListener(){
            public void sorterChanged(RowSorterEvent e){
                totalTrolleyTF.setText(String.valueOf(importPopUpTable.getRowSorter().getViewRowCount()));
//                double totalNetWeight=0;
//                int sumRow;
//                model = (DefaultTableModel) importPopUpTable.getModel();
//                RowSorter rs=importPopUpTable.getRowSorter();
//                int row=model.getRowCount();
//                if(null!=rs){
//                    row=rs.getViewRowCount();
//                }
//                try {
//                int r=0;
//                for(int i=0;i<row;i++){
//                    for(int j=0;j<model.getColumnCount();j++){
//                        if(null==model.getValueAt(i,j)){
//                            bw.write(""+"\t");
//                        }else{
//                            if(null==rs){
//                                bw.write(model.getValueAt(i,j)+"\t");
//                            }
//                            else{
//                                r = rs.convertRowIndexToModel(i);
//                                bw.write(model.getValueAt(r,j)+"\t");
//                            }
//                        }
//                    }
//                    if(r==0){
//                        totalNetWeight+=Double.parseDouble(model.getValueAt(i,11).toString());
//                    
//                    }else{
//                        totalNetWeight+=Double.parseDouble(model.getValueAt(r,11).toString());
//                    
//                    }
//                    bw.write("\n");
//                }   
//                bw.write("\n");
//                sumRow=model.getColumnCount();
//                for(int i=0;i<sumRow;i++){
//                    if(i==10){
//                        bw.write("Total Net Weight");
//                    }else if(i==11){
//                        bw.write(totalNetWeight+"\n");
//                    }
//                    bw.write("\t");
//                }   
//                bw.close();
//                JOptionPane.showMessageDialog(null,"FILE SAVED IN c:\\mandiReport\\importReport.xls");
//            }catch (IOException ex) {
//                Logger.getLogger(ImportPopUp.class.getName()).log(Level.SEVERE, null, ex);
//            }
           }
         }
                
        );
    }
    public void generatePopUpTable(){
                
        ResultSetMetaData rsmt;
        int columnCount;
        
        String sql = "select * from counter2";
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            rsmt = rs.getMetaData();
            columnCount = rsmt.getColumnCount();
            Vector<String> column = new Vector<String>();
            
            column.addElement("Token");
            column.addElement("Farmer Reg.");
            column.addElement("Name");
            column.addElement("Village");
            column.addElement("Tractor");
            column.addElement("Trolley Colour");
            column.addElement("RST");
            column.addElement("Date of Entry");
            column.addElement("Anubandh Kr.");
            column.addElement("Gross Weight");
            column.addElement("Tare Weight");
            column.addElement("Net Weight");
            column.addElement("Unload Verified");
            
            
            
            

            Vector data = new Vector();
            Vector row = new Vector();
            float sum = 0;
            while(rs.next()){
                String sql2="select * from counter1 where regno =?";
                PreparedStatement pst2=con.prepareStatement(sql2);
                pst2.setString(1,rs.getString("farmer_reg"));
                ResultSet rs2=pst2.executeQuery();
                rs2.next();
                row = new Vector(columnCount+2);
                for(int i=1;i<=columnCount+2;i++){
                    
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
                            row.add(rs.getString(5));
                            break;
                        case 8:
                            row.add(rs.getString(6));
                            break;
                        case 9:
                            row.add(rs.getString(7));
                            break;
                        case 10:
                            row.add(rs.getString(8));
                            break;
                        case 11:
                            row.add(rs.getString(9));
                            break;
                        case 12:
                            row.add(rs.getString(10));
                            sum += Float.valueOf((float)rs.getDouble(10));
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
            model = (DefaultTableModel) importPopUpTable.getModel();
            model.setDataVector(data, column);
            totalTrolleyTF.setText(String.valueOf(data.size()));
            totalNetWTF.setText(String.valueOf(sum));
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
        importPopUpTable = new javax.swing.JTable();
        importReportGenerateBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        importTableSearchField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        totalTrolleyTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        totalNetWTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        importPopUpTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        importPopUpTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importPopUpTableMouseClicked(evt);
            }
        });
        importPopUpTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                importPopUpTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                importPopUpTableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                importPopUpTableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(importPopUpTable);

        importReportGenerateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        importReportGenerateBtn.setText("Generate Report");
        importReportGenerateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importReportGenerateBtnActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\sadik\\Desktop\\icon\\if_search_173095.png")); // NOI18N
        jLabel14.setText("Search");

        importTableSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importTableSearchFieldActionPerformed(evt);
            }
        });
        importTableSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                importTableSearchFieldKeyReleased(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("* To generate Excel Report file close old report Excel file first, if it's already open!!!");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Total Trolley");

        totalTrolleyTF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Total Of Net Weight");

        totalNetWTF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(importReportGenerateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(totalTrolleyTF, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(totalNetWTF, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(30, 30, 30)
                .addComponent(importTableSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importReportGenerateBtn)
                    .addComponent(importTableSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(totalNetWTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalTrolleyTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void importPopUpTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importPopUpTableMouseClicked

       int rowIndex=importPopUpTable.getSelectedRow(); 
       if( importPopUpTable.getRowSorter()!=null){
           rowIndex=importPopUpTable.getRowSorter().convertRowIndexToModel(rowIndex);
       }
       String s1 = model.getValueAt(rowIndex,0)==null?"":model.getValueAt(rowIndex,0).toString();
       String s2 = model.getValueAt(rowIndex,1)==null?"":model.getValueAt(rowIndex,1).toString();
       String s3 = model.getValueAt(rowIndex,2)==null?"":model.getValueAt(rowIndex,2).toString();
       String s4 = model.getValueAt(rowIndex,3)==null?"":model.getValueAt(rowIndex,3).toString();
       String s5 = model.getValueAt(rowIndex,4)==null?"":model.getValueAt(rowIndex,4).toString();
       String s6 = model.getValueAt(rowIndex,5)==null?"":model.getValueAt(rowIndex,5).toString();
       String s7 = model.getValueAt(rowIndex,6)==null?"":model.getValueAt(rowIndex,6).toString();
       String s8 = model.getValueAt(rowIndex,7)==null?"":model.getValueAt(rowIndex,7).toString();
       String s9 = model.getValueAt(rowIndex,8)==null?"":model.getValueAt(rowIndex,8).toString();
       String s10 = model.getValueAt(rowIndex,9)==null?"":model.getValueAt(rowIndex,9).toString();
       String s11 = model.getValueAt(rowIndex,10)==null?"":model.getValueAt(rowIndex,10).toString();
       String s12 = model.getValueAt(rowIndex,11)==null?"":model.getValueAt(rowIndex,11).toString();
       String s13 = model.getValueAt(rowIndex,12)==null?"":model.getValueAt(rowIndex,12).toString();
        ac.getImportPopUp(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13);  
        
        importPopUpTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    dispose();
                }
            }
        });
        
    }//GEN-LAST:event_importPopUpTableMouseClicked

    private void importPopUpTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importPopUpTableKeyReleased
        
    }//GEN-LAST:event_importPopUpTableKeyReleased

    private void importPopUpTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importPopUpTableKeyPressed
        model = (DefaultTableModel) importPopUpTable.getModel();
        int rowIndex = importPopUpTable.getSelectedRow();
        if( importPopUpTable.getRowSorter()!=null){
           rowIndex=importPopUpTable.getRowSorter().convertRowIndexToModel(rowIndex);
       }
       String s1 = model.getValueAt(rowIndex,0)==null?"":model.getValueAt(rowIndex,0).toString();
       String s2 = model.getValueAt(rowIndex,1)==null?"":model.getValueAt(rowIndex,1).toString();
       String s3 = model.getValueAt(rowIndex,2)==null?"":model.getValueAt(rowIndex,2).toString();
       String s4 = model.getValueAt(rowIndex,3)==null?"":model.getValueAt(rowIndex,3).toString();
       String s5 = model.getValueAt(rowIndex,4)==null?"":model.getValueAt(rowIndex,4).toString();
       String s6 = model.getValueAt(rowIndex,5)==null?"":model.getValueAt(rowIndex,5).toString();
       String s7 = model.getValueAt(rowIndex,6)==null?"":model.getValueAt(rowIndex,6).toString();
       String s8 = model.getValueAt(rowIndex,7)==null?"":model.getValueAt(rowIndex,7).toString();
       String s9 = model.getValueAt(rowIndex,8)==null?"":model.getValueAt(rowIndex,8).toString();
       String s10 = model.getValueAt(rowIndex,9)==null?"":model.getValueAt(rowIndex,9).toString();
       String s11 = model.getValueAt(rowIndex,10)==null?"":model.getValueAt(rowIndex,10).toString();
       String s12 = model.getValueAt(rowIndex,11)==null?"":model.getValueAt(rowIndex,11).toString();
       String s13 = model.getValueAt(rowIndex,12)==null?"":model.getValueAt(rowIndex,12).toString();
       ac.getImportPopUp(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13);  
       
        if(evt.getKeyCode()==10){
            dispose();
        }
    }//GEN-LAST:event_importPopUpTableKeyPressed

    private void importPopUpTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importPopUpTableKeyTyped
        
    }//GEN-LAST:event_importPopUpTableKeyTyped

    private void importReportGenerateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importReportGenerateBtnActionPerformed
        double totalNetWeight=0;
        int sumRow;
        model = (DefaultTableModel) importPopUpTable.getModel();
        RowSorter rs=importPopUpTable.getRowSorter();
        int row=model.getRowCount();
        if(null!=rs){
            row=rs.getViewRowCount();
        }
        File file1 = new File("c:\\mandiReport");
        if(!file1.exists()){
            file1.mkdir();
                 
        }
        File file = new File("c:\\mandiReport\\importReport.xls");
        
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
                if(r==0){
                    Object s=model.getValueAt(i,11);
                    if(s!=null)
                        totalNetWeight+=Double.parseDouble(s.toString());
                    
                }else{
                    Object s=model.getValueAt(r,11);
                    if(s!=null)
                        totalNetWeight+=Double.parseDouble(s.toString());
                    
                }
                bw.write("\n");
            }
            bw.write("\n");
            sumRow=model.getColumnCount();
            for(int i=0;i<sumRow;i++){
                if(i==3){
                    bw.write("Total Trolley");
                }
                else if(i==4){
                    bw.write(String.valueOf(row));
                }
                if(i==10){
                    bw.write("Total Net Weight");
                }else if(i==11){
                    bw.write(totalNetWeight+"\n");
                }
                bw.write("\t");
            }
            bw.close();
            JOptionPane.showMessageDialog(null,"FILE SAVED IN c:\\mandiReport\\importReport.xls");
        }catch (IOException ex) {
            Logger.getLogger(ImportPopUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_importReportGenerateBtnActionPerformed

    private void importTableSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_importTableSearchFieldKeyReleased
       model = (DefaultTableModel)importPopUpTable.getModel();
       String search = importTableSearchField.getText();//.toLowerCase();
       TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model); 
       importPopUpTable.setRowSorter(trs);
       trs.setRowFilter(RowFilter.regexFilter(search));
       
       calculateTotal(trs);
    }//GEN-LAST:event_importTableSearchFieldKeyReleased

    private void calculateTotal(TableRowSorter trs){
        totalTrolleyTF.setText(String.valueOf(trs.getViewRowCount()));
        double sum = 0;
        for(int i=0;i<trs.getViewRowCount();i++){
            int r = trs.convertRowIndexToModel(i);
            sum += Double.valueOf((String)importPopUpTable.getModel().getValueAt(r,11));
            
        }
        totalNetWTF.setText(String.valueOf((float)sum));
    }
    private void importTableSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importTableSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_importTableSearchFieldActionPerformed

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
            java.util.logging.Logger.getLogger(ImportPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportPopUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ImportPopUp dialog = new ImportPopUp(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable importPopUpTable;
    private javax.swing.JButton importReportGenerateBtn;
    private javax.swing.JTextField importTableSearchField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField totalNetWTF;
    private javax.swing.JTextField totalTrolleyTF;
    // End of variables declaration//GEN-END:variables
}
