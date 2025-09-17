package tutorialVideoÜbungen2;

import tutorialVideoÜbungen.Fahrzeuge;

public class Auto extends Fahrzeuge{
public String marke;
public Auto(String marke, int umweltschädlichkeitsgrad) {
	super(umweltschädlichkeitsgrad);
	this.marke=marke;
}
public void fahren() {
	System.out.print("Tach... Tach... Tach... ");
}
}
