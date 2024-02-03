
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowFilter;
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
public class AdminControl extends javax.swing.JFrame {

    /**
     * Creates new form AdminControl
     */
    Connection con;
    PreparedStatement pst;
    ResultSet rs,rs1;
    final int counter;
    final javax.swing.JFrame login;
    
    public AdminControl(javax.swing.JFrame login,int counter) {
        con=DBConnection.getConnection();
        this.login=login;
        this.counter=counter;
        //setContentPane(new JLabel(new javax.swing.ImageIcon("wheat_field3.jpg")));
        initComponents();
        configureCounter();
        
        
    }
    public AdminControl() {
        con=DBConnection.getConnection();
        counter=0;
        login=this; //Useless code
        //setContentPane(new JLabel(new javax.swing.ImageIcon("wheat_field3.jpg")));
        initComponents();
        configureCounter();
        
    }

    private void configureCounter(){
        
        
        
        if(0==counter){
            btnSearchFarmer.setEnabled(true);
            btnResetFarmer.setEnabled(true);
            btnUpdateFarmer.setEnabled(true);
            btnRegisterFarmer.setEnabled(true);
            btnSearchData.setEnabled(true);
            btnResetData.setEnabled(true);
            btnUpdateData.setEnabled(true);
            btnGenerateToken.setEnabled(true);
            btnSaveData.setEnabled(true);
            btnVerifyUnload.setEnabled(true);
            userManagementPanel.setEnabled(true);
            
            
            counter3SearchBtn.setEnabled(true);
            counter3SaveBtn.setEnabled(true);
            counter3UpdateBtn.setEnabled(true);
            counter3ResetBtn.setEnabled(true);
            btnPrintImportReceipt.setEnabled(true);
            
            counter2SearchBtn.setEnabled(true);
            counter2SaveBtn.setEnabled(true);
            counter2UpdateBtn.setEnabled(true);
            counter2ResetBtn.setEnabled(true);
            
            counter2SearchBtn.setEnabled(true);
            counter2SaveBtn.setEnabled(true);
            counter2UpdateBtn.setEnabled(true);
            counter2ResetBtn.setEnabled(true);
            
            entryTableBtn.setEnabled(true);
            importAllRecordBtn.setEnabled(true);
            loadedTruckWeight.setEnabled(true);
            transportNetWeight.setEnabled(true);
            transportNetWeightWithoutBag.setEnabled(true);
            
            driverNameField.setEnabled(true);
            builtyNumber.setEnabled(true);
            numberOfBagsField.setEnabled(true);
            bagType1.setEnabled(true);
            bagType2.setEnabled(true);
            loadedVerifyCheckBox.setEnabled(true);
            
            tokenNumber.setEnabled(true);
            dateField.setEnabled(true);
            tractorName.setEnabled(true);
            rstField.setEnabled(true);
            loadedTractorField.setEnabled(true);
            netGoodsWeightField.setEnabled(true);
            selectTractorCMB.setEnabled(true);
            trolleyColourCMB.setEnabled(true);
            trolleyColour.setEnabled(true);
            unloadedTractorWeightField.setEnabled(true);
            anubandhNumber.setEnabled(true);
            
            unloadedTruckWeight.setEnabled(true);
            truckNumberField.setEnabled(true);
            transportDateField.setEnabled(true);
            
            jLabel47.setVisible(false);
            labourGroup.setVisible(false);
            exportingPlace.setVisible(false);
            jLabel25.setVisible(false);
            builtyNumber.setVisible(false);
            jLabel46.setVisible(false);
        }
        else if(1==counter){
            parentTab.setEnabledAt(2, false);
            
            btnSearchFarmer.setEnabled(true);
            btnResetFarmer.setEnabled(true);
            btnRegisterFarmer.setEnabled(true);
            btnGenerateToken.setEnabled(true);
            lblUser.setText("Counter 1");
            btnPrintImportReceipt.setEnabled(true);
            btnUpdateFarmer.setEnabled(true);
            importCounterWorkBTN.setEnabled(true);
            btnSearchData.setEnabled(true);
            btnResetData.setEnabled(true);
            btnSaveData.setEnabled(true);
            
            tokenNumber.setEnabled(true);
            dateField.setEnabled(true);
            tractorName.setEnabled(true);
            trolleyColour.setEnabled(true);
            trolleyColourCMB.setEnabled(true);
            selectTractorCMB.setEnabled(true);
            
            jLabel47.setVisible(false);
            labourGroup.setVisible(false);
            exportingPlace.setVisible(false);
            jLabel25.setVisible(false);
            builtyNumber.setVisible(false);
            jLabel46.setVisible(false);
            
        }
        else if(2==counter){
            parentTab.setEnabledAt(2, false);
            
            btnSearchData.setEnabled(true);
            btnResetData.setEnabled(true);
            btnUpdateData.setEnabled(true);
            btnSaveData.setEnabled(true);
            lblUser.setText("Counter 2");
            btnSearchFarmer.setEnabled(true);
            
            importCounterWorkBTN.setEnabled(true);
            counter3SearchBtn.setEnabled(true);
            
            counter3ResetBtn.setEnabled(true);
            
            counter2SearchBtn.setEnabled(true);
            counter2ResetBtn.setEnabled(true);
            exportCounterWorkBTN.setEnabled(true);
            counter2SaveBtn.setEnabled(true);
            counter2UpdateBtn.setEnabled(true);
            
            tokenNumber.setEnabled(true);
            rstField.setEnabled(true);
            loadedTractorField.setEnabled(true);
            unloadedTractorWeightField.setEnabled(true);
            
            transportDateField.setEnabled(true);
            truckNumberField.setEnabled(true);
            unloadedTruckWeight.setEnabled(true);
            
            loadedTruckWeight.setEnabled(true);
            //transportNetWeight.setEnabled(true);
            //transportNetWeightWithoutBag.setEnabled(true);
            jLabel47.setVisible(false);
            labourGroup.setVisible(false);
            exportingPlace.setVisible(false);
            jLabel25.setVisible(false);
            builtyNumber.setVisible(false);
            jLabel46.setVisible(false);
        }
        else if(3==counter){
            parentTab.setEnabledAt(2, false);
            
            
            btnVerifyUnload.setEnabled(true);
            lblUser.setText("Counter 3");
            btnSearchFarmer.setEnabled(true);
            btnSearchData.setEnabled(true);
            counter3SearchBtn.setEnabled(true);
            counter3ResetBtn.setEnabled(true);
            //counter2SearchBtn.setEnabled(true);
            
            btnSaveData.setEnabled(true);
            
            btnResetData.setEnabled(true);
            //counter3UpdateBtn.setEnabled(true);
            //counter2ResetBtn.setEnabled(true);
            btnUpdateData.setEnabled(true);
            exportCounterWorkBTN.setEnabled(true);
            importCounterWorkBTN.setEnabled(true);
            
            counter3SaveBtn.setEnabled(true);
            counter3UpdateBtn.setEnabled(true);
//builtyNumber.setEnabled(true);
            driverNameField.setEnabled(true);
            numberOfBagsField.setEnabled(true);
            bagType1.setEnabled(true);
            bagType2.setEnabled(true);
            loadedVerifyCheckBox.setEnabled(true);
            
            transportDateField.setEnabled(true);
            truckNumberField.setEnabled(true);
            unloadedTruckWeight.setEnabled(true);
            
            anubandhNumber.setEnabled(true);
            tokenNumber.setEnabled(true);
            unloadedTractorWeightField.setEnabled(false);
            
            jLabel47.setVisible(false);
            labourGroup.setVisible(false);
            exportingPlace.setVisible(false);
            jLabel25.setVisible(false);
            builtyNumber.setVisible(false);
            jLabel46.setVisible(false);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        parentTab = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        regNumber = new javax.swing.JTextField();
        btnSearchFarmer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        farmerName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        village = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tractorName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        trolleyColour = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        unloadedTractorWeightField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        netGoodsWeightField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        loadedTractorField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rstField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dateField = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        verifyCheckBox = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tokenNumber = new javax.swing.JTextField();
        btnResetFarmer = new javax.swing.JButton();
        btnUpdateFarmer = new javax.swing.JButton();
        btnRegisterFarmer = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        btnSearchData = new javax.swing.JButton();
        btnGenerateToken = new javax.swing.JButton();
        btnResetData = new javax.swing.JButton();
        btnUpdateData = new javax.swing.JButton();
        btnSaveData = new javax.swing.JButton();
        btnVerifyUnload = new javax.swing.JButton();
        importAllRecordBtn = new javax.swing.JButton();
        btnPrintImportReceipt = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        selectTractorCMB = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        anubandhNumber = new javax.swing.JTextField();
        trolleyColourCMB = new javax.swing.JComboBox<>();
        importCounterWorkBTN = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        driverNameField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        truckNumberField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        transportDateField = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        loadedTruckWeight = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        transportNetWeight = new javax.swing.JTextField();
        unloadedTruckWeight = new javax.swing.JTextField();
        transportRSTNumber = new javax.swing.JTextField();
        exportingPlace = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        numberOfBagsField = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        bagType1 = new javax.swing.JRadioButton();
        bagType2 = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        loadedVerifyCheckBox = new javax.swing.JCheckBox();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        counter3SearchBtn = new javax.swing.JButton();
        counter3ResetBtn = new javax.swing.JButton();
        counter3UpdateBtn = new javax.swing.JButton();
        counter3SaveBtn = new javax.swing.JButton();
        counter2SearchBtn = new javax.swing.JButton();
        counter2SaveBtn = new javax.swing.JButton();
        counter2UpdateBtn = new javax.swing.JButton();
        counter2ResetBtn = new javax.swing.JButton();
        entryTableBtn = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        transportNetWeightWithoutBag = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        builtyNumber = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        labourGroup = new javax.swing.JTextField();
        exportCounterWorkBTN = new javax.swing.JButton();
        userManagementPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        accessTypeCombo = new javax.swing.JComboBox<>();
        userSaveBtn = new javax.swing.JButton();
        userResetBtn = new javax.swing.JButton();
        userDeleteBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        userManagementTable = new javax.swing.JTable();
        userUpdateBtn1 = new javax.swing.JButton();
        userFirstName = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        userLastName = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        userId = new javax.swing.JTextField();
        userTableSearchField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        userUpdateBtn2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        userPassword = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 730));
        setPreferredSize(new java.awt.Dimension(1280, 730));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Wheat Collection"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setToolTipText("");

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUser.setText("Admin");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_user-logout_53674.png"))); // NOI18N
        jButton5.setText("Logout");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Lucida Calligraphy", 0, 36)); // NOI18N
        jLabel38.setText("Narmadamchal Vipdan Samiti Hoshangabad");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Authorised Accesses for");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblUser)))
                .addGap(18, 18, 18)
                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(62, 62, 62)
                .addComponent(jButton5)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUser)))))
                .addContainerGap())
        );

        parentTab.setMinimumSize(new java.awt.Dimension(1305, 518));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Registration Number");

        regNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnSearchFarmer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearchFarmer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_search_173095.png"))); // NOI18N
        btnSearchFarmer.setText("Search");
        btnSearchFarmer.setEnabled(false);
        btnSearchFarmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFarmerActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Farmer Name");

        farmerName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Village");

        village.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tractor");

        tractorName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tractorName.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Trolley colour");

        trolleyColour.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        trolleyColour.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Tare Weight");

        unloadedTractorWeightField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        unloadedTractorWeightField.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Net Weight");

        netGoodsWeightField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        netGoodsWeightField.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Gross Weight");

        loadedTractorField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loadedTractorField.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("RST No.");

        rstField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rstField.setEnabled(false);
        rstField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rstFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Date");

        dateField.setDateFormatString("dd/MM/yyyy");
        dateField.setEnabled(false);
        dateField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Unloading Verified");
        jLabel10.setOpaque(true);

        verifyCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        verifyCheckBox.setEnabled(false);

        jSeparator2.setMinimumSize(new java.awt.Dimension(50, 10));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 10));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 0, 0));
        jLabel11.setText("Data Record");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 0, 0));
        jLabel12.setText("Farmer Registration Detail");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Token Number");

        tokenNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tokenNumber.setEnabled(false);

        btnResetFarmer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResetFarmer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_counter_reset_16187.png"))); // NOI18N
        btnResetFarmer.setText("Reset");
        btnResetFarmer.setEnabled(false);
        btnResetFarmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetFarmerActionPerformed(evt);
            }
        });

        btnUpdateFarmer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateFarmer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_db_update_3213.png"))); // NOI18N
        btnUpdateFarmer.setText("Update");
        btnUpdateFarmer.setEnabled(false);
        btnUpdateFarmer.setMaximumSize(new java.awt.Dimension(93, 35));
        btnUpdateFarmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateFarmerActionPerformed(evt);
            }
        });

        btnRegisterFarmer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegisterFarmer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_registration1_(add)_16x16_9934.png"))); // NOI18N
        btnRegisterFarmer.setText("Register");
        btnRegisterFarmer.setEnabled(false);
        btnRegisterFarmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterFarmerActionPerformed(evt);
            }
        });

        btnSearchData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearchData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_search_173095.png"))); // NOI18N
        btnSearchData.setText("Search");
        btnSearchData.setEnabled(false);
        btnSearchData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDataActionPerformed(evt);
            }
        });

        btnGenerateToken.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGenerateToken.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_Cinema_Tickets1_2315959.png"))); // NOI18N
        btnGenerateToken.setText("Generate Token");
        btnGenerateToken.setEnabled(false);
        btnGenerateToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateTokenActionPerformed(evt);
            }
        });

        btnResetData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResetData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_counter_reset_16187.png"))); // NOI18N
        btnResetData.setText("Reset");
        btnResetData.setEnabled(false);
        btnResetData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetDataActionPerformed(evt);
            }
        });

        btnUpdateData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdateData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_db_update_3213.png"))); // NOI18N
        btnUpdateData.setText("Update");
        btnUpdateData.setEnabled(false);
        btnUpdateData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDataActionPerformed(evt);
            }
        });

        btnSaveData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSaveData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_save_87464.png"))); // NOI18N
        btnSaveData.setText("Save");
        btnSaveData.setEnabled(false);
        btnSaveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDataActionPerformed(evt);
            }
        });

        btnVerifyUnload.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVerifyUnload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_interface-54_809272.png"))); // NOI18N
        btnVerifyUnload.setText("Toggle Verify");
        btnVerifyUnload.setEnabled(false);
        btnVerifyUnload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyUnloadActionPerformed(evt);
            }
        });

        importAllRecordBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        importAllRecordBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_stock_show-all_24442.png"))); // NOI18N
        importAllRecordBtn.setText("All Entry");
        importAllRecordBtn.setEnabled(false);
        importAllRecordBtn.setPreferredSize(new java.awt.Dimension(97, 35));
        importAllRecordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importAllRecordBtnActionPerformed(evt);
            }
        });

        btnPrintImportReceipt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPrintImportReceipt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_print_44993.png"))); // NOI18N
        btnPrintImportReceipt.setText("Print Receipt");
        btnPrintImportReceipt.setEnabled(false);
        btnPrintImportReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintImportReceiptActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setText("kg");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setText("kg");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel42.setText("kg");

        selectTractorCMB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT TRACTOR", "Balwan", "Deutz", "Eicher", "Escort", "Farmtrac", "Hindustan", "HMT", "Indo Farm", "John Deere", "Kubota", "Mahindra", "Massey", "New Holland", "Powertrac", "Sonalika", "Swaraj", "Other" }));
        selectTractorCMB.setEnabled(false);
        selectTractorCMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTractorCMBActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Anubandh kr.");

        anubandhNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        anubandhNumber.setEnabled(false);

        trolleyColourCMB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT COLOUR", "Black", "Blue", "Brown", "Gray", "Green", "No Colour", "Orange", "Red", "Silver", "Yellow", "Other" }));
        trolleyColourCMB.setEnabled(false);
        trolleyColourCMB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trolleyColourCMBActionPerformed(evt);
            }
        });

        importCounterWorkBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        importCounterWorkBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_20_61484.png"))); // NOI18N
        importCounterWorkBTN.setText("Counter Work");
        importCounterWorkBTN.setEnabled(false);
        importCounterWorkBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importCounterWorkBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(173, 173, 173)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(anubandhNumber)
                                    .addComponent(rstField, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(netGoodsWeightField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel40))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(174, 174, 174))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(selectTractorCMB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tokenNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(tractorName))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(verifyCheckBox))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnVerifyUnload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(unloadedTractorWeightField, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loadedTractorField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trolleyColourCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(222, 222, 222)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(trolleyColour, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel41))
                        .addGap(123, 123, 123))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(142, 142, 142)
                                .addComponent(regNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184)
                                .addComponent(farmerName, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(185, 185, 185)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(village, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel12)
                                .addGap(84, 84, 84)
                                .addComponent(btnSearchFarmer)
                                .addGap(30, 30, 30)
                                .addComponent(btnPrintImportReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnResetFarmer)
                                .addGap(30, 30, 30)
                                .addComponent(btnUpdateFarmer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnRegisterFarmer)
                                .addGap(44, 44, 44)
                                .addComponent(importCounterWorkBTN))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel11)
                                .addGap(181, 181, 181)
                                .addComponent(btnSearchData)
                                .addGap(30, 30, 30)
                                .addComponent(btnGenerateToken)
                                .addGap(30, 30, 30)
                                .addComponent(btnResetData)
                                .addGap(30, 30, 30)
                                .addComponent(btnUpdateData)
                                .addGap(30, 30, 30)
                                .addComponent(btnSaveData, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(importAllRecordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSearchFarmer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnPrintImportReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnResetFarmer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(importCounterWorkBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(btnRegisterFarmer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdateFarmer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(regNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(village, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(farmerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdateData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnResetData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGenerateToken, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearchData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(importAllRecordBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(btnSaveData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tokenNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tractorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(selectTractorCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(trolleyColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trolleyColourCMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadedTractorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(rstField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unloadedTractorWeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(netGoodsWeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(anubandhNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVerifyUnload, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verifyCheckBox))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        parentTab.addTab("Import", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setOpaque(false);

        driverNameField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        driverNameField.setEnabled(false);
        driverNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driverNameFieldActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Driver Name");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Truck Number");

        truckNumberField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        truckNumberField.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Date of Entry");

        transportDateField.setDateFormatString("dd/MM/yyyy");
        transportDateField.setEnabled(false);
        transportDateField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Gross Weight");

        loadedTruckWeight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loadedTruckWeight.setEnabled(false);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Net Weight with bag");

        transportNetWeight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        transportNetWeight.setEnabled(false);

        unloadedTruckWeight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        unloadedTruckWeight.setEnabled(false);

        transportRSTNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        exportingPlace.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exportingPlace.setEnabled(false);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Exporting Place");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("RST Number");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Tare Weight");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Number Of Bags");

        numberOfBagsField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        numberOfBagsField.setEnabled(false);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Bags Type");

        bagType1.setText("Jute");
        bagType1.setEnabled(false);
        bagType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagType1ActionPerformed(evt);
            }
        });

        bagType2.setText("PP");
        bagType2.setEnabled(false);
        bagType2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bagType2ActionPerformed(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(255, 0, 0));
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Loaded Verify");
        jLabel30.setOpaque(true);

        loadedVerifyCheckBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loadedVerifyCheckBox.setText("Loaded ");
        loadedVerifyCheckBox.setEnabled(false);
        loadedVerifyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadedVerifyCheckBoxActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 0, 0));
        jLabel35.setText("Counter 3");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 0, 0));
        jLabel36.setText("Counter 2");

        counter3SearchBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        counter3SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_search_173095.png"))); // NOI18N
        counter3SearchBtn.setText("Search");
        counter3SearchBtn.setEnabled(false);
        counter3SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counter3SearchBtnActionPerformed(evt);
            }
        });

        counter3ResetBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        counter3ResetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_counter_reset_16187.png"))); // NOI18N
        counter3ResetBtn.setText("Reset");
        counter3ResetBtn.setEnabled(false);
        counter3ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counter3ResetBtnActionPerformed(evt);
            }
        });

        counter3UpdateBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        counter3UpdateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_db_update_3213.png"))); // NOI18N
        counter3UpdateBtn.setText("Update");
        counter3UpdateBtn.setEnabled(false);
        counter3UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counter3UpdateBtnActionPerformed(evt);
            }
        });

        counter3SaveBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        counter3SaveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_save_87464.png"))); // NOI18N
        counter3SaveBtn.setText("Save");
        counter3SaveBtn.setEnabled(false);
        counter3SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counter3SaveBtnActionPerformed(evt);
            }
        });

        counter2SearchBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        counter2SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_search_173095.png"))); // NOI18N
        counter2SearchBtn.setText("Search");
        counter2SearchBtn.setEnabled(false);
        counter2SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counter2SearchBtnActionPerformed(evt);
            }
        });

        counter2SaveBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        counter2SaveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_save_87464.png"))); // NOI18N
        counter2SaveBtn.setText("Save");
        counter2SaveBtn.setEnabled(false);
        counter2SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counter2SaveBtnActionPerformed(evt);
            }
        });

        counter2UpdateBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        counter2UpdateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_db_update_3213.png"))); // NOI18N
        counter2UpdateBtn.setText("Update");
        counter2UpdateBtn.setEnabled(false);
        counter2UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counter2UpdateBtnActionPerformed(evt);
            }
        });

        counter2ResetBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        counter2ResetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_counter_reset_16187.png"))); // NOI18N
        counter2ResetBtn.setText("Reset");
        counter2ResetBtn.setEnabled(false);
        counter2ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                counter2ResetBtnActionPerformed(evt);
            }
        });

        entryTableBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        entryTableBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_stock_show-all_24442.png"))); // NOI18N
        entryTableBtn.setText("All Entry");
        entryTableBtn.setEnabled(false);
        entryTableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryTableBtnActionPerformed(evt);
            }
        });

        jSeparator12.setPreferredSize(new java.awt.Dimension(2147483647, 2));

        transportNetWeightWithoutBag.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        transportNetWeightWithoutBag.setEnabled(false);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Net Weight without bag");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setText("kg");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setText("kg");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setText("kg");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setText("kg");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Builty Number");

        builtyNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        builtyNumber.setEnabled(false);

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Labour Group");

        labourGroup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labourGroup.setEnabled(false);

        exportCounterWorkBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exportCounterWorkBTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_20_61484.png"))); // NOI18N
        exportCounterWorkBTN.setText("Counter Work");
        exportCounterWorkBTN.setEnabled(false);
        exportCounterWorkBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportCounterWorkBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator6)
            .addComponent(jSeparator12, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
            .addComponent(jSeparator14)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel35)
                        .addGap(128, 128, 128)
                        .addComponent(counter3SearchBtn)
                        .addGap(50, 50, 50)
                        .addComponent(counter3SaveBtn)
                        .addGap(50, 50, 50)
                        .addComponent(counter3UpdateBtn)
                        .addGap(50, 50, 50)
                        .addComponent(counter3ResetBtn)
                        .addGap(50, 50, 50)
                        .addComponent(exportCounterWorkBTN))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(110, 110, 110)
                                .addComponent(truckNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(120, 120, 120)
                                .addComponent(transportRSTNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(198, 198, 198)
                                    .addComponent(numberOfBagsField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel28)))
                        .addGap(107, 107, 107)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(102, 102, 102)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(unloadedTruckWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel45))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(bagType1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bagType2))
                                        .addComponent(transportDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel46)))
                            .addComponent(jLabel29))
                        .addGap(99, 99, 99)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(driverNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(builtyNumber)
                            .addComponent(loadedVerifyCheckBox)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel36)
                        .addGap(132, 132, 132)
                        .addComponent(counter2SearchBtn)
                        .addGap(50, 50, 50)
                        .addComponent(counter2SaveBtn)
                        .addGap(50, 50, 50)
                        .addComponent(counter2UpdateBtn)
                        .addGap(50, 50, 50)
                        .addComponent(counter2ResetBtn)
                        .addGap(50, 50, 50)
                        .addComponent(entryTableBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(101, 101, 101)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loadedTruckWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(exportingPlace))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel44)
                .addGap(86, 86, 86)
                .addComponent(jLabel24)
                .addGap(71, 71, 71)
                .addComponent(transportNetWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(transportNetWeightWithoutBag, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel39))
                    .addComponent(labourGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
            .addComponent(jSeparator13)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(counter3SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(counter3SaveBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(counter3UpdateBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(counter3ResetBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel35)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(exportCounterWorkBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel20)
                                    .addComponent(driverNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(transportRSTNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel26))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel27)
                                        .addComponent(unloadedTruckWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(truckNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21))
                            .addComponent(jLabel22)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel46)
                                    .addComponent(builtyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(transportDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(numberOfBagsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bagType1)
                                    .addComponent(bagType2)
                                    .addComponent(jLabel30)
                                    .addComponent(loadedVerifyCheckBox))))
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(counter2SaveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(counter2UpdateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(counter2ResetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel36)
                            .addComponent(entryTableBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(counter2SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(loadedTruckWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel44)
                                .addComponent(jLabel24)
                                .addComponent(transportNetWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel43)
                                .addComponent(jLabel37)
                                .addComponent(transportNetWeightWithoutBag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel39)))))
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel47)
                        .addComponent(labourGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(exportingPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
        );

        loadedTruckWeight.getAccessibleContext().setAccessibleDescription("");
        unloadedTruckWeight.getAccessibleContext().setAccessibleDescription("");
        jSeparator13.getAccessibleContext().setAccessibleParent(this);

        parentTab.addTab("Export", jPanel3);

        userManagementPanel.setBackground(new java.awt.Color(204, 204, 204));
        userManagementPanel.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Access Type");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("UserId");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Password");

        accessTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Access", "Admin", "Counter 1", "Counter 2", "Counter 3" }));
        accessTypeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessTypeComboActionPerformed(evt);
            }
        });

        userSaveBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userSaveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_add_user_18499.png"))); // NOI18N
        userSaveBtn.setText("Add User");
        userSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSaveBtnActionPerformed(evt);
            }
        });

        userResetBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userResetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_counter_reset_16187.png"))); // NOI18N
        userResetBtn.setText("Reset");
        userResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userResetBtnActionPerformed(evt);
            }
        });

        userDeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userDeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_delete_user_6011.png"))); // NOI18N
        userDeleteBtn.setText("Delete");
        userDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userDeleteBtnActionPerformed(evt);
            }
        });

        userManagementTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        userManagementTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userManagementTableMouseClicked(evt);
            }
        });
        userManagementTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userManagementTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userManagementTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(userManagementTable);

        userUpdateBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/search_user.png"))); // NOI18N
        userUpdateBtn1.setText("Get All Users");
        userUpdateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userUpdateBtn1ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("First Name");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Last Name");

        userTableSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userTableSearchFieldKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\sadik\\Desktop\\icon\\if_search_173095.png")); // NOI18N
        jLabel14.setText("Search");

        userUpdateBtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userUpdateBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_db_update_3213.png"))); // NOI18N
        userUpdateBtn2.setText("Update");
        userUpdateBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userUpdateBtn2ActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon_images/if_Login Manager_7261.png"))); // NOI18N

        javax.swing.GroupLayout userManagementPanelLayout = new javax.swing.GroupLayout(userManagementPanel);
        userManagementPanel.setLayout(userManagementPanelLayout);
        userManagementPanelLayout.setHorizontalGroup(
            userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userManagementPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addGroup(userManagementPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(userResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userManagementPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userFirstName)
                            .addComponent(userLastName)
                            .addComponent(userId)
                            .addComponent(userPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(accessTypeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(userManagementPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(userSaveBtn)))
                .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userManagementPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userManagementPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(userUpdateBtn2)
                        .addGap(45, 45, 45)
                        .addComponent(userDeleteBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19)
                .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userManagementPanelLayout.createSequentialGroup()
                        .addComponent(userUpdateBtn1)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel14)
                        .addGap(34, 34, 34)
                        .addComponent(userTableSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        userManagementPanelLayout.setVerticalGroup(
            userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userManagementPanelLayout.createSequentialGroup()
                .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userManagementPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(accessTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(66, 66, 66)
                        .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addGap(34, 34, 34)
                        .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(34, 34, 34)
                        .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(34, 34, 34)
                        .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(userManagementPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(234, 234, 234)
                        .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userUpdateBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userSaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userManagementPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(userManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userUpdateBtn1)
                            .addGroup(userManagementPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel14))
                            .addGroup(userManagementPanelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(userTableSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );

        parentTab.addTab("User Management", userManagementPanel);

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));

        jLabel16.setFont(new java.awt.Font("Raavi", 2, 14)); // NOI18N
        jLabel16.setText("Developed by Sigma Enterprises Hoshangabad 9303435577");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(parentTab, javax.swing.GroupLayout.PREFERRED_SIZE, 1305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parentTab, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnSearchFarmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFarmerActionPerformed
           //con=DBConnection.getConnection();
        PreparedStatement pst = null;
        String sql="select * from counter1 where regno=?";
        try{

            pst=con.prepareStatement(sql);
            pst.setString(1,regNumber.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                farmerName.setText(rs.getString("farmername"));
                village.setText(rs.getString("village"));
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Registration Number "+regNumber.getText()+" Not Found");

                farmerName.setText("");
                village.setText("");
                tractorName.setText("");
                trolleyColour.setText("");
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }        
        
    }//GEN-LAST:event_btnSearchFarmerActionPerformed

    private void rstFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rstFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rstFieldActionPerformed

//    private ResultSet getTransportTokenResultSet(){
//        rs = null;
//        con = DBConnection.getConnection();
//        try{
//            String sql="select * from transport where token_number = ?";
//            int tn;
//            pst = null;
//            tn = Integer.parseInt(transportTokenField.getText().substring(9));
//            pst = con.prepareStatement(sql);
//            pst.setInt(1,tn);
//            rs = pst.executeQuery();
//            
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,e);
//        }
//        return rs;
//    }
    public class Function{
        ResultSet rs= null;
        PreparedStatement pst = null;
        public ResultSet findToken(){
            //con=DBConnection.getConnection();
            try{
            String sql="select * from counter2 where token_number=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,tokenNumber.getText());
            rs=pst.executeQuery();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e);
            }
        return rs;
        }
        
        public ResultSet findReg(String s){
            //con=DBConnection.getConnection();
            try{
                
                String sql="select * from counter1 where regno=?";
                pst=con.prepareStatement(sql);
                pst.setString(1,s);
                rs=pst.executeQuery();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e);
            }
        return rs;
        }
    
    }
    
    private void btnSearchDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDataActionPerformed
        //btnResetFarmerActionPerformed(evt);
        if(tokenNumber.getText().substring(0,1).equals("n")){
            String tokenDate;
            
        rstField.setText("");
        loadedTractorField.setText("");
        netGoodsWeightField.setText("");
        unloadedTractorWeightField.setText("");
        verifyCheckBox.setSelected(false);
        jLabel10.setBackground(Color.red);
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            String sql="SELECT * FROM counter2 WHERE token_number=?";
            try{
                //con = DBConnection.getConnection();
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setString(1,tokenNumber.getText().substring(1));
                rs=pst.executeQuery();
                if( rs.next() ){
                    if(rs.getInt("unloaded")==1&&counter==2){
                        unloadedTractorWeightField.setEnabled(true);
                    }else if(rs.getInt("unloaded")==0){
                        unloadedTractorWeightField.setEnabled(false);
                    }
                    regNumber.setText(rs.getString("farmer_reg"));
                    tractorName.setText(rs.getString("tractorname"));
                    trolleyColour.setText(rs.getString("tractorcolour"));
                    rstField.setText(rs.getString("rst_number"));
                    tokenDate = rs.getString("date_of_entry");
                    dateField.setDate(sdf.parse(tokenDate));
                    loadedTractorField.setText(rs.getString("loaded_tractor_weight"));
                    unloadedTractorWeightField.setText(rs.getString("unloaded_tractor_weight"));
                    netGoodsWeightField.setText(rs.getString("goods_weight"));
                    anubandhNumber.setText(rs.getString("anubandh"));
                    
                    if( rs.getString("unloaded").equals("1") ){
                        verifyCheckBox.setSelected(true);
                        jLabel10.setBackground(Color.green);
                    }
                    else{
                        verifyCheckBox.setSelected(false);
                        jLabel10.setBackground(Color.red);
                    }
                    btnSearchFarmerActionPerformed(evt);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wrong Token Number ","Search Result",JOptionPane.ERROR_MESSAGE);
                    btnResetFarmerActionPerformed(evt);
                    btnResetDataActionPerformed(evt);
                }
            }
            catch(SQLException | ParseException sqe){
                JOptionPane.showMessageDialog(null, sqe);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Wrong Token Number","Search Result",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSearchDataActionPerformed

    private int generateToken(){
        int token_max=0;
        //con = DBConnection.getConnection();
        try{
        Statement st=con.createStatement();
        rs=st.executeQuery("select max(token_number) from counter2");
        if(rs.next()){
            token_max=Integer.parseInt(rs.getString(1));
        }
        }catch(NumberFormatException | SQLException ex){
            JOptionPane.showMessageDialog(null,ex);
        }
        return token_max+1;
    }
    
    private void btnGenerateTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateTokenActionPerformed
        
        int token_max=generateToken();
        String sql;
        pst=null;
        ResultSet rs;
        if(((JTextField)dateField.getDateEditor().getUiComponent()).getText().equals("")||tractorName.getText().equals("")||trolleyColour.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Date or Tractor Name or Trolley Colour Field are Empty!!! plz fill it...");
        }else{
          try{
            sql="select * from counter1 where regno=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,regNumber.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                try{
                    sql="insert into counter2(token_number,farmer_reg) values(?,?)";
                    pst=con.prepareStatement(sql);
                    pst.setInt(1,token_max);
                    pst.setString(2,regNumber.getText());
                    pst.execute();
                    tokenNumber.setText("n"+token_max);
                    btnSaveDataActionPerformed(evt);
                    JOptionPane.showMessageDialog(null,"Data Saved with Generated Token : "+"n"+token_max);
                }catch(HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null,e);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Register First!!!");
            }
          }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
          }
        }
        
    }//GEN-LAST:event_btnGenerateTokenActionPerformed

    private void btnResetFarmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetFarmerActionPerformed
        
        regNumber.setText("");
        farmerName.setText("");
        village.setText("");
        
    }//GEN-LAST:event_btnResetFarmerActionPerformed

    private void btnRegisterFarmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterFarmerActionPerformed
        if(regNumber.getText().equals("")||farmerName.getText().equals("")||village.getText().equals("")){
            JOptionPane.showMessageDialog(null,"plz fill all mandatory fields!!!");
        }
        else{

            //con = DBConnection.getConnection();
            try{
                String sql="insert into counter1(regno,farmername,village) values(?,?,?)";
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setString(1,regNumber.getText());
                pst.setString(2,farmerName.getText());
                pst.setString(3,village.getText());
                
                pst.execute();
                JOptionPane.showMessageDialog(null,"Insert Complete..");
                btnResetFarmerActionPerformed(evt);

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Registration Number already exist!!!");
            }
        }
    }//GEN-LAST:event_btnRegisterFarmerActionPerformed

    private void btnResetDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetDataActionPerformed
        tokenNumber.setText("");
        tractorName.setText("");
        trolleyColour.setText("");
        rstField.setText("");
        anubandhNumber.setText("");
        loadedTractorField.setText("");
        netGoodsWeightField.setText("");
        unloadedTractorWeightField.setText("");
        verifyCheckBox.setSelected(false);
        jLabel10.setBackground(Color.red);
        
    }//GEN-LAST:event_btnResetDataActionPerformed

    private void btnSaveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDataActionPerformed
        if(((JTextField)dateField.getDateEditor().getUiComponent()).getText().equals("")||tractorName.getText().equals("")||trolleyColour.getText().equals("")){

            JOptionPane.showMessageDialog(null,"Date/Tractor Name or Tractor Colour Field are Empty!!! plz fill it...");
        }
        else
        {
                    try{
                            String sql;
                            sql = "update counter2 set tractorname = ?,tractorcolour = ?, rst_number = ?,date_of_entry = ?, loaded_tractor_weight = ?,"
                                    + " unloaded_tractor_weight=?, goods_weight=?,anubandh =? where token_number =?";

                            pst = con.prepareStatement(sql);

                            pst.setString(1,tractorName.getText());
                            pst.setString(2,trolleyColour.getText());
                            pst.setString(3,rstField.getText());
                            pst.setString(4,((JTextField)dateField.getDateEditor().getUiComponent()).getText());
                            if( loadedTractorField.getText().trim().equals("0.0000")||loadedTractorField.getText().trim().equals("") )
                                pst.setString(5,"0");
                            else
                                pst.setString(5,loadedTractorField.getText());
                            if( unloadedTractorWeightField.getText().trim().equals("0.0000")||unloadedTractorWeightField.getText().trim().equals("") )
                                pst.setString(6,"0");
                            else
                                pst.setString(6,unloadedTractorWeightField.getText());
                            if( loadedTractorField.getText().trim().equals("0.0000") ||
                                    unloadedTractorWeightField.getText().trim().equals("0.0000")||
                                    loadedTractorField.getText().trim().equals("") || 
                                    unloadedTractorWeightField.getText().trim().equals("") )
                                pst.setString(7,"0");
                            else
                                pst.setString(7,String.valueOf(Double.parseDouble(loadedTractorField.getText())-Double.parseDouble(unloadedTractorWeightField.getText())));
                            
                            pst.setString(8,anubandhNumber.getText());    
                            pst.setString(9,tokenNumber.getText().substring(1));
                            pst.executeUpdate();

                            JOptionPane.showMessageDialog(null,"Record Inserted/Updated");
                            
                        }catch(SQLException ex){
                            JOptionPane.showMessageDialog(null,ex.getStackTrace());
                            ex.printStackTrace();
                        }
                        catch(NumberFormatException nfe){
                            JOptionPane.showMessageDialog(null,"Entered Value must be number ","Wrong input",JOptionPane.ERROR_MESSAGE);
                        }   
            

        }
    }//GEN-LAST:event_btnSaveDataActionPerformed

    private void btnUpdateDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDataActionPerformed
        // TODO add your handling code here:
        btnSaveDataActionPerformed(evt);
    }//GEN-LAST:event_btnUpdateDataActionPerformed

    private void btnUpdateFarmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateFarmerActionPerformed
        // TODO add your handling code here:
        String sql="UPDATE counter1 SET village=?, farmername=?, WHERE regno=?";
        try{
            //con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setString(1, village.getText());
            pst.setString(2, farmerName.getText());
            pst.setString(3, regNumber.getText());
            int res=pst.executeUpdate();
            if( res==0 )
                JOptionPane.showMessageDialog(null,"Problem in Updateing Record, Check RegNo","Update",JOptionPane.ERROR_MESSAGE);
            else
                JOptionPane.showMessageDialog(null,"Record Updated Successfully","Update",JOptionPane.INFORMATION_MESSAGE);
            btnResetFarmerActionPerformed(evt);
        }
        catch(SQLException sqe){
            JOptionPane.showMessageDialog(null,"Database Connection Error","Update",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateFarmerActionPerformed

    private void btnVerifyUnloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyUnloadActionPerformed
        
       
        
        int unloaded=1;
        if( verifyCheckBox.isSelected())
            unloaded=0;
        
        try{
            String sql="select * from counter2 where token_number=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,tokenNumber.getText().substring(1));
            rs=pst.executeQuery();
            if(rs.next()){
                if(null==rs.getString("rst_number")||rs.getString("rst_number").equals("")){
                    JOptionPane.showMessageDialog(null,"RST number not found plz contact to counter2 ");
                }
                else{
                    sql="Update counter2 SET unloaded="+unloaded+" WHERE token_number=?";
                    pst=con.prepareStatement(sql);
                    pst.setString(1,tokenNumber.getText().substring(1));
                    int res=pst.executeUpdate();
                    if( res==0 )
                        JOptionPane.showMessageDialog(null,"Verification failed.","Verification",JOptionPane.ERROR_MESSAGE);
                    else{
                        JOptionPane.showMessageDialog(null,"Unloading verification changed!!!, Entry Auto Saved...","Verification",JOptionPane.INFORMATION_MESSAGE);
                        if( 0==unloaded ){
                            verifyCheckBox.setSelected(false);
                            jLabel10.setBackground(Color.red);
                        }
                        else{
                            verifyCheckBox.setSelected(true);
                            jLabel10.setBackground(Color.green);
                        }   
                    }
                }
            }
            
            
        }
        catch(SQLException sqe){
            JOptionPane.showMessageDialog(null,"Database Connection Error","Update",JOptionPane.ERROR_MESSAGE);
            sqe.printStackTrace();
        }
    }//GEN-LAST:event_btnVerifyUnloadActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void accessTypeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessTypeComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accessTypeComboActionPerformed
    private String getPrivilage(String code){
        switch (code) {
            case "0":
                return "Admin";
            case "1":
                return "Counter 1";
            case "2":
                return "Counter 2";
            case "3":
                return "Counter 3";
            default:
                break;
        }
        return "";
    }
    private void userUpdateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userUpdateBtn1ActionPerformed
        //con = DBConnection.getConnection();
        ResultSetMetaData rsmt;
        int columnCounter;
        String sql = "select * from userdetail";
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            rsmt = rs.getMetaData();
            columnCounter = rsmt.getColumnCount();
            Vector<String> column = new Vector<String>();
            column.addElement("Access");
            column.addElement("First Name");
            column.addElement("Last Name");
            column.addElement("UserId");
            column.addElement("Password");
                    
//            for(int i=2;i<=columnCounter;i++){
//                column.add(rsmt.getColumnClassName(i));
//            }
            Vector data = new Vector();
            Vector row = new Vector();
            while(rs.next()){
                row = new Vector(columnCounter);
                row.add(getPrivilage(rs.getString(1)));
                for(int i=2;i<=columnCounter;i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            DefaultTableModel model = (DefaultTableModel) userManagementTable.getModel();
            model.setDataVector(data, column);
            //userManagementTable = new JTable(data,column);
        } catch (SQLException ex) {
            Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userUpdateBtn1ActionPerformed

    public void getExportPopUp(String truckNumber, String rst, String date, String unloadTruck, String driver,  String loadTruck,
                                                                               String exportPlace, String bag, String bagType,String blty,String lbr, String netWWithBag,String netWWithoutBag, String verify){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        driverNameField.setText(driver);
        truckNumberField.setText(truckNumber);
        try {
            transportDateField.setDate(sdf.parse(date));
        } catch (ParseException ex) {
            Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        transportRSTNumber.setText(rst);
        loadedTruckWeight.setText(loadTruck);
        unloadedTruckWeight.setText(unloadTruck);
        exportingPlace.setText(exportPlace);
        transportNetWeight.setText(netWWithBag);
        transportNetWeightWithoutBag.setText(netWWithoutBag);
        numberOfBagsField.setText(bag);
        builtyNumber.setText(blty);
        labourGroup.setText(lbr);
        
                    if(bagType.equals("1")){
                        bagType1.setSelected(true);
                        bagType2.setSelected(false);
                    }
                    else if(bagType.equals("2")){
                        bagType2.setSelected(true);
                        bagType1.setSelected(false);
                    }
                    else if(bagType.equals("")){
                        bagType1.setSelected(false);
                        bagType2.setSelected(false);
                    }
                    
                    if(verify.equals("No")){
                        loadedVerifyCheckBox.setSelected(false);
                        jLabel30.setBackground(Color.red);
                    }
                    else{
                        loadedVerifyCheckBox.setSelected(true);
                        jLabel30.setBackground(Color.GREEN);
                    }
        
    }
    
    public void getImportPopUp(String token, String reg,String nam,String vlg,String tracN,String tracC, String rst, String date,String anubandh, String loadedW, String unloadedW, String wheatW,String verify){
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        regNumber.setText(reg);
        tokenNumber.setText(token);
        farmerName.setText(nam);
        village.setText(vlg);
        tractorName.setText(tracN);
        trolleyColour.setText(tracC);
        rstField.setText(rst);
        loadedTractorField.setText(loadedW);
        unloadedTractorWeightField.setText(unloadedW);
        netGoodsWeightField.setText(wheatW);
        anubandhNumber.setText(anubandh);
        try {
            dateField.setDate(sdf.parse(date));
        } catch (ParseException ex) {
            Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(verify.equals("Yes")){
            verifyCheckBox.setSelected(true);
            jLabel10.setBackground(Color.green);
        }else{
            verifyCheckBox.setSelected(false);
            jLabel10.setBackground(Color.red);
        }
    }
    private void userManagementTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userManagementTableMouseClicked
        
        DefaultTableModel model = (DefaultTableModel) userManagementTable.getModel();
        int selectedRowIndex = userManagementTable.getSelectedRow();
        if( userManagementTable.getRowSorter()!=null){
           selectedRowIndex=userManagementTable.getRowSorter().convertRowIndexToModel(selectedRowIndex);
        }
        if((model.getValueAt(selectedRowIndex,0).toString().equals("Admin"))){
            accessTypeCombo.setSelectedIndex(1);
            
        }
        else if((model.getValueAt(selectedRowIndex,0).toString().equals("Counter 1"))){
            accessTypeCombo.setSelectedIndex(2);
        }
        
        else if((model.getValueAt(selectedRowIndex,0).toString().equals("Counter 2"))){
            accessTypeCombo.setSelectedIndex(3);
        }
        
        else if((model.getValueAt(selectedRowIndex,0).toString().equals("Counter 3"))){
            accessTypeCombo.setSelectedIndex(4);
        }
       
        userFirstName.setText(model.getValueAt(selectedRowIndex,1).toString());
        userLastName.setText(model.getValueAt(selectedRowIndex,2).toString());
        userId.setText(model.getValueAt(selectedRowIndex,3).toString());
        userPassword.setText(model.getValueAt(selectedRowIndex,4).toString());
              
        
    }//GEN-LAST:event_userManagementTableMouseClicked

    private void userManagementTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userManagementTableKeyPressed
        
          
    }//GEN-LAST:event_userManagementTableKeyPressed

    private void userManagementTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userManagementTableKeyReleased
        
        DefaultTableModel model = (DefaultTableModel) userManagementTable.getModel();
        int selectedRowIndex = userManagementTable.getSelectedRow();
        if( userManagementTable.getRowSorter()!=null){
           selectedRowIndex=userManagementTable.getRowSorter().convertRowIndexToModel(selectedRowIndex);
        }
        if((model.getValueAt(selectedRowIndex,0).toString().equals("Admin"))){
            accessTypeCombo.setSelectedIndex(1);
        }
        else if((model.getValueAt(selectedRowIndex,0).toString().equals("Counter 1"))){
            accessTypeCombo.setSelectedIndex(2);
        }
        
        else if((model.getValueAt(selectedRowIndex,0).toString().equals("Counter 2"))){
            accessTypeCombo.setSelectedIndex(3);
        }
        
        else if((model.getValueAt(selectedRowIndex,0).toString().equals("Counter 3"))){
            accessTypeCombo.setSelectedIndex(4);
        }
        
        userFirstName.setText(model.getValueAt(selectedRowIndex,1).toString());
        userLastName.setText(model.getValueAt(selectedRowIndex,2).toString());
        userId.setText(model.getValueAt(selectedRowIndex,3).toString());
        userPassword.setText(model.getValueAt(selectedRowIndex,4).toString());
        
    }//GEN-LAST:event_userManagementTableKeyReleased

    private void userSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSaveBtnActionPerformed
        
        int accessType = 1;
        String sql = "insert into userdetail(counterno,fname,lname,username,password) values(?,?,?,?,?)";
        if(userFirstName.getText().equals("")||userLastName.getText().equals("")||userId.getText().equals("")||userPassword.getText().equals("")||accessTypeCombo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(rootPane,"Plz fill all Fields!!!");
        }else{
          try {
            pst = con.prepareStatement(sql);
            //pst.setString(1,.setText();
            if(accessTypeCombo.getSelectedItem().toString().equals("Admin")){
                accessType = 0;
            }
            else if(accessTypeCombo.getSelectedItem().toString().equals("Counter 1")){
                accessType = 1;
            }
            else if(accessTypeCombo.getSelectedItem().toString().equals("Counter 2")){
                accessType = 2;
            }
            else if(accessTypeCombo.getSelectedItem().toString().equals("Counter 3")){
                accessType = 3;
            }
            pst.setInt(1,accessType);
            pst.setString(2,userFirstName.getText());
            pst.setString(3,userLastName.getText());
            pst.setString(4,userId.getText());
            pst.setString(5,userPassword.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null,"User Id created...");
            accessTypeCombo.setSelectedIndex(0);
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"User Id already Exist!! choose an Unique UserId");
            Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_userSaveBtnActionPerformed

    private void userDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDeleteBtnActionPerformed
        if(userId.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Plz enter existing UserId to delete user!!!");
        }else{
            String sql = "delete from userdetail where username = ?";
          try {
            pst = con.prepareStatement(sql); 
            pst.setString(1,userId.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"UserId Deleted...");
            userFirstName.setText("");
            userLastName.setText("");
            userId.setText("");
            userPassword.setText("");
            userId.setText("");
            accessTypeCombo.setSelectedIndex(0);
            userUpdateBtn1ActionPerformed(evt);
          } catch (SQLException ex) {
            Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error : Check Entry!!!");
            }
        }
        
    }//GEN-LAST:event_userDeleteBtnActionPerformed

    private void userResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userResetBtnActionPerformed
            userFirstName.setText("");
            userLastName.setText("");
            userId.setText("");
            userPassword.setText("");
            accessTypeCombo.setSelectedIndex(0);
            userManagementTable.setModel(new DefaultTableModel(null,new String[]{"Access","First Name","Last Name","UserId","Password"}));
    }//GEN-LAST:event_userResetBtnActionPerformed

    private void counter3SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counter3SaveBtnActionPerformed
        if(transportRSTNumber.getText().equals("")
                ||truckNumberField.getText().equals("")
                ||unloadedTruckWeight.getText().equals("")
                ||driverNameField.getText().equals("")
                ||bagType1.isSelected()==bagType2.isSelected()
                ||!loadedVerifyCheckBox.isSelected()
                ||numberOfBagsField.getText().equals("")
                ||!loadedVerifyCheckBox.isSelected()){
            JOptionPane.showMessageDialog(null,"some fields are not filled, plz fill them!!!");
        }else{
            try{
                String sql="Insert into transport(transport_rst_number,truck_number,date,unloaded_truck_weight,driver_name,number_of_bags,bags_type,builty_number,truck_loaded_verify) values(?,?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1,transportRSTNumber.getText());
                pst.setString(2,truckNumberField.getText());
                pst.setString(3,((JTextField)transportDateField.getDateEditor().getUiComponent()).getText());
                pst.setString(4,unloadedTruckWeight.getText());
                pst.setString(5,driverNameField.getText());
                pst.setString(6,numberOfBagsField.getText());
                if(bagType1.isSelected()){
                    bagType2.setSelected(false);
                    pst.setInt(7,1);
                }
                else if(bagType2.isSelected()){
                    bagType1.setSelected(false);
                    pst.setInt(7,2);
                }
                pst.setString(8, builtyNumber.getText());
                if(loadedVerifyCheckBox.isSelected()){
                    pst.setInt(9,1);
                }else{
                    pst.setInt(9,0);
                }
                pst.execute();
        
                JOptionPane.showMessageDialog(null,"RST Number : "+transportRSTNumber.getText()+" Entry saved");
                counter3ResetBtnActionPerformed(evt);
      }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        }
    
    }//GEN-LAST:event_counter3SaveBtnActionPerformed

    private void counter2SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counter2SearchBtnActionPerformed
        //con=DBConnection.getConnection();    
        counter3SearchBtnActionPerformed(evt);
        String sql="select * from transport where transport_rst_number=?";
            try{
                pst=con.prepareStatement(sql);
                pst.setString(1,transportRSTNumber.getText());
                rs=pst.executeQuery();
                if(rs.next()){
                    loadedTruckWeight.setText(rs.getString("loaded_truck_weight"));
                    transportNetWeight.setText(rs.getString("net_weight_with_bag"));
                    transportNetWeightWithoutBag.setText(rs.getString("net_weight_without_bag"));
                    labourGroup.setText(rs.getString("labour_group"));
                    exportingPlace.setText(rs.getString("exporting_place"));
                       
                }  
                else{
                    //JOptionPane.showMessageDialog(null,"RST Number not Exist!!!");
                    counter3ResetBtnActionPerformed(evt);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e+" wrong RST Number!!!");
                counter3ResetBtnActionPerformed(evt);
            }
        
    }//GEN-LAST:event_counter2SearchBtnActionPerformed

    private void counter2SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counter2SaveBtnActionPerformed
        
        if(loadedTruckWeight.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Fill the gross Weight!!!");
        }else{
            counter2UpdateBtnActionPerformed(evt);
        }
        
    }//GEN-LAST:event_counter2SaveBtnActionPerformed

    private void counter2UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counter2UpdateBtnActionPerformed
        double unloadedW=0,netW=0,bagsW=0,pp=0.120,jute=0.580;
        int numberOfBags=0;
            try{
                String sql="select * from transport where transport_rst_number=?";
                pst=con.prepareStatement(sql);
                pst.setString(1,transportRSTNumber.getText());
                rs=pst.executeQuery();
                if(rs.next()){
                    numberOfBags=rs.getInt("number_of_bags");
                    //unloadedW=rs.getDouble("unloaded_truck_weight");
                    unloadedW=Double.parseDouble(unloadedTruckWeight.getText());
                    if(rs.getInt("bags_type")==1){
                        bagsW=numberOfBags*jute;
                    }else if(rs.getInt("bags_type")==2){
                        bagsW=numberOfBags*pp;
                    }
                    transportNetWeight.setText(String.valueOf(netW));
                    transportNetWeightWithoutBag.setText(String.valueOf(netW-bagsW));
                    
                    netW=Double.parseDouble(loadedTruckWeight.getText())-unloadedW;
                    sql = "update transport set loaded_truck_weight=?,net_weight_with_bag=?,net_weight_without_bag=?,exporting_place=?,labour_group=? where transport_rst_number = ?";
                    pst = con.prepareStatement(sql);
                    pst.setString(1,loadedTruckWeight.getText());
                    pst.setDouble(2,netW);
                    pst.setDouble(3,netW-bagsW);
                    pst.setString(4,exportingPlace.getText());
                    pst.setString(5,labourGroup.getText());
                    pst.setString(6,transportRSTNumber.getText());
                    
                    pst.executeUpdate();
                }
                    JOptionPane.showMessageDialog(null,"RST Number : "+transportRSTNumber.getText()+" Record Updated...");                       
                    counter2ResetBtnActionPerformed(evt);
                    counter3ResetBtnActionPerformed(evt);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        
    }//GEN-LAST:event_counter2UpdateBtnActionPerformed

    private void counter3SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counter3SearchBtnActionPerformed
        //con = DBConnection.getConnection();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        String sql ="select * from transport where transport_rst_number = ?";        
        try{
            pst=con.prepareStatement(sql);
            pst.setString(1,transportRSTNumber.getText());
            rs=pst.executeQuery();
            if(rs.next()){
                if(rs.getInt("truck_loaded_verify")==1){
                        loadedVerifyCheckBox.setSelected(true);
                        jLabel30.setBackground(Color.GREEN);
                    }
                    else{
                        loadedVerifyCheckBox.setSelected(false);
                        jLabel30.setBackground(Color.RED);
                    }
                transportRSTNumber.setText(rs.getString("transport_rst_number"));
                truckNumberField.setText(rs.getString("truck_number"));                
                transportDateField.setDate(sdf.parse(rs.getString("date")));
                unloadedTruckWeight.setText(rs.getString("unloaded_truck_weight"));
                driverNameField.setText(rs.getString("driver_name"));
                builtyNumber.setText(rs.getString("builty_number"));
                numberOfBagsField.setText(rs.getString("number_of_bags"));
                if(rs.getInt("bags_type")==1){
                        bagType1.setSelected(true);
                        bagType2.setSelected(false);
                    }
                else if(rs.getInt("bags_type")==2){
                    bagType2.setSelected(true);
                    bagType1.setSelected(false);
                }
                
//                loadedTruckWeight.setText(rs.getString("loaded_truck_weight"));
//                transportNetWeight.setText(rs.getString("net_weight_with_bag"));
//                transportNetWeightWithoutBag.setText(rs.getString("net_weight_without_bag"));
                
            }  
            else{
                JOptionPane.showMessageDialog(null,"RST Number, not Exist!!!");
                counter2ResetBtnActionPerformed(evt);
                counter3ResetBtnActionPerformed(evt);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e+" wrong RST Number!!!");
            counter2ResetBtnActionPerformed(evt);
            counter3ResetBtnActionPerformed(evt);
        }
    }//GEN-LAST:event_counter3SearchBtnActionPerformed

    private void counter3UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counter3UpdateBtnActionPerformed
        
        try{
            String sql="update transport set truck_number=?,date=?,unloaded_truck_weight=?,driver_name=?,number_of_bags=?,bags_type=?,builty_number=?,truck_loaded_verify=? where transport_rst_number=?";
            pst = con.prepareStatement(sql);
            
            pst.setString(1,truckNumberField.getText());
            pst.setString(2,((JTextField)transportDateField.getDateEditor().getUiComponent()).getText());
            pst.setString(3,unloadedTruckWeight.getText() );
            pst.setString(4,driverNameField.getText());
            pst.setString(5,numberOfBagsField.getText());
            if(bagType1.isSelected()){
                    //bagType2.setSelected(false);
                    pst.setInt(6,1);
            }
            else if(bagType2.isSelected()){
                    //bagType1.setSelected(false);
                    pst.setInt(6,2);
            }
            pst.setString(7,builtyNumber.getText());
            if(loadedVerifyCheckBox.isSelected()){
                    pst.setInt(8,1);
                }else{
                    pst.setInt(8,0);
                }
            pst.setString(9,transportRSTNumber.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"RST Number : "+transportRSTNumber.getText()+" Updated");
//                String sql="Insert into transport(transport_rst_number,truck_number,date,unloaded_truck_weight,driver_name,number_of_bags,bags_type,builty_number,truck_loaded_verify) values(?,?,?,?,?,?,?,?,?)";
//                pst = con.prepareStatement(sql);
//                pst.setString(1,transportRSTNumber.getText());
//                pst.setString(2,truckNumberField.getText());
//                pst.setString(3,((JTextField)transportDateField.getDateEditor().getUiComponent()).getText());
//                pst.setString(4,unloadedTruckWeight.getText());
//                pst.setString(5,driverNameField.getText());
//                pst.setString(6,numberOfBagsField.getText());
//                if(bagType1.isSelected()){
//                    bagType2.setSelected(false);
//                    pst.setInt(7,1);
//                }
//                else if(bagType2.isSelected()){
//                    bagType1.setSelected(false);
//                    pst.setInt(7,2);
//                }
//                pst.setString(8, builtyNumber.getText());
//                if(loadedVerifyCheckBox.isSelected()){
//                    pst.setInt(9,1);
//                }else{
//                    pst.setInt(9,0);
//                }
//                pst.execute();
//        
//                JOptionPane.showMessageDialog(null,"RST Number : "+transportRSTNumber.getText()+" Entry saved");
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);     
        }    }//GEN-LAST:event_counter3UpdateBtnActionPerformed

    private void counter3ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counter3ResetBtnActionPerformed
            
            truckNumberField.setText("");
            unloadedTruckWeight.setText("");
            driverNameField.setText("");
            bagType1.setSelected(false);
            bagType2.setSelected(false);
            transportNetWeight.setText("");
            //transportRSTNumber.setText("");
            builtyNumber.setText("");
            loadedVerifyCheckBox.setSelected(false);
            numberOfBagsField.setText("");
            jLabel30.setBackground(Color.RED);
            
    }//GEN-LAST:event_counter3ResetBtnActionPerformed

    private void counter2ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_counter2ResetBtnActionPerformed
        
