import logic.OrderService;

public class OrderSystemMain {
	public static void main(String[] args) {
		OrderService orderService = new OrderService();
		orderService.menuLoop();
	}
}
