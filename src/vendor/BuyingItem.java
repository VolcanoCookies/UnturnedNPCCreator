package vendor;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controller.Controller;
import models.ItemBuying;
import models.Vendor;
import objects.TextPrompt;

public class BuyingItem extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4888706022538542915L;
	private JTextField textFieldID;
	private JTextField textFieldCost;
	private JTextField textFieldAmount;
	private TextPrompt textPrompt;
	private JPopupMenu popupMenu;
	private JMenuItem menuItemCopy;
	private JMenuItem menuItemPaste;
	private JMenuItem menuItemClearConditions;
	private JMenuItem menuItemOpenConditions;
	private JSeparator separator;
	private JSeparator separator2;
	private JMenuItem menuItemRemove;
	private Component self = this;
	final Color noConditions = new Color(255,255,255);
	final Color Conditions = new Color(255,220,200);
	private Controller controller;
	private Vendor vendor;
	private ItemBuying item;
	private JMenuItem menuItemRemoveAll;

	/**
	 * Create the panel.
	 */
	public BuyingItem(Controller passedController, Vendor passedVendor, ItemBuying itemBuying, VendorPanel parentPanel) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				checkConditions(item);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				checkConditions(item);
			}
		});
		setLayout(new GridLayout(0, 3, 0, 0));
		
		this.item = itemBuying;
		this.controller = passedController;
		this.vendor = passedVendor;
		
		if(item==null) {
			item = new ItemBuying();
			vendor.addBuyingItem(item);
		}
		
		popupMenu = new JPopupMenu();
		popupMenu.setLabel("");
		menuItemCopy = new JMenuItem("Copy item");
		menuItemCopy.setEnabled(false);
		popupMenu.add(menuItemCopy);
		menuItemPaste = new JMenuItem("Paste item");
		menuItemPaste.setEnabled(false);
		popupMenu.add(menuItemPaste);
		separator = new JSeparator();
		popupMenu.add(separator);
		menuItemOpenConditions = new JMenuItem("Open conditons");
		menuItemOpenConditions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setConditions(controller.OpenConditions(item.getConditions()));
				checkConditions(item);	
			}
		});
		popupMenu.add(menuItemOpenConditions);
		menuItemClearConditions = new JMenuItem("Clear conditions");
		menuItemClearConditions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ObjButtons[] = {"Yes", "No"};
		    	int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Are you sure?",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        	item.setConditions(null);
				checkConditions(item);
			}
		});
		popupMenu.add(menuItemClearConditions);
		separator2 = new JSeparator();
		popupMenu.add(separator2);
		menuItemRemove = new JMenuItem("Remove item");
		menuItemRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentPanel.removeBuyingItem(self);
			}
		});
		popupMenu.add(menuItemRemove);
		
		textFieldID = new JTextField();
		textFieldID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				item.setItemID(textFieldID.getText());
			}
		});
		textPrompt = new TextPrompt("ID", textFieldID);
		textPrompt.changeAlpha(128);
		add(textFieldID);
		textFieldID.setColumns(1);
		textFieldID.setText(item.getItemID());
		textFieldID.setComponentPopupMenu(popupMenu);
		
		textFieldCost = new JTextField();
		textFieldCost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				item.setCost(textFieldCost.getText());
			}
		});
		textPrompt = new TextPrompt("Cost", textFieldCost);
		textPrompt.changeAlpha(128);
		add(textFieldCost);
		textFieldCost.setColumns(1);
		textFieldCost.setText(item.getCost());
		textFieldCost.setComponentPopupMenu(popupMenu);
		
		textFieldAmount = new JTextField();
		textFieldAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				item.setItemAmount(textFieldAmount.getText());
			}
		});
		textPrompt = new TextPrompt("Amount", textFieldAmount);
		textPrompt.changeAlpha(128);
		add(textFieldAmount);
		textFieldAmount.setColumns(1);
		textFieldAmount.setText(item.getItemAmount());
		textFieldAmount.setComponentPopupMenu(popupMenu);
		
		menuItemRemoveAll = new JMenuItem("Remove all");
		menuItemRemoveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ObjButtons[] = {"Yes", "No"};
		    	int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Are you sure?",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        	item.setConditions(null);
				parentPanel.removeAllBuying();
			}
		});
		popupMenu.add(menuItemRemoveAll);
		
		checkConditions(item);
		
	}

	protected void checkConditions(ItemBuying item) {
		if(item.getConditions()==null) {
			textFieldAmount.setBackground(noConditions);
			textFieldID.setBackground(noConditions);
			textFieldCost.setBackground(noConditions);
		} else {
			textFieldAmount.setBackground(Conditions);
			textFieldID.setBackground(Conditions);
			textFieldCost.setBackground(Conditions);
		}
		
	}

}
