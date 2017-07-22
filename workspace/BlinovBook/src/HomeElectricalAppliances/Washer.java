package HomeElectricalAppliances;

public class Washer extends HomeElectricalAppliances{
	
	

	private int numberOfButtons;
	
	
	
public int getNumberOfButtons() {
		return numberOfButtons;
	}



	public void setNumberOfButtons(int numberOfButtons) {
		this.numberOfButtons = numberOfButtons;
	}



public String turnOn() {
		
		return "Стиральная машина включена в розетку";
	}

}
