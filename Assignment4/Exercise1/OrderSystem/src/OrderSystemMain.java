import controllers.OrderController;
import entities.factories.SimpleItemFactory;
import gateways.OrderRepository;
import uis.cli.CLI;
import usecases.OrderService;

public class OrderSystemMain {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        // Initialize the components in the OrderService
        orderService.setOrderDataAccess(new OrderRepository());
        orderService.setSimpleItemFactory(new SimpleItemFactory());
        orderService.initializeService();

        if (args.length > 0 && args[0].equals("GUI")) {
            OrderController orderController = new OrderController(orderService);
            orderController.initializeController();
            orderService.setOrderOutputBoundary(orderController);
        } else {
            CLI cli = new CLI(orderService);
            orderService.setOrderOutputBoundary(cli);
            cli.menuLoop();
        }
    }
}