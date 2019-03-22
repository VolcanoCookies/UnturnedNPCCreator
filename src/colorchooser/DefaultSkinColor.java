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

public class DefaultSkinColor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 897177487892431184L;

	private final Action actionColorSelected = new SwingActionColorSelected();

	private Color[] colors = {
			new Color(244, 230, 210),
			new Color(217, 202, 180),
			new Color(190, 165, 130),
			new Color(157, 136, 107),
			new Color(148, 118, 75),
			new Color(112, 96, 73),
			new Color(83, 71, 54),
			new Color(75, 61, 49),
			new Color(51, 44, 37),
			new Color(35, 31, 28),
	};
	
	private int i;
	
	/**
	 * Create the panel.
	 */
	public DefaultSkinColor() {
		
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
			//ColorChooser.getChooser().setColor(((JButton) e.getSource()).getBackground());
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