//        driverNameField.setText("");
        exportingPlace.setText("");
//        numberOfBagsField.setText("");
//        builtyNumber.setText("");
        loadedTruckWeight.setText("");
        labourGroup.setText("");
        transportNetWeight.setText("");
        transportNetWeightWithoutBag.setText("");
//        bagType1.setSelected(false);
//        bagType2.setSelected(false);
//        loadedVerifyCheckBox.setSelected(false);
//        jLabel30.setBackground(Color.RED);
    }//GEN-LAST:event_counter2ResetBtnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent wEvt){
        //this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
    }
    private void driverNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_driverNameFieldActionPerformed

    private void entryTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryTableBtnActionPerformed

        ExportPopUp ep = new ExportPopUp(this,true);
        ep.show();
       
    }//GEN-LAST:event_entryTableBtnActionPerformed

    private void importAllRecordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importAllRecordBtnActionPerformed
        ImportPopUp ip = new ImportPopUp(this,true);
        //ep.setModal(true);
        ip.show();
    }//GEN-LAST:event_importAllRecordBtnActionPerformed

    private void btnPrintImportReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintImportReceiptActionPerformed
    
        if(regNumber.getText().equals("")||tokenNumber.getText().equals("")){
            JOptionPane.showMessageDialog(null,"plz fill/search Registration detail with Generated Token!!!");
        }else{
            ReceiptPrinter rp = new ReceiptPrinter();
            rp.regNo = regNumber.getText();
            rp.farmerName = farmerName.getText();
            rp.village = village.getText();
            rp.tokenNo = tokenNumber.getText();
            rp.tractor = tractorName.getText();
            rp.tractorClr = trolleyColour.getText();
            rp.printReceipt();        
        }
        
    }//GEN-LAST:event_btnPrintImportReceiptActionPerformed

    private void userTableSearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTableSearchFieldKeyReleased
        DefaultTableModel model = (DefaultTableModel)userManagementTable.getModel();
        String search = userTableSearchField.getText();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        userManagementTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_userTableSearchFieldKeyReleased

    private void userUpdateBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userUpdateBtn2ActionPerformed
        if(userFirstName.getText().equals("")||userLastName.getText().equals("")
                ||userId.getText().equals("")||userPassword.getText().equals("")||accessTypeCombo.getSelectedIndex()==0){
        
            JOptionPane.showMessageDialog(null,"Plz fill all Fields with Access Type!!!");
        }else{
            String sql="update userdetail set counterno=?,fname=?, lname=?, password=? where username=?";
            try {
                pst=con.prepareStatement(sql);
                if(accessTypeCombo.getSelectedIndex()==1){
                    pst.setInt(1, 0);//0 for admin
                }else if(accessTypeCombo.getSelectedIndex()==2){
                    pst.setInt(1, 1);//1 for counter 1 and respective to number
                }else if(accessTypeCombo.getSelectedIndex()==3){
                    pst.setInt(1, 2);
                }else if(accessTypeCombo.getSelectedIndex()==4){
                    pst.setInt(1, 3);
                }
                
                pst.setString(2, userFirstName.getText());
                pst.setString(3, userLastName.getText());
                pst.setString(4, userPassword.getText());
                pst.setString(5, userId.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"User detail updated");
                accessTypeCombo.setSelectedIndex(0);
                userUpdateBtn1ActionPerformed(evt);
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_userUpdateBtn2ActionPerformed

    private void bagType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagType1ActionPerformed
        
            bagType1.setSelected(true);
            bagType2.setSelected(false);
        
        
    }//GEN-LAST:event_bagType1ActionPerformed

    private void bagType2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bagType2ActionPerformed

            bagType2.setSelected(true);
            bagType1.setSelected(false);

    }//GEN-LAST:event_bagType2ActionPerformed

    private void selectTractorCMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTractorCMBActionPerformed
        if(selectTractorCMB.getSelectedIndex()==0||selectTractorCMB.getSelectedIndex()==17){
            tractorName.setText("");
        }else{
            tractorName.setText(selectTractorCMB.getSelectedItem().toString().toLowerCase());
        }
    }//GEN-LAST:event_selectTractorCMBActionPerformed

    private void trolleyColourCMBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trolleyColourCMBActionPerformed
        if(trolleyColourCMB.getSelectedIndex()==0||trolleyColourCMB.getSelectedIndex()==11){
            trolleyColour.setText("");
        }else{
            trolleyColour.setText(trolleyColourCMB.getSelectedItem().toString().toLowerCase());
        }
    }//GEN-LAST:event_trolleyColourCMBActionPerformed

    private void importCounterWorkBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importCounterWorkBTNActionPerformed
        
        UserImportPopUpTable upt=new UserImportPopUpTable(this,true,counter);
        upt.show();
        //UserImportPopUpTable.importCounter1(counter);
        
        //upt.importCounter1(1);
    }//GEN-LAST:event_importCounterWorkBTNActionPerformed

    private void exportCounterWorkBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportCounterWorkBTNActionPerformed
        UserExportPopUpTable uept=new UserExportPopUpTable(this,true,counter);
        uept.show();
    }//GEN-LAST:event_exportCounterWorkBTNActionPerformed

    private void loadedVerifyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadedVerifyCheckBoxActionPerformed
        if(loadedVerifyCheckBox.isSelected()){
            loadedVerifyCheckBox.setSelected(true);
            jLabel30.setBackground(Color.GREEN);
        }else{
            loadedVerifyCheckBox.setSelected(false);
            jLabel30.setBackground(Color.red);
        }
        
        
    }//GEN-LAST:event_loadedVerifyCheckBoxActionPerformed

