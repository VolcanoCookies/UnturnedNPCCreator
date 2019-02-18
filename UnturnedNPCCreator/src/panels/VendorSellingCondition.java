package panels;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VendorSellingCondition extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -644171350070598051L;
	private JTextField textFieldID;
	private JTextField textFieldPrice;
	private final Action actionRemove = new SwingActionRemove();
	private Component comp;
	private JLabel lblSellIndex;
	private String conditions;
	
	public VendorSellingCondition(int number) {
		comp = this;
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
		
		JLabel lblNewLabel = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
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
		String[] output = new String[2];
		
		output[0] = textFieldID.getText();
		output[1] = textFieldPrice.getText();
		
		return output;
	}

	private class SwingActionRemove extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5273204371123965770L;
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
	}
	public void setID(String id) {
		textFieldID.setText(id);
	}
	public void setPrice(String price) {
		textFieldPrice.setText(price);
	}
	public void PassConditions(String output) {
		// TODO Auto-generated method stub
		
	}
	
}
