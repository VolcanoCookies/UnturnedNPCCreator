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
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import conditions.conditionsDialog;

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
	private final Action actionOpenConditions = new SwingActionOpenConditions();
	private final Action actionClearConditions = new SwingActionClearConditions();
	private final Action actionRemove = new SwingActionRemove();
	private final Action actionMorphItem = new SwingActionMorphItem();
	private final Action actionMorphVehicle = new SwingActionMorphVehicle();
	private JMenuItem menuItemRemove;
	private JMenuItem menuItemOpenConditions;
	private JMenuItem menuItemClearConditions;
	private JMenu menuMorph;
	private JMenuItem menuItemItem;
	private JMenuItem menuItemVehicle;
	//True for item, false for vehicle
	private boolean type;
	private JLabel lblSpawnpointName;
	private JTextField textFieldSpawnpoint;
	
	public VendorSelling(int panelIndex, String itemPrice, String itemID, String spawnpointName, String cond, boolean panelType) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		comp = this;
		type = panelType;
		conditions = cond;
		
		popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		
		lblMenuIndex = new JLabel("New label");
		lblMenuIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuIndex.setFont(new Font("Tahoma", Font.BOLD, 11));
		popupMenu.add(lblMenuIndex);
		
		menuItemRemove = new JMenuItem("Remove");
		menuItemRemove.setAction(actionRemove);
		popupMenu.add(menuItemRemove);
		
		menuMorph = new JMenu("Morph");
		popupMenu.add(menuMorph);
		
		menuItemItem = new JMenuItem("Item");
		menuItemItem.setAction(actionMorphItem);
		menuMorph.add(menuItemItem);
		
		menuItemVehicle = new JMenuItem("Vehicle");
		menuItemVehicle.setAction(actionMorphVehicle);
		menuMorph.add(menuItemVehicle);
		
		menuItemOpenConditions = new JMenuItem("Remove");
		menuItemOpenConditions.setAction(actionOpenConditions);
		popupMenu.add(menuItemOpenConditions);
		
		menuItemClearConditions = new JMenuItem("Remove");
		menuItemClearConditions.setAction(actionClearConditions);
		popupMenu.add(menuItemClearConditions);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 40, 20, 40, 0};
		gridBagLayout.rowHeights = new int[]{0, 22, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblSellIndex = new JLabel("New label");
		lblSellIndex.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblBuyIndex = new GridBagConstraints();
		gbc_lblBuyIndex.gridwidth = 3;
		gbc_lblBuyIndex.insets = new Insets(0, 0, 5, 0);
		gbc_lblBuyIndex.gridx = 1;
		gbc_lblBuyIndex.gridy = 0;
		add(lblSellIndex, gbc_lblBuyIndex);
		
		lblSellIndex.setText("Item number " + panelIndex);
		
		JLabel lblID = new JLabel("ID");
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 1;
		add(lblID, gbc_lblID);
		
		textFieldID = new JTextField();
		textFieldID.setToolTipText("Item ID");
		textFieldID.setMinimumSize(new Dimension(45, 22));
		textFieldID.setText(itemID);
		GridBagConstraints gbc_textFieldID = new GridBagConstraints();
		gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldID.gridx = 1;
		gbc_textFieldID.gridy = 1;
		add(textFieldID, gbc_textFieldID);
		textFieldID.setColumns(5);
		
		JLabel lblPrice = new JLabel("Price");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 2;
		gbc_lblPrice.gridy = 1;
		add(lblPrice, gbc_lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setToolTipText("Item price");
		textFieldPrice.setMinimumSize(new Dimension(45, 22));
		textFieldPrice.setColumns(5);
		textFieldPrice.setText(itemPrice);
		GridBagConstraints gbc_textFieldPrice = new GridBagConstraints();
		gbc_textFieldPrice.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrice.gridx = 3;
		gbc_textFieldPrice.gridy = 1;
		add(textFieldPrice, gbc_textFieldPrice);
		
		lblSpawnpointName = new JLabel("Spawnpoint Name");
		GridBagConstraints gbc_lblSpawnpointName = new GridBagConstraints();
		gbc_lblSpawnpointName.gridwidth = 2;
		gbc_lblSpawnpointName.insets = new Insets(0, 0, 0, 5);
		gbc_lblSpawnpointName.gridx = 0;
		gbc_lblSpawnpointName.gridy = 2;
		add(lblSpawnpointName, gbc_lblSpawnpointName);
		
		textFieldSpawnpoint = new JTextField();
		textFieldSpawnpoint.setToolTipText("Devkit spawnpoint name for where to spawn the vehicle when purchased");
		GridBagConstraints gbc_textFieldSpawnpoint = new GridBagConstraints();
		gbc_textFieldSpawnpoint.gridwidth = 2;
		gbc_textFieldSpawnpoint.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSpawnpoint.gridx = 2;
		gbc_textFieldSpawnpoint.gridy = 2;
		add(textFieldSpawnpoint, gbc_textFieldSpawnpoint);
		textFieldSpawnpoint.setColumns(10);
		
		morph(type);
		
		if(conditions!=null)
			setBackground(new Color(255,206,213));
	}
	public String[] getValues()
	{
		String[] output;
		if(type) {
			output = new String[3];
		} else {
			output = new String[4];
			output[3] = textFieldSpawnpoint.getText();
		}
		
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
			putValue(SHORT_DESCRIPTION, "Remove this item.");
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
	public void setSpawnpointName(String spawnpointName) {
		textFieldSpawnpoint.setText(spawnpointName);
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
	private class SwingActionMorphItem extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8411617664712742924L;
		public SwingActionMorphItem() {
			putValue(NAME, "Item");
			putValue(SHORT_DESCRIPTION, "Change into a item");
		}
		public void actionPerformed(ActionEvent e) {
			morph(true);
		}
	}
	private class SwingActionMorphVehicle extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2495907310987323291L;
		public SwingActionMorphVehicle() {
			putValue(NAME, "Vehicle");
			putValue(SHORT_DESCRIPTION, "Change into a vehicle");
		}
		public void actionPerformed(ActionEvent e) {
			morph(false);
			
		}
	}
	public void morph(boolean bool) {
		type = bool;
		if(type) {
			textFieldID.setToolTipText("Item ID");
			textFieldPrice.setToolTipText("Item price");
			lblSpawnpointName.setVisible(false);
			textFieldSpawnpoint.setVisible(false);
		} else {
			textFieldID.setToolTipText("Vehicle ID");
			textFieldPrice.setToolTipText("Vehicle price");
			lblSpawnpointName.setVisible(true);
			textFieldSpawnpoint.setVisible(true);
		}
	}
}