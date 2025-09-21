package tutorialVideoÜbungen4;

import java.awt.Color;

import javax.swing.JScrollPane;

public class ScrollPanel extends JScrollPane implements ModComponent{
	 private static final long serialVersionUID = 1L;
	private final double xOrig, yOrig, widthOrig, heightOrig;
	public ScrollPanel(double xOrig, double yOrig, double widthOrig, double heightOrig) {
	    this.xOrig = xOrig;
	    this.yOrig = yOrig;
	    this.widthOrig = widthOrig;
	    this.heightOrig = heightOrig;

	    setOpaque(false);
	    setBackground(new Color(0, 0, 0, 0));
	    setForeground(Color.white);
	    setBorder(null);

	    // Viewport durchsichtig machen
	    getViewport().setOpaque(false);
	    getViewport().setBackground(new Color(0, 0, 0, 0));

	    // Scrollbars durchsichtig machen
	    getHorizontalScrollBar().setOpaque(true);
	    getHorizontalScrollBar().setBackground(Color.white);
	    getVerticalScrollBar().setOpaque(false);
	    getVerticalScrollBar().setBackground(new Color(0, 0, 0, 0));
	}

	    @Override public double getxOrig(){ return xOrig;}
	    @Override public double getyOrig(){ return yOrig;}
	    @Override public double getWidthOrig(){ return widthOrig;}
	    @Override public double getHeightOrig(){ return heightOrig;}


}
