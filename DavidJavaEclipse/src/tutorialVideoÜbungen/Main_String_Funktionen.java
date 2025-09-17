package tutorialVideoÜbungen;

import java.util.Scanner;

public class Main_String_Funktionen {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Geben Sie bitte einen Satz ein:");
String satz=scanner.nextLine();
int leerzeichen=0;
int kleinBuchstaben=0;
int großbuchstaben=0;
for (char i: satz.toCharArray()) {
	if (i==' ') {leerzeichen++;}
	else if (Character.isUpperCase(i)) {großbuchstaben++;}
	else if (Character.isLowerCase(i)) {kleinBuchstaben++;}

}System.out.printf("Der eingegebene Satz hat %d Leerzeichen, %d Großbuchstaben und %d Kleinbuchstaben.",leerzeichen,großbuchstaben,kleinBuchstaben);

}}
