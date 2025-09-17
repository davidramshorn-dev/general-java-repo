package geschenkMama;

public class Spielfeld {
public int laenge;
public int limx;
public int limy;
public Spieler sieger=null;
public Koordinate[] spielfeld;
public boolean payToWin;

public Spielfeld(int limx, int limy, int laenge, boolean payToWin){
	this.laenge=laenge;
	this.limx=limx;
	this.limy=limy;
	this.payToWin=payToWin;
	berechneKoordinaten();
}

public void berechneKoordinaten() {
	spielfeld=new Koordinate[limx*limy];
	for (int i=0; i<spielfeld.length; i++) {
		spielfeld[i]=new Koordinate(i, i%limy, (i-i%limy)/limx);
		System.out.print("NR-Koordinate: "+ spielfeld[i].nr);
		System.out.print("      X-Koordinate: "+ spielfeld[i].x);
		System.out.print("      Y-Koordinate: "+ spielfeld[i].y);
		System.out.print("      Besitzer-Koordinate: "+ spielfeld[i].besitzer.name);
		System.out.println();}
	
}

public Koordinate[] getSpielfeld() {
	return spielfeld;
}

public void setSpielfeld(Koordinate[] spielfeld) {
	this.spielfeld = spielfeld;
}

public boolean istBeendet() {
    return sieger != null; // Beispiel: wenn `sieger` gesetzt wurde
}

public boolean verändereSpielfeld(int x, int y, Spieler spieler) {
	System.out.println("Methode verändereSpielfeld wurde aufgerufen!");
    Koordinate feld = spielfeld[y * limx + x];
    Spieler besitzer = feld.besitzer;
    System.out.print(besitzer.name+ "   ");
    System.out.println(spieler.name);
    System.out.print(besitzer.spielertag+ "   ");
    System.out.println(spieler.spielertag);
    if (besitzer.name.equals("default")) {
        feld.besitzer = spieler;
        return true;
    }
    if (besitzer.name.equals(spieler.name)) {
        return false;
    }
    boolean gewonnen = herausforderung(x, y, spieler);
    if (gewonnen) {
        feld.besitzer = spieler;
        return true;
    }

    return false;
}
public HerausforderungIfo generiereHerausforderung(int x, int y, Spieler spieler) {
	HerausforderungIfo info=new HerausforderungIfo(x, y, spieler);
	return info;
}
public boolean herausforderung(int x, int y, Spieler spieler) {
	boolean permition=false;
//	Scanner scanner= new Scanner(System.in);
//	System.out.println("Du ("+spieler.name+") hast "+ spielfeld[y * limx + x].besitzer.name+" herausgefordert. \n Gewinne ein Schere, Stein, Papier Spiel gegen ihn, \num das Tik Tak Toe Feld zu übernehmen.");
//	while (true) {
//	System.out.println(spieler.name+" ist an der Reihe. Gib Sch, St oder Pa ein: ");
//	String an1=scanner.nextLine();
//	System.out.println(spielfeld[y * limx + x].besitzer.name+" ist an der Reihe. Gib Sch, St oder Pa ein: ");
//	String an2=scanner.nextLine();
//	if (an1.equals("St")&&an2.equals("Sch")) {System.out.print("yes");
//		permition= true;
//		break;
//	}
//	else if (an1.equals("Pa")&&an2.equals("St")) {
//		permition= true;
//		break;
//	}
//	else if (an1.equals("Sch")&&an2.equals("Pa")) {
//		permition= true;
//		break;
//	}
//	if (an1.equals("Pa")&&an2.equals("Sch")) {
//		break;
//	}
//	else if (an1.equals("Sch")&&an2.equals("St")) {
//		break;
//	}
//	else if (an1.equals("St")&&an2.equals("Pa")) {
//		break;
//	}
//	}
//	if (permition) {
//		System.out.println(spieler.name+" hat gewonnen.");
//	}
//	else {
//		System.out.println(spielfeld[y * limx + x].besitzer.name+" hat gewonnen.");
//	}                
	return permition;
}

public void ueberpruefe(Spieler spieler) {
	ueberpruefeWaagerecht(spieler);
	ueberpruefeSenkrecht(spieler);
	ueberpruefe13Diagonal(spieler);
	ueberpruefe24Diagonal(spieler);
}

public void ueberpruefeWaagerecht(Spieler spieler) {
	int zaehler=0;
	loop: for (int y=0; y<limy; y++) {
		for (int i=0; i<limx; i++) {
		 for (int z=i; z<laenge+i; z++) {
			if (spielfeld[z+y*(limx-1)].besitzer.spielertag==spielfeld[z+y*(limx-1)+1].besitzer.spielertag&&spielfeld[z+y*(limx-1)].besitzer.spielertag==spieler.spielertag) {zaehler++;
			if (zaehler>laenge-2) {spieler.gewonnen(true); 
			break loop;
			}}
			else {zaehler=0;}}
		 
}}}

public void ueberpruefeSenkrecht(Spieler spieler) {
    for (int x = 0; x < limx; x++) {
        int zaehler = 0;
        for (int y = 0; y < limy - 1; y++) {
            int index = x + y * limx;
            int nextIndex = x + (y + 1) * limx;
            if (spielfeld[index].besitzer.spielertag.equals(spieler.spielertag) &&
                spielfeld[nextIndex].besitzer.spielertag.equals(spieler.spielertag)) {
                zaehler++;
                if (zaehler >= laenge - 1) {
                    spieler.gewonnen(true);
                    return;
                }
            } else {
                zaehler = 0;
            }
        }
    }
}

public void ueberpruefe13Diagonal(Spieler spieler) {
	for (int x = 0; x<limx-laenge+1; x++) {
		int zaehler = 0;
		for (int y=0; y<limy; y++) {
			for (int i=0; i<laenge-1; i++) {
				if (x+(y+i+1)*limx+i+1>=spielfeld.length) {continue;}
				if (spielfeld[x+(y+i)*limx+i].besitzer.spielertag==spielfeld[x+(y+i+1)*limx+i+1].besitzer.spielertag && spielfeld[x+(y+i)*limx+i].besitzer.spielertag==spieler.spielertag) {
					zaehler++;
	                if (zaehler >= laenge - 1) {
	                    spieler.gewonnen(true);
	                    return;
	                }
				} else {
	                zaehler = 0;
	            }
			}
		}
	}
}

public void ueberpruefe24Diagonal(Spieler spieler) {
	for (int x = laenge-1; x<limx; x++) {
		int zaehler = 0;
		for (int y=0; y<limy; y++) {
			for (int i=0; i<laenge-1; i++) {
				if (-1>=x+(y+i+1)*limx-i-1 || x+(y+i)*limx-i>=spielfeld.length || x+(y+i+1)*limx-i-1>=spielfeld.length) {continue;}
				int vorgaenger =x+(y+i)*limx-i;
				int nachfolger =x+(y+i+1)*limx-i-1;
				if (spielfeld[vorgaenger].besitzer.spielertag.equals(spielfeld[nachfolger].besitzer.spielertag) && spielfeld[vorgaenger].besitzer.spielertag.equals(spieler.spielertag)) {
					zaehler++;
	                if (zaehler >= laenge - 1) {
	                    spieler.gewonnen(true);
	                    return;
	                }
				} else {
	                zaehler = 0;
	            }
			}
		}
	}
}

}                     