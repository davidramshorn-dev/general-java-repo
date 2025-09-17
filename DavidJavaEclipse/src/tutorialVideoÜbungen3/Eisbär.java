package tutorialVideoÜbungen3;

public class Eisbär extends Tier{
	String lieblingsEssen;
	public Eisbär(int alter, String lieblingsEssen) {
		super(true, alter);
		this.lieblingsEssen=lieblingsEssen;
	}

	@Override
	public void fressen() {
		System.out.println(lieblingsEssen+" ... Lecker.. Mhmh...");
		
	}

}
