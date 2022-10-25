import model.Order;
import model.Product;
import model.Service;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

//TODO split class in model.Product class and model.Service class´?
//TODO use Item as parent class (or composition?) for both items as they require same functionalities: sort and order
//TODO add functionality packages depending on function
public class OrderService {

	private Order orders = new Order();

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
		sortProducts();
		sortServices();
		finishOrder() ;
	}
	
	private void printMenu() {
		System.out.println("Your choice?");
		System.out.println("(0) Finish order");
		System.out.println("(1) Order product");
		System.out.println("(2) Order service");
	}
	
	private void sortProducts() {
		Comparator<Product> byPrice =
				Comparator.comparingInt(Product::getPrice);
		orders.getProducts().sort(byPrice);
	}

	private void sortServices() {
		Comparator<Service> byPrice =
				Comparator.comparingInt(Service::getPrice);
		orders.getServices().sort(byPrice);
	}
	private void orderProduct() {
		System.out.println("Name: ");
		String productName = Input.readString();
		System.out.println("Unit price (in cents): ");
		int productPrice = Input.readInt();
		System.out.println("Quantity: ");
		int productQuantity = Input.readInt();
		orders.getProducts().add(new Product(productName, productPrice, productQuantity));
	}
	
	private void orderService() {
		System.out.println("Service type: ");
		String serviceName = Input.readString();
		System.out.println("Number of persons: ");
		int servicePersons = Input.readInt();
		System.out.println("Hours: ");
		int serviceHours = Input.readInt();
		orders.getServices().add(new Service(serviceName, servicePersons, serviceHours));
	}
	
	private void finishOrder() {
		AtomicInteger sum = new AtomicInteger();
		orders.getProducts().forEach(product -> {
			System.out.println(product + " = " + formatPrice(product.getPrice()));
			sum.addAndGet(product.getPrice());
		});

		orders.getServices().forEach(service -> {
			System.out.println(service.toString());
			System.out.println(" = " + formatPrice(service.getPrice()));
			sum.addAndGet(service.getPrice());
		});

		System.out.println("Sum: "+ formatPrice(sum.get()));
		emptyCart();
		menuLoop();
	}

	private void emptyCart(){
		orders.getProducts().clear();
		orders.getServices().clear();
	}
	private String formatPrice(int priceInCent) {
		return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
			+ priceInCent % 100 + " EUR";
	}
}
