package DSS;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class aFormKaryawan extends javax.swing.JFrame {

    /**
     * Creates new form MainDashBoard
     */
    
    
    private void clear_data(){
        txtidk.setEditable(true);
        txtidk.setText(null);
        txtnk.setText(null);
        cbjabatan.setSelectedItem(this);
        txtalamat.setText(null);
        txttelp.setText(null);
        txtemail.setText(null);
        
    }
    
    private void tampilkan_data (){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("NIK");
        model.addColumn("Nama Karyawan");
        model.addColumn("Jabatan");
        model.addColumn("Alamat");
        model.addColumn("Email");
        model.addColumn("No. Telpon");
        
        
        
        try {
            int no = 1;
            String sql = "SELECT * FROM fkaryawan";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()){
                model.addRow(new Object []{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }
            jtkaryawan.setModel(model);
            
        } catch (SQLException e){
            System.out.println("error" + e.getMessage());
        }
    }
    
    public void search ()
    {
    
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("NIK");
        model.addColumn("Nama Karyawan");
        model.addColumn("Jabatan");
        model.addColumn("Alamat");
        model.addColumn("Email");
        model.addColumn("No. Telpon");
        
        
        
        try {
            int no = 1;
            String sql = "SELECT * FROM fkaryawan WHERE idkaryawan LIKE '%"+txtsearch.getText()+"%'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()){
                model.addRow(new Object []{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }
            jtkaryawan.setModel(model);
            
        } catch (SQLException e){
            System.out.println("error" + e.getMessage());
        }
    
    }
            
    public aFormKaryawan() {
            initComponents();
            this.setBackground (new Color(0,0,0,0));
            tampilkan_data ();
            clear_data();
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
        update = new javax.swing.JButton();
        search = new javax.swing.JButton();
        btfk = new javax.swing.JButton();
        btfp = new javax.swing.JButton();
        signOut1 = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        txtnk = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        txttelp = new javax.swing.JTextField();
        txtidk = new javax.swing.JTextField();
        cbjabatan = new javax.swing.JComboBox<>();
        jskaryawan = new javax.swing.JScrollPane();
        jtkaryawan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
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
        update.setBounds(350, 260, 91, 32);

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
        search.setBounds(1090, 273, 83, 37);

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

        btfp.setBackground(new java.awt.Color(255, 255, 255));
        btfp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/FP L.png"))); // NOI18N
        btfp.setBorderPainted(false);
        btfp.setContentAreaFilled(false);
        btfp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/FP D.png"))); // NOI18N
        btfp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btfpMouseClicked(evt);
            }
        });
        btfp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfpActionPerformed(evt);
            }
        });
        getContentPane().add(btfp);
        btfp.setBounds(0, 370, 219, 54);

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
        clear.setBounds(450, 260, 91, 32);

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
        delete.setBounds(550, 260, 91, 32);

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
        add.setBounds(250, 260, 91, 32);

        txtsearch.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(0, 102, 102));
        txtsearch.setBorder(null);
        getContentPane().add(txtsearch);
        txtsearch.setBounds(730, 268, 360, 30);

        txtnk.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtnk.setForeground(new java.awt.Color(0, 102, 102));
        txtnk.setBorder(null);
        getContentPane().add(txtnk);
        txtnk.setBounds(415, 160, 280, 30);

        txtemail.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtemail.setForeground(new java.awt.Color(0, 102, 102));
        txtemail.setBorder(null);
        getContentPane().add(txtemail);
        txtemail.setBounds(830, 160, 335, 30);

        txtalamat.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtalamat.setForeground(new java.awt.Color(0, 102, 102));
        txtalamat.setBorder(null);
        getContentPane().add(txtalamat);
        txtalamat.setBounds(830, 118, 335, 30);

        txttelp.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txttelp.setForeground(new java.awt.Color(0, 102, 102));
        txttelp.setBorder(null);
        getContentPane().add(txttelp);
        txttelp.setBounds(830, 202, 335, 30);

        txtidk.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtidk.setForeground(new java.awt.Color(0, 102, 102));
        txtidk.setBorder(null);
        getContentPane().add(txtidk);
        txtidk.setBounds(415, 118, 280, 30);

        cbjabatan.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        cbjabatan.setForeground(new java.awt.Color(0, 102, 102));
        cbjabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administration", "B2B", "Computer Graphics Operator", "Marketing", "Sales Counter", "Store Manager", "Supervisor", "Telemarketing" }));
        cbjabatan.setBorder(null);
        cbjabatan.setOpaque(false);
        getContentPane().add(cbjabatan);
        cbjabatan.setBounds(416, 200, 270, 30);

        jtkaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jtkaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtkaryawanMouseClicked(evt);
            }
        });
        jskaryawan.setViewportView(jtkaryawan);

        getContentPane().add(jskaryawan);
        jskaryawan.setBounds(253, 321, 914, 245);

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
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1208, 40);

        BG.setBackground(new java.awt.Color(255, 255, 255));
        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/DP Admin_Form Karyawan.png"))); // NOI18N
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
        
        this.setState(this.ICONIFIED);
        // TODO add your handling code here:
    }//GEN-LAST:event_MinimizeMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked

        try{
         
        String sql = "UPDATE fkaryawan SET idkaryawan = '"+txtidk.getText()+"',namakaryawan = '"+txtnk.getText()+"',jabatan = '"+cbjabatan.getSelectedItem()+"',alamat = '"+txtalamat.getText()+"',Email = '"+txtemail.getText()+"',Telp = '"+txttelp.getText()+"' WHERE idkaryawan = '"+txtidk.getText()+"'";
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

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked

        search();
        // TODO add your handling code here:
    }//GEN-LAST:event_searchMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void btfkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btfkMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btfkMouseClicked

    private void btfkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfkActionPerformed
    
        aFormKaryawan fk = new aFormKaryawan();
        fk.setVisible(true);
        this.setVisible(false);
        
    // TODO add your handling code here:
    }//GEN-LAST:event_btfkActionPerformed

    private void btfpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btfpMouseClicked

        aPencapaian fp = new aPencapaian();
        fp.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btfpMouseClicked

    private void btfpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btfpActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_clearMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked

        try{
         
        String sql = "Delete FROM fkaryawan  WHERE idkaryawan= '"+txtidk.getText()+"'";
        java.sql.Connection conn = (Connection)koneksi.configDB();
        java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.execute();
        JOptionPane.showMessageDialog(null,"Hapus Data Berhasil");
        tampilkan_data();
        clear_data();      
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
        }  
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteMouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked

        try{
            
            String sql ="INSERT INTO fkaryawan VALUES ('"+txtidk.getText()+"','"+txtnk.getText()+"','"+cbjabatan.getSelectedItem()+"','"+txtalamat.getText()+"','"+txtemail.getText()+"','"+txttelp.getText()+"')";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Proses Data Simpan Data Berhasil");
            tampilkan_data();
            clear_data();
                    
        }catch(HeadlessException | SQLException e){
        JOptionPane.showMessageDialog(this, e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void jtkaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtkaryawanMouseClicked

        int baris = jtkaryawan.rowAtPoint(evt.getPoint());
        
        String nik = jtkaryawan.getValueAt(baris, 1).toString();
        txtidk.setText(nik);
        
        String nama = jtkaryawan.getValueAt(baris, 2).toString();
        txtnk.setText(nama);
        
        String jab = jtkaryawan.getValueAt(baris, 3).toString();
        cbjabatan.setSelectedItem(jab);
       
        String alamat = jtkaryawan.getValueAt(baris, 4).toString();
        txtalamat.setText(alamat);
        
        String email = jtkaryawan.getValueAt(baris, 5).toString();
        txtemail.setText(email);
        
        String telp = jtkaryawan.getValueAt(baris, 6).toString();
        txttelp.setText(telp);
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jtkaryawanMouseClicked

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
            java.util.logging.Logger.getLogger(aFormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aFormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aFormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aFormKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new aFormKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel Minimize;
    private javax.swing.JButton add;
    private javax.swing.JButton btfk;
    private javax.swing.JButton btfp;
    private javax.swing.JComboBox<String> cbjabatan;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JLabel exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jskaryawan;
    private javax.swing.JTable jtkaryawan;
    private javax.swing.JButton search;
    private javax.swing.JButton signOut1;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtidk;
    private javax.swing.JTextField txtnk;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txttelp;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
