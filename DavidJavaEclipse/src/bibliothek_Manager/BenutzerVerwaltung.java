package bibliothek_Manager;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("resource")
public class BenutzerVerwaltung {
	static Bibliothek bibliothek=new Bibliothek();
	static Benutzer benutzer=null;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			if(benutzer==null) {
			begrueßung(scan);}
			System.out.println("Wählen sie eine dieser Aktionen! (sonst Abmeldung)");
			System.out.println("1 Medium ausleihen.");
			System.out.println("2 Medium zurückgeben.");
			System.out.println("3 Medium suchen.");
			System.out.println("4 Bibliothek ausgeben.");
			System.out.println("5 Bibliothek erweitern.");
			
			String response=scan.nextLine();

				switch(response) {
				case "1": mediumAusleihen(scan); break;
				case "2": mediumZurückgeben(scan); break;
				case "3": mediumSuchen(); break;
				case "4": bibliothekAusgeben(); break;
				case "5": bibliothekErweitern(scan); break;
				default: System.out.println("Sie sind abgemeldet!"); continue;
			}
			
			
		}

	}
	private static void bibliothekErweitern(Scanner scan) {
		System.out.println("1 Buch");
		System.out.println("2 Film");
		System.out.println("3 Magazin");
		int response=scan.nextInt();
		scan.nextLine();
		switch(response) {
		case 1: buchHinzufügen(scan);break;
		case 2: filmHinzufügen(scan);break;
		case 3: magazinHinzufügen(scan);break;
		}
		
	}
	private static void magazinHinzufügen(Scanner scan) {
		System.out.println("Titel?");
		String titel=scan.nextLine();
		System.out.println("Jahr?");
		int jahr=scan.nextInt();
		scan.nextLine();
		System.out.println("Ausgabe?");
		String ausgabe=scan.nextLine();
		Magazin magazin=new Magazin(titel, jahr, ausgabe);
		bibliothek.fuegeMediumHinzu(magazin);
		
	}
	private static void filmHinzufügen(Scanner scan) {
		System.out.println("Titel?");
		String titel=scan.nextLine();
		System.out.println("Jahr?");
		int jahr=scan.nextInt();
		scan.nextLine();
		System.out.println("Regisseur?");
		String regisseur=scan.nextLine();
		System.out.println("Dauer?");
		int dauer=scan.nextInt();
		scan.nextLine();
		Film film=new Film(titel,jahr, regisseur,dauer);
		bibliothek.fuegeMediumHinzu(film);
		
	}
	private static void buchHinzufügen(Scanner scan) {
		System.out.println("Titel?");
		String titel=scan.nextLine();
		System.out.println("Jahr?");
		int jahr=scan.nextInt();
		scan.nextLine();
		System.out.println("Autor?");
		String autor=scan.nextLine();
		System.out.println("Seiten?");
		int seiten=scan.nextInt();
		scan.nextLine();
		Buch buch=new Buch(titel, jahr, autor, seiten);
		bibliothek.fuegeMediumHinzu(buch);
		
	}
	private static void bibliothekAusgeben() {
		ArrayList<Medium>medien=bibliothek.getMedien();
		for(Medium m: medien) {
			System.out.print("Id: "+m.getId());
			m.zeigeInfo();
		}
		
	}
	private static void mediumSuchen() {
		// TODO Auto-generated method stub
		
	}
	private static void mediumZurückgeben(Scanner scan) {
			System.out.println("id?");
			int id=scan.nextInt();
			bibliothek.gebeZurueck(benutzer, id);
		
	}
	private static void mediumAusleihen(Scanner scan) {
			System.out.println("id?");
			int id=scan.nextInt();
			scan.nextLine();
			bibliothek.verleihe(benutzer, id);
		
	}
	
	private static void begrueßung(Scanner scan) {
		while(benutzer==null) {
		System.out.println("Passwort? (noch kein Konto, dann ENTER)");
			String password=scan.nextLine();
			benutzer=bibliothek.sucheNachBenutzer(password);	
			while(password.equals("")) {
				System.out.println("Erstellen Sie ein neues Konto.");
				kreiereNeuenBenutzer();
				System.out.println("Passwort? (noch kein Konto, dann ENTER)");
				password=scan.nextLine();
				benutzer=bibliothek.sucheNachBenutzer(password);	
			}
		}
		System.out.println("Wilkommen "+benutzer.getName());
		
	}
	private static void kreiereNeuenBenutzer() {
		System.out.println("Name?");
		Scanner scan = new Scanner(System.in);
			String name=scan.nextLine();
			System.out.println("Passwort?");
			String password=scan.nextLine();
			Benutzer benutzer=new Benutzer(name);
			bibliothek.fuegeBenutzerHinzu(password, benutzer);
		System.out.println("Benutzer wurde hinzugefügt.");
		
		
	}

}
