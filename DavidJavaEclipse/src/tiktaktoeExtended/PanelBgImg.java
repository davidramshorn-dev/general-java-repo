package tiktaktoeExtended;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.HierarchyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelBgImg extends JPanel {


    private static final long serialVersionUID = 1L;
    private Image backgroundImage;

    private final int origPanelWidth = 4000;
    private final int origPanelHeight = 2375;
    private final List<ModComponent> modComponents = new ArrayList<>();

    public PanelBgImg(ImageIcon imageIcon) {
        this.backgroundImage = imageIcon.getImage();
        setLayout(null);
        setPreferredSize(new Dimension(origPanelWidth, origPanelHeight));

        // Resize-Handler
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                double wr = getWidth() / (double) origPanelWidth;
                double hr = getHeight() / (double) origPanelHeight;
                resizeElements(wr, hr);
            }
        });

        // Initiales Skalieren beim ersten Anzeigen
        addHierarchyListener(e -> {
            if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0 && isShowing()) {
                double wr = getWidth() / (double) origPanelWidth;
                double hr = getHeight() / (double) origPanelHeight;
                resizeElements(wr, hr);
            }
        });
        
        //Initiales Skalieren weiterer Elemente
        addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
            	 modComponents.add((ModComponent) e.getChild());
            	double wr = getWidth() / (double) origPanelWidth;
                double hr = getHeight() / (double) origPanelHeight;
                resizeElements(wr, hr);
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
            	modComponents.remove((ModComponent) e.getChild());     //Fehler anfällig
            	double wr = getWidth() / (double) origPanelWidth;
                double hr = getHeight() / (double) origPanelHeight;
                resizeElements(wr, hr);
            }
        });
    }

    // Angepasste Methode
    private void resizeElements(double widthRatio, double heightRatio) {
        for (ModComponent mc : modComponents) {
            int bx = (int) Math.round(mc.getxOrig() * widthRatio);
            int by = (int) Math.round(mc.getyOrig() * heightRatio);
            int bw = (int) Math.round(mc.getWidthOrig() * widthRatio);
            int bh = (int) Math.round(mc.getHeightOrig() * heightRatio);
            float size = (float) Math.round(mc.getSizeTextOrig()*widthRatio);
            if (mc instanceof ModComponent comp) comp.setSizeText(size);
            if (mc instanceof Component comp) comp.setBounds(bx, by, bw, bh);
        }
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
