package factories;

import model.Order;


/**
 * Abstract factory knows about all item types
 */
public interface ItemFactory {

    // Methods for creating products and services
    void createProduct(Order order);
    void createService(Order order);
}
