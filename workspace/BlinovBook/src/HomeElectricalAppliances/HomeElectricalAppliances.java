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
		
		return "���� ���������� ��������� ������� = " + VOLT + " �����";
		
	}

	public abstract String turnOn(); 
		
	public int powerConsumption () {
		
		watt = amp * VOLT;
		
		return watt;
		//return "������������ �������� = " + watt + " ����"; ��� String
		
		
	}

	
	@Override
	public String toString() {
		return "Person [���� ���������� ��������� ������� = " + VOLT + ", ���� ���� = " + amp + ", ������������ �������� = " + watt+ "]";
	}
	
	
}
