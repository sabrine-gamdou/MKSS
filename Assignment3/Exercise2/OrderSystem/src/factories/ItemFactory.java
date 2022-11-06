package factories;

import model.Order;
import model.Product;
import model.Service;


/**
 * Abstract factory knows about all item types
 */
public interface ItemFactory {

    // Methods for creating products and services
    Product createProduct();
    Service createService();
}
