package Bibliothek_Manager2_0;

public class Buch extends Medium{
	private String autor;
	private int seiten;

	public Buch(int id, String titel, int jahr, String autor, int seiten) {
		super(titel, jahr);
		// TODO Auto-generated constructor stub
		this.autor=autor;
		this.seiten=seiten;
		
	}

	@Override
	public void zeigeInfo() {
		// TODO Auto-generated method stub
		
	}

}
