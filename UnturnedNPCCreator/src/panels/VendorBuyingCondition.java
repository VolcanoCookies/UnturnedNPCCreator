package panels;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import windows.ConditiondsDialog;

public class VendorBuyingCondition extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1942112558534084504L;
	private JTextField textFieldID;
	private JTextField textFieldPrice;
	private final Action actionRemove = new SwingActionRemove();
	private Component comp;
	private JLabel lblBuyIndex;
	private String conditions;
	private final Action action = new SwingAction();
	public ConditiondsDialog cd;
	private Component caller;
	
	public VendorBuyingCondition(int number) {
		caller = this;
		
		comp = this;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 40, 20, 40, 0};
		gridBagLayout.rowHeights = new int[]{0, 22, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton buttonRemove = new JButton("");
		buttonRemove.setMinimumSize(new Dimension(22, 22));
		buttonRemove.setAction(actionRemove);
		GridBagConstraints gbc_buttonRemove = new GridBagConstraints();
		gbc_buttonRemove.insets = new Insets(0, 0, 5, 5);
		gbc_buttonRemove.gridx = 0;
		gbc_buttonRemove.gridy = 0;
		add(buttonRemove, gbc_buttonRemove);
		
		lblBuyIndex = new JLabel("New label");
		lblBuyIndex.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblBuyIndex = new GridBagConstraints();
		gbc_lblBuyIndex.gridwidth = 3;
		gbc_lblBuyIndex.insets = new Insets(0, 0, 5, 0);
		gbc_lblBuyIndex.gridx = 1;
		gbc_lblBuyIndex.gridy = 0;
		add(lblBuyIndex, gbc_lblBuyIndex);
		
		lblBuyIndex.setText("Item number " + number);
		
		JLabel lblNewLabel = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldID = new JTextField();
		textFieldID.setMinimumSize(new Dimension(45, 22));
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
		textFieldPrice.setMinimumSize(new Dimension(45, 22));
		textFieldPrice.setColumns(5);
		GridBagConstraints gbc_textFieldPrice = new GridBagConstraints();
		gbc_textFieldPrice.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrice.gridx = 3;
		gbc_textFieldPrice.gridy = 1;
		add(textFieldPrice, gbc_textFieldPrice);
		
		JButton buttonConditions = new JButton("New button");
		buttonConditions.setAction(action);
		GridBagConstraints gbc_buttonConditions = new GridBagConstraints();
		gbc_buttonConditions.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonConditions.gridwidth = 4;
		gbc_buttonConditions.insets = new Insets(0, 0, 0, 5);
		gbc_buttonConditions.gridx = 0;
		gbc_buttonConditions.gridy = 2;
		add(buttonConditions, gbc_buttonConditions);
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
		private static final long serialVersionUID = -1993521655404817699L;
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
		lblBuyIndex.setText("Item number " + number);
	}
	public void setID(String id) {
		textFieldID.setText(id);
	}
	public void setPrice(String price) {
		textFieldPrice.setText(price);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Open conditions");
			putValue(SHORT_DESCRIPTION, "Open the conditions configuration window.");
		}
		public void actionPerformed(ActionEvent e) {
			JPanel conditions = new Conditions();
			JDialog dialog = new JDialog(new JFrame(), Dialog.ModalityType.APPLICATION_MODAL);
			dialog.add(conditions);
			dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			dialog.addWindowListener(new WindowAdapter() {
			    public void windowClosing(WindowEvent we)
			    { 
			        String ObjButtons[] = {"Yes","No"};
			        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Are you sure?",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
			        if(PromptResult==JOptionPane.YES_OPTION)
			        {
			            dialog.dispose();
			        }
			    }
			});
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			dialog.setSize(580, 475);
			dialog.setLocationRelativeTo(null);
			dialog.pack();
			dialog.setVisible(true);
		}
	}
}
