package tiktaktoeExtended;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Queue;

import javax.swing.*;


public class TransparentButtonDemo2 extends JFrame {    private static final long serialVersionUID = 1L;

public JPanel view;
public CardLayout cardlayout;

public JButton[][] buttons;

public JButton[][] getButtons() {
	return buttons;
}
public void setButtons(JButton[][] buttons) {
	this.buttons = buttons;
}

//homeScreen
JPopupMenu saves;
TransparentButton spielerSettings;
TransparentButton spielfeldSettings;
TransparentButton playButton;
TransparentButton button;

public JPopupMenu getSaves(){
	return saves;
}
public void setSaves(JPopupMenu saves){
	this.saves= saves;
}
public TransparentButton getSpielerSettings(){
	return spielerSettings;
}
public TransparentButton getSpielfeldSettings(){
	return spielfeldSettings;
}
public TransparentButton getPlayButton(){
	return playButton;
}
public TransparentButton getButton() {
	return button;
}

// SpielfeldSettings
PlaceholderTextField x;
PlaceholderTextField y;
PlaceholderTextField pruefLaenge;
PlaceholderTextField payToWin;
TransparentButton closeSpielfeldSettings;
TransparentButton applySpielfeldSettings;

public PlaceholderTextField getx() {
	return x;
}
public void setPx(PlaceholderTextField x) {
	this.x = x;
}
public PlaceholderTextField getPy() {
	return y;
}
public void setPy(PlaceholderTextField y) {
	this.y = y;
}
public PlaceholderTextField getPpruefLaenge() {
	return pruefLaenge;
}
public void setPpruefLaenge(PlaceholderTextField pruefLaenge) {
	this.pruefLaenge = pruefLaenge;
}
public PlaceholderTextField getPayToWin() {
	return payToWin;
}
public void setPpayToWin(PlaceholderTextField payToWin) {
	this.payToWin = payToWin;
}
public JButton getCloseSpielfeldSettings() {
	return closeSpielfeldSettings;
}
public void setCloseSpielfeldSettings(TransparentButton closeSpielfeldSettings) {
	this.closeSpielfeldSettings = closeSpielfeldSettings;
}
public JButton getApplySpielfeldSettings() {
	return applySpielfeldSettings;
}
public void setApplySpielfeldSettings(TransparentButton applySpielfeldSettings) {
	this.applySpielfeldSettings = applySpielfeldSettings;
}

// ListeSpieler
TransparentButton closeListeSpieler;
TransparentButton applyListeSpieler;
TransparentButton resetAll;
JPanel content;

public TransparentButton getResetAll() {
	return resetAll;
}
public void setResetAll(TransparentButton resetAll) {
	this.resetAll = resetAll;
}
public TransparentButton getCloseListeSpieler() {
	return closeListeSpieler;
}
public void setCloseListeSpieler(TransparentButton closeListeSpieler) {
	this.closeListeSpieler = closeListeSpieler;
}
public TransparentButton getApplyListeSpieler() {
	return applyListeSpieler;
}
public void setApplyListeSpieler(TransparentButton applyListeSpieler) {
	this.applyListeSpieler = applyListeSpieler;
}
public JPanel getContent() {
	return content;
}
public void setContent(JPanel content) {
	this.content = content;
}

//SettingsSpieler
PlaceholderTextField name;
PlaceholderTextField spielertag;
PlaceholderTextField tierSub;
TransparentButton farbe;
JPopupMenu menu2;
TransparentButton closeSettingsSpieler;
TransparentButton applySettingsSpieler;
//
//public JTextField getName() {
//	return name;
//}
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
public TransparentButton getFarbe() {
	return farbe;
}
public void setFarbe(TransparentButton farbe) {
	this.farbe = farbe;
}
public TransparentButton getCloseSettingsSpieler() {
	return closeSettingsSpieler;
}
public void setCloseSettingsSpieler(TransparentButton closeSettingsSpieler) {
	this.closeSettingsSpieler = closeSettingsSpieler;
}
public TransparentButton getApplySettingsSpieler() {
	return applySettingsSpieler;
}
public void setApplySettingsSpieler(TransparentButton applySettingsSpieler) {
	this.applySettingsSpieler = applySettingsSpieler;
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
TransparentButton schere;
TransparentButton stein;
TransparentButton papier;
TransparentButton closeHerausforderung;    //Automatisch verloren
ModLabel spielerAmZug;

public TransparentButton getSchere() {
	return schere;
}
public void setSchere(TransparentButton schere) {
	this.schere = schere;
}
public JButton getStein() {
	return stein;
}
public void setStein(TransparentButton stein) {
	this.stein = stein;
}
public TransparentButton getPapier() {
	return papier;
}
public void setPapier(TransparentButton papier) {
	this.papier = papier;
}
public TransparentButton getCloseHerausforderung() {
	return closeHerausforderung;
}
public void setCloseHerausforderung(TransparentButton closeHerausforderung) {
	this.closeHerausforderung = closeHerausforderung;
}
public ModLabel getSpielerAmZug() {
	return spielerAmZug;
}
public void setSpielerAmZug(ModLabel spielerAmZug) {
	this.spielerAmZug = spielerAmZug;
}

// ZeigeSieger
TransparentButton revanche;
TransparentButton closeZeigeSieger;
ModLabel zeigeSieger;

public TransparentButton getRevanche() {
	return revanche;
}
public void setRevanche(TransparentButton revanche) {
	this.revanche = revanche;
}
public TransparentButton getCloseZeigeSieger() {
	return closeZeigeSieger;
}
public void setCloseZeigeSieger(TransparentButton closeZeigeSieger) {
	this.closeZeigeSieger = closeZeigeSieger;
}
public ModLabel getZeigeSieger() {
	return zeigeSieger;
}
public void setZeigeSieger(ModLabel zeigeSieger) {
	this.zeigeSieger = zeigeSieger;
}

@SuppressWarnings("unused")
public TransparentButtonDemo2() {
	
    setTitle("Transparenter Button mit Click-Effekt");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(4000, 2375);
    Font global=new Font("Arial", Font.BOLD, 10);
    
    view=new JPanel();
    getContentPane().add(view); 
//    view.setSize(4000, 2375);
    cardlayout=new CardLayout();
    view.setLayout(cardlayout);
    
    
    ImageIcon image=new ImageIcon("img/homeScreen.png");
    spielfeldSettings=new TransparentButton("", 1672, 1798, 650, 173);
    playButton=new TransparentButton("", 1766, 990, 484, 150);
    spielerSettings=new TransparentButton("", 1745, 1980, 520, 178);
    PanelBgImg panel = new PanelBgImg(image);
    panel.add(spielerSettings);
    panel.add(playButton);
    panel.add(spielfeldSettings);
    button = new TransparentButton("", 3265, 1840, 300, 100);
    saves = new JPopupMenu();
    button.addActionListener(e -> saves.show(button, 0, button.getHeight()));
    
//
//    JMenuItem item1 = new JMenuItem("Option 1");
//    item1.addActionListener(e -> System.out.println("Option 1 gewählt"));
//    menu.add(item1);
//
//    JMenuItem item2 = new JMenuItem("Option 2");
//    item2.addActionListener(e -> System.out.println("Option 2 gewählt"));
//    menu.add(item2);
//
    
    panel.add(button);
    view.add(panel, "homeScreen");
    
    //spielfeldSettings
    ImageIcon image2=new ImageIcon("img/spielfeldSettings.png");
    PanelBgImg panel2 = new PanelBgImg(image2);
    applySpielfeldSettings=new TransparentButton("", 3370, 1910, 530, 300);
    closeSpielfeldSettings=new TransparentButton("",100, 1895, 300, 330);
    x=new PlaceholderTextField("DEFAULT - 4", 1870, 812, 560, 225, 40);
    y=new PlaceholderTextField("DEFAULT - 4", 1780, 1041, 650, 225, 40);
    pruefLaenge=new PlaceholderTextField("DEFAULT - 3", 1430, 1268, 1000, 225, 40);
    payToWin=new PlaceholderTextField("DEFAULT - false", 1230, 1495, 1200, 225, 40);
    x.setFont(global);
    y.setFont(global);
    pruefLaenge.setFont(global);
    payToWin.setFont(global);
    panel2.add(x);
    panel2.add(y);
    panel2.add(pruefLaenge);
    panel2.add(payToWin);
    panel2.add(applySpielfeldSettings);
    panel2.add(closeSpielfeldSettings);
    view.add(panel2, "spielfeldSettings");
    
    //alleSpieler
    ImageIcon image3=new ImageIcon("img/alleSpieler.png");
    PanelBgImg panel3 = new PanelBgImg(image3);
    applyListeSpieler=new TransparentButton("", 2950, 1960, 870, 300);
    closeListeSpieler=new TransparentButton("",100, 1945, 300, 330);
    resetAll=new TransparentButton("",1590, 1950, 630, 330);
    panel3.add(closeListeSpieler);
    panel3.add(applyListeSpieler);
    panel3.add(resetAll);
    ScrollPanel scroll = new ScrollPanel(430, 780, 3185, 1045);

    content = new JPanel();
    content.setOpaque(false);
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    scroll.setViewportView(content);
    panel3.add(scroll);
    view.add(panel3, "alleSpieler");
    
    //spielerSettings
    ImageIcon image4=new ImageIcon("img/spielerSettings.png");
    PanelBgImg panel4 = new PanelBgImg(image4);
    applySettingsSpieler=new TransparentButton("", 3370, 1910, 530, 300);
    closeSettingsSpieler=new TransparentButton("",100, 1895, 300, 330);
    name=new PlaceholderTextField("DEFAULT - Spieler", 1050, 812, 860, 225, 40);
    spielertag=new PlaceholderTextField("DEFAULT - Symbol", 1200, 1041, 950, 225, 40);
    farbe = new TransparentButton("Farbe auswählen", 1080, 1268, 1300, 225, 1.0f, Color.cyan);
    farbe.setFont(global);
    menu2 = new JPopupMenu();
    
    farbe.addActionListener(e -> menu2.show(farbe, 0, farbe.getHeight()));
    tierSub=new PlaceholderTextField("DEFAULT - 1000", 1000, 1495, 1500, 225, 40);
    name.setFont(global);
    spielertag.setFont(global);
    tierSub.setFont(global);
    farbe.setFont(global);
    panel4.add(name);
    panel4.add(spielertag);
    panel4.add(farbe);
    panel4.add(tierSub);
    panel4.add(applySettingsSpieler);
    panel4.add(closeSettingsSpieler);
    view.add(panel4, "spielerSettings");
    
  //gewinnerScreen
    ImageIcon image5=new ImageIcon("img/gewinnerScreen.png");
    PanelBgImg panel5 = new PanelBgImg(image5);
    revanche=new TransparentButton("", 1220, 1960, 1575, 300);
    closeZeigeSieger=new TransparentButton("",100, 1945, 300, 330);
    panel5.add(revanche);
    panel5.add(closeZeigeSieger);
    zeigeSieger=new ModLabel("David",1370, 1078, 1245, 225, 180);
    zeigeSieger.setHorizontalAlignment(SwingConstants.CENTER);
    zeigeSieger.setForeground(Color.white);
    zeigeSieger.setFont(global);
    panel5.add(zeigeSieger);
    view.add(panel5, "gewinnerScreen");
    
    //herausforderungScreen
    ImageIcon image6=new ImageIcon("img/herausforderungScreen.png");
    PanelBgImg panel6= new PanelBgImg(image6);
    stein=new TransparentButton("", 1635, 930, 610, 990);
    closeHerausforderung=new TransparentButton("",100, 1895, 300, 330);
    papier=new TransparentButton("", 2785, 930, 780, 990);
    schere=new TransparentButton("",385, 930, 780, 990);
    panel6.add(stein);
    panel6.add(closeHerausforderung);
    panel6.add(papier);
    panel6.add(schere);
    spielerAmZug=new ModLabel("David's Zug",1370, 1998, 1245, 225, 180);
    spielerAmZug.setHorizontalAlignment(SwingConstants.CENTER);
    spielerAmZug.setForeground(Color.black);
    spielerAmZug.setFont(global);
    panel6.add(spielerAmZug);
    view.add(panel6, "herausforderungScreen");

    zeigePanel("herausforderungScreen");
}

public void zeigePanel(String name) {
    cardlayout.show(view, name);
}
}

