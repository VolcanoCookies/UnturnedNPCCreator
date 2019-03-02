package vendor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import conditions.conditionsDialog;

public class VendorBuying extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1942112558534084504L;
	private String conditions;
	private Component comp;
	private JTextField textFieldID;
	private JTextField textFieldPrice;
	private JLabel lblBuyIndex;
	private JLabel lblMenuIndex;
	private JPopupMenu popupMenu;
	private final Action actionOpenConditions = new SwingActionOpenConditions();
	private final Action actionClearConditions = new SwingActionClearConditions();
	private final Action actionRemove = new SwingActionRemove();
	private JMenuItem mntmRemove;
	private JMenuItem mntmOpenConditions;
	private JMenuItem mntmClearConditions;
	
	public VendorBuying(int panelIndex, String itemPrice, String itemID, String cond) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		comp = this;
		conditions = cond;
		
		popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		
		lblMenuIndex = new JLabel("New label");
		lblMenuIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuIndex.setFont(new Font("Tahoma", Font.BOLD, 11));
		popupMenu.add(lblMenuIndex);
		
		mntmRemove = new JMenuItem("Remove");
		mntmRemove.setAction(actionRemove);
		popupMenu.add(mntmRemove);
		
		mntmOpenConditions = new JMenuItem("Open Conditions");
		mntmOpenConditions.setAction(actionOpenConditions);
		popupMenu.add(mntmOpenConditions);
		
		mntmClearConditions = new JMenuItem("Clear Conditions");
		mntmClearConditions.setAction(actionClearConditions);
		popupMenu.add(mntmClearConditions);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 40, 20, 40, 0};
		gridBagLayout.rowHeights = new int[]{0, 22, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblBuyIndex = new JLabel("New label");
		lblBuyIndex.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblBuyIndex = new GridBagConstraints();
		gbc_lblBuyIndex.gridwidth = 3;
		gbc_lblBuyIndex.insets = new Insets(0, 0, 5, 0);
		gbc_lblBuyIndex.gridx = 1;
		gbc_lblBuyIndex.gridy = 0;
		add(lblBuyIndex, gbc_lblBuyIndex);
		
		lblBuyIndex.setText("Item number " + panelIndex);
		
		JLabel lblID = new JLabel("ID");
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(0, 0, 0, 5);
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 1;
		add(lblID, gbc_lblID);
		
		textFieldID = new JTextField();
		textFieldID.setMinimumSize(new Dimension(45, 22));
		textFieldID.setToolTipText("Item ID");
		textFieldID.setText(itemID);
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
		textFieldPrice.setToolTipText("Item cost");
		textFieldPrice.setText(itemPrice);
		textFieldPrice.setColumns(5);
		GridBagConstraints gbc_textFieldPrice = new GridBagConstraints();
		gbc_textFieldPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrice.gridx = 3;
		gbc_textFieldPrice.gridy = 1;
		add(textFieldPrice, gbc_textFieldPrice);
		
		if(conditions!=null)
			setBackground(new Color(255,206,213));
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
			putValue(NAME, "Remove");
			putValue(SHORT_DESCRIPTION, "Remove this item");
		}
		public void actionPerformed(ActionEvent e) {
			getParent().remove(comp);
		}
	}
	public void ChangeIndex(int number)
	{
		lblBuyIndex.setText("Item number " + number);
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
		private static final long serialVersionUID = 2377146095714414985L;
		public SwingActionOpenConditions() {
			putValue(NAME, "Open conditions");
			putValue(SHORT_DESCRIPTION, "Open the conditions configurator");
		}
		public void actionPerformed(ActionEvent e) {
			OpenConditions();
		}
	}
	private void OpenConditions() {
		conditions = conditionsDialog.ConditionsDialog(conditions);
		if(conditions!=null) {
			setBackground(new Color(255,206,213));
		} else {
			setBackground(getParent().getBackground());
		}
	}
	private class SwingActionClearConditions extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -31330229355713318L;
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