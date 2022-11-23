package controller;

import model.Order;
import ui.OrderServiceInterface;
import ui.gui.GUI;

import java.awt.event.ActionEvent;

public class OrderController {
    private GUI view;
    private OrderServiceInterface model;

    public OrderController(OrderServiceInterface orderServiceInterface) {
        this.model = orderServiceInterface;
        this.view = new GUI();
        initializeView();
    }

    private void initializeView(){
        getCurrentOrder();
    }

    public OrderServiceInterface getModel() {
        return model;
    }

    public void initializeController() {
        // Set action listener to product dialog buttons
        view.getNewProductDialog().getSaveButton().addActionListener(e -> {
            addProduct();
            getCurrentOrder();
            view.getNewProductDialog().setVisible(false);
        });
        view.getNewProductDialog().getQuitButton().addActionListener(e -> view.getNewProductDialog().setVisible(false));

        // Set action listener to service dialog buttons
        view.getNewServiceDialog().getSaveButton().addActionListener(e -> {
            addService();
            getCurrentOrder();
            view.getNewServiceDialog().setVisible(false);
        });
        view.getNewServiceDialog().getQuitButton().addActionListener(e ->  view.getNewServiceDialog().setVisible(false));

        // Set action listener to finish dialog buttons
        view.getFinishButton().addActionListener(this::showFinishedOrder);
        view.getNewClientFinishDialog().getQuitButton().addActionListener(e -> resetOrder());
    }

    private void addProduct() {
        model.addProduct(view.getNewProductDialog().getItemName(),
                        view.getNewProductDialog().getItemsPriceLabel(),
                        view.getNewProductDialog().getQuantityLabel());
    }

    private void addService() {
        model.addService(view.getNewServiceDialog().getItemName(),
                        view.getNewServiceDialog().getItemsPriceLabel(),
                        view.getNewServiceDialog().getQuantityLabel());
    }

    private void resetOrder() {
        model.initializeService();
        getCurrentOrder();
    }

    private Order finishOrder() {
        return model.finishOrder(); //got finished order from backend -- need to render and update GUI -- update order in view
    }

    private void getCurrentOrder() {
        view.getItemsPanel().updateTable(model.getCurrentOrder()); //got order from backend -- need to render and update GUI
    }

    private void showFinishedOrder(ActionEvent e) {
        view.getNewClientFinishDialog().showDialog(finishOrder());
    }
}
