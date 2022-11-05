package factories;

import logic.Input;
import model.Item;
//import model.Order;
import model.Order;
import model.Product;
import model.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the ItemFactory and creates product and service instances
 */
public class SimpleItemFactory implements ItemFactory{

    @Override
    public Product createProduct() {
        System.out.println("Name: ");
        String productName = Input.readString();
        System.out.println("Unit price (in cents): ");
        int productPrice = Input.readInt();
        System.out.println("Quantity: ");
        int productQuantity = Input.readInt();
        return new Product(productName, productPrice, productQuantity);
        //order.getItems().add(new Product(productName, productPrice, productQuantity));
    }

    @Override
    public Service createService() {
        System.out.println("Service type: ");
        String serviceName = Input.readString();
        System.out.println("Number of persons: ");
        int servicePersons = Input.readInt();
        System.out.println("Hours: ");
        int serviceHours = Input.readInt();
        return new Service(serviceName, servicePersons, serviceHours);
        //order.getItems().add(new Service(serviceName, servicePersons, serviceHours));
    }
}
