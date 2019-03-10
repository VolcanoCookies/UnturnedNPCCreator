package rewards;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class RewardsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8696372636553406187L;
	private int rewardIndex = 0;
	private JTabbedPane tabbedPane;
	private JMenuBar menuBar;
	private JButton buttonNewReward;
	private JButton buttonSave;
	private final Action actionSave = new SwingActionSave();
	private final Action actionRemoveCurrent = new SwingActionRemoveCurrent();
	private final Action actionAddRewards = new SwingActionAddReward();
	private JButton buttonRemoveCurrent;
	
	/**
	 * Create the panel.
	 * @param container 
	 */
	public RewardsPanel(String rewards) {
		new JPanel();
		setVisible(true);
		setEnabled(true);
		setBounds(100, 100, 580, 475);
		setMinimumSize(new Dimension(580,455));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		setLayout(new GridLayout(0, 2, 0, 0));
		setLayout(new BorderLayout(0, 0));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		menuBar = new JMenuBar();
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.fill = GridBagConstraints.VERTICAL;
		gbc_menuBar.anchor = GridBagConstraints.WEST;
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		add(menuBar, BorderLayout.NORTH);
		
		buttonNewReward = new JButton("Add Reward");
		buttonNewReward.setAction(actionAddRewards);
		menuBar.add(buttonNewReward);
		
		buttonRemoveCurrent = new JButton("Remove Current");
		buttonRemoveCurrent.setAction(actionRemoveCurrent);
		menuBar.add(buttonRemoveCurrent);
		
		buttonSave = new JButton("Save");
		buttonSave.setAction(actionSave);
		menuBar.add(buttonSave);
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
		
		if(rewards!=null)
			LoadRewards(rewards);
		else {
			NewReward newReward = new NewReward(null);
			tabbedPane.addTab("Rew#" + ++rewardIndex  , null, newReward, null);
			tabbedPane.setEnabledAt(0, true);
		}
		
	}
	
	private void LoadRewards(String rewards) {
		//Make array out of passed rewards
		String[] rewardLines = rewards.split("\n");
		
		//Controller values
		int rewardsAmount = 0;
		String[] rewardsArray = null;
		
		//Get number of rewards
		for(String string: rewardLines) {
			if(string.toLowerCase().contains("rewards ")) {
				rewardsAmount = Integer.valueOf(string.split(" ")[1]);
				rewardsArray = new String[rewardsAmount];
			}
		}
		
		//Separate different rewards
		for(int i = 0; i < rewardsAmount; i++) {
			rewardsArray[i] = "";
			for(String string : rewardLines) {
				if(string.toLowerCase().contains("reward_" + i + "_")) {
					rewardsArray[i] += string + "\n";
				}
			}
		}
		
		//Create Tabs
		for(int i = 0; i < rewardsAmount; i++) {	
			tabbedPane.addTab("Rew#" + ++rewardIndex , null, new NewReward(rewardsArray[i]), null);
		}
	}
	
	public String Save() {
		int i = 0;
		//Get rewards count
		String output = "Rewards " + tabbedPane.getTabCount() + "\n";
		//Get each separate reward and merge
		for(Component panel : tabbedPane.getComponents())
		{
			output += ((NewReward) panel).ReturnRewards(i++) + "\n";
		}
		
		//Remove last "\n"
		output = output.substring(0, output.length()-1);
		
		return output;
	}
	private class SwingActionAddReward extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2963654643003997846L;
		public SwingActionAddReward() {
			putValue(NAME, "Add Reward");
			putValue(SHORT_DESCRIPTION, "Add a new reward.");
		}
		public void actionPerformed(ActionEvent e) {
			tabbedPane.addTab("Rew#" + ++rewardIndex , null, new NewReward(null), null);
		}
	}
	private class SwingActionSave extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4548002178573267948L;
		public SwingActionSave() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save the rewards.");
		}
		public void actionPerformed(ActionEvent e) {
			Save();
		}
	}
	private class SwingActionRemoveCurrent extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 173234416619775984L;
		public SwingActionRemoveCurrent() {
			putValue(NAME, "Remove Current");
			putValue(SHORT_DESCRIPTION, "Remove the currently selected reward.");
		}
		public void actionPerformed(ActionEvent e) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			ReorganizeIndex();
		}
	}
	public void ReorganizeIndex() {
		for(int i = 0; i < tabbedPane.getComponentCount(); i++)
		{
			tabbedPane.setTitleAt(i, "Rew#" + (i+1));
		}
	}
}
