package tutorialVideoÜbungen4;
import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class CustomBorderButtonDemo extends JFrame {

    private static final long serialVersionUID = 1L;

	public CustomBorderButtonDemo() {
        setTitle("Button mit Rahmen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);

        JButton textButton = new JButton("");
        textButton.setContentAreaFilled(false); // kein Hintergrund
        textButton.setOpaque(false);
        textButton.setForeground(Color.WHITE);  // Textfarbe
    	textButton.setPreferredSize(new Dimension(120, 100));

        // Rahmen: Farbe und Dicke
        textButton.setBorder(new LineBorder(Color.CYAN, 3)); // 3px cyan

        panel.add(textButton);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomBorderButtonDemo().setVisible(true));
    }
}



