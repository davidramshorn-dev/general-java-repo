package tutorialVideoÜbungen4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HoverCursorExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hover Cursor Beispiel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JButton button = new JButton("Hover mich");

            // MouseListener für Hover
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                 @Override
               public void mouseExited(MouseEvent e) {
                    button.setCursor(Cursor.getDefaultCursor());
                }
            });

            frame.add(button);
            frame.setVisible(true);
        });
    }
}

