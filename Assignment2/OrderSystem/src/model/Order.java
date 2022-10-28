package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Item> items = new ArrayList<>();
    private LocalDateTime checkoutTime;
    private int sum = 0;

    public List<Item> getItems() {
        return items;
    }

    public void setCheckoutTime(LocalDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
