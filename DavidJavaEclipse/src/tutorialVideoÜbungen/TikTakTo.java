package tutorialVideoÜbungen;

import java.util.Scanner;

public class TikTakTo {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Sie pielen mit dem Kreis. Bitte geben sie ihren Namen ein: ");
		Spieler spieler1= new Spieler(scanner.nextLine(), "O");
		System.out.println("Sie pielen mit dem Kreuz. Bitte geben sie ihren Namen ein: ");
		Spieler spieler2= new Spieler(scanner.nextLine(), "X");
		String[][] tabelle= new String[3][3];
		for (int i=0; i<tabelle.length; i++) {
			for (int i1=0; i1<tabelle[0].length; i1++) {
				tabelle[i][i1]= Integer.toString(i1+1+i*3);
			}
		}
		main: while (true) {
		createTabelle(tabelle);
		
		if (!freieFelderVorhanden(tabelle)) {break main;}
		tabelle= waehleFeld(spieler1, tabelle, scanner);
		
		createTabelle(tabelle);
	
		if (!freieFelderVorhanden(tabelle)) {break main;}
		
		tabelle= waehleFeld(spieler2, tabelle, scanner);
		
		checkeGewinner(tabelle, spieler1, spieler2);
	}System.out.println(spieler1.gewonnen);
	System.out.println(spieler2.gewonnen);}

	public static boolean freieFelderVorhanden(String[][] tabelle) {
		for(String[] i: tabelle) {for(String i1: i) {
			switch(i1){
			case "1": 
				return true;
			case "2": 
				return true;
			case "3": 
				return true;
			case "4": 
				return true;
			case "5": 
				return true;
			case "6": 
				return true;
			case "7": 
				return true;
			case "8": 
				return true;
			case "9": 
				return true;
				
			
			}
			
		}
		}
		return false;
	}

	public static void checkeGewinner(String[][] tabelle, Spieler spieler1, Spieler spieler2) {
		int x=0;
		String y="";
		for(String[] i: tabelle) {
			for(int i1=0; i1<i.length-2; i1++) { 
				if(i[i1]==i[i1+1]) {x++;}
				i[i1]=y;
			}
			gewinnErmittlung(y, x, spieler1, spieler2);
		}
		for(int i=0; i<tabelle.length-2; i++) {
			for(String[] i1: tabelle) {
				if(i1[i]==i1[i+1]) {x++;}
				i1[i]=y;
				gewinnErmittlung(y, x, spieler1, spieler2);
			}
		}
		for(int i=0; i<tabelle.length-2; i++) {

				if(tabelle[i][i]==tabelle[i+1][i+1]) {x++;}
				tabelle[i][i]=y;
				gewinnErmittlung(y, x, spieler1, spieler2);
		}
		for(int i=0; i<tabelle.length-2; i++) {

			if(tabelle[i][tabelle.length-1-i]==tabelle[i+1][tabelle.length-2-i]) {x++;}
			tabelle[i][tabelle.length-1-i]=y;
			gewinnErmittlung(y, x, spieler1, spieler2);
	}
	}

	private static void gewinnErmittlung(String y, int x, Spieler spieler1, Spieler spieler2) {
		if (x==2) {if (y==spieler1.gamertag) {spieler1.gewonnen=true;}
		else{spieler2.gewonnen=true;}}
	}

	private static String[][] waehleFeld(Spieler spieler, String[][] tabelle, Scanner scanner) {
		System.out.println(spieler.name+" ist am Zug... Wähle ein Feld: ");
		loop: while(true) {
		String feld=scanner.nextLine();
		for (int i=0; i<tabelle.length; i++) {
			for (int i1=0; i1<tabelle[0].length; i1++) {
				if (tabelle[i][i1].equals(feld)) {
					if(spieler.gamertag=="X") {tabelle[i][i1]="X";}
					else {tabelle[i][i1]="O";}
					break loop;
					
				}
				else {System.out.println("Ungültige Eingabe. Wähle ein Feld: ");}
			}}
		}
		return tabelle;
		
	}

	private static void createTabelle(String[][] tabelle) {
		for (int i=0; i<tabelle.length; i++) {
			for (int i1=0; i1<tabelle[0].length; i1++) {
				System.out.print(tabelle[i][i1] + "\t");
			}
			System.out.println();
		}
		
	}

}
