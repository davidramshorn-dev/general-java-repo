package tiktaktoeExtended;

import java.util.Scanner;

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

public Spielfeld(){
	this.laenge=4;
	this.limx=6;
	this.limy=5;
	this.payToWin=false;
	berechneKoordinaten();
}

public void berechneKoordinaten() {
	spielfeld=new Koordinate[limx*limy];
	for (int i=0; i<spielfeld.length; i++) {
		spielfeld[i]=new Koordinate(i, i%limx, (i-(i%limx))/limx);}
	
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

public void ueberpruefe(Spieler spieler) {
	ueberpruefeWaagerecht(spieler);
	ueberpruefeSenkrecht(spieler);
	ueberpruefe13Diagonal(spieler);
	ueberpruefe24Diagonal(spieler);
}

public void ueberpruefeWaagerecht(Spieler spieler) {
	int zaehler=0;
	for (int y=0; y<limy; y++) {
		for (int i=0; i<limx; i++) {
		 for (int z=i; z<laenge+i; z++) {
			if (spielfeld[z+y*(limx-1)].besitzer.spielertag==spielfeld[z+y*(limx-1)+1].besitzer.spielertag&&spielfeld[z+y*(limx-1)].besitzer.spielertag==spieler.spielertag) {zaehler++;
			if (zaehler>laenge-2) {spieler.gewonnen(true); 
        	gibGanzeSpielfeldAus();
        	System.out.println("waagerechtGewonnen");
			return;
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
                	gibGanzeSpielfeldAus();
                	System.out.println("senkrechtGewonnen");
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
	                	gibGanzeSpielfeldAus();
	                	System.out.println("diagonal13Gewonnen");
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
	                	gibGanzeSpielfeldAus();
	                	System.out.println("diagonal24Gewonnen");
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

public void gibGanzeSpielfeldAus() {
for (int i=0; i<spielfeld.length;i++) {
	System.out.print("NR-Koordinate: "+ spielfeld[i].nr);
	System.out.print("      X-Koordinate: "+ spielfeld[i].x);
	System.out.print("      Y-Koordinate: "+ spielfeld[i].y);
	System.out.print("      Besitzer-Koordinate: "+ spielfeld[i].besitzer.name);
	System.out.println();
}
	
}

}                     