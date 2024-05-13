package frm;

import bll.Food;
import bll.FoodResponse;
import bll.Response;
import bll.Users;
import dao.InterfaceDao;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class MakeOrder extends javax.swing.JInternalFrame {

    /**
     * Creates new form MakeOrder
     */

    private Users u;
    public MakeOrder() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        loadData();
    }

    public MakeOrder(Users u) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);

        this.u = u;
        loadData();
    }

    public void loadData() {
        try {
            InterfaceDao udao = (InterfaceDao) Naming.lookup("rmi://localhost:1099/db");
            FoodResponse res = (FoodResponse) udao.getAllFoods();

            System.out.println(res.foods.size());
            if (res.success) {
                DefaultTableModel dtm = new DefaultTableModel(new String[]{"Id", "Name", "Price", "Detail", "Category"}, 0);
                orderTable.setModel(dtm);
                for (Food food : res.foods) {
                    Object[] rowData = {food.getId(), food.getName(), food.getPrice(), food.getDetail(), food.getCategory()};
                    dtm.addRow(rowData);
                }
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(MakeOrder.class.getName()).log(Level.SEVERE, null, ex);
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
        orderTable = new javax.swing.JTable();
        btnOrder = new javax.swing.JButton();

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(orderTable);

        btnOrder.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnOrder.setText("Order");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {
        int row = orderTable.getSelectedRow() + 1;
        int col = orderTable.getSelectedColumn() + 1;
        int uid = (Integer) orderTable.getValueAt(row - 1, 0);
        String price = (String) orderTable.getValueAt(row -1, 2 );
        System.out.println("test");
        if (row - 1 >= 0) {
            try {
                InterfaceDao udao = (InterfaceDao) Naming.lookup("rmi://localhost:1099/db");
                Response res = (Response) udao.orderItem(u.getId(), uid , 1, price, "pending");
                System.out.println(res.message);
                if (res.success) {
                    JOptionPane.showMessageDialog(null, "Order Successfull!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Order failed: " + res.message);
                }
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(MakeOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        loadData();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderTable;
    // End of variables declaration
}
