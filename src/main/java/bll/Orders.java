package bll;

import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Orders implements Serializable {

    private int id;
    private int deliver_to;
    private String created_at;
    private String state;
    private String delivered_at;
    private int quantity;
    private String price;
    private int item_id;

    public Orders(int id, int deliver_to, String created_at, String state, String delivered_at, int quantity, String price, int item_id) {
        this.id = id;
        this.deliver_to = deliver_to;
        this.created_at = created_at;
        this.state = state;
        this.delivered_at = delivered_at;
        this.quantity = quantity;
        this.price = price;
        this.item_id = item_id;
    }

    public Orders(int deliver_to, String created_at, String state, String delivered_at, int quantity, String price, int item_id) {
        this.deliver_to = deliver_to;
        this.created_at = created_at;
        this.state = state;
        this.delivered_at = delivered_at;
        this.quantity = quantity;
        this.price = price;
        this.item_id = item_id;
    }

    public Orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeliver_to() {
        return deliver_to;
    }

    public void setDeliver_to(int deliver_to) {
        this.deliver_to = deliver_to;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDelivered_at() {
        return delivered_at;
    }

    public void setDelivered_at(String delivered_at) {
        this.delivered_at = delivered_at;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
