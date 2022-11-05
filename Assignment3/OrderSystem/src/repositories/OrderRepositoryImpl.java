package repositories;

import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private List<Order> orders;

    public OrderRepositoryImpl() {
        this.orders = new ArrayList<>();
    }

    @Override
    public Order save(Order order) {
        if (!orders.contains(order)) {
            orders.add(order);
        } else {
            get(order.getId()).setSum(order.getSum());
            get(order.getId()).setOrderStatus(order.getOrderStatus());
            get(order.getId()).setCheckoutTime(order.getCheckoutTime());
        }
        return orders.get(order.getId());
    }

    @Override
    public Order remove(int id) {
        if (!orders.contains(get(id))) {
            return null;
        } else {
            return orders.remove(id);
        }
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    private Order get(int id) {
        return orders.get(id);
    }
}
