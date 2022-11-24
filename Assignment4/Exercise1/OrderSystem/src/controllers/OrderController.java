package controllers;

import entities.OrderStatus;
import uis.gui.GUI;
import usecases.OrderInputBoundary;
import usecases.OrderInputData;
import usecases.OrderOutputBoundary;
import usecases.OrderOutputData;

import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.Collections;

public class OrderController implements OrderOutputBoundary {
    private GUI view;
    private OrderInputBoundary model;
    private OrderOutputData currentOrder;

    public OrderController(OrderInputBoundary orderInputBoundary) {
        this.model = orderInputBoundary;
        this.view = new GUI();
        initializeView();
    }

    private void initializeView(){
        getCurrentOrder();
    }

    public OrderInputBoundary getModel() {
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
        OrderInputData inputData = new OrderInputData(
                view.getNewProductDialog().getItemName(),
                view.getNewProductDialog().getItemsPriceLabel(),
                view.getNewProductDialog().getQuantityLabel());

        model.addProduct(inputData);
    }

    private void addService() {
        OrderInputData inputData = new OrderInputData(
                view.getNewServiceDialog().getItemName(),
                view.getNewServiceDialog().getItemsPriceLabel(),
                view.getNewServiceDialog().getQuantityLabel());
        model.addService(inputData);
    }

    private void resetOrder() {
        resetOutputData();
        getCurrentOrder();
    }

    private OrderOutputData finishOrder() {
        return model.finishOrder(); //got finished order from backend -- need to render and update GUI -- update order in view
    }

    private void getCurrentOrder() {
        view.getItemsPanel().updateTable(currentOrder); //got order from backend -- need to render and update GUI
    }

    private void showFinishedOrder(ActionEvent e) {
        view.getNewClientFinishDialog().showDialog(finishOrder());
    }

    @Override
    public void setCurrentOrder(OrderOutputData orderOutputData) {
        this.currentOrder = orderOutputData;
    }

    private void resetOutputData() {
        currentOrder = new OrderOutputData(Collections.emptyList(), LocalDateTime.now(),0, OrderStatus.CREATED,0);
    }
}
