package tutorialVideoÜbungen4;

import java.awt.Font;

import javax.swing.JLabel;

public class ModLabel extends JLabel implements ModComponent{
	private static final long serialVersionUID = 1L;
	private final double xOrig, yOrig, widthOrig, heightOrig, sizeTextOrig;
	public ModLabel(String text,double xOrig, double yOrig, double widthOrig, double heightOrig, double sizeTextOrig) {
			super(text);
		 	this.xOrig = xOrig;
		    this.yOrig = yOrig;
		    this.widthOrig = widthOrig;
		    this.heightOrig = heightOrig;
		    this.sizeTextOrig=sizeTextOrig;
	}
		@Override public double getxOrig(){ return xOrig;}
	    @Override public double getyOrig(){ return yOrig;}
	    @Override public double getWidthOrig(){ return widthOrig;}
	    @Override public double getHeightOrig(){ return heightOrig;}
		@Override public double getSizeTextOrig() {	return sizeTextOrig;}
		@Override public void setSizeText(float x) {Font current = this.getFont(); this.setFont(current.deriveFont(x));}
}
