package windows;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Conditions extends JFrame {

	private JPanel contentPane;
	private JPanel panelExperience;
	private JPanel panelReputation;
	private JPanel panelFlagShort;
	private JPanel panelFlagBool;
	private JPanel panelQuest;
	private JPanel panelSkillset;
	private JPanel panelItem;
	private JPanel panelKillsZombie;
	private JPanel panelKillsHorde;
	private JPanel panelConditionType;
	private JTextField textFieldTargetExperience;
	private JLabel lblTargetExperience;
	private JLabel lblTargetReputation;
	private JTextField textFieldTargetReputation;
	private JLabel lblShortConditionID;
	private JLabel lblShortConditionValue;
	private JTextField textFieldShortConditionValue;
	private JTextField textFieldShortConditionID;
	private JLabel lblShortAllowUnset;
	private JToggleButton toggleButtonShortAllowUnset;
	private JLabel lblBoolConditionID;
	private JLabel lblBoolValue;
	private JLabel lblBoolAllowUnset;
	private JTextField textFieldBoolConditionID;
	private JToggleButton toggleButtonBoolConditionValue;
	private JToggleButton toggleButtonBoolAllowUnset;
	private JLabel lblQuestID;
	private JTextField textFieldQuestID;
	private JLabel lblQuestStatus;
	private JPanel panelQuestStatus;
	private JRadioButton rdbtnActive;
	private JRadioButton rdbtnReady;
	private JRadioButton rdbtnCompleted;
	private final ButtonGroup buttonGroupQuestStatus = new ButtonGroup();
	private JLabel lblSkillsetConditionValue;
	private JComboBox comboBoxSkillsets;
	private JLabel lblItemID;
	private JLabel lblItemAmount;
	private JTextField textFieldItemID;
	private JTextField textFieldItemAmount;
	private JLabel lblZombieType;
	private JComboBox comboBoxZombieType;
	private JLabel lblConditionId;
	private JTextField textFieldZombieConditionID;
	private JLabel lblTargetKills;
	private JLabel lblNavmeshIndex;
	private JLabel lblSpawn;
	private JToggleButton toggleButtonZombieSpawn;
	private JTextField textFieldZombieTargetKills;
	private JTextField textFieldZombieNavmeshIndex;
	private JLabel lblHordeConditionID;
	private JLabel lblHordeTargetBeacons;
	private JLabel lblHordeNavmeshIndex;
	private JTextField textFieldHordeConditionID;
	private JTextField textFieldHordeTargetBeacons;
	private JTextField textFieldHordeNavmeshIndex;
	private JPanel panelKillsAnimal;
	private JLabel lblAnimalConditionID;
	private JTextField textField;
	private JLabel lblAnimalID;
	private JLabel lblTargetKills_1;
	private JTextField txtPanelconditiontypeaddpanelexperiencename;
	private JTextField textField_1;
	private JPanel panelTimeOfDay;
	private JPanel panelCompareFlags;
	private JLabel lblNewLabel;
	private JLabel lblConditionB;
	private JToggleButton toggleButtonConditionAAllowUnset;
	private JToggleButton toggleButtonConditionBAllowUnset;
	private JTextField textFieldConditionAID;
	private JTextField textFieldConditionBID;
	private JComboBox comboBoxCompareLogicalOperator;
	private JLabel lblSetBackTo;
	private JToggleButton toggleButtonReset;
	private JLabel lblConditionLogic;
	private JComboBox comboBoxConditionLogic;
	private JLabel lblSeconds;
	private JTextField textFieldSeconds;
	private JMenuBar menuBar;
	private JButton buttonNewCondition;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conditions frame = new Conditions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conditions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 324);
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
		menuBar.add(buttonNewCondition);
		
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Experience", "Reputation", "Flag_Bool", "Flag_SHort", "Quest", "SKillset", "Item", "Kills_Zombie", "Kills_Horde"}));
		contentPane.add(comboBox);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblConditionType = new JLabel("Condition type");
		lblConditionType.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblConditionType = new GridBagConstraints();
		gbc_lblConditionType.insets = new Insets(0, 0, 5, 5);
		gbc_lblConditionType.gridx = 0;
		gbc_lblConditionType.gridy = 0;
		panel.add(lblConditionType, gbc_lblConditionType);
		
		JComboBox comboBoxConditionType = new JComboBox();
		comboBoxConditionType.setMaximumRowCount(13);
		comboBoxConditionType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==ItemEvent.SELECTED&&panelConditionType!=null)
					if(panelConditionType.getComponents().length>=8)
						showCondition(comboBoxConditionType.getSelectedIndex());
			}
		});
		comboBoxConditionType.setModel(new DefaultComboBoxModel(new String[] {"Experience", "Reputation", "Flag_Bool", "Flag_Short", "Quest", "Skillset", "Item", "Kills_Zombie", "Kills_Horde", "Kills_Animal", "Time_Of_Day", "Compare_Flags"}));
		comboBoxConditionType.setSelectedIndex(0);
		GridBagConstraints gbc_comboBoxConditionType = new GridBagConstraints();
		gbc_comboBoxConditionType.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxConditionType.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxConditionType.gridx = 1;
		gbc_comboBoxConditionType.gridy = 0;
		panel.add(comboBoxConditionType, gbc_comboBoxConditionType);
		
		lblSetBackTo = new JLabel("Set back to zero");
		GridBagConstraints gbc_lblSetBackTo = new GridBagConstraints();
		gbc_lblSetBackTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSetBackTo.gridx = 0;
		gbc_lblSetBackTo.gridy = 1;
		panel.add(lblSetBackTo, gbc_lblSetBackTo);
		
		toggleButtonReset = new JToggleButton("False");
		toggleButtonReset.setToolTipText("Reset the condition value to 0 when completed");
		toggleButtonReset.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					toggleButtonReset.setText("True");
				else
					toggleButtonReset.setText("False");
			}
		});
		GridBagConstraints gbc_toggleButtonReset = new GridBagConstraints();
		gbc_toggleButtonReset.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButtonReset.insets = new Insets(0, 0, 5, 0);
		gbc_toggleButtonReset.gridx = 1;
		gbc_toggleButtonReset.gridy = 1;
		panel.add(toggleButtonReset, gbc_toggleButtonReset);
		
		lblConditionLogic = new JLabel("Condition logic");
		GridBagConstraints gbc_lblConditionLogic = new GridBagConstraints();
		gbc_lblConditionLogic.insets = new Insets(0, 0, 5, 5);
		gbc_lblConditionLogic.gridx = 0;
		gbc_lblConditionLogic.gridy = 2;
		panel.add(lblConditionLogic, gbc_lblConditionLogic);
		
		comboBoxConditionLogic = new JComboBox();
		comboBoxConditionLogic.setModel(new DefaultComboBoxModel(new String[] {"Less_Than", "Less_Than_Or_Equal_To", "Equal", "Not_Equal", "Greater_Than_Or_Equal_To", "Greater_Than"}));
		GridBagConstraints gbc_comboBoxConditionLogic = new GridBagConstraints();
		gbc_comboBoxConditionLogic.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxConditionLogic.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxConditionLogic.gridx = 1;
		gbc_comboBoxConditionLogic.gridy = 2;
		panel.add(comboBoxConditionLogic, gbc_comboBoxConditionLogic);
		
		panelConditionType = new JPanel();
		GridBagConstraints gbc_panelConditionType = new GridBagConstraints();
		gbc_panelConditionType.gridwidth = 2;
		gbc_panelConditionType.fill = GridBagConstraints.BOTH;
		gbc_panelConditionType.gridx = 0;
		gbc_panelConditionType.gridy = 3;
		panel.add(panelConditionType, gbc_panelConditionType);
		panelConditionType.setLayout(new CardLayout(0, 0));
		
		panelExperience = new JPanel();
		panelConditionType.add(panelExperience, "name_88379589756902");
		GridBagLayout gbl_panelExperience = new GridBagLayout();
		gbl_panelExperience.columnWidths = new int[]{46, 86, 0};
		gbl_panelExperience.rowHeights = new int[]{20, 0};
		gbl_panelExperience.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelExperience.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelExperience.setLayout(gbl_panelExperience);
		
		lblTargetExperience = new JLabel("Target experience");
		GridBagConstraints gbc_lblTargetExperience = new GridBagConstraints();
		gbc_lblTargetExperience.insets = new Insets(0, 0, 0, 5);
		gbc_lblTargetExperience.gridx = 0;
		gbc_lblTargetExperience.gridy = 0;
		panelExperience.add(lblTargetExperience, gbc_lblTargetExperience);
		
		textFieldTargetExperience = new JTextField();
		textFieldTargetExperience.setToolTipText("Required experience");
		GridBagConstraints gbc_textFieldTargetExperience = new GridBagConstraints();
		gbc_textFieldTargetExperience.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTargetExperience.anchor = GridBagConstraints.NORTH;
		gbc_textFieldTargetExperience.gridx = 1;
		gbc_textFieldTargetExperience.gridy = 0;
		panelExperience.add(textFieldTargetExperience, gbc_textFieldTargetExperience);
		textFieldTargetExperience.setColumns(10);
		
		panelReputation = new JPanel();
		panelConditionType.add(panelReputation, "name_88379605110798");
		GridBagLayout gbl_panelReputation = new GridBagLayout();
		gbl_panelReputation.columnWidths = new int[]{46, 0, 0};
		gbl_panelReputation.rowHeights = new int[]{14, 0};
		gbl_panelReputation.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelReputation.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelReputation.setLayout(gbl_panelReputation);
		
		lblTargetReputation = new JLabel("Target reputation");
		GridBagConstraints gbc_lblTargetReputation = new GridBagConstraints();
		gbc_lblTargetReputation.insets = new Insets(0, 0, 0, 5);
		gbc_lblTargetReputation.gridx = 0;
		gbc_lblTargetReputation.gridy = 0;
		panelReputation.add(lblTargetReputation, gbc_lblTargetReputation);
		
		textFieldTargetReputation = new JTextField();
		textFieldTargetReputation.setToolTipText("Required reputation");
		GridBagConstraints gbc_textFieldTargetReputation = new GridBagConstraints();
		gbc_textFieldTargetReputation.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTargetReputation.gridx = 1;
		gbc_textFieldTargetReputation.gridy = 0;
		panelReputation.add(textFieldTargetReputation, gbc_textFieldTargetReputation);
		textFieldTargetReputation.setColumns(10);
		
		panelFlagBool = new JPanel();
		panelConditionType.add(panelFlagBool, "name_88379619698912");
		GridBagLayout gbl_panelFlagBool = new GridBagLayout();
		gbl_panelFlagBool.columnWidths = new int[]{0, 0, 0};
		gbl_panelFlagBool.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelFlagBool.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelFlagBool.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelFlagBool.setLayout(gbl_panelFlagBool);
		
		lblBoolConditionID = new JLabel("Condition ID");
		lblBoolConditionID.setToolTipText("");
		GridBagConstraints gbc_lblBoolConditionID = new GridBagConstraints();
		gbc_lblBoolConditionID.anchor = GridBagConstraints.EAST;
		gbc_lblBoolConditionID.insets = new Insets(0, 0, 5, 5);
		gbc_lblBoolConditionID.gridx = 0;
		gbc_lblBoolConditionID.gridy = 0;
		panelFlagBool.add(lblBoolConditionID, gbc_lblBoolConditionID);
		
		textFieldBoolConditionID = new JTextField();
		textFieldBoolConditionID.setToolTipText("Similar to normal IDs, flag ID on the player to check");
		GridBagConstraints gbc_textFieldBoolConditionID = new GridBagConstraints();
		gbc_textFieldBoolConditionID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBoolConditionID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBoolConditionID.gridx = 1;
		gbc_textFieldBoolConditionID.gridy = 0;
		panelFlagBool.add(textFieldBoolConditionID, gbc_textFieldBoolConditionID);
		textFieldBoolConditionID.setColumns(10);
		
		lblBoolValue = new JLabel("Condition Value");
		GridBagConstraints gbc_lblBoolValue = new GridBagConstraints();
		gbc_lblBoolValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblBoolValue.gridx = 0;
		gbc_lblBoolValue.gridy = 1;
		panelFlagBool.add(lblBoolValue, gbc_lblBoolValue);
		
		toggleButtonBoolConditionValue = new JToggleButton("False");
		toggleButtonBoolConditionValue.setToolTipText("Target value for the flag \"True\" or \"False\"");
		toggleButtonBoolConditionValue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					toggleButtonBoolConditionValue.setText("True");
				else
					toggleButtonBoolConditionValue.setText("False");
			}
		});
		GridBagConstraints gbc_toggleButtonBoolConditionValue = new GridBagConstraints();
		gbc_toggleButtonBoolConditionValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButtonBoolConditionValue.insets = new Insets(0, 0, 5, 0);
		gbc_toggleButtonBoolConditionValue.gridx = 1;
		gbc_toggleButtonBoolConditionValue.gridy = 1;
		panelFlagBool.add(toggleButtonBoolConditionValue, gbc_toggleButtonBoolConditionValue);
		
		lblBoolAllowUnset = new JLabel("Allow Unset");
		GridBagConstraints gbc_lblBoolAllowUnset = new GridBagConstraints();
		gbc_lblBoolAllowUnset.insets = new Insets(0, 0, 0, 5);
		gbc_lblBoolAllowUnset.gridx = 0;
		gbc_lblBoolAllowUnset.gridy = 2;
		panelFlagBool.add(lblBoolAllowUnset, gbc_lblBoolAllowUnset);
		
		toggleButtonBoolAllowUnset = new JToggleButton("False");
		toggleButtonBoolAllowUnset.setToolTipText("Pass condition if the player doesn't have this flag yet");
		toggleButtonBoolAllowUnset.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					toggleButtonBoolAllowUnset.setText("True");
				else
					toggleButtonBoolAllowUnset.setText("False");
			}
		});
		GridBagConstraints gbc_toggleButtonBoolAllowUnset = new GridBagConstraints();
		gbc_toggleButtonBoolAllowUnset.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButtonBoolAllowUnset.gridx = 1;
		gbc_toggleButtonBoolAllowUnset.gridy = 2;
		panelFlagBool.add(toggleButtonBoolAllowUnset, gbc_toggleButtonBoolAllowUnset);
		
		panelFlagShort = new JPanel();
		panelConditionType.add(panelFlagShort, "name_88379634158471");
		GridBagLayout gbl_panelFlagShort = new GridBagLayout();
		gbl_panelFlagShort.columnWidths = new int[]{46, 0, 0};
		gbl_panelFlagShort.rowHeights = new int[]{14, 0, 0, 0};
		gbl_panelFlagShort.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelFlagShort.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelFlagShort.setLayout(gbl_panelFlagShort);
		
		lblShortConditionID = new JLabel("Condition ID");
		lblShortConditionID.setToolTipText("");
		GridBagConstraints gbc_lblShortConditionID = new GridBagConstraints();
		gbc_lblShortConditionID.anchor = GridBagConstraints.EAST;
		gbc_lblShortConditionID.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortConditionID.gridx = 0;
		gbc_lblShortConditionID.gridy = 0;
		panelFlagShort.add(lblShortConditionID, gbc_lblShortConditionID);
		
		textFieldShortConditionID = new JTextField();
		textFieldShortConditionID.setToolTipText("Similar to normal IDs, flag ID on the player to check");
		textFieldShortConditionID.setColumns(10);
		GridBagConstraints gbc_textFieldShortConditionID = new GridBagConstraints();
		gbc_textFieldShortConditionID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldShortConditionID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldShortConditionID.gridx = 1;
		gbc_textFieldShortConditionID.gridy = 0;
		panelFlagShort.add(textFieldShortConditionID, gbc_textFieldShortConditionID);
		
		lblShortConditionValue = new JLabel("Condition Value");
		GridBagConstraints gbc_lblShortConditionValue = new GridBagConstraints();
		gbc_lblShortConditionValue.anchor = GridBagConstraints.EAST;
		gbc_lblShortConditionValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortConditionValue.gridx = 0;
		gbc_lblShortConditionValue.gridy = 1;
		panelFlagShort.add(lblShortConditionValue, gbc_lblShortConditionValue);
		
		textFieldShortConditionValue = new JTextField();
		textFieldShortConditionValue.setToolTipText("Target value for the flag, 16 bit integer meaning the range  [-32768, 32767]");
		GridBagConstraints gbc_textFieldShortConditionValue = new GridBagConstraints();
		gbc_textFieldShortConditionValue.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldShortConditionValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldShortConditionValue.gridx = 1;
		gbc_textFieldShortConditionValue.gridy = 1;
		panelFlagShort.add(textFieldShortConditionValue, gbc_textFieldShortConditionValue);
		textFieldShortConditionValue.setColumns(10);
		
		lblShortAllowUnset = new JLabel("Allow Unset");
		GridBagConstraints gbc_lblShortAllowUnset = new GridBagConstraints();
		gbc_lblShortAllowUnset.insets = new Insets(0, 0, 0, 5);
		gbc_lblShortAllowUnset.gridx = 0;
		gbc_lblShortAllowUnset.gridy = 2;
		panelFlagShort.add(lblShortAllowUnset, gbc_lblShortAllowUnset);
		
		toggleButtonShortAllowUnset = new JToggleButton("False");
		toggleButtonShortAllowUnset.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					toggleButtonShortAllowUnset.setText("True");
				else
					toggleButtonShortAllowUnset.setText("False");
			}
		});
		toggleButtonShortAllowUnset.setToolTipText("Pass condition if the player doesn't have this flag yet");
		GridBagConstraints gbc_toggleButtonShortAllowUnset = new GridBagConstraints();
		gbc_toggleButtonShortAllowUnset.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButtonShortAllowUnset.gridx = 1;
		gbc_toggleButtonShortAllowUnset.gridy = 2;
		panelFlagShort.add(toggleButtonShortAllowUnset, gbc_toggleButtonShortAllowUnset);
		
		panelQuest = new JPanel();
		panelConditionType.add(panelQuest, "name_88379648449025");
		GridBagLayout gbl_panelQuest = new GridBagLayout();
		gbl_panelQuest.columnWidths = new int[]{0, 0, 0};
		gbl_panelQuest.rowHeights = new int[]{0, 0, 0};
		gbl_panelQuest.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelQuest.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelQuest.setLayout(gbl_panelQuest);
		
		lblQuestID = new JLabel("Quest ID");
		GridBagConstraints gbc_lblQuestID = new GridBagConstraints();
		gbc_lblQuestID.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuestID.anchor = GridBagConstraints.EAST;
		gbc_lblQuestID.gridx = 0;
		gbc_lblQuestID.gridy = 0;
		panelQuest.add(lblQuestID, gbc_lblQuestID);
		
		textFieldQuestID = new JTextField();
		textFieldQuestID.setToolTipText("Quest ID to check for");
		GridBagConstraints gbc_textFieldQuestID = new GridBagConstraints();
		gbc_textFieldQuestID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldQuestID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldQuestID.gridx = 1;
		gbc_textFieldQuestID.gridy = 0;
		panelQuest.add(textFieldQuestID, gbc_textFieldQuestID);
		textFieldQuestID.setColumns(10);
		
		lblQuestStatus = new JLabel("Quest status");
		GridBagConstraints gbc_lblQuestStatus = new GridBagConstraints();
		gbc_lblQuestStatus.insets = new Insets(0, 0, 0, 5);
		gbc_lblQuestStatus.gridx = 0;
		gbc_lblQuestStatus.gridy = 1;
		panelQuest.add(lblQuestStatus, gbc_lblQuestStatus);
		
		panelQuestStatus = new JPanel();
		GridBagConstraints gbc_panelQuestStatus = new GridBagConstraints();
		gbc_panelQuestStatus.fill = GridBagConstraints.BOTH;
		gbc_panelQuestStatus.gridx = 1;
		gbc_panelQuestStatus.gridy = 1;
		panelQuest.add(panelQuestStatus, gbc_panelQuestStatus);
		
		rdbtnActive = new JRadioButton("Active");
		buttonGroupQuestStatus.add(rdbtnActive);
		rdbtnActive.setToolTipText("Checks if the player has the quest");
		panelQuestStatus.add(rdbtnActive);
		
		rdbtnReady = new JRadioButton("Ready");
		buttonGroupQuestStatus.add(rdbtnReady);
		rdbtnReady.setToolTipText("Checks if the quest can be completed");
		panelQuestStatus.add(rdbtnReady);
		
		rdbtnCompleted = new JRadioButton("Completed");
		buttonGroupQuestStatus.add(rdbtnCompleted);
		rdbtnCompleted.setToolTipText("Checks if the quest is completed");
		panelQuestStatus.add(rdbtnCompleted);
		
		panelSkillset = new JPanel();
		panelConditionType.add(panelSkillset, "name_88379663201987");
		GridBagLayout gbl_panelSkillset = new GridBagLayout();
		gbl_panelSkillset.columnWidths = new int[]{0, 0, 0};
		gbl_panelSkillset.rowHeights = new int[]{23, 0};
		gbl_panelSkillset.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelSkillset.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelSkillset.setLayout(gbl_panelSkillset);
		
		lblSkillsetConditionValue = new JLabel("Condition Value");
		GridBagConstraints gbc_lblSkillsetConditionValue = new GridBagConstraints();
		gbc_lblSkillsetConditionValue.anchor = GridBagConstraints.EAST;
		gbc_lblSkillsetConditionValue.insets = new Insets(0, 0, 0, 5);
		gbc_lblSkillsetConditionValue.gridx = 0;
		gbc_lblSkillsetConditionValue.gridy = 0;
		panelSkillset.add(lblSkillsetConditionValue, gbc_lblSkillsetConditionValue);
		
		comboBoxSkillsets = new JComboBox(ComboBoxIcon());
		comboBoxSkillsets.setMaximumRowCount(11);
		GridBagConstraints gbc_comboBoxSkillsets = new GridBagConstraints();
		gbc_comboBoxSkillsets.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSkillsets.gridx = 1;
		gbc_comboBoxSkillsets.gridy = 0;
		panelSkillset.add(comboBoxSkillsets, gbc_comboBoxSkillsets);
		
		panelItem = new JPanel();
		panelConditionType.add(panelItem, "name_88379701526329");
		GridBagLayout gbl_panelItem = new GridBagLayout();
		gbl_panelItem.columnWidths = new int[]{0, 0, 0};
		gbl_panelItem.rowHeights = new int[]{0, 0, 0};
		gbl_panelItem.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelItem.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelItem.setLayout(gbl_panelItem);
		
		lblItemID = new JLabel("Item ID");
		GridBagConstraints gbc_lblItemID = new GridBagConstraints();
		gbc_lblItemID.anchor = GridBagConstraints.EAST;
		gbc_lblItemID.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemID.gridx = 0;
		gbc_lblItemID.gridy = 0;
		panelItem.add(lblItemID, gbc_lblItemID);
		
		textFieldItemID = new JTextField();
		textFieldItemID.setToolTipText("Item ID to search inventory for");
		GridBagConstraints gbc_textFieldItemID = new GridBagConstraints();
		gbc_textFieldItemID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldItemID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldItemID.gridx = 1;
		gbc_textFieldItemID.gridy = 0;
		panelItem.add(textFieldItemID, gbc_textFieldItemID);
		textFieldItemID.setColumns(10);
		
		lblItemAmount = new JLabel("Item Amount");
		GridBagConstraints gbc_lblItemAmount = new GridBagConstraints();
		gbc_lblItemAmount.anchor = GridBagConstraints.EAST;
		gbc_lblItemAmount.insets = new Insets(0, 0, 0, 5);
		gbc_lblItemAmount.gridx = 0;
		gbc_lblItemAmount.gridy = 1;
		panelItem.add(lblItemAmount, gbc_lblItemAmount);
		
		textFieldItemAmount = new JTextField();
		textFieldItemAmount.setToolTipText("Number of the item required");
		textFieldItemAmount.setColumns(10);
		GridBagConstraints gbc_textFieldItemAmount = new GridBagConstraints();
		gbc_textFieldItemAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldItemAmount.gridx = 1;
		gbc_textFieldItemAmount.gridy = 1;
		panelItem.add(textFieldItemAmount, gbc_textFieldItemAmount);
		
		panelKillsZombie = new JPanel();
		panelConditionType.add(panelKillsZombie, "name_88379716777992");
		GridBagLayout gbl_panelKillsZombie = new GridBagLayout();
		gbl_panelKillsZombie.columnWidths = new int[]{0, 0, 0};
		gbl_panelKillsZombie.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelKillsZombie.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelKillsZombie.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelKillsZombie.setLayout(gbl_panelKillsZombie);
		
		lblZombieType = new JLabel("Zombie type");
		GridBagConstraints gbc_lblZombieType = new GridBagConstraints();
		gbc_lblZombieType.insets = new Insets(0, 0, 5, 5);
		gbc_lblZombieType.anchor = GridBagConstraints.EAST;
		gbc_lblZombieType.gridx = 0;
		gbc_lblZombieType.gridy = 0;
		panelKillsZombie.add(lblZombieType, gbc_lblZombieType);
		
		comboBoxZombieType = new JComboBox();
		comboBoxZombieType.setMaximumRowCount(12);
		comboBoxZombieType.setModel(new DefaultComboBoxModel(new String[] {"Any", "Normal", "Mega", "Crawler", "Sprinter", "Flanker Visible", "Flanker Invisible", "Burner", "Acid", "Boss Electric", "Boss Wind", "Boss Fire"}));
		GridBagConstraints gbc_comboBoxZombieType = new GridBagConstraints();
		gbc_comboBoxZombieType.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxZombieType.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxZombieType.gridx = 1;
		gbc_comboBoxZombieType.gridy = 0;
		panelKillsZombie.add(comboBoxZombieType, gbc_comboBoxZombieType);
		
		lblConditionId = new JLabel("Condition ID");
		GridBagConstraints gbc_lblConditionId = new GridBagConstraints();
		gbc_lblConditionId.anchor = GridBagConstraints.EAST;
		gbc_lblConditionId.insets = new Insets(0, 0, 5, 5);
		gbc_lblConditionId.gridx = 0;
		gbc_lblConditionId.gridy = 1;
		panelKillsZombie.add(lblConditionId, gbc_lblConditionId);
		
		textFieldZombieConditionID = new JTextField();
		textFieldZombieConditionID.setToolTipText("Short flag to track stat");
		GridBagConstraints gbc_textFieldZombieConditionID = new GridBagConstraints();
		gbc_textFieldZombieConditionID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldZombieConditionID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldZombieConditionID.gridx = 1;
		gbc_textFieldZombieConditionID.gridy = 1;
		panelKillsZombie.add(textFieldZombieConditionID, gbc_textFieldZombieConditionID);
		textFieldZombieConditionID.setColumns(10);
		
		lblTargetKills = new JLabel("Target kills");
		GridBagConstraints gbc_lblTargetKills = new GridBagConstraints();
		gbc_lblTargetKills.anchor = GridBagConstraints.EAST;
		gbc_lblTargetKills.insets = new Insets(0, 0, 5, 5);
		gbc_lblTargetKills.gridx = 0;
		gbc_lblTargetKills.gridy = 2;
		panelKillsZombie.add(lblTargetKills, gbc_lblTargetKills);
		
		textFieldZombieTargetKills = new JTextField();
		textFieldZombieTargetKills.setToolTipText("Required kills");
		GridBagConstraints gbc_textFieldZombieTargetKills = new GridBagConstraints();
		gbc_textFieldZombieTargetKills.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldZombieTargetKills.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldZombieTargetKills.gridx = 1;
		gbc_textFieldZombieTargetKills.gridy = 2;
		panelKillsZombie.add(textFieldZombieTargetKills, gbc_textFieldZombieTargetKills);
		textFieldZombieTargetKills.setColumns(10);
		
		lblSpawn = new JLabel("Spawn");
		GridBagConstraints gbc_lblSpawn = new GridBagConstraints();
		gbc_lblSpawn.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpawn.gridx = 0;
		gbc_lblSpawn.gridy = 3;
		panelKillsZombie.add(lblSpawn, gbc_lblSpawn);
		
		toggleButtonZombieSpawn = new JToggleButton("False");
		toggleButtonZombieSpawn.setToolTipText("Specified if zombie should be generated (like for bosses), will be killed when you leave the area");
		toggleButtonZombieSpawn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					toggleButtonZombieSpawn.setText("True");
				else
					toggleButtonZombieSpawn.setText("False");
			}
		});
		GridBagConstraints gbc_toggleButtonZombieSpawn = new GridBagConstraints();
		gbc_toggleButtonZombieSpawn.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButtonZombieSpawn.insets = new Insets(0, 0, 5, 0);
		gbc_toggleButtonZombieSpawn.gridx = 1;
		gbc_toggleButtonZombieSpawn.gridy = 3;
		panelKillsZombie.add(toggleButtonZombieSpawn, gbc_toggleButtonZombieSpawn);
		
		lblNavmeshIndex = new JLabel("Navmesh index");
		GridBagConstraints gbc_lblNavmeshIndex = new GridBagConstraints();
		gbc_lblNavmeshIndex.anchor = GridBagConstraints.EAST;
		gbc_lblNavmeshIndex.insets = new Insets(0, 0, 0, 5);
		gbc_lblNavmeshIndex.gridx = 0;
		gbc_lblNavmeshIndex.gridy = 4;
		panelKillsZombie.add(lblNavmeshIndex, gbc_lblNavmeshIndex);
		
		textFieldZombieNavmeshIndex = new JTextField();
		textFieldZombieNavmeshIndex.setToolTipText("Index of the navmesh visible when selecting it in the editor");
		GridBagConstraints gbc_textFieldZombieNavmeshIndex = new GridBagConstraints();
		gbc_textFieldZombieNavmeshIndex.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldZombieNavmeshIndex.gridx = 1;
		gbc_textFieldZombieNavmeshIndex.gridy = 4;
		panelKillsZombie.add(textFieldZombieNavmeshIndex, gbc_textFieldZombieNavmeshIndex);
		textFieldZombieNavmeshIndex.setColumns(10);
		
		panelKillsHorde = new JPanel();
		panelConditionType.add(panelKillsHorde, "name_88379731191560");
		GridBagLayout gbl_panelKillsHorde = new GridBagLayout();
		gbl_panelKillsHorde.columnWidths = new int[]{0, 0, 0};
		gbl_panelKillsHorde.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelKillsHorde.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelKillsHorde.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelKillsHorde.setLayout(gbl_panelKillsHorde);
		
		lblHordeConditionID = new JLabel("Condition ID");
		GridBagConstraints gbc_lblHordeConditionID = new GridBagConstraints();
		gbc_lblHordeConditionID.anchor = GridBagConstraints.EAST;
		gbc_lblHordeConditionID.insets = new Insets(0, 0, 5, 5);
		gbc_lblHordeConditionID.gridx = 0;
		gbc_lblHordeConditionID.gridy = 0;
		panelKillsHorde.add(lblHordeConditionID, gbc_lblHordeConditionID);
		
		textFieldHordeConditionID = new JTextField();
		textFieldHordeConditionID.setToolTipText("Short flag to track stat");
		GridBagConstraints gbc_textFieldHordeConditionID = new GridBagConstraints();
		gbc_textFieldHordeConditionID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHordeConditionID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHordeConditionID.gridx = 1;
		gbc_textFieldHordeConditionID.gridy = 0;
		panelKillsHorde.add(textFieldHordeConditionID, gbc_textFieldHordeConditionID);
		textFieldHordeConditionID.setColumns(10);
		
		lblHordeTargetBeacons = new JLabel("Target Beacons\r\n");
		GridBagConstraints gbc_lblHordeTargetBeacons = new GridBagConstraints();
		gbc_lblHordeTargetBeacons.anchor = GridBagConstraints.EAST;
		gbc_lblHordeTargetBeacons.insets = new Insets(0, 0, 5, 5);
		gbc_lblHordeTargetBeacons.gridx = 0;
		gbc_lblHordeTargetBeacons.gridy = 1;
		panelKillsHorde.add(lblHordeTargetBeacons, gbc_lblHordeTargetBeacons);
		
		textFieldHordeTargetBeacons = new JTextField();
		textFieldHordeTargetBeacons.setToolTipText("Required number of beacons to complete");
		textFieldHordeTargetBeacons.setColumns(10);
		GridBagConstraints gbc_textFieldHordeTargetBeacons = new GridBagConstraints();
		gbc_textFieldHordeTargetBeacons.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHordeTargetBeacons.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHordeTargetBeacons.gridx = 1;
		gbc_textFieldHordeTargetBeacons.gridy = 1;
		panelKillsHorde.add(textFieldHordeTargetBeacons, gbc_textFieldHordeTargetBeacons);
		
		lblHordeNavmeshIndex = new JLabel("Navmesh Index");
		GridBagConstraints gbc_lblHordeNavmeshIndex = new GridBagConstraints();
		gbc_lblHordeNavmeshIndex.anchor = GridBagConstraints.EAST;
		gbc_lblHordeNavmeshIndex.insets = new Insets(0, 0, 0, 5);
		gbc_lblHordeNavmeshIndex.gridx = 0;
		gbc_lblHordeNavmeshIndex.gridy = 2;
		panelKillsHorde.add(lblHordeNavmeshIndex, gbc_lblHordeNavmeshIndex);
		
		textFieldHordeNavmeshIndex = new JTextField();
		textFieldHordeNavmeshIndex.setToolTipText("Index of the navmesh visible when selecting it in the editor");
		textFieldHordeNavmeshIndex.setColumns(10);
		GridBagConstraints gbc_textFieldHordeNavmeshIndex = new GridBagConstraints();
		gbc_textFieldHordeNavmeshIndex.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHordeNavmeshIndex.gridx = 1;
		gbc_textFieldHordeNavmeshIndex.gridy = 2;
		panelKillsHorde.add(textFieldHordeNavmeshIndex, gbc_textFieldHordeNavmeshIndex);
		
		panelKillsAnimal = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panelConditionType.add(panelKillsAnimal, "name_883795897524332");
		GridBagLayout gbl_panelKillsAnimal = new GridBagLayout();
		gbl_panelKillsAnimal.columnWidths = new int[]{46, 86, 0};
		gbl_panelKillsAnimal.rowHeights = new int[]{20, 0, 0, 0};
		gbl_panelKillsAnimal.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelKillsAnimal.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelKillsAnimal.setLayout(gbl_panelKillsAnimal);
		
		lblAnimalConditionID = new JLabel("Condition ID");
		GridBagConstraints gbc_lblAnimalConditionID = new GridBagConstraints();
		gbc_lblAnimalConditionID.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnimalConditionID.gridx = 0;
		gbc_lblAnimalConditionID.gridy = 0;
		panelKillsAnimal.add(lblAnimalConditionID, gbc_lblAnimalConditionID);
		
		textField = new JTextField();
		textField.setToolTipText("Short flag to track stat");
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panelKillsAnimal.add(textField, gbc_textField);
		
		lblAnimalID = new JLabel("Animal ID");
		GridBagConstraints gbc_lblAnimalID = new GridBagConstraints();
		gbc_lblAnimalID.anchor = GridBagConstraints.EAST;
		gbc_lblAnimalID.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnimalID.gridx = 0;
		gbc_lblAnimalID.gridy = 1;
		panelKillsAnimal.add(lblAnimalID, gbc_lblAnimalID);
		
		txtPanelconditiontypeaddpanelexperiencename = new JTextField();
		txtPanelconditiontypeaddpanelexperiencename.setToolTipText("ID of required animal");
		GridBagConstraints gbc_txtPanelconditiontypeaddpanelexperiencename = new GridBagConstraints();
		gbc_txtPanelconditiontypeaddpanelexperiencename.insets = new Insets(0, 0, 5, 0);
		gbc_txtPanelconditiontypeaddpanelexperiencename.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPanelconditiontypeaddpanelexperiencename.gridx = 1;
		gbc_txtPanelconditiontypeaddpanelexperiencename.gridy = 1;
		panelKillsAnimal.add(txtPanelconditiontypeaddpanelexperiencename, gbc_txtPanelconditiontypeaddpanelexperiencename);
		txtPanelconditiontypeaddpanelexperiencename.setColumns(10);
		
		lblTargetKills_1 = new JLabel("Target kills");
		GridBagConstraints gbc_lblTargetKills_1 = new GridBagConstraints();
		gbc_lblTargetKills_1.anchor = GridBagConstraints.EAST;
		gbc_lblTargetKills_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblTargetKills_1.gridx = 0;
		gbc_lblTargetKills_1.gridy = 2;
		panelKillsAnimal.add(lblTargetKills_1, gbc_lblTargetKills_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Required kills");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panelKillsAnimal.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		panelTimeOfDay = new JPanel();
		GridBagConstraints gbc_TimeOfDay = new GridBagConstraints();
		gbc_TimeOfDay.insets = new Insets(0, 0, 0, 5);
		gbc_TimeOfDay.fill = GridBagConstraints.BOTH;
		gbc_TimeOfDay.gridx = 0;
		gbc_TimeOfDay.gridy = 2;
		panelConditionType.add(panelTimeOfDay, "name_883795897512332");
		GridBagLayout gbl_panelTimeOfDay = new GridBagLayout();
		gbl_panelTimeOfDay.columnWidths = new int[]{53, 86, 0};
		gbl_panelTimeOfDay.rowHeights = new int[]{20, 0};
		gbl_panelTimeOfDay.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelTimeOfDay.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTimeOfDay.setLayout(gbl_panelTimeOfDay);
		
		lblSeconds = new JLabel("Seconds");
		GridBagConstraints gbc_lblSeconds = new GridBagConstraints();
		gbc_lblSeconds.insets = new Insets(0, 0, 0, 5);
		gbc_lblSeconds.gridx = 0;
		gbc_lblSeconds.gridy = 0;
		panelTimeOfDay.add(lblSeconds, gbc_lblSeconds);
		
		textFieldSeconds = new JTextField();
		textFieldSeconds.setToolTipText("Second of the 24 hour clock to compare against, where 43200 is noon and 86400 is the full day. It's formatted in military time 00:00:00. This will pass regardless of the current in-game day of the year");
		GridBagConstraints gbc_textFieldSeconds = new GridBagConstraints();
		gbc_textFieldSeconds.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSeconds.gridx = 1;
		gbc_textFieldSeconds.gridy = 0;
		panelTimeOfDay.add(textFieldSeconds, gbc_textFieldSeconds);
		textFieldSeconds.setColumns(10);
		
		panelCompareFlags = new JPanel();
		GridBagConstraints gbc_CompareFlags = new GridBagConstraints();
		gbc_CompareFlags.insets = new Insets(0, 0, 0, 5);
		gbc_CompareFlags.fill = GridBagConstraints.BOTH;
		gbc_CompareFlags.gridx = 0;
		gbc_CompareFlags.gridy = 2;
		panelConditionType.add(panelCompareFlags, "name_883795897512332");
		GridBagLayout gbl_panelCompareFlags = new GridBagLayout();
		gbl_panelCompareFlags.columnWidths = new int[]{46, 95, 95, 86, 0};
		gbl_panelCompareFlags.rowHeights = new int[]{20, 0, 0, 0};
		gbl_panelCompareFlags.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCompareFlags.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCompareFlags.setLayout(gbl_panelCompareFlags);
		
		lblNewLabel = new JLabel("Condition A");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelCompareFlags.add(lblNewLabel, gbc_lblNewLabel);
		
		lblConditionB = new JLabel("Condition B");
		lblConditionB.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblConditionB = new GridBagConstraints();
		gbc_lblConditionB.gridwidth = 2;
		gbc_lblConditionB.insets = new Insets(0, 0, 5, 0);
		gbc_lblConditionB.gridx = 2;
		gbc_lblConditionB.gridy = 0;
		panelCompareFlags.add(lblConditionB, gbc_lblConditionB);
		
		toggleButtonConditionAAllowUnset = new JToggleButton("False");
		toggleButtonConditionAAllowUnset.setToolTipText("Pass condition if the player doesn't have this flag yet");
		toggleButtonConditionAAllowUnset.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					toggleButtonConditionAAllowUnset.setText("True");
				else
					toggleButtonConditionAAllowUnset.setText("False");
			}
		});
		
		textFieldConditionAID = new JTextField();
		textFieldConditionAID.setText("Condition A ID");
		textFieldConditionAID.setForeground(Color.gray);
		textFieldConditionAID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textFieldConditionAID.getText().equalsIgnoreCase("Condition A ID"));
				{
					textFieldConditionAID.setText("");
					textFieldConditionAID.setForeground(Color.black);
				}
			}
			public void focusLost(FocusEvent arg0) {
				if(!(textFieldConditionAID.getText().length()>0))
				{
					textFieldConditionAID.setText("Condition A ID");
					textFieldConditionAID.setForeground(Color.gray);
				}
			}
		});
		textFieldConditionAID.setToolTipText("Condition A ID");
		GridBagConstraints gbc_textFieldConditionAID = new GridBagConstraints();
		gbc_textFieldConditionAID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldConditionAID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldConditionAID.gridx = 0;
		gbc_textFieldConditionAID.gridy = 1;
		panelCompareFlags.add(textFieldConditionAID, gbc_textFieldConditionAID);
		textFieldConditionAID.setColumns(10);
		
		comboBoxCompareLogicalOperator = new JComboBox();
		comboBoxCompareLogicalOperator.setModel(new DefaultComboBoxModel(new String[] {"A is Less_Than to B", "A is Less_Than_Or_Equal to B", "A is Equal to B", "A is Not_Equal to B", "A is Greater_Than_Or_Equal to B", "A is Greater_Than to B"}));
		GridBagConstraints gbc_combBoxCompareLogicalOperator = new GridBagConstraints();
		gbc_combBoxCompareLogicalOperator.fill = GridBagConstraints.HORIZONTAL;
		gbc_combBoxCompareLogicalOperator.gridwidth = 2;
		gbc_combBoxCompareLogicalOperator.insets = new Insets(0, 0, 5, 5);
		gbc_combBoxCompareLogicalOperator.gridx = 1;
		gbc_combBoxCompareLogicalOperator.gridy = 1;
		panelCompareFlags.add(comboBoxCompareLogicalOperator, gbc_combBoxCompareLogicalOperator);
		
		textFieldConditionBID = new JTextField();
		textFieldConditionBID.setText("Condition B ID");
		textFieldConditionBID.setForeground(Color.gray);
		textFieldConditionBID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(textFieldConditionBID.getText().equalsIgnoreCase("Condition B ID"));
				{
					textFieldConditionBID.setText("");
					textFieldConditionBID.setForeground(Color.black);
				}
			}
			public void focusLost(FocusEvent arg0) {
				if(!(textFieldConditionBID.getText().length()>0))
				{
					textFieldConditionBID.setText("Condition B ID");
					textFieldConditionBID.setForeground(Color.gray);
				}
			}
		});
		textFieldConditionBID.setToolTipText("Condition B ID");
		GridBagConstraints gbc_textFieldConditioBID = new GridBagConstraints();
		gbc_textFieldConditioBID.anchor = GridBagConstraints.NORTH;
		gbc_textFieldConditioBID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldConditioBID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldConditioBID.gridx = 3;
		gbc_textFieldConditioBID.gridy = 1;
		panelCompareFlags.add(textFieldConditionBID, gbc_textFieldConditioBID);
		textFieldConditionBID.setColumns(10);
		GridBagConstraints gbc_toggleButtonConditionAAllowUnset = new GridBagConstraints();
		gbc_toggleButtonConditionAAllowUnset.gridwidth = 2;
		gbc_toggleButtonConditionAAllowUnset.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButtonConditionAAllowUnset.insets = new Insets(0, 0, 0, 5);
		gbc_toggleButtonConditionAAllowUnset.gridx = 0;
		gbc_toggleButtonConditionAAllowUnset.gridy = 2;
		panelCompareFlags.add(toggleButtonConditionAAllowUnset, gbc_toggleButtonConditionAAllowUnset);
		
		toggleButtonConditionBAllowUnset = new JToggleButton("False");
		toggleButtonConditionBAllowUnset.setToolTipText("Pass condition if the player doesn't have this flag yet");
		toggleButtonConditionBAllowUnset.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					toggleButtonConditionBAllowUnset.setText("True");
				else
					toggleButtonConditionBAllowUnset.setText("False");
			}
		});
		GridBagConstraints gbc_toggleButtonConditionBAllowUnset = new GridBagConstraints();
		gbc_toggleButtonConditionBAllowUnset.gridwidth = 2;
		gbc_toggleButtonConditionBAllowUnset.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButtonConditionBAllowUnset.gridx = 2;
		gbc_toggleButtonConditionBAllowUnset.gridy = 2;
		panelCompareFlags.add(toggleButtonConditionBAllowUnset, gbc_toggleButtonConditionBAllowUnset);
		
	}
	
	protected Object[] ComboBoxIcon()
	{
		Object[] items = 
		{
			new ImageIcon(Conditions.class.getResource("/Icons/Skillsets/Civilian.png")),
			new ImageIcon(Conditions.class.getResource("/Icons/Skillsets/Chef.png")),
			new ImageIcon(Conditions.class.getResource("/Icons/Skillsets/Doctor.png")),
			new ImageIcon(Conditions.class.getResource("/Icons/Skillsets/Farmer.png")),
			new ImageIcon(Conditions.class.getResource("/Icons/Skillsets/Fire Fighter.png")),
			new ImageIcon(Conditions.class.getResource("/Icons/Skillsets/Fisher.png")),
			new ImageIcon(Conditions.class.getResource("/Icons/Skillsets/Lumberjack.png")),
			new ImageIcon(Conditions.class.getResource("/Icons/Skillsets/Spec Ops.png")),
			new ImageIcon(Conditions.class.getResource("/Icons/Skillsets/Thief.png")),
			new ImageIcon(Conditions.class.getResource("/Icons/Skillsets/Worker.png")),
			new ImageIcon(Conditions.class.getResource("/Icons/Skillsets/Police Officer.png"))
		};
		return items;
	}

	protected void showCondition(int selectedIndex) {
		for(Component comp : panelConditionType.getComponents())
			if(comp.isVisible())
				comp.setVisible(false);
		panelConditionType.getComponents()[selectedIndex].setVisible(true);
		panelConditionType.revalidate();
		panelConditionType.repaint();
	}
}
