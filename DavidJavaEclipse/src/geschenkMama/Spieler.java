package geschenkMama;

public class Spieler {
public String name;
public String spielertag;
public boolean gewonnen;
public int tier;
public int gewinncounter;
public Spieler (String spielertag, String name, boolean gewonnen, int tier , int gewinncounter) {
	this.spielertag=spielertag;
	this.name=name;
	this.gewonnen=gewonnen;
	this.tier=tier;
	this.gewinncounter=gewinncounter;
}
public Spieler () {
	this.spielertag="default";
	this.name="default";
	this.gewonnen=false;
	this.tier=0;
	this.gewinncounter=0;
}
public void gewonnen (boolean gewonnen) {
	this.gewonnen=gewonnen;
}
}         
