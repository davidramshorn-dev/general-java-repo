package tutorialVideoÜbungen4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TransparentButtonDemo2 extends JFrame {

    public TransparentButtonDemo2() {
    	
        setTitle("Transparenter Button mit Click-Effekt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(4000, 2375);
        setLocationRelativeTo(null);
        
        ImageIcon image=new ImageIcon("img/Lila_Bunt_3D_TicTacToe.png");
        MainPanel panel = new MainPanel(image);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TransparentButtonDemo2().setVisible(true));
    }
}

