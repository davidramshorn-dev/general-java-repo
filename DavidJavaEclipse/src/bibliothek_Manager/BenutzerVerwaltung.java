package bibliothek_Manager;
import java.util.Scanner;

public class BenutzerVerwaltung {
	static Bibliothek bibliothek=new Bibliothek();
	static Benutzer benutzer=null;
	public static void main(String[] args) {
		
		while (true) {
			begrueßung();
			System.out.println("Wählen sie eine dieser Aktionen! (sonst Abmeldung)");
			System.out.println("1 Medium ausleihen.");
			System.out.println("2 Medium zurückgeben.");
			System.out.println("3 Medium suchen.");
			System.out.println("4 Bibliothek ausgeben.");
			try (Scanner scan = new Scanner(System.in)) {
				switch(scan.nextLine()) {
				case "1": mediumAusleihen(); break;
				case "2": mediumZurückgeben(); break;
				case "3": mediumSuchen(); break;
				case "4": bibliothekAusgeben(); break;
				default: System.out.println("Sie sind abgemeldet!"); continue;
				}
			}
			
			
		}

	}
	private static void bibliothekAusgeben() {
		// TODO Auto-generated method stub
		
	}
	private static void mediumSuchen() {
		// TODO Auto-generated method stub
		
	}
	private static void mediumZurückgeben() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("id?");
			int id=scan.nextInt();
			bibliothek.gebeZurueck(benutzer, id);
		}
		
	}
	private static void mediumAusleihen() {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("id?");
			int id=scan.nextInt();
			bibliothek.verleihe(benutzer, id);
		}
		
	}
	private static void begrueßung() {
		while(benutzer==null) {
		System.out.println("Passwort? (noch kein Konto, dann ENTER)");
		try (Scanner scan = new Scanner(System.in)) {
			String password=scan.nextLine();
			benutzer=bibliothek.sucheNachBenutzer(password);	
			while(password==null) {
				kreiereNeuenBenutzer();
				System.out.println("Passwort? (noch kein Konto, dann ENTER)");
				password=scan.nextLine();
				benutzer=bibliothek.sucheNachBenutzer(password);	
			}
		}
		}
		System.out.println("Wilkommen "+benutzer.getName());
		
	}
	private static void kreiereNeuenBenutzer() {
		System.out.println("Name?");
		try (Scanner scan = new Scanner(System.in)) {
			String name=scan.nextLine();
			System.out.println("Passwort?");
			String password=scan.nextLine();
			Benutzer benutzer=new Benutzer(name);
			bibliothek.fuegeBenutzerHinzu(password, benutzer);
		}
		System.out.println("Benutzer wurde hinzugefügt.");
		
		
	}

}
