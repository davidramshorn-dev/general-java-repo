package tutorialVideoÜbungen3;

public class Fisch extends Tier{
String name;
	public Fisch(int alter, String name) {
		super(false, alter);
		this.name=name;
	}

	@Override
	public void fressen() {
		System.out.println("Mhhhhh");
		
	}
	public void getName() {
		System.out.println("Ich heiße: "+name);
		
	}

}
