package model;

public class Service {

	private String name;
	private int hours, persons;
	private final int HOURLY_WAGE = 1242;

	//Rename variables to more specific meaningful names
	public Service(String name, int hours, int persons) {
		this.name = name;
		this.hours = hours;
		this.persons = persons;
	}

	public String getName() {
		return name;
	}

	//Use of a hardcoded number - bad practice
	public int getPrice() {
		return HOURLY_WAGE * hours * persons;
	}

	//For consistency reasons we deleted the print method and added a toString method instead for both model classes
	public String toString(){
		return persons + " persons for " + hours + "h of " + getName();
	}
}
