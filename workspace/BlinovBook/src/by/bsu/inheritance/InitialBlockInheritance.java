package by.bsu.inheritance;

public class InitialBlockInheritance {

	public static void main(String[] args) {
		Doctor.stMan();
		System.out.println("Run.");
		Doctor doctor = new Doctor();
		System.out.println(doctor.form);
		Doctor.stDoctor();

	}

}
