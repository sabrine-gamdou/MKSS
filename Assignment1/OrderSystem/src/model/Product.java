package model;

public class Product extends Item{

	private String name;
	private int unitPrice;
	private int quantity;

	public Product(String name, int unitPrice, int quantity) {
		super(name, unitPrice * quantity);
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
}
