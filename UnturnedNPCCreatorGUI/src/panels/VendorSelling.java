package panels;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;

public class VendorSelling extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1942112558534084504L;
	private String conditions;
	private Component comp;
	private JTextField textFieldID;
	private JTextField textFieldPrice;
	private JLabel lblSellIndex;
	private JLabel lblMenuIndex;
	private JPopupMenu popupMenu;
	private JButton buttonOpenConditions;
	private JButton buttonClearCondition;
	private final Action actionOpenConditions = new SwingActionOpenConditions();
	private final Action actionClearConditions = new SwingActionClearConditions();
	private final Action actionRemove = new SwingActionRemove();
	
	public VendorSelling(int number) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		comp = this;
		
		popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		
		lblMenuIndex = new JLabel("New label");
		lblMenuIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuIndex.setFont(new Font("Tahoma", Font.BOLD, 11));
		popupMenu.add(lblMenuIndex);
		
		buttonOpenConditions = new JButton("New button");
		buttonOpenConditions.setAction(actionOpenConditions);
		popupMenu.add(buttonOpenConditions);
		
		buttonClearCondition = new JButton("New button");
		buttonClearCondition.setAction(actionClearConditions);
		popupMenu.add(buttonClearCondition);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 40, 20, 40, 0};
		gridBagLayout.rowHeights = new int[]{0, 22, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton buttonRemove = new JButton("");
		buttonRemove.setMinimumSize(new Dimension(22, 22));
		buttonRemove.setAction(actionRemove);
		GridBagConstraints gbc_buttonRemove = new GridBagConstraints();
		gbc_buttonRemove.insets = new Insets(0, 0, 5, 5);
		gbc_buttonRemove.gridx = 0;
		gbc_buttonRemove.gridy = 0;
		add(buttonRemove, gbc_buttonRemove);
		
		lblSellIndex = new JLabel("New label");
		lblSellIndex.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblBuyIndex = new GridBagConstraints();
		gbc_lblBuyIndex.gridwidth = 3;
		gbc_lblBuyIndex.insets = new Insets(0, 0, 5, 0);
		gbc_lblBuyIndex.gridx = 1;
		gbc_lblBuyIndex.gridy = 0;
		add(lblSellIndex, gbc_lblBuyIndex);
		
		lblSellIndex.setText("Item number " + number);
		
		JLabel lblID = new JLabel("ID");
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(0, 0, 0, 5);
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 1;
		add(lblID, gbc_lblID);
		
		textFieldID = new JTextField();
		textFieldID.setMinimumSize(new Dimension(45, 22));
		GridBagConstraints gbc_textFieldID = new GridBagConstraints();
		gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldID.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldID.gridx = 1;
		gbc_textFieldID.gridy = 1;
		add(textFieldID, gbc_textFieldID);
		textFieldID.setColumns(5);
		
		JLabel lblPrice = new JLabel("Price");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrice.gridx = 2;
		gbc_lblPrice.gridy = 1;
		add(lblPrice, gbc_lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setMinimumSize(new Dimension(45, 22));
		textFieldPrice.setColumns(5);
		GridBagConstraints gbc_textFieldPrice = new GridBagConstraints();
		gbc_textFieldPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrice.gridx = 3;
		gbc_textFieldPrice.gridy = 1;
		add(textFieldPrice, gbc_textFieldPrice);
	}
	public String[] getValues()
	{
		String[] output = new String[3];
		
		output[0] = textFieldID.getText();
		output[1] = textFieldPrice.getText();
		if(conditions!=null)
		{
			output[2] = conditions;
			System.out.println("Conditions not null");
		} else {
			System.out.println("Conditions null");
		}
		
		return output;
	}

	private class SwingActionRemove extends AbstractAction {
		private static final long serialVersionUID = -1993521655404817699L;
		public SwingActionRemove() {
			putValue(NAME, "X");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			getParent().remove(comp);
		}
	}
	public void ChangeIndex(int number)
	{
		lblSellIndex.setText("Item number " + number);
		lblMenuIndex.setText("Item number " + number);
	}
	public void setID(String id) {
		textFieldID.setText(id);
	}
	public void setPrice(String price) {
		textFieldPrice.setText(price);
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				} else if(!e.isPopupTrigger()) {
					hideMenu(e);
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
			private void hideMenu(MouseEvent e) {
				//popup.setVisible(false);
				
			}
		});
	}
	private class SwingActionOpenConditions extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2812484922613492268L;
		public SwingActionOpenConditions() {
			putValue(NAME, "Open conditions");
			putValue(SHORT_DESCRIPTION, "Open the conditions configurator");
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
	private class SwingActionClearConditions extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8230345997615188048L;
		public SwingActionClearConditions() {
			putValue(NAME, "Clear conditions");
			putValue(SHORT_DESCRIPTION, "Clear current conditions for this item");
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