package dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import conditions.Conditions;

public class NewMessage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2705985586487282881L;
	private final Action actionAddReply = new SwingActionAddReply();
	private JPanel panelReplies;
	private final Action actionRemove = new SwingActionRemove();
	public Component comp;
	private JLabel lblMessage;
	protected String conditions;
	private final Action actionOpenConditions = new SwingActionOpenConditions();
	private final Action actionClearCondition = new SwingActionClearCondition();

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
		gridBagLayout.rowHeights = new int[]{0, 89, 67, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblMessage = new JLabel("Message #");
		lblMessage.setToolTipText("Separate pages with <p>");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
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
		
		JTextArea textArea = new JTextArea();
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
		
		panelReplies = new JPanel();
		panelReplies.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelReplies.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				for(int i = 0; i < panelReplies.getComponentCount(); i++)
				{
					((NewReply) panelReplies.getComponent(i)).ChangeIndex(i+1);
				}
				panelReplies.repaint();
				panelReplies.revalidate();
			}
			@Override
			public void componentRemoved(ContainerEvent e) {
				for(int i = 0; i < panelReplies.getComponentCount(); i++)
				{
					((NewReply) panelReplies.getComponent(i)).ChangeIndex(i+1);
				}
				panelReplies.repaint();
				panelReplies.revalidate();
			}
		});
		GridBagConstraints gbc_panelReplies = new GridBagConstraints();
		gbc_panelReplies.insets = new Insets(0, 0, 5, 0);
		gbc_panelReplies.gridwidth = 2;
		gbc_panelReplies.fill = GridBagConstraints.BOTH;
		gbc_panelReplies.gridx = 0;
		gbc_panelReplies.gridy = 2;
		add(panelReplies, gbc_panelReplies);
		panelReplies.setLayout(new GridLayout(0, 1, 0, 0));
		
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
			putValue(SHORT_DESCRIPTION, "Add a new response");
		}
		public void actionPerformed(ActionEvent e) {
			panelReplies.add(new NewReply());
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
