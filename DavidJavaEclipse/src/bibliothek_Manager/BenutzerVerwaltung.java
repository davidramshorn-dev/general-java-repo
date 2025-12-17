package bibliothek_Manager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("resource")
public class BenutzerVerwaltung {
	static Bibliothek bibliothek=new Bibliothek("Bibliothek von Babel");
	static Benutzer benutzer=null;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Willkommen in der " +bibliothek.getName());
		
		while (bibliothek!=null) {
			if(benutzer==null) {
			begrueßung(scan);}
			System.out.println("Wählen sie eine dieser Aktionen! (sonst Abmeldung)");
			System.out.println("1 Medium ausleihen.");
			System.out.println("2 Medium zurückgeben.");
			System.out.println("3 Medium suchen.");
			System.out.println("4 Bibliothek ausgeben.");
			System.out.println("5 Bibliothek erweitern.");
			System.out.println("6 Bibliothek verlassen.");
			System.out.println("7 Benutzer anzeigen.");
			
			String response=scan.nextLine();
			try {
				switch(response) {
				case "1": mediumAusleihen(scan); break;
				case "2": mediumZurückgeben(scan); break;
				case "3": mediumSuchen(scan); break;
				case "4": bibliothekAusgeben(); break;
				case "5": bibliothekErweitern(scan); break;
				case "6": System.out.println("Sie haben die Bibliothek verlassen!"); bibliothek=null; break;
				case "7": benutzerAnzeigen(); break;
				default: System.out.println("Sie sind abgemeldet!"); benutzer=null;
			}
			}
			catch(NumberFormatException h) {
				 System.out.println("Fehlerhafte Eingabe!");
			}
			catch(MediumNichtGefundenException e) {
				System.out.println("Medium nicht gefunden!");
			}
			
			
			
		}

	}
	private static void benutzerAnzeigen() {
		// TODO Auto-generated method stub
		HashMap<String, Benutzer> benutzerListe= bibliothek.getBenutzerListe();
		benutzerListe.values().forEach(e->{System.out.println(e.getName());});
		
	}
	private static void bibliothekErweitern(Scanner scan) {
		System.out.println("1 Buch");
		System.out.println("2 Film");
		System.out.println("3 Magazin");
		int response=Integer.parseInt(scan.nextLine());
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
		int jahr=Integer.parseInt(scan.nextLine());
		System.out.println("Ausgabe?");
		String ausgabe=scan.nextLine();
		Magazin magazin=new Magazin(titel, jahr, ausgabe);
		bibliothek.fuegeMediumHinzu(magazin);
		
	}
	private static void filmHinzufügen(Scanner scan) {
		System.out.println("Titel?");
		String titel=scan.nextLine();
		System.out.println("Jahr?");
		int jahr=Integer.parseInt(scan.nextLine());
		System.out.println("Regisseur?");
		String regisseur=scan.nextLine();
		System.out.println("Dauer?");
		int dauer=Integer.parseInt(scan.nextLine());
		Film film=new Film(titel,jahr, regisseur,dauer);
		bibliothek.fuegeMediumHinzu(film);
		
	}
	private static void buchHinzufügen(Scanner scan) {
		System.out.println("Titel?");
		String titel=scan.nextLine();
		System.out.println("Jahr?");
		int jahr=Integer.parseInt(scan.nextLine());
		System.out.println("Autor?");
		String autor=scan.nextLine();
		System.out.println("Seiten?");
		int seiten=Integer.parseInt(scan.nextLine());
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
	private static void mediumSuchen(Scanner scan) {
		Medium medium=null;
		String response=scan.nextLine();
		int converted=Integer.parseInt(response);
		if(Integer.toString(converted).equals(response)) {
		medium =bibliothek.sucheMedium(converted);}
		else {
			medium =bibliothek.sucheMedium(response);
		}
		if(medium!=null) {
		medium.zeigeInfo();}
	}
	private static void mediumZurückgeben(Scanner scan) throws MediumNichtGefundenException {
			System.out.println("id?");
			int id=scan.nextInt();
			bibliothek.gebeZurueck(benutzer, id);
		
	}
	private static void mediumAusleihen(Scanner scan) throws MediumNichtGefundenException {
			System.out.println("id?");
			int id=scan.nextInt();
			scan.nextLine();
			bibliothek.verleihe(benutzer, id);
		
	}
	
	private static void begrueßung(Scanner scan) {
		String password=null;
		while(benutzer==null) {
			System.out.println("Name? (noch kein Konto, dann ENTER)");
			String name=scan.nextLine();
			while(name.equals("")) {
				System.out.println("Erstellen Sie ein neues Konto.");
				kreiereNeuenBenutzer();
				System.out.println("Name? (noch kein Konto, dann ENTER)");
				name=scan.nextLine();
			}
				System.out.println("Passwort?");
				password=scan.nextLine();
				benutzer=bibliothek.sucheNachBenutzer(password, name);
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
