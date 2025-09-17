package hausaufgabenIT;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean isValid=true;
		while (isValid) {
		System.out.print("Geben Sie eine Postleitzahl ein: ");
		String plz = scanner.nextLine();
		System.out.print("Aus welchem Land kommt die Postleitzahl? (DE/FR/PL)");
		String land = scanner.nextLine();
		PostleitzahlVorgabe passwort = new PostleitzahlVorgabe(land, plz);
		if (passwort.isValidPLZ()) {
		System.out.println("Die PLZ ist gültig.");
		isValid=false;
		} else {
		System.out.println("Die PLZ ist ungültig.");
		isValid=true;
		}}
		scanner.close();}

}
