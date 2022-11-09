package controller.item;

import controller.order.Order;

public interface Item {
    void create();
    void update();
    void delete();
    void initialize(Order order);
}
