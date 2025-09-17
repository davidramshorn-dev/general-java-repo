package geschenkMama;

import java.awt.Color;
import java.awt.event.ActionListener;
//import java.util.Arrays;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Controller {
public View view;
public Model model;
public int zaehler=0;
@SuppressWarnings({ "unused" })
public Controller(View view, Model model) {
	view.initialisiereControllerAktionen(this);
    this.model=model;
	this.view=view;
	System.out.println("spielfeldSettings: " + view.getSpielfeldSettings());
	System.out.println("saves: " + view.getSaves());
	String[] namen;
	try {
	    namen = model.spielfelder.keySet().toArray(new String[0]);
	} catch (NullPointerException e) {
	    System.out.println("Achtung: 'model' oder 'model.spielfelder' ist null!");
	    namen = new String[0]; // Leeres Array als Fallback
	}
	view.setSaves(new JComboBox<String>(namen));
	view.getSaves().addItem("Neues");
	view.erstelleSpielGUI();
	setSafeActionListener(view.getSpielfeldSettings(), e -> {
	    System.out.println("Öffnet die Spielfeld Settings...");
	    view.zeigePanel("SettingsSpielfeld");
	});
	setSafeActionListener(view.getPlayButton(), e -> {
	    System.out.println("Startet Spiel...");

	    Object selected = view.getSaves().getSelectedItem();

	    if (selected == null || "Neues".equals(selected.toString())) {
	        // Neues Spiel starten
	        int i = 1;
	        String key;
	        do {
	            key = String.valueOf(i++);
	        } while (model.spielfelder.containsKey(key));
					        Spielfeld neuesSpielfeld = new Spielfeld(4, 4, 3, false);
					        model.spielfelder.put(key, neuesSpielfeld);
					        model.spielfeld = neuesSpielfeld;
// ComboBox aktualisieren
	        String[] neueNamen = model.spielfelder.keySet().toArray(new String[0]);
	        view.aktualisiereSavesListe(neueNamen);

	    } else {
	        // Vorhandenes Spiel laden
	        String key = selected.toString();
	        Spielfeld gespeichertes = model.spielfelder.get(key);
	        if (gespeichertes != null) {
	            model.spielfeld = gespeichertes;
	        } else {
	            System.err.println("❌ Fehler: Save \"" + key + "\" nicht gefunden!");
	            return; // Nichts laden
	        }
	    }

	    // Starte das gewählte/neue Spiel
	    createSpielPanel(model.spielfeld, model.mitspieler);
	});
	setSafeActionListener(view.getSaves(), (e)->System.out.println("Zeigt die Saves..."));
	setSafeActionListener(view.getSpielerSettings(), (e)->System.out.println("Zeigt alle Teilnehmenden Spieler..."));
	
	setSafeActionListener(view.getCloseSpielfeldSettings(), (e)->{
	    System.out.println("Die Spielfeld Settings wurden geschlossen...");
		view.setX(new PlaceholderTextField(""));
		view.setY(new PlaceholderTextField(""));
		view.setPruefLaenge(new PlaceholderTextField(""));
		view.setTierSub(new PlaceholderTextField(""));
	    view.zeigePanel("Titelbild");
	});
	setSafeActionListener(view.getApplySpielfeldSettings(), (e)->{System.out.println("Wende Eingabe an und schließe, wenn gültiger input...");
	Object selected = view.getSaves().getSelectedItem();

    if (selected == null || "Neues".equals(selected.toString())) {
        // Neues Spiel starten
        int i = 1;
        String key;
        do {
            key = String.valueOf(i++);
        } while (model.spielfelder.containsKey(key));
				        Spielfeld neuesSpielfeld = new Spielfeld(4, 4, 3, false);
				        model.spielfelder.put(key, neuesSpielfeld);
				        model.spielfeld = neuesSpielfeld;
//ComboBox aktualisieren
        String[] neueNamen = model.spielfelder.keySet().toArray(new String[0]);
        view.aktualisiereSavesListe(neueNamen);

    } else {
        // Vorhandenes Spiel laden
        String key = selected.toString();
        Spielfeld gespeichertes = model.spielfelder.get(key);
        if (gespeichertes != null) {
            model.spielfeld = gespeichertes;
        } else {
            System.err.println("❌ Fehler: Save \"" + key + "\" nicht gefunden!");
            return; // Nichts laden
        }
    }
    
	if (istGanzzahl(view.getX().getText())) {
	    model.spielfeld.limx = Integer.parseInt(view.getX().getText());
	    uebertrageTextAlsPlaceholder("Spielfeld Breite: ", view.getX());
	} else {
	    view.getX().setText(String.valueOf(model.spielfeld.limx));
	    uebertrageTextAlsPlaceholder("Spielfeld Breite: DEFAULT - ", view.getX());
	}

	if (istGanzzahl(view.getY().getText())) {
	    model.spielfeld.limy = Integer.parseInt(view.getY().getText());
	    uebertrageTextAlsPlaceholder("Spielfeld Höhe: ", view.getY());
	} else {
	    view.getY().setText(String.valueOf(model.spielfeld.limy)); // ✅ vorher falsch
	    uebertrageTextAlsPlaceholder("Spielfeld Höhe: DEFAULT - ", view.getY());
	}

	if (
	    istGanzzahl(view.getPruefLaenge().getText()) &&
	    Integer.parseInt(view.getPruefLaenge().getText()) < model.spielfeld.limx &&
	    Integer.parseInt(view.getPruefLaenge().getText()) < model.spielfeld.limy
	) {
	    model.spielfeld.laenge = Integer.parseInt(view.getPruefLaenge().getText());
	    uebertrageTextAlsPlaceholder("Prüf-Länge: ", view.getPruefLaenge());
	} else {
	    view.getPruefLaenge().setText(String.valueOf(model.spielfeld.laenge)); // ✅ vorher falsch
	    uebertrageTextAlsPlaceholder("Prüf-Länge: DEFAULT - ", view.getPruefLaenge());
	}

	if (view.getPayToWin().getText().equalsIgnoreCase("Ja")) {
	    model.spielfeld.payToWin = true;
	    uebertrageTextAlsPlaceholder("PayToWin: ", view.getPayToWin());
	} else {
	    view.getPayToWin().setText(String.valueOf(model.spielfeld.payToWin)); // ✅ vorher falsch
	    uebertrageTextAlsPlaceholder("PayToWin: DEFAULT - ", view.getPayToWin());
	}
	model.spielfeld.berechneKoordinaten();
   view.zeigePanel("Titelbild");});
	
	view.getSpielerSettings().addActionListener((e)->{view.zeigePanel("ListeSpieler");});
	view.getCloseListeSpieler().addActionListener((e)->{System.out.println("Die Liste von Spielern wurde geschlossen..."); view.zeigePanel("Titelbild");});
	view.getApplyListeSpieler().addActionListener((e)->{System.out.println("Wende Eingabe an und schließe, wenn gültiger input..."); view.zeigePanel("SettingsSpieler");});
//	view.getResetAll().addActionListener((e)->System.out.println("Alle Spieler werden auf default zurückgesetzt..."));
//	view.getMitspieler().forEach(i->i.addActionListener((e)->System.out.println("Spieler wurde ausgewählt...")));
//	
//	view.getCloseSettingsSpieler().addActionListener((e)->System.out.println("Die Spieler Settings wurden geschlossen..."));
//	view.getApplySettingsSpieler().addActionListener((e)->System.out.println("Wende Eingabe an und schließe, wenn gültiger input..."));
//	view.getResetSettingsSpieler().addActionListener((e)->System.out.println("Die Eingaben werden zurückgesetzt..."));
//	
	setSafeActionListener(view.getCloseSpielfeld(), (e) -> {
//	    System.out.println("Spiel wird verlassen und gespeichert...");
//	    speichereAktuellesSpielWennNotwendig(); // 🔁 speichern, wenn nötig
//	    model.spielfelder.forEach((o, i)->{System.out.println("Danach: "+Arrays.toString(i.spielfeld));});
//	    view.updateTitelbild();
	    view.zeigePanel("Titelbild");
	});
//	view.getKoordinaten().forEach(i->i.addActionListener((e)->System.out.println("SpielerAmZug hat seinen Zug gemacht...")));   // eigentliche Spielmechanik
//	
//	view.getSchere().addActionListener((e)->System.out.println("Spieler wählt Schere aus..."));
//	view.getStein().addActionListener((e)->System.out.println("Spieler wählt Stein aus..."));
//	view.getPapier().addActionListener((e)->System.out.println("Spieler wählt Papier aus..."));
//	view.getCloseHerausforderung().addActionListener((e)->System.out.println("Die Herausforderung wird geschlossen..."));
//	
//	view.getRevanche().addActionListener((e)->System.out.println("Die Revanche beginnt..."));
//	view.getCloseZeigeSieger().addActionListener((e)->System.out.println("Der Gewinner ist..."));
//	JButton revanche;
//    JButton closeZeigeSieger;
}
@SuppressWarnings("unused")
private void createSpielPanel(Spielfeld spielfeld, Spieler[] mitspieler) {
    JButton[][] buttons = new JButton[spielfeld.limy][spielfeld.limx];
    
    for (int y = 0; y < spielfeld.limy; y++) {
        for (int x = 0; x < spielfeld.limx; x++) {
            JButton button = new JButton();
            int[] xx = {x};
            int[] yy = {y};

            Koordinate[] koordinate = spielfeld.getSpielfeld();
            if (x + y * spielfeld.limx<koordinate.length) {
            switch (koordinate[x + y * spielfeld.limx].besitzer.name) {
                case "default":
                    button.setBackground(Color.GRAY);
                    button.setText("");
                    break;
                default:
                    button.setBackground(Color.PINK);
                    button.setText(koordinate[x + y * spielfeld.limx].besitzer.spielertag);
                    break;
            }}

            buttons[x][y] = button;
            button.setOpaque(true);
            button.setContentAreaFilled(true);
            button.setBorderPainted(false);

            boolean sieWollenZufall = true;

            setSafeActionListener(button, e -> {
                Spieler player = switchPlayer(model.mitspieler);

                if (sieWollenZufall) {
                    int[] koordinaten = naechsterZug(xx[0], yy[0], player);
                    xx[0] = koordinaten[0];
                    yy[0] = koordinaten[1];
                }

                Color originalColor = buttons[xx[0]][yy[0]].getBackground();
                buttons[xx[0]][yy[0]].setBackground(Color.MAGENTA);

                new javax.swing.Timer(100, evt -> {
                    ((javax.swing.Timer) evt.getSource()).stop();

                    buttons[xx[0]][yy[0]].setBackground(originalColor);

                    // Versuche Spielfeld zu verändern
                    if (spielfeld.verändereSpielfeld(xx[0], yy[0], player)) {
                        buttons[xx[0]][yy[0]].setBackground(Color.RED);
                        buttons[xx[0]][yy[0]].setText(player.spielertag);

                        Koordinate[] koordinat = spielfeld.getSpielfeld();
                        koordinat[xx[0] + yy[0] * spielfeld.limx].besitzer = player;
                        spielfeld.setSpielfeld(koordinat);

                        System.out.println("Folgender Spielertag von " + player.name + ": " + player.spielertag);

                        spielfeld.ueberpruefe(player);

                        if (player.gewonnen) {
                            spielfeld.sieger = player;
                            gewonnen(player);
                            view.sperreAlleButtons(buttons, spielfeld);  // ✅ Nur hier sperren
                        } else {
                            view.entsperreAlleButtons(buttons, spielfeld);  // ✅ Wenn kein Sieg, wieder freigeben
                        }
                    } else {
                        // Kein gültiger Zug: wieder freigeben
                        view.entsperreAlleButtons(buttons, spielfeld);
                    }
                }).start();
            });
        }
    }

    view.createSpielPanel(buttons);

    if (spielfeld.sieger != null) {
        view.sperreAlleButtons(buttons, spielfeld);
    }
}
 
