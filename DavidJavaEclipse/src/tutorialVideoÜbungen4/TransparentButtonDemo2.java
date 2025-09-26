package tutorialVideoÜbungen4;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class TransparentButtonDemo2 extends JFrame {    private static final long serialVersionUID = 1L;

public JPanel view;
public CardLayout cardlayout;

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
    
    //homeScreen
    ImageIcon image=new ImageIcon("img/homeScreen.png");
    int[][] origBoundsForButtons = {
            {1672, 1798, 650, 173},   // Button 1
            {1766, 990, 484, 150},   // Button 2
            {1745, 1980, 520, 178}    // Button 3
        };
    PanelBgImg panel = new PanelBgImg(image);
    addButtons(origBoundsForButtons, panel);
    TransparentButton button = new TransparentButton("", 3265, 1840, 300, 100);
    JPopupMenu menu = new JPopupMenu();

    JMenuItem item1 = new JMenuItem("Option 1");
    item1.addActionListener(e -> System.out.println("Option 1 gewählt"));
    menu.add(item1);

    JMenuItem item2 = new JMenuItem("Option 2");
    item2.addActionListener(e -> System.out.println("Option 2 gewählt"));
    menu.add(item2);

    button.addActionListener(e -> menu.show(button, 0, button.getHeight()));
    
    panel.add(button);
    view.add(panel, "homeScreen");
    
    //spielfeldSettings
    ImageIcon image2=new ImageIcon("img/spielfeldSettings.png");
    int[][] origBoundsForButtons2 = {
            {3370, 1910, 530, 300},   // Button 1
            {100, 1895, 300, 330},   // Button 2
        };
    PanelBgImg panel2 = new PanelBgImg(image2);
    PlaceholderTextField text=new PlaceholderTextField("DEFAULT - 4", 1870, 812, 560, 225, 40);
    PlaceholderTextField text2=new PlaceholderTextField("DEFAULT - 4", 1780, 1041, 650, 225, 40);
    PlaceholderTextField text3=new PlaceholderTextField("DEFAULT - 3", 1430, 1268, 1000, 225, 40);
    PlaceholderTextField text4=new PlaceholderTextField("DEFAULT - false", 1230, 1495, 1200, 225, 40);
    text.setFont(global);
    text2.setFont(global);
    text3.setFont(global);
    text4.setFont(global);
    panel2.add(text);
    panel2.add(text2);
    panel2.add(text3);
    panel2.add(text4);
    panel2=addButtons(origBoundsForButtons2, panel2);
    view.add(panel2, "spielfeldSettings");
    
    //alleSpieler
    ImageIcon image3=new ImageIcon("img/alleSpieler.png");
    int[][] origBoundsForButtons3 = {
            {2950, 1960, 870, 300},   // Button 1
            {100, 1945, 300, 330},   // Button 2
            {1590, 1950, 630, 330},   // Button 3
    };
    PanelBgImg panel3 = new PanelBgImg(image3);
    panel3=addButtons(origBoundsForButtons3, panel3);
    ScrollPanel scroll = new ScrollPanel(430, 780, 3185, 1045);

    JPanel content = new JPanel();
    content.setOpaque(false);
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    PlayerPanel player=new PlayerPanel("Spieler 1");
    PlayerPanel player2=new PlayerPanel("Spieler 2");
    content.add(player);
    content.add(player2);
    scroll.setViewportView(content);
    panel3.add(scroll);
    view.add(panel3, "alleSpieler");
    
    //spielerSettings
    ImageIcon image4=new ImageIcon("img/spielerSettings.png");
    int[][] origBoundsForButtons4 = {
            {3370, 1910, 530, 300},   // Button 1
            {100, 1895, 300, 330},   // Button 2
        };
    PanelBgImg panel4 = new PanelBgImg(image4);
    PlaceholderTextField text1=new PlaceholderTextField("DEFAULT - Spieler", 1050, 812, 860, 225, 40);
    PlaceholderTextField text21=new PlaceholderTextField("DEFAULT - Symbol", 1200, 1041, 950, 225, 40);
    TransparentButton button2 = new TransparentButton("Farbe auswählen", 1080, 1268, 1300, 225, 1.0f, Color.cyan);
    button2.setFont(global);
    JPopupMenu menu2 = new JPopupMenu();

    JMenuItem item12 = new JMenuItem("Option 1");
    item12.setFont(global);
    item12.addActionListener(e -> System.out.println("Option 1 gewählt"));
    menu2.add(item12);

    JMenuItem item22 = new JMenuItem("Option 2");
    item22.setFont(global);
    item22.addActionListener(e -> System.out.println("Option 2 gewählt"));
    menu2.add(item22);

    button2.addActionListener(e -> menu2.show(button2, 0, button2.getHeight()));
    PlaceholderTextField text41=new PlaceholderTextField("DEFAULT - 1000", 1000, 1495, 1500, 225, 40);
    text1.setFont(global);
    text21.setFont(global);
    text41.setFont(global);
    panel4.add(text1);
    panel4.add(text21);
    panel4.add(button2);
    panel4.add(text41);
    panel4=addButtons(origBoundsForButtons4, panel4);
    view.add(panel4, "spielerSettings");
    
  //gewinnerScreen
    ImageIcon image5=new ImageIcon("img/gewinnerScreen.png");
    int[][] origBoundsForButtons5 = {
            {1220, 1960, 1575, 300},   // Button 1
            {100, 1945, 300, 330},   // Button 2
        };
    PanelBgImg panel5 = new PanelBgImg(image5);
    addButtons(origBoundsForButtons5, panel5);
    ModLabel label=new ModLabel("David",1370, 1078, 1245, 225, 180);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setForeground(Color.white);
    label.setFont(global);
    panel5.add(label);
    view.add(panel5, "gewinnerScreen");
    
    //herausforderungScreen
    ImageIcon image6=new ImageIcon("img/herausforderungScreen.png");
    int[][] origBoundsForButtons6 = {
            {1635, 930, 610, 990},   // Button 1
            {100, 1895, 300, 330},   // Button 2
            {2785, 930, 780, 990},   // Button 1
            {385, 930, 780, 990},   // Button 2
        };
    PanelBgImg panel6= new PanelBgImg(image6);
    addButtons(origBoundsForButtons6, panel6);
    ModLabel label2=new ModLabel("David's Zug",1370, 1998, 1245, 225, 180);
    label2.setHorizontalAlignment(SwingConstants.CENTER);
    label2.setForeground(Color.black);
    label2.setFont(global);
    panel6.add(label2);
    view.add(panel6, "herausforderungScreen");

    zeigePanel("spielfeldSettings");
}

private PanelBgImg addButtons(int[][] origBounds, PanelBgImg panel) {
	 for (int i = 0; i < origBounds.length; i++) {
         int x = origBounds[i][0];
         int y = origBounds[i][1];
         int w = origBounds[i][2];
         int h = origBounds[i][3];

         TransparentButton button = new TransparentButton("", x, y, w, h);
         panel.add(button);
     }
	return panel;
}
public void zeigePanel(String name) {
    cardlayout.show(view, name);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new TransparentButtonDemo2().setVisible(true));
}}

