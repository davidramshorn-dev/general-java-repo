package tiktaktoeExtended;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PlayerPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JScrollPane foundScroll;
    private ComponentAdapter vpListener;
    private JButton customize=new JButton("Bearbeiten");
    private JButton delete=new JButton("Löschen");
    private JLabel label=new JLabel("placeholder");

    public PlayerPanel(String name) {
        setOpaque(false);
        setForeground(java.awt.Color.BLACK);
        setBorder(null);
        setLayout(new BorderLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT); // wichtig für BoxLayout Y_AXIS
        label.setHorizontalAlignment(WIDTH/2);

        JPanel left = new JPanel(); left.setLayout(new BorderLayout());left.add(customize, BorderLayout.CENTER); left.setOpaque(false);
        JPanel center = new JPanel(); center.setLayout(new BorderLayout());center.add(label, BorderLayout.CENTER); center.setOpaque(false);
        JPanel right = new JPanel(); right.setLayout(new BorderLayout());right.add(delete, BorderLayout.CENTER); right.setOpaque(false);

        add(left, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
        add(right, BorderLayout.EAST);
    }

    // Wenn zum GUI hinzugefügt, Listener auf das Viewport registrieren
    @Override
    public void addNotify() {
        super.addNotify();
        registerViewportListener();
    }

    @Override
    public void removeNotify() {
        unregisterViewportListener();
        super.removeNotify();
    }

    private void registerViewportListener() {
        JScrollPane sp = findScrollPane();
        if (sp == null || sp == foundScroll) return;
        unregisterViewportListener();
        foundScroll = sp;
        vpListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                revalidate(); // Preferred/Maximum neu auswerten
            }
        };
        foundScroll.getViewport().addComponentListener(vpListener);
    }

    private void unregisterViewportListener() {
        if (foundScroll != null && vpListener != null) {
            foundScroll.getViewport().removeComponentListener(vpListener);
        }
        foundScroll = null;
        vpListener = null;
    }

    private JScrollPane findScrollPane() {
        java.awt.Container p = getParent();
        while (p != null && !(p instanceof JScrollPane)) {
            p = p.getParent();
        }
        return (p instanceof JScrollPane) ? (JScrollPane) p : null;
    }

    @Override
    public Dimension getPreferredSize() {
        JScrollPane sp = findScrollPane();
        int width = (sp != null) ? sp.getViewport().getWidth()
                                : (getParent() != null ? getParent().getWidth() : 100);
        int height = Math.max(24, (int) (width * 0.10)); // Mindesthöhe 24
        return new Dimension(width, height);
    }

    // sehr große Breite erlaubt BoxLayout das Strecken
    @Override
    public Dimension getMaximumSize() {
        Dimension pref = getPreferredSize();
        return new Dimension(Integer.MAX_VALUE, pref.height);
    }
}


