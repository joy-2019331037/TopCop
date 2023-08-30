import java.awt.Color;
import java.sql.*;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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

public class suspectConfessed extends javax.swing.JFrame {

    /**
     * Creates new form suspectConfessed
     */
    public static String id;
    String s ="<html><u><i><b>Add to Wanted List</b></i></u></html>";
    public suspectConfessed() {
        initComponents();
        
        this.setTitle("Confession From Suspect");
        Image icon = new ImageIcon(this.getClass().getResource("/project_icon.png")).getImage();
        this.setIconImage(icon);
        
        addToWantedList.setText(s);
        addInfoButton.setBackground(Color.WHITE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kButton1 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();
        ageTxt = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mentalHealthTxt = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        confessionTxt = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        prevHistoryTxt = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addToWantedList = new javax.swing.JLabel();
        addInfoButton = new javax.swing.JButton();
        nameTxt = new javax.swing.JTextField();
        ageText = new javax.swing.JTextField();
        genderTxt = new javax.swing.JTextField();

        kButton1.setText("kButton1");

        kButton2.setText("kButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ageTxt.setBackground(new java.awt.Color(0, 0, 0));
        ageTxt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Provide Information Regarding Suspect's Confession");
        ageTxt.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Name");
        ageTxt.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 97, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Statement Regarding Allegation");
        ageTxt.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Arrested for");
        ageTxt.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 219, -1, -1));

        mentalHealthTxt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theft", "Kidnapping", "Stealing", "Robbery", "Murder", "Rape", "Cyber Crime", "Sexual Abuse", " ", " " }));
        mentalHealthTxt.setBorder(null);
        ageTxt.add(mentalHealthTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 216, 162, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("Previous Criminal Offence (if any)");
        ageTxt.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        confessionTxt.setColumns(20);
        confessionTxt.setRows(5);
        confessionTxt.setBorder(null);
        confessionTxt.setOpaque(false);
        jScrollPane1.setViewportView(confessionTxt);

        ageTxt.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        prevHistoryTxt.setColumns(20);
        prevHistoryTxt.setRows(5);
        prevHistoryTxt.setBorder(null);
        jScrollPane2.setViewportView(prevHistoryTxt);

        ageTxt.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Age");
        ageTxt.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Gender");
        ageTxt.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 179, -1, -1));

        addToWantedList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addToWantedList.setForeground(new java.awt.Color(255, 255, 255));
        addToWantedList.setText("Add to Wanted List");
        addToWantedList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addToWantedListMouseClicked(evt);
            }
        });
        ageTxt.add(addToWantedList, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, -1, -1));

        addInfoButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addInfoButton.setText("Add Info");
        addInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInfoButtonActionPerformed(evt);
            }
        });
        ageTxt.add(addInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 100, -1));
        ageTxt.add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 160, -1));
        ageTxt.add(ageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 160, -1));
        ageTxt.add(genderTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 160, -1));

        getContentPane().add(ageTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addToWantedListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToWantedListMouseClicked
        String suspectIMGLocation="" ;
        addToWantedList.setForeground(new java.awt.Color(255,255,0));
        if(nameTxt.getText().length()==0)
            JOptionPane.showMessageDialog(null, "Name field cannot be empty");
        else if(ageText.getText().length()==0)
            JOptionPane.showMessageDialog(null, "Age field cannot be empty");
        else if(genderTxt.getText().length()==0)
            JOptionPane.showMessageDialog(null, "Gender field cannot be empty");
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do you want to add this guy into wanted list?", "Select", JOptionPane.YES_NO_OPTION);
            if(x==0){
                try {
                     Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");

                     PreparedStatement pst = con.prepareStatement("select suspectImage from report where id=?");
                     int ID = Integer.parseInt(id);
                     pst.setInt(1, ID);
                     ResultSet rs = pst.executeQuery();

                     while(rs.next()){
                         suspectIMGLocation = rs.getString("suspectImage");
                     }
                } catch (Exception e) {
                }

                try {
                     Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");

                     PreparedStatement pst = con.prepareStatement("insert into wanted values(?,?,?,?,?)");

                     pst.setString(1, nameTxt.getText());
                     pst.setString(2, ageText.getText());
                     pst.setString(3, genderTxt.getText());
                     pst.setString(4,mentalHealthTxt.getSelectedItem().toString());
                     pst.setString(5, suspectIMGLocation);

                     pst.executeUpdate();
                     JOptionPane.showMessageDialog(null, "Guy has been added to the wanted list!");
                    
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_addToWantedListMouseClicked

    private void addInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInfoButtonActionPerformed
        if(nameTxt.getText().length()==0)
            JOptionPane.showMessageDialog(null, "Name field cannot be empty");
        else if(ageText.getText().length()==0)
            JOptionPane.showMessageDialog(null, "Age field cannot be empty");
        else if(genderTxt.getText().length()==0)
            JOptionPane.showMessageDialog(null, "Gender field cannot be empty");
        else{
        int x = JOptionPane.showConfirmDialog(null, "Do you want to add these information on this investigation?", "Select", JOptionPane.YES_NO_OPTION);
        if(x==0){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
                
                Statement st = con.createStatement();

                st.executeUpdate("UPDATE investigation SET suspectName='"+nameTxt.getText()+"',suspectAge='"+ageText.getText()+"',suspectGender='"+genderTxt.getText()+"',"
                        + " mentalHealth='"+mentalHealthTxt.getSelectedItem()+"'"
                        + ",Confession='"+confessionTxt.getText()+"', prevHistory='"+prevHistoryTxt.getText()+"' WHERE id='"+id+"' ");    
                
            } catch (Exception e) {
            }
        
        
       
        String s="y";
        JOptionPane.showMessageDialog(this, "Prime suspect for this case has confessed.\nComplaint filer will receive a notification.");
        
         nameTxt.setText("");
         ageText.setText("");
         genderTxt.setText("");
         mentalHealthTxt.setSelectedIndex(0);
         confessionTxt.setText("");
         prevHistoryTxt.setText("");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
            Statement st = con.createStatement();
            
            st.executeUpdate("UPDATE progress SET suspectConfessed='"+s+"' WHERE id='"+id+"' ");    
        }catch(Exception e){
        }
        IndividualReports.suspectConfessedButton.setEnabled(false);
        }
        }
    }//GEN-LAST:event_addInfoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(suspectConfessed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(suspectConfessed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(suspectConfessed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(suspectConfessed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new suspectConfessed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInfoButton;
    private javax.swing.JLabel addToWantedList;
    private javax.swing.JTextField ageText;
    private javax.swing.JPanel ageTxt;
    private javax.swing.JTextArea confessionTxt;
    private javax.swing.JTextField genderTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private javax.swing.JComboBox<String> mentalHealthTxt;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextArea prevHistoryTxt;
    // End of variables declaration//GEN-END:variables
}
