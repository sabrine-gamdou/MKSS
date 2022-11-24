package usecases;

import entities.Order;

import java.util.Map;

public interface OrderDataAccess {
    Order save(Order order);
    Order remove(int id);
    Map<Integer,Order> findAll();
    Order findById(int id);
}
