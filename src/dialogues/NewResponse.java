package dialogues;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import conditions.Conditions;
import conditions.conditionsDialog;
import objects.TextPrompt;
import rewards.RewardsDialog;

import javax.swing.text.JTextComponent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

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
	private String rewards;
	private int thisIndex;
	private int globalIndex;
	/**
	 * Create the panel.
	 */
	public NewResponse() {
		comp = this;
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		
		JMenuItem menuItemRemove = new JMenuItem("Remove");
		menuItemRemove.setAction(actionRemove);
		popupMenu.add(menuItemRemove);
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
		
		addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				panelOnClick.setBackground(getBackground());
			}
		});

	}
	
	public String[] getValues(int messageIndex)
	{
		//Index 0 is Asset.dat, Index 1 is English.dat
		String[] output = new String[2];
		
		//Temporary strings
		String rewardsOutput;
		
		output[0] = "Response_ " + globalIndex + " " + textAreaReply.getText();
		if(rewards!=null) {
			rewardsOutput = "";
			for(String string : rewards.split("\n")) {
				rewardsOutput += "Response_" + globalIndex + "_" + string;
			}
		}
		output[1] = "Response_" + globalIndex + " " + textAreaReply.getText();
		
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
		thisIndex = index;
	}
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
			OpenConditions();
		}
	}
	private void OpenConditions()
	{
		conditions = conditionsDialog.ConditionsDialog(conditions);
		if(conditions!=null) {
			setBackground(new Color(255,206,213));
		} else {
			setBackground(getParent().getBackground());
		}
	}
	private class SwingActionClearCondition extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -31330229355713318L;
		public SwingActionClearCondition() {
			putValue(NAME, "Clear conditions");
			putValue(SHORT_DESCRIPTION, "Clear current conditions for this response");
		}
		public void actionPerformed(ActionEvent e) {
			String ObjButtons[] = {"Yes","No"};
	        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure?","Are you sure?",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[0]);
	        if(PromptResult==0)
	        {
	        	conditions = null;
	        	setBackground(getParent().getBackground());
	        } 
		}
	}
	private class SwingActionOpenRewards extends AbstractAction {
		public SwingActionOpenRewards() {
			putValue(NAME, "Open rewards");
			putValue(SHORT_DESCRIPTION, "Open the rewards editor.");
		}
		public void actionPerformed(ActionEvent e) {
			rewards = RewardsDialog.Dialog(rewards);
		}
	}
	public void setGlobalIndex(int index) {
		globalIndex = index;
		System.out.println(globalIndex + "\t" + this.getName());
	}
}
