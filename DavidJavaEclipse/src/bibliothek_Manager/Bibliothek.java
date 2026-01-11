package bibliothek_Manager;

import java.util.ArrayList;
import java.util.HashMap;

public class Bibliothek {
	private int idCounter=0;
private ArrayList<Medium> medien;
private HashMap<String, Benutzer> benutzerListe;
private String name;

public Bibliothek(String name) {
	medien=new ArrayList<Medium>();
	benutzerListe=new HashMap<>();
	
	setup();
	
	this.name=name;
}

private void setup() {
	fuegeBenutzerHinzu("??????", new Benutzer("Operator"));
	
	Medium[] lager = {
		    new Buch("Der Prozess", 1925, "Franz Kafka", 256),
		    new Film("Metropolis", 1927, "Fritz Lang", 153),
		    new Magazin("Der Spiegel", 2024, "12/2024"),

		    new Buch("Faust I", 1808, "Johann Wolfgang von Goethe", 304),
		    new Film("Nosferatu", 1922, "F. W. Murnau", 94),
		    new Magazin("National Geographic", 2023, "August"),

		    new Buch("1984", 1949, "George Orwell", 328),
		    new Film("Blade Runner", 1982, "Ridley Scott", 117),
		    new Magazin("Time", 2022, "42"),

		    new Buch("Der Hobbit", 1937, "J. R. R. Tolkien", 384),
		    new Film("Inception", 2010, "Christopher Nolan", 148),
		    new Magazin("Geo", 2021, "Mai"),

		    new Buch("Clean Code", 2008, "Robert C. Martin", 464),
		    new Film("Interstellar", 2014, "Christopher Nolan", 169),
		    new Magazin("c't", 2023, "18"),

		    new Buch("Java ist auch eine Insel", 2021, "Christian Ullenboom", 1420),
		    new Film("Matrix", 1999, "Lana Wachowski", 136)
		};
	for (int i=0; i<lager.length; i++) {
		fuegeMediumHinzu(lager[i]);
	}

}

public String getName() {
	return name;
}

public ArrayList<Medium> getMedien(){
	return medien;
}

public void fuegeMediumHinzu(Medium medium) {
	medien.add(medium);
	medium.setId(idCounter);
	idCounter++;
	
}
public void fuegeBenutzerHinzu(String passwort, Benutzer benutzer) {
	benutzerListe.put(passwort, benutzer);
}
public Medium sucheMedium(String titel) {
	Medium medium=null;
	for (Medium e : medien) {
	    if (titel.equals(e.getTitel())) {
	        medium = e;
	    }
	}
	return medium;	
}
public Medium sucheMedium(int erscheinungsjahr) {
	Medium medium=null;
	for (Medium e : medien) {
	    if (erscheinungsjahr==e.getJahr()) {
	        medium = e;
	    }
	}
	return medium;	
}
public void verleihe(Benutzer benutzer, int id) {
	Medium medium;
	try {
		medium = findeId(id);
		ArrayList<Medium>liste= benutzer.getAusgeliehen();
		liste.add(medium);
		benutzer.setAusgeliehen(liste);
		medien.remove(medium);
	} catch (MediumNichtGefundenException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
}
private Medium findeId(int id) throws MediumNichtGefundenException{
    for (Medium e : medien) {
        if (id == e.getId()) {
            return e;
        }
    }
    throw new MediumNichtGefundenException(id);
}

public void gebeZurueck(Benutzer benutzer, int id) {
		Medium mediumBuecherei;
		try {
			mediumBuecherei = findeId(id);
			ArrayList<Medium>liste= benutzer.getAusgeliehen();
			medien.add(mediumBuecherei);
			benutzer.getAusgeliehen().remove(mediumBuecherei);
		} catch (MediumNichtGefundenException e2) {
			// TODO Auto-generated catch block
			System.out.println(e2.getMessage());
		}
	}
	

public Benutzer sucheNachBenutzer(String password, String name2) throws BenutzerNichtGefunden{
	try {
	if(benutzerListe.get(password).getName().equals(name2)) {	return benutzerListe.get(password);}}
	catch(NullPointerException e) {
		throw new BenutzerNichtGefunden(name2);
	}
	return null;
}

public HashMap<String, Benutzer> getBenutzerListe() {
	return benutzerListe;
}
}
