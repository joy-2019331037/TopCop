
import java.awt.Color;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class AdminLogin extends javax.swing.JFrame {

    /**
     * Creates new form AdminLogin
     */
    public AdminLogin() {
        
        
        initComponents();
        
        invisibleEye.setVisible(false);
        this.setTitle("Admin");
           Image icon = new ImageIcon(this.getClass().getResource("/project_icon.png")).getImage();
        this.setIconImage(icon);
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jLabel1 = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        IDLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        IDText = new javax.swing.JTextField();
        PasswordText = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        visibleEye = new javax.swing.JLabel();
        invisibleEye = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        LoginButton.setBackground(new java.awt.Color(255, 255, 255));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 100, -1));

        CancelButton.setBackground(new java.awt.Color(255, 255, 255));
        CancelButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close_icon.png"))); // NOI18N
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 100, -1));

        IDLabel.setBackground(new java.awt.Color(204, 255, 255));
        IDLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        IDLabel.setText("ID No");
        IDLabel.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(IDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 55, -1));

        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PasswordLabel.setText("Password");
        getContentPane().add(PasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, -1, 82));

        IDText.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        IDText.setToolTipText("");
        getContentPane().add(IDText, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 170, -1));
        getContentPane().add(PasswordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 170, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        visibleEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/visibleEye.png"))); // NOI18N
        visibleEye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                visibleEyeMousePressed(evt);
            }
        });
        getContentPane().add(visibleEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, 30));

        invisibleEye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/invisibleEye.png"))); // NOI18N
        invisibleEye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                invisibleEyeMousePressed(evt);
            }
        });
        getContentPane().add(invisibleEye, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        setSize(new java.awt.Dimension(626, 432));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        if(IDText.getText().length()==0 || PasswordText.getText().length()==0){
           JOptionPane.showMessageDialog(this, "NID or Password is Blank.");
       }
        else{
             try {
                String id = IDText.getText();
                String password = PasswordText.getText();


                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
                pst = con.prepareStatement("select * from admin where id = ? and password=? ");
                pst.setString(1, id);
                pst.setString(2, password);
                rs = pst.executeQuery();
            
                if(rs.next()){
                    AdminWindow aw = new AdminWindow();
                    this.dispose();
                    aw.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(this, "NID or Password did not match.\nTry again.");
                    IDText.setText("");
                    PasswordText.setText("");
                    IDText.requestFocus();
                }
            
       } catch (ClassNotFoundException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
                
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // TODO add your handling code here:
        if(PasswordText.getText().length()!=0 || IDText.getText().length()!=0){
           PasswordText.setText("");
           IDText.setText("");
        }
        else{
            this.hide();
            home h = new home();
            h.setVisible(true);
        }
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void visibleEyeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visibleEyeMousePressed
        // TODO add your handling code here:
        visibleEye.setVisible(false);
        invisibleEye.setVisible(true);
        
        PasswordText.setEchoChar((char)0);
    }//GEN-LAST:event_visibleEyeMousePressed

    private void invisibleEyeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invisibleEyeMousePressed
        // TODO add your handling code here:
        invisibleEye.setVisible(false);
        visibleEye.setVisible(true);
        
        PasswordText.setEchoChar('*');
    }//GEN-LAST:event_invisibleEyeMousePressed

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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JTextField IDText;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JPasswordField PasswordText;
    private javax.swing.JLabel invisibleEye;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JLabel visibleEye;
    // End of variables declaration//GEN-END:variables
}
