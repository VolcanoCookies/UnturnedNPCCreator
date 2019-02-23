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

import windows.Window;
import javax.swing.JCheckBox;

public class SettingsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4235287392206935746L;
	private JTextField textFieldWorkshopFolder;
	private final Action actionBack = new SwingActionBack();
	private final Action actionSave = new SwingActionSave();

	public SettingsPanel() {
		setVisible(false);
		setEnabled(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton buttonBack = new JButton("New button");
		buttonBack.setAction(actionBack);
		GridBagConstraints gbc_buttonBack = new GridBagConstraints();
		gbc_buttonBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonBack.insets = new Insets(0, 0, 5, 5);
		gbc_buttonBack.gridx = 0;
		gbc_buttonBack.gridy = 0;
		add(buttonBack, gbc_buttonBack);
		
		JLabel lblWorkshopFolder = new JLabel("Workshop folder");
		GridBagConstraints gbc_lblWorkshopFolder = new GridBagConstraints();
		gbc_lblWorkshopFolder.insets = new Insets(0, 0, 5, 5);
		gbc_lblWorkshopFolder.anchor = GridBagConstraints.EAST;
		gbc_lblWorkshopFolder.gridx = 0;
		gbc_lblWorkshopFolder.gridy = 1;
		add(lblWorkshopFolder, gbc_lblWorkshopFolder);
		
		textFieldWorkshopFolder = new JTextField();
		GridBagConstraints gbc_textFieldWorkshopFolder = new GridBagConstraints();
		gbc_textFieldWorkshopFolder.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldWorkshopFolder.fill = GridBagConstraints.BOTH;
		gbc_textFieldWorkshopFolder.gridx = 1;
		gbc_textFieldWorkshopFolder.gridy = 1;
		add(textFieldWorkshopFolder, gbc_textFieldWorkshopFolder);
		textFieldWorkshopFolder.setColumns(10);
		
		JCheckBox checkBoxExperimentalFeatures = new JCheckBox("Experimental Features");
		GridBagConstraints gbc_checkBoxExperimentalFeatures = new GridBagConstraints();
		gbc_checkBoxExperimentalFeatures.insets = new Insets(0, 0, 5, 0);
		gbc_checkBoxExperimentalFeatures.gridx = 1;
		gbc_checkBoxExperimentalFeatures.gridy = 2;
		add(checkBoxExperimentalFeatures, gbc_checkBoxExperimentalFeatures);
		
		JButton buttonSave = new JButton("New button");
		buttonSave.setAction(actionSave);
		GridBagConstraints gbc_buttonSave = new GridBagConstraints();
		gbc_buttonSave.gridwidth = 2;
		gbc_buttonSave.gridx = 0;
		gbc_buttonSave.gridy = 15;
		add(buttonSave, gbc_buttonSave);
	}

	private class SwingActionBack extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6697899151314478211L;
		public SwingActionBack() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "Return to main panel.");
		}
		public void actionPerformed(ActionEvent e) {
			Window.Back();
		}
	}
	private class SwingActionSave extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4210975950065871443L;
		public SwingActionSave() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save current settings.");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
