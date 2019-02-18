package windows;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import panels.NewCondition;
import panels.VendorBuyingCondition;
import panels.VendorSellingCondition;

public class ConditiondsDialog extends JDialog {

	private int conditionIndex = 0;
	private JTabbedPane tabbedPane;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JButton buttonNewCondition;
	private final Action actionAddCondition = new SwingActionAddCondition();
	private JButton buttonSave;
	private final Action actionSave = new SwingActionSave();
	private Component caller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConditiondsDialog dialog = new ConditiondsDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param caller 
	 */
	public ConditiondsDialog(Component comp) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Save & Exit","Cancel","Exit"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Are you sure?",JOptionPane.WARNING_MESSAGE,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==0)
		        {
		        	Save();
		        	dispose();
		        } else if (PromptResult==2)
		        {
		        	dispose();
		        }
		    }
		});
		
		caller = comp;
		
		setBounds(100, 100, 580, 455);
		setMinimumSize(new Dimension(580,455));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contentPane = new JPanel();
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		buttonNewCondition = new JButton("Add Condition");
		buttonNewCondition.setAction(actionAddCondition);
		menuBar.add(buttonNewCondition);
		
		buttonSave = new JButton("New button");
		buttonSave.setAction(actionSave);
		menuBar.add(buttonSave);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		NewCondition newCondition = new NewCondition();
		tabbedPane.addTab("Con#" + ++conditionIndex  , null, newCondition, null);
		tabbedPane.setEnabledAt(0, true);
		contentPane.add(tabbedPane);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		GridBagConstraints gbc_TimeOfDay = new GridBagConstraints();
		gbc_TimeOfDay.insets = new Insets(0, 0, 0, 5);
		gbc_TimeOfDay.fill = GridBagConstraints.BOTH;
		gbc_TimeOfDay.gridx = 0;
		gbc_TimeOfDay.gridy = 2;
		GridBagConstraints gbc_CompareFlags = new GridBagConstraints();
		gbc_CompareFlags.insets = new Insets(0, 0, 0, 5);
		gbc_CompareFlags.fill = GridBagConstraints.BOTH;
		gbc_CompareFlags.gridx = 0;
		gbc_CompareFlags.gridy = 2;
		
	}
	
	public void Save() {
		String output = null;
		int i = 0;
		output = "Conditions " + tabbedPane.getTabCount() + "\n";
		for(Component panel : tabbedPane.getComponents())
		{
			output += ((NewCondition) panel).ReturnConditions(i++) + "\n";
		}
		try {
			((VendorBuyingCondition) caller).PassConditions(output);
		} catch (Exception e) {
			((VendorSellingCondition) caller).PassConditions(output);
		}
		
	}
	private class SwingActionAddCondition extends AbstractAction {
		public SwingActionAddCondition() {
			putValue(NAME, "Add Condition");
			putValue(SHORT_DESCRIPTION, "Add a new condition");
		}
		public void actionPerformed(ActionEvent e) {
			tabbedPane.addTab("Con#" + ++conditionIndex , null, new NewCondition(), null);
		}
	}
	private class SwingActionSave extends AbstractAction {
		public SwingActionSave() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save the conditions.");
		}
		public void actionPerformed(ActionEvent e) {
			Save();
		}
	}
}
