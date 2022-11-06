package ui;

import logic.Input;
import model.Item;
import model.Order;

import java.util.Comparator;

/**
 * This class was separated from the OrderService class and is responsible for printing and viewing orders and items
 */
public class CLI implements UI{

    public void printMenu() {
        System.out.println("Your choice?");
        System.out.println("(0) Finish order");
        System.out.println("(1) Order product");
        System.out.println("(2) Order service");
    }

    @Override
    public void printFinishedOrder(Order currentOrder) {
        currentOrder.getItems().forEach(item -> {
            printItemPrice(item, formatPrice(item.getPrice()));
        });

        System.out.println("Sum: "+ formatPrice(currentOrder.getSum()));
        System.out.println("Checkout time: " + currentOrder.getCheckoutTime());
        System.out.println("Session ended!\n");
    }

    @Override
    public UserInput readInput() {
        int input;
        do {
            printMenu();
            input = Input.readInt();
            switch (input) {
                case 0:
                    return UserInput.FINISH;
                case 1:
                    return UserInput.ADD_PRODUCT;
                case 2:
                    return UserInput.ADD_SERVICE;
                default:
                    return null;
            }
        } while (input != 0);
    }

    @Override
    public String formatPrice(int priceInCent) {
        return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
                + priceInCent % 100 + " EUR";
    }

    @Override
    public void sortItems(Order currentOrder) {
        Comparator<Item> byPrice =
                Comparator.comparingInt(Item::getPrice);
        currentOrder.getItems().sort(byPrice);
    }

    @Override
    public void printError(String error) {
        System.out.println(error);
    }

    public void printInfo(String info){
        System.out.println(info);
    }

    public void printOrder(Order order, String formattedPrice){

    }

    public void printItemPrice(Item item, String formattedPrice){
        System.out.println(item + " = " + formattedPrice);
    }

}
