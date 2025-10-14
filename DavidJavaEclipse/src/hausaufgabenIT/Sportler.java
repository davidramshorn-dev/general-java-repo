package hausaufgabenIT;

public class Sportler extends Mensch{
public double ausdauer;
public int anzahlMedallien;

public Sportler(String name, int alter, double ausdauer) {
	super(name, alter);
	this.ausdauer=ausdauer;
	anzahlMedallien=0;
}
public double getAusdauer() {
	return ausdauer;
}
public void setAusdauer(double ausdauer) {
	this.ausdauer = ausdauer;
}
public int getAnzahlMedallien() {
	return anzahlMedallien;
}
public void setAnzahlMedallien(int anzahlMedallien) {
	this.anzahlMedallien = anzahlMedallien;
}
public double gewinnchance() {
	return 1-1/anzahlMedallien;
}
}
