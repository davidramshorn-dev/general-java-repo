package bibliothek_Manager;

public class FalscheEingabeZahl extends NumberFormatException{
	private static final long serialVersionUID = 1L;

	public FalscheEingabeZahl() {
	super("Ein String oder eine andere ungültige Eingabe wurde getätigt.");}
}
