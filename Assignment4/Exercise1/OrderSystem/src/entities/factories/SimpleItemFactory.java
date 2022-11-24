package entities.factories;

import entities.Product;
import entities.Service;

/**
 * This class implements the ItemFactory and creates product and service instances
 */
public class SimpleItemFactory implements ItemFactory{
    @Override
    public Product createProduct(String productName, int productPrice, int productQuantity) {
        return new Product(productName, productPrice, productQuantity);
    }

    @Override
    public Service createService(String serviceName, int servicePersons, int serviceHours) {
        return new Service(serviceName, servicePersons, serviceHours);
    }
}
