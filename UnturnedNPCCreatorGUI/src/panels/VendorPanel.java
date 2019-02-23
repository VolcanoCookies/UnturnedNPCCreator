package panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

import util.FileManager;

public class VendorPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2036359898810091651L;
	public static int BuyingPanelNumber = 0;
	public static int SellingPanelNumber = 0;
	
	
	//Textfields
	private static JTextField textFieldName;
	private static JTextField textFieldID;
	private static JTextField textFieldGUID;
	private static JTextField textFieldStoreName;
	private static JTextArea textAreaDescription;
	//Panels
	private static JPanel panelBuying;
	private static JPanel panelSelling;
	//Actions
	private final Action actionLoad = new SwingActionLoad();
	private final Action actionAddBuyItem = new SwingActionAddBuyItem();
	private final Action actionAddSellItem = new SwingActionAddSellItem();
	private final Action actionSaveVendor = new SwingActionSaveVendor();
	public VendorPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{155, 155, 0};
		gbl_panel.rowHeights = new int[]{76, 0, 0, 0, 0, 0, 60, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panelStaticInfo = new JPanel();
		GridBagConstraints gbc_panelStaticInfo = new GridBagConstraints();
		gbc_panelStaticInfo.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelStaticInfo.gridwidth = 2;
		gbc_panelStaticInfo.insets = new Insets(0, 0, 5, 0);
		gbc_panelStaticInfo.anchor = GridBagConstraints.NORTH;
		gbc_panelStaticInfo.gridx = 0;
		gbc_panelStaticInfo.gridy = 0;
		panel.add(panelStaticInfo, gbc_panelStaticInfo);
		GridBagLayout gbl_panelStaticInfo = new GridBagLayout();
		gbl_panelStaticInfo.columnWidths = new int[] {70, 150, 44, 0};
		gbl_panelStaticInfo.rowHeights = new int[]{20, 0, 0, 0};
		gbl_panelStaticInfo.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelStaticInfo.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelStaticInfo.setLayout(gbl_panelStaticInfo);
		
		JLabel lblFolderName = new JLabel("Folder name");
		GridBagConstraints gbc_lblFolderName = new GridBagConstraints();
		gbc_lblFolderName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFolderName.gridx = 0;
		gbc_lblFolderName.gridy = 0;
		panelStaticInfo.add(lblFolderName, gbc_lblFolderName);
		
		textFieldName = new JTextField();
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
					FileManager.LoadVendor(textFieldName.getText());
			}
		});
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldName.anchor = GridBagConstraints.NORTH;
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 0;
		panelStaticInfo.add(textFieldName, gbc_textFieldName);
		textFieldName.setColumns(10);
		
		JButton buttonLoad = new JButton("New button");
		buttonLoad.setAction(actionLoad);
		GridBagConstraints gbc_buttonLoad = new GridBagConstraints();
		gbc_buttonLoad.insets = new Insets(0, 0, 5, 0);
		gbc_buttonLoad.gridx = 2;
		gbc_buttonLoad.gridy = 0;
		panelStaticInfo.add(buttonLoad, gbc_buttonLoad);
		
		JLabel lblID = new JLabel("ID");
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 1;
		panelStaticInfo.add(lblID, gbc_lblID);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		GridBagConstraints gbc_textFieldID = new GridBagConstraints();
		gbc_textFieldID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldID.gridx = 1;
		gbc_textFieldID.gridy = 1;
		panelStaticInfo.add(textFieldID, gbc_textFieldID);
		
		JLabel lblGUID = new JLabel("GUID");
		GridBagConstraints gbc_lblGUID = new GridBagConstraints();
		gbc_lblGUID.insets = new Insets(0, 0, 0, 5);
		gbc_lblGUID.gridx = 0;
		gbc_lblGUID.gridy = 2;
		panelStaticInfo.add(lblGUID, gbc_lblGUID);
		
		textFieldGUID = new JTextField();
		textFieldGUID.setToolTipText("Editing the GUID is not recommended. Unturned creates these automatically.");
		textFieldGUID.setEditable(false);
		textFieldGUID.setColumns(10);
		GridBagConstraints gbc_textFieldGUID = new GridBagConstraints();
		gbc_textFieldGUID.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldGUID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGUID.gridx = 1;
		gbc_textFieldGUID.gridy = 2;
		panelStaticInfo.add(textFieldGUID, gbc_textFieldGUID);
		
		JCheckBox checkboxEditGUID = new JCheckBox("Edit");
		checkboxEditGUID.setToolTipText("Not recommended.");
		checkboxEditGUID.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textFieldGUID.setEditable(checkboxEditGUID.isSelected());
			}
		});
		GridBagConstraints gbc_checkboxEditGUID = new GridBagConstraints();
		gbc_checkboxEditGUID.gridx = 2;
		gbc_checkboxEditGUID.gridy = 2;
		panelStaticInfo.add(checkboxEditGUID, gbc_checkboxEditGUID);
		
		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.gridwidth = 2;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 0);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		panel.add(lblDescription, gbc_lblDescription);
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textAreaDescription.setRows(3);
		textAreaDescription.setLineWrap(true);
		GridBagConstraints gbc_textAreaDescription = new GridBagConstraints();
		gbc_textAreaDescription.gridwidth = 2;
		gbc_textAreaDescription.insets = new Insets(0, 0, 5, 0);
		gbc_textAreaDescription.fill = GridBagConstraints.BOTH;
		gbc_textAreaDescription.gridx = 0;
		gbc_textAreaDescription.gridy = 2;
		panel.add(textAreaDescription, gbc_textAreaDescription);
		
		JLabel lblVendorStoreName = new JLabel("Vendor Store Name");
		GridBagConstraints gbc_lblVendorStoreName = new GridBagConstraints();
		gbc_lblVendorStoreName.gridwidth = 2;
		gbc_lblVendorStoreName.insets = new Insets(0, 0, 5, 0);
		gbc_lblVendorStoreName.gridx = 0;
		gbc_lblVendorStoreName.gridy = 3;
		panel.add(lblVendorStoreName, gbc_lblVendorStoreName);
		
		textFieldStoreName = new JTextField();
		GridBagConstraints gbc_textFieldStoreName = new GridBagConstraints();
		gbc_textFieldStoreName.gridwidth = 2;
		gbc_textFieldStoreName.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldStoreName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldStoreName.gridx = 0;
		gbc_textFieldStoreName.gridy = 4;
		panel.add(textFieldStoreName, gbc_textFieldStoreName);
		textFieldStoreName.setColumns(10);
		
		JLabel lblBuying = new JLabel("Buying");
		lblBuying.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblBuying = new GridBagConstraints();
		gbc_lblBuying.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuying.gridx = 0;
		gbc_lblBuying.gridy = 5;
		panel.add(lblBuying, gbc_lblBuying);
		
		JLabel lblSelling = new JLabel("Selling");
		GridBagConstraints gbc_lblSelling = new GridBagConstraints();
		gbc_lblSelling.insets = new Insets(0, 0, 5, 0);
		gbc_lblSelling.gridx = 1;
		gbc_lblSelling.gridy = 5;
		panel.add(lblSelling, gbc_lblSelling);
		lblSelling.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		panelBuying = new JPanel();
		panelBuying.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelBuying.addContainerListener(new ContainerAdapter() {
			public void componentAdded(ContainerEvent e) {
				BuyingPanelNumber = panelBuying.getComponentCount();
				reassignIndex("buy");
				panelBuying.revalidate();
				panelBuying.repaint();
			}
			public void componentRemoved(ContainerEvent e) {
				BuyingPanelNumber = panelBuying.getComponentCount();
				reassignIndex("buy");
				panelBuying.revalidate();
				panelBuying.repaint();
			}
		});
		GridBagConstraints gbc_panelBuying = new GridBagConstraints();
		gbc_panelBuying.anchor = GridBagConstraints.NORTH;
		gbc_panelBuying.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelBuying.insets = new Insets(0, 0, 5, 5);
		gbc_panelBuying.gridx = 0;
		gbc_panelBuying.gridy = 6;
		panel.add(panelBuying, gbc_panelBuying);
		panelBuying.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelSelling = new JPanel();
		panelSelling.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelSelling.addContainerListener(new ContainerAdapter() {
			public void componentAdded(ContainerEvent e) {
				SellingPanelNumber = panelSelling.getComponentCount();
				reassignIndex("sell");
				panelSelling.revalidate();
				panelSelling.repaint();
			}
			public void componentRemoved(ContainerEvent e) {
				SellingPanelNumber = panelSelling.getComponentCount();
				reassignIndex("sell");
				panelSelling.revalidate();
				panelSelling.repaint();
			}
		});
		panelSelling.setMaximumSize(new Dimension(150,150));
		GridBagConstraints gbc_panelSelling = new GridBagConstraints();
		gbc_panelSelling.anchor = GridBagConstraints.NORTH;
		gbc_panelSelling.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelSelling.insets = new Insets(0, 0, 5, 0);
		gbc_panelSelling.gridx = 1;
		gbc_panelSelling.gridy = 6;
		panel.add(panelSelling, gbc_panelSelling);
		panelSelling.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton buttonAddBuyItem = new JButton("New button");
		buttonAddBuyItem.setAction(actionAddBuyItem);
		GridBagConstraints gbc_buttonAddBuyItem = new GridBagConstraints();
		gbc_buttonAddBuyItem.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonAddBuyItem.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAddBuyItem.gridx = 0;
		gbc_buttonAddBuyItem.gridy = 7;
		panel.add(buttonAddBuyItem, gbc_buttonAddBuyItem);
		
		JButton buttonAddSellingItem = new JButton("New button");
		buttonAddSellingItem.setAction(actionAddSellItem);
		GridBagConstraints gbc_buttonAddSellingItem = new GridBagConstraints();
		gbc_buttonAddSellingItem.insets = new Insets(0, 0, 5, 0);
		gbc_buttonAddSellingItem.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonAddSellingItem.gridx = 1;
		gbc_buttonAddSellingItem.gridy = 7;
		panel.add(buttonAddSellingItem, gbc_buttonAddSellingItem);
		
		JButton buttonSaveVendor = new JButton("New button");
		buttonSaveVendor.setAction(actionSaveVendor);
		GridBagConstraints gbc_buttonSaveVendor = new GridBagConstraints();
		gbc_buttonSaveVendor.gridwidth = 2;
		gbc_buttonSaveVendor.gridx = 0;
		gbc_buttonSaveVendor.gridy = 8;
		panel.add(buttonSaveVendor, gbc_buttonSaveVendor);
		
	}
	
	public static void reassignIndex(String type)
	{
		if (type.equalsIgnoreCase("sell"))
		{
			for(int i = 0; i < panelSelling.getComponentCount(); i++)
			{
				((VendorSelling) panelSelling.getComponent(i)).ChangeIndex(i+1);
			}
		}
		if (type.equalsIgnoreCase("buy"))
		{
			for(int i = 0; i < panelBuying.getComponentCount(); i++)
			{
					((VendorBuying) panelBuying.getComponent(i)).ChangeIndex(i+1);
			}
		}
	}
	private class SwingActionLoad extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5961981017984513455L;
		public SwingActionLoad() {
			putValue(NAME, "Load");
			putValue(SHORT_DESCRIPTION, "Load a Vendor by name.");
		}
		public void actionPerformed(ActionEvent e) {
			FileManager.LoadVendor(textFieldName.getText());
		}
	}
	private class SwingActionAddBuyItem extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5537172925414579799L;
		public SwingActionAddBuyItem() {
			putValue(NAME, "Add item to buy");
			putValue(SHORT_DESCRIPTION, "Add an item the NPC will buy.");
		}
		public void actionPerformed(ActionEvent e) {
			panelBuying.add(new VendorBuying(++BuyingPanelNumber));
		}
	}
	private class SwingActionAddSellItem extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1666599406331438862L;
		public SwingActionAddSellItem() {
			putValue(NAME, "Add item to sell");
			putValue(SHORT_DESCRIPTION, "Add an item the NPC will sell.");
		}
		public void actionPerformed(ActionEvent e) {
			panelSelling.add(new VendorSelling(++SellingPanelNumber));
		}
	}
	private class SwingActionSaveVendor extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1194805489761944991L;
		public SwingActionSaveVendor() {
			putValue(NAME, "Save Vendor");
			putValue(SHORT_DESCRIPTION, "Save this vendor.");
		}
		public void actionPerformed(ActionEvent e) {
			FileManager.SaveVendor(null, getBasicValues(), getBuying(), getSelling(), textFieldName.getText());
		}
	}
	private static String[][] getBasicValues()
	{
		String[][] output = new String[2][3];
		output[1][0] = "Name " + textFieldStoreName.getText();
		output[1][1] = "Description " + textAreaDescription.getText().replace("\n", "<br>");
		output[0][0] = "GUID " + textFieldGUID.getText();
		output[0][1] = "ID " + textFieldID.getText();
		
		return output;
	}
	private static String[] getBuying()
	{
		String[] output = new String[512];
		int i = 0;
		int index = 0;
		String[] string;
		output[i++] = "Buying " + panelBuying.getComponentCount();
		for(Component comp : panelBuying.getComponents())
		{
			string = ((VendorBuying) comp).getValues();
			if(string!=null)
			{
				output[i++] = "Buying_" + (index) + "_ID " + string[0];
				output[i++] = "Buying_" + (index++) + "_Cost " + string[1];
				output[i++] = string[2];
			}
		}
		
		return output;
	}
	private static String[] getSelling()
	{
		String[] output = new String[512];
		int i = 0;
		int index = 0;
		String[] string;
		output[i++] = "Selling " + panelSelling.getComponentCount();
		for(Component comp : panelSelling.getComponents())
		{
			string = ((VendorSelling) comp).getValues();
			if(string!=null)
			{
				output[i++] = "Selling_" + (index) + "_ID " + string[0];
				output[i++] = "Selling_" + (index++) + "_Cost " + string[1];
			}
		}
		
		return output;
	}

	public static void clearFields() {
		textFieldGUID.setText("");
		textFieldStoreName.setText("");
		textFieldID.setText("");
		textAreaDescription.setText("");
	}

	public static void FillFields(String[] values) {
		String[] buying = new String[values.length];
		String[] selling = new String[values.length];
		int buyingIndex = 0;
		int sellingIndex = 0;
		for(int i = 0; i < values.length; i++)
		{
			if(values[i].contains("ID") && !values[i].contains("_ID") && !values[i].contains("GUID"))
				textFieldID.setText(values[i].split(" ")[1]);
			if(values[i].contains("GUID"))
				textFieldGUID.setText(values[i].split(" ")[1]);
			if(values[i].contains("Buying "))
			{
				for(int ii = 0; ii < Integer.valueOf(values[ii].split(" ")[1]); ii++)
					panelBuying.add(new VendorBuying(ii));
			}
			if(values[i].contains("Selling "))
			{
				for(int ii = 0; ii < Integer.valueOf(values[ii].split(" ")[1]); ii++)
					panelSelling.add(new VendorSelling(ii));
			}
			if(values[i].contains("Buying_") && values[i].contains("_ID"))
				buying[buyingIndex++] = values[i].split(" ")[1];
			if(values[i].contains("Buying_") && values[i].contains("_Cost"))
				buying[buyingIndex++] = values[i].split(" ")[1];
			if(values[i].contains("Conditions "))
			{
				String nextLine = values[i];
				String conditions = "";
				int ii = 0;
				while(nextLine.toLowerCase().contains("condition"))
				{
					conditions += nextLine + "\n";
					nextLine = values[i+ii++];
					while(nextLine.substring(0,3).contains("//"))
						nextLine = values[i+ii++];
				}
				FoundCondition(conditions);
			}
			if(values[i].contains("Selling_") && values[i].contains("_ID"))
				selling[sellingIndex++] = values[i].split(" ")[1];
			if(values[i].contains("Selling_") && values[i].contains("_Cost"))
				selling[sellingIndex++] = values[i].split(" ")[1];	
			if(values[i].contains("Description "))
				textAreaDescription.setText(values[i].replace("<br>", "\n").substring(12));
			if(values[i].contains("Name "))
				textFieldStoreName.setText(values[i].substring(5));
		}
		buyingIndex = 0;
		sellingIndex = 0;
		for(Component comp : panelBuying.getComponents())
		{
			((VendorBuying) comp).setID(buying[buyingIndex++]);
			((VendorBuying) comp).setPrice(buying[buyingIndex++]);
		}
		for(Component comp : panelSelling.getComponents())
		{
			((VendorSelling) comp).setID(selling[sellingIndex++]);
			((VendorSelling) comp).setPrice(selling[sellingIndex++]);
		}
		
	}

	private static void FoundCondition(String conditions) {
		// TODO Auto-generated method stub
		
	}
}
