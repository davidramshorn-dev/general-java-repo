package bibliothek_Manager;

public class BenutzerNichtGefunden extends NullPointerException{

	private static final long serialVersionUID = 1L;
	public BenutzerNichtGefunden(String name) {
		super(name+" wurde in der Datenbank nicht gefunden.");
	}

}
