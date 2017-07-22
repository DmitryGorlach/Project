package by.bsu.inheritance;

class Doctor extends Man {
	static {
		System.out.println("static block in Doctor");
	}
	public static void stDoctor() {
		System.out.println("static method in Doctor.");
	}
}
