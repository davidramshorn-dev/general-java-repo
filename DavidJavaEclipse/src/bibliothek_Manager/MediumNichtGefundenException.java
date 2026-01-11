package bibliothek_Manager;

public class MediumNichtGefundenException extends NullPointerException {
    private static final long serialVersionUID = 1L;

	public MediumNichtGefundenException(int id) {
        super("Die ID " + id + " ist nicht im System registriert.");
    }
}

