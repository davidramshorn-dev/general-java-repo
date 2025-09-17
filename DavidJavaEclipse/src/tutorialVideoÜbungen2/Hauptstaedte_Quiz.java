package tutorialVideoÜbungen2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Hauptstaedte_Quiz {

	public static void main(String[] args) {
		int counter=0;
		Scanner scanner=new Scanner(System.in);
		Map<String, String[]> laender= new HashMap<>();
		laender.put("Deutschland", new String[]{"Berlin", "80"});
		laender.put("Spanien", new String[]{"Madrid", "50"});
		laender.put("Ukraine", new String[]{"Kyev", "40"});
		laender.put("China", new String[]{"Peking", "1000"});
		laender.put("Japan", new String[]{"Tokio", "120"});
		laender.put("USA", new String[]{"WashingtonDC", "320"});
		List<String> auswahl= new ArrayList<>();
		Stack<String> korrektur=new Stack<>();
		auswahl.addAll(laender.keySet());
		Random random =new Random();
		Set<String> order= new LinkedHashSet<>();
		while(order.size()<auswahl.size()) {
			order.add(auswahl.get(random.nextInt(auswahl.size())));
		}
		System.out.println("Willkommen bei dem Länder Quiz! \nBeantworte "+ order.size() +" Fragen, um der Länder-Champion zu werden.\nHauptstadt-Quiz oder Bevölkerungs-Quiz (H/B)?");
		String antwort=scanner.nextLine();
		int decide=0;
		if (antwort.equals("B")) {decide=1;}
		String[] frage1= {"Welche Hauptstadt hat ","Wie groß ist die Bevölkerung von "};
		String[] satz2= {"Die Hauptstadt von %s ist nicht %s, sondern %s.","Die Bevölkerung von %s beträgt nicht %s, sondern %s."};
		long beginn=System.currentTimeMillis();
		for(String i: order) {
			System.out.println(frage1[decide]+i+"?");
			String inputS=scanner.nextLine();
			if (inputS.equals(laender.get(i)[decide])) {
				counter++;
			}
			else {
				korrektur.add(String.format(satz2[decide], i,inputS,laender.get(i)[decide]));
			}
			
		}
		long ende=System.currentTimeMillis();
		System.out.println("Du hast "+counter+" Punkte erreicht!");
		System.out.println("Benötigte Zeit:\n"+(ende-beginn)/1000+" Sekunden");
		System.out.println("");
		if (korrektur.size()!=0) {
			System.out.println("Das waren deine Fehler: ");
			while(korrektur.size()!=0) {
				System.out.println(korrektur.pop());
			}
		}
		else {
			System.out.println("Und das ohne Fehler!");
		}

	}

}
