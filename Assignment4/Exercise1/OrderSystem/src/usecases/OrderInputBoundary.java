package usecases;

import entities.factories.SimpleItemFactory;

public interface OrderInputBoundary {
    void addProduct(OrderInputData orderInputData);
    void addService(OrderInputData orderInputData);
    OrderOutputData finishOrder();
    void setSimpleItemFactory(SimpleItemFactory simpleItemFactory);
    SimpleItemFactory getSimpleItemFactory();
    void setOrderDataAccess(OrderDataAccess orderDataAccess);
    void initializeService();
}
