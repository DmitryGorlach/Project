package HomeElectricalAppliances;

public abstract class HomeElectricalAppliances {
	
	private int watt;
	private int amp;
	private static final int VOLT = 220;
	
	
	
	public int getWatt() {
		return watt;
	}

	public void setWatt(int watt) {
		this.watt = watt;
	}

	public int getAmp() {
		return amp;
	}

	public void setAmp(int amp) {
		this.amp = amp;
	}

	public String getVolt() {
		
		return "Сила напряжения источника питания = " + VOLT + " вольт";
		
	}

	public abstract String turnOn(); 
		
	public int powerConsumption () {
		
		watt = amp * VOLT;
		
		return watt;
		//return "Потребляемая мощность = " + watt + " ватт"; тип String
		
		
	}

	
	@Override
	public String toString() {
		return "Person [Сила напряжения источника питания = " + VOLT + ", Сила тока = " + amp + ", Потребляемая мощность = " + watt+ "]";
	}
	
	
}
