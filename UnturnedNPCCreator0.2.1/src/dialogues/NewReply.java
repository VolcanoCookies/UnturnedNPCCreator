package dialogues;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import conditions.Conditions;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class NewReply extends JPanel {

	private JTextArea textAreaReply;
	public Component comp;
	private JLabel lblResponseIndex;
	private final Action actionRemove = new SwingActionRemove();
	private final Action actionOpenConditions = new SwingActionOpenConditions();
	private String conditions;
	private final Action actionClearCondition = new SwingActionClearCondition();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldDialogueID;
	private JTextField textFieldQuestID;
	private JTextField textFieldVendorID;
	/**
	 * Create the panel.
	 */
	public NewReply() {
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
		gridBagLayout.rowHeights = new int[]{0, 0, 39, 36, 88, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblResponseIndex = new JLabel("Response #");
		lblResponseIndex.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblResponseIndex = new GridBagConstraints();
		gbc_lblResponseIndex.insets = new Insets(0, 0, 5, 0);
		gbc_lblResponseIndex.gridx = 0;
		gbc_lblResponseIndex.gridy = 0;
		add(lblResponseIndex, gbc_lblResponseIndex);
		
		JLabel lblOnClick = new JLabel("On Click");
		GridBagConstraints gbc_lblOnClick = new GridBagConstraints();
		gbc_lblOnClick.insets = new Insets(0, 0, 5, 0);
		gbc_lblOnClick.gridx = 0;
		gbc_lblOnClick.gridy = 1;
		add(lblOnClick, gbc_lblOnClick);
		
		JPanel panelOnClick = new JPanel();
		GridBagConstraints gbc_panelOnClick = new GridBagConstraints();
		gbc_panelOnClick.insets = new Insets(0, 0, 5, 0);
		gbc_panelOnClick.fill = GridBagConstraints.BOTH;
		gbc_panelOnClick.gridx = 0;
		gbc_panelOnClick.gridy = 2;
		add(panelOnClick, gbc_panelOnClick);
		
		JCheckBox checkBoxDialogue = new JCheckBox("Dialogue");
		panelOnClick.add(checkBoxDialogue);
		
		JCheckBox checkBoxQuest = new JCheckBox("Quest");
		panelOnClick.add(checkBoxQuest);
		
		JCheckBox checkBoxVendor = new JCheckBox("Vendor");
		panelOnClick.add(checkBoxVendor);
		
		JCheckBox checkBoxReward = new JCheckBox("Reward");
		panelOnClick.add(checkBoxReward);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 3;
		add(tabbedPane, gbc_tabbedPane);
		
		JPanel panelDialogue = new JPanel();
		tabbedPane.addTab("Dialogue", null, panelDialogue, null);
		GridBagLayout gbl_panelDialogue = new GridBagLayout();
		gbl_panelDialogue.columnWidths = new int[]{66, 0, 0};
		gbl_panelDialogue.rowHeights = new int[]{0, 0};
		gbl_panelDialogue.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelDialogue.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelDialogue.setLayout(gbl_panelDialogue);
		
		JLabel lblDialogueID = new JLabel("Dialogue ID");
		GridBagConstraints gbc_lblDialogueID = new GridBagConstraints();
		gbc_lblDialogueID.insets = new Insets(0, 0, 0, 5);
		gbc_lblDialogueID.anchor = GridBagConstraints.EAST;
		gbc_lblDialogueID.gridx = 0;
		gbc_lblDialogueID.gridy = 0;
		panelDialogue.add(lblDialogueID, gbc_lblDialogueID);
		
		textFieldDialogueID = new JTextField();
		GridBagConstraints gbc_textFieldDialogueID = new GridBagConstraints();
		gbc_textFieldDialogueID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDialogueID.gridx = 1;
		gbc_textFieldDialogueID.gridy = 0;
		panelDialogue.add(textFieldDialogueID, gbc_textFieldDialogueID);
		textFieldDialogueID.setColumns(10);
		
		JPanel panelQuest = new JPanel();
		tabbedPane.addTab("Quest", null, panelQuest, null);
		GridBagLayout gbl_panelQuest = new GridBagLayout();
		gbl_panelQuest.columnWidths = new int[]{67, 86, 0};
		gbl_panelQuest.rowHeights = new int[]{20, 0};
		gbl_panelQuest.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelQuest.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelQuest.setLayout(gbl_panelQuest);
		
		JLabel lblQuestID = new JLabel("Quest ID");
		GridBagConstraints gbc_lblQuestID = new GridBagConstraints();
		gbc_lblQuestID.anchor = GridBagConstraints.EAST;
		gbc_lblQuestID.insets = new Insets(0, 0, 0, 5);
		gbc_lblQuestID.gridx = 0;
		gbc_lblQuestID.gridy = 0;
		panelQuest.add(lblQuestID, gbc_lblQuestID);
		
		textFieldQuestID = new JTextField();
		textFieldQuestID.setColumns(10);
		GridBagConstraints gbc_textFieldQuestID = new GridBagConstraints();
		gbc_textFieldQuestID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldQuestID.anchor = GridBagConstraints.NORTH;
		gbc_textFieldQuestID.gridx = 1;
		gbc_textFieldQuestID.gridy = 0;
		panelQuest.add(textFieldQuestID, gbc_textFieldQuestID);
		
		JPanel panelVendor = new JPanel();
		tabbedPane.addTab("Vendor", null, panelVendor, null);
		GridBagLayout gbl_panelVendor = new GridBagLayout();
		gbl_panelVendor.columnWidths = new int[]{77, 86, 0};
		gbl_panelVendor.rowHeights = new int[]{20, 0};
		gbl_panelVendor.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelVendor.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelVendor.setLayout(gbl_panelVendor);
		
		JLabel lblVendorID = new JLabel("Vendor ID");
		GridBagConstraints gbc_lblVendorID = new GridBagConstraints();
		gbc_lblVendorID.anchor = GridBagConstraints.EAST;
		gbc_lblVendorID.insets = new Insets(0, 0, 0, 5);
		gbc_lblVendorID.gridx = 0;
		gbc_lblVendorID.gridy = 0;
		panelVendor.add(lblVendorID, gbc_lblVendorID);
		
		textFieldVendorID = new JTextField();
		textFieldVendorID.setColumns(10);
		GridBagConstraints gbc_textFieldVendorID = new GridBagConstraints();
		gbc_textFieldVendorID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVendorID.anchor = GridBagConstraints.NORTH;
		gbc_textFieldVendorID.gridx = 1;
		gbc_textFieldVendorID.gridy = 0;
		panelVendor.add(textFieldVendorID, gbc_textFieldVendorID);
		
		JPanel panelReward = new JPanel();
		tabbedPane.addTab("Reward", null, panelReward, null);
		
		textAreaReply = new JTextArea();
		textAreaReply.setToolTipText("Separate pages with <p>");
		GridBagConstraints gbc_textAreaReply = new GridBagConstraints();
		gbc_textAreaReply.fill = GridBagConstraints.BOTH;
		gbc_textAreaReply.gridx = 0;
		gbc_textAreaReply.gridy = 4;
		add(textAreaReply, gbc_textAreaReply);
		addPopup(textAreaReply, popupMenu);
		
		JMenuItem menuItemClearConditions = new JMenuItem("Condition");
		menuItemClearConditions.setAction(actionClearCondition);
		popupMenu.add(menuItemClearConditions);

	}
	
	public String[] getValues()
	{
		String[] output = new String[2];
		
		output[0] = textAreaReply.getText();
//		if(conditions!=null)
//		{
//			output[2] = conditions;
//			System.out.println("Conditions not null");
//		} else {
//			System.out.println("Conditions null");
//		}
		
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
	private class SwingActionOpenConditions extends AbstractAction {
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
		JPanel ConditionsPanel = new Conditions();
		JDialog dialog = new JDialog(new JFrame(), Dialog.ModalityType.APPLICATION_MODAL);
		dialog.getContentPane().add(ConditionsPanel);
		dialog.requestFocus();
		dialog.toFront();
		dialog.setSize(new Dimension(500,350));
		dialog.setMinimumSize(new Dimension(500,350));
		dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		dialog.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Save","Cancel","Exit"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"You are about to exit, would you like to save?","Are you sure?",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[0]);
		        if(PromptResult==0)
		        {
		        	conditions = ((Conditions) ConditionsPanel).Save();
		        	setBackground(new Color(255,206,213));
		            dialog.dispose();
		        } else if (PromptResult==2)
		        	dialog.dispose();
		    }
		});
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		dialog.setSize(580, 475);
		dialog.setLocationRelativeTo(null);
		dialog.pack();
		dialog.setVisible(true);
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
}
