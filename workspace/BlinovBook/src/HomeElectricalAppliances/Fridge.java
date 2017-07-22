package HomeElectricalAppliances;

public class Fridge extends HomeElectricalAppliances {


	private int numberOfShelves;
	
	
	public int getNumberOfShelves() {
		return numberOfShelves;
	}



	public void setNumberOfShelves(int numberOfShelves) {
		this.numberOfShelves = numberOfShelves;
	}



	@Override
	public String turnOn() {
		
		return "Холодильник включен в розетку";
	}

}
