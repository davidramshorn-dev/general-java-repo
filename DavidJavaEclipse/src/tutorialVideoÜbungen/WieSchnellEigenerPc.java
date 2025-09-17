package tutorialVideoÜbungen;

public class WieSchnellEigenerPc {

	public static void main(String[] args) {
		long beginn=System.nanoTime();
		for (int i=0; i< 500000; i++) {
			double x=Math.sin(i);
		}
		long ende=System.nanoTime();
		System.out.println(ende-beginn);

	}

}
