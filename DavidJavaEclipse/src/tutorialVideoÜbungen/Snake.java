package tutorialVideoÜbungen;

import java.awt.Point;
import java.util.Random;
import java.util.Scanner;

public class Snake {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		boolean spiel= true;
		while(spiel) {
		int[] xcoordinate = new int[4];
		int[] ycoordinate = new int[4];
		for (int i=0; i<4; i++) {
		Random x= new Random();
		int zahlx = x.nextInt(39);
		int zahly = x.nextInt(9);
		xcoordinate[i] = zahlx;
		ycoordinate[i] = zahly;}
		Point spielerPosition= new Point(xcoordinate[0], ycoordinate[0]);
		Point tuerPosition= new Point(xcoordinate[1], ycoordinate[1]);
		Point schlangePosition= new Point(xcoordinate[2], ycoordinate[2]);
		Point goldPosition= new Point(xcoordinate[3], ycoordinate[3]);
		boolean goldBesitz = false;
		updateInterface(spielerPosition, schlangePosition, tuerPosition, goldPosition);
		boolean runde=true;
		while (runde) {
		bewegen(spielerPosition, scanner);
		bewegeSchlange(spielerPosition, schlangePosition);
		updateInterface(spielerPosition, schlangePosition, tuerPosition, goldPosition);
		if (spielerPosition.equals(schlangePosition)) {
			System.out.println("Sie haben verloren!!! Wollen Sie nochmal spielen? (ja oder sonstige)");
			spiel = wiederholung(scanner);
			runde = false;
		}
		else if (spielerPosition.equals(goldPosition)) {
			goldBesitz= true;
		}
		else if (spielerPosition.equals(tuerPosition) && goldBesitz) {
			System.out.println("Sie haben gewonnen!!! (; Wollen Sie nochmal spielen? (ja oder sonstige)");
			spiel = wiederholung(scanner);
			runde = false;
		}}

	}}

	private static boolean wiederholung(Scanner scanner) {
	    String input = scanner.next();
	    boolean weiter=false;
	    if (input.equals("ja")) {weiter=true;
	    System.out.println("Viel Spaß.");}
	    else {System.out.println("Das Spiel wurde erfolgreich heruntergefahren.");}
	    return weiter;
	}

	private static void bewegeSchlange(Point spielerPosition, Point schlangePosition) {
		if (spielerPosition.x>schlangePosition.x) {schlangePosition.x++;}
		else if (spielerPosition.x<schlangePosition.x) {schlangePosition.x--;}
		if (spielerPosition.y>schlangePosition.y) {schlangePosition.y++;}
		else if (spielerPosition.y<schlangePosition.y) {schlangePosition.y--;}
		
	}

	private static void updateInterface(Point spielerPosition, Point schlangePosition, Point tuerPosition,
			Point goldPosition) {
		for(int y = 0; y<10; y++) {
			for (int x=0; x<40; x++) {
				Point p= new Point(x, y);
				if (p.equals(goldPosition)) {
					System.out.print("G");
				}
				else if (p.equals(schlangePosition)) {
					System.out.print("S");
				}
				else if (p.equals(tuerPosition)) {
					System.out.print("T");
				}
				else if (p.equals(spielerPosition)) {
					System.out.print("P");
				}
				System.out.print(".");
			}System.out.println();}
		
	}

	private static void bewegen(Point spielerPosition, Scanner scanner) {
		String input = scanner.next();
		if (input.equals("a") && spielerPosition.x>0) {spielerPosition.x--;}
		else if (input.equals("w")  && spielerPosition.y>0) {spielerPosition.y--;}
		else if (input.equals("s")  && spielerPosition.y<9) {spielerPosition.y++;}
		else if (input.equals("d")  && spielerPosition.x<39) {spielerPosition.x++;}
		else if (input.equals("w")  && spielerPosition.y<=0) {System.out.println("Bitte geben Sie a, s oder d ein!");}
		else if (input.equals("a")  && spielerPosition.x<=0) {System.out.println("Bitte geben Sie w, s oder d ein!");}
		else if (input.equals("s")  && spielerPosition.y>=9) {System.out.println("Bitte geben Sie a, w oder d ein!");}
		else if (input.equals("d")  && spielerPosition.x>=39) {System.out.println("Bitte geben Sie a, s oder w ein!");}
		else {System.out.println("Bitte geben Sie w, a, s oder d ein!");}
	}
	

}
