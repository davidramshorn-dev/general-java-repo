package tutorialVideoÜbungen2;

public class Main_Hunde {

	public static void main(String[] args) {
		HundInterface dackel= new Dackel(true);
		HundInterface mobs= new Mobs(4);
		HundInterface schaeferhund= new Schaeferhund();
		HundInterface[] hunde= {dackel, mobs, schaeferhund};
		for(HundInterface hund: hunde) {
			hund.bellen();
			hund.pfoteGeben();
		}

	}

}
