import controller.OrderController;
import factories.SimpleItemFactory;
import logic.OrderService;
import repositories.OrderRepositoryImpl;
import ui.cli.CLI;

public class OrderSystemMain {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        // Initialize the components in the OrderService
        orderService.setOrderRepository(new OrderRepositoryImpl());
        orderService.setSimpleItemFactory(new SimpleItemFactory());
        orderService.initializeService();

        if (args.length > 0 && args[0].equals("GUI")) {
            OrderController orderController = new OrderController(orderService);
            orderController.initializeController();
        } else {
            CLI cli = new CLI(orderService);
            cli.menuLoop();
        }
    }
}