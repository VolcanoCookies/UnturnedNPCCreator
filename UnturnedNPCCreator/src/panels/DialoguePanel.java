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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DialoguePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2242788810946648643L;
	private JTextField textField;
	private final Action actionLoad = new SwingActionLoad();
	private final Action actionAddDialogue = new SwingActionAddDialogue();

	/**
	 * Create the panel.
	 */
	public DialoguePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{568, 0};
		gridBagLayout.rowHeights = new int[]{713, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{61, 0};
		gbl_panel.rowHeights = new int[]{117, 160, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panelBasic = new JPanel();
		GridBagConstraints gbc_panelBasic = new GridBagConstraints();
		gbc_panelBasic.insets = new Insets(0, 0, 5, 0);
		gbc_panelBasic.fill = GridBagConstraints.BOTH;
		gbc_panelBasic.gridx = 0;
		gbc_panelBasic.gridy = 0;
		panel.add(panelBasic, gbc_panelBasic);
		GridBagLayout gbl_panelBasic = new GridBagLayout();
		gbl_panelBasic.columnWidths = new int[]{62, 0, 0, 0};
		gbl_panelBasic.rowHeights = new int[]{0, 0};
		gbl_panelBasic.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelBasic.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBasic.setLayout(gbl_panelBasic);
		
		JLabel lblFolderName = new JLabel("Folder name");
		GridBagConstraints gbc_lblFolderName = new GridBagConstraints();
		gbc_lblFolderName.insets = new Insets(0, 0, 0, 5);
		gbc_lblFolderName.gridx = 0;
		gbc_lblFolderName.gridy = 0;
		panelBasic.add(lblFolderName, gbc_lblFolderName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panelBasic.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton buttonLoad = new JButton("New button");
		buttonLoad.setAction(actionLoad);
		GridBagConstraints gbc_buttonLoad = new GridBagConstraints();
		gbc_buttonLoad.anchor = GridBagConstraints.NORTH;
		gbc_buttonLoad.gridx = 2;
		gbc_buttonLoad.gridy = 0;
		panelBasic.add(buttonLoad, gbc_buttonLoad);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		
		JButton buttonAddDialogue = new JButton("New button");
		buttonAddDialogue.setAction(actionAddDialogue);
		GridBagConstraints gbc_buttonAddDialogue = new GridBagConstraints();
		gbc_buttonAddDialogue.insets = new Insets(0, 0, 5, 0);
		gbc_buttonAddDialogue.anchor = GridBagConstraints.NORTH;
		gbc_buttonAddDialogue.gridx = 0;
		gbc_buttonAddDialogue.gridy = 2;
		panel.add(buttonAddDialogue, gbc_buttonAddDialogue);

	}

	private class SwingActionLoad extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8854282028767568235L;
		public SwingActionLoad() {
			putValue(NAME, "Load");
			putValue(SHORT_DESCRIPTION, "Load dialogues");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	private class SwingActionAddDialogue extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8880423923041098652L;
		public SwingActionAddDialogue() {
			putValue(NAME, "Add dialogue");
			putValue(SHORT_DESCRIPTION, "Add a new dialogue.");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
