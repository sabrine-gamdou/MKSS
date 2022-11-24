package gateways;

import entities.Item;
import entities.Order;
import usecases.OrderDataAccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository implements OrderDataAccess {

    private final Map<Integer,Order> orders;

    public OrderRepository() {
        this.orders = new HashMap<>();
    }

    @Override
    public Order save(Order order) {
        if (orders.containsValue(order)) {
            orders.remove(order.getId());
        }
        orders.put(order.getId(),order);
        Order newOrder;
        return orders.get(order.getId());
    }

    @Override
    public Order remove(int id) {
        if (!orders.containsKey(id)) {
            return null;
        } else {
            return orders.remove(id);
        }

    }

    @Override
    public Map<Integer,Order> findAll() {
        Map<Integer,Order> newOrders = new HashMap<>();

        for(Order order : orders.values()){
            Order newOrder = new Order();
            newOrder.setId(order.getId());
            newOrder.setOrderStatus(order.getOrderStatus());
            newOrder.setCheckoutTime(order.getCheckoutTime());
            newOrder.setSum(order.getSum());
            //newOrder.setItems(order.get);

            List<Item> items = new ArrayList<>();
            order.getItems().forEach(item -> {
                //items.add()
            });


            newOrders.put(order.getId(), newOrder);
        }
        return orders;
    }

    @Override
    public Order findById(int id) {
        if (get(id) == null) {
            return null;
        } else {
            return get(id);
        }
    }

    private Order get(int id) {
        return orders.get(id);
    }
}
