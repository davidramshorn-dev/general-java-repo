package geschenkMama;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        // Bild laden
        backgroundImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Bild an die Panelgröße anpassen
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}