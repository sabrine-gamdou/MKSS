package factories;

import model.Item;
//import entities.Order;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Abstract factory knows about all item types
 */
public interface ItemFactory {

    // Methods from old Order class
    List<Item> getItems();
    void setCheckoutTime(LocalDateTime checkoutTime);
    LocalDateTime getCheckoutTime();
    int getSum();
    void setSum(int sum);

    // Methods for creating products and services
    void createProduct(ItemFactory itemFactory);
    void createService(ItemFactory itemFactory);
}
