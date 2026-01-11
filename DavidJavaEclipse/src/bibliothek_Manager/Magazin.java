package bibliothek_Manager;

public class Magazin extends Medium{
	private String ausgabe;
	public Magazin(String titel, int jahr, String ausgabe) {
		super(titel, jahr);
		this.ausgabe=ausgabe;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void zeigeInfo() {
		// TODO Auto-generated method stub
		System.out.println("  Titel: "+super.getTitel()+",  Jahr: "+super.getJahr()+",  Ausgabe: "+ausgabe);
		
	}
	
	

	

}
