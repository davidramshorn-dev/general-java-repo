package tutorialVideoÜbungen4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SquareButtonGrid {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Quadratische Buttons (korrigiert)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 600);

            JPanel centerPanel = new JPanel(new GridBagLayout());
            frame.add(centerPanel, BorderLayout.CENTER);

            int rows = 20; // teste mit unterschiedlichen Werten
            int cols = 8;

            JPanel gridPanel = new JPanel(new GridLayout(rows, cols, 5, 5)) {
                private static final long serialVersionUID = 1L;

				@Override
                public Dimension getPreferredSize() {
                    // verfügbare Fläche im äußeren Container
                    Container p = getParent();
                    int availW = 600;
                    int availH = 600;
                    if (p != null) {
                        availW = p.getWidth();
                        availH = p.getHeight();
                    } else {
                        // Fallback falls noch kein Parent vorhanden ist
                        Window w = SwingUtilities.getWindowAncestor(this);
                        if (w != null) {
                            Dimension d = w.getSize();
                            availW = d.width;
                            availH = d.height;
                        }
                    }
                    // Berechne Zellgröße so, dass Zellen quadratisch sind
                    int cellSize = Math.max(1, Math.min(availW / Math.max(1, cols), availH / Math.max(1, rows)));
                    return new Dimension(cellSize * cols, cellSize * rows);
                }
            };

            // Buttons hinzufügen (keine eigene preferredSize nötig)
            for (int i = 0; i < rows * cols; i++) {
                JButton b = new JButton(String.valueOf(i + 1));
                b.setFocusable(false);
                gridPanel.add(b);
            }

            // Damit das gridPanel bei Größenänderung neu berechnet wird
            centerPanel.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    gridPanel.revalidate();
                }
            });

            centerPanel.add(gridPanel); // zentriert durch GridBagLayout

            frame.setVisible(true);

            // initiales Revalidate/Pack, damit preferredSize greift
            SwingUtilities.invokeLater(() -> {
                gridPanel.revalidate();
                frame.repaint();
            });
        });
    }
}


