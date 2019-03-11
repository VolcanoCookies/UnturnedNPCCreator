package colorchooser;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DefaultHairColor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 897177487892431184L;

	private final Action actionColorSelected = new SwingActionColorSelected();

	private Color[] colors = {
			new Color(215, 215, 215),
			new Color(193, 193, 193),
			new Color(205, 192, 140),
			new Color(172, 106, 57),
			new Color(102, 80, 55),
			new Color(87, 69, 47),
			new Color(71, 57, 40),
			new Color(53, 44, 34),
			new Color(55, 55, 55),
			new Color(25, 25, 25),
	};
	
	private int i;
	
	/**
	 * Create the panel.
	 */
	public DefaultHairColor() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		setLayout(new GridLayout(2, 5, 0, 0));
		
		for(i = 0; i < 10; i++) {
			add(new JButton("") {/**
				 * 
				 */
				private static final long serialVersionUID = 1130369538546171532L;

			{
				setOpaque(true);
				setAction(actionColorSelected);
				setBorderPainted(false);
				setBackground(colors[i]);
				setFocusPainted(false);
				setRolloverEnabled(false);
				setModel(new FixedStateButtonModel());
			}});
		}
	}
	
	private class SwingActionColorSelected extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4340209899346492615L;
		public SwingActionColorSelected() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			colorChooser.getChooser().setColor(((JButton) e.getSource()).getBackground());
		}
	}
	public class FixedStateButtonModel extends DefaultButtonModel    {

        /**
		 * 
		 */
		private static final long serialVersionUID = -6293605029007674167L;

		@Override
        public boolean isPressed() {
            return false;
        }

        @Override
        public boolean isRollover() {
            return false;
        }

        @Override
        public void setRollover(boolean b) {
            //NOOP
        }

    }
}
