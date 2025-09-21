package tutorialVideoÜbungen4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.HierarchyEvent;

import javax.swing.*;

public class TransparentButtonDemo2 extends JFrame {    private static final long serialVersionUID = 1L;

public TransparentButtonDemo2() {
	
    setTitle("Transparenter Button mit Click-Effekt");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(4000, 2375);
    setLocationRelativeTo(null);
    
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
//    add(panel);
    
    //spielfeldSettings
    ImageIcon image2=new ImageIcon("img/spielfeldSettings.png");
    int[][] origBoundsForButtons2 = {
            {3370, 1910, 530, 300},   // Button 1
            {100, 1895, 300, 330},   // Button 2
        };
    PanelBgImg panel2 = new PanelBgImg(image2);
    Font font = new Font("Arial", Font.BOLD, 40);
    PlaceholderTextField text=new PlaceholderTextField("DEFAULT - 4", 1870, 812, 560, 225);
    PlaceholderTextField text2=new PlaceholderTextField("DEFAULT - 4", 1780, 1041, 650, 225);
    PlaceholderTextField text3=new PlaceholderTextField("DEFAULT - 3", 1430, 1268, 1000, 225);
    PlaceholderTextField text4=new PlaceholderTextField("DEFAULT - false", 1230, 1495, 1200, 225);
    text.setFont(font);
    text2.setFont(font);
    text3.setFont(font);
    text4.setFont(font);
    panel2.add(text);
    panel2.add(text2);
    panel2.add(text3);
    panel2.add(text4);
    panel2=addButtons(origBoundsForButtons2, panel2);
//    add(panel2);
    
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
    add(panel3);

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

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new TransparentButtonDemo2().setVisible(true));
}}

