package tutorialVideoÜbungen3;

public class Main_Anonyme {
	public static void main(String[] args) {
		print(new Printable() {

			@Override
			public void print() {
				System.out.println("Yes");
			}
			
		});
	}
	public static void print(Printable printable) {
		printable.print();
	}
}
