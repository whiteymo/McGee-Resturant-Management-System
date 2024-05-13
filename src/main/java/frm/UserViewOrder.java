package frm;

import bll.OrderResponse;
import bll.Orders;
import bll.Users;
import dao.InterfaceDao;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class UserViewOrder extends javax.swing.JInternalFrame {

    private Users u;

    /**
     * Creates new form UserViewOrder
     */
    public UserViewOrder() {
        initComponents();
//        loadData();
    }

    public UserViewOrder(Users u) {
        initComponents();
//        loadData();
        this.u = u;
    }

//    public void loadData() {
//        try {
//            InterfaceDao udao = (InterfaceDao) Naming.lookup("rmi://localhost:1099/db");
//            OrderResponse res = (OrderResponse) udao.getUserOrders(u.getId());
//            System.out.println("order");
//            System.out.println(res.orders.size() + " Messagewreturned ->> " + res.message);
//            if (res.success) {
//                DefaultTableModel dtm = new DefaultTableModel(new String[]{"OrderId", "OrderBy", "OrderAt", "Status", "Quantity", "Price", "FoodId"}, 0);
//                userTable.setModel(dtm);
//                for (Orders u : res.orders) {
//                    Object[] rowData = {u.getId(), u.getDeliver_to(), u.getDelivered_at(), u.getState(), u.getQuantity(), u.getPrice(), u.getItem_id()};
//                    dtm.addRow(rowData);
//                }
//            }
//        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
//            Logger.getLogger(AdminViewOrder.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();

        userTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
                }
        ));
        jScrollPane1.setViewportView(userTable);

        btnDelete.setText("Delete Order");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {

    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable userTable;
    // End of variables declaration
}
