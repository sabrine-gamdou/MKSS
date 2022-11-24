package uis.cli;

import logic.Input;
import model.Item;
import model.Order;
import model.Product;
import model.Service;
import uis.OrderServiceInterface;
import utils.Utility;

/**
 * This class was separated from the OrderService class and is responsible for printing and viewing orders and items
 */
public class CLI {

    private OrderServiceInterface model;

    public CLI(OrderServiceInterface model) {
        this.model = model;
    }

    public void printMenu() {
        System.out.println("Your choice?");
        System.out.println("(0) Finish order");
        System.out.println("(1) Order product");
        System.out.println("(2) Order service");
    }

    public void printFinishedOrder(Order currentOrder) {
        currentOrder.getItems().forEach(item -> printItemPrice(item, Utility.formatPrice(item.getPrice())));

        System.out.println("Sum: " + Utility.formatPrice(currentOrder.getSum()));
        System.out.println("Checkout time: " + Utility.formatCheckoutTime(currentOrder.getCheckoutTime()));
        System.out.println("Session ended!\n");
    }

    public void menuLoop() {
        if (model.getCurrentOrder() != null) {
            printInfo("New order was created.");
            if (model.getSimpleItemFactory() != null) {
                int input;
                do {
                    printMenu();
                    input = Input.readInt();
                    switch (input) {
                        case 0 -> finishOrder();
                        case 1 -> {
                            Product product = addProduct();
                            model.addProduct(product.getName(), product.getUnitPrice(), product.getQuantity());
                        }
                        case 2 -> {
                            Service service = addService();
                            model.addService(service.getName(), service.getPersons(), service.getHours());
                        }
                        default -> printError("invalid");
                    }
                } while (input != 0);
                menuLoop();
            } else {
                printError("Internal system error!");
            }
        } else {
            printError("Order could not be initialized. Please restart the program!");
        }

    }

    public Product addProduct() {
        System.out.println("Name: ");
        String productName = Input.readString();
        System.out.println("Unit price (in cents): ");
        int productPrice = Input.readInt();
        System.out.println("Quantity: ");
        int productQuantity = Input.readInt();
        return new Product(productName, productPrice, productQuantity);
    }

    public Service addService() {
        System.out.println("Service type: ");
        String serviceName = Input.readString();
        System.out.println("Number of persons: ");
        int servicePersons = Input.readInt();
        System.out.println("Hours: ");
        int serviceHours = Input.readInt();
        return new Service(serviceName, serviceHours, servicePersons);
    }

    public void printError(String error) {
        System.out.println(error);
    }

    public void printInfo(String info) {
        System.out.println(info);
    }

    public void printItemPrice(Item item, String formattedPrice) {
        System.out.println(item + " = " + formattedPrice);
    }

    private void finishOrder() {
        if (model.getCurrentOrder() != null) {
            model.finishOrder();
            printInfo("Order was finished.");
            Utility.sortItems(model.getCurrentOrder());
            printFinishedOrder(model.getCurrentOrder());
            model.initializeService();
        } else {
            printError("No order was initialized.");
        }
    }
}
