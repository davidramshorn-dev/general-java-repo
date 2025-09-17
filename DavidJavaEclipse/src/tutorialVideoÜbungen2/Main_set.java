package tutorialVideoÜbungen2;

import java.util.HashSet;
import java.util.Set;

public class Main_set {

	public static void main(String[] args) {
		Set<Weapon> weapons= new HashSet<>();
		weapons.add(new Weapon("David"));
		weapons.add(new Weapon("David"));
		for (Weapon i: weapons) {
		System.out.println(i.name);
		}
	}

}
