package factories;

import model.Item;
//import model.Order;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This is the common interface for items family
 */
public interface ItemFactory {

    List<Item> getItems();
    void setCheckoutTime(LocalDateTime checkoutTime);
    LocalDateTime getCheckoutTime();
    int getSum();
    void setSum(int sum);

    void createProduct(ItemFactory itemFactory);
    void createService(ItemFactory itemFactory);
}
