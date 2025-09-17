package tutorialVideoÜbungen;

import java.util.ArrayList;

public class ForEach {

	public static void main(String[] args) {
		   ArrayList<Integer> array1d = new ArrayList<>();
		for(int i=0; i<10; i++) {
			for(int l=0; l<10; l++) {
				array1d.add(i*10+l);
			}
		}
		for(int ausgabe: array1d) {
		System.out.println(ausgabe+1);}
	}

}
