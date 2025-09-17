package tutorialVideoÜbungen;

public class Fahrzeuge {
	public int umweltschädlichkeitsgrad;
public Fahrzeuge(int umweltschädlichkeitsgrad) {
	this.umweltschädlichkeitsgrad=umweltschädlichkeitsgrad;
}
public void fahren() {
	System.out.println("Brumm...Brumm...Brumm...");
}
public void fahrErlaubnis() {
	if (umweltschädlichkeitsgrad<6) {
	System.out.println("TÜV bestanden.");}
	else {System.out.println("TÜV nicht bestanden.");}
}
}
