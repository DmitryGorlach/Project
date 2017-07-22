package HomeElectricalAppliances;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("�����������");
		Fridge fr = new Fridge();

		fr.setAmp(3);
		fr.powerConsumption();
		fr.setNumberOfShelves(6);
		fr.turnOn();
		
		System.out.println("���� ���� = " + fr.getAmp() + " �����");
		System.out.println(fr.getVolt());
		System.out.println("������������ �������� =  " + fr.powerConsumption());
		System.out.println("���������� ����� = " + fr.getNumberOfShelves());
		System.out.println(fr.turnOn());
		
		System.out.println("\n�����");
		Stove st = new Stove();
			
		st.setAmp(4);
		st.powerConsumption();
		st.setNumberOfBurners(4);
		
		System.out.println("���� ���� = " + st.getAmp() + " �����");
		System.out.println(st.getVolt());
		System.out.println("������������ �������� =  " + st.powerConsumption());
		System.out.println("���������� �������� = " + st.getNumberOfBurners());
		
		System.out.println("\n���������");
		TV tv = new TV();
		
		tv.setAmp(1);
		tv.powerConsumption();
		tv.setDiagonal(90);;
		tv.turnOn();
		
		System.out.println("���� ���� = " + tv.getAmp() + " �����");
		System.out.println(tv.getVolt());
		System.out.println("������������ �������� =  " + tv.powerConsumption());
		System.out.println("��������� = " + tv.getDiagonal() + " ������");
		System.out.println(tv.turnOn());
		
		System.out.println("\n���������� ������");
		Washer ws = new Washer();
		
		ws.setAmp(2);
		ws.powerConsumption();
		ws.setNumberOfButtons(8);;
		
		System.out.println("���� ���� = " + ws.getAmp() + " �����");
		System.out.println(ws.getVolt());
		System.out.println("������������ �������� =  " + ws.powerConsumption());
		System.out.println("���������� ������ = " + ws.getNumberOfButtons());
		
		int [] mas = {fr.powerConsumption(), st.powerConsumption(), tv.powerConsumption(), ws.powerConsumption()};
		
		String [] HomeElectricalAppliances = {};
		
		
	
		System.out.print("\n" + Arrays.toString(mas));

	
		
		int index = 0;
		int min = 0;
		
		for (int i = 0; i < mas.length; i ++) {
			min = mas[i];
			index = i;
			for(int j = i + 1; j < mas.length; j++ ) {
				if (mas[j] < min) {
					index = j;
					min =mas[j];
				}
			}
			if(mas[i] != mas[index]) {
				mas[index] = mas[i];
				mas[i] = min;
			}
			
			System.out.print("\n" +mas[i]);
		}
		
		
	}

}
