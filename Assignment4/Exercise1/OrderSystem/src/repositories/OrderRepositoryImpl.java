package repositories;

import model.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepositoryImpl implements OrderRepository {

    private final Map<Integer,Order> orders;

    public OrderRepositoryImpl() {
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
