package tutorialVideoÜbungen;

import java.util.Scanner;

public class Creator {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		String[] lieblingssongs= {"La Mudanza","NuevaYol", "Innocente"};
		Mensch David= new Mensch();
		Mensch Paul= new Mensch();
David.construktor(180, "David", lieblingssongs);
Paul.construktor(400, "Paul");
System.out.println("Hallo: "+ David.getName()+" und "+ Paul.getName());
System.out.println("Lasst uns ein Spiel spielen. Wer denkt ihr ist größer?");
String var = scanner.nextLine();

if(var.equals("Paul") && Paul.getGroeße()>David.getGroeße()) {
	System.out.println("Du hast richtig geraten! Glückwunsch!!! Paul ist " + (Paul.getGroeße() - David.getGroeße()) + " cm größer als David!");
}
else if(var.equals("David") && Paul.getGroeße()<David.getGroeße()) {
	System.out.println("Du hast richtig geraten! Glückwunsch!!! David ist " + (David.getGroeße() - Paul.getGroeße()) + " cm größer als Paul!");
}
else {
	System.out.println("Du hast falsch geraten! Schade ):");
}
scanner.close();	}

}
