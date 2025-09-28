package tiktaktoeExtended;

	public class Koordinate {
		public Spieler besitzer;
		int x;
		int y;
		int nr;
		public Koordinate (int nr, int x, int y, Spieler besitzer) {
			this.nr=nr;
		this.x=x;
		this.y=y;
		this.besitzer=besitzer;}
		public Koordinate (int nr, int x, int y) {
			this.nr=nr;
		this.x=x;
		this.y=y;
		this.besitzer=new Spieler();}
		}              
