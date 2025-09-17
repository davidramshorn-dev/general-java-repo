package tutorialVideoÜbungen;

public class Printf {

	public static void main(String[] args) {
		String name="Robert";
	int alter= 15;
	double groeße=5.42;
	System.out.printf("Guten Tag %s. \n Sie sind %d Jahre alt und %f cm groß. \n", name, alter, groeße);
	System.out.printf("Guten Tag %S. \n Sie sind %08d Jahre alt und %024.2f cm groß. \n", name, alter, groeße);
	}

}
