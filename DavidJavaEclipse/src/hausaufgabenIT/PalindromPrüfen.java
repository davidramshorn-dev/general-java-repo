package hausaufgabenIT;

import java.util.Scanner;

public class PalindromPrüfen {
public static void main(String[] args) {
while(true) {
	Palindrom palindrom=new Palindrom(inputString());
System.out.println(palindrom.prüfeObPalindrom());
}
}

private static String inputString() {
System.out.println("Gib ein Palindrom ein!");
Scanner scanner=new Scanner(System.in);
return scanner.nextLine();
}
}
