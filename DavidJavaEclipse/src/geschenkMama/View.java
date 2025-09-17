package geschenkMama;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Queue;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View {
	private JFrame frame;
    private JPanel kartenContainer; 
    private CardLayout cardLayout;
    public JButton[][] buttons;
    
    
    public JButton[][] getButtons() {
		return buttons;
	}
	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}

	// Titelbild Buttons
    JComboBox<String> saves;
    JButton spielerSettings;
    JButton spielfeldSettings;
    JButton playButton;
    
    public JComboBox<String> getSaves(){
    	return saves;
    }
    public void setSaves(JComboBox<String> saves){
    	this.saves= saves;
    }
    public JButton getSpielerSettings(){
    	return spielerSettings;
    }
    public JButton getSpielfeldSettings(){
    	return spielfeldSettings;
    }
    public JButton getPlayButton(){
    	return playButton;
    }
    
 // SpielfeldSettings
//    JTextField x;
//    JTextField y;
//    JTextField pruefLaenge;
//    JTextField payToWin;     //tickYesChooser...
    PlaceholderTextField x = new PlaceholderTextField("Spielfeld Breite:");
    PlaceholderTextField y = new PlaceholderTextField("Spielfeld Länge:");
    PlaceholderTextField pruefLaenge = new PlaceholderTextField("Prüfende Länge:");
    PlaceholderTextField payToWin = new PlaceholderTextField("Pay To Win Modus:");
    
    JButton closeSpielfeldSettings;
    JButton applySpielfeldSettings;
  
