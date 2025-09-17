package tutorialVideoÜbungen;

import java.util.Scanner;

public class KonditionelleOperatoren {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int zahl= scanner.nextInt();
		System.out.println("Der Betrag: " + betrag(zahl));
		scanner.close();

	}
	public static int betrag(int i1) {
		return i1 > 0 ? i1: -1 * i1;
	}

}
