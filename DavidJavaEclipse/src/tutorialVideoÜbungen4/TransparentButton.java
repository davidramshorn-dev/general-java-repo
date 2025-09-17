package tutorialVideoÜbungen4;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.Timer;

class TransparentButton extends JButton {

    private static final long serialVersionUID = 1L;
	private float alpha = 1.0f; // Transparenz für Klick-Effekt

    public TransparentButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(false);
        setBorder(null);         // kein sichtbarer Rahmen
        setFocusPainted(false);  // keine Fokus-Markierung
        setBackground(Color.WHITE);
        setAlpha(0.0f);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        // Transparenz setzen
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        // Hintergrund manuell malen
        g2.setColor(getBackground());
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g2); // Text zeichnen
        g2.dispose();
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }

    // Kurzer Klick-Effekt
    public void flash() {
        setAlpha(0.25f);
        Timer timer = new Timer(150, e -> setAlpha(0.0f));
        timer.setRepeats(false);
        timer.start();
    }
}
