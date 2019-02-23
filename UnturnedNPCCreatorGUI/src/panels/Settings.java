package panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Settings extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3883769054769812654L;
	private JTextField textFieldDefaultPath;
	private final Action actionSetDefaultPath = new SwingActionSetDefaultPath();

	/**
	 * Create the panel.
	 */
	public Settings() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{80, 301, 80, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Default Path:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldDefaultPath = new JTextField();
		textFieldDefaultPath.setToolTipText("Path to your NPC folder");
		GridBagConstraints gbc_textFieldDefaultPath = new GridBagConstraints();
		gbc_textFieldDefaultPath.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldDefaultPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDefaultPath.gridx = 1;
		gbc_textFieldDefaultPath.gridy = 0;
		add(textFieldDefaultPath, gbc_textFieldDefaultPath);
		textFieldDefaultPath.setColumns(10);
		
		JButton buttonSetDefaultPath = new JButton("New button");
		buttonSetDefaultPath.setAction(actionSetDefaultPath);
		GridBagConstraints gbc_buttonSetDefaultPath = new GridBagConstraints();
		gbc_buttonSetDefaultPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonSetDefaultPath.gridx = 2;
		gbc_buttonSetDefaultPath.gridy = 0;
		add(buttonSetDefaultPath, gbc_buttonSetDefaultPath);

	}

	private class SwingActionSetDefaultPath extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 973025715149308214L;
		public SwingActionSetDefaultPath() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
