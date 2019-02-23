package panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class NewDialogue extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2705985586487282881L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public NewDialogue() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 76, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblFolderName = new JLabel("Folder name");
		GridBagConstraints gbc_lblFolderName = new GridBagConstraints();
		gbc_lblFolderName.anchor = GridBagConstraints.EAST;
		gbc_lblFolderName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFolderName.gridx = 0;
		gbc_lblFolderName.gridy = 0;
		add(lblFolderName, gbc_lblFolderName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblDialogueId = new JLabel("Dialogue ID");
		GridBagConstraints gbc_lblDialogueId = new GridBagConstraints();
		gbc_lblDialogueId.anchor = GridBagConstraints.EAST;
		gbc_lblDialogueId.insets = new Insets(0, 0, 5, 5);
		gbc_lblDialogueId.gridx = 0;
		gbc_lblDialogueId.gridy = 1;
		add(lblDialogueId, gbc_lblDialogueId);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMessage = new JLabel(" Message ");
		lblMessage.setToolTipText("Separate pages with <p>");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.gridwidth = 2;
		gbc_lblMessage.insets = new Insets(0, 0, 5, 0);
		gbc_lblMessage.gridx = 0;
		gbc_lblMessage.gridy = 2;
		add(lblMessage, gbc_lblMessage);
		
		JPanel panelDialogueType = new JPanel();
		GridBagConstraints gbc_panelDialogueType = new GridBagConstraints();
		gbc_panelDialogueType.gridwidth = 2;
		gbc_panelDialogueType.fill = GridBagConstraints.BOTH;
		gbc_panelDialogueType.gridx = 0;
		gbc_panelDialogueType.gridy = 3;
		add(panelDialogueType, gbc_panelDialogueType);
		panelDialogueType.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setToolTipText("Separate pages with <p>");
		panelDialogueType.add(textArea);

	}

}
