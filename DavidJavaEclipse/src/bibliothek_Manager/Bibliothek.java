package bibliothek_Manager;

import java.util.ArrayList;
import java.util.HashMap;

public class Bibliothek {
	private int idCounter=0;
private ArrayList<Medium> medien;
private HashMap<String, Benutzer> benutzerListe;

public Bibliothek() {
	medien=new ArrayList<Medium>();
	benutzerListe=new HashMap<>();
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
	Medium medium=findeId(id);
	ArrayList<Medium>liste= benutzer.getAusgeliehen();
	liste.add(medium);
	benutzer.setAusgeliehen(liste);
	medien.remove(medium);
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
	else {
		System.out.println("Die ID ist registriert.");
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
	if(medium !=null) {
		Medium mediumBuecherei=findeId(id);
		ArrayList<Medium>liste= benutzer.getAusgeliehen();
		medien.add(mediumBuecherei);
		benutzer.setAusgeliehen(liste);
		benutzer.getAusgeliehen().remove(mediumBuecherei);
	}
	
}
public Benutzer sucheNachBenutzer(String password) {
	if(benutzerListe!=null) {	return benutzerListe.get(password);}
	return null;
}
}
