package ui;

import factories.SimpleItemFactory;
import model.Order;
import repositories.OrderRepository;

/**
 * This is an abstraction interface for possible order services to avoid dependency inversion violations.
 * For instance, the GUI controller from the UI layer, utilizes this interface instead of directly accessing the implementation
 */
public interface OrderServiceInterface {
    void addProduct(String productName, int productPrice, int productQuantity);
    void addService(String serviceName, int servicePersons, int serviceHours);
    Order getCurrentOrder();
    Order finishOrder();
    void setSimpleItemFactory(SimpleItemFactory simpleItemFactory);
    SimpleItemFactory getSimpleItemFactory();
    void setOrderRepository(OrderRepository orderRepository);
    void initializeService();
}
