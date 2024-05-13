package bll;

import java.util.List;

public class OrderResponse extends Response{
    public Orders order;
    public List<Orders> orders;

    public OrderResponse(boolean success, String message, Orders order) {
        super(success, message);
        this.order = order;
    }

    public OrderResponse(boolean success, String message, List<Orders> orders) {
        super(success, message);
        this.orders = orders;
    }
}
