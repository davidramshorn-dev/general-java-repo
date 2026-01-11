package bibliothek_Manager;

public class Film extends Medium{
	private String regisseur;
	private int dauer;

	public Film(String titel, int jahr, String regisseur, int dauer) {
		super(titel, jahr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void zeigeInfo() {
		// TODO Auto-generated method stub
		System.out.println("  Titel: "+super.getTitel()+",  Regisseur: "+regisseur+",  Jahr: "+super.getJahr()+",  Dauer: "+dauer);
		
	}

}
