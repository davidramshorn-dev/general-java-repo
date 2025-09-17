package tutorialVideoÜbungen;

public class Spieler {
public String name;
public String gamertag;
public boolean gewonnen;
public Spieler(String name, String gamertag) {
	this.name=name;
	this.gamertag=gamertag;
}
public Spieler(boolean gewonnen) {
	this.gewonnen=gewonnen;
}
}
