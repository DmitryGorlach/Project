package by.bsu.inheritance;

public class ProgrammerBook extends Book{
	private String language;
	
	public ProgrammerBook() {
		
	}
	
	public ProgrammerBook (String title, int price, String language) {
		super(title, price);
		this.language = language;
	}
	
	public String getInfo() {
		return super.getInfo() + ". язык: " + language;
	}
}
