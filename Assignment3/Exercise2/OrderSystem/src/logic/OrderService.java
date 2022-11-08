package logic;

import factories.SimpleItemFactory;
import model.Order;
import model.OrderStatus;
import repositories.OrderRepository;
import repositories.OrderRepositoryImpl;
import ui.UI;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {

    private final OrderRepository orderRepository;
    private final UI userInterface;
    private SimpleItemFactory simpleItemFactory;

    private Order currentOrder;

    public OrderService(UI userInterface) {
        this.userInterface = userInterface;
        this.orderRepository = new OrderRepositoryImpl();
        initializeOrder();
    }

    public void menuLoop() {
        if (simpleItemFactory != null) {
            switch (userInterface.readInput()) {
                case FINISH:
                    finishOrder();
                    userInterface.sortItems(currentOrder);
                    userInterface.printFinishedOrder(currentOrder);
                    initializeOrder();
                    break;
                case ADD_PRODUCT:
                    addProduct();
                    break;
                case ADD_SERVICE:
                    addService();
                    break;
                case WAITING:
                    userInterface.printInfo("No user input was received.");
                    break;
                default:
                    userInterface.printError("invalid");
                    break;
            }
            //menuLoop();
        }else{
            userInterface.printError("Internal system error!");
        }
    }

    public void setSimpleItemFactory(SimpleItemFactory simpleItemFactory) {
        this.simpleItemFactory = simpleItemFactory;
    }

    private void addProduct() {
        currentOrder.getItems().add(simpleItemFactory.createProduct());
        updateOrder();
    }

    private void addService() {
        currentOrder.getItems().add(simpleItemFactory.createService());
        updateOrder();
    }

    private void updateOrder() {
        orderRepository.save(currentOrder);
    }

    private void initializeOrder() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.CREATED);
        order.setId(generateId());

        currentOrder = orderRepository.save(order);

        if (currentOrder != null) {
            userInterface.printInfo("New order was created.");
        } else {
            userInterface.printError("Order could not be initialized. Please restart the program!");
        }
    }

    private int generateId() {
        Random random = new SecureRandom();
        return random.nextInt();
    }

    private void finishOrder() {
        if(currentOrder != null){
            AtomicInteger sum = new AtomicInteger();
            currentOrder.getItems().forEach(item -> {
                sum.addAndGet(item.getPrice());
            });

            currentOrder.setSum(sum.get());
            currentOrder.setCheckoutTime(LocalDateTime.now());
            currentOrder.setOrderStatus(OrderStatus.FINISHED);
            updateOrder();
        }else{
            userInterface.printError("No order was initialized.");
        }
    }
}
