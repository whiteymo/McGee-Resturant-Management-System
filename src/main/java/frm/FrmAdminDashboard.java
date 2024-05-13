package frm;

import bll.Users;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class FrmAdminDashboard extends javax.swing.JFrame {

    Color DefaultColor, ClickedColor;
    /**
     * Creates new form FrmAdminDashboard
     */
    private Users u;

    public FrmAdminDashboard() {
        initComponents();
        loadData();
        DefaultColor = new Color(242, 242, 242);
        ClickedColor = new Color(240, 151, 57);
    }

    public FrmAdminDashboard(Users u) {
        initComponents();
        this.u = u;
        DefaultColor = new Color(13, 36, 51);
        ClickedColor = new Color(240, 151, 57);

    }

    public FrmAdminDashboard(FrmAddUsers add) {
        initComponents();
        Panel.removeAll();
        Panel.add(add).setVisible(true);
        Panel.revalidate();
        Panel.repaint();
        DefaultColor = new Color(13, 36, 51);
        ClickedColor = new Color(240, 151, 57);
    }

    public FrmAdminDashboard(FrmAddFoods addf) {
        initComponents();
        Panel.removeAll();
        Panel.add(addf).setVisible(true);
        Panel.revalidate();
        Panel.repaint();
        DefaultColor = new Color(13, 36, 51);
        ClickedColor = new Color(240, 151, 57);
    }

    public void loadData() {
        try {
            FrmViewUsers fvu = new FrmViewUsers();
            Panel.removeAll();
            Panel.add(fvu).setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(FrmAdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        mngOrders = new javax.swing.JLabel();
        mngUsers = new javax.swing.JLabel();
        mngFoods = new javax.swing.JLabel();
        ViewProfile = new javax.swing.JLabel();
        signOut = new javax.swing.JLabel();
        Panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Dashboard");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Admin Dashboard");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(317, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        mngOrders.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        mngOrders.setForeground(new java.awt.Color(255, 255, 255));
        mngOrders.setText("Manage Orders");
        mngOrders.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mngOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mngOrdersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mngOrdersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mngOrdersMouseExited(evt);
            }
        });

        mngUsers.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        mngUsers.setForeground(new java.awt.Color(255, 255, 255));
        mngUsers.setText("Manage Users");
        mngUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mngUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mngUsersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mngUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mngUsersMouseExited(evt);
            }
        });

        mngFoods.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        mngFoods.setForeground(new java.awt.Color(255, 255, 255));
        mngFoods.setText("Manage Foods");
        mngFoods.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mngFoods.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mngFoodsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mngFoodsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mngFoodsMouseExited(evt);
            }
        });

        ViewProfile.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ViewProfile.setForeground(new java.awt.Color(255, 255, 255));
        ViewProfile.setText("Profile");
        ViewProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ViewProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ViewProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ViewProfileMouseExited(evt);
            }
        });

        signOut.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        signOut.setForeground(new java.awt.Color(255, 255, 255));
        signOut.setText("Sign Out");
        signOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signOutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mngOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mngFoods, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(mngUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ViewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(mngUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(mngFoods, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(mngOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(ViewProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void mngUsersMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            FrmViewUsers fvu = new FrmViewUsers();
            Panel.removeAll();
            Panel.add(fvu).setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(FrmAdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mngUsersMouseEntered(java.awt.event.MouseEvent evt) {
        mngUsers.setForeground(ClickedColor);
    }

    private void mngUsersMouseExited(java.awt.event.MouseEvent evt) {
        mngUsers.setForeground(DefaultColor);
    }

    private void mngFoodsMouseClicked(java.awt.event.MouseEvent evt) {
        FrmViewFoods fvf = new FrmViewFoods();
        Panel.removeAll();
        Panel.add(fvf).setVisible(true);

    }

    private void mngFoodsMouseEntered(java.awt.event.MouseEvent evt) {
        mngFoods.setForeground(ClickedColor);
    }

    private void mngFoodsMouseExited(java.awt.event.MouseEvent evt) {
        mngFoods.setForeground(DefaultColor);
    }

    private void mngOrdersMouseEntered(java.awt.event.MouseEvent evt) {
        mngOrders.setForeground(ClickedColor);
    }

    private void mngOrdersMouseExited(java.awt.event.MouseEvent evt) {
        mngOrders.setForeground(DefaultColor);
    }

    private void ViewProfileMouseClicked(java.awt.event.MouseEvent evt) {
        FrmAdminProfile fp = new FrmAdminProfile(u);
        Panel.removeAll();
        Panel.add(fp).setVisible(true);
    }

    private void ViewProfileMouseEntered(java.awt.event.MouseEvent evt) {
        ViewProfile.setForeground(ClickedColor);
    }

    private void ViewProfileMouseExited(java.awt.event.MouseEvent evt) {
        ViewProfile.setForeground(DefaultColor);
    }

    private void signOutMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        FrmLogin fl = new FrmLogin();
        fl.setVisible(true);
    }

    private void mngOrdersMouseClicked(java.awt.event.MouseEvent evt) {
        AdminViewOrder avo = new AdminViewOrder(u);
        Panel.removeAll();
        Panel.add(avo).setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(FrmAdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel ViewProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel mngFoods;
    private javax.swing.JLabel mngOrders;
    private javax.swing.JLabel mngUsers;
    private javax.swing.JLabel signOut;
    // End of variables declaration
}