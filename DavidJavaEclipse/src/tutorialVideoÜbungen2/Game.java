package tutorialVideoÜbungen2;

public class Game {

	public static void main(String[] args) {
		Gamer Sp1=new Gamer(Schwierigkeitsgrad.LEICHT);
		switch (Sp1.getLevel()) {
		case Schwierigkeitsgrad.LEICHT:
			System.out.println("LEICHT");
			break;
		case Schwierigkeitsgrad.MITTEL:
			System.out.println("MITTEL");
			break;
		case Schwierigkeitsgrad.HART:
			System.out.println("HART");
			break;
		default:
			break;
		}

	}

}
