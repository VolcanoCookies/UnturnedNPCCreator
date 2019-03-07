package panels;

import java.awt.Container;
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
import java.awt.GridLayout;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class SettingsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4235287392206935746L;
	private JTextField textFieldWorkshopFolder;
	private final Action actionSave = new SwingActionSave();
	private final Action actionAddDirectory = new SwingActionAddDirectory();
	private JPanel panelDirectories;

	public SettingsPanel() {
		setVisible(false);
		setEnabled(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblWorkshopFolder = new JLabel("Workshop folder");
		GridBagConstraints gbc_lblWorkshopFolder = new GridBagConstraints();
		gbc_lblWorkshopFolder.insets = new Insets(0, 0, 5, 5);
		gbc_lblWorkshopFolder.anchor = GridBagConstraints.EAST;
		gbc_lblWorkshopFolder.gridx = 0;
		gbc_lblWorkshopFolder.gridy = 0;
		add(lblWorkshopFolder, gbc_lblWorkshopFolder);
		
		textFieldWorkshopFolder = new JTextField();
		GridBagConstraints gbc_textFieldWorkshopFolder = new GridBagConstraints();
		gbc_textFieldWorkshopFolder.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldWorkshopFolder.fill = GridBagConstraints.BOTH;
		gbc_textFieldWorkshopFolder.gridx = 1;
		gbc_textFieldWorkshopFolder.gridy = 0;
		add(textFieldWorkshopFolder, gbc_textFieldWorkshopFolder);
		textFieldWorkshopFolder.setColumns(10);
		
		panelDirectories = new JPanel();
		panelDirectories.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				panelDirectories.revalidate();
				panelDirectories.repaint();
			}
			@Override
			public void componentRemoved(ContainerEvent e) {
				panelDirectories.revalidate();
				panelDirectories.repaint();
			}
		});
		GridBagConstraints gbc_panelDirectories = new GridBagConstraints();
		gbc_panelDirectories.gridwidth = 2;
		gbc_panelDirectories.insets = new Insets(0, 0, 5, 0);
		gbc_panelDirectories.fill = GridBagConstraints.BOTH;
		gbc_panelDirectories.gridx = 0;
		gbc_panelDirectories.gridy = 1;
		add(panelDirectories, gbc_panelDirectories);
		panelDirectories.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton buttonAddDirectory = new JButton("New button");
		buttonAddDirectory.setAction(actionAddDirectory);
		GridBagConstraints gbc_buttonAddDirectory = new GridBagConstraints();
		gbc_buttonAddDirectory.gridwidth = 2;
		gbc_buttonAddDirectory.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAddDirectory.gridx = 0;
		gbc_buttonAddDirectory.gridy = 2;
		add(buttonAddDirectory, gbc_buttonAddDirectory);
		
		JButton buttonSave = new JButton("New button");
		buttonSave.setAction(actionSave);
		GridBagConstraints gbc_buttonSave = new GridBagConstraints();
		gbc_buttonSave.gridwidth = 2;
		gbc_buttonSave.gridx = 0;
		gbc_buttonSave.gridy = 15;
		add(buttonSave, gbc_buttonSave);
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
	private class SwingActionAddDirectory extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -724139153731732268L;
		public SwingActionAddDirectory() {
			putValue(NAME, "Add directory");
			putValue(SHORT_DESCRIPTION, "Add a directory containint npc data.");
		}
		public void actionPerformed(ActionEvent e) {
			panelDirectories.add(new NewDirectory());
		}
	}
}
