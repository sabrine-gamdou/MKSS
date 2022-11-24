package factories;

import logic.Input;
import model.Item;
import model.Product;
import model.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//import entities.Order;

/**
 * This class implements the ItemFactory and creates product and service instances
 */
public class SimpleItemFactory implements ItemFactory{

    private List<Item> items = new ArrayList<>();
    private LocalDateTime checkoutTime;
    private int sum = 0;

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void setCheckoutTime(LocalDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    @Override
    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    @Override
    public int getSum() {
        return sum;
    }

    @Override
    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public void createProduct(ItemFactory itemFactory) {
        System.out.println("Name: ");
        String productName = Input.readString();
        System.out.println("Unit price (in cents): ");
        int productPrice = Input.readInt();
        System.out.println("Quantity: ");
        int productQuantity = Input.readInt();
        itemFactory.getItems().add(new Product(productName, productPrice, productQuantity));
    }

    @Override
    public void createService(ItemFactory itemFactory) {
        System.out.println("Service type: ");
        String serviceName = Input.readString();
        System.out.println("Number of persons: ");
        int servicePersons = Input.readInt();
        System.out.println("Hours: ");
        int serviceHours = Input.readInt();
        itemFactory.getItems().add(new Service(serviceName, servicePersons, serviceHours));
    }
}
