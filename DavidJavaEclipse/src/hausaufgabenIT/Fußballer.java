package hausaufgabenIT;

public class Fußballer extends Sportler{
public int beliebtheit;
public int vermögen;
	public Fußballer(String name, int alter, double ausdauer, int beliebtheit, int vermögen) {
		super(name, alter, ausdauer);
		this.beliebtheit=beliebtheit;
		this.vermögen=vermögen;
	}
public int wieWohlhabend() {
	return beliebtheit*vermögen;
	
}
public int getBeliebtheit() {
	return beliebtheit;
}
public void setBeliebtheit(int beliebtheit) {
	this.beliebtheit = beliebtheit;
}
public int getVermögen() {
	return vermögen;
}
public void setVermögen(int vermögen) {
	this.vermögen = vermögen;
}
}
