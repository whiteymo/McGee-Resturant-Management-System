package dao;

import bll.Food;
import bll.FoodResponse;
import bll.OrderResponse;
import bll.Orders;
import bll.Response;
import bll.UserResponse;
import bll.Users;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.sql.Connection;
import java.sql.Statement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DbConnection;
import utils.Helpers;

/**
 *
 * @author Dell
 */
public class Server extends UnicastRemoteObject implements InterfaceDao {

    private Connection cn;
    private PreparedStatement ps;

    public Server() throws RemoteException {
        super();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodsystem", "root", "");

        } catch (Exception ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(1099);
        Server s = new Server();
        reg.rebind("db", s);
        System.out.println("Server is running now.........");
    }

    @Override
    public Response DeleteUser(int id) throws RemoteException {
        try {
            String sql = "Delete FROM users where id=?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return new Response(true, "Successfull");
        } catch (SQLException ex) {
            return new Response(false, ex.getMessage());
        }
    }

    @Override
    public String InsertUser(int id, String fname, String lname, String username, String password, String role, String gender) throws RemoteException {
        try {
//            cn = DbConnection.myConnection();
            Statement st = cn.createStatement();
            String sql = "insert into users value('" + id + "','" + fname + "', '" + lname + "', '" + username + "', '" + password + "', '" + role + "', '" + gender + "')";
            st.executeUpdate(sql);
            return "Record Insert Successfully";
        } catch (Exception e) {
            return (e.toString());
        }
    }

    @Override
    public UserResponse getAllUsers() throws RemoteException {
        List<Users> us = new ArrayList<>();
        try {
            String sql = "SELECT * From users";
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (Helpers.isMyResultSetEmpty(rs)) {
                return new UserResponse(false, "No Data", Collections.<Users>emptyList());

            } else {
                while (rs.next()) {
                    Users user = new Users(
                            rs.getInt("id"),
                            rs.getString("fname"),
                            rs.getString("lname"),
                            rs.getString("username"),
                            rs.getString("gender"),
                            rs.getString("password"),
                            rs.getString("role")
                    );
                    us.add(user);
                }
                return new UserResponse(true, "Successfull", us);
            }
        } catch (SQLException ex) {
            return new UserResponse(false, ex.getMessage(), Collections.<Users>emptyList());
        }
    }

    @Override
    public Users AuthUser(String username, String password, String role) throws RemoteException {
        try {
            String sql = "SELECT * From users where username=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (Helpers.isMyResultSetEmpty(rs)) {
                return new Users();
            } else {

                if (rs.getString("password").equals(password) && rs.getString("role").equals(role)) {

                    Users user = new Users(
                            rs.getInt("id"),
                            rs.getString("fname"),
                            rs.getString("lname"),
                            rs.getString("username"),
                            rs.getString("gender"),
                            rs.getString("password"),
                            rs.getString("role")
                    );
                    return user;
                } else {

                    return new Users();
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return new Users();
        }

    }

    @Override
    public String AddFoods(int id, String name, String price, String detail, String category) throws RemoteException {
        try {
//            cn = DbConnection.myConnection();
            Statement st = cn.createStatement();
            String sql = "insert into foods value('" + id + "','" + name + "', '" + price + "', '" + detail + "', '" + category + "')";
            st.executeUpdate(sql);
            return "Record Insert Successfully";
        } catch (Exception e) {
            return (e.toString());
        }
    }

    @Override
    public FoodResponse getAllFoods() throws RemoteException {
        List<Food> us = new ArrayList<>();
        try {
            String sql = "SELECT * From foods";
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (Helpers.isMyResultSetEmpty(rs)) {
                return new FoodResponse(false, "No Data", Collections.<Food>emptyList());

            } else {
                while (rs.next()) {
                    Food fod = new Food(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("price"),
                            rs.getString("detail"),
                            rs.getString("category")
                    );
                    us.add(fod);
                }
                return new FoodResponse(true, "Successfull", us);
            }
        } catch (SQLException ex) {
            return new FoodResponse(false, ex.getMessage(), Collections.<Food>emptyList());
        }
    }

    @Override
    public Response DeleteFood(int id) throws RemoteException {
        try {
            String sql = "Delete FROM foods where id=?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return new Response(true, "Successfull");
        } catch (SQLException ex) {
            return new Response(false, ex.getMessage());
        }
    }

    @Override
    public String UpdateUser(int id, Users u) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String MakeOrder(int id, int deliver_to, String created_at, String state, String delivered_at, int quantity, float price, int item_id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Response orderItem(int user_id, int food_id, int quantity, String price, String state) throws RemoteException {
        try {
            String sql = "INSERT INTO orders(deliver_to, item_id, delivered_at, quantity, price, state) VALUES(?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setInt(2, food_id);
            ps.setString(3, Helpers.getTimeStamp());
            ps.setInt(4, quantity);
            ps.setString(5, price);
            ps.setString(6, state);

            ps.execute();
            return new Response(true, "Successfull");
        } catch (SQLException ex) {
            return new Response(false, ex.getMessage());
        }
    }

    @Override
    public OrderResponse getAllOrders() throws RemoteException {
        List<Orders> orderlist = new ArrayList<>();
        try {
            String sql = "SELECT * From orders";
            ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (Helpers.isMyResultSetEmpty(rs)) {
                return new OrderResponse(false, "NO Items", Collections.<Orders>emptyList());
            } else {
                while (rs.next()) {
                    Orders od = new Orders(
                            rs.getInt("id"),
                            rs.getInt("deliver_to"),
                            rs.getString("created_at"),
                            rs.getString("state"),
                            rs.getString("delivered_at"),
                            rs.getInt("quantity"),
                            rs.getString("price"),
                            rs.getInt("item_id")
                    );
                    orderlist.add(od);
                }
                return new OrderResponse(true, "Successfull", orderlist);
            }
        } catch (SQLException ex) {
            return new OrderResponse(false, ex.getMessage(), Collections.<Orders>emptyList());
        }
    }

}