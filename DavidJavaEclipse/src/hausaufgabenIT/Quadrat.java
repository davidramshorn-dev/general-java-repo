package hausaufgabenIT;

public class Quadrat implements Flaeche{
private double a;
private double umfang;
private double flaeche;

	public Quadrat(double a) {
	super();
	this.a = a;
	umfang = berechneUmfang();
	flaeche = berechneFlaeche();
}

	@Override
	public double berechneFlaeche() {
		return Math.pow(a, 2);
	}

	@Override
	public double berechneUmfang() {
		return 4*a;
	}

	public double getA() {
		return a;
	}

	public double getUmfang() {
		return umfang;
	}

	public double getFlaeche() {
		return flaeche;
	}

}
