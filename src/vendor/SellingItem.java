package vendor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Controller;
import models.ItemSelling;
import models.Vendor;
import objects.TextPrompt;

public class SellingItem extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1941526641997266566L;
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
	private JSeparator separator_1;
	private JMenuItem menuItemMorphVehicle;
	private JMenu menuMorph;
	private JMenuItem menuItemMorphItem;
	private ItemSelling item;
	private Controller controller;
	private Vendor vendor;
	private JPanel panelTop;
	protected spawnpointPanel spawnpointPanel;
	private JPanel panel;
	private JMenuItem menuItemRemoveAll;

	/**
	 * Create the panel.
	 * @param vendorID 
	 */
	public SellingItem(Controller passedcontroller, Vendor passedVendor, ItemSelling itemSelling, VendorPanel parentPanel) {
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
		
		setBackground(Color.red);
		
		this.item = itemSelling;
		this.controller = passedcontroller;
		this.vendor = passedVendor;
		
		if(item==null) {
			this.item = new ItemSelling();
			vendor.addSellingItem(this.item);
		}
		setLayout(new BorderLayout(0, 0));
		
		popupMenu = new JPopupMenu();
		popupMenu.setLabel("");
		add(popupMenu);
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
		menuItemOpenConditions.setHorizontalAlignment(SwingConstants.CENTER);
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
		menuItemClearConditions.setHorizontalAlignment(SwingConstants.CENTER);
		popupMenu.add(menuItemClearConditions);
		separator2 = new JSeparator();
		popupMenu.add(separator2);
		menuItemRemove = new JMenuItem("Remove item");
		menuItemRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentPanel.removeSellingItem(self);
			}
		});
		
		menuMorph = new JMenu("Morph");
		popupMenu.add(menuMorph);
		
		menuItemMorphVehicle = new JMenuItem("Vehicle");
		menuItemMorphVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setVehicle(true);
				panel.add(spawnpointPanel, BorderLayout.SOUTH);
				revalidate();
				repaint();
			}
		});
		menuMorph.add(menuItemMorphVehicle);
		menuItemMorphVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		
		menuItemMorphItem = new JMenuItem("Item");
		menuItemMorphItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setVehicle(false);
				panel.remove(spawnpointPanel);
				revalidate();
				repaint();
			}
		});
		menuItemMorphItem.setHorizontalAlignment(SwingConstants.CENTER);
		menuMorph.add(menuItemMorphItem);
		
		separator_1 = new JSeparator();
		popupMenu.add(separator_1);
		popupMenu.add(menuItemRemove);
		
		spawnpointPanel = new spawnpointPanel(item, popupMenu);
		
		panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panelTop = new JPanel();
		panel.add(panelTop);
		panelTop.setLayout(new GridLayout(0, 3, 0, 0));
		
		textFieldID = new JTextField();
		panelTop.add(textFieldID);
		textFieldID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				item.setItemID(textFieldID.getText());
			}
		});
		textPrompt = new TextPrompt("ID", textFieldID);
		textPrompt.changeAlpha(128);
		textFieldID.setColumns(1);
		textFieldID.setText(item.getItemID());
		textFieldID.setComponentPopupMenu(popupMenu);
		
		textFieldCost = new JTextField();
		panelTop.add(textFieldCost);
		textFieldCost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				item.setCost(textFieldCost.getText());
			}
		});
		textPrompt = new TextPrompt("Cost", textFieldCost);
		textPrompt.changeAlpha(128);
		textFieldCost.setColumns(1);
		textFieldCost.setText(item.getCost());
		textFieldCost.setComponentPopupMenu(popupMenu);
		
		textFieldAmount = new JTextField();
		panelTop.add(textFieldAmount);
		textFieldAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				item.setItemAmount(textFieldAmount.getText());
			}
		});
		textPrompt = new TextPrompt("Amount", textFieldAmount);
		textPrompt.changeAlpha(128);
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
				parentPanel.removeAllSelling();
			}
		});
		popupMenu.add(menuItemRemoveAll);
		
		if(item.isVehicle()) {
			panel.add(spawnpointPanel, BorderLayout.SOUTH);
			revalidate();
			repaint();
		}
		
		checkConditions(item);
	}

	protected void checkConditions(ItemSelling item) {
		if(item.getConditions()==null) {
			textFieldAmount.setBackground(noConditions);
			textFieldID.setBackground(noConditions);
			textFieldCost.setBackground(noConditions);
			spawnpointPanel.textFieldBackgroundColor(noConditions);
		} else {
			textFieldAmount.setBackground(Conditions);
			textFieldID.setBackground(Conditions);
			textFieldCost.setBackground(Conditions);
			spawnpointPanel.textFieldBackgroundColor(Conditions);
		}
	}
}
class spawnpointPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3115063467438858657L;
	private JTextField textFieldSpawnpoint;
	private TextPrompt textPrompt;

	public spawnpointPanel(ItemSelling item, JPopupMenu popupMenu) {
		setLayout(new BorderLayout(0, 0));
		textFieldSpawnpoint = new JTextField();
		add(textFieldSpawnpoint, BorderLayout.CENTER);
		textFieldSpawnpoint.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				item.setSpawnpoint(textFieldSpawnpoint.getText());
			}
		});
		textPrompt = new TextPrompt("Spawnpoint", textFieldSpawnpoint);
		textPrompt.changeAlpha(128);
		textFieldSpawnpoint.setColumns(1);
		textFieldSpawnpoint.setComponentPopupMenu(popupMenu);
	}

	public void textFieldBackgroundColor(Color color) {
		textFieldSpawnpoint.setBackground(color);
	}
}