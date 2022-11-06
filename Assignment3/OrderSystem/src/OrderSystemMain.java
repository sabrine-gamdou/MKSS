import factories.SimpleItemFactory;
import logic.OrderService;
import ui.CLI;
import ui.UI;

public class OrderSystemMain {
	public static void main(String[] args) {
		/*UI userInterface;
		if(args[0].equals("GUI")){
			userInterface = new GUI();
		}else{
			userInterface = new CLI();
		}*/
		UI userInterface = new CLI();
		OrderService orderService = new OrderService(userInterface);
		SimpleItemFactory simpleItemFactory = new SimpleItemFactory();
		orderService.setSimpleItemFactory(simpleItemFactory);
		orderService.menuLoop();
	}
}
