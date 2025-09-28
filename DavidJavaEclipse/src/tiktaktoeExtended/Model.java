package tiktaktoeExtended;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Model {
	public Spieler SpielerAmZug;
	public HashMap<String, Spielfeld> spielfelder;
//	public int limX;
	public Spieler[] mitspieler= new Spieler[] {new Spieler("D", "David", false, 1000000 , 0), new Spieler("A", "Aniko", false,4000, 0)};
	public LinkedList<Spieler> spielerArray = new LinkedList<>(Arrays.asList(mitspieler));
//	public int limY;
//	public int pruefLaenge;
//	public int spielfeldNummer=1;
	public Spielfeld spielfeld;
	public Model() {
        spielfelder = new HashMap<>();
    }
	public Spieler getSpielerAmZug() {
		return SpielerAmZug;
	}
	public HashMap<String, Spielfeld> getSpielfelder() {
		return spielfelder;
	}
	public Spieler[] getMitspieler() {
		return mitspieler;
	}
	public LinkedList<Spieler> getSpielerArray() {
		return spielerArray;
	}
	public void setSpielerAmZug(Spieler spielerAmZug) {
		SpielerAmZug = spielerAmZug;
	}
	public void setSpielfelder(HashMap<String, Spielfeld> spielfelder) {
		this.spielfelder = spielfelder;
	}
	public void setMitspieler(Spieler[] mitspieler) {
		this.mitspieler = mitspieler;
	}
	public void setSpielerArray(LinkedList<Spieler> spielerArray) {
		this.spielerArray = spielerArray;
	}
	public void setSpielfeld(Spielfeld spielfeld) {
		this.spielfeld = spielfeld;
	}
	public Spielfeld getSpielfeld() {
		return spielfeld;
	}
}    
