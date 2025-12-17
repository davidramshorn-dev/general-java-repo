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
	this.name=name;
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
public void verleihe(Benutzer benutzer, int id) throws MediumNichtGefundenException {
	Medium medium=findeId(id);
	ArrayList<Medium>liste= benutzer.getAusgeliehen();
	liste.add(medium);
	benutzer.setAusgeliehen(liste);
	medien.remove(medium);
}
private Medium findeId(int id) throws MediumNichtGefundenException {
    for (Medium e : medien) {
        if (id == e.getId()) {
            return e;
        }
    }
    throw new MediumNichtGefundenException(id);
}

public void gebeZurueck(Benutzer benutzer, int id) throws MediumNichtGefundenException {
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
public Benutzer sucheNachBenutzer(String password, String name2) {
	if(benutzerListe!=null) {if(benutzerListe.get(password).getName().equals(name2)) {	return benutzerListe.get(password);}}
	return null;
}

public HashMap<String, Benutzer> getBenutzerListe() {
	return benutzerListe;
}
}
