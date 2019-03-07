package dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import conditions.conditionsDialog;
import objects.TextPrompt;

public class NewMessage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2705985586487282881L;
	private final Action actionAddReply = new SwingActionAddReply();
	private JPanel panelResponses;
	private final Action actionRemove = new SwingActionRemove();
	public Component comp;
	private JLabel lblMessage;
	protected String conditions;
	private final Action actionOpenConditions = new SwingActionOpenConditions();
	private final Action actionClearCondition = new SwingActionClearCondition();
	private TextPrompt textPrompt;
	private int thisIndex;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public NewMessage() {
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
		
		JMenuItem menuItemConditions = new JMenuItem("New menu item");
		menuItemConditions.setAction(actionOpenConditions);
		popupMenu.add(menuItemConditions);
		
		JMenuItem menuItemClearConditions = new JMenuItem("Clear conditions");
		menuItemClearConditions.setAction(actionClearCondition);
		popupMenu.add(menuItemClearConditions);
		
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
			panelResponses.add(new NewResponse());
		}
	}
	
	NewResponse[] getResponses() {
		if(getResponseCount()>0)
			return (NewResponse[]) panelResponses.getComponents();
		else
			return null;
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
	
	private String[] getValues() {
		//Index 0 is for Asset.dat, Index 1 is for English.dat
		String[] output = new String[2];
		
		output[1] = "";
		if(textArea.getText().toLowerCase().contains("<p>")) {
			//Split text by "<p>".
			String[] messagePages = textArea.getText().split("<p>");
			for(int i = 0; i < messagePages.length; i++) {
				output[1] += "Message_" + thisIndex + "_Page_" + i + " " + messagePages[i].replace("\n", "<br>" + "\n");
				output[0] += "Message_" + thisIndex + "_Pages " + messagePages.length + "\n";
			}
		} else {
			//Only one page, no <p> found in text.
			output[1] += "Message_" + thisIndex + "_Page_0 " + textArea.getText().replace("\n", "<br>" + "\n");
		}
		
		output[0] += "Message_" + thisIndex + "_Responses " + panelResponses.getComponentCount()  + "\n";
		
		
		for(Component comp : panelResponses.getComponents()) {
			((NewResponse) comp).getValues(thisIndex);
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
		lblMessage.setText(" Message #" + index + " ");
		thisIndex = index;
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
	private class SwingActionOpenConditions extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -7782457173747717780L;
		public SwingActionOpenConditions() {
			putValue(NAME, "Add conditions");
			putValue(SHORT_DESCRIPTION, "Add conditions to this message");
		}
		public void actionPerformed(ActionEvent e) {
			OpenConditions();
		}
	}
}
