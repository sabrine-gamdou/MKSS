package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();
    private List<Service> services = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public List<Service> getServices() {
        return services;
    }
}
