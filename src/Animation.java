
import java.awt.Color;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
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
public class Animation extends javax.swing.JFrame {

    /**
     * Creates new form Animation
     */
    public Animation() {
        initComponents();
        seeAnimationButton.setBackground(Color.WHITE);
        this.setTitle("About Us");
        Image icon = new ImageIcon(this.getClass().getResource("/project_icon.png")).getImage();
        this.setIconImage(icon);
        ifYouEverLabel.setVisible(false);
        dontHesitateLabel.setVisible(false);
        ourOfficersWillLabel.setVisible(false);
        andWillLetYouKnowLabel.setVisible(false);
        createAnAccountHereLabel.setVisible(false);
        thenReportLabel.setVisible(false);
        traceCriminalsLabel.setVisible(false);
        goAfterLabel.setVisible(false);
        ThenNabLabel.setVisible(false);
        yourWellBeing.setVisible(false);
        respectLabel.setVisible(false);
        thankYouLabel.setVisible(false);
        
        ifYouEver.setVisible(false);
        createAnAccount.setVisible(false);
        ourOfficers.setVisible(false);
        criminalRunning.setVisible(false);
        policeMakesWarningShot.setVisible(false);
        arresting.setVisible(false);
        salute.setVisible(false);
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
        ifYouEverLabel = new javax.swing.JLabel();
        dontHesitateLabel = new javax.swing.JLabel();
        ifYouEver = new javax.swing.JLabel();
        ourOfficersWillLabel = new javax.swing.JLabel();
        andWillLetYouKnowLabel = new javax.swing.JLabel();
        createAnAccountHereLabel = new javax.swing.JLabel();
        createAnAccount = new javax.swing.JLabel();
        thenReportLabel = new javax.swing.JLabel();
        criminalRunning = new javax.swing.JLabel();
        policeMakesWarningShot = new javax.swing.JLabel();
        arresting = new javax.swing.JLabel();
        traceCriminalsLabel = new javax.swing.JLabel();
        goAfterLabel = new javax.swing.JLabel();
        ourOfficers = new javax.swing.JLabel();
        ThenNabLabel = new javax.swing.JLabel();
        salute = new javax.swing.JLabel();
        yourWellBeing = new javax.swing.JLabel();
        respectLabel = new javax.swing.JLabel();
        thankYouLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        seeAnimationButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ifYouEverLabel.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        ifYouEverLabel.setForeground(new java.awt.Color(0, 0, 102));
        ifYouEverLabel.setText("If you ever get into Trouble . . .");
        jPanel1.add(ifYouEverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 510, -1, -1));

