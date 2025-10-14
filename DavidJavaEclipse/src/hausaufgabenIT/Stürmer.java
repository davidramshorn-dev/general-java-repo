package hausaufgabenIT;

public class Stürmer extends Fußballer{
public int geschwindigkeit;
public int geschosseneTore;
public String torjubel;
	public Stürmer(String name, int alter, double ausdauer, int beliebtheit, int vermögen, int geschwindigkeit, String torjubel) {
		super(name, alter, ausdauer, beliebtheit, vermögen);
		this.geschwindigkeit=geschwindigkeit;
		this.torjubel=torjubel;
		geschosseneTore=0;
	}
public void schießtTor() {
	geschosseneTore++;
	System.out.println(torjubel);
}
public int getGeschwindigkeit() {
	return geschwindigkeit;
}
public void setGeschwindigkeit(int geschwindigkeit) {
	this.geschwindigkeit = geschwindigkeit;
}
public int getGeschosseneTore() {
	return geschosseneTore;
}
public void setGeschosseneTore(int geschosseneTore) {
	this.geschosseneTore = geschosseneTore;
}
public String getTorjubel() {
	return torjubel;
}
public void setTorjubel(String torjubel) {
	this.torjubel = torjubel;
}

}
