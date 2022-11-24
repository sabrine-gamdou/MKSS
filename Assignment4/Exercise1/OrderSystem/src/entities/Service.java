package entities;

public class Service extends Item {

	private final int hours;
	private final int persons;
	private final int HOURLY_WAGE = 1242;

	//Rename variables to more specific meaningful names
	public Service(String name, int hours, int persons) {
		super(name, 1242 * hours * persons);
		this.hours = hours;
		this.persons = persons;
	}

	//For consistency reasons we deleted the print method and added a toString method instead for both model classes
	public String toString(){
		return persons + " persons for " + hours + "h of " + getName();
	}

	public int getHours() {
		return hours;
	}

	public int getPersons() {
		return persons;
	}
}
