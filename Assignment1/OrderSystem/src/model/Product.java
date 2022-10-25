package model;

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

	//Removed override as it is redundant
	public String toString() {
		return quantity + " * " + getName();
	}
}
