package repositories;

import model.Order;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);
    Order remove(int id);
    List findAll();
    Order findById(int id);
}
