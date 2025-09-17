package hausaufgabenIT;

import java.util.Scanner;

public class KreisBerechnen {
	public static void main(String[] args) {
		Kreis kreis=new Kreis(radiusEingabe());
		kreisAlleInformationen(kreis);
	}

	public static void kreisAlleInformationen(Kreis kreis) {
		System.out.println("Die Radius: "+kreis.getRadius());
		System.out.println("Die Flaeche: "+kreis.getFlaeche());
		System.out.println("Die Umfang: "+kreis.getUmfang());
		System.out.println("Die Differenz: "+kreis.getDifferenzFU());
		
	}

	private static double radiusEingabe() {
	Scanner scanner=new Scanner(System.in);
	System.out.println("Gib einen Radius ein!");
	return scanner.nextDouble();
	}
}
