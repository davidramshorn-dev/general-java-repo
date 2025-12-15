package bibliothek_Manager;
public abstract class Medium {
	private int id;
	private String titel;
	private int jahr;
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getTitel() {
		return titel;
	}
	public int getId() {
		return id;
	}



	public void setTitel(String titel) {
		this.titel = titel;
	}



	public int getJahr() {
		return jahr;
	}



	public void setJahr(int jahr) {
		this.jahr = jahr;
	}



	public Medium(String titel, int jahr) {
		super();
		this.titel = titel;
		this.jahr = jahr;
	}



	abstract public void zeigeInfo();
}
