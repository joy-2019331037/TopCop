
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class home extends javax.swing.JFrame {

    /**
     * Creates new form home
     */
    public home() {
        initComponents();
        userTypeButton.setBackground(Color.WHITE);
        enterButton.setBackground(Color.WHITE);
        this.setTitle("Home");
        Image icon = new ImageIcon(this.getClass().getResource("/project_icon.png")).getImage();
        this.setIconImage(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        userTypeButton = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox<>();
        enterButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 51));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Welcome to TOP-COP");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 290, 90));

        userTypeButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userTypeButton.setForeground(new java.awt.Color(255, 255, 255));
        userTypeButton.setText("User Type");
        getContentPane().add(userTypeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 80, -1));

        ComboBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });
        ComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBoxKeyPressed(evt);
            }
        });
        getContentPane().add(ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 80, -1));

        enterButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        enterButton.setText("Enter");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });
        getContentPane().add(enterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 72, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hehehe.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(652, 401));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxActionPerformed
    ActionEvent enterbuttonActionEvent;
    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed
        // TODO add your handling code here:
        enterbuttonActionEvent=evt;
        String SelectedItem = ComboBox.getSelectedItem().toString();
        if(SelectedItem=="User"){
            Login1 l = new Login1();
            this.hide(); //this line would destroy the current home.java window
            l.setVisible(true);
        }
        else{
          this.hide();
           new PRACTICE2().setVisible(true);
       }
    }//GEN-LAST:event_enterButtonActionPerformed

    private void ComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxKeyPressed
        enterButtonActionPerformed(enterbuttonActionEvent);
    }//GEN-LAST:event_ComboBoxKeyPressed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton enterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel userTypeButton;
    // End of variables declaration//GEN-END:variables
}
