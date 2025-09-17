package tutorialVideoÜbungen;

public class Pflanzen extends Lebewesen{
public boolean mussGegossenWerden;
public boolean istGiftig;
public Pflanzen(String name, int alter, int groeße, boolean mussGegossenWerden, boolean istGiftig) {
    super(name, alter, groeße);
    this.mussGegossenWerden = mussGegossenWerden;
    this.istGiftig = istGiftig;
}
public void inAchtNehmen() {
	if (istGiftig&&mussGegossenWerden) {
		System.out.println("Besondere Vorsicht beim Giessen.");
	}
}
}
