package ui;

import model.Order;

public interface UI {
    void printMenu();
    void printFinishedOrder(Order currentOrder);
    UserInput readInput(Order currentOrder);
    String formatPrice(int priceInCent);
    void sortItems(Order currentOrder);
    void printError(String error);
    void printInfo(String info);
}
