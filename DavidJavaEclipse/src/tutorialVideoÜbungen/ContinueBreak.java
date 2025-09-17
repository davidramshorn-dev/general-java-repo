package tutorialVideoÜbungen;

import java.util.Random;

public class ContinueBreak {

	public static void main(String[] args) {
		int[] zahlen = {1, 30, 28917, 213, 1321, 13};
		System.out.println("Nur Zahlen, die Größer als 100 sind:");
		for(int i : zahlen) {
			if (i<=100) {continue;}
			System.out.println(i);
		}
		String[] mRNA = {"uuc", "aug", "agg", "gua", "ccu", "ggg", "ccc"};
		System.out.println("Aminosäure:");
		boolean startCodon=false;
		for(String i : mRNA) {
			if (i.equals("aug")) {
				startCodon=true;
			}
			if(startCodon) {
				System.out.println(i);
			}
			if(startCodon&&i.equals("ggg")) {
				break;
			}
		}
		System.out.println("Dreimal die !!");
		Random random= new Random();
		int[] letztenDrei= new int[3];
		while(true) {
			int aktuell= random.nextInt(6);
			int vorgaenger= letztenDrei[0];
			int vorvorgaenger= letztenDrei[1];
			letztenDrei[0]=aktuell;
			letztenDrei[1]=vorgaenger;
			letztenDrei[2]= vorvorgaenger;
			System.out.println(vorvorgaenger+", " + vorgaenger+", " + aktuell);
			if (vorgaenger== aktuell && aktuell == vorvorgaenger) {break;}
			
		}
		System.out.println("Dreimal die "+ letztenDrei[0] +" !!");

	}

}