//    public void paintComponent(Graphics g){
//        super.paintComponents(g);
//        ImageIcon im = new ImageIcon("wheat_field.jpg");
//        Image i=im.getImage();
//        g.drawImage(i, 0, 0, this.getSize().width, this.getSize().height, this);
//        
//    }
    
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
            java.util.logging.Logger.getLogger(AdminControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accessTypeCombo;
    private javax.swing.JTextField anubandhNumber;
    private javax.swing.JRadioButton bagType1;
    private javax.swing.JRadioButton bagType2;
    private javax.swing.JButton btnGenerateToken;
    private javax.swing.JButton btnPrintImportReceipt;
    private javax.swing.JButton btnRegisterFarmer;
    private javax.swing.JButton btnResetData;
    private javax.swing.JButton btnResetFarmer;
    private javax.swing.JButton btnSaveData;
    private javax.swing.JButton btnSearchData;
    private javax.swing.JButton btnSearchFarmer;
    private javax.swing.JButton btnUpdateData;
    private javax.swing.JButton btnUpdateFarmer;
    private javax.swing.JButton btnVerifyUnload;
    private javax.swing.JTextField builtyNumber;
    private javax.swing.JButton counter2ResetBtn;
    private javax.swing.JButton counter2SaveBtn;
    private javax.swing.JButton counter2SearchBtn;
    private javax.swing.JButton counter2UpdateBtn;
    private javax.swing.JButton counter3ResetBtn;
    private javax.swing.JButton counter3SaveBtn;
    private javax.swing.JButton counter3SearchBtn;
    private javax.swing.JButton counter3UpdateBtn;
    private com.toedter.calendar.JDateChooser dateField;
    private javax.swing.JTextField driverNameField;
    private javax.swing.JButton entryTableBtn;
    private javax.swing.JButton exportCounterWorkBTN;
    private javax.swing.JTextField exportingPlace;
    private javax.swing.JTextField farmerName;
    private javax.swing.JButton importAllRecordBtn;
    private javax.swing.JButton importCounterWorkBTN;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField labourGroup;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField loadedTractorField;
    private javax.swing.JTextField loadedTruckWeight;
    private javax.swing.JCheckBox loadedVerifyCheckBox;
    private javax.swing.JTextField netGoodsWeightField;
    private javax.swing.JTextField numberOfBagsField;
    private javax.swing.JTabbedPane parentTab;
    private javax.swing.JTextField regNumber;
    private javax.swing.JTextField rstField;
    private javax.swing.JComboBox<String> selectTractorCMB;
    private javax.swing.JTextField tokenNumber;
    private javax.swing.JTextField tractorName;
    private com.toedter.calendar.JDateChooser transportDateField;
    private javax.swing.JTextField transportNetWeight;
    private javax.swing.JTextField transportNetWeightWithoutBag;
    private javax.swing.JTextField transportRSTNumber;
    private javax.swing.JTextField trolleyColour;
    private javax.swing.JComboBox<String> trolleyColourCMB;
    private javax.swing.JTextField truckNumberField;
    private javax.swing.JTextField unloadedTractorWeightField;
    private javax.swing.JTextField unloadedTruckWeight;
    private javax.swing.JButton userDeleteBtn;
    private javax.swing.JTextField userFirstName;
    private javax.swing.JTextField userId;
    private javax.swing.JTextField userLastName;
    private javax.swing.JPanel userManagementPanel;
    private javax.swing.JTable userManagementTable;
    private javax.swing.JPasswordField userPassword;
    private javax.swing.JButton userResetBtn;
    private javax.swing.JButton userSaveBtn;
    private javax.swing.JTextField userTableSearchField;
    private javax.swing.JButton userUpdateBtn1;
    private javax.swing.JButton userUpdateBtn2;
    private javax.swing.JCheckBox verifyCheckBox;
    private javax.swing.JTextField village;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
