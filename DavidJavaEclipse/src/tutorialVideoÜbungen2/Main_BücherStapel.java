package tutorialVideoÜbungen2;

import java.util.Scanner;
import java.util.Stack;

public class Main_BücherStapel {

	public static void main(String[] args) {
		Stack<String> buecherstapel=new Stack<>();
		Scanner scan=new Scanner(System.in);
		while (true) {
			System.out.println("Geben Sie den Namen eines Buches ein oder stoppen sie das Programm mit einem n: ");
			String input = scan.nextLine();
			if (input.equals("n")) {break;}
			else {
				buecherstapel.add(input);
			}
		}System.out.println("Dein Bücherstapel: "+ buecherstapel.pop());
		System.out.println("Dein Bücherstapel: "+ buecherstapel.pop());

	}

}