private Spieler switchPlayer(Spieler[] spielergruppe) {
	zaehler++;
	if(zaehler>=spielergruppe.length) {
		zaehler=0;
	}
	return spielergruppe[zaehler];
}
public int[] naechsterZug(int x, int y, Spieler spieler) { 
	Random random= new Random();
	int n= spieler.tier;
	int r=random.nextInt(16+n);
	if (r==15+n){
		x++;}
	if (r==14+n){
		x++; y--;}
	if (r==13+n){
		x--;}
	if (r==12+n){
		x--; y--;}
	if (r==11+n){
		x++; y++;}
	if (r==9+n){
		y++;}
	if (r==8+n){
		y--;}
	if (r==7+n){
		x--; y++;}
	System.out.println(x);
	System.out.println(y);
	x = Math.max(0, Math.min(x, model.spielfeld.limx - 1));
	y = Math.max(0, Math.min(y, model.spielfeld.limy - 1));
	System.out.println(x);
	System.out.println(y);
int[] koordinaten= {x, y};
return koordinaten;
}
private void gewonnen(Spieler spieler) {
	System.out.println("Herzlichen Glückwunsch "+ spieler.name +"! Du hast das Spiel gewonnen.");
	spieler.gewonnen=false;
	spieler.gewinncounter++;
	
}
private void speichereAktuellesSpielWennNotwendig() {
    if (model.spielfeld != null && !model.spielfeld.istBeendet()) {
        Object selected = view.getSaves().getSelectedItem();
        String key;
        if (selected == null || "Neues".equals(selected.toString())) {
            // Neues Spiel speichern unter neuem Key
            int i = 1;
            do {
                key = String.valueOf(i++);
            } while (model.spielfelder.containsKey(key));
        } else {
            // Vorhandenes Spiel wird unter seinem Namen gespeichert
            key = selected.toString();
        }
        model.spielfelder.put(key, model.spielfeld);
        // ComboBox aktualisieren
        String[] neueNamen = model.spielfelder.keySet().toArray(new String[0]);
        view.aktualisiereSavesListe(neueNamen);
    }
}
 
private void setSafeActionListener(AbstractButton button, ActionListener newListener) {
    for (ActionListener al : button.getActionListeners()) {
        button.removeActionListener(al);
    }
    button.addActionListener(newListener);
}

private void setSafeActionListener(JComboBox<?> comboBox, ActionListener newListener) {
    for (ActionListener al : comboBox.getActionListeners()) {
        comboBox.removeActionListener(al);
    }
    comboBox.addActionListener(newListener);
}
public void uebertrageTextAlsPlaceholder(String s, JTextField jTextField) {
    String eingabe = jTextField.getText();
    jTextField.setText("");
    ((PlaceholderTextField) jTextField).setPlaceholder(s+eingabe);
}
public boolean istGanzzahl(String s) {
    try {
        Integer.parseInt(s);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}
}                         