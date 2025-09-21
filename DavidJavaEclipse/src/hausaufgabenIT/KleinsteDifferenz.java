package hausaufgabenIT;

public class KleinsteDifferenz {
	public static void main(String[] args) {
		Kreis besteKreis=new Kreis(2);
		for (int i=2;i<10; i++) {
			Kreis kreis=new Kreis(i);
			if (besteKreis.getDifferenzFU()>kreis.getDifferenzFU()) {
				besteKreis=kreis;
			}
		}
		KreisBerechnen.kreisAlleInformationen(besteKreis);
	}
}
