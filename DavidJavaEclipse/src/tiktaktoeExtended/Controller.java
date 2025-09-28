package tiktaktoeExtended;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Random;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Controller {
public TransparentButtonDemo2 view;
public Model model;
public int zaehler=0;
@SuppressWarnings({ "unused" })
public Controller(TransparentButtonDemo2 view, Model model) {
	this.model=model;
	this.view=view;
	ActionListener closeListener= e->{
		warteKurz(100, ()->view.zeigePanel("homeScreen"));
	};
	view.getCloseHerausforderung().addActionListener(closeListener);
	view.getCloseListeSpieler().addActionListener(closeListener);
	view.getCloseSpielfeld().addActionListener(closeListener);
	view.getCloseSpielfeldSettings().addActionListener(closeListener);
	view.getCloseZeigeSieger().addActionListener(closeListener);
	
	view.getCloseSettingsSpieler().addActionListener((e)->{
		warteKurz(100, ()->	view.zeigePanel("alleSpieler"));
	});
	view.getSpielerSettings().addActionListener((e)->{
		warteKurz(100, ()->	view.zeigePanel("alleSpieler"));
	});
	view.getSpielfeldSettings().addActionListener((e)->{
		warteKurz(100, ()->view.zeigePanel("spielfeldSettings"));
	});

	model.setSpielfelder(map);

	view.getButton().addActionListener((e)->{
		Set<String> allkeys = model.getSpielfelder().keySet();
		for (String key : allkeys) {
		    JMenuItem item = new JMenuItem(key);
		    view.getSaves().add(item);
		}
	});
}
private void warteKurz(int ms, Runnable nachher) {
    new Timer(ms, e -> {
        ((Timer)e.getSource()).stop();
        nachher.run();
    }).start();
}
@SuppressWarnings("unused")
//private void createSpielPanel(Spielfeld spielfeld, Spieler[] mitspieler) {
//    JButton[][] buttons = new JButton[spielfeld.limy][spielfeld.limx];
//    
//    for (int y = 0; y < spielfeld.limy; y++) {
//        for (int x = 0; x < spielfeld.limx; x++) {
//            JButton button = new JButton();
//            int[] xx = {x};
//            int[] yy = {y};
//
//            Koordinate[] koordinate = spielfeld.getSpielfeld();
//            if (x + y * spielfeld.limx<koordinate.length) {
//            switch (koordinate[x + y * spielfeld.limx].besitzer.name) {
//                case "default":
//                    button.setBackground(Color.GRAY);
//                    button.setText("");
//                    break;
//                default:
//                    button.setBackground(Color.PINK);
//                    button.setText(koordinate[x + y * spielfeld.limx].besitzer.spielertag);
//                    break;
//            }}
//
//            buttons[x][y] = button;
//            button.setOpaque(true);
//            button.setContentAreaFilled(true);
//            button.setBorderPainted(false);
//
//            boolean sieWollenZufall = true;
//
//            setSafeActionListener(button, e -> {
//                Spieler player = switchPlayer(model.mitspieler);
//
//                if (sieWollenZufall) {
//                    int[] koordinaten = naechsterZug(xx[0], yy[0], player);
//                    xx[0] = koordinaten[0];
//                    yy[0] = koordinaten[1];
//                }
//
//                Color originalColor = buttons[xx[0]][yy[0]].getBackground();
//                buttons[xx[0]][yy[0]].setBackground(Color.MAGENTA);
//
//                new javax.swing.Timer(100, evt -> {
//                    ((javax.swing.Timer) evt.getSource()).stop();
//
//                    buttons[xx[0]][yy[0]].setBackground(originalColor);
//
//                    // Versuche Spielfeld zu verändern
//                    if (spielfeld.verändereSpielfeld(xx[0], yy[0], player)) {
//                        buttons[xx[0]][yy[0]].setBackground(Color.RED);
//                        buttons[xx[0]][yy[0]].setText(player.spielertag);
//
//                        Koordinate[] koordinat = spielfeld.getSpielfeld();
//                        koordinat[xx[0] + yy[0] * spielfeld.limx].besitzer = player;
//                        spielfeld.setSpielfeld(koordinat);
//
//                        System.out.println("Folgender Spielertag von " + player.name + ": " + player.spielertag);
//
//                        spielfeld.ueberpruefe(player);
//
//                        if (player.gewonnen) {
//                            spielfeld.sieger = player;
//                            gewonnen(player);
//                            view.sperreAlleButtons(buttons, spielfeld);  // ✅ Nur hier sperren
//                        } else {
//                            view.entsperreAlleButtons(buttons, spielfeld);  // ✅ Wenn kein Sieg, wieder freigeben
//                        }
//                    } else {
//                        // Kein gültiger Zug: wieder freigeben
//                        view.entsperreAlleButtons(buttons, spielfeld);
//                    }
//                }).start();
//            });
//        }
//    }
//
//    view.createSpielPanel(buttons);
//
//    if (spielfeld.sieger != null) {
//        view.sperreAlleButtons(buttons, spielfeld);
//    }
//}
 
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
//private void speichereAktuellesSpielWennNotwendig() {
//    if (model.spielfeld != null && !model.spielfeld.istBeendet()) {
//        Object selected = view.getSaves().getSelectedItem();
//        String key;
//        if (selected == null || "Neues".equals(selected.toString())) {
//            // Neues Spiel speichern unter neuem Key
//            int i = 1;
//            do {
//                key = String.valueOf(i++);
//            } while (model.spielfelder.containsKey(key));
//        } else {
//            // Vorhandenes Spiel wird unter seinem Namen gespeichert
//            key = selected.toString();
//        }
//        model.spielfelder.put(key, model.spielfeld);
//        // ComboBox aktualisieren
//        String[] neueNamen = model.spielfelder.keySet().toArray(new String[0]);
//        view.aktualisiereSavesListe(neueNamen);
//    }
//}
 
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