package hausaufgabenIT;

public class VererbungMain {

	public static void main(String[] args) {
		Stürmer stürmer=new Stürmer("Günther", 99, 10, 31, 100000000, 5, "Jay, jay, yeah");
		gibAlterAus(stürmer);
		for (int i=0; i<4; i++) {
		stürmer.feiertGeburtstag();
		gibAlterAus(stürmer);
		stürmer.schießtTor();}
		Büroangestellter olaf=new Büroangestellter("Olaf", 45, 100);
		gibAlterAus(olaf);

	}

	private static void gibAlterAus(Mensch mensch) {
		System.out.println(mensch.getName()+" ist "+ mensch.getAlter()+" Jahre alt.");
	}

}
