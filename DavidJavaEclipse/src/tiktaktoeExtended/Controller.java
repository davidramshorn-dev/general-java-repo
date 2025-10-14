package tiktaktoeExtended;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Controller {
	public SoundPlayer backgroundMusic=new SoundPlayer();
	

public TransparentButtonDemo2 view;
public Model model;
public int zaehler=0;
private boolean ersterZug = true;
private String an1;
private String an2;
private Spieler spieler1Orig=new Spieler("X", "spieler1", false, 1000000 , 0);
private Spieler spieler2Orig=new Spieler("O", "spielder2", false, 1000000 ,0);
private int limxOrig=6;
private int limyOrig=6;
private boolean payToWinOrig=false;
private int laengeOrig=4;
private int limx=6;
private int limy=6;
private boolean payToWin=false;
private int laenge=4;
@SuppressWarnings({ "unused" })
public Controller(TransparentButtonDemo2 view, Model model) {
	backgroundMusic.play("wav/718167__audiocoffee__star-journey-cinematic-trailer-loop-ver.wav", true);
	this.model=model;
	this.view=view;
	model.spielerZwischenspeicher.add(spieler1Orig);
	model.spielerZwischenspeicher.add(spieler2Orig);
	ActionListener closeListener= e->{
		warteKurz(100, ()->view.zeigePanel("homeScreen"));
	};
	view.getCloseHerausforderung().addActionListener(e->{
		warteKurz(100, ()->view.zeigePanel("spielfeldScreen"));
	});
	view.getCloseListeSpieler().addActionListener(e->{
		view.getContent().removeAll();
		warteKurz(100, ()->view.zeigePanel("homeScreen"));
	});
	view.getCloseSpielfeld().addActionListener(closeListener);
	view.getCloseSpielfeldSettings().addActionListener(closeListener);
	view.getCloseZeigeSieger().addActionListener(closeListener);
	
	view.getCloseSettingsSpieler().addActionListener((e)->{
		warteKurz(100, ()->	{
		for (ActionListener al : view.getApplySettingsSpieler().getActionListeners()) {
		    view.getApplySettingsSpieler().removeActionListener(al);
		}
		view.getContent().removeAll();
		refreshAlleSpieler();
		view.zeigePanel("alleSpieler"); 
		});
	});
	view.getSpielerSettings().addActionListener((e)->{
	    auffuellen();

	    setSafeActionListener(view.getResetAll(), g -> {
	        model.spielerZwischenspeicher.clear();
	        auffuellen();
	        view.getContent().removeAll();
	        view.getContent().revalidate();
	        view.getContent().repaint();
	        refreshAlleSpieler();
	    });

	    setSafeActionListener(view.getApplyListeSpieler(), r -> {
	        Spieler spieler = new Spieler();
	        model.spielerZwischenspeicher.add(spieler);
	        view.getNameBsp().setText(spieler.name);
	        view.getSpielertag().setText(spieler.spielertag);
	        view.getTierSub().setText(spieler.tier + "");
	        view.zeigePanel("spielerSettings");

	        // Optional: applySettings-Spieler resetten
	        for (ActionListener al : view.getApplySettingsSpieler().getActionListeners()) {
	            view.getApplySettingsSpieler().removeActionListener(al);
	        }

	        view.getApplySettingsSpieler().addActionListener(g -> {
	            if (!view.getNameBsp().getText().equals("")) {
	                spieler.name = view.getNameBsp().getText();
	            }
	            if (!view.getSpielertag().getText().equals("")) {
	                spieler.spielertag = view.getSpielertag().getText();
	            }
	            if (istGanzzahl(view.getTierSub().getText())) {
	                spieler.tier = Integer.parseInt(view.getTierSub().getText());
	            }
	            view.getNameBsp().setText(spieler.name);
	            view.getSpielertag().setText(spieler.spielertag);
	            view.getTierSub().setText(spieler.tier + "");
	        });});

	    refreshAlleSpieler();
	    warteKurz(100, () -> view.zeigePanel("alleSpieler"));
	});

	view.getSpielfeldSettings().addActionListener((e)->{
		view.getx().setText("");
		view.getPy().setText("");
		view.getPpruefLaenge().setText("");
		view.getPayToWin().setText("");
		warteKurz(100, ()->{
		view.getx().setPlaceholder("Default - "+limxOrig);
		view.getPy().setPlaceholder("Default - "+limyOrig);
		view.getPpruefLaenge().setPlaceholder("Default - "+laengeOrig);
		view.getPayToWin().setPlaceholder("Default - "+payToWinOrig);
		view.zeigePanel("spielfeldSettings");});
	});
	view.getApplySpielfeldSettings().addActionListener((e)->{
		String xPreferred=view.getx().getText();
		String yPreferred=view.getPy().getText();
		String payToWinPreferred=view.getPayToWin().getText();
		String pruefLaengePreferred=view.getPpruefLaenge().getText();
		if (istGanzzahl(xPreferred)) {
			if (Integer.parseInt(xPreferred)>2) {
				limx=Integer.parseInt(xPreferred);
			}
			else {
				limx=limxOrig;
			}
		}
		else {
			limx=limxOrig;
		}

		if (istGanzzahl(yPreferred)) {
			if (Integer.parseInt(yPreferred)>2) {
				limy=Integer.parseInt(yPreferred);
			}
			else {
				limy=limyOrig;
			}
		}
		else {
			limy=limyOrig;
		}
		if (payToWinPreferred.equals("true")) {
			payToWin=true;
		}
		else {
			payToWin=payToWinOrig;
		}
		if (istGanzzahl(pruefLaengePreferred)) {
			if (Integer.parseInt(pruefLaengePreferred)<limx && Integer.parseInt(pruefLaengePreferred)<limy) {
				laenge=Integer.parseInt(pruefLaengePreferred);
			}
			else {
				if (limx<limy) {
				laenge=limx-1;}
				else {
					laenge=limy-1;
				}
			}
		}
		else {
			if (limx<limy) {
				laenge=limx-1;}
				else {
					laenge=limy-1;
				}
		}
		view.getx().setText(limx+"");
		view.getPy().setText(limy+"");
		view.getPpruefLaenge().setText(laenge+"");
		view.getPayToWin().setText(payToWin+"");
		
	});

	Spielfeld spielfeld=new Spielfeld();
	
	view.getRevanche().addActionListener(e->{
		model.spielfeld=new Spielfeld(model.spielfeld.limx, model.spielfeld.limy, model.spielfeld.laenge, model.spielfeld.payToWin);
		createSpielPanel(model.spielfeld);
		warteKurz(100, ()->view.zeigePanel("spielfeldScreen"));
	});
	
	view.getPlayButton().addActionListener((e)->{Spielfeld spielfeldEx=new Spielfeld(limx, limy, laenge, payToWin);
	model.spielfeld=spielfeldEx;
	model.mitspieler = model.spielerZwischenspeicher.toArray(new Spieler[0]);
	createSpielPanel(spielfeldEx);
	view.zeigePanel("spielfeldScreen");});
	
	view.getButton().addActionListener((e)->{
		Set<String> allkeys = model.getSpielfelder().keySet();
		for (String key : allkeys) {
		    JMenuItem item = new JMenuItem(key);
		    view.getSaves().add(item);
		}
	});
}
private void auffuellen() {
	if (model.spielerZwischenspeicher.size()==0) {
		model.spielerZwischenspeicher.add(spieler1Orig);
		model.spielerZwischenspeicher.add(spieler2Orig);
	}
	
}
private void warteKurz(int ms, Runnable nachher) {
    new Timer(ms, e -> {
        ((Timer)e.getSource()).stop();
        nachher.run();
    }).start();
}

@SuppressWarnings("unused")
private void createSpielPanel(Spielfeld spielfeld) {
    JButton[][] buttons = new JButton[spielfeld.limy][spielfeld.limx];
    
    for (int y = 0; y < spielfeld.limy; y++) {
        for (int x = 0; x < spielfeld.limx; x++) {
            JButton button = new JButton();
            int[] xx = {x};
            int[] yy = {y};
            System.out.println(x+"  "+y);

            Koordinate[] koordinate = spielfeld.getSpielfeld();               //game Existiert bereits und buttons werden mit altem Spielstand gessetzt 
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

            buttons[y][x] = button;
            button.setOpaque(true);
            button.setContentAreaFilled(true);
            button.setBorderPainted(false);

            boolean sieWollenZufall = false;                                 //eher eine eigenschaft des Spielfeldes!!

            button.addActionListener(e -> {
                Spieler player = switchPlayer(model.mitspieler);             //ab hier nochmal den Code anschauen

                if (sieWollenZufall) {
                    int[] koordinaten = naechsterZug(yy[0], xx[0], player);
                    yy[0] = koordinaten[0];
                    xx[0] = koordinaten[1];
                }

                Color originalColor = buttons[yy[0]][xx[0]].getBackground();
                buttons[yy[0]][xx[0]].setBackground(Color.MAGENTA);

                new javax.swing.Timer(100, evt -> {
                    ((javax.swing.Timer) evt.getSource()).stop();

                    buttons[yy[0]][xx[0]].setBackground(originalColor);

                    // Versuche Spielfeld zu verändern
                    verändereSpielfeld(yy[0], xx[0], player, spielfeld, buttons);
                }).start();
            });
        }
    }
    System.out.println(spielfeld.spielfeld.length);

    view.createSpielPanel(buttons);

    if (spielfeld.sieger != null) {
        view.sperreAlleButtons(buttons, spielfeld);
    }
}
public void viewSpielfeldLogik(boolean neuesFeldWirdGesetzt, JButton[][] buttons, int y, int x, Spieler player, Spielfeld spielfeld) {
if (neuesFeldWirdGesetzt){
    buttons[y][x].setBackground(Color.RED);
    buttons[y][x].setText(player.spielertag);

    System.out.println("Folgender Spielertag von " + player.name + ": " + player.spielertag);

    spielfeld.gibGanzeSpielfeldAus();
    spielfeld.ueberpruefe(player);

    if (player.gewonnen) {
        spielfeld.sieger = player;
        gewonnen(player);
        view.sperreAlleButtons(buttons, spielfeld);  // ✅ Nur hier sperren
        
    } else {
        view.entsperreAlleButtons(buttons, spielfeld);  // ✅ Wenn kein Sieg, wieder freigeben
    }
} 
else {
    // Kein gültiger Zug: wieder freigeben
    view.entsperreAlleButtons(buttons, spielfeld);
}}
 
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
	view.getZeigeSieger().setText(spieler.name);
	   new javax.swing.Timer(300, evt -> {
           ((javax.swing.Timer) evt.getSource()).stop();
         	view.zeigePanel("gewinnerScreen");
       }).start();
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

//private void setSafeActionListener(JComboBox<?> comboBox, ActionListener newListener) {
//    for (ActionListener al : comboBox.getActionListeners()) {
//        comboBox.removeActionListener(al);
//    }
//    comboBox.addActionListener(newListener);
//}
public void verändereSpielfeld(int y,int x, Spieler spieler, Spielfeld spielfeld, JButton[][] buttons) {
	System.out.println("Methode verändereSpielfeld wurde aufgerufen!");
    Koordinate feld = spielfeld.spielfeld[y* spielfeld.limx + x];
    Spieler besitzer = feld.besitzer;
    System.out.print(besitzer.name+ "   ");
    System.out.println(spieler.name);
    System.out.print(besitzer.spielertag+ "   ");
    System.out.println(spieler.spielertag);
    if (besitzer.name.equals("default")) {
        feld.besitzer = spieler;
        viewSpielfeldLogik(true, buttons, y, x, spieler, spielfeld);
    }
    else if (besitzer.name.equals(spieler.name)) {
    	viewSpielfeldLogik(true, buttons, y, x, spieler, spielfeld);
    }
    else {
    herausforderung(besitzer, spieler, y, x, spielfeld, buttons);}
}
private void herausforderung(Spieler besitzer, Spieler spieler, int y,int x, Spielfeld spielfeld, JButton[][] buttons) {
	Koordinate feld = spielfeld.spielfeld[y* spielfeld.limx + x];
	view.zeigePanel("herausforderungScreen");
	view.getSpielerAmZug().setText(spieler.name+ " ist am Zug!");
	ActionListener[] ref = new ActionListener[1]; // Platzhalter für self-reference

	ref[0] = new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (ersterZug) {
	            an1 = e.getActionCommand();
	            ersterZug = false;
	            view.getSpielerAmZug().setText(besitzer.name + " ist am Zug!");
	        } else {
	            an2 = e.getActionCommand();
	            if (überprüfeObGewinner(an1, an2)) {
	                view.zeigePanel("spielfeldScreen");
	                feld.besitzer = spieler;
	                if (istGewinnerSpieler(an1, an2)) {
	                    viewSpielfeldLogik(true, buttons, y, x, spieler, spielfeld);
	                } else {
	                    viewSpielfeldLogik(false, buttons, y, x, spieler, spielfeld);
	                }
	            }
	            ersterZug = true;
	            view.getSpielerAmZug().setText(spieler.name + " ist am Zug!");

	            // jetzt Listener entfernen
	            view.getSchere().removeActionListener(ref[0]);
	            view.getStein().removeActionListener(ref[0]);
	            view.getPapier().removeActionListener(ref[0]);
	        }
	    }
	};

	// an alle Buttons hängen
	view.getSchere().addActionListener(ref[0]);
	view.getStein().addActionListener(ref[0]);
	view.getPapier().addActionListener(ref[0]);


	    view.getSchere().setActionCommand("Schere");
	    view.getStein().setActionCommand("Stein");
	    view.getPapier().setActionCommand("Papier");
}
private boolean istGewinnerSpieler(String an12, String an22) {
	if (an1.equals("Stein")&&an2.equals("Schere")) {System.out.print("yes");
	return true;
}
else if (an1.equals("Papier")&&an2.equals("Stein")) {
	return true;
}
else if (an1.equals("Schere")&&an2.equals("Papier")) {
	return true;
}
	return false;
}
private boolean überprüfeObGewinner(String an12, String an22) {
	return !an12.equals(an22);
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
@SuppressWarnings("unused")
public void refreshAlleSpieler() {
	for (int i=0; i<model.spielerZwischenspeicher.size();i++) {
		Spieler spieler=model.spielerZwischenspeicher.get(i);
		PlayerPanel player=new PlayerPanel(spieler.name);
		player.label.setText(spieler.name);
		player.customize.addActionListener(f->{
			view.getNameBsp().setText(spieler.name);
			view.getSpielertag().setText(spieler.spielertag);
			view.getTierSub().setText(spieler.tier+"");
			view.getApplySettingsSpieler().addActionListener(g->{
				if (!view.getNameBsp().getText().equals("")) {
					spieler.name=view.getNameBsp().getText();
				}
				if (!view.getSpielertag().getText().equals("")) {
					spieler.spielertag=view.getSpielertag().getText();
				}
				if (istGanzzahl(view.getTierSub().getText())) {
					spieler.tier=Integer.parseInt(view.getTierSub().getText());
				}
				view.getNameBsp().setText(spieler.name);
				view.getSpielertag().setText(spieler.spielertag);
				view.getTierSub().setText(spieler.tier+"");
				player.label.setText(spieler.name);
			});
			view.zeigePanel("spielerSettings");
		});
		player.delete.addActionListener(f->{
			view.content.remove(player);
			view.content.revalidate();
			view.content.repaint();
			model.spielerZwischenspeicher.remove(spieler);
			System.out.println(	model.spielerZwischenspeicher.size());
		});
		view.getContent().add(player);
	}
}
}                         