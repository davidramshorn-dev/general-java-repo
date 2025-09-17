package tutorialVideoÜbungen4;

public record GeschenkRec<T extends Spielzeug, U extends Spielzeug> (T spielzeug1, U spielzeug2) {
public void abwägen() {
	if (spielzeug1.beliebtheit<spielzeug2.beliebtheit) {
		System.out.println("Das ist ein besseres Geschenk: "+spielzeug2.getNameI());
	}
	else {
		System.out.println("Das ist ein besseres Geschenk: "+spielzeug1.getNameI());
	}
}
}
