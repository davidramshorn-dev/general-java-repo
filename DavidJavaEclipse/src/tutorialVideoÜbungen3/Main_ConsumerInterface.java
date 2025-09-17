package tutorialVideoÜbungen3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main_ConsumerInterface {
	public static void main(String[] args) {
	List<String> namen=new ArrayList<>();
	namen.add("David");
	namen.add("Julia");
	namen.add("Aniko");
	namen.add("Andreas");
	namen.add("Oma");
	namen.forEach(a->{char[] buchstaben=a.toCharArray();
	System.out.println(buchstaben[0]+" "+buchstaben[buchstaben.length-1]);});
}}
