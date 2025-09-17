package tutorialVideoÜbungen;

import java.util.Random;

public class Würfel {

	public static void main(String[] args) {
		System.out.println(wuerfeln());
	}
	public static int wuerfeln() {
		Random random = new Random();
		int zahl = random.nextInt(6)+1;
		return zahl;
	}

}
