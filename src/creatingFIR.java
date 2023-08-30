import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
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
public class creatingFIR extends javax.swing.JFrame {

    /**
     * Creates new form creatingFIR
     */
    
   
    public static String id;
    public creatingFIR() {
        
        initComponents();
        fileFIRbutton.setBackground(Color.WHITE);
        
        this.setTitle("Creating FIR");
        Image icon = new ImageIcon(this.getClass().getResource("/project_icon.png")).getImage();
        this.setIconImage(icon);
        
        this.setVisible(true);
        reportIDtxt.setText(id);
        reportIDtxt.setEditable(false);
        consentRequestedPanel.setVisible(false);
        fileFIRbutton.setVisible(false);
        checkIFconsentISalreadyRequested();
        checkIFconsentISgiven();
    }
    
    
    public void checkIFconsentISalreadyRequested(){
        int ID = Integer.parseInt(id);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
            PreparedStatement pst = con.prepareStatement("select id,consentRequested from progress where id=?");
            
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("consentRequested").equals("y")){
                    requestConsentPanel.setVisible(false);
                    consentRequestedPanel.setVisible(true);
                }
            }
            
        }catch (Exception e){
            
        }
    }
    
    public void checkIFconsentISgiven(){
        int ID = Integer.parseInt(id);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
            PreparedStatement pst = con.prepareStatement("select id,consentGiven from progress where id=?");
            
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("consentGiven").equals("y")){
                    requestConsentPanel.setVisible(false);
                    consentRequestedPanel.setVisible(false);
                    JOptionPane.showMessageDialog(this, "Complaint filer has given consent for FIR creation.\nYou may proceed now.");
                    fileFIRbutton.setVisible(true);
                }
            }
            
        }catch (Exception e){
            
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        reportIDtxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        requestConsentPanel = new javax.swing.JPanel();
        requestConsentLabel = new javax.swing.JLabel();
        consentRequestedPanel = new javax.swing.JPanel();
        consentRequestedLabel = new javax.swing.JLabel();
        fileFIRbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Report ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));
        jPanel1.add(reportIDtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 92, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        requestConsentPanel.setBackground(new java.awt.Color(204, 204, 255));
        requestConsentPanel.setForeground(new java.awt.Color(255, 255, 255));
        requestConsentPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                requestConsentPanelMouseClicked(evt);
            }
        });

        requestConsentLabel.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        requestConsentLabel.setText("Request Consent");

        javax.swing.GroupLayout requestConsentPanelLayout = new javax.swing.GroupLayout(requestConsentPanel);
        requestConsentPanel.setLayout(requestConsentPanelLayout);
        requestConsentPanelLayout.setHorizontalGroup(
            requestConsentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, requestConsentPanelLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(requestConsentLabel)
                .addGap(36, 36, 36))
        );
        requestConsentPanelLayout.setVerticalGroup(
            requestConsentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requestConsentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(requestConsentLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(requestConsentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        consentRequestedPanel.setBackground(new java.awt.Color(204, 204, 255));
        consentRequestedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consentRequestedPanelMouseClicked(evt);
            }
        });

        consentRequestedLabel.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        consentRequestedLabel.setText("Consent Requested");

        javax.swing.GroupLayout consentRequestedPanelLayout = new javax.swing.GroupLayout(consentRequestedPanel);
        consentRequestedPanel.setLayout(consentRequestedPanelLayout);
        consentRequestedPanelLayout.setHorizontalGroup(
            consentRequestedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consentRequestedPanelLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(consentRequestedLabel)
                .addGap(32, 32, 32))
        );
        consentRequestedPanelLayout.setVerticalGroup(
            consentRequestedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consentRequestedPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(consentRequestedLabel)
                .addContainerGap())
        );

        jPanel1.add(consentRequestedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        fileFIRbutton.setText("File FIR");
        fileFIRbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileFIRbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(fileFIRbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void requestConsentPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_requestConsentPanelMouseClicked
        // TODO add your handling code here:
        String s="y";
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
            Statement st = con.createStatement();
            
            st.executeUpdate("  UPDATE progress SET consentRequested='"+s+"' WHERE id='"+id+"'   ");
            JOptionPane.showMessageDialog(this, "Consent for creating FIR has been requested to the user");
            consentRequestedPanel.setVisible(true);
            requestConsentPanel.setVisible(false);
        }catch(Exception e){
        }
    }//GEN-LAST:event_requestConsentPanelMouseClicked

    private void consentRequestedPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consentRequestedPanelMouseClicked
        // TODO add your handling code here:
        int ID = Integer.parseInt(id);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
            PreparedStatement pst = con.prepareStatement("select id,consentRequested from progress where id=?");
            
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("consentRequested").equals("y"))
                    JOptionPane.showMessageDialog(this, "Consent already requested.\nPlease wait for the complaint filer to respond.");
            }
            
        }catch (Exception e){
            
        }
    }//GEN-LAST:event_consentRequestedPanelMouseClicked

    private void fileFIRbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileFIRbuttonActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Are you sure to file an FIR on this report?", "Select", JOptionPane.YES_NO_OPTION);
        if(x==0){
             String s="y";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
                Statement st = con.createStatement();

                st.executeUpdate("  UPDATE progress SET createFIR='"+s+"' WHERE id='"+id+"'   ");
                JOptionPane.showMessageDialog(this, "FIR for report id " + id + " has been filed with approprate consent.");
                fileFIRbutton.setEnabled(false);

                IndividualReports.createFIRButton.setEnabled(false);
                //make all other following buttons in IndividualReport visible
                //it requires each of them be public and static
                //dunno if making all of them static encounters any further problem or not
                IndividualReports.evidenceButton.setEnabled(true);
            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_fileFIRbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(creatingFIR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(creatingFIR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(creatingFIR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(creatingFIR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new creatingFIR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel consentRequestedLabel;
    private javax.swing.JPanel consentRequestedPanel;
    private javax.swing.JButton fileFIRbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField reportIDtxt;
    private javax.swing.JLabel requestConsentLabel;
    private javax.swing.JPanel requestConsentPanel;
    // End of variables declaration//GEN-END:variables
}