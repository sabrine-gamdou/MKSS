import factories.SimpleItemFactory;
import logic.OrderService;

public class OrderSystemMain {
	public static void main(String[] args) {
		OrderService orderService = new OrderService();
		SimpleItemFactory simpleItemFactory = new SimpleItemFactory();
		orderService.setSimpleItemFactory(simpleItemFactory);
		orderService.menuLoop();
	}
}
