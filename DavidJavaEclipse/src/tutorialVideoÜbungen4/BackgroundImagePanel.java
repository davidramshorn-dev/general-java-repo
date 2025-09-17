package tutorialVideoÜbungen4;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.JPanel;

public class BackgroundImagePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private Icon backgroundImage;

    public BackgroundImagePanel(Icon image) {
        this.backgroundImage = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Icon auf die volle Panelgröße skalieren
            backgroundImage.paintIcon(this, g, 0, 0);
        }
    }
}
