/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Hotelmanagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ebruk
 */
public class reservation extends javax.swing.JFrame {

    /**
     * Creates new form reservation
     */
    
    public reservation() {
        initComponents();
        connect();
        
         //rezervasyon numarasını otomatik atar
        autoID();
        
       
        RoomTypel();
        RoomNo();
        BedType();
        Load_reservation();
        //tablodaki verileri veri tabanına yerleştirir
    }

    
      Connection con;
    PreparedStatement pst;
    DefaultTableModel d;
     public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagement","root","");
            System.out.println("Bağlantı başarıyla kuruldu.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     
     
     
     
     //otomatik atama
      public void autoID(){
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery("select MAX(reid) from  reservation");
            rs.next();
            rs.getString("MAX(reid)");
            if(rs.getString("MAX(reid)")==null){
                jLabel12.setText("RE001");
            }else
            {
                long id=Long.parseLong(rs.getString("MAX(reid)").substring(2,rs.getString("MAX(reid)").length()));
                id++;
                jLabel12.setText("RE"+String.format("%03d", id));

            } 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      
      
      
      public void RoomTypel(){
        try {
            pst=con.prepareStatement("select  Distinct rtype from room");
            ResultSet rs= pst.executeQuery();
            txtrtype.removeAllItems();
            while(rs.next()){
                txtrtype.addItem(rs.getString("rtype"));
            }        
            
        } catch (SQLException ex) {
            Logger.getLogger(reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      }
      
      
      
      
      
     
      
   public void Load_reservation() {
    int c;
    try {
        pst = con.prepareStatement("select *from reservation");
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData rsd = rs.getMetaData();
        c = rsd.getColumnCount();

        d = (DefaultTableModel) jTable1.getModel();
        d.setRowCount(0);

        while (rs.next()) {
            Vector v2 = new Vector();
            for (int i = 1; i <= c; i++) {
                v2.add(rs.getString("reid"));
                v2.add(rs.getString("name"));
                v2.add(rs.getString("mobile"));
                v2.add(rs.getString("checkin"));
                v2.add(rs.getString("checkout"));
                v2.add(rs.getString("rtype"));
                v2.add(rs.getString("roomno"));
                v2.add(rs.getString("bedtype"));
                v2.add(rs.getString("amount"));
            }
            d.addRow(v2);
        }

        // Tabloyu güncelle
        jTable1.setModel(d);

    } catch (SQLException ex) {
        Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
        ex.printStackTrace(); // Hatanın detaylarını consola yazdır
    }
}

      
      
      
      
      
        
      public void RoomNo(){
        try {
            pst=con.prepareStatement("select  Distinct rid from room");
            ResultSet rs= pst.executeQuery();
            txtro.removeAllItems();
            while(rs.next()){
                txtro.addItem(rs.getString("rid"));
            }        
            
        } catch (SQLException ex) {
            Logger.getLogger(reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      }
      
      
      
       public void BedType(){
        try {
            pst=con.prepareStatement("select  Distinct btype from room");
            ResultSet rs= pst.executeQuery();
            txtbtype.removeAllItems();
            while(rs.next()){
                txtbtype.addItem(rs.getString("btype"));
            }        
            
        } catch (SQLException ex) {
            Logger.getLogger(reservation.class.getName()).log(Level.SEVERE, null, ex);
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

        txtamoun = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtadress = new javax.swing.JTextField();
        txtcheckin = new com.toedter.calendar.JDateChooser();
        txtcheckout = new com.toedter.calendar.JDateChooser();
        txtrtype = new javax.swing.JComboBox<>();
        txtro = new javax.swing.JComboBox<>();
        txtmobile = new javax.swing.JTextField();
        txtbtype = new javax.swing.JComboBox<>();
        txtamount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtamoun.setBackground(new java.awt.Color(153, 153, 0));
        txtamoun.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("Rezervasyon");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("Rezervasyon No");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("İsim");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Adres");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Tel");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Giriş tarihi");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Çıkış Tarihi");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Oda Türü");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Oda Numarası");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Yatak Türü");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Tutar");

        txtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroActionPerformed(evt);
            }
        });

        txtbtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtypeActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setText("Kaydet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 204));
        jButton2.setText("Düzenle");

        jButton3.setBackground(new java.awt.Color(255, 255, 204));
        jButton3.setText("Sil");

        jButton4.setBackground(new java.awt.Color(255, 102, 102));
        jButton4.setText("Temizle");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RID", "Name", "Mobile", "CheckIn", "CheckOut", "RoomType", "RoomNo", "BedType", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("jLabel12");

        jButton5.setBackground(new java.awt.Color(102, 255, 255));
        jButton5.setText("Kapat");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtamounLayout = new javax.swing.GroupLayout(txtamoun);
        txtamoun.setLayout(txtamounLayout);
        txtamounLayout.setHorizontalGroup(
            txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtamounLayout.createSequentialGroup()
                .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtamounLayout.createSequentialGroup()
                        .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtamounLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(txtamounLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(txtamounLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(txtamounLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54))
                    .addGroup(txtamounLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)))
                .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtname)
                        .addComponent(txtadress)
                        .addComponent(txtcheckin, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(txtcheckout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtrtype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtmobile)
                        .addComponent(txtbtype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(txtamounLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(txtamounLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(58, 58, 58)
                        .addComponent(jButton2)
                        .addGap(53, 53, 53)
                        .addComponent(jButton3)
                        .addGap(43, 43, 43)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(23, 23, 23))))
            .addGroup(txtamounLayout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        txtamounLayout.setVerticalGroup(
            txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtamounLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtamounLayout.createSequentialGroup()
                        .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12))
                        .addGap(38, 38, 38)
                        .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtadress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtcheckin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(31, 31, 31)
                        .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtrtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbtype, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtamounLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(txtamoun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtamoun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbtypeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        
             String reno=jLabel12.getText();
        String name=txtname.getText();
        String adress=txtadress.getText();
        String mobile=txtmobile.getText();
        SimpleDateFormat df1=new SimpleDateFormat ("yyyy-mm-dd");
        String StartDate=df1.format(txtcheckin.getDate());
        
        
        SimpleDateFormat df2=new SimpleDateFormat ("yyyy-mm-dd");
        String EndDate=df1.format(txtcheckout.getDate());
        
        
        String rtype=txtrtype.getSelectedItem().toString();
                String bedtype=txtbtype.getSelectedItem().toString();
                   String amount=txtamount.getText();

         
          
               String roomno=txtro.getSelectedItem().toString();

        
        
      
        try {
            pst=con.prepareStatement("insert into reservation(reid,name,adress,mobile,checkin,checkout,bedtype,roomno,rtype,amount) values(?,?,?,?,?,?,?,?,?,?)");
         pst.setString(1, reno);
         pst.setString(2, name);
         pst.setString(3, adress);
         pst.setString(4, mobile);
         pst.setString(5, StartDate);
        pst.setString(6, EndDate);
         pst.setString(7, bedtype);
         pst.setString(8, roomno);
         pst.setString(9, rtype);
         pst.setString(10, amount);

         
         
         
         
         pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "rezervasyon eklendi");
            
            txtname.setText("");
            txtadress.setText("");    
            txtmobile.setText("");
                        txtadress.setText("");
                                    txtmobile.setText("");
 
            
            txtrtype.setSelectedIndex(-1);
            txtro.setSelectedIndex(-1);
            txtbtype.setSelectedIndex(-1);
            txtamount.setText("");
            autoID();
           // Load_room();

        } catch (SQLException ex) {
            Logger.getLogger(room.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtroActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        
        
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtadress;
    private javax.swing.JPanel txtamoun;
    private javax.swing.JTextField txtamount;
    private javax.swing.JComboBox<String> txtbtype;
    private com.toedter.calendar.JDateChooser txtcheckin;
    private com.toedter.calendar.JDateChooser txtcheckout;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JComboBox<String> txtro;
    private javax.swing.JComboBox<String> txtrtype;
    // End of variables declaration//GEN-END:variables
}
