package ui;

import model.Item;
import model.Order;
/**
 * This class was seperated from the OrderService class and is responsible for printing and viewing orders and items
 */
public class OrderViewer {

    public void printMenu() {
        //System.out.println("A new session started!");
        System.out.println("Your choice?");
        System.out.println("(0) Finish order");
        System.out.println("(1) Order product");
        System.out.println("(2) Order service");
    }

//    public void orderProduct(Order order) {
//        System.out.println("Name: ");
//        String productName = Input.readString();
//        System.out.println("Unit price (in cents): ");
//        int productPrice = Input.readInt();
//        System.out.println("Quantity: ");
//        int productQuantity = Input.readInt();
//        order.getItems().add(new Product(productName, productPrice, productQuantity));
//    }

//    public void orderService(Order order) {
//        System.out.println("Service type: ");
//        String serviceName = Input.readString();
//        System.out.println("Number of persons: ");
//        int servicePersons = Input.readInt();
//        System.out.println("Hours: ");
//        int serviceHours = Input.readInt();
//        order.getItems().add(new Service(serviceName, servicePersons, serviceHours));
//    }

    public void printOrder(Order order, String formattedPrice){
        System.out.println("Sum: "+ formattedPrice);
        System.out.println("Checkout time: " + order.getCheckoutTime());
        System.out.println("Session ended!\n");
    }

    public void printItemPrice(Item item, String formattedPrice){
        System.out.println(item + " = " + formattedPrice);
    }

}
