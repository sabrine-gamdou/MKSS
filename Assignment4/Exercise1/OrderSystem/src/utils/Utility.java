package utils;

import model.Item;
import model.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public final class Utility {

    private Utility() {
        System.out.println("Utility class.");
    }

    public static String formatPrice(int priceInCent) {
        return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
                + priceInCent % 100 + " EUR";
    }

    public static void sortItems(Order currentOrder) {
        Comparator<Item> byPrice =
                Comparator.comparingInt(Item::getPrice);
        currentOrder.getItems().sort(byPrice);
    }

    public static String formatCheckoutTime(LocalDateTime checkoutTime) {
        return checkoutTime.format(DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss"));
    }
}
