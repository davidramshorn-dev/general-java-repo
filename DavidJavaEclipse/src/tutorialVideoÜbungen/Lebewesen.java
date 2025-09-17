package tutorialVideoÜbungen;

public class Lebewesen {
public String name;
public int alter;
public int groeße;
public Lebewesen(String name, int alter, int groeße) {
	this.name=name;
	this.alter=alter;
	this.groeße=groeße;
}
public void groeßeAusgabe() {
	System.out.println("Groeße: " +groeße);
}
public void insAlt() {
	if (alter>10) {
	System.out.println("Ist alt.");}
	else {
		System.out.println("Ist jung.");
	}
}
}
