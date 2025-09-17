package tutorialVideoÜbungen2;

public class Dackel implements HundInterface{
	boolean kannPfoteGeben;
public Dackel(boolean kannPfoteGeben) {
	this.kannPfoteGeben=kannPfoteGeben;
}
public void bellen() {
	System.out.println("Wuff Wuff Wuff");
}
public void pfoteGeben() {
	if(kannPfoteGeben) {
		System.out.println("Hier die Pfote");
	}
}
}