//	public PlaceholderTextField getPx() {
//		return Px;
//	}
//	public void setPx(PlaceholderTextField px) {
//		Px = px;
//	}
//	public PlaceholderTextField getPy() {
//		return Py;
//	}
//	public void setPy(PlaceholderTextField py) {
//		Py = py;
//	}
//	public PlaceholderTextField getPpruefLaenge() {
//		return PpruefLaenge;
//	}
//	public void setPpruefLaenge(PlaceholderTextField ppruefLaenge) {
//		PpruefLaenge = ppruefLaenge;
//	}
//	public PlaceholderTextField getPpayToWin() {
//		return PpayToWin;
//	}
//	public void setPpayToWin(PlaceholderTextField ppayToWin) {
//		PpayToWin = ppayToWin;
//	}
	public JButton getCloseSpielfeldSettings() {
		return closeSpielfeldSettings;
	}
	public void setCloseSpielfeldSettings(JButton closeSpielfeldSettings) {
		this.closeSpielfeldSettings = closeSpielfeldSettings;
	}
	public JButton getApplySpielfeldSettings() {
		return applySpielfeldSettings;
	}
	public void setApplySpielfeldSettings(JButton applySpielfeldSettings) {
		this.applySpielfeldSettings = applySpielfeldSettings;
	}
    public JTextField getX() {
		return x;
	}
	public void setX(PlaceholderTextField x) {
		this.x = x;
	}
	public JTextField getY() {
		return y;
	}
	public void setY(PlaceholderTextField y) {
		this.y = y;
	}
	public JTextField getPruefLaenge() {
		return pruefLaenge;
	}
	public void setPruefLaenge(PlaceholderTextField pruefLaenge) {
		this.pruefLaenge = pruefLaenge;
	}
	public JTextField getPayToWin() {
		return payToWin;
	}
	public void setPayToWin(PlaceholderTextField payToWin) {
		this.payToWin = payToWin;
	}
	
	// ListeSpieler
	JButton closeListeSpieler;
    JButton applyListeSpieler;
    JButton resetAll;
    Stack<JButton> mitspieler;
    
	public Stack<JButton> getMitspieler() {
		return mitspieler;
	}
	public void setMitspieler(Stack<JButton> mitspieler) {
		this.mitspieler = mitspieler;
	}
	public JButton getResetAll() {
		return resetAll;
	}
	public void setResetAll(JButton resetAll) {
		this.resetAll = resetAll;
	}
	public JButton getCloseListeSpieler() {
		return closeListeSpieler;
	}
	public void setCloseListeSpieler(JButton closeListeSpieler) {
		this.closeListeSpieler = closeListeSpieler;
	}
	public JButton getApplyListeSpieler() {
		return applyListeSpieler;
	}
	public void setApplyListeSpieler(JButton applyListeSpieler) {
		this.applyListeSpieler = applyListeSpieler;
	}
	
	// SettingsSpieler
	PlaceholderTextField name;
    PlaceholderTextField spielertag;
    PlaceholderTextField tierSub;
    PlaceholderTextField farbe;     //rotationalChooser
    JButton closeSettingsSpieler;
    JButton applySettingsSpieler;
    JButton resetSettingsSpieler;
    
    public JTextField getName() {
		return name;
	}
	public void setName(PlaceholderTextField name) {
		this.name = name;
	}
	public JTextField getSpielertag() {
		return spielertag;
	}
	public void setSpielertag(PlaceholderTextField spielertag) {
		this.spielertag = spielertag;
	}
	public JTextField getTierSub() {
		return tierSub;
	}
	public void setTierSub(PlaceholderTextField tierSub) {
		this.tierSub = tierSub;
	}
	public JTextField getFarbe() {
		return farbe;
	}
	public void setFarbe(PlaceholderTextField farbe) {
		this.farbe = farbe;
	}
	public JButton getCloseSettingsSpieler() {
		return closeSettingsSpieler;
	}
	public void setCloseSettingsSpieler(JButton closeSettingsSpieler) {
		this.closeSettingsSpieler = closeSettingsSpieler;
	}
	public JButton getApplySettingsSpieler() {
		return applySettingsSpieler;
	}
	public void setApplySettingsSpieler(JButton applySettingsSpieler) {
		this.applySettingsSpieler = applySettingsSpieler;
	}
	public JButton getResetSettingsSpieler() {
		return resetSettingsSpieler;
	}
	public void setResetSettingsSpieler(JButton resetSettingsSpieler) {
		this.resetSettingsSpieler = resetSettingsSpieler;
	}
    
	// Spielfeld
	JButton closeSpielfeld=new JButton("Close");
	Queue<JButton> koordinaten;
	
	public JButton getCloseSpielfeld() {
		return closeSpielfeld;
	}
	public void setCloseSpielfeld(JButton closeSpielfeld) {
		this.closeSpielfeld = closeSpielfeld;
	}
	public Queue<JButton> getKoordinaten() {
		return koordinaten;
	}
	public void setKoordinaten(Queue<JButton> koordinaten) {
		this.koordinaten = koordinaten;
	}
	
	// Herausforderung
	JButton schere;
    JButton stein;
    JButton papier;
    JButton closeHerausforderung;    //Automatisch verloren
    
    public JButton getSchere() {
		return schere;
	}
	public void setSchere(JButton schere) {
		this.schere = schere;
	}
	public JButton getStein() {
		return stein;
	}
	public void setStein(JButton stein) {
		this.stein = stein;
	}
	public JButton getPapier() {
		return papier;
	}
	public void setPapier(JButton papier) {
		this.papier = papier;
	}
	public JButton getCloseHerausforderung() {
		return closeHerausforderung;
	}
	public void setCloseHerausforderung(JButton closeHerausforderung) {
		this.closeHerausforderung = closeHerausforderung;
	}
	
	// ZeigeSieger
	JButton revanche;
    JButton closeZeigeSieger;
    
	public JButton getRevanche() {
		return revanche;
	}
	public void setRevanche(JButton revanche) {
		this.revanche = revanche;
	}
	public JButton getCloseZeigeSieger() {
		return closeZeigeSieger;
	}
	public void setCloseZeigeSieger(JButton closeZeigeSieger) {
		this.closeZeigeSieger = closeZeigeSieger;
	}
	
	public void erstelleSpielGUI() {
        frame = new JFrame("TikTakToe - immersive.2.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        
        cardLayout = new CardLayout();
        kartenContainer = new JPanel(cardLayout);

        JPanel panel1 = createTitelbildPanel();
        JPanel panel2 = createSettingsSpielfeld();
        JPanel panel3 = createListeSpieler();
        JPanel panel4 = createSettingsSpieler();
//        JPanel panel6 = createHerausforderung();
//        JPanel panel7 = createSiegerPanel();

        kartenContainer.add(panel1, "Titelbild");
        kartenContainer.add(panel2, "SettingsSpielfeld");
        kartenContainer.add(panel3, "ListeSpieler");
        kartenContainer.add(panel4, "SettingsSpieler");
//        kartenContainer.add(panel6, "Herausforderung");
//        kartenContainer.add(panel7, "ZeigeSieger");
        frame.add(kartenContainer);
        frame.setVisible(true);
    }
	@SuppressWarnings("unused")
	public void initialisiereControllerAktionen(Controller c) {
	    // Nur wenn die Komponenten nicht null sind
	    if (spielfeldSettings != null) {
	        spielfeldSettings.addActionListener((e) -> {
	            System.out.println("Öffnet die Spielfeld Settings...");
	            zeigePanel("SettingsSpielfeld");
	        });
	    }

	    if (applySpielfeldSettings != null) {
	        applySpielfeldSettings.addActionListener((e) -> {
	            System.out.println("Wende Eingabe an und schließe, wenn gültiger Input...");
	            System.out.println("X-Eingabe: " + getX().getText());
	            zeigePanel("Titelbild"); // Optional
	        });
	    }

	    if (closeSpielfeldSettings != null) {
	        closeSpielfeldSettings.addActionListener((e) -> {
	            System.out.println("Die Spielfeld Settings wurden geschlossen...");
	            zeigePanel("Titelbild");
	        });
	    }

	    if (saves != null) {
	        saves.addActionListener((e) -> System.out.println("Zeigt die Saves..."));
	    }

	    if (spielerSettings != null) {
	        spielerSettings.addActionListener((e) -> System.out.println("Zeigt alle Teilnehmenden Spieler..."));
	    }

	    // usw. – du kannst die anderen Buttons hier auch hinzufügen
	}
    @SuppressWarnings("unused")
	private JPanel createHerausforderung() {
    	JPanel panel = new JPanel(); panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    	panel.setBackground(Color.BLACK);
        JLabel titel = new JLabel("Herausforderung - TikTakToe");
        titel.setFont(new Font("Arial", Font.BOLD, 24));
        titel.setForeground(Color.WHITE);
        panel.add(titel);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        JButton buttonSchere=new JButton("Schere");
       // buttonSchere.addActionListener(()->{String input="Schere";spielfeld.herausforderung(zaehler, zaehler, spielerAmZug);});
        JButton buttonStein=new JButton("Stein");
        JButton buttonPapier= new JButton("Papier");
        panel2.add(buttonSchere);
        panel2.add(buttonStein);
        panel2.add(buttonPapier);
        panel.add(panel2);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		return panel;
	}
    
	private JPanel createSettingsSpieler() {
		JPanel panel=new JPanel();
		
		name=new PlaceholderTextField("Name: ");
	    spielertag=new PlaceholderTextField("Spielertag: ");
	    tierSub=new PlaceholderTextField("TierSub: ");
	    farbe=new PlaceholderTextField("Farbe: ");     //rotationalChooser
		
	    closeSettingsSpieler=new JButton();
	    applySettingsSpieler=new JButton();
	    resetSettingsSpieler=new JButton();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new BorderLayout());
	    JLabel label= new JLabel("Settings Spieler");
	    label.setFont(new Font("Arial", Font.BOLD, 50));
	    label.setForeground(Color.WHITE);
	    label.setAlignmentX(Component.CENTER_ALIGNMENT);
	    label.setHorizontalAlignment(SwingConstants.CENTER); // <-- wichtig für Inhalt!
	    label.setMaximumSize(new Dimension(Integer.MAX_VALUE, label.getPreferredSize().height));
	    label.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
	    panel.add(label, BorderLayout.NORTH);
	    JPanel panel3=new JPanel();
	    panel3.setBackground(Color.BLACK);
	    panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
	    panel3.add(name);
	    panel3.add(spielertag);
	    panel3.add(tierSub);
	    panel3.add(farbe);
	    panel.add(panel3, BorderLayout.CENTER);
	    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		Font font2 = new Font("Arial", Font.PLAIN, 60);
		closeListeSpieler = new JButton("X");
		resetAll = new JButton("reset");
		applyListeSpieler = new JButton("add");
		closeListeSpieler.setFont(font2);
		resetAll.setFont(font2);
		applyListeSpieler.setFont(font2);
		panel2.add(closeListeSpieler, BorderLayout.WEST);
		panel2.add(resetAll, BorderLayout.EAST);
		panel2.add(applyListeSpieler, BorderLayout.CENTER);
		panel2.setBackground(Color.DARK_GRAY);
		panel2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(panel2, BorderLayout.SOUTH);
		return panel;
	}
	
	private JPanel createListeSpieler() {
		JPanel panel= new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new BorderLayout());
	    JLabel label= new JLabel("Alle Spieler");
	    label.setFont(new Font("Arial", Font.BOLD, 50));
	    label.setForeground(Color.WHITE);
	    label.setAlignmentX(Component.CENTER_ALIGNMENT);
	    label.setHorizontalAlignment(SwingConstants.CENTER); // <-- wichtig für Inhalt!
	    label.setMaximumSize(new Dimension(Integer.MAX_VALUE, label.getPreferredSize().height));
	    label.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
	    panel.add(label, BorderLayout.NORTH);
	    JPanel panel3=new JPanel();
	    panel3.setBackground(Color.BLACK);
	    panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
	    if (mitspieler!=null) {
	    mitspieler.forEach((e)->{e.setFont(new Font("Arial", Font.PLAIN, 20));e.setAlignmentX(Component.CENTER_ALIGNMENT); panel3.add(e);});
	    mitspieler.forEach((e) -> {
	        e.setFont(new Font("Arial", Font.PLAIN, 20));
	        e.setAlignmentX(Component.CENTER_ALIGNMENT);
	        e.setMaximumSize(new Dimension(Integer.MAX_VALUE, e.getPreferredSize().height));
	        panel.add(e);
	    });}
	    panel.add(panel3, BorderLayout.CENTER);
	    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		Font font2 = new Font("Arial", Font.PLAIN, 60);
		closeListeSpieler = new JButton("X");
		resetAll = new JButton("reset");
		applyListeSpieler = new JButton("add");
		closeListeSpieler.setFont(font2);
		resetAll.setFont(font2);
		applyListeSpieler.setFont(font2);
		panel2.add(closeListeSpieler, BorderLayout.WEST);
		panel2.add(resetAll, BorderLayout.EAST);
		panel2.add(applyListeSpieler, BorderLayout.CENTER);
		panel2.setBackground(Color.DARK_GRAY);
		panel2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(panel2, BorderLayout.SOUTH);
		return panel;
	}
	private JPanel createSettingsSpielfeld() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.WHITE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel label1 = new JLabel("Spielfeld Einstellungen");
		label1.setForeground(Color.WHITE);
		label1.setAlignmentX(Component.LEFT_ALIGNMENT);
		label1.setFont(new Font("Arial", Font.BOLD, 24));
		panel.add(Box.createRigidArea(new Dimension(0, 25)));
		panel.add(label1);
		panel.add(Box.createRigidArea(new Dimension(0, 25)));

		Font font = new Font("Arial", Font.BOLD, 20);

		// Verwende jetzt PlaceholderTextField statt JTextField
		
		x.setFont(font);
		y.setFont(font);
		pruefLaenge.setFont(font);
		payToWin.setFont(font);

		x.setAlignmentX(Component.LEFT_ALIGNMENT);
		y.setAlignmentX(Component.LEFT_ALIGNMENT);
		pruefLaenge.setAlignmentX(Component.LEFT_ALIGNMENT);
		payToWin.setAlignmentX(Component.LEFT_ALIGNMENT);

		panel.add(x);
		panel.add(Box.createRigidArea(new Dimension(0, 25)));
		panel.add(y);
		panel.add(Box.createRigidArea(new Dimension(0, 25)));
		panel.add(pruefLaenge);
		panel.add(Box.createRigidArea(new Dimension(0, 25)));
		panel.add(payToWin);
		panel.add(Box.createRigidArea(new Dimension(0, 25)));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		Font font2 = new Font("Arial", Font.PLAIN, 60);
		closeSpielfeldSettings = new JButton("X");
		applySpielfeldSettings = new JButton("--->");
		closeSpielfeldSettings.setFont(font2);
		applySpielfeldSettings.setFont(font2);
		panel2.add(closeSpielfeldSettings, BorderLayout.WEST);
		panel2.add(applySpielfeldSettings, BorderLayout.EAST);
		panel2.setBackground(Color.DARK_GRAY);
		panel2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(panel2);
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		return panel;
	}
	private JPanel createTitelbildPanel() {
		JPanel buttonPanel = new BackgroundPanel("/Users/anwender/Downloads/Play-tic-tac-toe-with-virus-1.png"); // Pfad zum Bild
		buttonPanel.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        JPanel settings=new JPanel();
        JPanel customize=new JPanel();
        customize.setLayout(new BoxLayout(customize, BoxLayout.Y_AXIS));
        spielfeldSettings=new JButton("Spielfeld");
        spielerSettings=new JButton("Spieler");
        JLabel setting=new JLabel("SETTINGS");
        setting.setForeground(Color.WHITE);
        customize.add(setting);
        customize.add(spielfeldSettings);
        customize.add(spielerSettings);
        settings.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        settings.add(customize, gbc);
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.insets = new Insets(0, 0, 0, 20); // Rechts 20px Abstand zum nächsten Panel
        settings.add(customize, gbc);
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 400, 0, 0); // Links 20px Abstand vom vorherigen Panel
//        saves.setForeground(Color.WHITE);
        settings.add(saves, gbc);
        playButton=new JButton("play");
        playButton.setMargin(new Insets(10, 20, 10, 20));
        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.anchor = GridBagConstraints.CENTER;
        buttonPanel.add(playButton, gbcButton);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout());
        settings.setBackground(Color.BLACK);
        customize.setBackground(Color.BLACK);
        settings.setForeground(Color.WHITE);
        customize.setForeground(Color.WHITE);
        JLabel titel = new JLabel("Willkommen zu TikTakToe - immersive.2.0");
        titel.setFont(new Font("Arial", Font.BOLD, 24));
        titel.setForeground(Color.WHITE);
        panel.add(titel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(settings, BorderLayout.SOUTH);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return panel;
	}

	public void createSpielPanel(JButton[][] buttons) {
	    // Spielfeld-Panel vorbereiten
	    JPanel spielfeldPanel = new JPanel();
	    int yLim = buttons.length;             // Anzahl der Zeilen (Y-Achse)
	    int xLim = buttons[0].length;
	    spielfeldPanel.setLayout(new GridLayout(yLim, xLim, 1, 1)); // ACHTUNG: yLim und xLim vertauscht!
	    
	    for (JButton[] row : buttons) {
	        for (JButton btn : row) {
	            spielfeldPanel.add(btn);
	        }
	    }

	    // LayeredPane als Container
	    JLayeredPane layeredPane = new JLayeredPane();
	    layeredPane.setPreferredSize(new Dimension(800, 800));

	    // Spielfeld Panel platzieren
	    spielfeldPanel.setBounds(0, 0, 800, 800); // exakt platzieren
	    layeredPane.add(spielfeldPanel, Integer.valueOf(0)); // Hintergrund

	 // Overlay mit Close-Button im Spielfeld
	    JPanel overlay = new JPanel(null); // kein Layout → manuelle Platzierung
	    overlay.setOpaque(false);
	    overlay.setBounds(0, 0, 800, 800);

	    // Neuen Button speziell für das Spielfeld
	    closeSpielfeld.setBounds(10, 740, 120, 30); // Position
	    overlay.add(closeSpielfeld);
	    layeredPane.add(overlay, Integer.valueOf(1)); // Vordergrund

	    // In Kartencontainer einfügen
	    kartenContainer.add(layeredPane, "Spielfeld");
	    cardLayout.show(kartenContainer, "Spielfeld");
	}
    public void sperreAlleButtons(JButton[][] buttons, Spielfeld spielfeld) {
	    for (int i = 0; i < spielfeld.limy; i++) {
	        for (int j = 0; j < spielfeld.limx; j++) {
	            buttons[i][j].setEnabled(false);
	        }
	    }
	}
    public void entsperreAlleButtons(JButton[][] buttons, Spielfeld spielfeld) {
	    for (int i = 0; i < spielfeld.limy; i++) {
	        for (int j = 0; j < spielfeld.limx; j++) {
	            buttons[i][j].setEnabled(true);
	        }
	    }
	}

    @SuppressWarnings({ "unused" })
	private JPanel createSiegerPanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Spiel vorbei! Willst du nochmal spielen?");
        JButton jaButton = new JButton("Ja");
        JButton neinButton = new JButton("Nein");

        // Listener kannst du später anpassen
        jaButton.addActionListener(e -> zeigePanel("Customizing"));
        neinButton.addActionListener(e -> System.exit(0));

        panel.add(label);
        panel.add(jaButton);
        panel.add(neinButton);
        return panel;
    }
    public void updateTitelbild() {
    	for (Component comp : kartenContainer.getComponents()) {
    	    if (kartenContainer.getLayout() instanceof CardLayout && "Titelbild".equals(kartenContainer.getClientProperty(comp))) {
    	        kartenContainer.remove(comp);
    	        break;
    	    }
    	}
    	kartenContainer.add(createTitelbildPanel(), "Titelbild");
    	kartenContainer.revalidate();
    	kartenContainer.repaint();
    	updateTitelbild();
    }
    public void zeigePanel(String name) {
        cardLayout.show(kartenContainer, name);
    }
//    @SuppressWarnings("deprecation")
//	public void addSpielfeld(JPanel panel) {
//    	kartenContainer.add(panel, "Spielfeld");
//    	 cardLayout.show(kartenContainer, "Spielfeld");
//    }
    public void aktualisiereSavesListe(String[] namen) {
        saves.removeAllItems();
        for (String name : namen) {
            saves.addItem(name);
        }
        saves.addItem("Neues");
    }

}
