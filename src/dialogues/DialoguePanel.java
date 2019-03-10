package dialogues;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import filemanagement.LoadDialogue;

public class DialoguePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2242788810946648643L;
	private JTextField textFieldFolderName;
	private final Action actionLoad = new SwingActionLoad();
	private final Action actionAddMessage = new SwingActionAddMessage();
	private static JTextField textFieldDialogueID;
	private static JPanel panelMessages;
	private final Action actionSaveDialogue = new SwingActionSaveDialogue();

	/**
	 * Create the panel.
	 */
	public DialoguePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{61, 0};
		gbl_panel.rowHeights = new int[]{43, 160, 0, 0, 0, 0};
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
		gbl_panelBasic.columnWidths = new int[]{91, 0, 0, 0};
		gbl_panelBasic.rowHeights = new int[]{0, 0, 0};
		gbl_panelBasic.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelBasic.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelBasic.setLayout(gbl_panelBasic);
		
		JLabel lblFolderName = new JLabel("Folder name");
		GridBagConstraints gbc_lblFolderName = new GridBagConstraints();
		gbc_lblFolderName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFolderName.gridx = 0;
		gbc_lblFolderName.gridy = 0;
		panelBasic.add(lblFolderName, gbc_lblFolderName);
		
		textFieldFolderName = new JTextField();
		GridBagConstraints gbc_textFieldFolderName = new GridBagConstraints();
		gbc_textFieldFolderName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFolderName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFolderName.gridx = 1;
		gbc_textFieldFolderName.gridy = 0;
		panelBasic.add(textFieldFolderName, gbc_textFieldFolderName);
		textFieldFolderName.setColumns(10);
		
		JButton buttonLoad = new JButton("New button");
		buttonLoad.setAction(actionLoad);
		GridBagConstraints gbc_buttonLoad = new GridBagConstraints();
		gbc_buttonLoad.insets = new Insets(0, 0, 5, 0);
		gbc_buttonLoad.anchor = GridBagConstraints.NORTH;
		gbc_buttonLoad.gridx = 2;
		gbc_buttonLoad.gridy = 0;
		panelBasic.add(buttonLoad, gbc_buttonLoad);
		
		JLabel lblDialogueId = new JLabel("Dialogue ID");
		GridBagConstraints gbc_lblDialogueId = new GridBagConstraints();
		gbc_lblDialogueId.anchor = GridBagConstraints.EAST;
		gbc_lblDialogueId.insets = new Insets(0, 0, 0, 5);
		gbc_lblDialogueId.gridx = 0;
		gbc_lblDialogueId.gridy = 1;
		panelBasic.add(lblDialogueId, gbc_lblDialogueId);
		
		textFieldDialogueID = new JTextField();
		textFieldDialogueID.setColumns(10);
		GridBagConstraints gbc_textFieldDialogueID = new GridBagConstraints();
		gbc_textFieldDialogueID.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldDialogueID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDialogueID.gridx = 1;
		gbc_textFieldDialogueID.gridy = 1;
		panelBasic.add(textFieldDialogueID, gbc_textFieldDialogueID);
		
		panelMessages = new JPanel();
		panelMessages.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				for(int i = 0; i < panelMessages.getComponentCount(); i++)
				{
					((NewMessage) panelMessages.getComponent(i)).ChangeIndex(i);
				}
				panelMessages.repaint();
				panelMessages.revalidate();
			}
			@Override
			public void componentRemoved(ContainerEvent e) {
				for(int i = 0; i < panelMessages.getComponentCount(); i++)
				{
					((NewMessage) panelMessages.getComponent(i)).ChangeIndex(i);
				}
				panelMessages.repaint();
				panelMessages.revalidate();
			}
		});
		GridBagConstraints gbc_panelMessages = new GridBagConstraints();
		gbc_panelMessages.insets = new Insets(0, 0, 5, 0);
		gbc_panelMessages.fill = GridBagConstraints.BOTH;
		gbc_panelMessages.gridx = 0;
		gbc_panelMessages.gridy = 1;
		panel.add(panelMessages, gbc_panelMessages);
		panelMessages.setLayout(new GridLayout(0, 1, 0, 10));
		
		JButton buttonAddReply = new JButton("New button");
		buttonAddReply.setAction(actionAddMessage);
		GridBagConstraints gbc_buttonAddReply = new GridBagConstraints();
		gbc_buttonAddReply.insets = new Insets(0, 0, 5, 0);
		gbc_buttonAddReply.anchor = GridBagConstraints.NORTH;
		gbc_buttonAddReply.gridx = 0;
		gbc_buttonAddReply.gridy = 2;
		panel.add(buttonAddReply, gbc_buttonAddReply);
		
		JButton button = new JButton("New button");
		button.setAction(actionSaveDialogue);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 3;
		panel.add(button, gbc_button);
		
		reorganizeGlobalIndex();

	}
	
	static void reorganizeGlobalIndex() {
		
		int indexResponses = 0;
		int indexMessages = 0;
		
		//Redistribute global index
		for(Component message : panelMessages.getComponents()) {
			((NewMessage) message).ChangeIndex(indexMessages++);
			if(((NewMessage) message).getResponses()!=null) {
				for(Component response : ((NewMessage) message).getResponses()) {
					((NewResponse) response).setGlobalIndex(indexResponses++);
				}
			}
		}
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
			FillFields(LoadDialogue.loadDialogue(textFieldFolderName.getText()));
		}
	}
	private class SwingActionAddMessage extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8880423923041098652L;
		public SwingActionAddMessage() {
			putValue(NAME, "Add message");
			putValue(SHORT_DESCRIPTION, "Add a new message.");
		}
		public void actionPerformed(ActionEvent e) {
			panelMessages.add(new NewMessage(0, null));
			reorganizeGlobalIndex();
		}
	}
	private class SwingActionSaveDialogue extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -24168609282897078L;
		public SwingActionSaveDialogue() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save the dialogue.");
		}
		public void actionPerformed(ActionEvent e) {
			Save();
		}
	}
	public static void Save() {
		//Index 0 is for Asset.dat, Index 1 is for English.dat
		String[] output = new String[2];
		
		output[1] = "";
		
		//Assign type and ID
		output[0] = "Type Dialogue\n";
		output[0] += "ID " + textFieldDialogueID.getText() + "\n\n";
		
		//Number of messages
		output[0] += "Messages " + panelMessages.getComponentCount() + "\n";
		
		//Get all message windows
		for(Component comp : panelMessages.getComponents()) {
			output[0] += ((NewMessage) comp).getValues()[0] + "\n";
			output[1] += ((NewMessage) comp).getValues()[1] + "\n";
		}
		
		System.out.println(output[0]);
		System.out.println(output[1]);
		
	}

	public void FillFields(String[] values) {
		
		//Remove any existing messages etc
		panelMessages.removeAll();
		
		//Temp values
		int noMessages = 0;
		
		//Get number of messages
		Matcher matcher = Pattern.compile("[^_]*messages ([0-9]+).*", Pattern.DOTALL).matcher(values[0].toLowerCase());
		if(matcher.matches())
			noMessages = Integer.valueOf(matcher.group(1));
		
		//Create new messages
		for(int i = 0; i < noMessages; i++) {
			panelMessages.add(new NewMessage(i, values));
		}
	}
	
	public void OldFillFields(String[][] values) {
		
		//Temporary values
		String[][] messages = null;
		String[][] responses = null;
		String[] messageResponses = new String[2];
		
		//Get number of messages and responses
		for(String string : values[0]) {
			if(string.toLowerCase().contains("messages ") && !string.toLowerCase().contains("_messages")) {
				messages = new String[2][Integer.valueOf(string.split(" ")[1])];
			}
			if(string.toLowerCase().contains("responses ") && !string.toLowerCase().contains("_responses")) {
				responses = new String[2][Integer.valueOf(string.split(" ")[1])];
			}
		}
		
		//Replace all content with "" so you can use +=
		for(int i = 0; i < messages[0].length; i++) {
			for(int ii = 0; ii < 2; ii++) {
				messages[ii][i] = "";
			}
		}
		//Replace all content with "" so you can use +=
		for(int i = 0; i < responses[0].length; i++) {
			for(int ii = 0; ii < 2; ii++) {
				responses[ii][i] = "";
			}
		}
		
		//Iterate Asset data
		for(String string : values[0]) {
			if(string.toLowerCase().matches("message_[0-9]+_.*")) {
				messages[0][Integer.valueOf(string.toLowerCase().split("_")[1])] += string + "\n";
			}
			if(string.toLowerCase().matches("response_[0-9]+_.*")) {
				responses[0][Integer.valueOf(string.toLowerCase().split("_")[1])] += string + "\n";
			}
		}
		//Iterate English data
		for(String string : values[1]) {
			if(string.toLowerCase().matches("message_[0-9]+_page_[0-9]+.*")) {
				messages[1][Integer.valueOf(string.toLowerCase().split("_")[1])] += string + "\n";
			}
			if(string.toLowerCase().matches("response_[0-9]+.*")) {
				responses[1][Integer.valueOf(string.toLowerCase().split("_")[1].split(" ")[0])] = string;
			}
		}
		
		//Assign responses to messages then create the message.
		for(int ii = 0; ii < messages[0].length; ii++) {
			Matcher matcher = Pattern.compile(".*message_" + ii + "_responses ([0-9]+).*").matcher(messages[0][ii].toLowerCase().replaceAll("\n", "").replaceAll("\r", ""));
			if(matcher.matches()) {
				messageResponses[0] = "";
				messageResponses[1] = "";
			}
			if(matcher.groupCount()>1) {
				for(int i = 0; i < Integer.valueOf(matcher.group(1)); i++) {
					matcher = Pattern.compile(".*message_" + ii + "_response_" + i + " ([0-9]+).*").matcher(messages[0][i].toLowerCase().replaceAll("\n", "").replaceAll("\r", ""));
					if(matcher.matches()) {
						messageResponses[0] += responses[0][Integer.valueOf(matcher.group(1))] + ":::";
						messageResponses[1] += responses[1][Integer.valueOf(matcher.group(1))] + ":::";
					}
				}
			}
			
			panelMessages.add(new NewMessage(messages[0][ii], messages[1][ii], messageResponses));
		}
		
//		for(String string : messages[0]) {
//			System.out.println(string);
//			System.out.println("____________________________");
//		}
//		for(String string : messages[1]) {
//			System.out.println(string);
//			System.out.println("____________________________");
//		}
	}
}
