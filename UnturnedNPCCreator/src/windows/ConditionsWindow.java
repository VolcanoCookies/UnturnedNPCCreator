package windows;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import panels.NewCondition;
import panels.VendorBuyingCondition;
import panels.VendorPanel;
import javax.swing.JInternalFrame;

public class ConditionsWindow extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroupQuestStatus = new ButtonGroup();
	private JMenuBar menuBar;
	private JButton buttonNewCondition;
	private int conditionIndex = 0;
	private final Action actionAddCondition = new SwingActionAddCondition();
	private JTabbedPane tabbedPane;
	private JButton buttonSave;
	private VendorPanel caller;
	
//	/**
//	 * Launch the application.
//	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConditionsWindow frame = new ConditionsWindow(getPeer());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//
//	/**
//	 * Create the frame.
//	 */
	public ConditionsWindow(Component caller) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Save","Cancel","Exit"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Are you sure?",JOptionPane.WARNING_MESSAGE,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==0)
		        {
		        	Save();
		        } else if (PromptResult==2)
		        {
		        	System.exit(0);
		        }
		    }
		});
		setBounds(100, 100, 580, 455);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		buttonNewCondition = new JButton("Add Condition");
		buttonNewCondition.setAction(actionAddCondition);
		menuBar.add(buttonNewCondition);
		
		buttonSave = new JButton("New button");
		menuBar.add(buttonSave);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Experience", "Reputation", "Flag_Bool", "Flag_SHort", "Quest", "SKillset", "Item", "Kills_Zombie", "Kills_Horde"}));
		contentPane.add(comboBox);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		NewCondition newCondition = new NewCondition();
		tabbedPane.addTab("Con#" + ++conditionIndex , null, newCondition, null);
		tabbedPane.setEnabledAt(0, true);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
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
	protected void Save() {
		String output = null;
		int i = 0;
		output = "Conditions " + tabbedPane.getTabCount() + "\n";
		for(Component panel : tabbedPane.getComponents())
		{
			output += ((NewCondition) panel).ReturnConditions(i++) + "\n";
		}
		
		((VendorBuyingCondition) caller).PassConditions(output);
		
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
}
