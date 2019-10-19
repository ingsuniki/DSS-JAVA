package DSS;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author L - Arch
 */
public class aPencapaian extends javax.swing.JFrame {
    
    
  
    
    
    
    // Clear data
    
    private void clear_data(){
        txtidk.setEditable(true);
        txtidk.setText(null);
        txtnk.setText(null);
        txtjabatan.setText(null);
        cbidjabatan.setSelectedItem(this);
        
        txttq1.setText(null);
	txttq2.setText(null);
	txttq3.setText(null);
	txttq4.setText(null);

	txtpq1.setText(null);
	txtpq2.setText(null);
	txtpq3.setText(null);
	txtpq4.setText(null);

	txtppq1.setText(null);
	txtppq2.setText(null);
	txtppq3.setText(null);
	txtppq4.setText(null);

	txtkkg1.setText(null);
	txtkkg2.setText(null);
	txtkkg3.setText(null);
		
	txthkg1.setText(null);
	txthkg2.setText(null);
	txthkg3.setText(null);

	txtap.setText(null);
	txtcs.setText(null);
	txtss.setText(null);
        
    }
    
    
    // Tampil data Tabel
    
    private void tampilkan_data (){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("NIK");
        model.addColumn("Nama Karyawan");
        model.addColumn("Jabatan");
        model.addColumn("ID Jabatan");
        model.addColumn("Pencapaian Q1");
        model.addColumn("Pencapaian Q2");
        model.addColumn("Pencapaian Q3");
        model.addColumn("Pencapaian Q4");
        model.addColumn("Persentase Q1");
        model.addColumn("Persentase Q2");
        model.addColumn("Persentase Q3");
        model.addColumn("Persentase Q4");
        model.addColumn("Average Persentase");
        model.addColumn("Current Salary");
        model.addColumn("Submission Salary");
        
        
        
        try {
            int no = 1;
            String sql = "SELECT * FROM fpencapaian";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()){
                model.addRow(new Object []{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),res.getString(13),res.getString(14),res.getString(15)});
            }
            jtpencapaian.setModel(model);
            
        } catch (SQLException e){
            System.out.println("error" + e.getMessage());
        }
    }
    
    private void search(){
    
     DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("NIK");
        model.addColumn("Nama Karyawan");
        model.addColumn("Jabatan");
        model.addColumn("ID Jabatan");
        model.addColumn("Pencapaian Q1");
        model.addColumn("Pencapaian Q2");
        model.addColumn("Pencapaian Q3");
        model.addColumn("Pencapaian Q4");
        model.addColumn("Persentase Q1");
        model.addColumn("Persentase Q2");
        model.addColumn("Persentase Q3");
        model.addColumn("Persentase Q4");
        model.addColumn("Average Persentase");
        model.addColumn("Current Salary");
        model.addColumn("Submission Salary");
        
        
        
        try {
            int no = 1;
            String sql = "SELECT * FROM fpencapaian WHERE idkaryawan LIKE '%"+txtsearch.getText()+"%'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()){
                model.addRow(new Object []{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),res.getString(13),res.getString(14),res.getString(15)});
            }
            jtpencapaian.setModel(model);
            
        } catch (SQLException e){
            System.out.println("error" + e.getMessage());
        }   
        
        
    }
    
    
    // batas default
    
    private void setTombol(boolean t) {
     find.setEnabled(t);
     check.setEnabled(!t);
     count.setEnabled(!t);
     add.setEnabled(!t);
     clear.setEnabled(!t);
     update.setEnabled(!t);
     delete.setEnabled(!t);
     print.setEnabled(!t);
    }
    
    public void cbjabatan () {
    
        try {
            
            String sql = "SELECT idjabatan FROM ftarget ";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){

            Object[] ob = new Object[3];

            ob[0] = res.getString(1);

            cbidjabatan.addItem((String) ob[0]);                                      // fungsi ini bertugas menampung isi dari database

        }
            
            res.close(); stm.close();
            
           
        } catch (SQLException e){
            System.out.println("error" + e.getMessage());
        }
    
    }
    
    
    
    

    /**
     * Creates new form MainDashBoard
     */
    public aPencapaian() {
        initComponents();
         this.setBackground (new Color(0,0,0,0));
         
         tampilkan_data ();
                 
         clear_data();
         cbjabatan ();
         setTombol(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Minimize = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        txtpq1 = new javax.swing.JTextField();
        txtpq2 = new javax.swing.JTextField();
        txtpq3 = new javax.swing.JTextField();
        txtpq4 = new javax.swing.JTextField();
        txtppq1 = new javax.swing.JTextField();
        txtppq2 = new javax.swing.JTextField();
        txtppq3 = new javax.swing.JTextField();
        txtppq4 = new javax.swing.JTextField();
        txtap = new javax.swing.JTextField();
        txtcs = new javax.swing.JTextField();
        txtjabatan = new javax.swing.JTextField();
        txtidk = new javax.swing.JTextField();
        txtnk = new javax.swing.JTextField();
        txtsearch = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        btfk = new javax.swing.JButton();
        btfp1 = new javax.swing.JButton();
        signOut1 = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        print = new javax.swing.JButton();
        find = new javax.swing.JButton();
        add = new javax.swing.JButton();
        count = new javax.swing.JButton();
        check = new javax.swing.JButton();
        update = new javax.swing.JButton();
        txttq2 = new javax.swing.JTextField();
        txttq3 = new javax.swing.JTextField();
        txttq4 = new javax.swing.JTextField();
        txttq1 = new javax.swing.JTextField();
        txthkg1 = new javax.swing.JTextField();
        txtkkg2 = new javax.swing.JTextField();
        txthkg2 = new javax.swing.JTextField();
        txtkkg3 = new javax.swing.JTextField();
        txthkg3 = new javax.swing.JTextField();
        txtkkg1 = new javax.swing.JTextField();
        printall = new javax.swing.JButton();
        txtss = new javax.swing.JTextField();
        cbidjabatan = new javax.swing.JComboBox<>();
        jsuser = new javax.swing.JScrollPane();
        jtpencapaian = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtidjabatan12 = new javax.swing.JTextField();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(null);

        Minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeMouseClicked(evt);
            }
        });
        getContentPane().add(Minimize);
        Minimize.setBounds(1125, 6, 25, 25);

        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(1161, 6, 25, 25);

        txtpq1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtpq1.setForeground(new java.awt.Color(0, 102, 102));
        txtpq1.setBorder(null);
        getContentPane().add(txtpq1);
        txtpq1.setBounds(800, 105, 260, 30);

        txtpq2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtpq2.setForeground(new java.awt.Color(0, 102, 102));
        txtpq2.setBorder(null);
        getContentPane().add(txtpq2);
        txtpq2.setBounds(800, 147, 260, 30);

        txtpq3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtpq3.setForeground(new java.awt.Color(0, 102, 102));
        txtpq3.setBorder(null);
        getContentPane().add(txtpq3);
        txtpq3.setBounds(800, 190, 260, 30);

        txtpq4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtpq4.setForeground(new java.awt.Color(0, 102, 102));
        txtpq4.setBorder(null);
        getContentPane().add(txtpq4);
        txtpq4.setBounds(800, 231, 260, 30);

        txtppq1.setEditable(false);
        txtppq1.setBackground(new java.awt.Color(255, 255, 255));
        txtppq1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtppq1.setForeground(new java.awt.Color(0, 102, 102));
        txtppq1.setBorder(null);
        getContentPane().add(txtppq1);
        txtppq1.setBounds(1085, 105, 50, 30);

        txtppq2.setEditable(false);
        txtppq2.setBackground(new java.awt.Color(255, 255, 255));
        txtppq2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtppq2.setForeground(new java.awt.Color(0, 102, 102));
        txtppq2.setBorder(null);
        getContentPane().add(txtppq2);
        txtppq2.setBounds(1085, 147, 50, 30);

        txtppq3.setEditable(false);
        txtppq3.setBackground(new java.awt.Color(255, 255, 255));
        txtppq3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtppq3.setForeground(new java.awt.Color(0, 102, 102));
        txtppq3.setBorder(null);
        getContentPane().add(txtppq3);
        txtppq3.setBounds(1085, 190, 50, 30);

        txtppq4.setEditable(false);
        txtppq4.setBackground(new java.awt.Color(255, 255, 255));
        txtppq4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtppq4.setForeground(new java.awt.Color(0, 102, 102));
        txtppq4.setBorder(null);
        getContentPane().add(txtppq4);
        txtppq4.setBounds(1085, 231, 50, 30);

        txtap.setEditable(false);
        txtap.setBackground(new java.awt.Color(255, 255, 255));
        txtap.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtap.setForeground(new java.awt.Color(0, 102, 102));
        txtap.setBorder(null);
        getContentPane().add(txtap);
        txtap.setBounds(710, 273, 50, 30);

        txtcs.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtcs.setForeground(new java.awt.Color(0, 102, 102));
        txtcs.setBorder(null);
        txtcs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcsActionPerformed(evt);
            }
        });
        txtcs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcsKeyReleased(evt);
            }
        });
        getContentPane().add(txtcs);
        txtcs.setBounds(700, 313, 150, 20);

        txtjabatan.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtjabatan.setForeground(new java.awt.Color(0, 102, 102));
        txtjabatan.setBorder(null);
        getContentPane().add(txtjabatan);
        txtjabatan.setBounds(370, 168, 185, 23);

        txtidk.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtidk.setForeground(new java.awt.Color(0, 102, 102));
        txtidk.setBorder(null);
        getContentPane().add(txtidk);
        txtidk.setBounds(370, 113, 135, 23);

        txtnk.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtnk.setForeground(new java.awt.Color(0, 102, 102));
        txtnk.setBorder(null);
        txtnk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnkActionPerformed(evt);
            }
        });
        getContentPane().add(txtnk);
        txtnk.setBounds(370, 142, 185, 23);

        txtsearch.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(0, 102, 102));
        txtsearch.setBorder(null);
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        getContentPane().add(txtsearch);
        txtsearch.setBounds(798, 354, 290, 30);

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Search D.png"))); // NOI18N
        search.setBorderPainted(false);
        search.setContentAreaFilled(false);
        search.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Search L.png"))); // NOI18N
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(1088, 359, 83, 37);

        btfk.setBackground(new java.awt.Color(255, 255, 255));
        btfk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/FK L.png"))); // NOI18N
        btfk.setBorderPainted(false);
        btfk.setContentAreaFilled(false);
        btfk.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/FK D.png"))); // NOI18N
        btfk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btfkMouseClicked(evt);
            }
        });
        btfk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfkActionPerformed(evt);
            }
        });
        getContentPane().add(btfk);
        btfk.setBounds(0, 320, 219, 54);

        btfp1.setBackground(new java.awt.Color(255, 255, 255));
        btfp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/FP L.png"))); // NOI18N
        btfp1.setBorderPainted(false);
        btfp1.setContentAreaFilled(false);
        btfp1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/FP D.png"))); // NOI18N
        btfp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btfp1MouseClicked(evt);
            }
        });
        btfp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfp1ActionPerformed(evt);
            }
        });
        getContentPane().add(btfp1);
        btfp1.setBounds(0, 370, 219, 54);

        signOut1.setBackground(new java.awt.Color(255, 255, 255));
        signOut1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Sign Out L.png"))); // NOI18N
        signOut1.setBorderPainted(false);
        signOut1.setContentAreaFilled(false);
        signOut1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Sign Out D.png"))); // NOI18N
        signOut1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signOut1MouseClicked(evt);
            }
        });
        signOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOut1ActionPerformed(evt);
            }
        });
        getContentPane().add(signOut1);
        signOut1.setBounds(20, 550, 91, 28);

        clear.setBackground(new java.awt.Color(255, 255, 255));
        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Clear D.png"))); // NOI18N
        clear.setBorderPainted(false);
        clear.setContentAreaFilled(false);
        clear.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Clear L.png"))); // NOI18N
        clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearMouseClicked(evt);
            }
        });
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(410, 360, 91, 32);

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Del D.png"))); // NOI18N
        delete.setBorderPainted(false);
        delete.setContentAreaFilled(false);
        delete.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Del L.png"))); // NOI18N
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(500, 360, 91, 32);

        print.setBackground(new java.awt.Color(255, 255, 255));
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Print D.png"))); // NOI18N
        print.setBorderPainted(false);
        print.setContentAreaFilled(false);
        print.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Print L.png"))); // NOI18N
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
        });
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        print.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                printPropertyChange(evt);
            }
        });
        getContentPane().add(print);
        print.setBounds(590, 360, 91, 32);

        find.setBackground(new java.awt.Color(255, 255, 255));
        find.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Find D_1.png"))); // NOI18N
        find.setBorderPainted(false);
        find.setContentAreaFilled(false);
        find.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/FInd L_1.png"))); // NOI18N
        find.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findMouseClicked(evt);
            }
        });
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });
        getContentPane().add(find);
        find.setBounds(510, 120, 49, 20);

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Add D.png"))); // NOI18N
        add.setBorderPainted(false);
        add.setContentAreaFilled(false);
        add.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Add L.png"))); // NOI18N
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add);
        add.setBounds(230, 360, 91, 32);

        count.setBackground(new java.awt.Color(255, 255, 255));
        count.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Count D.png"))); // NOI18N
        count.setBorderPainted(false);
        count.setContentAreaFilled(false);
        count.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Count L.png"))); // NOI18N
        count.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countMouseClicked(evt);
            }
        });
        count.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countActionPerformed(evt);
            }
        });
        getContentPane().add(count);
        count.setBounds(1080, 275, 91, 32);

        check.setBackground(new java.awt.Color(255, 255, 255));
        check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Check D.png"))); // NOI18N
        check.setBorderPainted(false);
        check.setContentAreaFilled(false);
        check.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Check L.png"))); // NOI18N
        check.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkMouseClicked(evt);
            }
        });
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        getContentPane().add(check);
        check.setBounds(510, 202, 49, 20);

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Update D.png"))); // NOI18N
        update.setBorderPainted(false);
        update.setContentAreaFilled(false);
        update.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Update L.png"))); // NOI18N
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(320, 360, 91, 32);

        txttq2.setEditable(false);
        txttq2.setBackground(new java.awt.Color(255, 255, 255));
        txttq2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txttq2.setForeground(new java.awt.Color(0, 102, 102));
        txttq2.setBorder(null);
        getContentPane().add(txttq2);
        txttq2.setBounds(640, 154, 110, 23);

        txttq3.setEditable(false);
        txttq3.setBackground(new java.awt.Color(255, 255, 255));
        txttq3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txttq3.setForeground(new java.awt.Color(0, 102, 102));
        txttq3.setBorder(null);
        getContentPane().add(txttq3);
        txttq3.setBounds(640, 197, 110, 23);

        txttq4.setEditable(false);
        txttq4.setBackground(new java.awt.Color(255, 255, 255));
        txttq4.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txttq4.setForeground(new java.awt.Color(0, 102, 102));
        txttq4.setBorder(null);
        getContentPane().add(txttq4);
        txttq4.setBounds(640, 238, 110, 23);

        txttq1.setEditable(false);
        txttq1.setBackground(new java.awt.Color(255, 255, 255));
        txttq1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txttq1.setForeground(new java.awt.Color(0, 102, 102));
        txttq1.setBorder(null);
        getContentPane().add(txttq1);
        txttq1.setBounds(640, 113, 110, 23);

        txthkg1.setEditable(false);
        txthkg1.setBackground(new java.awt.Color(255, 255, 255));
        txthkg1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txthkg1.setForeground(new java.awt.Color(0, 102, 102));
        txthkg1.setBorder(null);
        getContentPane().add(txthkg1);
        txthkg1.setBounds(420, 263, 50, 23);

        txtkkg2.setEditable(false);
        txtkkg2.setBackground(new java.awt.Color(255, 255, 255));
        txtkkg2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtkkg2.setForeground(new java.awt.Color(0, 102, 102));
        txtkkg2.setBorder(null);
        getContentPane().add(txtkkg2);
        txtkkg2.setBounds(250, 289, 50, 23);

        txthkg2.setEditable(false);
        txthkg2.setBackground(new java.awt.Color(255, 255, 255));
        txthkg2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txthkg2.setForeground(new java.awt.Color(0, 102, 102));
        txthkg2.setBorder(null);
        getContentPane().add(txthkg2);
        txthkg2.setBounds(420, 289, 50, 23);

        txtkkg3.setEditable(false);
        txtkkg3.setBackground(new java.awt.Color(255, 255, 255));
        txtkkg3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtkkg3.setForeground(new java.awt.Color(0, 102, 102));
        txtkkg3.setBorder(null);
        getContentPane().add(txtkkg3);
        txtkkg3.setBounds(250, 314, 50, 23);

        txthkg3.setEditable(false);
        txthkg3.setBackground(new java.awt.Color(255, 255, 255));
        txthkg3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txthkg3.setForeground(new java.awt.Color(0, 102, 102));
        txthkg3.setBorder(null);
        getContentPane().add(txthkg3);
        txthkg3.setBounds(420, 314, 50, 23);

        txtkkg1.setEditable(false);
        txtkkg1.setBackground(new java.awt.Color(255, 255, 255));
        txtkkg1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtkkg1.setForeground(new java.awt.Color(0, 102, 102));
        txtkkg1.setBorder(null);
        getContentPane().add(txtkkg1);
        txtkkg1.setBounds(250, 263, 50, 23);

        printall.setBackground(new java.awt.Color(255, 255, 255));
        printall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Print All D.png"))); // NOI18N
        printall.setBorderPainted(false);
        printall.setContentAreaFilled(false);
        printall.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/Print all L.png"))); // NOI18N
        printall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printallMouseClicked(evt);
            }
        });
        printall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printallActionPerformed(evt);
            }
        });
        printall.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                printallPropertyChange(evt);
            }
        });
        getContentPane().add(printall);
        printall.setBounds(680, 360, 91, 32);

        txtss.setEditable(false);
        txtss.setBackground(new java.awt.Color(255, 255, 255));
        txtss.setFont(new java.awt.Font("Microsoft JhengHei", 1, 24)); // NOI18N
        txtss.setForeground(new java.awt.Color(204, 51, 0));
        txtss.setBorder(null);
        getContentPane().add(txtss);
        txtss.setBounds(900, 305, 260, 30);

        cbidjabatan.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        cbidjabatan.setForeground(new java.awt.Color(0, 102, 102));
        cbidjabatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbidjabatanMouseClicked(evt);
            }
        });
        cbidjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbidjabatanActionPerformed(evt);
            }
        });
        getContentPane().add(cbidjabatan);
        cbidjabatan.setBounds(370, 194, 135, 27);

        jtpencapaian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtpencapaian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtpencapaianMouseClicked(evt);
            }
        });
        jsuser.setViewportView(jtpencapaian);

        getContentPane().add(jsuser);
        jsuser.setBounds(239, 410, 941, 161);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        txtidjabatan12.setBackground(new java.awt.Color(204, 204, 204));
        txtidjabatan12.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtidjabatan12.setForeground(new java.awt.Color(0, 102, 102));
        txtidjabatan12.setBorder(null);
        jPanel1.add(txtidjabatan12);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1208, 40);

        BG.setBackground(new java.awt.Color(255, 255, 255));
        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/LDP Admin_Form Pencapaian.png"))); // NOI18N
        getContentPane().add(BG);
        BG.setBounds(0, 0, 1208, 608);

        setSize(new java.awt.Dimension(1208, 608));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged

      int kordinatX = evt.getXOnScreen();
      int kordinatY = evt.getYOnScreen();
      
      this.setLocation(kordinatX-604,kordinatY-21);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_exitMouseClicked

    private void MinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeMouseClicked
        
        this.setState(aPencapaian.ICONIFIED);
        // TODO add your handling code here:
    }//GEN-LAST:event_MinimizeMouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked

        search();
        // TODO add your handling code here:
    }//GEN-LAST:event_searchMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void btfkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btfkMouseClicked

        aFormKaryawan fk = new aFormKaryawan();
        fk.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btfkMouseClicked

    private void btfkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btfkActionPerformed

    private void btfp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btfp1MouseClicked

        aPencapaian fp = new aPencapaian();
        fp.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btfp1MouseClicked

    private void btfp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btfp1ActionPerformed

    private void signOut1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOut1MouseClicked

        MainDashBoard md = new MainDashBoard();
        md.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_signOut1MouseClicked

    private void signOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOut1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signOut1ActionPerformed

    private void clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearMouseClicked

        clear_data();
        cbjabatan ();
        setTombol(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_clearMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked

        try{
         
        String sql = "Delete FROM fpencapaian  WHERE idkaryawan= '"+txtidk.getText()+"'";
        java.sql.Connection conn = (Connection)koneksi.configDB();
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.execute();
        JOptionPane.showMessageDialog(null,"Hapus Data Berhasil");
        tampilkan_data();
        clear_data();      
        cbjabatan ();
        setTombol(true);
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
        
        }  
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_printMouseClicked

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed

        try {

  String path="src/report/Pencapaian.jasper";      // letak penyimpanan report

  HashMap parameter = new HashMap();

  parameter.put("parameter1",this.txtidk.getText());   
// "no_faktur" => nama parameter yang dibuat
 //jTextFieldnofaktur.getText() ==> disesuaikan dengan jTextField yang digunakan
   Connection konek =  koneksi.configDB();

  JasperPrint cetak = JasperFillManager.fillReport(path,parameter,konek);

  JasperViewer.viewReport(cetak, false);

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada "+ex);
    }

        // TODO add your handling code here:
    }//GEN-LAST:event_printActionPerformed

    private void findMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findMouseClicked

         try {
            
            String sql = "SELECT * FROM fkaryawan WHERE idkaryawan = '"+ txtidk.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
           while  (res.next())
           
           {   
            
            String idk  = res.getString("idkaryawan");
            String nk   = res.getString("namakaryawan");
            String jabb = res.getString("jabatan");
            
            txtidk.setText(idk);
            txtnk.setText(nk);
            txtjabatan.setText(jabb);
            
            check.setEnabled(true);
            clear.setEnabled(true);
            
           }
        } catch (SQLException e){
            System.out.println("error" + e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_findMouseClicked

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findActionPerformed

    private void countMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countMouseClicked

         int inc ,ss; 
        
         double dtq1 = Double.parseDouble(txttq1.getText());
         double dpq1 = Double.parseDouble(txtpq1.getText());
         
         double dtq2 = Double.parseDouble(txttq2.getText());
         double dpq2 = Double.parseDouble(txtpq2.getText());
         
         double dtq3 = Double.parseDouble(txttq3.getText());
         double dpq3 = Double.parseDouble(txtpq3.getText());
         
         double dtq4 = Double.parseDouble(txttq4.getText());
         double dpq4 = Double.parseDouble(txtpq4.getText());
         
         double dkkg1 = Double.parseDouble(txtkkg1.getText());
         double dkkg2 = Double.parseDouble(txtkkg2.getText());
         double dkkg3 = Double.parseDouble(txtkkg3.getText());

         int dhkg1 = Integer.parseInt(txthkg1.getText());
         int dhkg2 = Integer.parseInt(txthkg2.getText());
         int dhkg3 = Integer.parseInt(txthkg3.getText());
         
         int dcs = Integer.parseInt(txtcs.getText());
        
        
            
        // Hitung Persentase
        double hq1 = (dpq1/dtq1)*100;
        double hq2 = (dpq2/dtq2)*100;
        double hq3 = (dpq3/dtq3)*100;
        double hq4 = (dpq4/dtq4)*100;
        
        // Average Percentation
        
        double ap = (hq1 + hq2 + hq3 + hq4)/4;
        
        // konversi jumlah anka desimal
        DecimalFormat df = new DecimalFormat("#.#");
        
        
       
       
        // Input Kedalam Text Field
            
        txtppq1.setText(""+df.format(hq1));
        txtppq2.setText(""+df.format(hq2));
        txtppq3.setText(""+df.format(hq3));
        txtppq4.setText(""+df.format(hq4));
        
        txtap.setText(""+df.format(ap));
        
        // Logic kenaikan Gaji
        
        if ( ap > dkkg1 ) {
        
            inc = (dhkg1 * dcs)/100;
        
        } else if (ap >= dkkg2 ){
            
            inc = (dhkg2 * dcs)/100;
            
        } else if ( ap >= dkkg3 ){
            
            inc = (dhkg3 * dcs)/100;
            
        }  else {
            
            inc = (0 * dcs)/100;
        }
            
            ss = dcs + inc;
         
        // Set SUbmission Salary   
            
            txtss.setText(""+ss);
            
            add.setEnabled(true);
        
        
    }//GEN-LAST:event_countMouseClicked

    private void countActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked

        try{
            
            String sql ="INSERT INTO fpencapaian VALUES ('"+txtidk.getText()+"','"+txtnk.getText()+"','"+txtjabatan.getText()+"','"+cbidjabatan.getSelectedItem()+"','"+txtpq1.getText()+"','"+txtpq2.getText()+"','"+txtpq3.getText()+"','"+txtpq4.getText()+"','"+txtppq1.getText()+"','"+txtppq2.getText()+"','"+txtppq3.getText()+"','"+txtppq4.getText()+"','"+txtap.getText()+"','"+txtcs.getText()+"','"+txtss.getText()+"')";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Proses Data Simpan Data Berhasil");
            tampilkan_data();
            clear_data();
            cbjabatan ();
            setTombol(true);
                    
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void cbidjabatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbidjabatanMouseClicked

        
        // TODO add your handling code here:
    }//GEN-LAST:event_cbidjabatanMouseClicked

    private void cbidjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbidjabatanActionPerformed

        
        // TODO add your handling code here:
    }//GEN-LAST:event_cbidjabatanActionPerformed

    private void checkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMouseClicked

        try {
            
            String sql = "SELECT * FROM ftarget WHERE idjabatan = '"+ cbidjabatan.getSelectedItem() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
           while  (res.next())
           
           {   
               
               
               
           // function Pengambilan data dari database + conversi data    
            
            String kkg1  = res.getString("kkg1");
           
            String kkg2  = res.getString("kkg2");
            
            String kkg3  = res.getString("kkg3");
            
            String hkg1  = res.getString("hkg1");
           
            String hkg2  = res.getString("hkg2");
            
            String hkg3  = res.getString("hkg3");
            
            String tq1  = res.getString("tq1");
            
            String tq2  = res.getString("tq2");
            
            String tq3  = res.getString("tq3");
            
            String tq4  = res.getString("tq4");
            
            
            // function Hitung persentase satuan
            
           // Tampilkan data ke field
            
            txtkkg1.setText(kkg1);
            txtkkg2.setText(kkg2);
            txtkkg3.setText(kkg3);
            
            txthkg1.setText(hkg1);
            txthkg2.setText(hkg2);
            txthkg3.setText(hkg3);
            
            txttq1.setText(tq1);
            txttq2.setText(tq2);
            txttq3.setText(tq3);
            txttq4.setText(tq4);
            
            
           }
           
        } catch (SQLException e){
            System.out.println("error" + e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_checkMouseClicked

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkActionPerformed

    private void txtnkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnkActionPerformed

    private void txtcsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcsActionPerformed

    private void txtcsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcsKeyReleased

        count.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcsKeyReleased

    private void jtpencapaianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtpencapaianMouseClicked

        int baris = jtpencapaian.rowAtPoint(evt.getPoint());
        
        String nik = jtpencapaian.getValueAt(baris, 1).toString();
        txtidk.setText(nik);
        
        String nama = jtpencapaian.getValueAt(baris, 2).toString();
        txtnk.setText(nama);
        
        String jab = jtpencapaian.getValueAt(baris, 3).toString();
        txtjabatan.setText(jab);
        
        String idjab = jtpencapaian.getValueAt(baris, 4).toString();
        cbidjabatan.setSelectedItem(idjab);
       
        String pq1 = jtpencapaian.getValueAt(baris, 5).toString();
        txtpq1.setText(pq1);
        
        String pq2 = jtpencapaian.getValueAt(baris, 6).toString();
        txtpq2.setText(pq2);
        
        String pq3 = jtpencapaian.getValueAt(baris, 7).toString();
        txtpq3.setText(pq3);
        
        String pq4 = jtpencapaian.getValueAt(baris, 8).toString();
        txtpq4.setText(pq4);
        
        String ppq1 = jtpencapaian.getValueAt(baris, 9).toString();
        txtppq1.setText(ppq1);
        
        String ppq2 = jtpencapaian.getValueAt(baris, 10).toString();
        txtppq2.setText(ppq2);
        
        String ppq3 = jtpencapaian.getValueAt(baris, 11).toString();
        txtppq3.setText(ppq3);
        
        String ppq4 = jtpencapaian.getValueAt(baris, 12).toString();
        txtppq4.setText(ppq4);
        
        String ap = jtpencapaian.getValueAt(baris, 13).toString();
        txtap.setText(ap);
        
        String cs = jtpencapaian.getValueAt(baris, 14).toString();
        txtcs.setText(cs);
        
        String ss = jtpencapaian.getValueAt(baris, 15).toString();
        txtss.setText(ss);
        
        setTombol(true);
        delete.setEnabled(true);
        check.setEnabled(true);
        clear.setEnabled(true);
        count.setEnabled(true);
        update.setEnabled(true);
        print.setEnabled(true);
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jtpencapaianMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked

        try{

            String sql = "UPDATE fpencapaian SET idkaryawan = '"+txtidk.getText()+"',namakaryawan = '"+txtnk.getText()+"',jabatan = '"+txtjabatan.getText()+"',idjabatan = '"+cbidjabatan.getSelectedItem()+"',pq1 = '"+txtpq1.getText()+"',pq2 = '"+txtpq2.getText()+"',pq3 = '"+txtpq3.getText()+"',pq4 = '"+txtpq4.getText()+"', ppq1 = '"+txtppq1.getText()+"', ppq2 = '"+txtppq2.getText()+"', ppq3 = '"+txtppq3.getText()+"', ppq4 = '"+txtppq4.getText()+"',ap = '"+txtap.getText()+"', cs = '"+txtcs.getText()+"', ss ='"+txtss.getText()+"' WHERE idkaryawan = '"+txtidk.getText()+"'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Update Data Berhasil");
            tampilkan_data();
            clear_data();

        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_updateMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void printPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_printPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_printPropertyChange

    private void printallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printallMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_printallMouseClicked

    private void printallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printallActionPerformed

         try {

  String path="src/report/Pencapaian_all.jasper";      // letak penyimpanan report

  HashMap parameter = new HashMap();

  parameter.put("parameter1",this.txtidk.getText());   
// "no_faktur" => nama parameter yang dibuat
 //jTextFieldnofaktur.getText() ==> disesuaikan dengan jTextField yang digunakan
   Connection konek =  koneksi.configDB();

  JasperPrint cetak = JasperFillManager.fillReport(path,parameter,konek);

  JasperViewer.viewReport(cetak, false);

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(rootPane,"Dokumen Tidak Ada "+ex);
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_printallActionPerformed

    private void printallPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_printallPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_printallPropertyChange

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
            java.util.logging.Logger.getLogger(aPencapaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aPencapaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aPencapaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aPencapaian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new aPencapaian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel Minimize;
    private javax.swing.JButton add;
    private javax.swing.JButton btfk;
    private javax.swing.JButton btfp1;
    private javax.swing.JComboBox<String> cbidjabatan;
    private javax.swing.JButton check;
    private javax.swing.JButton clear;
    private javax.swing.JButton count;
    private javax.swing.JButton delete;
    private javax.swing.JLabel exit;
    private javax.swing.JButton find;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jsuser;
    private javax.swing.JTable jtpencapaian;
    private javax.swing.JButton print;
    private javax.swing.JButton printall;
    private javax.swing.JButton search;
    private javax.swing.JButton signOut1;
    private javax.swing.JTextField txtap;
    private javax.swing.JTextField txtcs;
    private javax.swing.JTextField txthkg1;
    private javax.swing.JTextField txthkg2;
    private javax.swing.JTextField txthkg3;
    private javax.swing.JTextField txtidjabatan12;
    private javax.swing.JTextField txtidk;
    private javax.swing.JTextField txtjabatan;
    private javax.swing.JTextField txtkkg1;
    private javax.swing.JTextField txtkkg2;
    private javax.swing.JTextField txtkkg3;
    private javax.swing.JTextField txtnk;
    private javax.swing.JTextField txtppq1;
    private javax.swing.JTextField txtppq2;
    private javax.swing.JTextField txtppq3;
    private javax.swing.JTextField txtppq4;
    private javax.swing.JTextField txtpq1;
    private javax.swing.JTextField txtpq2;
    private javax.swing.JTextField txtpq3;
    private javax.swing.JTextField txtpq4;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtss;
    private javax.swing.JTextField txttq1;
    private javax.swing.JTextField txttq2;
    private javax.swing.JTextField txttq3;
    private javax.swing.JTextField txttq4;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
