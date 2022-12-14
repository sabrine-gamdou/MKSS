package ui;

import factories.SimpleItemFactory;
import model.Item;

/**
 * This class was separated from the OrderService class and is responsible for printing and viewing orders and items
 */
public class OrderViewer {

    public void printMenu() {
        //System.out.println("A new session started!");
        System.out.println("Your choice?");
        System.out.println("(0) Finish order");
        System.out.println("(1) Order product");
        System.out.println("(2) Order service");
    }

    public void printOrder(SimpleItemFactory simpleItemFactory, String formattedPrice){
        System.out.println("Sum: "+ formattedPrice);
        System.out.println("Checkout time: " + simpleItemFactory.getCheckoutTime());
        System.out.println("Session ended!\n");
    }

    public void printItemPrice(Item item, String formattedPrice){
        System.out.println(item + " = " + formattedPrice);
    }

}
