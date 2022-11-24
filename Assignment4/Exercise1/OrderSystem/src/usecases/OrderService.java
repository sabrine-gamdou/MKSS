package usecases;

import entities.Order;
import entities.OrderStatus;
import entities.factories.SimpleItemFactory;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService implements OrderInputBoundary {

    private OrderDataAccess orderDataAccess;
    private SimpleItemFactory simpleItemFactory;
    private OrderOutputBoundary orderOutputBoundary;

    private Order currentOrder;

    public OrderService() {
    }

    public void addProduct(OrderInputData orderInputData) {
        String productName = orderInputData.getName();
        int productPrice = orderInputData.getUnitPrice();
        int productQuantity = orderInputData.getQuantity();
        currentOrder.getItems().add(simpleItemFactory.createProduct(productName, productPrice, productQuantity));
        updateOrder();
    }

    public void addService(OrderInputData orderInputData) {
        String serviceName = orderInputData.getName();
        int servicePersons = orderInputData.getUnitPrice();
        int serviceHours = orderInputData.getQuantity();
        currentOrder.getItems().add(simpleItemFactory.createService(serviceName, servicePersons, serviceHours));
        updateOrder();
    }

    public void initializeService() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.CREATED);
        order.setId(generateId());

        currentOrder = orderDataAccess.save(order);
    }

    public OrderOutputData finishOrder() {
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
        return new OrderOutputData(currentOrder.getItems(),currentOrder.getCheckoutTime(),currentOrder.getSum(),
                currentOrder.getOrderStatus(),currentOrder.getId());
    }

    private int generateId() {
        Random random = new SecureRandom();
        return random.nextInt();
    }

    private void updateOrder() {
        orderDataAccess.save(currentOrder);
        orderOutputBoundary.setCurrentOrder(new OrderOutputData(currentOrder.getItems(),currentOrder.getCheckoutTime(),
                currentOrder.getSum(), currentOrder.getOrderStatus(), currentOrder.getId()));
    }

    public void setSimpleItemFactory(SimpleItemFactory simpleItemFactory) {
        this.simpleItemFactory = simpleItemFactory;
    }

    public SimpleItemFactory getSimpleItemFactory() {
        return simpleItemFactory;
    }

    public OrderDataAccess getOrderDataAccess() {
        return orderDataAccess;
    }

    public void setOrderDataAccess(OrderDataAccess orderDataAccess) {
        this.orderDataAccess = orderDataAccess;
    }

    public OrderOutputBoundary getOrderOutputBoundary() {
        return orderOutputBoundary;
    }

    public void setOrderOutputBoundary(OrderOutputBoundary orderOutputBoundary) {
        this.orderOutputBoundary = orderOutputBoundary;
    }
}
