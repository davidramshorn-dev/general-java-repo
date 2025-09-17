package geschenkMama;

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
}    
