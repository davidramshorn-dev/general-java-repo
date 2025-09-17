package tutorialVideoÜbungen;

import java.util.Random;

public class ZufaelligesWort {
	public static void main(String[] args) {
String vokale="AEIOUÖÄÜ";
String konsonanten="WQRSDFYXCVBGZHTNMJKLP";
Random random=new Random();
String word = String.valueOf(konsonanten.charAt(random.nextInt(21)));
for (int i=1; i<3; i++) {
	word += String.valueOf(vokale.charAt(random.nextInt(8)));
	word += String.valueOf(konsonanten.charAt(random.nextInt(21)));
}
System.out.println(word);
}}
