package tutorialVideoÜbungen;

public class Experiment {

	public static void main(String[] args) {
		double[] ergebnisse= {1.4, 5.0, 3.4, 5.9};
		double sum=0;
		for (int i=0; i<ergebnisse.length; i++) {
			sum = sum + ergebnisse[i];
		}
		System.out.println(sum / ergebnisse.length);

	}

}
