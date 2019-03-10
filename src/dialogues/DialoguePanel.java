package dialogues;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import filemanagement.LoadDialogue;
import filemanagement.SaveDialogue;
import popups.fileChooser;

public class DialoguePanel extends JPanel {
	
	String GUID;
	String dialogueID;
	
	//Number of messages and responses
	int numberOfMessages;
	int numberOfResponses;
	
	//Messages in this dialogue
	Message[] messages;
	//Responses in this dialogue
	Response[] responses;
	
	//Path where this dialogue was loaded from
	String path;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2242788810946648643L;
	private JTextField textFieldFolderName;
	private final Action actionLoad = new SwingActionLoad();
	private final Action actionAddMessage = new SwingActionAddMessage();
	private static JTextField textFieldDialogueID;
	static int index;
	private final Action actionSaveDialogue = new SwingActionSaveDialogue();
	private static JTabbedPane tabbedPane;
	
	/**
	 * Create the panel.
	 */
	public DialoguePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBasic = new JPanel();
		panel.add(panelBasic, BorderLayout.NORTH);
		GridBagLayout gbl_panelBasic = new GridBagLayout();
		gbl_panelBasic.columnWidths = new int[]{91, 0, 0, 0};
		gbl_panelBasic.rowHeights = new int[]{0, 0, 0};
		gbl_panelBasic.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelBasic.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelBasic.setLayout(gbl_panelBasic);
		
