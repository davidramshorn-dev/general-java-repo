package tutorialVideoÜbungen4;

public class Spielzeug {
	public int beliebtheit;
	public String name="Auto";
	public Spielzeug(int beliebtheit, String name) {
		this.beliebtheit=beliebtheit;
		this.name=name;
	}
	public String getNameI() {
		return name;
	}
}
