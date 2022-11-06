package logic;

import factories.SimpleItemFactory;
import model.Item;
import model.Order;
import model.OrderStatus;
import repositories.OrderRepository;
import repositories.OrderRepositoryImpl;
import ui.OrderViewer;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderViewer orderViewer;
    private SimpleItemFactory simpleItemFactory;

    private Order currentOrder;

    public OrderService() {
        this.orderRepository = new OrderRepositoryImpl();
        this.orderViewer = new OrderViewer();
    }

    public void menuLoop() {
        if (simpleItemFactory != null) {
            initializeOrder();
            int input;
            do {
                orderViewer.printMenu();
                input = Input.readInt();
                switch (input) {
                    case 0:
                        break;
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        addService();
                        break;
                    default:
                        System.out.println("invalid");
                        break;
                }
            } while (input != 0);
            sortItems(currentOrder.getId());
            finishOrder();
        } else {
            System.out.println("Internal system error!");
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
            System.out.println("Order was created.");
        } else {
            // order wasn't created - log error for ex.
            System.out.println("Order could not be initialized. Please restart the program!");
        }
    }

    private int generateId() {
        Random random = new SecureRandom();
        return random.nextInt();
    }

    private void sortItems(int id) {
        Comparator<Item> byPrice =
                Comparator.comparingInt(Item::getPrice);
        orderRepository.findById(id).getItems().sort(byPrice);
    }

    private void finishOrder() {
        AtomicInteger sum = new AtomicInteger();
        currentOrder.getItems().forEach(item -> {
            orderViewer.printItemPrice(item, formatPrice(item.getPrice()));
            sum.addAndGet(item.getPrice());
        });

        currentOrder.setSum(sum.get());
        currentOrder.setCheckoutTime(LocalDateTime.now());
        currentOrder.setOrderStatus(OrderStatus.FINISHED);
        updateOrder();

        orderViewer.printOrder(currentOrder, formatPrice(currentOrder.getSum()));

        emptyCart();
        menuLoop();
    }

    private void emptyCart() {
        currentOrder.getItems().clear();
    }

    private String formatPrice(int priceInCent) {
        return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
                + priceInCent % 100 + " EUR";
    }
}
