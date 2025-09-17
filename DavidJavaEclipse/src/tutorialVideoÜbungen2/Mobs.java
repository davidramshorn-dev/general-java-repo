package tutorialVideoÜbungen2;

public class Mobs implements HundInterface{
	int alter;
	public Mobs(int alter) {
		this.alter=alter;
	}
	public void bellen() {
		if (alter>3) {
		System.out.println("Grrrr Grrrr Grrrr");}
	}
	public void pfoteGeben() {
			System.out.println("Ich zeige meine Pfote");
	}
}
