package usecases;

import entities.Item;
import entities.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderOutputData {
    private List<Item> items = new ArrayList<>();
    private LocalDateTime checkoutTime;
    private int sum = 0;
    private OrderStatus orderStatus;
    private int id;

    public OrderOutputData(List<Item> items, LocalDateTime checkoutTime, int sum, OrderStatus orderStatus, int id) {
        this.items = items;
        this.checkoutTime = checkoutTime;
        this.sum = sum;
        this.orderStatus = orderStatus;
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(LocalDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
