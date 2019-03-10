package dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import conditions.conditionsDialog;
import objects.TextPrompt;
import rewards.RewardsDialog;

public class NewMessage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2705985586487282881L;
	private JPanel panelResponses;
	public Component comp;
	private JLabel lblMessage;
	protected String conditions;
	private final Action actionOpenConditions = new SwingActionOpenConditions();
	private final Action actionClearCondition = new SwingActionClearCondition();
	private final Action actionOpenRewards = new SwingActionOpenRewards();
	private final Action actionClearRewards = new SwingActionClearRewards();
	private final Action actionAddReply = new SwingActionAddReply();
	private final Action actionRemove = new SwingActionRemove();
	private TextPrompt textPrompt;
	private int thisIndex;
	private JTextArea textArea;
	private String rewards;

	/**
	 * Create the panel.
	 * @param messageAsset 
	 * @param messageResponses 
	 * @param messageResponsesEnglish 
	 */
	public NewMessage(int messageIndex, String[] values) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		comp = this;
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		
		JMenuItem menuItemRemoveMessage = new JMenuItem("New menu item");
		menuItemRemoveMessage.setAction(actionRemove);
		popupMenu.add(menuItemRemoveMessage);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 89, 35, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblMessage = new JLabel("Message #");
		lblMessage.setToolTipText("Separate pages with <p>");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.gridwidth = 2;
		gbc_lblMessage.insets = new Insets(0, 0, 5, 0);
		gbc_lblMessage.gridx = 0;
		gbc_lblMessage.gridy = 0;
		add(lblMessage, gbc_lblMessage);
		
		JPanel panelDialogueType = new JPanel();
		GridBagConstraints gbc_panelDialogueType = new GridBagConstraints();
		gbc_panelDialogueType.insets = new Insets(0, 0, 5, 0);
		gbc_panelDialogueType.gridwidth = 2;
		gbc_panelDialogueType.fill = GridBagConstraints.BOTH;
		gbc_panelDialogueType.gridx = 0;
		gbc_panelDialogueType.gridy = 1;
		add(panelDialogueType, gbc_panelDialogueType);
		panelDialogueType.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textPrompt = new TextPrompt("Text shown for this message. Separate pages with <p>", textArea);
		textPrompt.changeAlpha(128);
		textArea.setLineWrap(true);
		textArea.setToolTipText("Separate pages with <p>");
		panelDialogueType.add(textArea);
		addPopup(textArea, popupMenu);
		
		JSeparator separator_1 = new JSeparator();
		popupMenu.add(separator_1);
		
		JMenuItem menuItemConditions = new JMenuItem("New menu item");
		menuItemConditions.setAction(actionOpenConditions);
		popupMenu.add(menuItemConditions);
		
		JMenuItem menuItemClearConditions = new JMenuItem("Clear conditions");
		menuItemClearConditions.setAction(actionClearCondition);
		popupMenu.add(menuItemClearConditions);
		
		JSeparator separator = new JSeparator();
		popupMenu.add(separator);
		
		JMenuItem menuItemAddRewards = new JMenuItem("New menu item");
		menuItemAddRewards.setAction(actionOpenRewards);
		popupMenu.add(menuItemAddRewards);
		
		JMenuItem menuItemClearRewards = new JMenuItem("New menu item");
		menuItemClearRewards.setAction(actionClearRewards);
		popupMenu.add(menuItemClearRewards);
		
		panelResponses = new JPanel();
		panelResponses.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelResponses.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				for(int i = 0; i < panelResponses.getComponentCount(); i++)
				{
					((NewResponse) panelResponses.getComponent(i)).ChangeIndex(i+1);
				}
				
				DialoguePanel.reorganizeGlobalIndex();
				
				panelResponses.repaint();
				panelResponses.revalidate();
			}
			@Override
			public void componentRemoved(ContainerEvent e) {
				for(int i = 0; i < panelResponses.getComponentCount(); i++)
				{
					((NewResponse) panelResponses.getComponent(i)).ChangeIndex(i+1);
				}
				
				DialoguePanel.reorganizeGlobalIndex();
				
				panelResponses.repaint();
				panelResponses.revalidate();
			}
		});
		GridBagConstraints gbc_panelReplies = new GridBagConstraints();
		gbc_panelReplies.insets = new Insets(0, 0, 5, 0);
		gbc_panelReplies.gridwidth = 2;
		gbc_panelReplies.fill = GridBagConstraints.BOTH;
		gbc_panelReplies.gridx = 0;
		gbc_panelReplies.gridy = 2;
		add(panelResponses, gbc_panelReplies);
		panelResponses.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton buttonAddReply = new JButton("New button");
		buttonAddReply.setAction(actionAddReply);
		GridBagConstraints gbc_buttonAddReply = new GridBagConstraints();
		gbc_buttonAddReply.gridwidth = 2;
		gbc_buttonAddReply.gridx = 0;
		gbc_buttonAddReply.gridy = 3;
		add(buttonAddReply, gbc_buttonAddReply);

		if(values!=null) {
			FillFields(messageIndex, values);
		}
		
	}

	private void FillFields(int messageIndex, String values[]) {
		//0 is for Asset.dat, 1 is for English.dat
		
		//Temporary variable
		String stringEnglish = "";
		String[][] responses = null;
		Integer[] responsesIndex = null;
		int addedResponses = 0;
		
		//Process English string
		for(String string : values[1].split("\n")) {
			if(string.toLowerCase().contains("message_" + messageIndex + "_page")) {
				if(stringEnglish.length()>1)
					stringEnglish += "<p>";
				Matcher matcher = Pattern.compile("Message_[0-9]+_Page_[0-9]+ ").matcher(string);
				stringEnglish += matcher.replaceAll("");
			}
		}
		textArea.setText(stringEnglish);
		
		//Get message conditions and rewards
		for(String string : values[0].split("\n")) {
			if(string.toLowerCase().contains("message_" + messageIndex + "_condition")) {
				if(conditions==null)
					conditions = "";
				conditions += string + "\n";
			}
			if(string.toLowerCase().contains("message_" + messageIndex + "_reward")) {
				if(rewards==null)
					rewards = "";
				rewards += string + "\n";
			}
		}
		
		//Get number of responses
		for(String string : values[0].split("\n")) {
			if(string.toLowerCase().contains("message_" + messageIndex + "_responses ")) {
				responses = new String[2][Integer.valueOf(string.split(" ")[1])];
				responsesIndex = new Integer[Integer.valueOf(string.split(" ")[1])];
			}
			if(string.toLowerCase().contains("message_" + messageIndex + "_response_")) {
				responsesIndex[addedResponses++] = Integer.valueOf(string.split(" ")[1]);
			}
		}
		
		String[] temp = values[0].split("\n");
		
		//Get responses content
		for(int type = 0; type < 2; type++) {
			if(responsesIndex!=null) {
				for(int responseNumber = 0; responseNumber < responsesIndex.length; responseNumber++) {
					for(int i = 0; i < temp.length; i++) {
						if(temp[i].toLowerCase().contains("response_" + responsesIndex[responseNumber]) && !temp[i].toLowerCase().contains("_response_")) {
							if(responses[type][responseNumber]==null)
								responses[type][responseNumber] = "";
							responses[type][responseNumber] += temp[i] + "\n";
						}
					}
				}
				temp = values[1].split("\n");
			}
		}
		
		//Change appropriate color
		if(conditions!=null) {
			ConditionsPresent(true);
		}
		if(rewards!=null) {
			RewardsPresent(true);
		}		
		
//		if(responses!=null) {
//		for(String string : responses[0])
//			System.out.println(string);
//		for(String string : responses[1])
//			System.out.println(string);
//		}
		
		//Create responses
		if(responses!=null) {
			for(int i = 0; i < responses[0].length; i++) {
				panelResponses.add(new NewResponse(responses[0][i], responses[1][i]));
			}
		}
		
	}

	private class SwingActionAddReply extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1736116289006795993L;
		public SwingActionAddReply() {
			putValue(NAME, "New response");
			putValue(SHORT_DESCRIPTION, "Add a new response.");
		}
		public void actionPerformed(ActionEvent e) {
			panelResponses.add(new NewResponse(null, null));
		}
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	int getResponseCount() {
		return panelResponses.getComponentCount();
	}
	
	String[] getValues() {
		//Index 0 is for Asset.dat, Index 1 is for English.dat
		String[] output = new String[2];
		
		//Temporary variables
		String conditionsOutput = "";
		String rewardsOutput = "";
		String[] messagePages = textArea.getText().split("<p>");
		
		output[1] = "";
		
		//Generate English.dat
		//Split text by "<p>".
		for(int i = 0; i < messagePages.length; i++) {
			output[1] += "Message_" + thisIndex + "_Page_" + i + " " + messagePages[i].replace("\n", "<br>") + "\n";
		}
		
		//Set number of message pages and responses
		output[0] = "Message_" + thisIndex + "_Pages " + messagePages.length + "\n";
		output[0] += "Message_" + thisIndex + "_Responses " + panelResponses.getComponentCount()  + "\n";
		
		//Get response globalIndexes
		for(int i = 0; i < panelResponses.getComponentCount(); i++)
			output[0] += "Message_" + thisIndex + "_Response_" + i + " " + ((NewResponse) panelResponses.getComponent(i)).getGlobalIndex() + "\n";
		
		//Get conditions
		if(conditions!=null) {
			for(String string : conditions.split("\n")) {
				conditionsOutput += "Message_" + thisIndex + "_" + string + "\n";
			}
			output[0] += conditionsOutput;
		}
		
		//Get rewards
		if(rewards!=null) {
			for(String string : rewards.split("\n")) {
				rewardsOutput += "Message_" + thisIndex + "_" + string + "\n";
			}
			output[0] += rewardsOutput;
		}
		
		//Get responses
		for(Component comp : panelResponses.getComponents()) {
			String[] response = ((NewResponse) comp).getValues(thisIndex);
			output[0] += "\n" + response[0];
			output[1] += "\n" + response[1];
		}
		
		return output;
	}
	
	private class SwingActionRemove extends AbstractAction {
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 2933271674152307091L;
		public SwingActionRemove() {
			putValue(NAME, "Remove message");
			putValue(SHORT_DESCRIPTION, "Remove this message.");
		}
		public void actionPerformed(ActionEvent e) {
			getParent().remove(comp);
		}
	}
	
	public void ChangeIndex(int index) {
		lblMessage.setText(" Message #" + (index + 1) + " ");
		thisIndex = index;
	}
	public Component[] getResponses() {
		return panelResponses.getComponents();
	}

	public void ConditionsPresent(boolean isPresent) {
		
		if(isPresent)
			comp.setBackground(new Color(comp.getBackground().getRed(), comp.getBackground().getGreen() - 30, comp.getBackground().getBlue() - 30));
		else
			comp.setBackground(new Color(comp.getBackground().getRed(), comp.getBackground().getGreen() + 30, comp.getBackground().getBlue() + 30));
		comp.revalidate();
		comp.repaint();
	}
	public void RewardsPresent(boolean isPresent) {
		if(isPresent)
			comp.setBackground(new Color(comp.getBackground().getRed() - 30, comp.getBackground().getGreen(), comp.getBackground().getBlue() - 30));
		else
			comp.setBackground(new Color(comp.getBackground().getRed() + 30, comp.getBackground().getGreen(), comp.getBackground().getBlue() + 30));
		comp.revalidate();
		comp.repaint();
	}
	
	//Conditions and rewards actions.
	private class SwingActionOpenConditions extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1227819414645128804L;
		public SwingActionOpenConditions() {
			putValue(NAME, "Add conditions");
			putValue(SHORT_DESCRIPTION, "Open the conditions window.");
		}
		public void actionPerformed(ActionEvent e) {
			//Change color to less red
			if(conditions!=null)
				ConditionsPresent(false);
			
			conditions = conditionsDialog.ConditionsDialog(conditions);
				
			//Change color to more red
			if(conditions!=null)
				ConditionsPresent(true);
		}
	}
	private class SwingActionClearCondition extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8044852770132039349L;
		public SwingActionClearCondition() {
			putValue(NAME, "Clear conditions");
			putValue(SHORT_DESCRIPTION, "Clear current conditions for this message.");
		}
		public void actionPerformed(ActionEvent e) {
			String ObjButtons[] = {"Yes","No"};
	        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure?","Are you sure you want to clear conditions?",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[0]);
	        if(PromptResult==0)
	        {
	        	//Change color to less red
				if(conditions!=null)
					ConditionsPresent(false);
				conditions = null;
	        } 
		}
	}
	private class SwingActionOpenRewards extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1828029442225506423L;
		public SwingActionOpenRewards() {
			putValue(NAME, "Open rewards");
			putValue(SHORT_DESCRIPTION, "Open the rewards window.");
		}
		public void actionPerformed(ActionEvent e) {
			//Change color to less green
			if(rewards!=null)
				RewardsPresent(false);
			
			rewards = RewardsDialog.Dialog(rewards);
				
			//Change color to more green
			if(rewards!=null)
				RewardsPresent(true);
		}
	}
	private class SwingActionClearRewards extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8954594618308736149L;
		public SwingActionClearRewards() {
			putValue(NAME, "Clear rewards");
			putValue(SHORT_DESCRIPTION, "Clear the rewards for this message.");
		}
		public void actionPerformed(ActionEvent e) {
			String ObjButtons[] = {"Yes","No"};
	        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to clear rewards?","",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[0]);
	        if(PromptResult==0)
	        {
				//Change color to less green
				if(rewards!=null)
					RewardsPresent(false);
				rewards = null;
	        }
		}
	}
}
