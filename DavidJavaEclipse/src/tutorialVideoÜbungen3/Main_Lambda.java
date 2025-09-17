package tutorialVideoÜbungen3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_Lambda {

	public static void main(String[] args) {
		Map<Rechentyp, Rechner> taschenrechner=new HashMap<>();
		taschenrechner.put(Rechentyp.DEFAULT, (a,b) -> 0);
		taschenrechner.put(Rechentyp.MULTIPLIZIEREN, (a,b) -> a*b);
		taschenrechner.put(Rechentyp.DIVIDIEREN, (a,b) -> a/b);
		taschenrechner.put(Rechentyp.ADDIEREN, (a,b) -> a+b);
		taschenrechner.put(Rechentyp.SUBTRAHIEREN, (a,b) -> a-b);
		System.out.println("Wollen Sie ADDIEREN, SUBTRAHIEREN, MULTIPLIZIEREN oder DIVIDIEREN? (1/2/3/4)");
		Scanner scanner=new Scanner(System.in);
		String input=scanner.nextLine();
		System.out.println("Zahl1: ");
		int zahl1=scanner.nextInt();
		System.out.println("Zahl2: ");
		int zahl2=scanner.nextInt();
			Rechentyp var;
			switch (input) {
			case "1":
				var=Rechentyp.ADDIEREN;
				break;
			case "2":
				var=Rechentyp.SUBTRAHIEREN;
				break;
			case "3":
				var=Rechentyp.MULTIPLIZIEREN;
				break;
			case "4":
				var=Rechentyp.DIVIDIEREN;
				break;
			default:
				var=Rechentyp.DEFAULT;
			}
			rechenOperation(taschenrechner.get(var), zahl1, zahl2);
			scanner.close();

	}
	public static void rechenOperation(Rechner rechner, int zahl1, int zahl2){
		System.out.println(rechner.rechnen(zahl1, zahl2));
	}

}
