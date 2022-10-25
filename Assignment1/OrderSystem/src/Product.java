
public class Product {

	private String name;
	private int unitPrice;
	private int quantity;

	public Product(String name, int unitPrice, int quantity) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return unitPrice * quantity;
	}

	//TODO not consistent with Service class where print is used as a method instead of toString?
	@Override
	public String toString() {
		return quantity + " * " + getName();
	}
}
