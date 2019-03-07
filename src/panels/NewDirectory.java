package panels;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class NewDirectory extends JPanel {
	private JTextField textFieldDirectoryPath;
	private final Action actionRemoveSelf = new SwingActionRemoveSelf();
	private NewDirectory self;

	/**
	 * Create the panel.
	 */
	public NewDirectory() {
		self = this;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{68, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDirectory = new JLabel("Directory");
		GridBagConstraints gbc_lblDirectory = new GridBagConstraints();
		gbc_lblDirectory.insets = new Insets(0, 0, 0, 5);
		gbc_lblDirectory.gridx = 0;
		gbc_lblDirectory.gridy = 0;
		add(lblDirectory, gbc_lblDirectory);
		
		textFieldDirectoryPath = new JTextField();
		textFieldDirectoryPath.setToolTipText("Path to the Bundles folder");
		GridBagConstraints gbc_textFieldDirectoryPath = new GridBagConstraints();
		gbc_textFieldDirectoryPath.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldDirectoryPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDirectoryPath.gridx = 1;
		gbc_textFieldDirectoryPath.gridy = 0;
		add(textFieldDirectoryPath, gbc_textFieldDirectoryPath);
		textFieldDirectoryPath.setColumns(10);
		
		JButton buttonRemoveSelf = new JButton("New button");
		buttonRemoveSelf.setAction(actionRemoveSelf);
		GridBagConstraints gbc_buttonRemoveSelf = new GridBagConstraints();
		gbc_buttonRemoveSelf.gridx = 2;
		gbc_buttonRemoveSelf.gridy = 0;
		add(buttonRemoveSelf, gbc_buttonRemoveSelf);

	}

	private class SwingActionRemoveSelf extends AbstractAction {
		public SwingActionRemoveSelf() {
			putValue(NAME, "X");
			putValue(SHORT_DESCRIPTION, "Remove this directory");
		}
		public void actionPerformed(ActionEvent e) {
			getParent().remove(self);
		}
	}
}
