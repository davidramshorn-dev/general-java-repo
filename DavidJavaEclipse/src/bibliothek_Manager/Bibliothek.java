package Bibliothek_Manager2_0;

import java.util.ArrayList;
import java.util.HashMap;

public class Bibliothek {
	private int idCounter=0;
private ArrayList<Medium> medien;
private HashMap<String, Benutzer> benutzerListe;

public Bibliothek() {
	ArrayList<Medium> medien=new ArrayList<Medium>();
	HashMap<String, Benutzer> benutzerListe=new HashMap<String, Benutzer>();
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
	ArrayList<Medium>liste= benutzer.getAusgeliehen();
	liste.add(findeId(id));
	benutzer.setAusgeliehen(liste);
	medien.remove(findeId(id));
}
private Medium findeId(int id) {
	Medium medium=null;
	for (Medium e : medien) {
	    if (id==e.getId()) {
	        medium = e;
	    }
	}
	if(medium==null) {
		System.out.println("Die ID ist nicht im System registriert.");
	}
	return medium;	
}
public void gebeZurueck(Benutzer benutzer, int id) {
	Medium medium=null;
	for (Medium e : benutzer.getAusgeliehen()) {
	    if (id==e.getId()) {
	        medium = e;
	    }
	}
	if(medium==null) {
		System.out.println("Die ID ist nicht im System registriert.");
	}
	else {
		ArrayList<Medium>liste= benutzer.getAusgeliehen();
		medien.add(findeId(id));
		benutzer.setAusgeliehen(liste);
		benutzer.getAusgeliehen().remove(findeId(id));
	}
	
}
public Benutzer sucheNachBenutzer(String password) {
	if(benutzerListe!=null) {	return benutzerListe.get(password);}
	return null;
}
}
