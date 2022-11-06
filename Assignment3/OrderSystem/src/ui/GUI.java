package ui;

import model.Order;

public class GUI implements UI{


    public void printCurrentOrder(){

    }

    public void createOrder() {

    }

    @Override
    public void printMenu() {

    }

    @Override
    public void printFinishedOrder(Order currentOrder) {

    }

    @Override
    public UserInput readInput(Order currentOrder) {
        return null;
    }

    @Override
    public String formatPrice(int priceInCent) {
        return null;
    }

    @Override
    public void sortItems(Order currentOrder) {

    }

    @Override
    public void printError(String error) {

    }

    @Override
    public void printInfo(String info) {

    }
}
