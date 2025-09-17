package tutorialVideoÜbungen4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private Image backgroundImage;

    private final int origPanelWidth = 4000;
    private final int origPanelHeight = 2375;

    private TransparentButton textButton;
    private TransparentButton textButton2;
    private TransparentButton textButton3;

    private final int[][] origBounds = {
        {1672, 1798, 650, 128+45},   // Button 1
        {1766, 990, 484, 110+40},   // Button 2
        {1745, 1980, 520, 128+50}    // Button 3
    };

    public MainPanel(ImageIcon imageIcon) {
        this.backgroundImage = imageIcon.getImage();

        setLayout(null);
        setPreferredSize(new Dimension(origPanelWidth, origPanelHeight));

        // Button 1
        textButton = new TransparentButton("");
        textButton.setForeground(Color.WHITE);
//        textButton.setBackground(Color.BLACK);
        textButton.setAlpha(0.0f); // sicherstellen: voll deckend
        addHoverEffect(textButton);
        textButton.addActionListener((ActionEvent e) -> textButton.flash());
        add(textButton);

        // Button 2
        textButton2 = new TransparentButton("");
        textButton2.setForeground(Color.WHITE);
//        textButton2.setBackground(Color.BLACK);
        textButton2.setAlpha(0.0f);
        addHoverEffect(textButton2);
        textButton2.addActionListener((ActionEvent e) -> textButton2.flash());
        add(textButton2);

        // Button 3
        textButton3 = new TransparentButton("");
        textButton3.setForeground(Color.WHITE);
//        textButton3.setBackground(Color.BLACK);
        textButton3.setAlpha(0.0f);
        addHoverEffect(textButton3);
        textButton3.addActionListener((ActionEvent e) -> textButton3.flash());
        add(textButton3);

        // Resize-Handler
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeButtons();
            }
        });

        // Initiales Skalieren beim ersten Anzeigen
        addHierarchyListener(e -> {
            if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0 && isShowing()) {
                resizeButtons();
            }
        });
    }

 // Feld (z.B. oben in der Klasse)
    private double scaleMultiplier = 1; // 1.0 = unverändert, >1 = größer, <1 = kleiner
    private double positionMultiplier = 1;
    private double yAchsenabschnittB1=0;
    private double yAchsenabschnittB2=0;
    private double yAchsenabschnittB3=0;
    private final int minButtonWidth = 30;  // Mindestgrößen verhindern zu kleine Buttons
    private final int minButtonHeight = 16;

    // Angepasste Methode
    private void resizeButtons() {
        int w = Math.max(1, getWidth());
        int h = Math.max(1, getHeight());
        double widthRatio = w / (double) origPanelWidth;
        double heightRatio = h / (double) origPanelHeight;

        int bw = Math.max(minButtonWidth, (int) Math.round(origBounds[0][2] * widthRatio * scaleMultiplier));
        int bh = Math.max(minButtonHeight, (int) Math.round(origBounds[0][3] * heightRatio * scaleMultiplier));
        int bx = (int) Math.round(origBounds[0][0] * widthRatio * positionMultiplier);
        int by = (int) Math.round(origBounds[0][1] * heightRatio * positionMultiplier+yAchsenabschnittB1);
        textButton.setBounds(bx, by, bw, bh);

        // Button 2
        bw = Math.max(minButtonWidth, (int) Math.round(origBounds[1][2] * widthRatio * scaleMultiplier));
        bh = Math.max(minButtonHeight, (int) Math.round(origBounds[1][3] * heightRatio * scaleMultiplier));
        bx = (int) Math.round(origBounds[1][0] * widthRatio * positionMultiplier);
        by = (int) Math.round(origBounds[1][1] * heightRatio * positionMultiplier+yAchsenabschnittB2);
        textButton2.setBounds(bx, by, bw, bh);

        // Button 3
        bw = Math.max(minButtonWidth, (int) Math.round(origBounds[2][2] * widthRatio * scaleMultiplier));
        bh = Math.max(minButtonHeight, (int) Math.round(origBounds[2][3] * heightRatio * scaleMultiplier));
        bx = (int) Math.round(origBounds[2][0] * widthRatio * positionMultiplier);
        by = (int) Math.round(origBounds[2][1] * heightRatio * positionMultiplier+yAchsenabschnittB3);
        textButton3.setBounds(bx, by, bw, bh);

        revalidate();
        repaint();
    }


    private void addHoverEffect(TransparentButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
