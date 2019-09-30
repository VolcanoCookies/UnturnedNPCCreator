package panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import objects.ItemSelling;
import objects.TextPrompt;
import window.Frame;

public class PanelSellingItem extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemSelling item;
	
	private PanelSellingItem self = this;
	private JTextField textFieldID;
	private JTextField textFieldAmount;
	private JTextField textFieldCost;
	
	//PopupMenu
	private JPopupMenu popupMenu;
	private JMenuItem menuItemRemove;
	private JMenuItem menuItemCopy;
	private JMenuItem menuItemCut;
	private JMenuItem menuItemPaste;
	
	public PanelSellingItem(ItemSelling item, PanelVendor parent) {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		if(item != null) {
			this.item = item;
			loadItem();
		}
		else
			this.item = new ItemSelling();
		
		popupMenu = new JPopupMenu();
		
		menuItemRemove = new JMenuItem("Remove");
		menuItemRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.removeSellingItem(self);
			}
		});
		popupMenu.add(menuItemRemove);
		
		menuItemCopy = new JMenuItem("Copy");
		menuItemCopy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.clipboard = item;
			}
		});
		
		menuItemCut = new JMenuItem("Cut");
		menuItemCut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.clipboard = item;
				parent.removeSellingItem(self);
			}
		});
		
		menuItemPaste = new JMenuItem("Paste");
		menuItemPaste.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Frame.clipboard != null) {
					PanelSellingItem.this.item = Frame.clipboard;	
					loadItem();
				}
			}
		});
		
		
		
		textFieldID = new JTextField();
		new TextPrompt("Item ID", textFieldID, 100);
		add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldAmount = new JTextField();
		new TextPrompt("Amount", textFieldAmount, 100);
		textFieldAmount.setColumns(10);
		add(textFieldAmount);
		
		textFieldCost = new JTextField();
		new TextPrompt("Cost", textFieldCost, 100);
		textFieldCost.setColumns(10);
		add(textFieldCost);
		
		setVisible(true);
		
	}
	
	private void loadItem() {
		textFieldID.setText(Integer.toString(item.getItemID()));
		textFieldAmount.setText(Integer.toString(item.getAmount()));
		textFieldCost.setText(Integer.toString(item.getCost()));
	}

}
