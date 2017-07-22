package HomeElectricalAppliances;

public class Stove extends HomeElectricalAppliances{
	
	


	private int numberOfBurners;
	
	
	
	
public int getNumberOfBurners() {
		return numberOfBurners;
	}



	public void setNumberOfBurners(int numberOfBurners) {
		this.numberOfBurners = numberOfBurners;
	}



public String turnOn() {
		
		return "Плита включена в розетку";
	}

}
