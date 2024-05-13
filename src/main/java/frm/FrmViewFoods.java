package frm;

import bll.Food;
import bll.FoodResponse;
import bll.Response;
import bll.UserResponse;
import bll.Users;
import dao.InterfaceDao;
import java.awt.Container;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class FrmViewFoods extends javax.swing.JInternalFrame {

    private Food foods;

    /**
     * Creates new form FrmViewFoods
     */
    public FrmViewFoods() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        loadData();
    }

    public FrmViewFoods(Food food) {
        initComponents();
        this.foods = food;
    }

    public void loadData() {
        try {
            InterfaceDao udao = (InterfaceDao) Naming.lookup("rmi://localhost:1099/db");
            FoodResponse res = (FoodResponse) udao.getAllFoods();

            System.out.println(res.foods.size());
            if (res.success) {
                DefaultTableModel dtm = new DefaultTableModel(new String[]{"Id", "Name", "Price", "Detail", "Category"}, 0);
                foodTable.setModel(dtm);
                for (Food food : res.foods) {
                    Object[] rowData = {food.getId(), food.getName(), food.getPrice(), food.getDetail(), food.getCategory()};
                    dtm.addRow(rowData);
                }
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(FrmViewFoods.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        foodTable = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        foodTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(foodTable);

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUpdate.setText("Update");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(149, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(216, 216, 216))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        FrmAddFoods addf = new FrmAddFoods();
        addf.setVisible(true);
        Container frame = btnAdd.getParent();
        FrmAdminDashboard fad = new FrmAdminDashboard(addf);
        do {
            frame = frame.getParent();
        } while (!(frame instanceof JFrame));
        ((JFrame) frame).dispose();
        fad.setVisible(true);
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int row = foodTable.getSelectedRow() + 1;
        int col = foodTable.getSelectedColumn() + 1;
        int uid = (Integer) foodTable.getValueAt(row - 1, 0);
        System.out.println("test");
        if (row - 1 >= 0) {
            try {
                InterfaceDao udao = (InterfaceDao) Naming.lookup("rmi://localhost:1099/db");
                Response res = (Response) udao.DeleteFood(uid);
                System.out.println(res.message);
                if (res.success) {
                    JOptionPane.showMessageDialog(null, "Selected User deleted successfully!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Delete User failed: " + res.message);
                }
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(FrmViewFoods.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        loadData();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTable foodTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration
}