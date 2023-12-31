
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.awt.Point;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class newUser extends javax.swing.JFrame {

    /**
     * Creates new form newUser
     */
    public newUser() {
        initComponents();
        createProfileButton.setBackground(Color.WHITE);
        this.setTitle("New User");
        createProfileButton.setBackground(Color.white);
        
        Image icon = new ImageIcon(this.getClass().getResource("/project_icon.png")).getImage();
        this.setIconImage(icon);
    }
   Connection con;
   PreparedStatement pst;

    @Override
    public boolean contains(int x, int y) {
        return super.contains(x, y); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    @Override
    public boolean contains(Point p) {
        return super.contains(p); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
        jLabel2 = new javax.swing.JLabel();
        NIdLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        confirmPasswordLabel = new javax.swing.JLabel();
        NIDText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        confirmPasswordText = new javax.swing.JPasswordField();
        createProfileButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        genderBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        IDtxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userIcon1.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 80, 103));

        NIdLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NIdLabel.setText("NID*");
        jPanel1.add(NIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 45, -1));

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passwordLabel.setText("Password");
        jPanel1.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 75, -1));

        confirmPasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmPasswordLabel.setText("Confirm Password");
        jPanel1.add(confirmPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));

        NIDText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(NIDText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 150, 20));

        passwordText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        passwordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextActionPerformed(evt);
            }
        });
        jPanel1.add(passwordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 150, -1));

        confirmPasswordText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmPasswordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordTextActionPerformed(evt);
            }
        });
        jPanel1.add(confirmPasswordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 160, -1));

        createProfileButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        createProfileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PROFILE.jpg"))); // NOI18N
        createProfileButton.setText("Create Profile");
        createProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProfileButtonActionPerformed(evt);
            }
        });
        jPanel1.add(createProfileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 140, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Gender");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Phone");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 80, -1));

        phone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        jPanel1.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 160, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Name ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        nameText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(nameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 150, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Email");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        email.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 150, -1));

        genderBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        genderBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Transgender" }));
        jPanel1.add(genderBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 160, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 70, -1));

        IDtxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(IDtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 390));

        setSize(new java.awt.Dimension(685, 426));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmPasswordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPasswordTextActionPerformed

    private void createProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProfileButtonActionPerformed

        if(IDtxt.getText().length()==0){
           JOptionPane.showMessageDialog(this, "ID Field cannot be empty.");
       }
       else if(NIDText.getText().length()==0){
           JOptionPane.showMessageDialog(this, "NID Field cannot be empty.");
       }
       else if(passwordText.getText().length()==0){
           JOptionPane.showMessageDialog(this, "Password Field cannot be empty.");
       }
       else if(confirmPasswordText.getText().equals(passwordText.getText())==false){
           JOptionPane.showMessageDialog(this, "Password did not match.\nTry again.");
       }
       else{
            try {
                String nid = NIDText.getText();
                String confirmPassword = confirmPasswordText.getText();
                
                
               Class.forName("com.mysql.jdbc.Driver");
               con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
               pst = con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
               
               pst.setString(1, IDtxt.getText());
               pst.setString(2, confirmPassword);
               pst.setString(3, nameText.getText());
               pst.setString(4, nid);
               pst.setString(5, genderBox.getSelectedItem().toString());
               pst.setString(6, email.getText());
               pst.setString(7, phone.getText());
               
               pst.executeUpdate();
    
               JOptionPane.showMessageDialog(null, "User Profile Created.");
               
               NIDText.setText("");
               confirmPasswordText.setText("");
               nameText.setText("");
               genderBox.setSelectedIndex(0);
               email.setText("");
               phone.setText("");
               IDtxt.setText("");
               
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex);
            } 
       
       }
    }//GEN-LAST:event_createProfileButtonActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void passwordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextActionPerformed

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
            java.util.logging.Logger.getLogger(newUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDtxt;
    private javax.swing.JTextField NIDText;
    private javax.swing.JLabel NIdLabel;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JPasswordField confirmPasswordText;
    private javax.swing.JButton createProfileButton;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> genderBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField phone;
    // End of variables declaration//GEN-END:variables
}
