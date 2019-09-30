package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import objects.ItemBuying;
import objects.ItemSelling;
import objects.TextPrompt;
import objects.Vendor;

public class PanelVendor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldName;
	private JTextField textFieldID;
	private JTextField textFieldGUID;
	private Vendor loadedVendor;
	private JPanel panelSellingItems;
	private JPanel panelBuyingItems;
	private JButton buttonAddSellingItem;
	private JPanel panelBuyingContent;
	private JPanel panelSellingContent;	
	
	/**
	 * Create the panel.
	 */
	public PanelVendor() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelTop = new JPanel();
		add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		JPanel panelID = new JPanel();
		panelTop.add(panelID, BorderLayout.NORTH);
		
		textFieldName = new JTextField();
		new TextPrompt("Name", textFieldName, 100);
		panelID.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldID = new JTextField();
		new TextPrompt("ID", textFieldID, 100);
		panelID.add(textFieldID);
		textFieldID.setColumns(10);
		
		JPanel panelGUID = new JPanel();
		panelTop.add(panelGUID);
		panelGUID.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelGUID.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{5, 86, 0};
		gbl_panel.rowHeights = new int[]{20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		textFieldGUID = new JTextField();
		new TextPrompt("GUID", textFieldGUID, 100);
		GridBagConstraints gbc_textFieldGUID = new GridBagConstraints();
		gbc_textFieldGUID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGUID.gridx = 1;
		gbc_textFieldGUID.gridy = 0;
		panel.add(textFieldGUID, gbc_textFieldGUID);
		textFieldGUID.setColumns(10);
		textFieldGUID.setEditable(false);
		
		JCheckBox checkboxEditGUID = new JCheckBox("Edit");
		checkboxEditGUID.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textFieldGUID.setEditable(checkboxEditGUID.isSelected());
			}
		});
		panelGUID.add(checkboxEditGUID, BorderLayout.EAST);
		
		JPanel panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{273, 273, 0};
		gbl_panelCenter.rowHeights = new int[]{20, 0};
		gbl_panelCenter.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		panelBuyingItems = new JPanel();
		
		panelSellingItems = new JPanel();
		panelSellingItems.setBorder(new TitledBorder(null, "Selling", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelSellingItems = new GridBagConstraints();
		gbc_panelSellingItems.anchor = GridBagConstraints.NORTH;
		gbc_panelSellingItems.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelSellingItems.insets = new Insets(0, 0, 0, 5);
		gbc_panelSellingItems.gridx = 0;
		gbc_panelSellingItems.gridy = 0;
		panelCenter.add(panelSellingItems, gbc_panelSellingItems);
		GridBagLayout gbl_panelSellingItems = new GridBagLayout();
		gbl_panelSellingItems.columnWidths = new int[]{256, 0};
		gbl_panelSellingItems.rowHeights = new int[]{0, 50, 0};
		gbl_panelSellingItems.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelSellingItems.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panelSellingItems.setLayout(gbl_panelSellingItems);
		
		panelSellingContent = new JPanel();
		panelSellingContent.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				panelSellingContent.revalidate();
			}
			@Override
			public void componentRemoved(ContainerEvent e) {
				panelSellingContent.revalidate();
			}
		});
		GridBagConstraints gbc_panelSellingContent = new GridBagConstraints();
		gbc_panelSellingContent.fill = GridBagConstraints.BOTH;
		gbc_panelSellingContent.insets = new Insets(0, 0, 5, 0);
		gbc_panelSellingContent.gridx = 0;
		gbc_panelSellingContent.gridy = 0;
		panelSellingItems.add(panelSellingContent, gbc_panelSellingContent);
		panelSellingContent.setLayout(new GridLayout(0, 1, 0, 0));
		
		buttonAddSellingItem = new JButton("+");
		buttonAddSellingItem.setFocusPainted(false);
		buttonAddSellingItem.setFocusable(false);
		buttonAddSellingItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addSellingItem(null);
				
			}
		});
		buttonAddSellingItem.setForeground(Color.GRAY);
		buttonAddSellingItem.setFont(new Font("Tahoma", Font.BOLD, 35));
		GridBagConstraints gbc_buttonAddSellingItem = new GridBagConstraints();
		gbc_buttonAddSellingItem.fill = GridBagConstraints.BOTH;
		gbc_buttonAddSellingItem.gridx = 0;
		gbc_buttonAddSellingItem.gridy = 1;
		panelSellingItems.add(buttonAddSellingItem, gbc_buttonAddSellingItem);
		panelBuyingItems.setBorder(new TitledBorder(null, "Buying", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		GridBagConstraints gbc_panelBuyingItems = new GridBagConstraints();
		gbc_panelBuyingItems.anchor = GridBagConstraints.NORTH;
		gbc_panelBuyingItems.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelBuyingItems.gridx = 1;
		gbc_panelBuyingItems.gridy = 0;
		panelCenter.add(panelBuyingItems, gbc_panelBuyingItems);
		GridBagLayout gbl_panelBuyingItems = new GridBagLayout();
		gbl_panelBuyingItems.columnWidths = new int[]{106, 0};
		gbl_panelBuyingItems.rowHeights = new int[]{0, 50, 0};
		gbl_panelBuyingItems.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelBuyingItems.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panelBuyingItems.setLayout(gbl_panelBuyingItems);
		
		panelBuyingContent = new JPanel();
		panelBuyingContent.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent e) {
				panelBuyingContent.revalidate();
			}
			@Override
			public void componentRemoved(ContainerEvent e) {
				panelBuyingContent.revalidate();
			}
		});
		GridBagConstraints gbc_panelBuyingContent = new GridBagConstraints();
		gbc_panelBuyingContent.fill = GridBagConstraints.BOTH;
		gbc_panelBuyingContent.insets = new Insets(0, 0, 5, 0);
		gbc_panelBuyingContent.gridx = 0;
		gbc_panelBuyingContent.gridy = 0;
		panelBuyingItems.add(panelBuyingContent, gbc_panelBuyingContent);
		panelBuyingContent.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton buttonAddBuyingItem = new JButton("+");
		buttonAddBuyingItem.setFocusPainted(false);
		buttonAddBuyingItem.setFocusable(false);
		GridBagConstraints gbc_buttonAddBuyingItem = new GridBagConstraints();
		gbc_buttonAddBuyingItem.fill = GridBagConstraints.BOTH;
		gbc_buttonAddBuyingItem.gridx = 0;
		gbc_buttonAddBuyingItem.gridy = 1;
		panelBuyingItems.add(buttonAddBuyingItem, gbc_buttonAddBuyingItem);
		buttonAddBuyingItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				addBuyingItem(null);
				
			}
		});
		buttonAddBuyingItem.setForeground(Color.GRAY);
		buttonAddBuyingItem.setFont(new Font("Tahoma", Font.BOLD, 35));
		
	}
	

	public void addSellingItem(ItemSelling item) {
		panelSellingContent.add(new PanelSellingItem(item, this));
	}
	
	public void addBuyingItem(ItemBuying item) {
		panelBuyingContent.add(new PanelBuyingItem(item, this));
	}
	
	void removeSellingItem(PanelSellingItem item) {
		panelBuyingContent.remove(item);
	}
	
	void removeBuyingItem(PanelBuyingItem item) {
		panelBuyingContent.remove(item);
	}
	
}
