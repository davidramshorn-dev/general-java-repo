package tutorialVideoÜbungen4;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PlaceholderTextField extends JTextField implements ModComponent{
    private String placeholder;
    private final double xOrig, yOrig, widthOrig, heightOrig;

    public PlaceholderTextField(String placeholder, double xOrig, double yOrig, double widthOrig, double heightOrig) {
        this.placeholder = placeholder;
        this.xOrig = xOrig;
        this.yOrig = yOrig;
        this.widthOrig = widthOrig;
        this.heightOrig = heightOrig;
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
        setForeground(Color.white);
        setBorder(null);
//        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // z. B. graue Linie
    }
    
    @Override public double getxOrig(){ return xOrig;}
    @Override public double getyOrig(){ return yOrig;}
    @Override public double getWidthOrig(){ return widthOrig;}
    @Override public double getHeightOrig(){ return heightOrig;}

    public void setPlaceholder(String text) {
        this.placeholder = text;
        repaint();
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getText().isEmpty() && ! (FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setFont(getFont().deriveFont(Font.ITALIC));
            g2.setColor(Color.GRAY);
            Insets insets = getInsets();
            g2.drawString(placeholder, insets.left + 5, getHeight() / 2 + getFont().getSize() / 2 - 4);
            g2.dispose();
        }
    }
}                     

