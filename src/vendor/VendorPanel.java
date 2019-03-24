package vendor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import controller.Controller;
import models.ItemBuying;
import models.ItemSelling;
import models.Vendor;
import objects.TextPrompt;

public class VendorPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7687050267475741861L;
	private JTextField textFieldVendorID;
	private JTextField textFieldName;
	private TextPrompt textPrompt;
	private TextPrompt textPrompt_1;
	private JPanel panelBuying;
	private JPanel panelSelling;
	private Controller controller;
	private Vendor vendor;
	private VendorPanel self = this;
	private JTextArea textAreaDescription;

	/**
	 * Create the panel.
	 */
	public VendorPanel(Controller passedController, Vendor passedVendor) {
		setLayout(new BorderLayout(0, 0));
		
		this.controller = passedController;
		this.vendor = passedVendor;
		
		if(vendor==null) {
			vendor = new Vendor();
			controller.addVendor(vendor);
		}
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBot = new JPanel();
		panel.add(panelBot, BorderLayout.CENTER);
		panelBot.setBorder(new TitledBorder(null, "Items", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBot.setLayout(new BorderLayout(0, 0));
		
		JPanel panelItems = new JPanel();
		panelBot.add(panelItems);
		panelItems.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBothItems = new JPanel();
		panelItems.add(panelBothItems);
		GridBagLayout gbl_panelBothItems = new GridBagLayout();
		gbl_panelBothItems.columnWidths = new int[]{0, 0, 0};
		gbl_panelBothItems.rowHeights = new int[]{0, 0};
		gbl_panelBothItems.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelBothItems.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBothItems.setLayout(gbl_panelBothItems);
		
		panelBuying = new JPanel();
		GridBagConstraints gbc_panelBuying = new GridBagConstraints();
		gbc_panelBuying.anchor = GridBagConstraints.NORTH;
		gbc_panelBuying.insets = new Insets(0, 0, 0, 5);
		gbc_panelBuying.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelBuying.gridx = 0;
		gbc_panelBuying.gridy = 0;
		panelBothItems.add(panelBuying, gbc_panelBuying);
		panelBuying.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				panelBuying.revalidate();
				panelBuying.repaint();
			}
			@Override
			public void componentRemoved(ContainerEvent e) {
				panelBuying.revalidate();
				panelBuying.repaint();
			}
		});
		panelBuying.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buying", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelBuying.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelSelling = new JPanel();
		GridBagConstraints gbc_panelSelling = new GridBagConstraints();
		gbc_panelSelling.anchor = GridBagConstraints.NORTH;
		gbc_panelSelling.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelSelling.gridx = 1;
		gbc_panelSelling.gridy = 0;
		panelBothItems.add(panelSelling, gbc_panelSelling);
		panelSelling.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				panelSelling.revalidate();
				panelSelling.repaint();
			}
			@Override
			public void componentRemoved(ContainerEvent e) {
				panelSelling.revalidate();
				panelSelling.repaint();
			}
		});
		panelSelling.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Selling", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSelling.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelBothButtons = new JPanel();
		panelBot.add(panelBothButtons, BorderLayout.SOUTH);
		panelBothButtons.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtons = new JPanel();
		panelBothButtons.add(panelButtons, BorderLayout.SOUTH);
		
		JButton buttonAddBuying = new JButton("Add buying item");
		buttonAddBuying.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelBuying.add(new BuyingItem(controller, vendor, null, self));
			}
		});
		panelButtons.setLayout(new GridLayout(0, 2, 0, 0));
		panelButtons.add(buttonAddBuying);
		
		JButton buttonAddSelling = new JButton("Add selling item");
		buttonAddSelling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelSelling.add(new SellingItem(controller, vendor, null, self));
			}
		});
		panelButtons.add(buttonAddSelling);
		
		JPanel panelTop = new JPanel();
		panel.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGeneralInformation = new JPanel();
		panelTop.add(panelGeneralInformation);
		panelGeneralInformation.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelGeneralInformation.setLayout(new GridLayout(0, 2, 0, 0));
		
		textFieldVendorID = new JTextField();
		textPrompt = new TextPrompt("Vendor ID", textFieldVendorID);
		textPrompt.changeAlpha(128);
		textFieldVendorID.setText(vendor.getID());
		panelGeneralInformation.add(textFieldVendorID);
		textFieldVendorID.setColumns(10);
		
		textFieldName = new JTextField();
		textPrompt = new TextPrompt("Vendor Name", textFieldName);
		textPrompt.changeAlpha(128);
		textFieldName.setText(vendor.getName());
		panelGeneralInformation.add(textFieldName);
		textFieldName.setColumns(10);
		
		JPanel panelDescription = new JPanel();
		panelDescription.setBorder(new TitledBorder(null, "Description", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTop.add(panelDescription, BorderLayout.SOUTH);
		panelDescription.setLayout(new BorderLayout(0, 0));
		
		textAreaDescription = new JTextArea();
		textPrompt_1 = new TextPrompt("Vendor description", textAreaDescription);
		textPrompt_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPrompt_1.changeAlpha(128);
		textAreaDescription.setText(vendor.getDescription());
		panelDescription.add(textAreaDescription);
		
		JPanel panelLoadSave = new JPanel();
		add(panelLoadSave, BorderLayout.NORTH);
		panelLoadSave.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton buttonLoad = new JButton("Load");
		panelLoadSave.add(buttonLoad);
		
		JButton buttonSave = new JButton("Save");
		panelLoadSave.add(buttonSave);
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.SaveVendor(vendor);
			}
		});
		buttonLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCurrentVendor(controller.LoadVendor());
			}
		});
	}
	protected void setCurrentVendor(Vendor loadFile) {
		this.vendor = loadFile;
		
		//Clear items
		panelBuying.removeAll();
		panelSelling.removeAll();
		
		//Generate item panels
		for(ItemBuying item : vendor.getBuyingItems()) {
			panelBuying.add(new BuyingItem(controller, vendor, item, self));
		}
		for(ItemSelling item : vendor.getSellingItems()) {
			panelSelling.add(new SellingItem(controller, vendor, item, self));
		}
		
		//Name and description
		textFieldName.setText(vendor.getName());
		textAreaDescription.setText(vendor.getDescription());
		textFieldVendorID.setText(vendor.getID());
		
		self.revalidate();
		self.repaint();
	}
	public void removeBuyingItem(Component comp) {
		panelBuying.remove(comp);
	}
	public void removeSellingItem(Component comp) {
		panelSelling.remove(comp);
	}
	public void removeAllBuying() {
		panelBuying.removeAll();
	}
	public void removeAllSelling() {
		panelSelling.removeAll();
	}
}
