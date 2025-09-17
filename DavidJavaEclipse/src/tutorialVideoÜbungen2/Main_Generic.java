package tutorialVideoÜbungen2;

public class Main_Generic {

	public static void main(String[] args) {
		Hund_Generic<String> hund=new Hund_Generic<String>("2");
		Hund_Generic<Integer> hund1=new Hund_Generic<Integer>(7);
		Hund_Generic<Double> hund2=new Hund_Generic<Double>(2.2);
		hund.gibName();
		hund1.gibName();
		hund2.gibName();

	}

}
