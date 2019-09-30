package panels;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import bibliothek.gui.dock.common.DefaultMultipleCDockable;
import colorchooser.ColorChooser;
import objects.Character;
import objects.Pose;
import objects.TextPrompt;

public class PanelCharacter extends JPanel {
	
	private DefaultMultipleCDockable dockableParent;
	
	private Character loadedCharacter;
	private JTextField textFieldID;
	private JTextField textFieldName;
	private JTextField textFieldGUID;
	private JTextField textFieldShirt;
	private JTextField textFieldPants;
	private JTextField textFieldHat;
	private JTextField textFieldBackpack;
	private JTextField textFieldVest;
	private JTextField textFieldGlasses;
	private JTextField textFieldMask;
	private JTextField textFieldShirtChristmas;
	private JTextField textFieldPantsChristmas;
	private JTextField textFieldHatChristmas;
	private JTextField textFieldBackpackChristmas;
	private JTextField textFieldVestChristmas;
	private JTextField textFieldGlassesChristmas;
	private JTextField textFieldMaskChristmas;
	private JTextField textFieldShirtHalloween;
	private JTextField textFieldPantsHalloween;
	private JTextField textFieldHatHalloween;
	private JTextField textFieldBackpackHalloween;
	private JTextField textFieldVestHalloween;
	private JTextField textFieldGlassesHalloween;
	private JTextField textFieldMaskHalloween;
	private JPanel panelRegularClothing;
	private JPanel panelChristmasClothing;
	private JPanel panelHalloweenClothing;
	private JTextField textFieldPrimary;
	private JTextField textFieldSecondary;
	private JTextField textFieldTertiary;
	private final ButtonGroup buttonGroupEquipped = new ButtonGroup();
	private JRadioButton[] equippedButtons = new JRadioButton[4];
	private JButton buttonAddHalloween;
	private JButton buttonAddChristmas;
	private JPanel panelClothingIds;
	private JTextField textFieldDialogueID;

	private Canvas canvasHairColor;
	private Canvas canvasSkinColor;

	private JComboBox<Pose> comboBoxPose;
	private JComboBox<ImageIcon> comboBoxFaces;
	private JComboBox<ImageIcon> comboBoxHairs;
	private JComboBox<ImageIcon> comboBoxBeards;

	private boolean halloweenClothingEnabled = false;
	private boolean christmasClothingEnabled = false;
	
	private JLabel labelLocation;
	
