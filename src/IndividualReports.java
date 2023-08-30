
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
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
public class IndividualReports extends javax.swing.JFrame {

    /**
     * Creates new form IndividualReports
     */
    
    public IndividualReports() {
        initComponents();
        individualReportsLabel.setVisible(true);
        up.setVisible(false);
        jPanelSpecial.setVisible(false);
        this.setTitle("Individual Reports");
        Image icon = new ImageIcon(this.getClass().getResource("/project_icon.png")).getImage();
        this.setIconImage(icon);
        
        investigateButton.setBackground(new Color(204,255,255));
        createFIRButton.setBackground(new Color(204,255,255));
        evidenceButton.setBackground(new Color(204,255,255));
        suspectLocatedButton.setBackground(new Color(204,255,255));
        suspectConfessedButton.setBackground(new Color(204,255,255));
        victimFoundButton.setBackground(new Color(204,255,255));
    }
    
    public boolean shouldVictimFoundButtonBeDisplayed(int id){
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
                pst = con.prepareStatement("select id,crimeType from report where id=? ");
                pst.setInt(1, id);
                rs=pst.executeQuery();
                
                while(rs.next()){
                    if(rs.getString("crimeType").equals("Kidnap"))
                        return true;
                    if(rs.getString("crimeType").equals("Murder"))
                        return true;
                    if(rs.getString("crimeType").equals("Rape"))
                        return true;
                    if(rs.getString("crimeType").equals("Missing Person"))
                        return true;
                   if(rs.getString("crimeType").equals("Others"))
                        return true; 
                }
        } catch (Exception e) {
        }
    return false;
    }
    
    public boolean checkIfInvestigationReportIsCreated(int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
            pst = con.prepareStatement("select reportCreated from investigation where id=? ");
            pst.setInt(1, id);
            rs=pst.executeQuery();
            
            while(rs.next()){
                if(rs.getString("reportCreated").equals("n"))
                    return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
    
    public void areAllButtonsDisabled(int id){
         try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
                pst = con.prepareStatement("select id,investigationStarted,createFIR,evidenceCollected,"
                        + "suspectLocated,victimFound,suspectConfessed from progress where id=? ");
                pst.setInt(1, id);
                rs=pst.executeQuery();
                
                while(rs.next()){
                    if(rs.getString("investigationStarted").equals("y"))
                        if(rs.getString("createFIR").equals("y"))
                            if(rs.getString("evidenceCollected").equals("y"))
                                if(rs.getString("suspectLocated").equals("y"))
                                    if(rs.getString("suspectConfessed").equals("y"))
                                        //if(rs.getString("victimFound").equals("y"))
                                    {
                                            boolean c = checkIfInvestigationReportIsCreated(id);
                                            if(c==true){
                                                JOptionPane.showMessageDialog(this, "Full investigation on this report has been conducted."
                                                    + "\nCheck detailed report from \"Completed Investigations\" section.");
                                            }
                                            else{
                                               int x = JOptionPane.showConfirmDialog(null, "Full investigation on this report has been conducted\n Do you want to "
                                                       + "create an investigation report on this case??", "Select", JOptionPane.YES_NO_OPTION);
                                                if(x==0){
                                                    createInvesitgationReport.id=id;
                                                    new createInvesitgationReport().setVisible(true);
                                                }
                                            }
                                           
                                    }
                }
        } catch (Exception e) {
        }
    }
    public void initButtonBasedOnProgress(int id){
         try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
                pst = con.prepareStatement("select * from progress where id=? ");
                pst.setInt(1, id);
                rs=pst.executeQuery();

                
                while(rs.next()){
                    if(rs.getString("investigationStarted").equals("y")){
                        investigateButton.setEnabled(false);

                        if(rs.getString("createFIR").equals("y")){
                            createFIRButton.setEnabled(false);
                            
                            if(rs.getString("evidenceCollected").equals("y")){
                                evidenceButton.setEnabled(false);
                                //logic upto this point is fine
                                
                                //now we move forward for the other two buttons
                                //Logically, suspect cannot confessed if not located\
                                //So, suspectLocated needs to come first and only after that should come suspectConfessed
                                if(rs.getString("suspectLocated").equals("y")){
                                    suspectLocatedButton.setEnabled(false);
                                    
                                    //now checking for confession
                                    if(rs.getString("suspectConfessed").equals("y"))
                                        suspectConfessedButton.setEnabled(false);
                                    else{
                                        
                                        suspectConfessedButton.setEnabled(true);
                                    }
                                        //after this, no other button left to make unvisible
                                }
                                else{
                                    suspectLocatedButton.setEnabled(true);
                                    //plus make all other buttons unvisible
                                    suspectConfessedButton.setEnabled(false);
                                }
                                
                                
                                
                                //after evidence collection, victim can be found at any time
                                //whether suspect is located/confessed or not
                                //so, first we will have to enable the victimFoundButton from here
                                if(rs.getString("victimFound").equals("y"))
                                    victimFoundButton.setEnabled(false);    
                                else{
                                    
                                    //one more thing to worry here
                                    //it is not necesarry that a victim be lost or out of reach everytime
                                    //in cases like theft, cyber crime, abuse, robbery etc, it is safe to assume that the victim 
                                    //is unharmed
                                    //hence, we need to check what type of crime we are dealing with here
                                    //base on that, we can enable the victimFoundButton
                                    if(shouldVictimFoundButtonBeDisplayed(id))
                                        victimFoundButton.setEnabled(true);
                                    else
                                        victimFoundButton.setEnabled(false);
                                }
                                //Notice
                                //victimFound has nothing to do with suspectLoated or suspectConfessed
                                //so it will not have any further nested if-else's
                                //Moreover, found victim(if not dead) can be used to identify suspect's Location
                                //this is also the reason why victimFoundButton needs to be enabled before those two
     
                            }
                            
                            //logic below this point is fine
                            else{
                              
                                evidenceButton.setEnabled(true);
                                //plus make all other following buttons unvisible
                                suspectLocatedButton.setEnabled(false);
                                victimFoundButton.setEnabled(false);
                                suspectConfessedButton.setEnabled(false);
                            }
                        }
                        else{
                            createFIRButton.setEnabled(true);
                            //plus make all other following buttons unvisible
                            evidenceButton.setEnabled(false); 
                            suspectLocatedButton.setEnabled(false);
                            victimFoundButton.setEnabled(false);
                            suspectConfessedButton.setEnabled(false);
                        }

                    }    


                    else{
                        investigateButton.setEnabled(true);
                        //plus make all other following buttons unvisible
                        createFIRButton.setEnabled(false);
                        evidenceButton.setEnabled(false); 
                        suspectLocatedButton.setEnabled(false);
                        victimFoundButton.setEnabled(false);
                        suspectConfessedButton.setEnabled(false);
                    }
                }

            } catch (Exception e) {
            }
    }
    
    
    public void show(String ID){
        try{
            int id = Integer.parseInt(ID);
            

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
            PreparedStatement pst = con.prepareStatement("select * from report where id=? ");
            
           
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            
            reportIDtxt.setText(ID);
            reportIDtxt.setEditable(false);
            
            while(rs.next()){
                victimtxt.setText(rs.getString("victim"));
                victimtxt.setEditable(false);
                bloodTxt.setText(rs.getString("bloodGroup"));
                bloodTxt.setEditable(false);
                prof_txt.setText(rs.getString("profession"));
                prof_txt.setEditable(false);
                victimAgeTxt.setText(rs.getString("victimAge"));
                victimAgeTxt.setEditable(false);
                addressTxt.setText(rs.getString("address"));
                addressTxt.setEditable(false);
                
                crimeTypeTxt.setText(rs.getString("crimeType"));
                crimeTypeTxt.setEditable(false);
                
                descriptionTxt.setText(rs.getString("description"));
                descriptionTxt.setEditable(false);
                placeTxt.setText(rs.getString("crimePlace"));
                placeTxt.setEditable(false);
                suspectTxt.setText(rs.getString("suspect"));
                suspectTxt.setEditable(false);
                suspectDetailsTxt.setText(rs.getString("suspectDetails"));
                suspectDetailsTxt.setEditable(false);
                suspectAgeText.setText(rs.getString("suspectAge"));
                suspectAgeText.setEditable(false);
                
                witnessTxt.setText(rs.getString("witness"));
                witnessTxt.setEditable(false);
                StatOfWitTxt.setText(rs.getString("witnessStatement"));
                StatOfWitTxt.setEditable(false);

                //two dates
                dateHappenedDate.setText(rs.getString("dateHappened"));
                dateHappenedDate.setEditable(false);
                reportFiledOnDate.setText(rs.getString("reportFiledOn"));
                reportFiledOnDate.setEditable(false);
                
                
                //now setting two images
                String victimImageLocation = rs.getString("victimImage");
                String suspectImageLocation = rs.getString("suspectImage");
    
                Image getAbsolutePath = null;
                ImageIcon icon = new ImageIcon(victimImageLocation);
                Image image = icon.getImage().getScaledInstance(victimImageLabel.getWidth(), victimImageLabel.getHeight(), Image.SCALE_SMOOTH);
                victimImageLabel.setIcon(icon);
                
                getAbsolutePath = null;
                icon = new ImageIcon(suspectImageLocation);
                image = icon.getImage().getScaledInstance(suspectImageLabel.getWidth(), suspectImageLabel.getHeight(), Image.SCALE_SMOOTH);
                suspectImageLabel.setIcon(icon);
            }
            
            // 
            initButtonBasedOnProgress(id);
            areAllButtonsDisabled(id);
               
            
            }catch (Exception e){
                
            }
    }
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        down = new javax.swing.JLabel();
        up = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        reportIDtxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        crimeTypeTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        suspectPanel = new javax.swing.JPanel();
        suspectTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        suspectDetailsTxt = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        suspectImageLabel = new javax.swing.JLabel();
        suspectAgeText = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        searchFromWantedList = new javax.swing.JLabel();
        crimeDetailsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTxt = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        placeTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        witnessTxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        StatOfWitTxt = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        dateHappenedDate = new javax.swing.JTextField();
        reportFiledOnDate = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        personalInformationPanel = new javax.swing.JPanel();
        victimtxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bloodTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        prof_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addressTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        victimImageLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        victimAgeTxt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        individualReportsLabel = new javax.swing.JLabel();
        jPanelSpecial = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        investigateButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        createFIRButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        evidenceButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        suspectLocatedButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        suspectConfessedButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        victimFoundButton = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("jLabel14");

        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(200, 250, 253));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        down.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down.png"))); // NOI18N
        down.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downMouseClicked(evt);
            }
        });
        jPanel9.add(down, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/up.png"))); // NOI18N
        up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upMouseClicked(evt);
            }
        });
        jPanel9.add(up, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(reportIDtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 110, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Report  ID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));
        jPanel2.add(crimeTypeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 110, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Crime Type");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        suspectPanel.setBackground(new java.awt.Color(0, 0, 0));
        suspectPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suspectPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                suspectPanelMouseExited(evt);
            }
        });
        suspectPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        suspectPanel.add(suspectTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 230, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Suspect");
        suspectPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        suspectDetailsTxt.setColumns(20);
        suspectDetailsTxt.setRows(5);
        jScrollPane2.setViewportView(suspectDetailsTxt);

        suspectPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 230, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 255));
        jLabel10.setText("Suspect Details");
        suspectPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        suspectImageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255)));
        suspectPanel.add(suspectImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 200, 200));

        suspectAgeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suspectAgeTextActionPerformed(evt);
            }
        });
        suspectPanel.add(suspectAgeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 230, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 255, 255));
        jLabel15.setText("Age");
        suspectPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        searchFromWantedList.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        searchFromWantedList.setForeground(new java.awt.Color(255, 0, 51));
        searchFromWantedList.setText("Search From Wanted List");
        searchFromWantedList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFromWantedListMouseClicked(evt);
            }
        });
        suspectPanel.add(searchFromWantedList, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, -1));

        jPanel2.add(suspectPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 360, 490));

        crimeDetailsPanel.setBackground(new java.awt.Color(0, 0, 0));
        crimeDetailsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crimeDetailsPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crimeDetailsPanelMouseExited(evt);
            }
        });
        crimeDetailsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        descriptionTxt.setColumns(20);
        descriptionTxt.setRows(5);
        descriptionTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                descriptionTxtKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(descriptionTxt);

        crimeDetailsPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, 120));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Description");
        crimeDetailsPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        crimeDetailsPanel.add(placeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 226, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Crime Place");
        crimeDetailsPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 80, 20));
        crimeDetailsPanel.add(witnessTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 230, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 255, 255));
        jLabel11.setText("Witness");
        crimeDetailsPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        StatOfWitTxt.setColumns(20);
        StatOfWitTxt.setRows(5);
        jScrollPane3.setViewportView(StatOfWitTxt);

        crimeDetailsPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 255, 255));
        jLabel12.setText("Witness Statement");
        crimeDetailsPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));
        crimeDetailsPanel.add(dateHappenedDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 230, -1));
        crimeDetailsPanel.add(reportFiledOnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 230, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 255, 255));
        jLabel17.setText("Date Happened");
        crimeDetailsPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 255, 255));
        jLabel18.setText("Report Filed On");
        crimeDetailsPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jPanel2.add(crimeDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 380, 490));

        personalInformationPanel.setBackground(new java.awt.Color(0, 0, 0));
        personalInformationPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personalInformationPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                personalInformationPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                personalInformationPanelMouseExited(evt);
            }
        });
        personalInformationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        personalInformationPanel.add(victimtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 160, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Victim");
        personalInformationPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, 10));
        personalInformationPanel.add(bloodTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 160, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Blood Group");
        personalInformationPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));
        personalInformationPanel.add(prof_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 160, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("Profession");
        personalInformationPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));
        personalInformationPanel.add(addressTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 160, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Address");
        personalInformationPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        victimImageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255)));
        personalInformationPanel.add(victimImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 200, 200));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 255, 255));
        jLabel13.setText("Age");
        personalInformationPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        victimAgeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                victimAgeTxtActionPerformed(evt);
            }
        });
        personalInformationPanel.add(victimAgeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 160, -1));

        jPanel2.add(personalInformationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 330, 490));

        jPanel9.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1160, 650));

        jPanel1.setBackground(new java.awt.Color(228, 250, 253));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(153, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, 100));

        individualReportsLabel.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        individualReportsLabel.setText("Investigation Panel");
        jPanel9.add(individualReportsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        jPanelSpecial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(228, 250, 253));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        investigateButton.setBackground(new java.awt.Color(255, 255, 255));
        investigateButton.setText("Start Investigation");
        investigateButton.setOpaque(false);
        investigateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                investigateButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                investigateButtonMouseExited(evt);
            }
        });
        investigateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                investigateButtonActionPerformed(evt);
            }
        });
        jPanel3.add(investigateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, -1));

        jPanelSpecial.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 100));

        jPanel4.setBackground(new java.awt.Color(228, 250, 253));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createFIRButton.setText("Create FIR");
        createFIRButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createFIRButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createFIRButtonMouseExited(evt);
            }
        });
        createFIRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createFIRButtonActionPerformed(evt);
            }
        });
        jPanel4.add(createFIRButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 100, -1));

        jPanelSpecial.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 170, 100));

        jPanel5.setBackground(new java.awt.Color(228, 250, 253));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        evidenceButton.setText("Collect Evidence");
        evidenceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                evidenceButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                evidenceButtonMouseExited(evt);
            }
        });
        evidenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evidenceButtonActionPerformed(evt);
            }
        });
        jPanel5.add(evidenceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jPanelSpecial.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 190, 100));

        jPanel6.setBackground(new java.awt.Color(228, 250, 253));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        suspectLocatedButton.setText("Suspect Located");
        suspectLocatedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suspectLocatedButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                suspectLocatedButtonMouseExited(evt);
            }
        });
        suspectLocatedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suspectLocatedButtonActionPerformed(evt);
            }
        });
        jPanel6.add(suspectLocatedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jPanelSpecial.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 180, 100));

        jPanel7.setBackground(new java.awt.Color(228, 250, 253));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        suspectConfessedButton.setText("Suspect Confessed");
        suspectConfessedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suspectConfessedButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                suspectConfessedButtonMouseExited(evt);
            }
        });
        suspectConfessedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suspectConfessedButtonActionPerformed(evt);
            }
        });
        jPanel7.add(suspectConfessedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jPanelSpecial.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(699, 0, 190, 100));

        jPanel8.setBackground(new java.awt.Color(228, 250, 253));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        victimFoundButton.setText("Victim Found");
        victimFoundButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                victimFoundButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                victimFoundButtonMouseExited(evt);
            }
        });
        victimFoundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                victimFoundButtonActionPerformed(evt);
            }
        });
        jPanel8.add(victimFoundButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jPanelSpecial.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 190, 100));

        jPanel9.add(jPanelSpecial, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 1140, 100));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void downMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downMouseClicked
        // TODO add your handling code here:
        jPanelSpecial.setVisible(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<=100;i++){
                        Thread.sleep(1);
                        jPanelSpecial.setSize(1130,i);
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
        down.setVisible(false);
        up.setVisible(true);
        individualReportsLabel.setVisible(false);
    }//GEN-LAST:event_downMouseClicked

    private void upMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upMouseClicked
        // TODO add your handling code here:
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=100;i>=0;i--){
                        Thread.sleep(1);
                        jPanelSpecial.setSize(1130,i);
                    }
                } catch (Exception e) {
                }
            }
        });
        t.start();
        
        Timer timerSpecial = new Timer();
        TimerTask taskSpecial = new TimerTask() {
            @Override
            public void run() {
                jPanelSpecial.setVisible(false);
            }
        };
        timerSpecial.schedule(taskSpecial, 200);        
       
        up.setVisible(false);
        down.setVisible(true);
 
        
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                individualReportsLabel.setVisible(true);
            }
        };
        timer.schedule(task, 250);
    }//GEN-LAST:event_upMouseClicked

    private void descriptionTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionTxtKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_descriptionTxtKeyTyped

    private void victimFoundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_victimFoundButtonActionPerformed
        // TODO add your handling code here:
        String id = reportIDtxt.getText();
        String s="y";
        JOptionPane.showMessageDialog(this, "Victim is found.\nComplaint filer will receive a notification.");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
            Statement st = con.createStatement();

            st.executeUpdate("UPDATE progress SET victimFound='"+s+"' WHERE id='"+id+"'   ");
        }catch(Exception e){
        }
        victimFoundButton.setEnabled(false);
    }//GEN-LAST:event_victimFoundButtonActionPerformed

    private void suspectConfessedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suspectConfessedButtonActionPerformed
        // TODO add your handling code here:

        String id = reportIDtxt.getText();
        suspectConfessed.id=id;
        new suspectConfessed().setVisible(true);
    }//GEN-LAST:event_suspectConfessedButtonActionPerformed

    private void suspectLocatedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suspectLocatedButtonActionPerformed
        // TODO add your handling code here:
        String id = reportIDtxt.getText();
        suspectLocated.id=id;
        new suspectLocated().setVisible(true);
    }//GEN-LAST:event_suspectLocatedButtonActionPerformed

    private void evidenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evidenceButtonActionPerformed
        // TODO add your handling code here:
        String id = reportIDtxt.getText();
        String s="y";
        JOptionPane.showMessageDialog(this, "Evidence collection proceess has begun on report id." + id + ".\nComplaint filer will receive a notification.");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
            Statement st = con.createStatement();

            st.executeUpdate("UPDATE progress SET evidenceCollected='"+s+"' WHERE id='"+id+"'   ");
        }catch(Exception e){
        }

        //turning to evidenceButton means that investigationButtoon has already been made invisible
        evidenceButton.setEnabled(false);
        //plus nake all other buttons visible
        suspectLocatedButton.setEnabled(true);
        int ID = Integer.parseInt(id);
        if(shouldVictimFoundButtonBeDisplayed(ID))
        victimFoundButton.setEnabled(true);
        else
        victimFoundButton.setEnabled(false);
    }//GEN-LAST:event_evidenceButtonActionPerformed

    private void investigateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_investigateButtonActionPerformed
        // TODO add your handling code here:

        //try sending a message to the respective report filer from here
        String id = reportIDtxt.getText();
        String s="y";
        JOptionPane.showMessageDialog(this, "Investigation started on report id " + id + ".\nComplaint filer will receive a notification.");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crime record", "root", "");
            Statement st = con.createStatement();

            st.executeUpdate("  UPDATE progress SET investigationStarted='"+s+"' WHERE id='"+id+"'   ");
        }catch(Exception e){
        }

        investigateButton.setEnabled(false);
        //plus make all other buttons visible
        createFIRButton.setEnabled(true);
    }//GEN-LAST:event_investigateButtonActionPerformed

    private void createFIRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createFIRButtonActionPerformed
        // TODO add your handling code here:
        String ID = reportIDtxt.getText();
        creatingFIR.id=ID;
        new creatingFIR().setVisible(true);
    }//GEN-LAST:event_createFIRButtonActionPerformed

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
        jPanel3.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
        jPanel3.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        // TODO add your handling code here:
        jPanel4.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        jPanel4.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        // TODO add your handling code here:
        jPanel5.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        // TODO add your handling code here:
        jPanel5.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        // TODO add your handling code here:
        jPanel6.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // TODO add your handling code here:
        jPanel6.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        // TODO add your handling code here:
        jPanel7.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:
        jPanel7.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        // TODO add your handling code here:
        jPanel8.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        // TODO add your handling code here:
        jPanel8.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_jPanel8MouseEntered

    private void investigateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_investigateButtonMouseEntered
        // TODO add your handling code here:
        jPanel3.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_investigateButtonMouseEntered

    private void investigateButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_investigateButtonMouseExited
        // TODO add your handling code here:
        jPanel3.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_investigateButtonMouseExited

    private void createFIRButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createFIRButtonMouseEntered
        jPanel4.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_createFIRButtonMouseEntered

    private void createFIRButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createFIRButtonMouseExited
        // TODO add your handling code here:
          jPanel4.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_createFIRButtonMouseExited

    private void evidenceButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evidenceButtonMouseEntered
        jPanel5.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_evidenceButtonMouseEntered

    private void evidenceButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evidenceButtonMouseExited
        jPanel5.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_evidenceButtonMouseExited

    private void suspectLocatedButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suspectLocatedButtonMouseEntered
        jPanel6.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_suspectLocatedButtonMouseEntered

    private void suspectLocatedButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suspectLocatedButtonMouseExited
      jPanel6.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_suspectLocatedButtonMouseExited

    private void suspectConfessedButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suspectConfessedButtonMouseEntered
        jPanel7.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_suspectConfessedButtonMouseEntered

    private void suspectConfessedButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suspectConfessedButtonMouseExited
       jPanel7.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_suspectConfessedButtonMouseExited

    private void victimFoundButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_victimFoundButtonMouseEntered
       jPanel8.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_victimFoundButtonMouseEntered

    private void victimFoundButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_victimFoundButtonMouseExited
        jPanel8.setBackground(new java.awt.Color(228, 250, 253));
    }//GEN-LAST:event_victimFoundButtonMouseExited

    private void personalInformationPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalInformationPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_personalInformationPanelMouseClicked

    private void personalInformationPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalInformationPanelMouseEntered
        // TODO add your handling code here:
        personalInformationPanel.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_personalInformationPanelMouseEntered

    private void personalInformationPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personalInformationPanelMouseExited
        // TODO add your handling code here:
        personalInformationPanel.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_personalInformationPanelMouseExited

    private void victimAgeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_victimAgeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_victimAgeTxtActionPerformed

    private void suspectAgeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suspectAgeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suspectAgeTextActionPerformed

    private void crimeDetailsPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crimeDetailsPanelMouseEntered
       crimeDetailsPanel.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_crimeDetailsPanelMouseEntered

    private void crimeDetailsPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crimeDetailsPanelMouseExited
        // TODO add your handling code here:
        crimeDetailsPanel.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_crimeDetailsPanelMouseExited

    private void suspectPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suspectPanelMouseEntered
        suspectPanel.setBackground(new java.awt.Color(51,51,51));
    }//GEN-LAST:event_suspectPanelMouseEntered

    private void suspectPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suspectPanelMouseExited
      suspectPanel.setBackground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_suspectPanelMouseExited

    private void searchFromWantedListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFromWantedListMouseClicked
      searchFromWantedList.setForeground(new java.awt.Color(51, 51, 255));
      new wantedList().setVisible(true);
    }//GEN-LAST:event_searchFromWantedListMouseClicked

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
            java.util.logging.Logger.getLogger(IndividualReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndividualReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndividualReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndividualReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndividualReports().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextArea StatOfWitTxt;
    public javax.swing.JTextField addressTxt;
    public javax.swing.JTextField bloodTxt;
    public static javax.swing.JButton createFIRButton;
    private javax.swing.JPanel crimeDetailsPanel;
    protected javax.swing.JTextField crimeTypeTxt;
    private javax.swing.JTextField dateHappenedDate;
    public javax.swing.JTextArea descriptionTxt;
    private javax.swing.JLabel down;
    public static javax.swing.JButton evidenceButton;
    private javax.swing.JLabel individualReportsLabel;
    public javax.swing.JButton investigateButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelSpecial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel personalInformationPanel;
    public javax.swing.JTextField placeTxt;
    public javax.swing.JTextField prof_txt;
    private javax.swing.JTextField reportFiledOnDate;
    public javax.swing.JTextField reportIDtxt;
    private javax.swing.JLabel searchFromWantedList;
    private javax.swing.JTextField suspectAgeText;
    protected static javax.swing.JButton suspectConfessedButton;
    public javax.swing.JTextArea suspectDetailsTxt;
    private javax.swing.JLabel suspectImageLabel;
    public static javax.swing.JButton suspectLocatedButton;
    private javax.swing.JPanel suspectPanel;
    public javax.swing.JTextField suspectTxt;
    private javax.swing.JLabel up;
    private javax.swing.JTextField victimAgeTxt;
    public static javax.swing.JButton victimFoundButton;
    private javax.swing.JLabel victimImageLabel;
    public javax.swing.JTextField victimtxt;
    public javax.swing.JTextField witnessTxt;
    // End of variables declaration//GEN-END:variables
}
