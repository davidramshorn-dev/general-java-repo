package tutorialVideoÜbungen;

import java.util.Scanner;

public class Notendurchschnitt {

	public static void main(String[] args) {
		int zaehler=0;
		int gesampt =0;
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.println("Geben Sie ihre Note ein: ");
		String snote = scanner.nextLine();
		zaehler++;
		int inote=0;
		switch(snote) {
		case "1": 
			inote= 1;
			break;
		case "2": 
			inote= 2;
			break;
		case "3": 
			inote= 3;
			break;
		case "4": 
			inote= 4;
			break;
		case "5": 
			inote= 5;
			break;
		case "6": 
			inote= 6;
			break;
		default: 
			continue;
		}
		gesampt= gesampt+inote;
		System.out.println("Dein Durchschnitt ist: " + (double) gesampt/zaehler);
		System.out.println("Wollen Sie aufhören? (j/sonstige)");
		if (scanner.nextLine().equals("j")) {break;}
		}
		scanner.close();}

}
