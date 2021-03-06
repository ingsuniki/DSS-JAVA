package DSS;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author L - Arch
 */
public class aUser extends javax.swing.JFrame {

    /**
     * Creates new form MainDashBoard
     */
    
    private void clear_data(){
        txtiduser.setEditable(true);
        txtiduser.setText(null);
        txtusername.setText(null);
        txtpassword.setText(null);
        cbauthority.setSelectedItem(null);
        
    }
    
    private void tampilkan_data (){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("ID User");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Authority");
        
        try {
            int no = 1;
            String sql = "SELECT * FROM fuser";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()){
                model.addRow(new Object []{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }
            jtuser.setModel(model);
            
        } catch (SQLException e){
            System.out.println("error" + e.getMessage());
        }
    }
    
    public void search ()
    {
    
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID User");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Authority");
        
        try {
            int no = 1;
            String sql = "SELECT * FROM fuser WHERE idPengguna LIKE '%"+txtsearch.getText()+"%'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while (res.next()){
                model.addRow(new Object []{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4)});
            }
            jtuser.setModel(model);
            
        } catch (SQLException e){
            System.out.println("error" + e.getMessage());
        }
    }
    
    
    
    
    
    
    public aUser() {
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
        btft = new javax.swing.JButton();
        btur = new javax.swing.JButton();
        signOut1 = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        cbauthority = new javax.swing.JComboBox<>();
        txtusername = new javax.swing.JTextField();
        txtsearch = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        txtiduser = new javax.swing.JTextField();
        jsuser = new javax.swing.JScrollPane();
        jtuser = new javax.swing.JTable();
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
        update.setBounds(350, 270, 91, 32);

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
        search.setBounds(1088, 271, 83, 37);

        btft.setBackground(new java.awt.Color(255, 255, 255));
        btft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/FT L.png"))); // NOI18N
        btft.setBorderPainted(false);
        btft.setContentAreaFilled(false);
        btft.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/FT D.png"))); // NOI18N
        btft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btftMouseClicked(evt);
            }
        });
        btft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btftActionPerformed(evt);
            }
        });
        getContentPane().add(btft);
        btft.setBounds(0, 320, 219, 54);

        btur.setBackground(new java.awt.Color(255, 255, 255));
        btur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/FU L.png"))); // NOI18N
        btur.setBorderPainted(false);
        btur.setContentAreaFilled(false);
        btur.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/FU D.png"))); // NOI18N
        btur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bturMouseClicked(evt);
            }
        });
        btur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bturActionPerformed(evt);
            }
        });
        getContentPane().add(btur);
        btur.setBounds(0, 370, 219, 54);

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
        clear.setBounds(450, 270, 91, 32);

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
        delete.setBounds(550, 270, 91, 32);

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
        add.setBounds(250, 270, 91, 32);

        cbauthority.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        cbauthority.setForeground(new java.awt.Color(0, 102, 102));
        cbauthority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Manager" }));
        cbauthority.setBorder(null);
        cbauthority.setOpaque(false);
        getContentPane().add(cbauthority);
        cbauthority.setBounds(840, 163, 250, 30);

        txtusername.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtusername.setForeground(new java.awt.Color(0, 102, 102));
        txtusername.setBorder(null);
        getContentPane().add(txtusername);
        txtusername.setBounds(415, 165, 280, 30);

        txtsearch.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtsearch.setForeground(new java.awt.Color(0, 102, 102));
        txtsearch.setBorder(null);
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        getContentPane().add(txtsearch);
        txtsearch.setBounds(698, 265, 390, 30);

        txtpassword.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(0, 102, 102));
        txtpassword.setBorder(null);
        getContentPane().add(txtpassword);
        txtpassword.setBounds(415, 208, 280, 30);

        txtiduser.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtiduser.setForeground(new java.awt.Color(0, 102, 102));
        txtiduser.setBorder(null);
        getContentPane().add(txtiduser);
        txtiduser.setBounds(415, 123, 280, 30);

        jtuser.setModel(new javax.swing.table.DefaultTableModel(
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
        jtuser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtuserMouseClicked(evt);
            }
        });
        jsuser.setViewportView(jtuser);

        getContentPane().add(jsuser);
        jsuser.setBounds(253, 319, 914, 260);

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
        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DSS/image/DDP Admin_User Management.png"))); // NOI18N
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
         
        String sql = "UPDATE fuser SET idPengguna= '"+txtiduser.getText()+"',username = '"+txtusername.getText()+"',password = '"+txtpassword.getText()+"',authority = '"+cbauthority.getSelectedItem()+"' WHERE idPengguna = '"+txtiduser.getText()+"'";
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

    private void btftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btftMouseClicked

        aFormTarget ft = new aFormTarget();
        ft.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btftMouseClicked

    private void btftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btftActionPerformed
       
    // TODO add your handling code here:
    }//GEN-LAST:event_btftActionPerformed

    private void bturMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bturMouseClicked

        aUser ur = new aUser();
        ur.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_bturMouseClicked

    private void bturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bturActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bturActionPerformed

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
         
        String sql = "Delete FROM fuser WHERE idPengguna = '"+txtiduser.getText()+"'";
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
            
            String sql ="INSERT INTO fuser VALUES ('"+txtiduser.getText()+"','"+txtusername.getText()+"','"+txtpassword.getText()+"','"+cbauthority.getSelectedItem()+"')";
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

    private void jtuserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtuserMouseClicked

        int baris = jtuser.rowAtPoint(evt.getPoint());
        
        String idur = jtuser.getValueAt(baris, 1).toString();
        txtiduser.setText(idur);
        
        String ur = jtuser.getValueAt(baris, 2).toString();
        txtusername.setText(ur);
        
        String pass = jtuser.getValueAt(baris, 3).toString();
        txtpassword.setText(pass);
        
        String ot = jtuser.getValueAt(baris, 4).toString();
        cbauthority.setSelectedItem(ot);
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jtuserMouseClicked

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

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
            java.util.logging.Logger.getLogger(aUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new aUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel Minimize;
    private javax.swing.JButton add;
    private javax.swing.JButton btft;
    private javax.swing.JButton btur;
    private javax.swing.JComboBox<String> cbauthority;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JLabel exit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jsuser;
    private javax.swing.JTable jtuser;
    private javax.swing.JButton search;
    private javax.swing.JButton signOut1;
    private javax.swing.JTextField txtiduser;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JTextField txtusername;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
