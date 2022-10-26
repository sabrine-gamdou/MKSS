package model;

public class Service extends Item{

	private String name;
	private int hours, persons;
	private final int HOURLY_WAGE = 1242;

	//Rename variables to more specific meaningful names
	public Service(String name, int hours, int persons) {
		super(name, 1242 * hours * persons);
		this.name = name;
		this.hours = hours;
		this.persons = persons;
	}
}
