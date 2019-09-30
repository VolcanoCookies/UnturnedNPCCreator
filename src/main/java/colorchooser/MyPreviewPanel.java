package colorchooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JColorChooser;
import javax.swing.JComponent;

class MyPreviewPanel extends JComponent {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 5886245894052585787L;
	Color curColor;
	  public MyPreviewPanel(JColorChooser chooser) {
	    curColor = chooser.getColor();
	    
	    setPreferredSize(new Dimension(50, 50));
	  }
	  public void paint(Graphics g) {
	    g.setColor(curColor);
	    g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
	  }
}