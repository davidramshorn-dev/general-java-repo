package tutorialVideoÜbungen5;

public class AnonymeKlassen {

	public static void main(String[] args) {
		print((e) -> System.out.println(e));
	}
	public static void print(Printable printable) {
		printable.print(1000);
	}

}
