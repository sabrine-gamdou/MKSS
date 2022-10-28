package model;

public interface ItemFactory {
    void createProduct(Order order);
    void createService(Order order);
}
