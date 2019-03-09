package rewards;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

public class NewReward extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2361674634792299210L;
	//Panels
	private static JPanel panelExperience;
	private static JPanel panelReputation;
	private static JPanel panelFlagShort;
	private static JPanel panelFlagBool;	
	private static JPanel panelQuest;
	private static JPanel panelItem;
	private static JPanel panelFlagShortRandom;
	private static JPanel panelItemRandom;
	private static JPanel panelRewardType;
	private static JPanel panelVehicle;
	private static JPanel panelTeleport;
	private static JPanel panelFlagMath;
	//Textfield
	private JTextField textFieldExperience;
	private JTextField textFieldReputation;
	private JTextField textFieldShortFlagID;
	private JTextField textFieldBoolFlagID;
	private JTextField textFieldQuestID;
	private JTextField textFieldItemID;
	private JTextField textFieldItemAmount;
	private JTextField textFieldShortRandomMaxValue;
	private JTextField textFieldShortRandomMinValue;
	private JTextField textFieldItemRandomSpawnID;
	private JTextField textFieldItemRandomAmount;
	private JTextField textFieldVehicleID;
	private JTextField textFieldVehicleSpawnpointID;
	//Labels
	private JLabel lblExperience;
	private JLabel lblReputation;
	private JLabel lblShortConditionID;
	private JLabel lblShortFlagValue;
	private JLabel lblBoolConditionID;
	private JLabel lblSetBool;
	private JLabel lblQuestID;
	private JLabel lblShortRandomMaxValue;
	private JLabel lblShortRandomModification;
	private JLabel lblItemID;
	private JLabel lblItemAmount;
	private JLabel lblShortFlagID;
	private JLabel lblShortRandomMinValue;
	private JLabel lblItemSpawnID;
	private JLabel lblRandomItemAmount;
	private JLabel lblVehicleID;
	private JLabel lblVehicleSpawnpointID;
	private JToggleButton toggleButtonBoolFlagValue;
	private JComboBox<RewardType> comboBoxConditionType;
	//ButtonGroup
	private JTextField textFieldShortFlagValue;
	private JTextField textFieldFlagShortRandomID;
	private JComboBox<Modifications> comboBoxShortRandomModifications;
	private JLabel lblSpawnpointId;
	private JTextField textFieldSpawnpointID;
	private JLabel lblFlagA;
	private JLabel lblFlagB;
	private JTextField textFieldFlagAID;
	private JTextField textFieldFlagBID;
	private JComboBox<FlagMathModifications> comboBoxFlagMathModification;
	private JTextField textFieldTeleportSpawnpointID;
	private JComboBox<Modifications> comboBoxShortModifications;
	private JLabel lblShortFlagModification;
	private JTextPane txtpnAssignSetsThe;
	private JTextPane textPane;
	private JTextPane txtpnAssignSetsA;
	
	public NewReward(String rewards) {
		new JPanel();
		setVisible(true);
		setEnabled(true);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gbl_panel);
		
		JLabel lblRewardType = new JLabel("Reward Type");
		lblRewardType.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblRewardType = new GridBagConstraints();
		gbc_lblRewardType.fill = GridBagConstraints.VERTICAL;
		gbc_lblRewardType.insets = new Insets(0, 0, 5, 5);
		gbc_lblRewardType.gridx = 0;
		gbc_lblRewardType.gridy = 0;
		add(lblRewardType, gbc_lblRewardType);
		
		comboBoxConditionType = new JComboBox<RewardType>();
		comboBoxConditionType.setMaximumRowCount(11);
		comboBoxConditionType.setModel(new DefaultComboBoxModel<RewardType>(RewardType.values()));
		comboBoxConditionType.setSelectedIndex(0);
		comboBoxConditionType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			((Window) getParent().getParent().getParent().getParent().getParent().getParent()).toFront();
			}
		});
		comboBoxConditionType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==ItemEvent.SELECTED&&panelRewardType!=null)
					if(panelRewardType.getComponents().length>=1)
						showRewardType(panelRewardType.getComponents(), comboBoxConditionType.getSelectedItem());
			}
		});
		GridBagConstraints gbc_comboBoxConditionType = new GridBagConstraints();
		gbc_comboBoxConditionType.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxConditionType.fill = GridBagConstraints.BOTH;
		gbc_comboBoxConditionType.gridx = 1;
		gbc_comboBoxConditionType.gridy = 0;
		add(comboBoxConditionType, gbc_comboBoxConditionType);
		
		panelRewardType = new JPanel();
		GridBagConstraints gbc_panelRewardType = new GridBagConstraints();
		gbc_panelRewardType.gridwidth = 2;
		gbc_panelRewardType.fill = GridBagConstraints.BOTH;
		gbc_panelRewardType.gridx = 0;
		gbc_panelRewardType.gridy = 1;
		add(panelRewardType, gbc_panelRewardType);
		panelRewardType.setLayout(new CardLayout(0, 0));
		
		panelExperience = new JPanel();
		panelRewardType.add(panelExperience, "name_88379589756902");
		GridBagLayout gbl_panelExperience = new GridBagLayout();
		gbl_panelExperience.columnWidths = new int[]{46, 86, 0};
		gbl_panelExperience.rowHeights = new int[]{20, 0};
		gbl_panelExperience.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelExperience.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelExperience.setLayout(gbl_panelExperience);
		
		lblExperience = new JLabel("Experience");
		GridBagConstraints gbc_lblExperience = new GridBagConstraints();
		gbc_lblExperience.insets = new Insets(0, 0, 0, 5);
		gbc_lblExperience.gridx = 0;
		gbc_lblExperience.gridy = 0;
		panelExperience.add(lblExperience, gbc_lblExperience);
		
		textFieldExperience = new JTextField();
		textFieldExperience.setToolTipText("Experience the player will get.");
		GridBagConstraints gbc_textFieldExperience = new GridBagConstraints();
		gbc_textFieldExperience.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldExperience.anchor = GridBagConstraints.NORTH;
		gbc_textFieldExperience.gridx = 1;
		gbc_textFieldExperience.gridy = 0;
		panelExperience.add(textFieldExperience, gbc_textFieldExperience);
		textFieldExperience.setColumns(10);
		
		panelReputation = new JPanel();
		panelRewardType.add(panelReputation, "name_88379605110798");
		GridBagLayout gbl_panelReputation = new GridBagLayout();
		gbl_panelReputation.columnWidths = new int[]{46, 0, 0};
		gbl_panelReputation.rowHeights = new int[]{14, 0};
		gbl_panelReputation.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelReputation.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelReputation.setLayout(gbl_panelReputation);
		
		lblReputation = new JLabel("Reputation");
		GridBagConstraints gbc_lblReputation = new GridBagConstraints();
		gbc_lblReputation.insets = new Insets(0, 0, 0, 5);
		gbc_lblReputation.gridx = 0;
		gbc_lblReputation.gridy = 0;
		panelReputation.add(lblReputation, gbc_lblReputation);
		
		textFieldReputation = new JTextField();
		textFieldReputation.setToolTipText("Reputation the player will get.");
		GridBagConstraints gbc_textFieldReputation = new GridBagConstraints();
		gbc_textFieldReputation.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldReputation.gridx = 1;
		gbc_textFieldReputation.gridy = 0;
		panelReputation.add(textFieldReputation, gbc_textFieldReputation);
		textFieldReputation.setColumns(10);
		
		panelFlagBool = new JPanel();
		panelRewardType.add(panelFlagBool, "name_88379619698912");
		GridBagLayout gbl_panelFlagBool = new GridBagLayout();
		gbl_panelFlagBool.columnWidths = new int[]{86, 0, 0};
		gbl_panelFlagBool.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelFlagBool.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelFlagBool.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelFlagBool.setLayout(gbl_panelFlagBool);
		
		lblBoolConditionID = new JLabel("Flag ID");
		lblBoolConditionID.setToolTipText("");
		GridBagConstraints gbc_lblBoolConditionID = new GridBagConstraints();
		gbc_lblBoolConditionID.insets = new Insets(0, 0, 5, 5);
		gbc_lblBoolConditionID.gridx = 0;
		gbc_lblBoolConditionID.gridy = 0;
		panelFlagBool.add(lblBoolConditionID, gbc_lblBoolConditionID);
		
		textFieldBoolFlagID = new JTextField();
		textFieldBoolFlagID.setToolTipText("Similar to normal IDs, flag ID on the player to change");
		GridBagConstraints gbc_textFieldBoolConditionID = new GridBagConstraints();
		gbc_textFieldBoolConditionID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBoolConditionID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBoolConditionID.gridx = 1;
		gbc_textFieldBoolConditionID.gridy = 0;
		panelFlagBool.add(textFieldBoolFlagID, gbc_textFieldBoolConditionID);
		textFieldBoolFlagID.setColumns(10);
		
		lblSetBool = new JLabel("Set bool value");
		GridBagConstraints gbc_lblSetBool = new GridBagConstraints();
		gbc_lblSetBool.insets = new Insets(0, 0, 5, 5);
		gbc_lblSetBool.gridx = 0;
		gbc_lblSetBool.gridy = 1;
		panelFlagBool.add(lblSetBool, gbc_lblSetBool);
		
		toggleButtonBoolFlagValue = new JToggleButton("False");
		toggleButtonBoolFlagValue.setToolTipText("Value the flag will be set to, \"True\" or \"False\"");
		toggleButtonBoolFlagValue.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					toggleButtonBoolFlagValue.setText("True");
				else
					toggleButtonBoolFlagValue.setText("False");
			}
		});
		GridBagConstraints gbc_toggleButtonBoolConditionValue = new GridBagConstraints();
		gbc_toggleButtonBoolConditionValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_toggleButtonBoolConditionValue.insets = new Insets(0, 0, 5, 0);
		gbc_toggleButtonBoolConditionValue.gridx = 1;
		gbc_toggleButtonBoolConditionValue.gridy = 1;
		panelFlagBool.add(toggleButtonBoolFlagValue, gbc_toggleButtonBoolConditionValue);
		
		panelFlagShort = new JPanel();
		panelRewardType.add(panelFlagShort, "name_88379634158471");
		GridBagLayout gbl_panelFlagShort = new GridBagLayout();
		gbl_panelFlagShort.columnWidths = new int[]{69, 357, 0};
		gbl_panelFlagShort.rowHeights = new int[]{20, 20, 20, 0, 0};
		gbl_panelFlagShort.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelFlagShort.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelFlagShort.setLayout(gbl_panelFlagShort);
		
		lblShortConditionID = new JLabel("Flag ID");
		lblShortConditionID.setToolTipText("");
		GridBagConstraints gbc_lblShortConditionID = new GridBagConstraints();
		gbc_lblShortConditionID.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortConditionID.gridx = 0;
		gbc_lblShortConditionID.gridy = 0;
		panelFlagShort.add(lblShortConditionID, gbc_lblShortConditionID);
		
		textFieldShortFlagID = new JTextField();
		textFieldShortFlagID.setToolTipText("Similar to normal IDs, flag ID on the player to target.");
		textFieldShortFlagID.setColumns(10);
		GridBagConstraints gbc_textFieldShortFlagID = new GridBagConstraints();
		gbc_textFieldShortFlagID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldShortFlagID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldShortFlagID.gridx = 1;
		gbc_textFieldShortFlagID.gridy = 0;
		panelFlagShort.add(textFieldShortFlagID, gbc_textFieldShortFlagID);
		
		lblShortFlagValue = new JLabel("Flag value");
		GridBagConstraints gbc_lblShortFlagValue = new GridBagConstraints();
		gbc_lblShortFlagValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortFlagValue.gridx = 0;
		gbc_lblShortFlagValue.gridy = 1;
		panelFlagShort.add(lblShortFlagValue, gbc_lblShortFlagValue);
		
		textFieldShortFlagValue = new JTextField();
		textFieldShortFlagValue.setToolTipText("Value to set the flag to, 16 bit integer meaning the range [-32768, 32767].");
		textFieldShortFlagValue.setColumns(10);
		GridBagConstraints gbc_textFieldShortConditionValue = new GridBagConstraints();
		gbc_textFieldShortConditionValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldShortConditionValue.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldShortConditionValue.gridx = 1;
		gbc_textFieldShortConditionValue.gridy = 1;
		panelFlagShort.add(textFieldShortFlagValue, gbc_textFieldShortConditionValue);
		
		panelFlagShortRandom = new JPanel();
		panelRewardType.add(panelFlagShortRandom, "name_88379716777992");
		GridBagLayout gbl_panelFlagShortRandom = new GridBagLayout();
		gbl_panelFlagShortRandom.columnWidths = new int[]{0, 0, 0};
		gbl_panelFlagShortRandom.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelFlagShortRandom.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelFlagShortRandom.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelFlagShortRandom.setLayout(gbl_panelFlagShortRandom);
		
		lblShortFlagID = new JLabel("Flag ID");
		GridBagConstraints gbc_lblShortFlagID = new GridBagConstraints();
		gbc_lblShortFlagID.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortFlagID.gridx = 0;
		gbc_lblShortFlagID.gridy = 0;
		panelFlagShortRandom.add(lblShortFlagID, gbc_lblShortFlagID);
		
		lblShortFlagModification = new JLabel("Modification");
		GridBagConstraints gbc_lblShortFlagModification = new GridBagConstraints();
		gbc_lblShortFlagModification.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortFlagModification.gridx = 0;
		gbc_lblShortFlagModification.gridy = 2;
		panelFlagShort.add(lblShortFlagModification, gbc_lblShortFlagModification);
		
		comboBoxShortModifications = new JComboBox<Modifications>();
		comboBoxShortModifications.setMaximumRowCount(3);
		comboBoxShortModifications.setModel(new DefaultComboBoxModel<Modifications>(Modifications.values()));
		GridBagConstraints gbc_comboBoxShortModifications = new GridBagConstraints();
		gbc_comboBoxShortModifications.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxShortModifications.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxShortModifications.gridx = 1;
		gbc_comboBoxShortModifications.gridy = 2;
		panelFlagShort.add(comboBoxShortModifications, gbc_comboBoxShortModifications);
		
		txtpnAssignSetsThe = new JTextPane();
		txtpnAssignSetsThe.setBackground((Color) null);
		txtpnAssignSetsThe.setText("Assign sets the flag to the flag value\r\nIncrement adds the flag value to the flag\r\nDecrement subtracts the flag value from the flag");
		txtpnAssignSetsThe.setEditable(false);
		GridBagConstraints gbc_txtpnAssignSetsThe = new GridBagConstraints();
		gbc_txtpnAssignSetsThe.gridwidth = 2;
		gbc_txtpnAssignSetsThe.insets = new Insets(0, 0, 0, 5);
		gbc_txtpnAssignSetsThe.fill = GridBagConstraints.VERTICAL;
		gbc_txtpnAssignSetsThe.gridx = 0;
		gbc_txtpnAssignSetsThe.gridy = 3;
		panelFlagShort.add(txtpnAssignSetsThe, gbc_txtpnAssignSetsThe);
		
		textFieldFlagShortRandomID = new JTextField();
		textFieldFlagShortRandomID.setToolTipText("Similar to normal IDs, flag ID on the player to target.");
		textFieldFlagShortRandomID.setColumns(10);
		GridBagConstraints gbc_textFieldFlagShortRandomID = new GridBagConstraints();
		gbc_textFieldFlagShortRandomID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFlagShortRandomID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFlagShortRandomID.gridx = 1;
		gbc_textFieldFlagShortRandomID.gridy = 0;
		panelFlagShortRandom.add(textFieldFlagShortRandomID, gbc_textFieldFlagShortRandomID);
		
		lblShortRandomMinValue = new JLabel("Min value");
		GridBagConstraints gbc_lblShortRandomMinValue = new GridBagConstraints();
		gbc_lblShortRandomMinValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortRandomMinValue.gridx = 0;
		gbc_lblShortRandomMinValue.gridy = 1;
		panelFlagShortRandom.add(lblShortRandomMinValue, gbc_lblShortRandomMinValue);
		
		textFieldShortRandomMinValue = new JTextField();
		textFieldShortRandomMinValue.setToolTipText("Min inclusive value for the flag, 16 bit integer meaning the range [-32768, 32767].");
		GridBagConstraints gbc_textFieldShortRandomMinValue = new GridBagConstraints();
		gbc_textFieldShortRandomMinValue.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldShortRandomMinValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldShortRandomMinValue.gridx = 1;
		gbc_textFieldShortRandomMinValue.gridy = 1;
		panelFlagShortRandom.add(textFieldShortRandomMinValue, gbc_textFieldShortRandomMinValue);
		textFieldShortRandomMinValue.setColumns(10);
		
		lblShortRandomMaxValue = new JLabel("Max value");
		GridBagConstraints gbc_lblShortRandomMaxValue = new GridBagConstraints();
		gbc_lblShortRandomMaxValue.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortRandomMaxValue.gridx = 0;
		gbc_lblShortRandomMaxValue.gridy = 2;
		panelFlagShortRandom.add(lblShortRandomMaxValue, gbc_lblShortRandomMaxValue);
		
		textFieldShortRandomMaxValue = new JTextField();
		textFieldShortRandomMaxValue.setToolTipText("Max inclusive value for the flag, 16 bit integer meaning the range [-32768, 32767].");
		GridBagConstraints gbc_textFieldShortRandomMaxValue = new GridBagConstraints();
		gbc_textFieldShortRandomMaxValue.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldShortRandomMaxValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldShortRandomMaxValue.gridx = 1;
		gbc_textFieldShortRandomMaxValue.gridy = 2;
		panelFlagShortRandom.add(textFieldShortRandomMaxValue, gbc_textFieldShortRandomMaxValue);
		textFieldShortRandomMaxValue.setColumns(10);
		
		lblShortRandomModification = new JLabel("Modification");
		GridBagConstraints gbc_lblShortRandomModification = new GridBagConstraints();
		gbc_lblShortRandomModification.anchor = GridBagConstraints.EAST;
		gbc_lblShortRandomModification.insets = new Insets(0, 0, 5, 5);
		gbc_lblShortRandomModification.gridx = 0;
		gbc_lblShortRandomModification.gridy = 3;
		panelFlagShortRandom.add(lblShortRandomModification, gbc_lblShortRandomModification);
		
		comboBoxShortRandomModifications = new JComboBox<Modifications>();
		comboBoxShortRandomModifications.setMaximumRowCount(3);
		comboBoxShortRandomModifications.setModel(new DefaultComboBoxModel<Modifications>(Modifications.values()));
		GridBagConstraints gbc_comboBoxRandomModifications = new GridBagConstraints();
		gbc_comboBoxRandomModifications.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxRandomModifications.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxRandomModifications.gridx = 1;
		gbc_comboBoxRandomModifications.gridy = 3;
		panelFlagShortRandom.add(comboBoxShortRandomModifications, gbc_comboBoxRandomModifications);
		
		textPane = new JTextPane();
		textPane.setText("Assign sets the flag to the flag value\r\nIncrement adds the flag value to the flag\r\nDecrement subtracts the flag value from the flag");
		textPane.setEditable(false);
		textPane.setBackground((Color) null);
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridwidth = 2;
		gbc_textPane.fill = GridBagConstraints.VERTICAL;
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 4;
		panelFlagShortRandom.add(textPane, gbc_textPane);

		
		panelQuest = new JPanel();
		panelRewardType.add(panelQuest, "name_88379648449025");
		GridBagLayout gbl_panelQuest = new GridBagLayout();
		gbl_panelQuest.columnWidths = new int[]{63, 0, 0};
		gbl_panelQuest.rowHeights = new int[]{0, 0};
		gbl_panelQuest.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelQuest.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelQuest.setLayout(gbl_panelQuest);
		
		lblQuestID = new JLabel("Quest ID");
		GridBagConstraints gbc_lblQuestID = new GridBagConstraints();
		gbc_lblQuestID.insets = new Insets(0, 0, 0, 5);
		gbc_lblQuestID.gridx = 0;
		gbc_lblQuestID.gridy = 0;
		panelQuest.add(lblQuestID, gbc_lblQuestID);
		
		textFieldQuestID = new JTextField();
		textFieldQuestID.setToolTipText("Quest ID to give the player.");
		GridBagConstraints gbc_textFieldQuestID = new GridBagConstraints();
		gbc_textFieldQuestID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldQuestID.gridx = 1;
		gbc_textFieldQuestID.gridy = 0;
		panelQuest.add(textFieldQuestID, gbc_textFieldQuestID);
		textFieldQuestID.setColumns(10);
		
		panelItem = new JPanel();
		panelRewardType.add(panelItem, "name_88379701526329");
		GridBagLayout gbl_panelItem = new GridBagLayout();
		gbl_panelItem.columnWidths = new int[]{74, 0, 0};
		gbl_panelItem.rowHeights = new int[]{0, 0, 0};
		gbl_panelItem.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelItem.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelItem.setLayout(gbl_panelItem);
		
		lblItemID = new JLabel("Item ID");
		GridBagConstraints gbc_lblItemID = new GridBagConstraints();
		gbc_lblItemID.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemID.gridx = 0;
		gbc_lblItemID.gridy = 0;
		panelItem.add(lblItemID, gbc_lblItemID);
		
		textFieldItemID = new JTextField();
		textFieldItemID.setToolTipText("Item ID to give the player.");
		GridBagConstraints gbc_textFieldItemID = new GridBagConstraints();
		gbc_textFieldItemID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldItemID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldItemID.gridx = 1;
		gbc_textFieldItemID.gridy = 0;
		panelItem.add(textFieldItemID, gbc_textFieldItemID);
		textFieldItemID.setColumns(10);
		
		lblItemAmount = new JLabel("Item Amount");
		GridBagConstraints gbc_lblItemAmount = new GridBagConstraints();
		gbc_lblItemAmount.insets = new Insets(0, 0, 0, 5);
		gbc_lblItemAmount.gridx = 0;
		gbc_lblItemAmount.gridy = 1;
		panelItem.add(lblItemAmount, gbc_lblItemAmount);
		
		textFieldItemAmount = new JTextField();
		textFieldItemAmount.setToolTipText("Number of the item to give.");
		textFieldItemAmount.setColumns(10);
		GridBagConstraints gbc_textFieldItemAmount = new GridBagConstraints();
		gbc_textFieldItemAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldItemAmount.gridx = 1;
		gbc_textFieldItemAmount.gridy = 1;
		panelItem.add(textFieldItemAmount, gbc_textFieldItemAmount);
		
		panelItemRandom = new JPanel();
		panelRewardType.add(panelItemRandom, "name_88379731191560");
		GridBagLayout gbl_panelItemRandom = new GridBagLayout();
		gbl_panelItemRandom.columnWidths = new int[]{69, 0, 0};
		gbl_panelItemRandom.rowHeights = new int[]{0, 0, 0};
		gbl_panelItemRandom.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelItemRandom.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelItemRandom.setLayout(gbl_panelItemRandom);
		
		lblItemSpawnID = new JLabel("Spawn ID");
		GridBagConstraints gbc_lblItemSpawnID = new GridBagConstraints();
		gbc_lblItemSpawnID.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemSpawnID.gridx = 0;
		gbc_lblItemSpawnID.gridy = 0;
		panelItemRandom.add(lblItemSpawnID, gbc_lblItemSpawnID);
		
		textFieldItemRandomSpawnID = new JTextField();
		textFieldItemRandomSpawnID.setToolTipText("Spawn ID to pick an item from.");
		GridBagConstraints gbc_textFieldItemRandomSpawnID = new GridBagConstraints();
		gbc_textFieldItemRandomSpawnID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldItemRandomSpawnID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldItemRandomSpawnID.gridx = 1;
		gbc_textFieldItemRandomSpawnID.gridy = 0;
		panelItemRandom.add(textFieldItemRandomSpawnID, gbc_textFieldItemRandomSpawnID);
		textFieldItemRandomSpawnID.setColumns(10);
		
		lblRandomItemAmount = new JLabel("Amount");
		GridBagConstraints gbc_lblRandomItemAmount = new GridBagConstraints();
		gbc_lblRandomItemAmount.insets = new Insets(0, 0, 0, 5);
		gbc_lblRandomItemAmount.gridx = 0;
		gbc_lblRandomItemAmount.gridy = 1;
		panelItemRandom.add(lblRandomItemAmount, gbc_lblRandomItemAmount);
		
		textFieldItemRandomAmount = new JTextField();
		textFieldItemRandomAmount.setToolTipText("Number of the randomly selected item.");
		textFieldItemRandomAmount.setColumns(10);
		GridBagConstraints gbc_textFieldItemRandomAmount = new GridBagConstraints();
		gbc_textFieldItemRandomAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldItemRandomAmount.gridx = 1;
		gbc_textFieldItemRandomAmount.gridy = 1;
		panelItemRandom.add(textFieldItemRandomAmount, gbc_textFieldItemRandomAmount);
		
		panelVehicle = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panelRewardType.add(panelVehicle, "name_883795897524332");
		GridBagLayout gbl_panelVehicle = new GridBagLayout();
		gbl_panelVehicle.columnWidths = new int[]{85, 86, 0};
		gbl_panelVehicle.rowHeights = new int[]{20, 0, 0};
		gbl_panelVehicle.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelVehicle.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelVehicle.setLayout(gbl_panelVehicle);
		
		lblVehicleID = new JLabel("Vehicle ID");
		GridBagConstraints gbc_lblVehicleID = new GridBagConstraints();
		gbc_lblVehicleID.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehicleID.gridx = 0;
		gbc_lblVehicleID.gridy = 0;
		panelVehicle.add(lblVehicleID, gbc_lblVehicleID);
		
		textFieldVehicleID = new JTextField();
		textFieldVehicleID.setToolTipText("Vehicle ID to give.");
		textFieldVehicleID.setColumns(10);
		GridBagConstraints gbc_textFieldVehicleID = new GridBagConstraints();
		gbc_textFieldVehicleID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldVehicleID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVehicleID.anchor = GridBagConstraints.NORTH;
		gbc_textFieldVehicleID.gridx = 1;
		gbc_textFieldVehicleID.gridy = 0;
		panelVehicle.add(textFieldVehicleID, gbc_textFieldVehicleID);
		
		lblVehicleSpawnpointID = new JLabel("Spawnpoint ID");
		GridBagConstraints gbc_lblVehicleSpawnpointID = new GridBagConstraints();
		gbc_lblVehicleSpawnpointID.insets = new Insets(0, 0, 0, 5);
		gbc_lblVehicleSpawnpointID.gridx = 0;
		gbc_lblVehicleSpawnpointID.gridy = 1;
		panelVehicle.add(lblVehicleSpawnpointID, gbc_lblVehicleSpawnpointID);
		
		textFieldVehicleSpawnpointID = new JTextField();
		textFieldVehicleSpawnpointID.setToolTipText("ID of the spawnpoint (set in the inspector) in the level to spawn at.");
		GridBagConstraints gbc_textFieldVehicleSpawnpointID = new GridBagConstraints();
		gbc_textFieldVehicleSpawnpointID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVehicleSpawnpointID.gridx = 1;
		gbc_textFieldVehicleSpawnpointID.gridy = 1;
		panelVehicle.add(textFieldVehicleSpawnpointID, gbc_textFieldVehicleSpawnpointID);
		textFieldVehicleSpawnpointID.setColumns(10);
		
		panelTeleport = new JPanel();
		GridBagConstraints gbc_panelTeleport = new GridBagConstraints();
		gbc_panelTeleport.insets = new Insets(0, 0, 0, 5);
		gbc_panelTeleport.fill = GridBagConstraints.BOTH;
		gbc_panelTeleport.gridx = 0;
		gbc_panelTeleport.gridy = 2;
		panelRewardType.add(panelTeleport, "name_883798477524332");
		GridBagLayout gbl_panelTeleport = new GridBagLayout();
		gbl_panelTeleport.columnWidths = new int[]{89, 0, 0};
		gbl_panelTeleport.rowHeights = new int[]{0, 0};
		gbl_panelTeleport.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelTeleport.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTeleport.setLayout(gbl_panelTeleport);
		
		lblSpawnpointId = new JLabel("Spawnpoint ID");
		GridBagConstraints gbc_lblSpawnpointId = new GridBagConstraints();
		gbc_lblSpawnpointId.insets = new Insets(0, 0, 0, 5);
		gbc_lblSpawnpointId.anchor = GridBagConstraints.EAST;
		gbc_lblSpawnpointId.gridx = 0;
		gbc_lblSpawnpointId.gridy = 0;
		panelTeleport.add(lblSpawnpointId, gbc_lblSpawnpointId);
		
		textFieldTeleportSpawnpointID = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panelTeleport.add(textFieldTeleportSpawnpointID, gbc_textField);
		
		textFieldSpawnpointID = new JTextField();
		textFieldSpawnpointID.setToolTipText("ID of the spawnpoint (set in the inspector) in the level to spawn at.");
		GridBagConstraints gbc_textFieldSpawnpointID = new GridBagConstraints();
		gbc_textFieldSpawnpointID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSpawnpointID.gridx = 1;
		gbc_textFieldSpawnpointID.gridy = 0;
		panelTeleport.add(textFieldSpawnpointID, gbc_textFieldSpawnpointID);
		textFieldSpawnpointID.setColumns(10);
		textFieldTeleportSpawnpointID.setColumns(10);

		panelFlagMath = new JPanel();
		GridBagConstraints gbc_panelFlagMath = new GridBagConstraints();
		gbc_panelFlagMath.insets = new Insets(0, 0, 0, 5);
		gbc_panelFlagMath.fill = GridBagConstraints.BOTH;
		gbc_panelFlagMath.gridx = 0;
		gbc_panelFlagMath.gridy = 2;
		panelRewardType.add(panelFlagMath, "name_894858477524332");
		GridBagLayout gbl_panelFlagMath = new GridBagLayout();
		gbl_panelFlagMath.columnWidths = new int[]{0, 0, 0};
		gbl_panelFlagMath.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelFlagMath.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelFlagMath.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelFlagMath.setLayout(gbl_panelFlagMath);
		
		lblFlagA = new JLabel("Flag A");
		lblFlagA.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFlagA = new GridBagConstraints();
		gbc_lblFlagA.insets = new Insets(0, 0, 5, 5);
		gbc_lblFlagA.gridx = 0;
		gbc_lblFlagA.gridy = 0;
		panelFlagMath.add(lblFlagA, gbc_lblFlagA);
		
		lblFlagB = new JLabel("Flag B");
		lblFlagB.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblFlagB = new GridBagConstraints();
		gbc_lblFlagB.insets = new Insets(0, 0, 5, 0);
		gbc_lblFlagB.gridx = 1;
		gbc_lblFlagB.gridy = 0;
		panelFlagMath.add(lblFlagB, gbc_lblFlagB);
		
		textFieldFlagAID = new JTextField();
		textFieldFlagAID.setToolTipText("Flag to apply the math to.");
		GridBagConstraints gbc_textFieldFlagAID = new GridBagConstraints();
		gbc_textFieldFlagAID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFlagAID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFlagAID.gridx = 0;
		gbc_textFieldFlagAID.gridy = 1;
		panelFlagMath.add(textFieldFlagAID, gbc_textFieldFlagAID);
		textFieldFlagAID.setColumns(10);
		
		textFieldFlagBID = new JTextField();
		textFieldFlagBID.setToolTipText("Flag containing the math value to use.");
		GridBagConstraints gbc_textFieldFlagBID = new GridBagConstraints();
		gbc_textFieldFlagBID.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldFlagBID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFlagBID.gridx = 1;
		gbc_textFieldFlagBID.gridy = 1;
		panelFlagMath.add(textFieldFlagBID, gbc_textFieldFlagBID);
		textFieldFlagBID.setColumns(10);
		
		comboBoxFlagMathModification = new JComboBox<FlagMathModifications>();
		comboBoxFlagMathModification.setMaximumRowCount(5);
		comboBoxFlagMathModification.setModel(new DefaultComboBoxModel<FlagMathModifications>(FlagMathModifications.values()));
		GridBagConstraints gbc_comboBoxFlagMathModification = new GridBagConstraints();
		gbc_comboBoxFlagMathModification.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxFlagMathModification.gridwidth = 2;
		gbc_comboBoxFlagMathModification.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxFlagMathModification.gridx = 0;
		gbc_comboBoxFlagMathModification.gridy = 2;
		panelFlagMath.add(comboBoxFlagMathModification, gbc_comboBoxFlagMathModification);
		
		txtpnAssignSetsA = new JTextPane();
		txtpnAssignSetsA.setText("Assign sets A to [B]\r\nAddition sets A to [A + B]\r\nSubtraction sets A to [A - B]\r\nMultiplication sets A to [A * B]\r\nDivision sets A to [A / B]");
		txtpnAssignSetsA.setBackground((Color) null);
		GridBagConstraints gbc_txtpnAssignSetsA = new GridBagConstraints();
		gbc_txtpnAssignSetsA.gridwidth = 2;
		gbc_txtpnAssignSetsA.insets = new Insets(0, 0, 0, 5);
		gbc_txtpnAssignSetsA.fill = GridBagConstraints.VERTICAL;
		gbc_txtpnAssignSetsA.gridx = 0;
		gbc_txtpnAssignSetsA.gridy = 3;
		panelFlagMath.add(txtpnAssignSetsA, gbc_txtpnAssignSetsA);
		
		if(rewards!=null)
			FillFields(rewards);
		
	}
	
	private void showRewardType(Component[] components, Object selectedPanel) {
		for(Component panel : components) {
			panel.setVisible(false);
		}
		panelRewardType.getComponent(((RewardType) selectedPanel).rewardType()).setVisible(true);;
	}
	
	private void FillFields(String reward) {
		
		//Controller Values
		String[] rewardLines = reward.split("\n");
		String type = null;
		
		//Find the reward type
		for(String stringType : rewardLines) {
			if(stringType.toLowerCase().contains("type")) {
				type = stringType.split(" ")[1];
				break;
			}
		}
		//Fill the fields
			if (type.toLowerCase().contains("experience")) {
				for(String string : rewardLines) {
					if(string.toLowerCase().contains("value")) {
						textFieldExperience.setText(string.split(" ")[1]);
					}
				}
			}
			if (type.toLowerCase().contains("reputation")) {
				for(String string : rewardLines) {
					if(string.toLowerCase().contains("value")) {
						textFieldReputation.setText(string.split(" ")[1]);
					}
				}
			}
			if (type.toLowerCase().contains("flag_bool")) {
				for(String string : rewardLines) {
					if(string.toLowerCase().contains("id")) {
						textFieldBoolFlagID.setText(string.split(" ")[1]);
					}
					if(string.toLowerCase().contains("value")) {
						if(string.toLowerCase().contains("true"))
							toggleButtonBoolFlagValue.setSelected(true);
						if(string.toLowerCase().contains("false"))
							toggleButtonBoolFlagValue.setSelected(false);
					}
				}
			}
			if (type.toLowerCase().contains("flag_short") && !type.toLowerCase().contains("flag_short_random")) {
				for(String string : rewardLines) {
					if(string.toLowerCase().contains("id")) {
						textFieldShortFlagID.setText(string.split(" ")[1]);
					}
					if(string.toLowerCase().contains("value")) {
						textFieldShortFlagValue.setText(string.split(" ")[1]);
					}
					if(string.toLowerCase().contains("modification")) {
						if(string.toLowerCase().contains("assign"))
							comboBoxShortModifications.setSelectedIndex(0);
						if(string.toLowerCase().contains("increment"))
							comboBoxShortModifications.setSelectedIndex(1);
						if(string.toLowerCase().contains("decrement"))
							comboBoxShortModifications.setSelectedIndex(2);
					}
				}
			}
			if (type.toLowerCase().contains("flag_short_random")) {
				for(String string : rewardLines) {
					if(string.toLowerCase().contains("id")) {
						textFieldFlagShortRandomID.setText(string.split(" ")[1]);
					}
					if(string.toLowerCase().contains("min")) {
						textFieldShortRandomMinValue.setText(string.split(" ")[1]);
					}
					if(string.toLowerCase().contains("max")) {
						textFieldShortRandomMaxValue.setText(string.split(" ")[1]);
					}
					if(string.toLowerCase().contains("modification")) {
						if(string.toLowerCase().contains("assign"))
							comboBoxShortRandomModifications.setSelectedIndex(0);
						if(string.toLowerCase().contains("increment"))
							comboBoxShortRandomModifications.setSelectedIndex(1);
						if(string.toLowerCase().contains("decrement"))
							comboBoxShortRandomModifications.setSelectedIndex(2);
					}
				}
			}
			if (type.toLowerCase().contains("quest")) {
				for(String string : rewardLines) {
					if(string.toLowerCase().contains("id")) {
						textFieldQuestID.setText(string.split(" ")[1]);
					}
				}
			}
			if (type.toLowerCase().contains("item") && !type.toLowerCase().contains("item_random")) {
				for(String string : rewardLines) {
					if(string.toLowerCase().contains("id")) {
						textFieldItemID.setText(string.split(" ")[1]);
					}
					if(string.toLowerCase().contains("amount")) {
						textFieldItemAmount.setText(string.split(" ")[1]);
					}
				}
			}
			if (type.toLowerCase().contains("item_random")) {
				for(String string : rewardLines) {
					if(string.toLowerCase().contains("id")) {
						textFieldItemRandomSpawnID.setText(string.split(" ")[1]);
					}
					if(string.toLowerCase().contains("amount")) {
						textFieldItemRandomAmount.setText(string.split(" ")[1]);
					}
				}
			}
			if (type.toLowerCase().contains("vehicle")) {
				for(String string : rewardLines) {
					if(string.toLowerCase().contains("id")) {
						textFieldVehicleID.setText(string.split(" ")[1]);
					}
					if(string.toLowerCase().contains("spawnpoint")) {
						textFieldVehicleSpawnpointID.setText(string.split(" ")[1]);
					}
				}
			}
			if (type.toLowerCase().contains("teleport")) {
				for(String string : rewardLines) {
					if(string.toLowerCase().contains("spawnpoint")) {
						textFieldTeleportSpawnpointID.setText(string.split(" ")[1]);
					}
				}
			}
			if (type.toLowerCase().contains("flag_math")) {
				for(String string : rewardLines) {
					if(string.toLowerCase().contains("a_id")) {
						textFieldFlagAID.setText(string.split(" ")[1]);
					}
					if(string.toLowerCase().contains("b_id")) {
						textFieldFlagBID.setText(string.split(" ")[1]);
					}
					if(string.toLowerCase().contains("operation")) {
						if(string.toLowerCase().contains("assign"))
							comboBoxFlagMathModification.setSelectedIndex(0);
						if(string.toLowerCase().contains("addition"))
							comboBoxFlagMathModification.setSelectedIndex(1);
						if(string.toLowerCase().contains("subtraction"))
							comboBoxFlagMathModification.setSelectedIndex(2);
						if(string.toLowerCase().contains("multiplication"))
							comboBoxFlagMathModification.setSelectedIndex(3);
						if(string.toLowerCase().contains("division"))
							comboBoxFlagMathModification.setSelectedIndex(4);
					}
				}
			}
	}
	
	private enum RewardType {
		Experience (0), 
		Reputation (1), 
		Flag_Bool (2), 
		Flag_Short (3), 
		Flag_Short_Random (4), 
		Quest (5), 
		Item (6), 
		Item_Random (7), 
		Vehicle (8), 
		Teleport (9), 
		Flag_Math (10);
		
		private final int intex;
		
		RewardType(int intex) {
			this.intex = intex;
		}
		private int rewardType() { return intex; };
	}
	
	public enum Modifications {
		Assign ("Assign"), 
		Increment ("Increment"), 
		Decrement ("Decrement");
		private String modification;
		Modifications(String modification) {
			this.modification = modification;
		}
	}
	
	public enum FlagMathModifications {
		Assign ("Assign"), 
		Addition ("Addition"), 
		Subtraction ("Subtraction"), 
		Multiplication ("Multiplication"), 
		Division ("Division");
		private String modificationMath;
		
		FlagMathModifications(String modificationMath) {
			this.modificationMath = modificationMath;
		}
	}

	public String ReturnRewards(int index) {
		//Output variable
		String output = "";
		
		//Create one string to output
		switch(comboBoxConditionType.getSelectedIndex()) {
		case 0:
			output += "Reward_" + index + "_Type Experience\n";
			output += "Reward_" + index + "_Value " + textFieldExperience.getText() + "\n";
			break;
		case 1:
			output += "Reward_" + index + "_Type Reputation\n";
			output += "Reward_" + index + "_Value " + textFieldReputation.getText() + "\n";
			break;
		case 2:
			output += "Reward_" + index + "_Type Flag_Bool\n";
			output += "Reward_" + index + "_ID " + textFieldBoolFlagID.getText() + "\n";
			if(toggleButtonBoolFlagValue.isSelected())
				output += "Reward_" + index + "_Value true\n";
			else
				output += "Reward_" + index + "_Value false\n";
			break;
		case 3:
			output += "Reward_" + index + "_Type Flag_Short\n";
			output += "Reward_" + index + "_Value " + textFieldShortFlagValue.getText() + "\n";
			switch(comboBoxShortModifications.getSelectedIndex()) {
			case 0:
				output += "Reward_" + index + "_Modification Assign\n";
				break;
			case 1:
				output += "Reward_" + index + "_Modification Increment\n";
				break;
			case 2: 
				output += "Reward_" + index + "_Modification Decrement\n";
				break;
			}
			break;
		case 4:
			output += "Reward_" + index + "_Type Flag_Short_Random\n";
			output += "Reward_" + index + "_ID " + textFieldFlagShortRandomID.getText() + "\n";
			output += "Reward_" + index + "_Min_Value " + textFieldShortRandomMinValue.getText() + "\n";
			output += "Reward_" + index + "_Max_Value " + textFieldShortRandomMaxValue.getText() + "\n";
			switch(comboBoxShortRandomModifications.getSelectedIndex()) {
			case 0:
				output += "Reward_" + index + "_Modification Assign\n";
				break;
			case 1:
				output += "Reward_" + index + "_Modification Increment\n";
				break;
			case 2: 
				output += "Reward_" + index + "_Modification Decrement\n";
				break;
			}
			break;
		case 5:
			output += "Reward_" + index + "_Type Quest\n";
			output += "Reward_" + index + "_ID " + textFieldQuestID.getText() + "\n";
			break;
		case 6:
			output += "Reward_" + index + "_Type Item\n";
			output += "Reward_" + index + "_ID " + textFieldItemID.getText() + "\n";
			output += "Reward_" + index + "_Amount " + textFieldItemAmount.getText() + "\n";
			break;
		case 7:
			output += "Reward_" + index + "_Type Item_Random\n";
			output += "Reward_" + index + "_ID " + textFieldItemRandomSpawnID.getText() + "\n";
			output += "Reward_" + index + "_Amount " + textFieldItemRandomAmount.getText() + "\n";
			break;
		case 8:
			output += "Reward_" + index + "_Type Vehicle\n";
			output += "Reward_" + index + "_ID " + textFieldVehicleID.getText() + "\n";
			output += "Reward_" + index + "_Spawnpoint " + textFieldVehicleSpawnpointID.getText() + "\n";
			break;
		case 9:
			output += "Reward_" + index + "_Type Teleport\n";
			output += "Reward_" + index + "_Spawnpoint " + textFieldTeleportSpawnpointID.getText() + "\n";
			break;
		case 10:
			output += "Reward_" + index + "_Type Flag_Math\n";
			output += "Reward_" + index + "_A_ID " + textFieldFlagAID.getText() + "\n";
			output += "Reward_" + index + "_B_ID " + textFieldFlagBID.getText() + "\n";
			switch (comboBoxFlagMathModification.getSelectedIndex()) {
			case 0:
				output += "Reward_" + index + "_Operator Assign\n";
				break;
			case 1:
				output += "Reward_" + index + "_Operator Addition\n";
				break;
			case 2:
				output += "Reward_" + index + "_Operator Subtraction\n";
				break;
			case 3:
				output += "Reward_" + index + "_Operator Multiplication\n";
				break;
			case 4:
				output += "Reward_" + index + "_Operator Division\n";
				break; 
			}
			break;
		}
		
		return output;
	}
}
