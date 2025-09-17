package tutorialVideoÜbungen4;

public class Main_Geschenk {

	public static void main(String[] args) {
		Auto auto=new Auto(1000, "Mercedes");
		Barbie barbie=new Barbie(100, "Steve");
		GeschenkRec<Auto,Barbie> geschenkbox=new GeschenkRec<Auto,Barbie>(auto,barbie);
		geschenkbox.abwägen();

	}

}
