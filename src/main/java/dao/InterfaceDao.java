package dao;
import bll.Food;
import bll.FoodResponse;
import bll.OrderResponse;
import bll.Response;
import bll.UserResponse;
import bll.Users;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceDao extends Remote {

    public Users AuthUser(String username, String password, String role) throws RemoteException;

    public Response DeleteUser(int id) throws RemoteException;

    public String InsertUser(int id, String fname, String lname, String username, String password, String role, String gender) throws RemoteException;

    public String UpdateUser(int id, Users u) throws RemoteException;

    public UserResponse getAllUsers() throws RemoteException;

    public String AddFoods(int id, String name, String price, String detail, String category) throws RemoteException;

    public FoodResponse getAllFoods() throws RemoteException;

    public Response DeleteFood(int id) throws RemoteException;

    public String MakeOrder(int id, int deliver_to, String created_at, String state, String delivered_at, int quantity, float price, int item_id) throws RemoteException;

    public Response orderItem(int user_id, int food_id, int quantity, String price, String state) throws RemoteException;

    public OrderResponse getAllOrders() throws RemoteException;


}
