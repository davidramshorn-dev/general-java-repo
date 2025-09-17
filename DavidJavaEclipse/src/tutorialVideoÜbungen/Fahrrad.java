package tutorialVideoÜbungen;

public class Fahrrad extends Fahrzeuge{

public String art;
public Fahrrad(String art, int umweltschädlichkeitsgrad) {
	super(umweltschädlichkeitsgrad);
	this.art=art;
}
}
