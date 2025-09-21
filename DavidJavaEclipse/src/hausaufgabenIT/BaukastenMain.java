package hausaufgabenIT;

public class BaukastenMain {
	public static void main(String[] args) {
		double länge=5;
		Kreis kreis=new Kreis(länge);
		System.out.println("(Kreis) "+länge+":");
		alleMetadaten(kreis);
		Rechteck rechteck=new Rechteck(länge, länge+1);
		System.out.println("(Rechteck) "+länge+", "+(länge+1)+":");
		alleMetadaten(rechteck);
		Quadrat quadrat=new Quadrat(länge);
		System.out.println("(Quadrat) "+länge+":");
		alleMetadaten(quadrat);
	}

	private static void alleMetadaten(Flaeche flaeche) {
		System.out.println("Fläche: "+flaeche.getFlaeche());
		System.out.println("Umfang: "+flaeche.getUmfang());
	}
}
