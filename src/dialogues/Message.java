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
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.JTextField;

public class Message extends JPanel {
	
	String index;
	String conditions;
	String rewards;
	
	//Indexes in dialogue file for the responses for this message.
	List<Integer> responseIndexes = new ArrayList<Integer>();
	
	//Array is for pages.
	List<String> text = new ArrayList<String>();
	
	//Index of message to go back to
	int returnMessageIndex = 0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2705985586487282881L;
	private JPanel panelResponses;
	public Component comp;
	private JLabel lblMessage;
	private final Action actionOpenConditions = new SwingActionOpenConditions();
	private final Action actionClearCondition = new SwingActionClearCondition();
	private final Action actionOpenRewards = new SwingActionOpenRewards();
	private final Action actionClearRewards = new SwingActionClearRewards();
	private final Action actionAddReply = new SwingActionAddReply();
	private final Action actionRemove = new SwingActionRemove();
	private TextPrompt textPrompt;
	private JTextArea textArea;
	private boolean hasConditionColor = false;
	private boolean hasRewardColor = false;
	private JTextField textFieldPrevID;

	/**
	 * Create the panel.
	 * @param messageAsset 
	 * @param messageResponses 
	 * @param messageResponsesEnglish 
	 */
	public Message() {
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
		
		textFieldPrevID = new JTextField();
		textPrompt = new TextPrompt("Message ID to go back to, usualy doesnt have to be set", textFieldPrevID);
		textPrompt.changeAlpha(128);
		panelDialogueType.add(textFieldPrevID, BorderLayout.SOUTH);
		textFieldPrevID.setColumns(10);
		
		panelResponses = new JPanel();
		panelResponses.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelResponses.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				for(int i = 0; i < panelResponses.getComponentCount(); i++)
				{
					((Response) panelResponses.getComponent(i)).ChangeIndex(i+1);
				}
				
				panelResponses.repaint();
				panelResponses.revalidate();
			}
			@Override
			public void componentRemoved(ContainerEvent e) {
				for(int i = 0; i < panelResponses.getComponentCount(); i++)
				{
					((Response) panelResponses.getComponent(i)).ChangeIndex(i+1);
				}
				
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
		panelResponses.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton buttonAddReply = new JButton("New button");
		buttonAddReply.setAction(actionAddReply);
		GridBagConstraints gbc_buttonAddReply = new GridBagConstraints();
		gbc_buttonAddReply.gridwidth = 2;
		gbc_buttonAddReply.gridx = 0;
		gbc_buttonAddReply.gridy = 3;
		add(buttonAddReply, gbc_buttonAddReply);
		
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
			panelResponses.add(new Response());
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
	
	public Component[] getResponses() {
		return panelResponses.getComponents();
	}

	public void ConditionsPresent() {
		
		if(this.conditions!=null && !hasConditionColor) {
			comp.setBackground(new Color(comp.getBackground().getRed() - 30, comp.getBackground().getGreen(), comp.getBackground().getBlue() - 30));
			hasConditionColor = true;
		}
		else if (this.conditions==null && hasConditionColor){
			comp.setBackground(new Color(comp.getBackground().getRed() + 30, comp.getBackground().getGreen(), comp.getBackground().getBlue() + 30));
			hasConditionColor = false;
		}
		comp.revalidate();
		comp.repaint();
	}
	public void RewardsPresent() {
		if(this.rewards!=null && !hasRewardColor) {
			comp.setBackground(new Color(comp.getBackground().getRed() - 30, comp.getBackground().getGreen(), comp.getBackground().getBlue() - 30));
			hasRewardColor = true;
		}
		else if (this.rewards==null && hasRewardColor){
			comp.setBackground(new Color(comp.getBackground().getRed() + 30, comp.getBackground().getGreen(), comp.getBackground().getBlue() + 30));
			hasRewardColor = false;
		}
			
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
			ConditionsPresent();
			
			conditions = conditionsDialog.ConditionsDialog(conditions);
				
			//Change color to more red
			ConditionsPresent();
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
					ConditionsPresent();
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
				RewardsPresent();
			
			rewards = RewardsDialog.Dialog(rewards);
				
			//Change color to more green
			if(rewards!=null)
				RewardsPresent();
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
					RewardsPresent();
				rewards = null;
	        }
		}
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getRewards() {
		return rewards;
	}
	public void setRewards(String rewards) {
		this.rewards = rewards;
	}
	public List<Integer> getResponseIndexes() {
		return responseIndexes;
	}
	public void setResponseIndexes(List<Integer> responseIndexes) {
		this.responseIndexes = responseIndexes;
	}
	public List<String> getText() {
		return text;
	}
	public void addText(String text) {
		textArea.setText(textArea.getText() + text);
		this.text.add(text);
	}
	public int getReturnMessageIndex() {
		return returnMessageIndex;
	}
	public void setReturnMessageIndex(int returnMessageIndex) {
		textFieldPrevID.setText(Integer.toString(returnMessageIndex));
		this.returnMessageIndex = returnMessageIndex;
	}
	public void addReturnMessageIndex(int returnMessageIndex) {

		this.returnMessageIndex = returnMessageIndex;
	}
	public void addResponseIndex(int index) {
		this.responseIndexes.add(index);
	}

	public String[] CompileMessage() {
		//Asset.dat is 0, English.dat is 1
		String output[] = new String[2];
		output[0] = "";
		output[1] = "";
		
		//Get message pages
		output[0] += "Message_" + this.index + "_Pages " + (textArea.getText().split("<p>").length) + "\n";
		
		
		//Get responses
		if(this.responseIndexes.size()>0) {
			output[0] += "Message_" + this.index + "_Responses " + this.responseIndexes.size() + "\n";
			for(int i = 0; i < this.responseIndexes.size(); i++) {
				output[0] += "Message_" + this.index + "_Response_" + i + " " + this.responseIndexes.get(i) + "\n";
			}
		}
		
		//Get previous dialogue to go back to
		if(this.returnMessageIndex!=0)
			output[0] += "Message_" + this.index + "_Prev " + this.returnMessageIndex + "\n";
		
		//Get message conditions and rewards
		if(this.conditions!=null) {
			for(String string : this.conditions.split("\n")) {
				output[0] += "Message_" + this.index + "_" + string + "\n";
			}
		}
		if(this.rewards!=null) {
			for(String string : this.rewards.split("\n")) {
				output[0] += "Message_" + this.index + "_" + string + "\n";
			}
		}
		
		//Get English text
		for(int i = 0; i < text.size(); i++) {
			output[1] += "Message_" + this.index + "_Page_" + i + " " + text.get(i);
		}
				
		return output;
	}

	public void addResponse(Response response) {
		panelResponses.add(response);
	}
}
