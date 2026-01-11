package bibliothek_Manager;

public class MediumNichtGefundenException extends Exception {
    public MediumNichtGefundenException(int id) {
        super("Die ID " + id + " ist nicht im System registriert.");
    }
}

