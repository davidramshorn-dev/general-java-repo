package tutorialVideoÜbungen;

import tutorialVideoÜbungen2.Auto;

public class Main_Fahrzeuge {

	public static void main(String[] args) {
Fahrzeuge auto=new Auto("Merzedes", 7);
Fahrzeuge fahrrad=new Fahrrad ("Maountain Bike", 0);
fahrrad.fahren();
fahrrad.fahrErlaubnis();
auto.fahren();
auto.fahrErlaubnis();
	}

}
