import java.util.ArrayList;
import java.util.Scanner;

public class Einkaufsliste {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		ArrayList<String> einkaufsliste = new ArrayList();
		while(true) {
			System.out.println("Geben Sie ein weiteres Lebensmittel oder n ein.");
			String input =scan.nextLine();
			if(!input.equals("n")) {
				einkaufsliste.add(input);
			}
			else {break;}
		} for (String lebensmittel: einkaufsliste) {
			System.out.println(lebensmittel);
		}scan.close();
	}

}
