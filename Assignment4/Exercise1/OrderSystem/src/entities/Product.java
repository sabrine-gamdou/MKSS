package entities;

public class Product extends Item {

	private final int unitPrice;
	private final int quantity;

	public Product(String name, int unitPrice, int quantity) {
		super(name, unitPrice * quantity);
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String toString() {
		return quantity + " * " + getName();
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}
}
