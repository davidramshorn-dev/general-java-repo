package hausaufgabenIT;

public class Torwart extends Fußballer{
public int gehalteneBälle;
public int sprungkraft;
	public Torwart(String name, int alter, double ausdauer, int beliebtheit, int vermögen, int sprungkraft) {
		super(name, alter, ausdauer, beliebtheit, vermögen);
		this.sprungkraft=sprungkraft;
		gehalteneBälle=0;
	}
public void hältBall() {
	gehalteneBälle++;
}
}
