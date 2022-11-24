package logic;

import factories.SimpleItemFactory;
import model.Order;
import model.OrderStatus;
import repositories.OrderRepository;
import uis.OrderServiceInterface;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService implements OrderServiceInterface {

    private OrderRepository orderRepository;
    private SimpleItemFactory simpleItemFactory;

    private Order currentOrder;

    public OrderService() {
    }

    public void addProduct(String productName, int productPrice, int productQuantity) {
        currentOrder.getItems().add(simpleItemFactory.createProduct(productName, productPrice, productQuantity));
        updateOrder();
    }

    public void addService(String serviceName, int servicePersons, int serviceHours) {
        currentOrder.getItems().add(simpleItemFactory.createService(serviceName, servicePersons, serviceHours));
        updateOrder();
    }

    public Order getCurrentOrder(){
        return currentOrder;
    }

    public void initializeService() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.CREATED);
        order.setId(generateId());

        currentOrder = orderRepository.save(order);
    }

    public Order finishOrder() {
        if(currentOrder != null){
            AtomicInteger sum = new AtomicInteger();
            currentOrder.getItems().forEach(item -> {
                sum.addAndGet(item.getPrice());
            });

            currentOrder.setSum(sum.get());
            currentOrder.setCheckoutTime(LocalDateTime.now());
            currentOrder.setOrderStatus(OrderStatus.FINISHED);
            updateOrder();
        }
        return currentOrder;
    }

    private int generateId() {
        Random random = new SecureRandom();
        return random.nextInt();
    }

    private void updateOrder() {
        orderRepository.save(currentOrder);
    }

    public void setSimpleItemFactory(SimpleItemFactory simpleItemFactory) {
        this.simpleItemFactory = simpleItemFactory;
    }

    public SimpleItemFactory getSimpleItemFactory() {
        return simpleItemFactory;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
