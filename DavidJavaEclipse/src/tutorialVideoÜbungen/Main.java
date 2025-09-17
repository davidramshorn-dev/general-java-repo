package tutorialVideoÜbungen;

public class Main {

	public static void main(String[] args) {
		Hund Schaeferhund = new Hund(6, "Gerri", "Schaeferhund", true);
		Hund Laprador = new Hund(3, "Gerald", "Laprador", false);
		Hund Mops = new Hund(12, "Guenther", "Mops", true);
		Hund[] hunde = {Schaeferhund, Laprador, Mops};
		System.out.println("Welche Hundearten gibt es?");
		for (int i = 0; i<hunde.length; i++) {
			System.out.println(hunde[i].art);
		}
		System.out.println("Wie viele Hunde können Pfoten geben?");
		int var=0;
		for (int i = 0; i<hunde.length; i++) {
			if (hunde[i].kannBellen) {var=var+1;}
		}
		System.out.println(var);

	}

}
