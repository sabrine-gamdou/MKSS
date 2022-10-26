import model.Item;
import model.Order;
import model.Product;
import model.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

//TODO split class in model.Product class and model.Service class´?
//TODO use Item as parent class (or composition?) for both items as they require same functionalities: sort and order
//TODO add functionality packages depending on function
public class OrderService {

	private Order order = new Order();

	//Changed menuloop to menuLoop (naming convention)
	public void menuLoop() {
		int input;
		do {
			printMenu();
			input = Input.readInt();
			switch ( input ) {
				case 0: break ;
				case 1: orderProduct(); break ;
				case 2: orderService(); break ;
				default: System.out.println("invalid" ); break ;
			}
		} while( input != 0 );
		sortItems();
		finishOrder() ;
	}
	
	private void printMenu() {
		System.out.println("Your choice?");
		System.out.println("(0) Finish order");
		System.out.println("(1) Order product");
		System.out.println("(2) Order service");
	}

	private void sortItems() {
		Comparator<Item> byPrice =
				Comparator.comparingInt(Item::getPrice);
		order.getItems().sort(byPrice);
	}

	private void orderProduct() {
		System.out.println("Name: ");
		String productName = Input.readString();
		System.out.println("Unit price (in cents): ");
		int productPrice = Input.readInt();
		System.out.println("Quantity: ");
		int productQuantity = Input.readInt();
		order.getItems().add(new Product(productName, productPrice, productQuantity));
	}
	
	private void orderService() {
		System.out.println("Service type: ");
		String serviceName = Input.readString();
		System.out.println("Number of persons: ");
		int servicePersons = Input.readInt();
		System.out.println("Hours: ");
		int serviceHours = Input.readInt();
		order.getItems().add(new Service(serviceName, servicePersons, serviceHours));
	}
	
	private void finishOrder() {
		AtomicInteger sum = new AtomicInteger();
		order.getItems().forEach(item -> {
			System.out.println(item + " = " + formatPrice(item.getPrice()));
			sum.addAndGet(item.getPrice());
		});

		order.setSum(sum.get());
		order.setCheckoutTime(LocalDateTime.now());

		System.out.println("Sum: "+ formatPrice(order.getSum()));
		System.out.println("Checkout time: " + order.getCheckoutTime());

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
