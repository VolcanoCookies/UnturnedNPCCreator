package panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import objects.ItemBuying;
import objects.TextPrompt;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

public class PanelBuyingItem extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemBuying item;
	private PanelBuyingItem self = this;
	private JTextField textFieldID;
	private JTextField textFieldAmount;
	private JTextField textFieldCost;
	
	//PopupMenu
	private JPopupMenu popupMenu;
	private JMenuItem menuItemRemove;
	private PanelVendor parent;

	public PanelBuyingItem(ItemBuying item, PanelVendor parent) {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		self = this;
		this.parent = parent;
		
		if(item != null){
			this.item = item;
			loadItem();
		}
		else
			this.item = new ItemBuying();
		
		popupMenu = new JPopupMenu();
		
		menuItemRemove = new JMenuItem("Remove");
		menuItemRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.removeBuyingItem(self);
			}
		});
		popupMenu.add(menuItemRemove);
		
		textFieldID = new JTextField();
		new TextPrompt("Item ID", textFieldID, 100);
		textFieldID.setColumns(10);
		textFieldID.setComponentPopupMenu(popupMenu);
		add(textFieldID);
		
		textFieldAmount = new JTextField();
		new TextPrompt("Amount", textFieldAmount, 100);
		textFieldAmount.setColumns(10);
		textFieldAmount.setComponentPopupMenu(popupMenu);
		add(textFieldAmount);
		
		textFieldCost = new JTextField();
		new TextPrompt("Cost", textFieldCost, 100);
		textFieldCost.setColumns(10);
		textFieldCost.setComponentPopupMenu(popupMenu);
		add(textFieldCost);
		
		setVisible(true);
	}

	private void loadItem() {
		textFieldID.setText(Integer.toString(item.getItemID()));
		textFieldAmount.setText(Integer.toString(item.getAmount()));
		textFieldCost.setText(Integer.toString(item.getCost()));
	}
	
}
