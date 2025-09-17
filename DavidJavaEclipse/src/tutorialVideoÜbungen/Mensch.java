package tutorialVideoÜbungen;

public class Mensch {
private int groeße;
private String name;
private String[] lieblingssongs;
private int lieblingszahl;

public void construktor(int groeße, String name, String[] lieblingssongs, int lieblingszahl) {
	this.groeße=groeße;
	this.name=name;
	this.lieblingssongs=lieblingssongs;
	this.lieblingszahl=lieblingszahl;
}

public void construktor(int groeße, String name, String[] lieblingssongs) {
	this.groeße=groeße;
	this.name=name;
	this.lieblingssongs=lieblingssongs;
}

public void construktor(int groeße, String name) {
	this.groeße=groeße;
	this.name=name;
}

public String[] getLieblingssongs() {
	return lieblingssongs;
}
public String getName() {
	return name;
}
public int getGroeße() {
	return groeße;
}
public int getLieblingszahl() {
	return lieblingszahl;
}
public void setLieblingssongs(String[] lieblingssongs) {
	this.lieblingssongs=lieblingssongs;
}
public void setName(String name) {
	this.name=name;
}
public void setGroeße(int groeße) {
	this.groeße=groeße;
}
public void setLieblingszahl(int lieblingszahl) {
	this.lieblingszahl=lieblingszahl;
}
}
