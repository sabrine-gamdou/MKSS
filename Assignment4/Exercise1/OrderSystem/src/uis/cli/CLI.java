package uis.cli;


import entities.Item;
import entities.Product;
import entities.Service;
import logic.Input;
import usecases.OrderInputBoundary;
import usecases.OrderInputData;
import usecases.OrderOutputBoundary;
import usecases.OrderOutputData;
import utils.Utility;

/**
 * This class was separated from the OrderService class and is responsible for printing and viewing orders and items
 */
public class CLI implements OrderOutputBoundary {

    private OrderInputBoundary model;
    private OrderOutputData currentOutputData;

    public CLI(OrderInputBoundary model) {
        this.model = model;
    }

    public void printMenu() {
        System.out.println("Your choice?");
        System.out.println("(0) Finish order");
        System.out.println("(1) Order product");
        System.out.println("(2) Order service");
    }

    public void printFinishedOrder(OrderOutputData currentOrder) {
        currentOrder.getItems().forEach(item -> printItemPrice(item, Utility.formatPrice(item.getPrice())));

        System.out.println("Sum: " + Utility.formatPrice(currentOrder.getSum()));
        System.out.println("Checkout time: " + Utility.formatCheckoutTime(currentOrder.getCheckoutTime()));
        System.out.println("Session ended!\n");
    }

    public void menuLoop() {
        if (currentOutputData != null) {
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
                            model.addProduct(new OrderInputData(product.getName(), product.getUnitPrice(), product.getQuantity()));
                        }
                        case 2 -> {
                            Service service = addService();
                            model.addService(new OrderInputData(service.getName(), service.getPersons(), service.getHours()));
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
        if (currentOutputData != null) {
            model.finishOrder();
            printInfo("Order was finished.");
            Utility.sortItems(currentOutputData);
            printFinishedOrder(currentOutputData);
            model.initializeService();
        } else {
            printError("No order was initialized.");
        }
    }

    @Override
    public void setCurrentOrder(OrderOutputData orderOutputData) {
        this.currentOutputData = orderOutputData;
    }
}
