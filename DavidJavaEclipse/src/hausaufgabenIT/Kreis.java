package hausaufgabenIT;

public class Kreis implements Flaeche{
public double radius;
public double flaeche;
public double umfang;
public double differenzFU;
public Kreis(double radius) {
	this.radius=radius;
umfang=berechneUmfang();
flaeche=berechneFlaeche();
differenzFU=Math.abs(berechneDifferenzFU());
}
private double berechneDifferenzFU() {
	if (flaeche-umfang>0) {
	return flaeche-umfang;}
	else{
		return -1*(flaeche-umfang);
	}
}
public double berechneFlaeche() {
	return Math.pow(radius, 2)*Math.PI;
}
public double berechneUmfang() {
	return 2*radius*Math.PI;
}
public double getRadius() {
	return radius;
}
public void setRadius(double radius) {
	this.radius = radius;
}
public double getFlaeche() {
	return flaeche;
}
public void setFlaeche(double flaeche) {
	this.flaeche = flaeche;
}
public double getUmfang() {
	return umfang;
}
public void setUmfang(double umfang) {
	this.umfang = umfang;
}
public double getDifferenzFU() {
	return differenzFU;
}
public void setDifferenzFU(double differenzFU) {
	this.differenzFU = differenzFU;
}
}
