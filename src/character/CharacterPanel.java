package character;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import util.FileManager;
import windows.Window;

public class CharacterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6244044573674230366L;
	public static String[] assets;
	//TextFields
	private static JTextField textFieldName;
	private static JTextField textFieldID;
	private static JTextField textFieldShirt;
	private static JTextField textFieldPants;
	private static JTextField textFieldVest;
	private static JTextField textFieldHat;
	private static JTextField textFieldMask;
	private static JTextField textFieldGlasses;
	private static JTextField textFieldBackpack;
	private static JTextField textFieldCharacterName;
	private static JTextField textFieldDialogID;
	private static JTextField textFieldGUID;
	private static JTextField textFieldPrimary;
	private static JTextField textFieldSecondary;
	private static JTextField textFieldTertiary;
	private static JTextField textFieldR2;
	private static JTextField textFieldG2;
	private static JTextField textFieldB2;
	private static JTextField textFieldR1;
	private static JTextField textFieldG1;
	private static JTextField textFieldB1;
	private static JTextField textFieldHex2;
	private static JTextField textFieldHex1;
	private JTextField textFieldHex3;
	private JTextField textFieldR3;
	private JTextField textFieldG3;
	private JTextField textFieldB3;
	//Actions
	private final Action actionLoad = new SwingActionLoad();
	private final Action actionSaveCharacter = new SwingActionSaveCharacter();
	private final Action actionCreateCharacter = new SwingActionCreateCharacter();
	private final Action actionToggleBeardSelection = new SwingActionToggleBeardSelection();
	private final Action actionToggleHairSelection = new SwingActionToggleHairSelection();
	private final Action actionToggleFaceSelector = new SwingActionToggleFaceSelector();
	//Canvas
	private static Canvas skinColor;
	private static Canvas hairColor;
	private Canvas characterColor;
	//Sliders
	private static JSlider sliderSkinRed;
	private static JSlider sliderSkinGreen;
	private static JSlider sliderSkinBlue;
	private static JSlider sliderHairRed;
	private static JSlider sliderHairGreen;
	private static JSlider sliderHairBlue;
	//Button groups
	private static ButtonGroup buttonGroupStance = new ButtonGroup();
	private static ButtonGroup buttonGroupEquipped = new ButtonGroup();
	private static ButtonGroup buttonGroupCharacterNameColor = new ButtonGroup();
	//Radio Buttons
	private static JRadioButton radioButtonStand;
	private static JRadioButton radioButtonSit;
	private static JRadioButton radioButtonAsleep;
	private static JRadioButton radioButtonPrimary;
	private static JRadioButton radioButtonSecondary;
	private static JRadioButton radioButtonTertiary;
	private static JRadioButton radioButtonNone;
	private static JRadioButton radioButtonCommon;
	private static JRadioButton radioButtonUncommon;
	private static JRadioButton radioButtonRare;
	private static JRadioButton radioButtonEpic;
	private static JRadioButton radioButtonLegendary;
	private static JRadioButton radioButtonColorNone;
	private static JRadioButton radioButtonMythical;
	private JRadioButton radioButtonLean;
	private JRadioButton radioButtonUnderArrest;
	private JRadioButton radioButtonRest;
	private JRadioButton radioButtonProne;
	private JRadioButton radioButtonCrouch;
	private JRadioButton radioButtonCustom;
	//Checkbox
	private static JCheckBox checkBoxIsLeftHanded;
	private static JPanel panel;
	private JPanel panelEquipped;
	private static JPanel characterNameColorPanel;
	//Buttons
	private JButton buttonToggleFaceSelector;
	private JButton buttonToggleBeardSelector;
	private JButton buttonToggleHairSelector;
	private JLabel lblHex2;
	private JLabel lblHex1;
	private JLabel lblHexColor;
	private JLabel lblRed_1;
	private JLabel lblGreen_1;
	private JLabel lblBlue_1;
	private static JPanel facePanel;
	private static JPanel beardPanel;
	private static JPanel hairPanel;
	private JPanel panelCharacterCustomColor;
	private JSlider sliderCharacterRed;
	private JSlider sliderCharacterGreen;
	private JSlider sliderCharacterBlue;
	

	/**
	 * Create the panel.
	 */
	public CharacterPanel() {
		setLayout(new BorderLayout(0, 0));
		setBounds(new Rectangle(10000, 10000, 1000, 1000));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setWheelScrollingEnabled(true);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollPane, BorderLayout.CENTER);

		panel = new JPanel();
		panel.setSize(new Dimension(1000, 100));
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {80, 100, 80};
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 23, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };		
		panel.setLayout(gbl_panel);

		JLabel lblNameAndID = new JLabel("Name & ID");
		lblNameAndID.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNameAndID = new GridBagConstraints();
		gbc_lblNameAndID.insets = new Insets(0, 0, 5, 5);
		gbc_lblNameAndID.gridx = 1;
		gbc_lblNameAndID.gridy = 0;
		panel.add(lblNameAndID, gbc_lblNameAndID);

		JLabel lblName = new JLabel("Folder Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		panel.add(lblName, gbc_lblName);

		textFieldName = new JTextField();
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
					FileManager.LoadCharacter(textFieldName.getText());
			}
		});
		textFieldName.setToolTipText("NPC name or Path");
		textFieldName.setColumns(10);
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldName.weightx = 0.0;
		gbc_textFieldName.anchor = GridBagConstraints.PAGE_END;
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 1;
		panel.add(textFieldName, gbc_textFieldName);

		JButton buttonLoad = new JButton("");
		buttonLoad.setAction(actionLoad);
		GridBagConstraints gbc_buttonLoad = new GridBagConstraints();
		gbc_buttonLoad.fill = GridBagConstraints.BOTH;
		gbc_buttonLoad.insets = new Insets(0, 0, 5, 0);
		gbc_buttonLoad.anchor = GridBagConstraints.PAGE_END;
		gbc_buttonLoad.gridx = 2;
		gbc_buttonLoad.gridy = 1;
		panel.add(buttonLoad, gbc_buttonLoad);

		JLabel lblID = new JLabel("ID");
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 2;
		panel.add(lblID, gbc_lblID);

		textFieldID = new JTextField();
		textFieldID.setToolTipText("Set the NPC ID      Max value is 65535      Under 2000 is reserved for official content.");
		textFieldID.setColumns(10);
		GridBagConstraints gbc_textFieldID = new GridBagConstraints();
		gbc_textFieldID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldID.anchor = GridBagConstraints.NORTH;
		gbc_textFieldID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldID.gridx = 1;
		gbc_textFieldID.gridy = 2;
		panel.add(textFieldID, gbc_textFieldID);
		
		JButton buttonCreate = new JButton("Create");
		buttonCreate.setAction(actionCreateCharacter);
		buttonCreate.setToolTipText("Create character with specified path");
		GridBagConstraints gbc_buttonCreate = new GridBagConstraints();
		gbc_buttonCreate.fill = GridBagConstraints.BOTH;
		gbc_buttonCreate.insets = new Insets(0, 0, 5, 0);
		gbc_buttonCreate.gridx = 2;
		gbc_buttonCreate.gridy = 2;
		panel.add(buttonCreate, gbc_buttonCreate);
		
		JLabel lblGUID = new JLabel("GUID");
		GridBagConstraints gbc_lblGUID = new GridBagConstraints();
		gbc_lblGUID.insets = new Insets(0, 0, 5, 5);
		gbc_lblGUID.gridx = 0;
		gbc_lblGUID.gridy = 3;
		panel.add(lblGUID, gbc_lblGUID);
		
		textFieldGUID = new JTextField();
		textFieldGUID.setEditable(false);
		textFieldGUID.setToolTipText("Suggested not to change, will be assigned automatically by unturned.");
		textFieldGUID.setColumns(10);
		GridBagConstraints gbc_textFieldGUID = new GridBagConstraints();
		gbc_textFieldGUID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGUID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGUID.gridx = 1;
		gbc_textFieldGUID.gridy = 3;
		panel.add(textFieldGUID, gbc_textFieldGUID);
		
		JCheckBox checkboxEditGUID = new JCheckBox("Edit");
		checkboxEditGUID.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textFieldGUID.setEditable(checkboxEditGUID.isSelected());
			}
		});
		checkboxEditGUID.setToolTipText("Not recommended.");
		GridBagConstraints gbc_checkboxEditGUID = new GridBagConstraints();
		gbc_checkboxEditGUID.insets = new Insets(0, 0, 5, 0);
		gbc_checkboxEditGUID.gridx = 2;
		gbc_checkboxEditGUID.gridy = 3;
		panel.add(checkboxEditGUID, gbc_checkboxEditGUID);

		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.gridwidth = 3;
		gbc_separator_2.fill = GridBagConstraints.VERTICAL;
		gbc_separator_2.insets = new Insets(0, 0, 5, 0);
		gbc_separator_2.gridx = 0;
		gbc_separator_2.gridy = 4;
		panel.add(separator_2, gbc_separator_2);

		JLabel lblCharacter = new JLabel("Character");
		lblCharacter.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCharacter = new GridBagConstraints();
		gbc_lblCharacter.insets = new Insets(0, 0, 5, 5);
		gbc_lblCharacter.gridx = 1;
		gbc_lblCharacter.gridy = 5;
		panel.add(lblCharacter, gbc_lblCharacter);
		
		JLabel lblCharacterName = new JLabel("Character Name");
		GridBagConstraints gbc_lblCharacterName = new GridBagConstraints();
		gbc_lblCharacterName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCharacterName.gridx = 0;
		gbc_lblCharacterName.gridy = 6;
		panel.add(lblCharacterName, gbc_lblCharacterName);
		
		textFieldCharacterName = new JTextField();
		textFieldCharacterName.setToolTipText("Character name shown in dialogue");
		textFieldCharacterName.setColumns(10);
		GridBagConstraints gbc_textFieldCharacterName = new GridBagConstraints();
		gbc_textFieldCharacterName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCharacterName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCharacterName.gridx = 1;
		gbc_textFieldCharacterName.gridy = 6;
		panel.add(textFieldCharacterName, gbc_textFieldCharacterName);
		
		JLabel lblCharacterColor = new JLabel("Character Color");
		GridBagConstraints gbc_lblCharacterColor = new GridBagConstraints();
		gbc_lblCharacterColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblCharacterColor.gridx = 0;
		gbc_lblCharacterColor.gridy = 7;
		panel.add(lblCharacterColor, gbc_lblCharacterColor);
		
		characterNameColorPanel = new JPanel();
		GridBagConstraints gbc_characterNameColorPanel = new GridBagConstraints();
		gbc_characterNameColorPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_characterNameColorPanel.insets = new Insets(0, 0, 5, 5);
		gbc_characterNameColorPanel.gridx = 1;
		gbc_characterNameColorPanel.gridy = 7;
		panel.add(characterNameColorPanel, gbc_characterNameColorPanel);
		characterNameColorPanel.setLayout(new GridLayout(2, 3, 0, 0));
		
		radioButtonCommon = new JRadioButton("Common");
		radioButtonCommon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				characterColor.setBackground(Color.white);
			}
		});
		buttonGroupCharacterNameColor.add(radioButtonCommon);
		radioButtonCommon.setMnemonic('1');
		characterNameColorPanel.add(radioButtonCommon);
		
		radioButtonUncommon = new JRadioButton("Uncommon");
		radioButtonUncommon.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				characterColor.setBackground(new Color(31,135,31));
			}
		});
		buttonGroupCharacterNameColor.add(radioButtonUncommon);
		radioButtonUncommon.setMnemonic('2');
		characterNameColorPanel.add(radioButtonUncommon);
		
		radioButtonRare = new JRadioButton("Rare");
		radioButtonRare.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				characterColor.setBackground(new Color(75,100,250));
			}
		});
		buttonGroupCharacterNameColor.add(radioButtonRare);
		radioButtonRare.setMnemonic('3');
		characterNameColorPanel.add(radioButtonRare);
		
		radioButtonEpic = new JRadioButton("Epic");
		radioButtonEpic.setMnemonic('4');
		radioButtonEpic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				characterColor.setBackground(new Color(150,75,250));
			}
		});
		buttonGroupCharacterNameColor.add(radioButtonEpic);
		characterNameColorPanel.add(radioButtonEpic);
		
		radioButtonLegendary = new JRadioButton("Legendary");
		radioButtonLegendary.setMnemonic('5');
		radioButtonLegendary.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				characterColor.setBackground(new Color(187,50,250));
			}
		});
		buttonGroupCharacterNameColor.add(radioButtonLegendary);
		characterNameColorPanel.add(radioButtonLegendary);
		
		radioButtonMythical = new JRadioButton("Mythical");
		radioButtonMythical.setMnemonic('6');
		radioButtonMythical.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				characterColor.setBackground(new Color(250,50,17));
			}
		});
		buttonGroupCharacterNameColor.add(radioButtonMythical);
		characterNameColorPanel.add(radioButtonMythical);
		
		radioButtonColorNone = new JRadioButton("None");
		radioButtonColorNone.setSelected(true);
		radioButtonColorNone.setMnemonic('7');
		radioButtonColorNone.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				characterColor.setBackground(Color.WHITE);
			}
		});
		buttonGroupCharacterNameColor.add(radioButtonColorNone);
		characterNameColorPanel.add(radioButtonColorNone);
		
		radioButtonCustom = new JRadioButton("Custom");
		radioButtonCustom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==ItemEvent.SELECTED)
				{
					panelCharacterCustomColor.setVisible(true);
					panel.revalidate();
					panel.repaint();
				} else
				{
					panelCharacterCustomColor.setVisible(false);
					panel.revalidate();
					panel.repaint();
				}
			}
		});
		buttonGroupCharacterNameColor.add(radioButtonCustom);
		radioButtonCustom.setMnemonic('7');
		characterNameColorPanel.add(radioButtonCustom);
		
		characterColor = new Canvas();
		characterColor.setBackground(Color.WHITE);
		GridBagConstraints gbc_characterColor = new GridBagConstraints();
		gbc_characterColor.fill = GridBagConstraints.BOTH;
		gbc_characterColor.insets = new Insets(0, 0, 5, 5);
		gbc_characterColor.gridx = 1;
		gbc_characterColor.gridy = 8;
		panel.add(characterColor, gbc_characterColor);
		
		panelCharacterCustomColor = new JPanel();
		panelCharacterCustomColor.setVisible(false);
		GridBagConstraints gbc_panelCharacterCustomColor = new GridBagConstraints();
		gbc_panelCharacterCustomColor.gridwidth = 3;
		gbc_panelCharacterCustomColor.insets = new Insets(0, 0, 5, 0);
		gbc_panelCharacterCustomColor.fill = GridBagConstraints.BOTH;
		gbc_panelCharacterCustomColor.gridx = 0;
		gbc_panelCharacterCustomColor.gridy = 9;
		panel.add(panelCharacterCustomColor, gbc_panelCharacterCustomColor);
		GridBagLayout gbl_panelCharacterCustomColor = new GridBagLayout();
		gbl_panelCharacterCustomColor.columnWidths = new int[]{58, 0, 0, 0};
		gbl_panelCharacterCustomColor.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelCharacterCustomColor.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelCharacterCustomColor.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCharacterCustomColor.setLayout(gbl_panelCharacterCustomColor);
		
		lblRed_1 = new JLabel("Red");
		GridBagConstraints gbc_lblRed_1 = new GridBagConstraints();
		gbc_lblRed_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRed_1.gridx = 0;
		gbc_lblRed_1.gridy = 0;
		panelCharacterCustomColor.add(lblRed_1, gbc_lblRed_1);
		
		sliderCharacterRed = new JSlider();
		sliderCharacterRed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CharacterColorChanged();
			}
		});
		sliderCharacterRed.setMaximum(255);
		GridBagConstraints gbc_sliderCharacterRed = new GridBagConstraints();
		gbc_sliderCharacterRed.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderCharacterRed.insets = new Insets(0, 0, 5, 5);
		gbc_sliderCharacterRed.gridx = 1;
		gbc_sliderCharacterRed.gridy = 0;
		panelCharacterCustomColor.add(sliderCharacterRed, gbc_sliderCharacterRed);
		
		textFieldR3 = new JTextField();
		textFieldR3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = textFieldR3.getText();
				if(string.chars().allMatch(Character::isDigit)&&string.length()>0)
				{
					int val = Integer.valueOf(string);
					if(val<0)
						sliderCharacterRed.setValue(0);
					else if(val>255)
						sliderCharacterRed.setValue(255);
					else
						sliderCharacterRed.setValue(val);
				}
			}
		});
		GridBagConstraints gbc_textFieldR3 = new GridBagConstraints();
		gbc_textFieldR3.anchor = GridBagConstraints.WEST;
		gbc_textFieldR3.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldR3.gridx = 2;
		gbc_textFieldR3.gridy = 0;
		panelCharacterCustomColor.add(textFieldR3, gbc_textFieldR3);
		textFieldR3.setColumns(4);
		
		lblGreen_1 = new JLabel("Green");
		GridBagConstraints gbc_lblGreen_1 = new GridBagConstraints();
		gbc_lblGreen_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGreen_1.gridx = 0;
		gbc_lblGreen_1.gridy = 1;
		panelCharacterCustomColor.add(lblGreen_1, gbc_lblGreen_1);
		
		sliderCharacterGreen = new JSlider();
		sliderCharacterGreen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CharacterColorChanged();
			}
		});
		sliderCharacterGreen.setMaximum(255);
		GridBagConstraints gbc_sliderCharacterGreen = new GridBagConstraints();
		gbc_sliderCharacterGreen.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderCharacterGreen.insets = new Insets(0, 0, 5, 5);
		gbc_sliderCharacterGreen.gridx = 1;
		gbc_sliderCharacterGreen.gridy = 1;
		panelCharacterCustomColor.add(sliderCharacterGreen, gbc_sliderCharacterGreen);
		
		textFieldG3 = new JTextField();
		textFieldG3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = textFieldG3.getText();
				if(string.chars().allMatch(Character::isDigit)&&string.length()>0)
				{
					int val = Integer.valueOf(string);
					if(val<0)
						sliderCharacterGreen.setValue(0);
					else if(val>255)
						sliderCharacterGreen.setValue(255);
					else
						sliderCharacterGreen.setValue(val);
				}
			}
		});
		textFieldG3.setColumns(4);
		GridBagConstraints gbc_textFieldG3 = new GridBagConstraints();
		gbc_textFieldG3.anchor = GridBagConstraints.WEST;
		gbc_textFieldG3.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldG3.gridx = 2;
		gbc_textFieldG3.gridy = 1;
		panelCharacterCustomColor.add(textFieldG3, gbc_textFieldG3);
		
		lblBlue_1 = new JLabel("Blue");
		GridBagConstraints gbc_lblBlue_1 = new GridBagConstraints();
		gbc_lblBlue_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlue_1.gridx = 0;
		gbc_lblBlue_1.gridy = 2;
		panelCharacterCustomColor.add(lblBlue_1, gbc_lblBlue_1);
		
		sliderCharacterBlue = new JSlider();
		sliderCharacterBlue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CharacterColorChanged();
			}
		});
		sliderCharacterBlue.setMaximum(255);
		GridBagConstraints gbc_sliderCharacterBlue = new GridBagConstraints();
		gbc_sliderCharacterBlue.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderCharacterBlue.insets = new Insets(0, 0, 5, 5);
		gbc_sliderCharacterBlue.gridx = 1;
		gbc_sliderCharacterBlue.gridy = 2;
		panelCharacterCustomColor.add(sliderCharacterBlue, gbc_sliderCharacterBlue);
		
		textFieldB3 = new JTextField();
		textFieldB3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = textFieldB3.getText();
				if(string.chars().allMatch(Character::isDigit)&&string.length()>0)
				{
					int val = Integer.valueOf(string);
					if(val<0)
						sliderCharacterBlue.setValue(0);
					else if(val>255)
						sliderCharacterBlue.setValue(255);
					else
						sliderCharacterBlue.setValue(val);
				}
			}
		});
		textFieldB3.setColumns(4);
		GridBagConstraints gbc_textFieldB3 = new GridBagConstraints();
		gbc_textFieldB3.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldB3.anchor = GridBagConstraints.WEST;
		gbc_textFieldB3.gridx = 2;
		gbc_textFieldB3.gridy = 2;
		panelCharacterCustomColor.add(textFieldB3, gbc_textFieldB3);
		
		lblHexColor = new JLabel("HEX");
		GridBagConstraints gbc_lblHexColor = new GridBagConstraints();
		gbc_lblHexColor.insets = new Insets(0, 0, 0, 5);
		gbc_lblHexColor.gridx = 0;
		gbc_lblHexColor.gridy = 3;
		panelCharacterCustomColor.add(lblHexColor, gbc_lblHexColor);
		
		textFieldHex3 = new JTextField();
		textFieldHex3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
						setCharacterColors(Color.decode(textFieldHex3.getText()));
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(new JFrame(), "Incorrect formating, remember \"#\"", "Warning",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		GridBagConstraints gbc_textFieldHex3 = new GridBagConstraints();
		gbc_textFieldHex3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHex3.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldHex3.gridx = 1;
		gbc_textFieldHex3.gridy = 3;
		panelCharacterCustomColor.add(textFieldHex3, gbc_textFieldHex3);
		textFieldHex3.setColumns(10);
		
		JLabel lblFace = new JLabel("Face");
		GridBagConstraints gbc_lblFace = new GridBagConstraints();
		gbc_lblFace.insets = new Insets(0, 0, 5, 5);
		gbc_lblFace.gridx = 0;
		gbc_lblFace.gridy = 10;
		panel.add(lblFace, gbc_lblFace);
		
		buttonToggleFaceSelector = new JButton("New button");
		buttonToggleFaceSelector.setAction(actionToggleFaceSelector);
		GridBagConstraints gbc_buttonToggleFaceSelector = new GridBagConstraints();
		gbc_buttonToggleFaceSelector.anchor = GridBagConstraints.NORTH;
		gbc_buttonToggleFaceSelector.insets = new Insets(0, 0, 5, 5);
		gbc_buttonToggleFaceSelector.gridx = 1;
		gbc_buttonToggleFaceSelector.gridy = 10;
		panel.add(buttonToggleFaceSelector, gbc_buttonToggleFaceSelector);
		
		facePanel = new JPanel();
		facePanel.setVisible(false);
		facePanel.setEnabled(false);
		GridBagConstraints gbc_facePanel = new GridBagConstraints();
		gbc_facePanel.gridwidth = 3;
		gbc_facePanel.insets = new Insets(0, 0, 5, 0);
		gbc_facePanel.fill = GridBagConstraints.BOTH;
		gbc_facePanel.gridx = 0;
		gbc_facePanel.gridy = 11;
		panel.add(facePanel, gbc_facePanel);

		JLabel lblBeard = new JLabel("Beard");
		GridBagConstraints gbc_lblBeard = new GridBagConstraints();
		gbc_lblBeard.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeard.gridx = 0;
		gbc_lblBeard.gridy = 12;
		panel.add(lblBeard, gbc_lblBeard);
		
		buttonToggleBeardSelector = new JButton("New button");
		buttonToggleBeardSelector.setAction(actionToggleBeardSelection);
		GridBagConstraints gbc_buttonToggleBeardSelector = new GridBagConstraints();
		gbc_buttonToggleBeardSelector.insets = new Insets(0, 0, 5, 5);
		gbc_buttonToggleBeardSelector.gridx = 1;
		gbc_buttonToggleBeardSelector.gridy = 12;
		panel.add(buttonToggleBeardSelector, gbc_buttonToggleBeardSelector);
		
		beardPanel = new JPanel();
		beardPanel.setVisible(false);
		beardPanel.setEnabled(false);
		GridBagConstraints gbc_beardPanel = new GridBagConstraints();
		gbc_beardPanel.gridwidth = 3;
		gbc_beardPanel.insets = new Insets(0, 0, 5, 0);
		gbc_beardPanel.fill = GridBagConstraints.BOTH;
		gbc_beardPanel.gridx = 0;
		gbc_beardPanel.gridy = 13;
		panel.add(beardPanel, gbc_beardPanel);
		
		JLabel lblHair = new JLabel("Hair");
		GridBagConstraints gbc_lblHair = new GridBagConstraints();
		gbc_lblHair.insets = new Insets(0, 0, 5, 5);
		gbc_lblHair.gridx = 0;
		gbc_lblHair.gridy = 14;
		panel.add(lblHair, gbc_lblHair);
		
		buttonToggleHairSelector = new JButton("New button");
		buttonToggleHairSelector.setAction(actionToggleHairSelection);
		GridBagConstraints gbc_buttonToggleHairSelector = new GridBagConstraints();
		gbc_buttonToggleHairSelector.insets = new Insets(0, 0, 5, 5);
		gbc_buttonToggleHairSelector.gridx = 1;
		gbc_buttonToggleHairSelector.gridy = 14;
		panel.add(buttonToggleHairSelector, gbc_buttonToggleHairSelector);
		
		hairPanel = new JPanel();
		hairPanel.setVisible(false);
		hairPanel.setEnabled(false);
		GridBagConstraints gbc_hairPanel = new GridBagConstraints();
		gbc_hairPanel.gridwidth = 3;
		gbc_hairPanel.insets = new Insets(0, 0, 5, 0);
		gbc_hairPanel.fill = GridBagConstraints.BOTH;
		gbc_hairPanel.gridx = 0;
		gbc_hairPanel.gridy = 15;
		panel.add(hairPanel, gbc_hairPanel);
		
		JLabel lblDialogId = new JLabel("Dialog ID");
		GridBagConstraints gbc_lblDialogId = new GridBagConstraints();
		gbc_lblDialogId.insets = new Insets(0, 0, 5, 5);
		gbc_lblDialogId.gridx = 0;
		gbc_lblDialogId.gridy = 16;
		panel.add(lblDialogId, gbc_lblDialogId);
		
		textFieldDialogID = new JTextField();
		textFieldDialogID.setToolTipText("Hair ID");
		textFieldDialogID.setColumns(10);
		GridBagConstraints gbc_textFieldDialogID = new GridBagConstraints();
		gbc_textFieldDialogID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDialogID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDialogID.gridx = 1;
		gbc_textFieldDialogID.gridy = 16;
		panel.add(textFieldDialogID, gbc_textFieldDialogID);

		JLabel lblSkinColor = new JLabel("Skin Color");
		GridBagConstraints gbc_lblSkinColor = new GridBagConstraints();
		gbc_lblSkinColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblSkinColor.gridx = 0;
		gbc_lblSkinColor.gridy = 17;
		panel.add(lblSkinColor, gbc_lblSkinColor);

		skinColor = new Canvas();
		skinColor.setBackground(Color.WHITE);
		GridBagConstraints gbc_skinColor = new GridBagConstraints();
		gbc_skinColor.fill = GridBagConstraints.BOTH;
		gbc_skinColor.insets = new Insets(0, 0, 5, 5);
		gbc_skinColor.gridx = 1;
		gbc_skinColor.gridy = 17;
		panel.add(skinColor, gbc_skinColor);

		sliderSkinRed = new JSlider();
		sliderSkinRed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				SkinColorChanged();
			}
		});
		
		JLabel lblRed = new JLabel("Red");
		GridBagConstraints gbc_lblRed = new GridBagConstraints();
		gbc_lblRed.insets = new Insets(0, 0, 5, 5);
		gbc_lblRed.gridx = 0;
		gbc_lblRed.gridy = 18;
		panel.add(lblRed, gbc_lblRed);
		sliderSkinRed.setSnapToTicks(true);
		sliderSkinRed.setMaximum(255);
		GridBagConstraints gbc_sliderSkinRed = new GridBagConstraints();
		gbc_sliderSkinRed.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderSkinRed.insets = new Insets(0, 0, 5, 5);
		gbc_sliderSkinRed.gridx = 1;
		gbc_sliderSkinRed.gridy = 18;
		panel.add(sliderSkinRed, gbc_sliderSkinRed);

		sliderSkinGreen = new JSlider();
		sliderSkinGreen.setSnapToTicks(true);
		sliderSkinGreen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				SkinColorChanged();
			}
		});
		
		textFieldR1 = new JTextField();
		GridBagConstraints gbc_textFieldR1 = new GridBagConstraints();
		gbc_textFieldR1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldR1.gridx = 2;
		gbc_textFieldR1.gridy = 18;
		panel.add(textFieldR1, gbc_textFieldR1);
		textFieldR1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = textFieldR1.getText();
				if(string.chars().allMatch(Character::isDigit)&&string.length()>0)
				{
					int val = Integer.valueOf(string);
					if(val<0)
						sliderSkinRed.setValue(0);
					else if(val>255)
						sliderSkinRed.setValue(255);
					else
						sliderSkinRed.setValue(val);
				}
			}
		});
		textFieldR1.setColumns(4);
		
		JLabel lblGreen = new JLabel("Green");
		GridBagConstraints gbc_lblGreen = new GridBagConstraints();
		gbc_lblGreen.insets = new Insets(0, 0, 5, 5);
		gbc_lblGreen.gridx = 0;
		gbc_lblGreen.gridy = 19;
		panel.add(lblGreen, gbc_lblGreen);
		sliderSkinGreen.setMaximum(255);
		GridBagConstraints gbc_sliderSkinGreen = new GridBagConstraints();
		gbc_sliderSkinGreen.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderSkinGreen.insets = new Insets(0, 0, 5, 5);
		gbc_sliderSkinGreen.gridx = 1;
		gbc_sliderSkinGreen.gridy = 19;
		panel.add(sliderSkinGreen, gbc_sliderSkinGreen);

		sliderSkinBlue = new JSlider();
		sliderSkinBlue.setSnapToTicks(true);
		sliderSkinBlue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				SkinColorChanged();
			}
		});
		
		textFieldG1 = new JTextField();
		textFieldG1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = textFieldG1.getText();
				if(string.chars().allMatch(Character::isDigit)&&string.length()>0)
				{
					int val = Integer.valueOf(string);
					if(val<0)
						sliderSkinGreen.setValue(0);
					else if(val>255)
						sliderSkinGreen.setValue(255);
					else
						sliderSkinGreen.setValue(val);
				}
			}
		});
		GridBagConstraints gbc_textFieldG1 = new GridBagConstraints();
		gbc_textFieldG1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldG1.gridx = 2;
		gbc_textFieldG1.gridy = 19;
		panel.add(textFieldG1, gbc_textFieldG1);
		textFieldG1.setColumns(4);
		
		JLabel lblBlue = new JLabel("Blue");
		GridBagConstraints gbc_lblBlue = new GridBagConstraints();
		gbc_lblBlue.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlue.gridx = 0;
		gbc_lblBlue.gridy = 20;
		panel.add(lblBlue, gbc_lblBlue);
		sliderSkinBlue.setMaximum(255);
		GridBagConstraints gbc_sliderSkinBlue = new GridBagConstraints();
		gbc_sliderSkinBlue.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderSkinBlue.insets = new Insets(0, 0, 5, 5);
		gbc_sliderSkinBlue.gridx = 1;
		gbc_sliderSkinBlue.gridy = 20;
		panel.add(sliderSkinBlue, gbc_sliderSkinBlue);
		
		textFieldB1 = new JTextField();
		textFieldB1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String string = textFieldB1.getText();
				if(string.chars().allMatch(Character::isDigit)&&string.length()>0)
				{
					int val = Integer.valueOf(string);
					if(val<0)
						sliderSkinBlue.setValue(0);
					else if(val>255)
						sliderSkinBlue.setValue(255);
					else
						sliderSkinBlue.setValue(val);
				}
			}
		});
		GridBagConstraints gbc_textFieldB1 = new GridBagConstraints();
		gbc_textFieldB1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldB1.gridx = 2;
		gbc_textFieldB1.gridy = 20;
		panel.add(textFieldB1, gbc_textFieldB1);
		textFieldB1.setColumns(4);
		
		lblHex1 = new JLabel("HEX");
		GridBagConstraints gbc_lblHex1 = new GridBagConstraints();
		gbc_lblHex1.insets = new Insets(0, 0, 5, 5);
		gbc_lblHex1.gridx = 0;
		gbc_lblHex1.gridy = 21;
		panel.add(lblHex1, gbc_lblHex1);
		
		textFieldHex1 = new JTextField();
		textFieldHex1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
						setSkinColors(Color.decode(textFieldHex1.getText()));
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(new JFrame(), "Incorrect formating, remember \"#\"", "Warning",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		textFieldHex1.setColumns(10);
		GridBagConstraints gbc_textFieldHex1 = new GridBagConstraints();
		gbc_textFieldHex1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldHex1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHex1.gridx = 1;
		gbc_textFieldHex1.gridy = 21;
		panel.add(textFieldHex1, gbc_textFieldHex1);

		JLabel lblHairColor = new JLabel("Hair Color");
		GridBagConstraints gbc_lblHairColor = new GridBagConstraints();
		gbc_lblHairColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblHairColor.gridx = 0;
		gbc_lblHairColor.gridy = 22;
		panel.add(lblHairColor, gbc_lblHairColor);
		
		sliderHairRed = new JSlider();
		sliderHairRed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				HairColorChanged();
			}
		});
		
		hairColor = new Canvas();
		hairColor.setBackground(Color.WHITE);
		GridBagConstraints gbc_hairColor = new GridBagConstraints();
		gbc_hairColor.fill = GridBagConstraints.BOTH;
		gbc_hairColor.insets = new Insets(0, 0, 5, 5);
		gbc_hairColor.gridx = 1;
		gbc_hairColor.gridy = 22;
		panel.add(hairColor, gbc_hairColor);
		
		JLabel lblRed2 = new JLabel("Red");
		GridBagConstraints gbc_lblRed2 = new GridBagConstraints();
		gbc_lblRed2.insets = new Insets(0, 0, 5, 5);
		gbc_lblRed2.gridx = 0;
		gbc_lblRed2.gridy = 23;
		panel.add(lblRed2, gbc_lblRed2);
		sliderHairRed.setSnapToTicks(true);
		sliderHairRed.setMaximum(255);
		GridBagConstraints gbc_sliderHairRed = new GridBagConstraints();
		gbc_sliderHairRed.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderHairRed.insets = new Insets(0, 0, 5, 5);
		gbc_sliderHairRed.gridx = 1;
		gbc_sliderHairRed.gridy = 23;
		panel.add(sliderHairRed, gbc_sliderHairRed);
		
		sliderHairGreen = new JSlider();
		sliderHairGreen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				HairColorChanged();
			}
		});
		
		textFieldR2 = new JTextField();
		textFieldR2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String string = textFieldR2.getText();
				if(string.chars().allMatch(Character::isDigit)&&string.length()>0)
				{
					int val = Integer.valueOf(string);
					if(val<0)
						sliderHairRed.setValue(0);
					else if(val>255)
						sliderHairRed.setValue(255);
					else
						sliderHairRed.setValue(val);
				}
			}
		});
		GridBagConstraints gbc_textFieldR2 = new GridBagConstraints();
		gbc_textFieldR2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldR2.gridx = 2;
		gbc_textFieldR2.gridy = 23;
		panel.add(textFieldR2, gbc_textFieldR2);
		textFieldR2.setColumns(4);
		
		JLabel lblGreen2 = new JLabel("Green");
		GridBagConstraints gbc_lblGreen2 = new GridBagConstraints();
		gbc_lblGreen2.insets = new Insets(0, 0, 5, 5);
		gbc_lblGreen2.gridx = 0;
		gbc_lblGreen2.gridy = 24;
		panel.add(lblGreen2, gbc_lblGreen2);
		sliderHairGreen.setSnapToTicks(true);
		sliderHairGreen.setMaximum(255);
		GridBagConstraints gbc_sliderHairGreen = new GridBagConstraints();
		gbc_sliderHairGreen.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderHairGreen.insets = new Insets(0, 0, 5, 5);
		gbc_sliderHairGreen.gridx = 1;
		gbc_sliderHairGreen.gridy = 24;
		panel.add(sliderHairGreen, gbc_sliderHairGreen);
		
		sliderHairBlue = new JSlider();
		sliderHairBlue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				HairColorChanged();
			}
		});
		
		textFieldG2 = new JTextField();
		textFieldG2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String string = textFieldG2.getText();
				if(string.chars().allMatch(Character::isDigit)&&string.length()>0)
				{
					int val = Integer.valueOf(string);
					if(val<0)
						sliderHairGreen.setValue(0);
					else if(val>255)
						sliderHairGreen.setValue(255);
					else
						sliderHairGreen.setValue(val);
				}
			}
		});
		GridBagConstraints gbc_textFieldG2 = new GridBagConstraints();
		gbc_textFieldG2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldG2.gridx = 2;
		gbc_textFieldG2.gridy = 24;
		panel.add(textFieldG2, gbc_textFieldG2);
		textFieldG2.setColumns(4);
		
		JLabel lblBlue2 = new JLabel("Blue");
		GridBagConstraints gbc_lblBlue2 = new GridBagConstraints();
		gbc_lblBlue2.insets = new Insets(0, 0, 5, 5);
		gbc_lblBlue2.gridx = 0;
		gbc_lblBlue2.gridy = 25;
		panel.add(lblBlue2, gbc_lblBlue2);
		sliderHairBlue.setSnapToTicks(true);
		sliderHairBlue.setMaximum(255);
		GridBagConstraints gbc_sliderHairBlue = new GridBagConstraints();
		gbc_sliderHairBlue.fill = GridBagConstraints.HORIZONTAL;
		gbc_sliderHairBlue.insets = new Insets(0, 0, 5, 5);
		gbc_sliderHairBlue.gridx = 1;
		gbc_sliderHairBlue.gridy = 25;
		panel.add(sliderHairBlue, gbc_sliderHairBlue);
		
		textFieldB2 = new JTextField();
		textFieldB2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String string = textFieldB2.getText();
				if(string.chars().allMatch(Character::isDigit)&&string.length()>0)
				{
					int val = Integer.valueOf(string);
					if(val<0)
						sliderHairBlue.setValue(0);
					else if(val>255)
						sliderHairBlue.setValue(255);
					else
						sliderHairBlue.setValue(val);
				}
			}
		});
		GridBagConstraints gbc_textFieldB2 = new GridBagConstraints();
		gbc_textFieldB2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldB2.gridx = 2;
		gbc_textFieldB2.gridy = 25;
		panel.add(textFieldB2, gbc_textFieldB2);
		textFieldB2.setColumns(4);
		
		lblHex2 = new JLabel("HEX");
		GridBagConstraints gbc_lblHex2 = new GridBagConstraints();
		gbc_lblHex2.insets = new Insets(0, 0, 5, 5);
		gbc_lblHex2.gridx = 0;
		gbc_lblHex2.gridy = 26;
		panel.add(lblHex2, gbc_lblHex2);
		
		textFieldHex2 = new JTextField();
		textFieldHex2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					try {
						setHairColors(Color.decode(textFieldHex2.getText()));
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(new JFrame(), "Incorrect formating, remember \"#\"", "Warning",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		GridBagConstraints gbc_textFieldHex2 = new GridBagConstraints();
		gbc_textFieldHex2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldHex2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHex2.gridx = 1;
		gbc_textFieldHex2.gridy = 26;
		panel.add(textFieldHex2, gbc_textFieldHex2);
		textFieldHex2.setColumns(10);
		
		JLabel lblPose = new JLabel("Pose");
		GridBagConstraints gbc_lblPose = new GridBagConstraints();
		gbc_lblPose.insets = new Insets(0, 0, 5, 5);
		gbc_lblPose.gridx = 0;
		gbc_lblPose.gridy = 27;
		panel.add(lblPose, gbc_lblPose);
		
		JPanel panelStance = new JPanel();
		GridBagConstraints gbc_panelStance = new GridBagConstraints();
		gbc_panelStance.insets = new Insets(0, 0, 5, 5);
		gbc_panelStance.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelStance.gridx = 1;
		gbc_panelStance.gridy = 27;
		panel.add(panelStance, gbc_panelStance);
		panelStance.setLayout(new GridLayout(2, 5, 0, 0));
		
		radioButtonStand = new JRadioButton("Stand");
		buttonGroupStance.add(radioButtonStand);
		radioButtonStand.setMnemonic('1');
		radioButtonStand.setSelected(true);
		panelStance.add(radioButtonStand);
		
		radioButtonSit = new JRadioButton("Sit");
		buttonGroupStance.add(radioButtonSit);
		radioButtonSit.setMnemonic('2');
		panelStance.add(radioButtonSit);
		
		radioButtonAsleep = new JRadioButton("Asleep");
		buttonGroupStance.add(radioButtonAsleep);
		radioButtonAsleep.setMnemonic('3');
		panelStance.add(radioButtonAsleep);
		
		radioButtonLean = new JRadioButton("Lean");
		buttonGroupStance.add(radioButtonLean);
		radioButtonLean.setMnemonic('4');
		panelStance.add(radioButtonLean);
		
		radioButtonUnderArrest = new JRadioButton("Under Arrest");
		buttonGroupStance.add(radioButtonUnderArrest);
		radioButtonUnderArrest.setMnemonic('5');
		panelStance.add(radioButtonUnderArrest);
		
		radioButtonRest = new JRadioButton("Rest");
		buttonGroupStance.add(radioButtonRest);
		radioButtonRest.setMnemonic('6');
		panelStance.add(radioButtonRest);
		
		radioButtonProne = new JRadioButton("Prone");
		buttonGroupStance.add(radioButtonProne);
		radioButtonProne.setMnemonic('7');
		panelStance.add(radioButtonProne);
		
		radioButtonCrouch = new JRadioButton("Crouch");
		buttonGroupStance.add(radioButtonCrouch);
		radioButtonCrouch.setMnemonic('8');
		panelStance.add(radioButtonCrouch);
		
		radioButtonCrouch = new JRadioButton("Surrender");
		buttonGroupStance.add(radioButtonCrouch);
		radioButtonCrouch.setMnemonic('9');
		panelStance.add(radioButtonCrouch);
		
		checkBoxIsLeftHanded = new JCheckBox("Is left handed");
		GridBagConstraints gbc_checkBoxIsLeftHanded = new GridBagConstraints();
		gbc_checkBoxIsLeftHanded.fill = GridBagConstraints.HORIZONTAL;
		gbc_checkBoxIsLeftHanded.insets = new Insets(0, 0, 5, 5);
		gbc_checkBoxIsLeftHanded.gridx = 1;
		gbc_checkBoxIsLeftHanded.gridy = 28;
		panel.add(checkBoxIsLeftHanded, gbc_checkBoxIsLeftHanded);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 3;
		gbc_separator.fill = GridBagConstraints.VERTICAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 29;
		panel.add(separator, gbc_separator);

		JLabel lblEquipment = new JLabel("Equipment");
		lblEquipment.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblEquipment = new GridBagConstraints();
		gbc_lblEquipment.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquipment.gridx = 1;
		gbc_lblEquipment.gridy = 30;
		panel.add(lblEquipment, gbc_lblEquipment);

		JLabel lblShirt = new JLabel("Shirt");
		GridBagConstraints gbc_lblShirt = new GridBagConstraints();
		gbc_lblShirt.insets = new Insets(0, 0, 5, 5);
		gbc_lblShirt.gridx = 0;
		gbc_lblShirt.gridy = 31;
		panel.add(lblShirt, gbc_lblShirt);

		textFieldShirt = new JTextField();
		textFieldShirt.setToolTipText("Shirt ID");
		GridBagConstraints gbc_textFieldShirt = new GridBagConstraints();
		gbc_textFieldShirt.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldShirt.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldShirt.gridx = 1;
		gbc_textFieldShirt.gridy = 31;
		panel.add(textFieldShirt, gbc_textFieldShirt);
		textFieldShirt.setColumns(10);

		JLabel lblPants = new JLabel("Pants");
		GridBagConstraints gbc_lblPants = new GridBagConstraints();
		gbc_lblPants.insets = new Insets(0, 0, 5, 5);
		gbc_lblPants.gridx = 0;
		gbc_lblPants.gridy = 32;
		panel.add(lblPants, gbc_lblPants);

		textFieldPants = new JTextField();
		textFieldPants.setToolTipText("Pants ID");
		textFieldPants.setColumns(10);
		GridBagConstraints gbc_textFieldPants = new GridBagConstraints();
		gbc_textFieldPants.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPants.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPants.gridx = 1;
		gbc_textFieldPants.gridy = 32;
		panel.add(textFieldPants, gbc_textFieldPants);

		JLabel lblVest = new JLabel("Vest");
		GridBagConstraints gbc_lblVest = new GridBagConstraints();
		gbc_lblVest.insets = new Insets(0, 0, 5, 5);
		gbc_lblVest.gridx = 0;
		gbc_lblVest.gridy = 33;
		panel.add(lblVest, gbc_lblVest);

		textFieldVest = new JTextField();
		textFieldVest.setToolTipText("Vest ID");
		textFieldVest.setColumns(10);
		GridBagConstraints gbc_textFieldVest = new GridBagConstraints();
		gbc_textFieldVest.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVest.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVest.gridx = 1;
		gbc_textFieldVest.gridy = 33;
		panel.add(textFieldVest, gbc_textFieldVest);

		JLabel lblHat = new JLabel("Hat");
		GridBagConstraints gbc_lblHat = new GridBagConstraints();
		gbc_lblHat.insets = new Insets(0, 0, 5, 5);
		gbc_lblHat.gridx = 0;
		gbc_lblHat.gridy = 34;
		panel.add(lblHat, gbc_lblHat);

		textFieldHat = new JTextField();
		textFieldHat.setToolTipText("Hat ID");
		textFieldHat.setColumns(10);
		GridBagConstraints gbc_textFieldHat = new GridBagConstraints();
		gbc_textFieldHat.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldHat.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHat.gridx = 1;
		gbc_textFieldHat.gridy = 34;
		panel.add(textFieldHat, gbc_textFieldHat);

		JLabel lblMask = new JLabel("Mask");
		GridBagConstraints gbc_lblMask = new GridBagConstraints();
		gbc_lblMask.insets = new Insets(0, 0, 5, 5);
		gbc_lblMask.gridx = 0;
		gbc_lblMask.gridy = 35;
		panel.add(lblMask, gbc_lblMask);

		textFieldMask = new JTextField();
		textFieldMask.setToolTipText("Mask ID");
		textFieldMask.setColumns(10);
		GridBagConstraints gbc_textFieldMask = new GridBagConstraints();
		gbc_textFieldMask.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMask.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMask.gridx = 1;
		gbc_textFieldMask.gridy = 35;
		panel.add(textFieldMask, gbc_textFieldMask);

		JLabel lblGlasses = new JLabel("Glasses");
		GridBagConstraints gbc_lblGlasses = new GridBagConstraints();
		gbc_lblGlasses.insets = new Insets(0, 0, 5, 5);
		gbc_lblGlasses.gridx = 0;
		gbc_lblGlasses.gridy = 36;
		panel.add(lblGlasses, gbc_lblGlasses);

		textFieldGlasses = new JTextField();
		textFieldGlasses.setToolTipText("Glasses ID");
		textFieldGlasses.setColumns(10);
		GridBagConstraints gbc_textFieldGlasses = new GridBagConstraints();
		gbc_textFieldGlasses.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGlasses.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGlasses.gridx = 1;
		gbc_textFieldGlasses.gridy = 36;
		panel.add(textFieldGlasses, gbc_textFieldGlasses);
		
		JLabel lblBackpack = new JLabel("Backpack");
		GridBagConstraints gbc_lblBackpack = new GridBagConstraints();
		gbc_lblBackpack.insets = new Insets(0, 0, 5, 5);
		gbc_lblBackpack.gridx = 0;
		gbc_lblBackpack.gridy = 37;
		panel.add(lblBackpack, gbc_lblBackpack);
		
		textFieldBackpack = new JTextField();
		textFieldBackpack.setToolTipText("Backpack ID");
		textFieldBackpack.setColumns(10);
		GridBagConstraints gbc_textFieldBackpack = new GridBagConstraints();
		gbc_textFieldBackpack.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBackpack.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBackpack.gridx = 1;
		gbc_textFieldBackpack.gridy = 37;
		panel.add(textFieldBackpack, gbc_textFieldBackpack);
		
		JLabel lblPrimary = new JLabel("Primary");
		GridBagConstraints gbc_lblPrimary = new GridBagConstraints();
		gbc_lblPrimary.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimary.gridx = 0;
		gbc_lblPrimary.gridy = 38;
		panel.add(lblPrimary, gbc_lblPrimary);
		
		textFieldPrimary = new JTextField();
		textFieldPrimary.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(textFieldPrimary.getText().length()>0 || textFieldSecondary.getText().length()>0 || textFieldTertiary.getText().length()>0)
				{
					panelEquipped.setEnabled(true);
					panelEquipped.setVisible(true);
					panelEquipped.revalidate();
					panelEquipped.repaint();
				}
				else
				{
					panelEquipped.setEnabled(false);
					panelEquipped.setVisible(false);
					panelEquipped.revalidate();
					panelEquipped.repaint();
				}
			}
		});
		textFieldPrimary.setToolTipText("Primary item ID");
		textFieldPrimary.setColumns(10);
		GridBagConstraints gbc_textFieldPrimary = new GridBagConstraints();
		gbc_textFieldPrimary.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrimary.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrimary.gridx = 1;
		gbc_textFieldPrimary.gridy = 38;
		panel.add(textFieldPrimary, gbc_textFieldPrimary);
		
		JLabel lblSecondary = new JLabel("Secondary");
		GridBagConstraints gbc_lblSecondary = new GridBagConstraints();
		gbc_lblSecondary.insets = new Insets(0, 0, 5, 5);
		gbc_lblSecondary.gridx = 0;
		gbc_lblSecondary.gridy = 39;
		panel.add(lblSecondary, gbc_lblSecondary);
		
		textFieldSecondary = new JTextField();
		textFieldSecondary.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(textFieldPrimary.getText().length()>0 || textFieldSecondary.getText().length()>0 || textFieldTertiary.getText().length()>0)
				{
					panelEquipped.setEnabled(true);
					panelEquipped.setVisible(true);
					panelEquipped.revalidate();
					panelEquipped.repaint();
				}
				else
				{
					panelEquipped.setEnabled(false);
					panelEquipped.setVisible(false);
					panelEquipped.revalidate();
					panelEquipped.repaint();
				}
			}
		});
		textFieldSecondary.setToolTipText("Secondary item ID");
		textFieldSecondary.setColumns(10);
		GridBagConstraints gbc_textFieldSecondary = new GridBagConstraints();
		gbc_textFieldSecondary.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSecondary.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSecondary.gridx = 1;
		gbc_textFieldSecondary.gridy = 39;
		panel.add(textFieldSecondary, gbc_textFieldSecondary);
		
		JLabel lblTertiary = new JLabel("Tertiary");
		GridBagConstraints gbc_lblTertiary = new GridBagConstraints();
		gbc_lblTertiary.insets = new Insets(0, 0, 5, 5);
		gbc_lblTertiary.gridx = 0;
		gbc_lblTertiary.gridy = 40;
		panel.add(lblTertiary, gbc_lblTertiary);
		
		textFieldTertiary = new JTextField();
		textFieldTertiary.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(textFieldPrimary.getText().length()>0 || textFieldSecondary.getText().length()>0 || textFieldTertiary.getText().length()>0)
				{
					panelEquipped.setEnabled(true);
					panelEquipped.setVisible(true);
					panelEquipped.revalidate();
					panelEquipped.repaint();
				}
				else
				{
					panelEquipped.setEnabled(false);
					panelEquipped.setVisible(false);
					panelEquipped.revalidate();
					panelEquipped.repaint();
				}
			}
		});
		textFieldTertiary.setToolTipText("Tertiary item ID");
		textFieldTertiary.setColumns(10);
		GridBagConstraints gbc_textFieldTertiary = new GridBagConstraints();
		gbc_textFieldTertiary.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTertiary.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTertiary.gridx = 1;
		gbc_textFieldTertiary.gridy = 40;
		panel.add(textFieldTertiary, gbc_textFieldTertiary);
		
		JLabel lblEquipped = new JLabel("Equipped");
		GridBagConstraints gbc_lblEquipped = new GridBagConstraints();
		gbc_lblEquipped.insets = new Insets(0, 0, 5, 5);
		gbc_lblEquipped.gridx = 0;
		gbc_lblEquipped.gridy = 41;
		panel.add(lblEquipped, gbc_lblEquipped);
		
		panelEquipped = new JPanel();
		GridBagConstraints gbc_panelEquipped = new GridBagConstraints();
		gbc_panelEquipped.insets = new Insets(0, 0, 5, 5);
		gbc_panelEquipped.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelEquipped.gridx = 1;
		gbc_panelEquipped.gridy = 41;
		panelEquipped.setEnabled(false);
		panelEquipped.setVisible(false);
		panel.add(panelEquipped, gbc_panelEquipped);
		
		radioButtonPrimary = new JRadioButton("Primary");
		radioButtonPrimary.setMnemonic('1');
		buttonGroupEquipped.add(radioButtonPrimary);
		panelEquipped.add(radioButtonPrimary);
		
		radioButtonSecondary = new JRadioButton("Secondary");
		radioButtonSecondary.setMnemonic('2');
		buttonGroupEquipped.add(radioButtonSecondary);
		panelEquipped.add(radioButtonSecondary);
		
		radioButtonTertiary = new JRadioButton("Tertiary");
		radioButtonTertiary.setMnemonic('3');
		buttonGroupEquipped.add(radioButtonTertiary);
		panelEquipped.add(radioButtonTertiary);
		
		radioButtonNone = new JRadioButton("None");
		radioButtonNone.setMnemonic('4');
		radioButtonNone.setSelected(true);
		buttonGroupEquipped.add(radioButtonNone);
		panelEquipped.add(radioButtonNone);

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 3;
		gbc_separator_1.fill = GridBagConstraints.VERTICAL;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 42;
		panel.add(separator_1, gbc_separator_1);
		
		JButton btnSaveCharacter = new JButton("New button");
		btnSaveCharacter.setAction(actionSaveCharacter);
		GridBagConstraints gbc_btnSaveCharacter = new GridBagConstraints();
		gbc_btnSaveCharacter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSaveCharacter.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveCharacter.gridx = 1;
		gbc_btnSaveCharacter.gridy = 43;
		panel.add(btnSaveCharacter, gbc_btnSaveCharacter);
		
	}

	protected void setCharacterColors(Color decode) {
		sliderCharacterRed.setValue(decode.getRed());
		sliderCharacterGreen.setValue(decode.getGreen());
		sliderCharacterBlue.setValue(decode.getBlue());	
		characterColor.revalidate();
		characterColor.repaint();
	}

	protected void setSkinColors(Color decode) {
		sliderSkinRed.setValue(decode.getRed());
		sliderSkinGreen.setValue(decode.getGreen());
		sliderSkinBlue.setValue(decode.getBlue());	
		skinColor.revalidate();
		skinColor.repaint();
	}
	
	protected void setHairColors(Color decode) {
		sliderHairRed.setValue(decode.getRed());
		sliderHairGreen.setValue(decode.getGreen());
		sliderHairBlue.setValue(decode.getBlue());	
		hairColor.revalidate();
		hairColor.repaint();
	}

	private class SwingActionLoad extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2351450800685324381L;

		public SwingActionLoad() {
			putValue(NAME, "Load");
			putValue(SHORT_DESCRIPTION, "Load NPC from path or name.");
		}

		public void actionPerformed(ActionEvent e) {
			FileManager.LoadCharacter(textFieldName.getText());
		}
	}
	public static void FillFields(String[] assets) {
		if (assets == null) {
			JOptionPane.showMessageDialog(new JFrame(), "Assets field equals null", "Warning",
					JOptionPane.WARNING_MESSAGE);
		} else {
			// Implement option to toggle between Halloween and Christmas

			for (String string : assets) {
				if (string.contains("Shirt") && !(string.contains("Halloween") || string.contains("Christmas")))
					textFieldShirt.setText(string.split(" ")[1]);
				if (string.contains("Pants") && !(string.contains("Halloween") || string.contains("Christmas")))
					textFieldPants.setText(string.split(" ")[1]);
				if (string.contains("Vest") && !(string.contains("Halloween") || string.contains("Christmas")))
					textFieldVest.setText(string.split(" ")[1]);
				if (string.contains("Hat") && !(string.contains("Halloween") || string.contains("Christmas")))
					textFieldHat.setText(string.split(" ")[1]);
				if (string.contains("Mask") && !(string.contains("Halloween") || string.contains("Christmas")))
					textFieldMask.setText(string.split(" ")[1]);
				if (string.contains("Glasses") && !(string.contains("Halloween") || string.contains("Christmas")))
					textFieldGlasses.setText(string.split(" ")[1]);
				if (string.contains("Backpack") && !(string.contains("Halloween") || string.contains("Christmas")))
					textFieldBackpack.setText(string.split(" ")[1]);
				if (string.contains("Color_Skin"))
				{
					sliderSkinRed.setValue(Color.decode(string.split(" ")[1]).getRed());
					sliderSkinGreen.setValue(Color.decode(string.split(" ")[1]).getGreen());
					sliderSkinBlue.setValue(Color.decode(string.split(" ")[1]).getBlue());
				}
				if (string.contains("Color_Hair"))
				{
					sliderHairRed.setValue(Color.decode(string.split(" ")[1]).getRed());
					sliderHairGreen.setValue(Color.decode(string.split(" ")[1]).getGreen());
					sliderHairBlue.setValue(Color.decode(string.split(" ")[1]).getBlue());
				}
				if (string.contains("ID") && !string.contains("GUID"))
					textFieldID.setText(string.split(" ")[1]);
				if (string.contains("GUID"))
					textFieldGUID.setText(string.split(" ")[1]);
				if (string.contains("Dialog"))
					textFieldDialogID.setText(string.split(" ")[1]);
				if (string.contains("Character "))
					textFieldCharacterName.setText(string.substring(string.indexOf(" ")+1));
				if (string.contains("CharacterColor"))
				{
					if(string.toLowerCase().contains("common") && !string.toLowerCase().contains("uncommon"))
						radioButtonCommon.setSelected(true);
					else if(string.toLowerCase().contains("uncommon"))
						radioButtonUncommon.setSelected(true);
					else if(string.toLowerCase().contains("rare"))
						radioButtonRare.setSelected(true);
					else if(string.toLowerCase().contains("epic"))
						radioButtonEpic.setSelected(true);
					else if(string.toLowerCase().contains("legendary"))
						radioButtonLegendary.setSelected(true);
					else if(string.toLowerCase().contains("mythical"))
						radioButtonMythical.setSelected(true);
					else
						radioButtonNone.setSelected(true);
				}
				if (string.contains("Pose "))
				{
					if(string.contains("Stand"))
						radioButtonStand.setSelected(true);
					if(string.contains("Sit"))
						radioButtonSit.setSelected(true);
					if(string.contains("Asleep"))
						radioButtonAsleep.setSelected(true);
				}
				if (string.contains("Primary "))
					textFieldPrimary.setText(string.split(" ")[1]);
				if (string.contains("Secondary "))
					textFieldSecondary.setText(string.split(" ")[1]);
				if (string.contains("Tertiary "))
					textFieldTertiary.setText(string.split(" ")[1]);
				if (string.contains("Backwards "))
					if(string.toLowerCase().contains("true"))
						checkBoxIsLeftHanded.setSelected(true);
				if (string.contains("Face ")) {
					if(facePanel.getComponents().length>0)
						((FaceSelector) facePanel.getComponents()[0]).setFaceID(string.split(" ")[1]);
					else {
						facePanel.add(new FaceSelector());
						((FaceSelector) facePanel.getComponents()[0]).setFaceID(string.split(" ")[1]);
					}
				}
				if (string.contains("Beard ")) {
					if(beardPanel.getComponents().length>0)
						((BeardSelector) beardPanel.getComponents()[0]).setBeardID(string.split(" ")[1]);
					else {
						beardPanel.add(new BeardSelector());
						((BeardSelector) beardPanel.getComponents()[0]).setBeardID(string.split(" ")[1]);
					}
				}
				if (string.contains("Hair ") && !string.toLowerCase().contains("color")) {
					if(hairPanel.getComponents().length>0)
						((HairSelector) hairPanel.getComponents()[0]).setHairID(string.split(" ")[1]);
					else {
						hairPanel.add(new HairSelector());
						((HairSelector) hairPanel.getComponents()[0]).setHairID(string.split(" ")[1]);
					}
				}
				textFieldName.setText(Window.currentPath.split("/")[Window.currentPath.split("/").length-2]);
			}
		}
	}
	
	private class SwingActionSaveCharacter extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6125424399385004120L;

		public SwingActionSaveCharacter() {
			putValue(NAME, "Save Character");
			putValue(SHORT_DESCRIPTION, "Save character properties.");
		}

		public void actionPerformed(ActionEvent e) {
			if(!textFieldID.getText().equals("") && textFieldID.getText().chars().allMatch(Character::isDigit))
				FileManager.SaveCharacter(assets, getValues(), textFieldName.getText());
			else if(!textFieldID.getText().chars().allMatch(Character::isDigit))
				JOptionPane.showMessageDialog(new JFrame(), "A character ID needs to be numerical, range 1-65535, under 2000 is reserved for official content.", "Warning",
						JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(new JFrame(), "You need to assign a ID to the character before saving.", "Warning",
						JOptionPane.WARNING_MESSAGE);
		}
	}
	
	protected void CharacterColorChanged() {
		if(sliderCharacterRed!=null&&sliderCharacterGreen!=null&&sliderCharacterBlue!=null)
		{
			if(textFieldR3!=null&&textFieldG3!=null&&textFieldB3!=null)
			{
				textFieldR3.setText(String.valueOf(sliderCharacterRed.getValue()));
				textFieldG3.setText(String.valueOf(sliderCharacterGreen.getValue()));
				textFieldB3.setText(String.valueOf(sliderCharacterBlue.getValue()));
			}
			characterColor.setBackground(new Color(sliderCharacterRed.getValue(), sliderCharacterGreen.getValue(), sliderCharacterBlue.getValue()));
			characterColor.revalidate();
			characterColor.repaint();
		}
	}
	
	public static void SkinColorChanged() {
		if(sliderSkinRed!=null&&sliderSkinGreen!=null&&sliderSkinBlue!=null)
		{
			if(textFieldR1!=null&&textFieldG1!=null&&textFieldB1!=null)
			{
				textFieldR1.setText(String.valueOf(sliderSkinRed.getValue()));
				textFieldG1.setText(String.valueOf(sliderSkinGreen.getValue()));
				textFieldB1.setText(String.valueOf(sliderSkinBlue.getValue()));
			}
			skinColor.setBackground(new Color(sliderSkinRed.getValue(), sliderSkinGreen.getValue(), sliderSkinBlue.getValue()));
			skinColor.revalidate();
			skinColor.repaint();
		}
	}

	public static void HairColorChanged() {
		if(sliderHairRed!=null&&sliderHairGreen!=null&&sliderHairBlue!=null)
		{
			if(textFieldR2!=null&&textFieldG2!=null&&textFieldB2!=null)
			{
				textFieldR2.setText(String.valueOf(sliderHairRed.getValue()));
				textFieldG2.setText(String.valueOf(sliderHairGreen.getValue()));
				textFieldB2.setText(String.valueOf(sliderHairBlue.getValue()));
			}
			hairColor.setBackground(new Color(sliderHairRed.getValue(), sliderHairGreen.getValue(), sliderHairBlue.getValue()));
			hairColor.revalidate();
			hairColor.repaint();
		}
	}
	
	public static String[][] getValues()
	{
		String[] assetValues = new String[256];
		String[] englishValues = new String[2];
		int i = 0;
		assetValues[i++] = "Type NPC";
		if (textFieldGUID.getText().length()>0)
			assetValues[i++] = "GUID " + textFieldGUID.getText();
		if (textFieldID.getText().chars().allMatch(Character::isDigit) && textFieldID.getText().length()>0)
			assetValues[i++] = "ID " + textFieldID.getText();
		if (textFieldShirt.getText().chars().allMatch(Character::isDigit) && textFieldShirt.getText().length()>0)
			assetValues[i++] = "Shirt " + textFieldShirt.getText();
		if (textFieldPants.getText().chars().allMatch(Character::isDigit) && textFieldPants.getText().length()>0)
			assetValues[i++] = "Pants " + textFieldPants.getText();
		if (textFieldVest.getText().chars().allMatch(Character::isDigit) && textFieldVest.getText().length()>0)
			assetValues[i++] = "Vest " + textFieldVest.getText();
		if (textFieldHat.getText().chars().allMatch(Character::isDigit) && textFieldHat.getText().length()>0)
			assetValues[i++] = "Hat " + textFieldHat.getText();
		if (textFieldMask.getText().chars().allMatch(Character::isDigit) && textFieldMask.getText().length()>0)
			assetValues[i++] = "Mask " + textFieldMask.getText();
		if (textFieldGlasses.getText().chars().allMatch(Character::isDigit) && textFieldGlasses.getText().length()>0)
			assetValues[i++] = "Glasses " + textFieldGlasses.getText();
		if (textFieldBackpack.getText().chars().allMatch(Character::isDigit) && textFieldBackpack.getText().length()>0)
			assetValues[i++] = "Backpack " + textFieldBackpack.getText();
		
		if (textFieldPrimary.getText().length()>0)
			assetValues[i++] = "Primary " + textFieldPrimary.getText();
		if (textFieldSecondary.getText().length()>0)
			assetValues[i++] = "Secondary " + textFieldSecondary.getText();
		if (textFieldTertiary.getText().length()>0)
			assetValues[i++] = "Tertiary " + textFieldTertiary.getText();
		if (textFieldPrimary.getText().length()>0)
			if (buttonGroupEquipped.getSelection().getMnemonic() == '1') assetValues[i++] = "Equipped Primary";
		if (textFieldSecondary.getText().length()>0)
			if (buttonGroupEquipped.getSelection().getMnemonic() == '2') assetValues[i++] = "Equipped Secondary";
		if (textFieldTertiary.getText().length()>0)
			if (buttonGroupEquipped.getSelection().getMnemonic() == '3') assetValues[i++] = "Equipped Tertiary";
		
		if (buttonGroupStance.getSelection().getMnemonic() == '1') assetValues[i++] = "Pose Stand";
		if (buttonGroupStance.getSelection().getMnemonic() == '2') assetValues[i++] = "Pose Sit";
		if (buttonGroupStance.getSelection().getMnemonic() == '3') assetValues[i++] = "Pose Asleep";
		if (buttonGroupStance.getSelection().getMnemonic() == '4') assetValues[i++] = "Pose Passive";
		if (buttonGroupStance.getSelection().getMnemonic() == '5') assetValues[i++] = "Pose Under_Arrest";
		if (buttonGroupStance.getSelection().getMnemonic() == '6') assetValues[i++] = "Pose Rest";
		if (buttonGroupStance.getSelection().getMnemonic() == '7') assetValues[i++] = "Pose Prone";
		if (buttonGroupStance.getSelection().getMnemonic() == '8') assetValues[i++] = "Pose Crouch";
		if (buttonGroupStance.getSelection().getMnemonic() == '9') assetValues[i++] = "Pose Surrender";
		if (checkBoxIsLeftHanded.isSelected()) assetValues[i++] = "Backwards True";
		else assetValues[i++] = "Backwards False";
		
		assetValues[i++] = "Face " + ((FaceSelector) facePanel.getComponents()[0]).getFaceID();
		String string = ((BeardSelector) beardPanel.getComponents()[0]).getBeardID();
		if (!string.equals("0"))
			assetValues[i++] = "Beard " + string;
		string = ((HairSelector) hairPanel.getComponents()[0]).getHairID();
		if (!string.equals("0"))
			assetValues[i++] = "Hair " + string;
		assetValues[i++] = "Color_Skin " + String.format("#%02X%02X%02X", sliderSkinRed.getValue(), sliderSkinGreen.getValue(), sliderSkinBlue.getValue());
		assetValues[i++] = "Color_Hair " + String.format("#%02X%02X%02X", sliderHairRed.getValue(), sliderHairGreen.getValue(), sliderHairBlue.getValue());
		
		if (textFieldDialogID.getText().chars().allMatch(Character::isDigit) && textFieldDialogID.getText().length()>0)
			assetValues[i++] = "Dialogue " + textFieldDialogID.getText();
		
		englishValues[0] = textFieldCharacterName.getText();
		if (buttonGroupCharacterNameColor.getSelection().getMnemonic() == '1') englishValues[1] = "<color=common>" + textFieldCharacterName.getText() + "</color>";
		if (buttonGroupCharacterNameColor.getSelection().getMnemonic() == '2') englishValues[1] = "<color=uncommon>" + textFieldCharacterName.getText() + "</color>";
		if (buttonGroupCharacterNameColor.getSelection().getMnemonic() == '3') englishValues[1] = "<color=rare>" + textFieldCharacterName.getText() + "</color>";
		if (buttonGroupCharacterNameColor.getSelection().getMnemonic() == '4') englishValues[1] = "<color=epic>" + textFieldCharacterName.getText() + "</color>";
		if (buttonGroupCharacterNameColor.getSelection().getMnemonic() == '5') englishValues[1] = "<color=legendary>" + textFieldCharacterName.getText() + "</color>";
		if (buttonGroupCharacterNameColor.getSelection().getMnemonic() == '6') englishValues[1] = "<color=mythical>" + textFieldCharacterName.getText() + "</color>";
		if (buttonGroupCharacterNameColor.getSelection().getMnemonic() == '7') englishValues[1] = textFieldCharacterName.getText();
		
		String[][] output = new String[2][256];
		output[0] = assetValues;
		output[1] = englishValues;
		
		return output;
	}
	private class SwingActionCreateCharacter extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5931032488297478621L;
		public SwingActionCreateCharacter() {
			putValue(NAME, "Create");
			putValue(SHORT_DESCRIPTION, "Creates a new Character with the specified path.");
		}
		public void actionPerformed(ActionEvent e) {
			FileManager.CreateEmpty(textFieldName.getText(), "Characters");
		}
	}
	public static void clearFields() {
		textFieldID.setText("");
		textFieldShirt.setText("");
		textFieldPants.setText("");
		textFieldVest.setText("");
		textFieldHat.setText("");
		textFieldMask.setText("");
		textFieldGlasses.setText("");
		textFieldBackpack.setText("");
		textFieldCharacterName.setText("");
		textFieldDialogID.setText("");
		textFieldGUID.setText("");
		textFieldPrimary.setText("");
		textFieldSecondary.setText("");
		textFieldTertiary.setText("");
	}
	private class SwingActionToggleFaceSelector extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8980200047470646966L;
		public SwingActionToggleFaceSelector() {
			putValue(NAME, "Select Face");
			putValue(SHORT_DESCRIPTION, "Open the face selector.");
		}
		public void actionPerformed(ActionEvent e) {
			if(facePanel.getComponents().length<1)
				facePanel.add(new FaceSelector());
			facePanel.setVisible(!facePanel.isVisible());
			facePanel.setEnabled(!facePanel.isEnabled());
			panel.revalidate();
			panel.repaint();
		}
	}
	private class SwingActionToggleBeardSelection extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8272062276743105050L;
		public SwingActionToggleBeardSelection() {
			putValue(NAME, "Select Beard");
			putValue(SHORT_DESCRIPTION, "Open the beard selector.");
		}
		public void actionPerformed(ActionEvent e) {
			if(beardPanel.getComponents().length<1)
				beardPanel.add(new BeardSelector());
			beardPanel.setVisible(!beardPanel.isVisible());
			beardPanel.setEnabled(!beardPanel.isEnabled());
			panel.revalidate();
			panel.repaint();
		}
	}
	private class SwingActionToggleHairSelection extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1643223590523085821L;
		public SwingActionToggleHairSelection() {
			putValue(NAME, "Select Hair");
			putValue(SHORT_DESCRIPTION, "Open the hair selector.");
		}
		public void actionPerformed(ActionEvent e) {
			if(hairPanel.getComponents().length<1)
				hairPanel.add(new HairSelector());
			hairPanel.setVisible(!hairPanel.isVisible());
			hairPanel.setEnabled(!hairPanel.isEnabled());
			panel.revalidate();
			panel.repaint();
		}
	}
}
