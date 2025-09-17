package tutorialVideoÜbungen;

public class Baum extends Pflanzen{
	public String art;
	public Baum(String name, int alter, int groeße, String art) {
	    super(name, alter, groeße, true, false);
	    this.art=art;
	}
	public void getBaumArt() {
		System.out.println(art);
	}
}
