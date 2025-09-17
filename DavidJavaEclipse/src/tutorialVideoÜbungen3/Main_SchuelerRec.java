package tutorialVideoÜbungen3;
import java.util.Scanner;
import java.util.Stack;

public class Main_SchuelerRec {

	public static void main(String[] args) {
		Stack<SchuelerRec> schueler=new Stack<>();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.println("Geben Sie ihren Namen oder n ein: ");
			String input=scanner.nextLine();
			if (input.equals("n")) {break;}
			else {
				String name=input;
			} System.out.println("Geben Sie ihr Alter ein: ");
			int input2=scanner.nextInt();
			 System.out.println("Geben Sie ihr Noten-Durchschnitt ein: ");
			 double input3=scanner.nextDouble();
			 scanner.nextLine();
			 System.out.println("Geben Sie ihre Schule ein: ");
			 String input4=scanner.nextLine();
			 schueler.add(new SchuelerRec(input, input2, input3, input4));
		} schueler.forEach(i->System.out.println(i.name()));
	}

}
