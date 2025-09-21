package hausaufgabenIT;

public class Rechteck implements Flaeche{
private double a;
private double b;
private double flaeche;
private double umfang;
	
	public Rechteck(double a, double b) {
	this.a = a;
	this.b = b;
	flaeche=berechneFlaeche();
	umfang=berechneUmfang();
}

	public double getFlaeche() {
		return flaeche;
	}

	public double getUmfang() {
		return umfang;
	}

	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	@Override
	public double berechneFlaeche() {
		return a*b;
	}

	@Override
	public double berechneUmfang() {
		return (a+b)*2;
	}

}
