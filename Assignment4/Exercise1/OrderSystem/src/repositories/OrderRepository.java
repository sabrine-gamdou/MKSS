package repositories;

import model.Order;

import java.util.Map;

public interface OrderRepository {
    Order save(Order order);
    Order remove(int id);
    Map<Integer,Order> findAll();
    Order findById(int id);
}