	public PanelCharacter(DefaultMultipleCDockable dockableParent, Character character) {
		this.dockableParent = dockableParent;
		if(character != null)
			this.loadedCharacter = character;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTop = new JPanel();
		panelCenter.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panelTop.add(panel);
		
		textFieldName = new JTextField();
		textFieldName.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(textFieldName.getText().trim().length() > 0) {
					dockableParent.setTitleText("Character - " + textFieldName.getText());
				} else {
					dockableParent.setTitleText("Character");
				}
			}
			public void keyReleased(KeyEvent e) {
				if(textFieldName.getText().trim().length() > 0) {
					dockableParent.setTitleText("Character - " + textFieldName.getText());
				} else {
					dockableParent.setTitleText("Character");
				}
			}
			public void keyTyped(KeyEvent e) {}
		});
		new TextPrompt("Name", textFieldName, 100);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldID = new JTextField();
		new TextPrompt("ID", textFieldID, 100);
		panel.add(textFieldID);
		textFieldID.setColumns(10);
		
		JPanel panelGUID = new JPanel();
		panelTop.add(panelGUID);
		panelGUID.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panelGUID.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{5, 86, 0};
		gbl_panel_1.rowHeights = new int[]{20, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		textFieldGUID = new JTextField();
		new TextPrompt("GUID", textFieldGUID, 100);
		textFieldGUID.setEditable(false);
		GridBagConstraints gbc_textFieldGUID = new GridBagConstraints();
		gbc_textFieldGUID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGUID.gridx = 1;
		gbc_textFieldGUID.gridy = 0;
		panel_1.add(textFieldGUID, gbc_textFieldGUID);
		textFieldGUID.setColumns(10);
		
		JCheckBox checkboxEditGUID = new JCheckBox("Edit");
		checkboxEditGUID.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textFieldGUID.setEditable(checkboxEditGUID.isSelected());
			}
		});
		panelGUID.add(checkboxEditGUID, BorderLayout.EAST);
		
		JPanel panelCenter2 = new JPanel();
		panelCenter.add(panelCenter2, BorderLayout.CENTER);
		panelCenter2.setLayout(new BorderLayout(0, 0));
		
		JPanel panelClothing = new JPanel();
		panelClothing.setBorder(new TitledBorder(null, "Clothing", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCenter2.add(panelClothing, BorderLayout.NORTH);
		panelClothing.setLayout(new BorderLayout(0, 0));
		
		panelClothingIds = new JPanel();
		panelClothing.add(panelClothingIds, BorderLayout.CENTER);
		panelClothingIds.setLayout(new GridLayout(0, 1, 0, 0));
		
		panelRegularClothing = new JPanel();
		panelRegularClothing.setBorder(new TitledBorder(null, "Regular", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelClothingIds.add(panelRegularClothing);
		panelRegularClothing.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panelRegularClothing.add(panel_2);
		
		textFieldShirt = new JTextField();
		new TextPrompt("Shirt", textFieldShirt, 100);
		textFieldShirt.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setShirt(Integer.valueOf(textFieldShirt.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		panel_2.add(textFieldShirt);
		textFieldShirt.setColumns(10);
		
		textFieldPants = new JTextField();
		new TextPrompt("Pants", textFieldPants, 100);
		textFieldPants.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setPants(Integer.valueOf(textFieldPants.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		panel_2.add(textFieldPants);
		textFieldPants.setColumns(10);
		
		textFieldHat = new JTextField();
		new TextPrompt("Hat", textFieldHat, 100);
		textFieldHat.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setHat(Integer.valueOf(textFieldHat.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldHat.setColumns(10);
		panel_2.add(textFieldHat);
		
		textFieldBackpack = new JTextField();
		new TextPrompt("Backpack", textFieldBackpack, 100);
		textFieldBackpack.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setBackpack(Integer.valueOf(textFieldBackpack.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldBackpack.setColumns(10);
		panel_2.add(textFieldBackpack);
		
		JPanel panel_3 = new JPanel();
		panelRegularClothing.add(panel_3);
		
		textFieldVest = new JTextField();
		new TextPrompt("Vest", textFieldVest, 100);
		textFieldVest.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setVest(Integer.valueOf(textFieldVest.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldVest.setColumns(10);
		panel_3.add(textFieldVest);
		
		textFieldGlasses = new JTextField();
		new TextPrompt("Glasses", textFieldGlasses, 100);
		textFieldGlasses.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setGlasses(Integer.valueOf(textFieldGlasses.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldGlasses.setColumns(10);
		panel_3.add(textFieldGlasses);
		
		textFieldMask = new JTextField();
		new TextPrompt("Mask", textFieldMask, 100);
		textFieldMask.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setMask(Integer.valueOf(textFieldMask.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldMask.setColumns(10);
		panel_3.add(textFieldMask);
		
		/*
		 * Christmas clothing panel
		 */
		
		panelChristmasClothing = new JPanel();
		panelChristmasClothing.setBorder(new TitledBorder(null, "Christmas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChristmasClothing.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panelChristmasClothing.add(panel_8);
		
		textFieldShirtChristmas = new JTextField();
		new TextPrompt("Shirt", textFieldShirtChristmas, 100);
		textFieldShirt.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setShirtChristmas(Integer.valueOf(textFieldShirtChristmas.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		panel_8.add(textFieldShirtChristmas);
		textFieldShirtChristmas.setColumns(10);
		
		textFieldPantsChristmas = new JTextField();
		new TextPrompt("Pants", textFieldPantsChristmas, 100);
		textFieldPants.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setPantsChristmas(Integer.valueOf(textFieldPantsChristmas.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		panel_8.add(textFieldPantsChristmas);
		textFieldPantsChristmas.setColumns(10);
		
		textFieldHatChristmas = new JTextField();
		new TextPrompt("Hat", textFieldHatChristmas, 100);
		textFieldHat.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setHatChristmas(Integer.valueOf(textFieldHatChristmas.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldHatChristmas.setColumns(10);
		panel_8.add(textFieldHatChristmas);
		
		textFieldBackpackChristmas = new JTextField();
		new TextPrompt("Backpack", textFieldBackpackChristmas, 100);
		textFieldBackpack.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setBackpackChristmas(Integer.valueOf(textFieldBackpackChristmas.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldBackpackChristmas.setColumns(10);
		panel_8.add(textFieldBackpackChristmas);
		
		JPanel panel_9 = new JPanel();
		panelChristmasClothing.add(panel_9);
				
		textFieldVestChristmas = new JTextField();
		new TextPrompt("Vest", textFieldVestChristmas, 100);
		textFieldVest.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setVestChristmas(Integer.valueOf(textFieldVestChristmas.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldVestChristmas.setColumns(10);
		panel_9.add(textFieldVestChristmas);
		
		textFieldGlassesChristmas = new JTextField();
		new TextPrompt("Glasses", textFieldGlassesChristmas, 100);
		textFieldGlasses.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setGlassesChristmas(Integer.valueOf(textFieldGlassesChristmas.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldGlassesChristmas.setColumns(10);
		panel_9.add(textFieldGlassesChristmas);
		
		textFieldMaskChristmas = new JTextField();
		new TextPrompt("Mask", textFieldMaskChristmas, 100);
		textFieldMask.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setMaskChristmas(Integer.valueOf(textFieldMaskChristmas.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldMaskChristmas.setColumns(10);
		panel_9.add(textFieldMaskChristmas);
		
		/*
		 * Halloween clothing panel
		 */
		
		panelHalloweenClothing = new JPanel();
		panelHalloweenClothing.setBorder(new TitledBorder(null, "Halloween", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelHalloweenClothing.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panelHalloweenClothing.add(panel_6);
		
		textFieldShirtHalloween = new JTextField();
		new TextPrompt("Shirt", textFieldShirtHalloween, 100);
		textFieldShirt.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setShirtHalloween(Integer.valueOf(textFieldShirtHalloween.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		panel_6.add(textFieldShirtHalloween);
		textFieldShirtHalloween.setColumns(10);
		
		textFieldPantsHalloween = new JTextField();
		new TextPrompt("Pants", textFieldPantsHalloween, 100);
		textFieldPants.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setPantsHalloween(Integer.valueOf(textFieldPantsHalloween.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		panel_6.add(textFieldPantsHalloween);
		textFieldPantsHalloween.setColumns(10);
		
		textFieldHatHalloween = new JTextField();
		new TextPrompt("Hat", textFieldHatHalloween, 100);
		textFieldHat.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setHatHalloween(Integer.valueOf(textFieldHatHalloween.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldHatHalloween.setColumns(10);
		panel_6.add(textFieldHatHalloween);
		
		textFieldBackpackHalloween = new JTextField();
		new TextPrompt("Backpack", textFieldBackpackHalloween, 100);
		textFieldBackpack.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setBackpackHalloween(Integer.valueOf(textFieldBackpackHalloween.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldBackpackHalloween.setColumns(10);
		panel_6.add(textFieldBackpackHalloween);
		
		JPanel panel_7 = new JPanel();
		panelHalloweenClothing.add(panel_7);
				
		textFieldVestHalloween = new JTextField();
		new TextPrompt("Vest", textFieldVestHalloween, 100);
		textFieldVest.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setVestHalloween(Integer.valueOf(textFieldVestHalloween.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldVestHalloween.setColumns(10);
		panel_7.add(textFieldVestHalloween);
		
		textFieldGlassesHalloween = new JTextField();
		new TextPrompt("Glasses", textFieldGlassesHalloween, 100);
		textFieldGlasses.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setGlassesHalloween(Integer.valueOf(textFieldGlassesHalloween.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldGlassesHalloween.setColumns(10);
		panel_7.add(textFieldGlassesHalloween);
		
		textFieldMaskHalloween = new JTextField();
		new TextPrompt("Mask", textFieldMaskHalloween, 100);
		textFieldMask.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				loadedCharacter.setMaskHalloween(Integer.valueOf(textFieldMaskHalloween.getText()));
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		textFieldMaskHalloween.setColumns(10);
		panel_7.add(textFieldMaskHalloween);
		
		/*
		 * 
		 */
		
		JPanel panelAddDifferentClothingTypes = new JPanel();
		panelClothing.add(panelAddDifferentClothingTypes, BorderLayout.SOUTH);
		
		buttonAddHalloween = new JButton("Add halloween clothing");
		buttonAddHalloween.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				halloweenClothingEnabled = !halloweenClothingEnabled;
				if(halloweenClothingEnabled) {
					panelClothingIds.add(panelHalloweenClothing);
					buttonAddHalloween.setText("Remove Halloween Clothing");
				} else {
					panelClothingIds.remove(panelHalloweenClothing);
					buttonAddHalloween.setText("Add Halloween Clothing");
				}
				if(loadedCharacter!=null)
					loadedCharacter.setHalloweenClothing(halloweenClothingEnabled);
			}
		});
		panelAddDifferentClothingTypes.add(buttonAddHalloween);
		
		buttonAddChristmas = new JButton("Add christmas clothing");
		buttonAddChristmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				christmasClothingEnabled = !christmasClothingEnabled;
				if(christmasClothingEnabled) {
					panelClothingIds.add(panelChristmasClothing);
					buttonAddChristmas.setText("Remove Christmas Clothing");
				} else {
					panelClothingIds.remove(panelChristmasClothing);
					buttonAddChristmas.setText("Add Christmas Clothing");
				}
				if(loadedCharacter!=null)
					loadedCharacter.setChristmasClothing(christmasClothingEnabled);
			}
		});
		panelAddDifferentClothingTypes.add(buttonAddChristmas);
		
		JPanel panelCenter3 = new JPanel();
		panelCenter2.add(panelCenter3, BorderLayout.CENTER);
		panelCenter3.setLayout(new BorderLayout(0, 0));
		
		JPanel panelEquipped = new JPanel();
		panelEquipped.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Equipment", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCenter3.add(panelEquipped, BorderLayout.NORTH);
		panelEquipped.setLayout(new BorderLayout(0, 0));
		
		JPanel panelEquippedID = new JPanel();
		panelEquipped.add(panelEquippedID);
		
		JPanel panelEquippedItem = new JPanel();
		panelEquipped.add(panelEquippedItem, BorderLayout.SOUTH);
		
		JRadioButton radioButtonNone = new JRadioButton("None");
		buttonGroupEquipped.add(radioButtonNone);
		equippedButtons[0] = radioButtonNone;
		radioButtonNone.setSelected(true);
		panelEquippedItem.add(radioButtonNone);
		
		JRadioButton radioButtonPrimary = new JRadioButton("Primary");
		radioButtonPrimary.setEnabled(false);
		equippedButtons[1] = radioButtonPrimary;
		buttonGroupEquipped.add(radioButtonPrimary);
		panelEquippedItem.add(radioButtonPrimary);
		
		JRadioButton radioButtonSecondary = new JRadioButton("Secondary");
		radioButtonSecondary.setEnabled(false);
		equippedButtons[2] = radioButtonSecondary;
		buttonGroupEquipped.add(radioButtonSecondary);
		panelEquippedItem.add(radioButtonSecondary);
		
		JRadioButton radioButtonTertiary = new JRadioButton("Tertiary");
		radioButtonTertiary.setEnabled(false);
		equippedButtons[3] = radioButtonTertiary;
		buttonGroupEquipped.add(radioButtonTertiary);
		panelEquippedItem.add(radioButtonTertiary);
		
		textFieldPrimary = new JTextField();
		textFieldPrimary.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textFieldPrimary.getText().trim().length()>0) {
					radioButtonPrimary.setEnabled(true);
				} else {
					if(radioButtonPrimary.isSelected())
						radioButtonNone.setSelected(true);
					radioButtonPrimary.setEnabled(false);
				}
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		new TextPrompt("Primary", textFieldPrimary, 100);
		panelEquippedID.add(textFieldPrimary);
		textFieldPrimary.setColumns(10);
		
		textFieldSecondary = new JTextField();
		textFieldSecondary.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textFieldSecondary.getText().trim().length()>0) {
					radioButtonSecondary.setEnabled(true);
				} else {
					if(radioButtonSecondary.isSelected())
						radioButtonNone.setSelected(true);
					radioButtonSecondary.setEnabled(false);
				}
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		new TextPrompt("Secondary", textFieldSecondary, 100);
		textFieldSecondary.setColumns(10);
		panelEquippedID.add(textFieldSecondary);
		
		textFieldTertiary = new JTextField();
		textFieldTertiary.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(textFieldTertiary.getText().trim().length()>0) {
					radioButtonTertiary.setEnabled(true);
				} else {
					if(radioButtonTertiary.isSelected())
						radioButtonNone.setSelected(true);
					radioButtonTertiary.setEnabled(false);
				}
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		new TextPrompt("Tertiary", textFieldTertiary, 100);
		textFieldTertiary.setColumns(10);
		panelEquippedID.add(textFieldTertiary);
		
		JPanel panelCenter4 = new JPanel();
		panelCenter3.add(panelCenter4, BorderLayout.CENTER);
		panelCenter4.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCharacter = new JPanel();
		panelCharacter.setBorder(new TitledBorder(null, "Character", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCenter4.add(panelCharacter, BorderLayout.NORTH);
		panelCharacter.setLayout(new BorderLayout(0, 0));
		
		JPanel panelPose = new JPanel();
		panelCharacter.add(panelPose, BorderLayout.NORTH);
		panelPose.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		comboBoxPose = new JComboBox<Pose>(new DefaultComboBoxModel<Pose>(Pose.values()));
		panelPose.add(comboBoxPose);
		
		ImageIcon[] faceIcons = new ImageIcon[new File(this.getClass().getClassLoader().getResource("Icons/Faces").getFile().replace("%20", " ")).listFiles().length];
		for(int i = 0; i < faceIcons.length; i++) {
			try {
				faceIcons[i] = new ImageIcon(ImageIO.read(new File(this.getClass().getClassLoader().getResource("Icons/Faces").getFile().replace("%20", " ")).listFiles()[i]));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		ImageIcon[] hairIcons = new ImageIcon[new File(this.getClass().getClassLoader().getResource("Icons/Hairs").getFile().replace("%20", " ")).listFiles().length];
		for(int i = 0; i < hairIcons.length; i++) {
			try {
				hairIcons[i] = new ImageIcon(ImageIO.read(new File(this.getClass().getClassLoader().getResource("Icons/Hairs").getFile().replace("%20", " ")).listFiles()[i]));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		ImageIcon[] beardIcons = new ImageIcon[new File(this.getClass().getClassLoader().getResource("Icons/Beards").getFile().replace("%20", " ")).listFiles().length];
		for(int i = 0; i < beardIcons.length; i++) {
			try {
				beardIcons[i] = new ImageIcon(ImageIO.read(new File(this.getClass().getClassLoader().getResource("Icons/Beards").getFile().replace("%20", " ")).listFiles()[i]));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		comboBoxFaces = new JComboBox<ImageIcon>(new DefaultComboBoxModel<ImageIcon>(faceIcons));
		comboBoxFaces.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadedCharacter.setFace(comboBoxFaces.getSelectedIndex());
			}
		});
		panelPose.add(comboBoxFaces);
		
		comboBoxHairs = new JComboBox<ImageIcon>(new DefaultComboBoxModel<ImageIcon>(hairIcons));
		comboBoxHairs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadedCharacter.setHair(comboBoxHairs.getSelectedIndex());
			}
		});
		panelPose.add(comboBoxHairs);
		
		comboBoxBeards = new JComboBox<ImageIcon>(new DefaultComboBoxModel<ImageIcon>(beardIcons));
		comboBoxBeards.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadedCharacter.setBeard(comboBoxBeards.getSelectedIndex());
			}
		});
		panelPose.add(comboBoxBeards);
		
		JPanel panelSkinAndHairColor = new JPanel();
		panelCharacter.add(panelSkinAndHairColor, BorderLayout.SOUTH);
		
		canvasSkinColor = new Canvas();
		panelSkinAndHairColor.add(canvasSkinColor);
		canvasSkinColor.setBackground(new Color(0xFFFFFF));
		canvasSkinColor.setSize(25, 25);
		
		JButton buttonSkinColor = new JButton("Skin color");
		panelSkinAndHairColor.add(buttonSkinColor);
		
		canvasHairColor = new Canvas();
		panelSkinAndHairColor.add(canvasHairColor);
		canvasHairColor.setBackground(new Color(0xFFFFFF));
		canvasHairColor.setSize(25, 25);
		
		JButton buttonHairAndBeard = new JButton("Hair Color");
		panelSkinAndHairColor.add(buttonHairAndBeard);
		buttonHairAndBeard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ColorChooser(loadedCharacter.getHairColor(), canvasHairColor);
				loadedCharacter.setHairColor(canvasHairColor.getBackground());
			}
		});
		buttonSkinColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ColorChooser(loadedCharacter.getSkinColor(), canvasSkinColor); 
				loadedCharacter.setSkinColor(canvasSkinColor.getBackground());
			}
		});
		
		JPanel panelCenter5 = new JPanel();
		panelCenter4.add(panelCenter5, BorderLayout.CENTER);
		panelCenter5.setLayout(new BorderLayout(0, 0));
		
		JPanel panelExtra = new JPanel();
		panelExtra.setBorder(new TitledBorder(null, "Extra", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCenter5.add(panelExtra, BorderLayout.NORTH);
		panelExtra.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textFieldDialogueID = new JTextField();
		panelExtra.add(textFieldDialogueID);
		new TextPrompt("Dialogue ID", textFieldDialogueID, 100);
		textFieldDialogueID.setColumns(10);
		
		JButton buttonAddCondition = new JButton("Add condition");
		panelExtra.add(buttonAddCondition);
		
		JPanel panelCenter6 = new JPanel();
		panelCenter5.add(panelCenter6, BorderLayout.CENTER);
		
		labelLocation = new JLabel("Location: ");
		panelCenter6.add(labelLocation);
		
		JPanel panelBottom = new JPanel();
		add(panelBottom, BorderLayout.SOUTH);
		panelBottom.setLayout(new GridLayout(0, 2, 0, 0));
		
		if(this.loadedCharacter != null)
			loadCharacter(this.loadedCharacter);
		else
			this.loadedCharacter = new Character();
		
	}
	
	public void loadCharacter(Character character) {
		
		setText(textFieldGUID, character.getGUID());
		setText(textFieldID, character.getID());
		setText(textFieldName, character.getName());

		setText(textFieldShirt, character.getShirt());
		setText(textFieldPants, character.getPants());
		setText(textFieldHat, character.getHat());
		setText(textFieldBackpack, character.getBackpack());
		setText(textFieldVest, character.getVest());
		setText(textFieldGlasses, character.getGlasses());
		setText(textFieldMask, character.getMask());
		
		setText(textFieldShirtHalloween, character.getShirtHalloween());
		setText(textFieldPantsHalloween, character.getPantsHalloween());
		setText(textFieldHatHalloween, character.getHatHalloween());
		setText(textFieldBackpackHalloween, character.getBackpackHalloween());
		setText(textFieldVestHalloween, character.getVestHalloween());
		setText(textFieldGlassesHalloween, character.getGlassesHalloween());
		setText(textFieldMaskHalloween, character.getMaskHalloween());
		
		setText(textFieldShirtChristmas, character.getShirtChristmas());
		setText(textFieldPantsChristmas, character.getPantsChristmas());
		setText(textFieldHatChristmas, character.getHatChristmas());
		setText(textFieldBackpackChristmas, character.getBackpackChristmas());
		setText(textFieldVestChristmas, character.getVestChristmas());
		setText(textFieldGlassesChristmas, character.getGlassesChristmas());
		setText(textFieldMaskChristmas, character.getMaskChristmas());
		
		setText(textFieldPrimary, character.getPrimary());
		setText(textFieldSecondary, character.getSecondary());
		setText(textFieldTertiary, character.getTertiary());
		
		equippedButtons[character.getEquipped().getValue()].setSelected(true);
		
		if(character.isHalloweenClothing()) {
			panelClothingIds.add(panelHalloweenClothing);
			halloweenClothingEnabled = true;
			buttonAddHalloween.setText("Remove Halloween Clothing");
		}
		if(character.isChristmasClothing()) {
			panelClothingIds.add(panelChristmasClothing);
			christmasClothingEnabled = true;
			buttonAddChristmas.setText("Remove Christmas Clothing");
		}
		
		canvasSkinColor.setBackground(character.getSkinColor());
		canvasHairColor.setBackground(character.getHairColor());
		
		comboBoxFaces.setSelectedIndex(character.getFace());
		comboBoxHairs.setSelectedIndex(character.getHair());
		comboBoxBeards.setSelectedIndex(character.getBeard());
		
		comboBoxPose.setSelectedItem(character.getPose());
		
		setText(textFieldDialogueID, character.getDialogueID());
		
		labelLocation.setText("Location: " + character.getFile().getAbsolutePath());
		labelLocation.setToolTipText(character.getFile().getAbsolutePath());
		
	}
	
	public Character getCharacter() {
		return this.loadedCharacter;
	}
	
	private void setText(JTextField textField, String value) {
		if(value != null)
			textField.setText(value);
	}
	
	private void setText(JTextField textField, int value) {
		if(value != -1)
			setText(textField, Integer.toString(value));
	}
}
