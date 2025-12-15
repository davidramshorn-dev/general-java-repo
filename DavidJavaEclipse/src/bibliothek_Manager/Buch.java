package bibliothek_Manager;

public class Buch extends Medium{
	private String autor;
	private int seiten;

	public Buch(String titel, int jahr, String autor, int seiten) {
		super(titel, jahr);
		// TODO Auto-generated constructor stub
		this.autor=autor;
		this.seiten=seiten;
		
	}

	@Override
	public void zeigeInfo() {
		System.out.println("  Titel: "+super.getTitel()+",  Autor: "+autor+",  Jahr: "+super.getJahr()+",  Seiten: "+seiten);
		
	}

}
