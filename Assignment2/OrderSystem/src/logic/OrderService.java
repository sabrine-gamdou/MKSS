package logic;

import model.Item;
//import model.Order;
import factories.SimpleItemFactory;
import ui.OrderViewer;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {

	//private Order order = new Order();
	private OrderViewer orderViewer = new OrderViewer();
	private SimpleItemFactory simpleItemFactory = new SimpleItemFactory();

	public void menuLoop() {
		int input;
		do {
			orderViewer.printMenu();
			input = Input.readInt();
			switch ( input ) {
				case 0: break ;
				case 1: simpleItemFactory.createProduct(simpleItemFactory); break ;
				case 2: simpleItemFactory.createService(simpleItemFactory); break ;
				default: System.out.println("invalid"); break ;
			}
		} while( input != 0 );
		sortItems();
		finishOrder() ;
	}

	private void sortItems() {
		Comparator<Item> byPrice =
				Comparator.comparingInt(Item::getPrice);
		simpleItemFactory.getItems().sort(byPrice);
	}

	public void setSimpleItemFactory(SimpleItemFactory simpleItemFactory) {
		this.simpleItemFactory = simpleItemFactory;
	}

	private void finishOrder() {
		AtomicInteger sum = new AtomicInteger();
		simpleItemFactory.getItems().forEach(item -> {
			orderViewer.printItemPrice(item,formatPrice(item.getPrice()));
			sum.addAndGet(item.getPrice());
		});

		simpleItemFactory.setSum(sum.get());
		simpleItemFactory.setCheckoutTime(LocalDateTime.now());

		orderViewer.printOrder(simpleItemFactory, formatPrice(simpleItemFactory.getSum()));

		emptyCart();
		menuLoop();
	}

	private void emptyCart(){
		simpleItemFactory.getItems().clear();
	}

	private String formatPrice(int priceInCent) {
		return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
			+ priceInCent % 100 + " EUR";
	}
}
