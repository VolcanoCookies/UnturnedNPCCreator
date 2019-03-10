package dialogues;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import conditions.conditionsDialog;
import objects.TextPrompt;
import rewards.RewardsDialog;
import javax.swing.JSeparator;

public class NewResponse extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3010487946578431869L;
	private JTextArea textAreaReply;
	public Component comp;
	private JLabel lblResponseIndex;
	private final Action actionRemove = new SwingActionRemove();
	private final Action actionOpenConditions = new SwingActionOpenConditions();
	private String conditions;
	private final Action actionClearCondition = new SwingActionClearCondition();
	private JTextField textFieldDialogueID;
	private JTextField textFieldQuestID;
	private JTextField textFieldVendorID;
	private TextPrompt textPrompt;
	private final Action actionOpenRewards = new SwingActionOpenRewards();
	private final Action actionClearRewards = new SwingActionClearRewards();
	private String rewards;
	private int globalIndex;
	/**
	 * Create the panel.
	 * @param response 
	 */
	public NewResponse(String responseAsset, String responseEnglish) {
		comp = this;
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		
		JMenuItem menuItemRemove = new JMenuItem("Remove");
		menuItemRemove.setAction(actionRemove);
		popupMenu.add(menuItemRemove);
		
		JSeparator separator = new JSeparator();
		popupMenu.add(separator);
		JMenuItem menuItemNewCondition = new JMenuItem("Condition");
		menuItemNewCondition.setAction(actionOpenConditions);
		popupMenu.add(menuItemNewCondition);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 11, 85, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblResponseIndex = new JLabel("Response #");
		lblResponseIndex.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblResponseIndex = new GridBagConstraints();
		gbc_lblResponseIndex.insets = new Insets(0, 0, 5, 0);
		gbc_lblResponseIndex.gridx = 0;
		gbc_lblResponseIndex.gridy = 0;
		add(lblResponseIndex, gbc_lblResponseIndex);
		
		JPanel panelOnClick = new JPanel();
		GridBagConstraints gbc_panelOnClick = new GridBagConstraints();
		gbc_panelOnClick.anchor = GridBagConstraints.NORTH;
		gbc_panelOnClick.insets = new Insets(0, 0, 5, 0);
		gbc_panelOnClick.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelOnClick.gridx = 0;
		gbc_panelOnClick.gridy = 1;
		add(panelOnClick, gbc_panelOnClick);
		GridBagLayout gbl_panelOnClick = new GridBagLayout();
		gbl_panelOnClick.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelOnClick.rowHeights = new int[]{0, 0, 0};
		gbl_panelOnClick.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelOnClick.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelOnClick.setLayout(gbl_panelOnClick);
		
		JLabel lblOnClick = new JLabel(" On Click ");
		GridBagConstraints gbc_lblOnClick = new GridBagConstraints();
		gbc_lblOnClick.gridwidth = 4;
		gbc_lblOnClick.insets = new Insets(0, 0, 5, 0);
		gbc_lblOnClick.gridx = 0;
		gbc_lblOnClick.gridy = 0;
		panelOnClick.add(lblOnClick, gbc_lblOnClick);
		lblOnClick.setFont(new Font("Tahoma", Font.ITALIC, 11));
		
		textFieldDialogueID = new JTextField();
		textPrompt = new TextPrompt("Dialogue ID", textFieldDialogueID);
		textPrompt.changeAlpha(128);
		GridBagConstraints gbc_textFieldDialogueID = new GridBagConstraints();
		gbc_textFieldDialogueID.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldDialogueID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDialogueID.gridx = 0;
		gbc_textFieldDialogueID.gridy = 1;
		panelOnClick.add(textFieldDialogueID, gbc_textFieldDialogueID);
		textFieldDialogueID.setColumns(10);
		
		textFieldQuestID = new JTextField();
		textPrompt = new TextPrompt("Quest ID", textFieldQuestID);
		textPrompt.changeAlpha(128);
		textFieldQuestID.setColumns(10);
		GridBagConstraints gbc_textFieldQuestID = new GridBagConstraints();
		gbc_textFieldQuestID.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldQuestID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldQuestID.gridx = 1;
		gbc_textFieldQuestID.gridy = 1;
		panelOnClick.add(textFieldQuestID, gbc_textFieldQuestID);
		
		textFieldVendorID = new JTextField();
		textPrompt = new TextPrompt("Vendor ID", textFieldVendorID);
		textPrompt.changeAlpha(128);
		textFieldVendorID.setColumns(10);
		GridBagConstraints gbc_textFieldVendorID = new GridBagConstraints();
		gbc_textFieldVendorID.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldVendorID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVendorID.gridx = 2;
		gbc_textFieldVendorID.gridy = 1;
		panelOnClick.add(textFieldVendorID, gbc_textFieldVendorID);
		
		JButton buttonAddRewards = new JButton("Add Rewards");
		buttonAddRewards.setAction(actionOpenRewards);
		GridBagConstraints gbc_buttonAddRewards = new GridBagConstraints();
		gbc_buttonAddRewards.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonAddRewards.gridx = 3;
		gbc_buttonAddRewards.gridy = 1;
		panelOnClick.add(buttonAddRewards, gbc_buttonAddRewards);
		
		textAreaReply = new JTextArea();
		textPrompt = new TextPrompt("Text shown for this button.", textAreaReply);
		textPrompt.changeAlpha(128);
		textAreaReply.setToolTipText("Separate pages with <p>");
		GridBagConstraints gbc_textAreaReply = new GridBagConstraints();
		gbc_textAreaReply.fill = GridBagConstraints.BOTH;
		gbc_textAreaReply.gridx = 0;
		gbc_textAreaReply.gridy = 2;
		add(textAreaReply, gbc_textAreaReply);
		addPopup(textAreaReply, popupMenu);
		
		JMenuItem menuItemClearConditions = new JMenuItem("Condition");
		menuItemClearConditions.setAction(actionClearCondition);
		popupMenu.add(menuItemClearConditions);
		
		JSeparator separator_1 = new JSeparator();
		popupMenu.add(separator_1);
		
		JMenuItem menuItemOpenRewards = new JMenuItem("Condition");
		menuItemOpenRewards.setAction(actionOpenRewards);
		popupMenu.add(menuItemOpenRewards);
		
		JMenuItem menuItemClearRewards = new JMenuItem("Condition");
		menuItemClearRewards.setAction(actionClearRewards);
		popupMenu.add(menuItemClearRewards);
		
		addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				panelOnClick.setBackground(getBackground());
			}
		});
		
		if(responseAsset!=null && responseEnglish!=null) {
			FillFields(responseAsset, responseEnglish);
		}
		
	}
	
	private void FillFields(String responseAsset, String responseEnglish) {
		//Matcher
		Matcher matcher;
		
		//Get response conditions, rewards and other info in assets
		for(String string : responseAsset.split("\n")) {
			if(Pattern.compile("response_[0-9]+_condition.*", Pattern.DOTALL).matcher(string.toLowerCase()).matches()) {
				if(conditions==null)
					conditions = "";
				conditions += string + "\n";
			}
			if(Pattern.compile("response_[0-9]+_reward.*", Pattern.DOTALL).matcher(string.toLowerCase()).matches()) {
				if(rewards==null)
					rewards = "";
				rewards += string + "\n";
			}
			if(string.toLowerCase().contains("reponse_[0-9]+_dialogue")) {
				textFieldDialogueID.setText(string.split(" ")[1]);
			}
			if(string.toLowerCase().contains("reponse_[0-9]+_quest")) {
				textFieldQuestID.setText(string.split(" ")[1]);
			}
			if(string.toLowerCase().contains("reponse_[0-9]+_vendor")) {
				textFieldVendorID.setText(string.split(" ")[1]);
			}
		}
		
		//Change appropriate color
		if(conditions!=null) {
			ConditionsPresent(true);
		}
		if(rewards!=null) {
			RewardsPresent(true);
		}
		
		//Get English values
		for(String string : responseEnglish.split("\n")) {
			if(string.toLowerCase().contains("response_")) {
				matcher = Pattern.compile("Response_[0-9]+ ").matcher(string);
				textAreaReply.setText(matcher.replaceAll(""));
			}
		}
		
	}

	public String[] getValues(int messageIndex)
	{
		//Index 0 is Asset.dat, Index 1 is English.dat
		String[] output = new String[2];
		output[0] = "";
		
		//Temporary strings
		String rewardsOutput = null;
		String conditionsOutput = null;
		
		//Add lines if conditions exist
		if(conditions!=null) {
			conditionsOutput = "";
			for(String string : conditions.split("\n")) {
				conditionsOutput += "Response_" + globalIndex + "_" + string + "\n";
			}
		}
		//Add lines if rewards exist
		if(rewards!=null) {
			rewardsOutput = "";
			for(String string : rewards.split("\n")) {
				rewardsOutput += "Response_" + globalIndex + "_" + string + "\n";
			}
		}
		
		//Save onClick
		if(textFieldDialogueID.getText().length()>0)
			output[0] += "Response_" + globalIndex + "_Dialogue " + textFieldDialogueID.getText() + "\n";
		if(textFieldQuestID.getText().length()>0)
			output[0] += "Response_" + globalIndex + "_Quest " + textFieldQuestID.getText() + "\n";
		if(textFieldVendorID.getText().length()>0)
			output[0] += "Response_" + globalIndex + "_Vendor " + textFieldVendorID.getText() + "\n";
		
		//Save rewards and conditions
		if(conditions!=null)
			output[0] += conditionsOutput + "\n";
		if(rewards!=null)
			output[0] += rewardsOutput + "\n";
		
		//Get English.dat
		output[1] = "Response_" + globalIndex + " " + textAreaReply.getText().replaceAll("\n", "") + "\n";
		
		return output;
	}

	private class SwingActionRemove extends AbstractAction {
		private static final long serialVersionUID = -1993521655404817699L;
		public SwingActionRemove() {
			putValue(NAME, "Remove response");
			putValue(SHORT_DESCRIPTION, "Remove this response.");
		}
		public void actionPerformed(ActionEvent e) {
			getParent().remove(comp);
		}
	}
	public void setReply(String reply) {
		textAreaReply.setText(reply);
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

	public void ChangeIndex(int index) {
		lblResponseIndex.setText(" Response #" + index + " ");
	}
	
	public int getGlobalIndex() {
		return globalIndex;
	}
	public void setGlobalIndex(int index) {
		globalIndex = index;
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
		private static final long serialVersionUID = 4586724512787147466L;
		public SwingActionOpenConditions() {
			putValue(NAME, "Add conditions");
			putValue(SHORT_DESCRIPTION, "Add conditions to this response");
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
		private static final long serialVersionUID = -6129364339935782679L;
		public SwingActionClearCondition() {
			putValue(NAME, "Clear conditions");
			putValue(SHORT_DESCRIPTION, "Clear current conditions for this response");
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
		private static final long serialVersionUID = -476946929815141209L;
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
		private static final long serialVersionUID = -8640629465484831938L;
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
