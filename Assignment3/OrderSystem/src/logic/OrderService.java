package logic;

import model.Item;
import model.Order;
import factories.SimpleItemFactory;
import ui.OrderViewer;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {

	private Order order = new Order();
	private OrderViewer orderViewer = new OrderViewer();
	private SimpleItemFactory simpleItemFactory;

	public void menuLoop() {
		if (simpleItemFactory != null) {
			int input;
			do {
				orderViewer.printMenu();
				input = Input.readInt();
				switch ( input ) {
					case 0: break ;
					case 1: simpleItemFactory.createProduct(); break ;
					case 2: simpleItemFactory.createService(); break ;
					default: System.out.println("invalid"); break ;
				}
			} while( input != 0 );
			sortItems();
			finishOrder() ;
		} else {
			System.out.println("Internal system error!");
		}
	}

	private void sortItems() {
		Comparator<Item> byPrice =
				Comparator.comparingInt(Item::getPrice);
		order.getItems().sort(byPrice);
	}

	public void setSimpleItemFactory(SimpleItemFactory simpleItemFactory) {
		this.simpleItemFactory = simpleItemFactory;
	}

	private void finishOrder() {
		AtomicInteger sum = new AtomicInteger();
		order.getItems().forEach(item -> {
			orderViewer.printItemPrice(item,formatPrice(item.getPrice()));
			sum.addAndGet(item.getPrice());
		});

		order.setSum(sum.get());
		order.setCheckoutTime(LocalDateTime.now());

		orderViewer.printOrder(order, formatPrice(order.getSum()));

		emptyCart();
		menuLoop();
	}

	private void emptyCart(){
		order.getItems().clear();
	}

	private String formatPrice(int priceInCent) {
		return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
			+ priceInCent % 100 + " EUR";
	}
}
