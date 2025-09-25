package tutorialVideoÜbungen4;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.Timer;
public class TransparentButton extends JButton implements ModComponent {
    private static final long serialVersionUID = 1L;
    private float alpha = 0.0f;
    private float alphaOrig = 0.0f;
    private final double xOrig, yOrig, widthOrig, heightOrig,sizeTextOrig;

    public TransparentButton(String text, double xOrig, double yOrig, double widthOrig, double heightOrig) {
        super(text);
        this.xOrig = xOrig;
        this.yOrig = yOrig;
        this.widthOrig = widthOrig;
        this.heightOrig = heightOrig;
        this.sizeTextOrig=0;
        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setBackground(Color.WHITE);
        setAlpha(alpha);
        addHoverEffect();
        addActionListener(e -> this.flash());

        // Setze initiale Bounds sofort
        setBounds((int) xOrig, (int) yOrig, (int) widthOrig, (int) heightOrig);
    }
    
    public TransparentButton(String text, double xOrig, double yOrig, double widthOrig, double heightOrig, Color color) {
        super(text);
        this.xOrig = xOrig;
        this.yOrig = yOrig;
        this.widthOrig = widthOrig;
        this.heightOrig = heightOrig;
        this.sizeTextOrig=0;
        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setBackground(color);
        setAlpha(alpha);
        addHoverEffect();
        addActionListener(e -> this.flash());

        // Setze initiale Bounds sofort
        setBounds((int) xOrig, (int) yOrig, (int) widthOrig, (int) heightOrig);
    }
    
    public TransparentButton(String text, double xOrig, double yOrig, double widthOrig, double heightOrig, float alphaOrig, Color color) {
        super(text);
        this.xOrig = xOrig;
        this.yOrig = yOrig;
        this.widthOrig = widthOrig;
        this.heightOrig = heightOrig;
        this.alphaOrig=alphaOrig;
        this.sizeTextOrig=0;
        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setBackground(color);
        setAlpha(alphaOrig);
        addHoverEffect();
        addActionListener(e -> this.flash());

        // Setze initiale Bounds sofort
        setBounds((int) xOrig, (int) yOrig, (int) widthOrig, (int) heightOrig);
    }

    @Override public double getxOrig(){ return xOrig;}
    @Override public double getyOrig(){ return yOrig;}
    @Override public double getWidthOrig(){ return widthOrig;}
    @Override public double getHeightOrig(){ return heightOrig;}
    @Override public double getSizeTextOrig() {	return sizeTextOrig;}
    @Override public void setSizeText(float x) {Font current = this.getFont(); this.setFont(current.deriveFont(x));}

    @Override
    protected void paintComponent(Graphics g){ Graphics2D g2 = (Graphics2D) g.create();
    // Transparenz setzen
    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    // Hintergrund manuell malen
    g2.setColor(getBackground());
    g2.fillRect(0, 0, getWidth(), getHeight());
    super.paintComponent(g2); // Text zeichnen
    g2.dispose(); }

    public void setAlpha(float a){ this.alpha = a; repaint(); }

 // Kurzer Klick-Effekt
    public void flash() {
    	  setAlpha(alphaOrig*0.6f+0.17f);
        Timer timer = new Timer(150, e -> setAlpha(alphaOrig));
        timer.setRepeats(false);
        timer.start();
        setAlpha(alphaOrig*0.6f+0.17f);
    }
    private void addHoverEffect() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
    }
}

