package HomeElectricalAppliances;

public class TV extends HomeElectricalAppliances{
	
	

	private int diagonal;
	
		
public int getDiagonal() {
		return diagonal;
	}



	public void setDiagonal(int diagonal) {
		this.diagonal = diagonal;
	}



public String turnOn() {
		
		return "Телевизор включен в розетку";
	}

}
