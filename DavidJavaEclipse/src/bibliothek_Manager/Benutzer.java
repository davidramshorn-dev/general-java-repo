package bibliothek_Manager;

import java.util.ArrayList;

public class Benutzer {
private String name;
private ArrayList<Medium> ausgeliehen;
public Benutzer(String name) {
	super();
	this.name = name;
	ausgeliehen=new ArrayList<Medium>();
}
public ArrayList<Medium> getAusgeliehen(){
	return ausgeliehen;
	
}
public void setAusgeliehen(ArrayList<Medium> ausgeliehen){
	this.ausgeliehen=ausgeliehen;
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
private Medium findeId(int id) {
	Medium medium=null;
	for (Medium e : ausgeliehen) {
	    if (id==e.getId()) {
	        medium = e;
	    }
	}
	if(medium==null) {
		System.out.println("Die ID ist nicht im System registriert.");
	}
	return medium;	
}


}