		JLabel lblDialoguePath = new JLabel("Dialogue path");
		GridBagConstraints gbc_lblDialoguePath = new GridBagConstraints();
		gbc_lblDialoguePath.insets = new Insets(0, 0, 5, 5);
		gbc_lblDialoguePath.gridx = 0;
		gbc_lblDialoguePath.gridy = 0;
		panelBasic.add(lblDialoguePath, gbc_lblDialoguePath);
		
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
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				tabbedPane.revalidate();
				tabbedPane.repaint();
			}
			public void componentRemoved(ContainerEvent e) {
				tabbedPane.revalidate();
				tabbedPane.repaint();
			}
		});
		panel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelButtons = new JPanel();
		panel.add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new BorderLayout(0, 0));
		
		JButton buttonAddReply = new JButton("New button");
		panelButtons.add(buttonAddReply);
		buttonAddReply.setAction(actionAddMessage);
		
		JButton button = new JButton("New button");
		panelButtons.add(button, BorderLayout.SOUTH);
		button.setAction(actionSaveDialogue);

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
			LoadDialogue(LoadDialogue.loadDialogue(textFieldFolderName.getText()));
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
			tabbedPane.addTab("Mes#" + 0, null, new Message());
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
			String path = fileChooser.FileChooser();
			if(path!=null)
				SaveDialogue.Save(CompileDialogue(), path);
		}
	}
	
	public void FillFields(String[] values) {
		
		//Remove any existing messages etc
		tabbedPane.removeAll();
		
		//Temporary values
		int noMessages = 0;
		
		//Get number of messages
		Matcher matcher = Pattern.compile("[^_]*messages ([0-9]+).*", Pattern.DOTALL).matcher(values[0].toLowerCase());
		if(matcher.matches())
			noMessages = Integer.valueOf(matcher.group(1));
		
		//Create new messages
		for(int i = 0; i < noMessages; i++) {
			tabbedPane.add(new Message());
		}
	}
	
	private String[] CompileDialogue() {
		//Asset.dat is 0, English.dat is 1
		String output[] = new String[2];
		output[0] = "";
		output[1] = "";
		
		//Get ID, GUID and set type
		output[0] += "GUID " + this.GUID + "\n";
		output[0] += "ID " + this.dialogueID + "\n";
		output[0] += "Type Dialogue\n";
		
		
		//Get messages and responses
		output[0] += "\n" + "Messages " + this.numberOfMessages + "\n\n";
		for(Message mes : messages) {
			String[] compiled = mes.CompileMessage();
			output[0] += compiled[0] + "\n";
			output[1] += compiled[1] + "\n";
		}
		output[1] += "\n";
		output[0] += "\n" + "Responses " + this.numberOfResponses + "\n\n";
		for(Response res : responses) {
			String[] compiled = res.CompileResponse();
			output[0] += compiled[0] + "\n";
			output[1] += compiled[1] + "\n";
		}
		
		return output;
	}
	private void LoadDialogue(String values[]) {
		
		//Matchers to use for everything
		Matcher matcher = Pattern.compile("").matcher(values[0]);
		Matcher englishMatcher = Pattern.compile("").matcher(values[1]);

		//Get ID and GUID
		matcher.reset();
		matcher.usePattern(Pattern.compile("ID ([0-9]+)"));
		if(matcher.find()) {
			this.dialogueID = matcher.group(1);
			textFieldDialogueID.setText(this.dialogueID);
		}
		matcher.reset();
		matcher.usePattern(Pattern.compile("GUID (.+)"));
		if(matcher.find())
			this.GUID = matcher.group(1);
		
		//Get number of messages and responses
		matcher.reset();
		matcher.usePattern(Pattern.compile("[^_]+Messages ([0-9]+)"));
		if(matcher.find()) {
			numberOfMessages = Integer.valueOf(matcher.group(1));
			messages = new Message[numberOfMessages];
		}
		matcher.reset();
		matcher.usePattern(Pattern.compile("[^_]+Responses ([0-9]+)"));
		if(matcher.find()) {
			numberOfResponses = Integer.valueOf(matcher.group(1));
			responses = new Response[numberOfResponses];
		}
			
		//Generate messages
		for(int i = 0; i < numberOfMessages; i++) {
			messages[i] = new Message();
			messages[i].setIndex(Integer.toString(i));
		}
		//Generate responses
		for(int i = 0; i < numberOfResponses; i++) {
			responses[i] = new Response();
			responses[i].setIndex(Integer.toString(i));
		}
		
		//Get message conditions
		matcher.reset();
		matcher.usePattern(Pattern.compile("Message_([0-9]+)_(Condition.*)"));
		while(matcher.find()) {
			if(messages[Integer.valueOf(matcher.group(1))].getConditions()==null)
				messages[Integer.valueOf(matcher.group(1))].setConditions("");
			messages[Integer.valueOf(matcher.group(1))].setConditions(messages[Integer.valueOf(matcher.group(1))].getConditions() + matcher.group(2) + "\n");
		}
		//Get message rewards
		matcher.reset();
		matcher.usePattern(Pattern.compile("Message_([0-9]+)_(Reward.*)"));
		while(matcher.find()) {
			if(messages[Integer.valueOf(matcher.group(1))].getRewards()==null)
				messages[Integer.valueOf(matcher.group(1))].setRewards("");
			messages[Integer.valueOf(matcher.group(1))].setRewards(messages[Integer.valueOf(matcher.group(1))].getRewards() + matcher.group(2) + "\n");
		}
		//Get message response indexes
		matcher.reset();
		matcher.usePattern(Pattern.compile("Message_([0-9]+)_Response_[0-9]+ ([0-9]+)"));
		while(matcher.find()) {
			messages[Integer.valueOf(matcher.group(1))].addResponseIndex(Integer.valueOf(matcher.group(2)));
		}
		
		//Get message English section
		englishMatcher.reset();
		englishMatcher.usePattern(Pattern.compile("Message_([0-9]+)_Page_[0-9]+ (.*)"));
		while(englishMatcher.find()) {
			messages[Integer.valueOf(englishMatcher.group(1))].addText(englishMatcher.group(2));
		}
		
		/*
		 * RESPONSE SECTION
		 */
		
		//Get response conditions
		matcher.reset();
		matcher.usePattern(Pattern.compile("Response_([0-9]+)_(Condition.*)"));
		while(matcher.find()) {
			if(responses[Integer.valueOf(matcher.group(1))].getConditions()==null)
				responses[Integer.valueOf(matcher.group(1))].setConditions("");
			responses[Integer.valueOf(matcher.group(1))].setConditions(responses[Integer.valueOf(matcher.group(1))].getConditions() + matcher.group(2) + "\n");
		}
		//Get response rewards
		matcher.reset();
		matcher.usePattern(Pattern.compile("Response_([0-9]+)_(Reward.*)"));
		while(matcher.find()) {
			if(responses[Integer.valueOf(matcher.group(1))].getRewards()==null)
				responses[Integer.valueOf(matcher.group(1))].setRewards("");
			responses[Integer.valueOf(matcher.group(1))].setRewards(responses[Integer.valueOf(matcher.group(1))].getRewards() + matcher.group(2) + "\n");
		}
		//Get messages to show this response for
		matcher.reset();
		matcher.usePattern(Pattern.compile("Response_([0-9]+)_Message_[0-9]+ ([0-9]+)"));
		while(matcher.find()) {
			responses[Integer.valueOf(matcher.group(1))].addMessageIndexes(Integer.valueOf(matcher.group(2)));;
		}
		
		//Get onClick
		matcher.reset();
		matcher.usePattern(Pattern.compile("Response_([0-9]+)_(Quest|Dialogue|Vendor) ([0-9]+)"));
		while(matcher.find()) {
			if(matcher.group(2).equals("Dialogue"))
				responses[Integer.valueOf(matcher.group(1))].setDialogueID(matcher.group(3));
			if(matcher.group(2).equals("Quest"))
				responses[Integer.valueOf(matcher.group(1))].setQuestID(matcher.group(3));
			if(matcher.group(2).equals("Vendor"))
				responses[Integer.valueOf(matcher.group(1))].setVendorID(matcher.group(3));	
		}
		
		//Get response English section
		englishMatcher.reset();
		englishMatcher.usePattern(Pattern.compile("Response_([0-9]+) (.*)"));
		while(englishMatcher.find()) {
			responses[Integer.valueOf(englishMatcher.group(1))].setText(englishMatcher.group(2));
		}
		
		//Add messages to message panel
		for(int i = 0; i < messages.length; i++) {
			tabbedPane.addTab("Mes#" + i, messages[i]);
			for(int ii = 0; ii < messages[i].getResponseIndexes().size(); ii++) {
				messages[i].addResponse(responses[messages[i].getResponseIndexes().get(ii)]);
			}
		}
	}
}