        dontHesitateLabel.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        dontHesitateLabel.setForeground(new java.awt.Color(0, 0, 102));
        dontHesitateLabel.setText("Don't hesitate to call us!");
        jPanel1.add(dontHesitateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 540, -1, -1));

        ifYouEver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ifYourEver.jpg"))); // NOI18N
        jPanel1.add(ifYouEver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 290));

        ourOfficersWillLabel.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        ourOfficersWillLabel.setForeground(new java.awt.Color(0, 0, 102));
        ourOfficersWillLabel.setText("Our Officers will investigate in details . . .");
        jPanel1.add(ourOfficersWillLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 390, 300, -1));

        andWillLetYouKnowLabel.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        andWillLetYouKnowLabel.setForeground(new java.awt.Color(0, 0, 102));
        andWillLetYouKnowLabel.setText(". . . And will let you know the updates");
        jPanel1.add(andWillLetYouKnowLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 370, -1, 20));

        createAnAccountHereLabel.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        createAnAccountHereLabel.setForeground(new java.awt.Color(0, 0, 102));
        createAnAccountHereLabel.setText("At first, create an account here . . .");
        jPanel1.add(createAnAccountHereLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, -1, -1));

        createAnAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/createAnAccount.jpg"))); // NOI18N
        jPanel1.add(createAnAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

        thenReportLabel.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        thenReportLabel.setForeground(new java.awt.Color(0, 0, 102));
        thenReportLabel.setText(". . . Then report your complain");
        jPanel1.add(thenReportLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 420, 230, -1));

        criminalRunning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/criminalRunning.jpg"))); // NOI18N
        jPanel1.add(criminalRunning, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        policeMakesWarningShot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/policeMakesAWarningShot.jpg"))); // NOI18N
        jPanel1.add(policeMakesWarningShot, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, -1));

        arresting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arresting.jpg"))); // NOI18N
        jPanel1.add(arresting, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, -1, -1));

        traceCriminalsLabel.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        traceCriminalsLabel.setForeground(new java.awt.Color(0, 0, 102));
        traceCriminalsLabel.setText("We will trace criminals on behalf of you . . .");
        jPanel1.add(traceCriminalsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 570, -1, -1));

        goAfterLabel.setBackground(new java.awt.Color(0, 0, 102));
        goAfterLabel.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        goAfterLabel.setForeground(new java.awt.Color(0, 0, 102));
        goAfterLabel.setText(". . . And go after them!!");
        jPanel1.add(goAfterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        ourOfficers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ourOfficers.jpg"))); // NOI18N
        jPanel1.add(ourOfficers, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        ThenNabLabel.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        ThenNabLabel.setForeground(new java.awt.Color(0, 0, 102));
        ThenNabLabel.setText("Eventually we will nab the criminal for you!");
        jPanel1.add(ThenNabLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        salute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salute.jpg"))); // NOI18N
        jPanel1.add(salute, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, -1));

        yourWellBeing.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        yourWellBeing.setForeground(new java.awt.Color(0, 0, 102));
        yourWellBeing.setText("Your well-being is our top Priority");
        jPanel1.add(yourWellBeing, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 600, -1, -1));

        respectLabel.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        respectLabel.setForeground(new java.awt.Color(0, 0, 102));
        respectLabel.setText("We respect your freedom of life");
        jPanel1.add(respectLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 610, -1, -1));

        thankYouLabel.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        thankYouLabel.setForeground(new java.awt.Color(102, 0, 153));
        thankYouLabel.setText("Thank You For Your Patience");
        jPanel1.add(thankYouLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1090, 650));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seeAnimationButton.setText("See Animation");
        seeAnimationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeAnimationButtonActionPerformed(evt);
            }
        });
        jPanel2.add(seeAnimationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, -1, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 12)); // NOI18N
        jLabel1.setText("Crime Record Management System");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel2.setText("is the modernized version of the law enforcement act. This system is built with the intention of serving you digitally. You can register a complaint on our ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel3.setText("system. We will provide a solution for your case with timely updates from our admins. We vow to serve you anytime. Thanks. ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setText("©");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 30));

        jLabel5.setFont(new java.awt.Font("Perpetua", 1, 12)); // NOI18N
        jLabel5.setText("Crime Record Management System, 2022");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Perpetua", 1, 12)); // NOI18N
        jLabel6.setText("All rights reserved");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 130));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void seeAnimationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeAnimationButtonActionPerformed
        
        seeAnimationButton.setEnabled(false);
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                ifYouEverLabel.setVisible(true);
                for(int i=272;i<350;i++){
                    ifYouEverLabel.setLocation(i, 50);
                    try {
                    Thread.sleep(5);
                    } catch (Exception e) {
                    }
                }       
            }
        });
        t.start();
        
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
               
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    ifYouEverLabel.setVisible(false);
                    dontHesitateLabel.setVisible(true);
                    for(int i=570;i>=460;i--){
                        dontHesitateLabel.setLocation(i, 80);
                        try {
                        Thread.sleep(5);
                        } catch (Exception e) {
                        }
                    }  
                }
                });
                t1.start();
            }
        };
        timer.schedule(task, 2000);
        
        Timer timer2 = new Timer();
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                    Thread t2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                       ifYouEver.setVisible(true);
                       for(int i=350;i<=480;i++){
                           ifYouEver.setLocation(i, 110);
                           try {
                               Thread.sleep(5);
                           } catch (Exception e) {
                           }
                       }
                    }
                    });
                t2.start();
            }
        };
        timer2.schedule(task2, 2000);
        
        Timer timer3 = new Timer();
        TimerTask task3 = new TimerTask() {
            @Override
            public void run() {
                    Thread t3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                       dontHesitateLabel.setVisible(false);
                       ifYouEver.setVisible(false);
                       
                       try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        createAnAccountHereLabel.setVisible(true);
                        thenReportLabel.setVisible(true);
                        createAnAccount.setVisible(true);
                        for(int i=600;i>=445;i--){
                            createAnAccountHereLabel.setLocation(i, 90);
                            createAnAccount.setLocation(i, 130);
                            thenReportLabel.setLocation(i, 410);
                            try {
                                Thread.sleep(5);
                            } catch (Exception e) {
                            }
                        }
                    }
                    });
                t3.start();
            }
        };
        timer3.schedule(task3, 4000);
        
        
        Timer timer4 = new Timer();
        TimerTask task4 = new TimerTask() {
            @Override
            public void run() {
                    Thread t4 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                      createAnAccount.setVisible(false);
                      createAnAccountHereLabel.setVisible(false);
                      thenReportLabel.setVisible(false);
                       try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        ourOfficers.setVisible(true);
                        ourOfficersWillLabel.setVisible(true);
                        andWillLetYouKnowLabel.setVisible(true);
                        for(int i=320;i<=450;i++){
                                ourOfficersWillLabel.setLocation(i-20, 90);
                                ourOfficers.setLocation(i+25, 130);
                                andWillLetYouKnowLabel.setLocation(i-15, 445);
                            try {
                                Thread.sleep(5);
                            } catch (Exception e) {
                            }
                        }
                    }
                    });
                t4.start();
            }
        };
        timer4.schedule(task4, 7000);
  
        Timer timer5 = new Timer();
        TimerTask task5 = new TimerTask() {
            @Override
            public void run() {
                    Thread t5 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ourOfficers.setVisible(false);
                        ourOfficersWillLabel.setVisible(false);
                        andWillLetYouKnowLabel.setVisible(false);
                        
                        traceCriminalsLabel.setVisible(true);
                        for(int i=320;i<=410;i++){
                            try {
                                Thread.sleep(5);
                            } catch (Exception e) {
                            }

                            traceCriminalsLabel.setLocation(i, 100);
                        }
                    }
                    });
                t5.start();
            }
        };
        timer5.schedule(task5, 10000);
        
        
        Timer timer6 = new Timer();
        TimerTask task6 = new TimerTask() {
            @Override
            public void run() {
                    Thread t6 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                       traceCriminalsLabel.setVisible(false);
                        
                        criminalRunning.setVisible(true);
                        for(int i=520;i>=250;i--){
                            try {
                                Thread.sleep(8);
                            } catch (Exception e) {
                            }

                            criminalRunning.setLocation(i, 170);
                        }
                    }
                    });
                t6.start();
            }
        };
        timer6.schedule(task6, 12000);

        Timer timer7 = new Timer();
        TimerTask task7 = new TimerTask() {
            @Override
            public void run() {
                    Thread t7 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        goAfterLabel.setVisible(true);
                        for(int i=320;i<=460;i++){
                            try {
                                Thread.sleep(8);
                            } catch (Exception e) {
                            }

                            goAfterLabel.setLocation(i, 90);
                        }
                        
                        policeMakesWarningShot.setVisible(true);
                        for(int i=820;i>=690;i--){
                            try {
                                Thread.sleep(6);
                            } catch (Exception e) {
                            }

                            policeMakesWarningShot.setLocation(i, 170);
                        }
                    }
                    });
                t7.start();
                
            }
        };
        timer7.schedule(task7, 13000);
        
        Timer timer8 = new Timer();
        TimerTask task8 = new TimerTask() {
            @Override
            public void run() {
                    Thread t8 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        
                        goAfterLabel.setVisible(false);
                        criminalRunning.setVisible(false);
                        policeMakesWarningShot.setVisible(false);
                        
                        ThenNabLabel.setVisible(true);
                        for(int i=480;i>=350;i--){
                            try {
                                Thread.sleep(8);
                            } catch (Exception e) {
                            }

                            ThenNabLabel.setLocation(i, 110);
                        }
                        
                       arresting.setVisible(true);
                        for(int i=300;i<=430;i++){
                            try {
                                Thread.sleep(8);
                            } catch (Exception e) {
                            }

                            arresting.setLocation(i, 170);
                        }
                    }
                    });
                t8.start();
                
            }
        };
        timer8.schedule(task8, 17000);
        
        Timer timer9 = new Timer();
        TimerTask task9 = new TimerTask() {
            @Override
            public void run() {
                    Thread t9 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ThenNabLabel.setVisible(false);
                        arresting.setVisible(false);
           
                        yourWellBeing.setVisible(true);
                        salute.setVisible(true);
                        respectLabel.setVisible(true);
                        for(int i=320;i<=430;i++){
                            yourWellBeing.setLocation(i,80);
                            salute.setLocation(i+20,130);
                            respectLabel.setLocation(i,480);
                            
                            try {
                                 Thread.sleep(5);
                            } catch (Exception e) {
                            }
                        }
                       
                    }
                    });
                t9.start();
                
            }
        };
        timer9.schedule(task9, 21000);
        
        
        Timer timer10 = new Timer();
        TimerTask task10 = new TimerTask() {
            @Override
            public void run() {
                    Thread t10 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        yourWellBeing.setVisible(false);
                        salute.setVisible(false);
                        respectLabel.setVisible(false);
                        
                        thankYouLabel.setVisible(true);
                        for(int i=520;i>=390;i--){
                            try {
                                Thread.sleep(5);
                            } catch (Exception e) {
                            }

                           thankYouLabel.setLocation(i, 260);
                        }
                    }
                    });
                t10.start();
            }
        };
        timer10.schedule(task10, 24000);

       
        Timer timer11 = new Timer();
        TimerTask task11 = new TimerTask() {
            @Override
            public void run() {
                    Thread t11 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        thankYouLabel.setVisible(false);
                    }
                    });
                t11.start();
            }
        };
        timer11.schedule(task11, 26000);
 
        
    }//GEN-LAST:event_seeAnimationButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Animation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Animation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Animation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Animation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Animation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ThenNabLabel;
    private javax.swing.JLabel andWillLetYouKnowLabel;
    private javax.swing.JLabel arresting;
    private javax.swing.JLabel createAnAccount;
    private javax.swing.JLabel createAnAccountHereLabel;
    private javax.swing.JLabel criminalRunning;
    private javax.swing.JLabel dontHesitateLabel;
    private javax.swing.JLabel goAfterLabel;
    private javax.swing.JLabel ifYouEver;
    private javax.swing.JLabel ifYouEverLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel ourOfficers;
    private javax.swing.JLabel ourOfficersWillLabel;
    private javax.swing.JLabel policeMakesWarningShot;
    private javax.swing.JLabel respectLabel;
    private javax.swing.JLabel salute;
    private javax.swing.JButton seeAnimationButton;
    private javax.swing.JLabel thankYouLabel;
    private javax.swing.JLabel thenReportLabel;
    private javax.swing.JLabel traceCriminalsLabel;
    private javax.swing.JLabel yourWellBeing;
    // End of variables declaration//GEN-END:variables
}
