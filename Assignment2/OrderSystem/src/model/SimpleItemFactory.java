package model;

import logic.Input;

public class SimpleItemFactory implements ItemFactory{

    //Order order = new Order();

    @Override
    public void createProduct(Order order) {
        System.out.println("Name: ");
        String productName = Input.readString();
        System.out.println("Unit price (in cents): ");
        int productPrice = Input.readInt();
        System.out.println("Quantity: ");
        int productQuantity = Input.readInt();
        order.getItems().add(new Product(productName, productPrice, productQuantity));
        //return product;
    }

    @Override
    public void createService(Order order) {
        System.out.println("Service type: ");
        String serviceName = Input.readString();
        System.out.println("Number of persons: ");
        int servicePersons = Input.readInt();
        System.out.println("Hours: ");
        int serviceHours = Input.readInt();
        order.getItems().add(new Service(serviceName, servicePersons, serviceHours));
        //return service;
    }
}
