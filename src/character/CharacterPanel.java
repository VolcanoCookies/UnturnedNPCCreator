package character;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import colorchooser.ColorChooser;
import controller.Controller;
import models.Equipped;
import models.NPCCharacter;
import objects.TextPrompt;

public class CharacterPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4741923655589344562L;
	Controller controller;
	CharacterPanel self = this;
	NPCCharacter character;
	TextPrompt textPrompt;
	private JTextField textFieldGUID;
	private JTextField textFieldID;
	private JTextField textFieldCharacterName;
	private JTextField textFieldHalloweenGlasses;
	private JTextField textFieldShirt;
	private JTextField textFieldChristmasShirt;
	private JTextField textFieldChristmasVest;
	private JTextField textFieldHalloweenVest;
	private JTextField textFieldHalloweenShirt;
	private JTextField textFieldPants;
	private JTextField textFieldChristmasPants;
	private JTextField textFieldHalloweenPants;
	private JTextField textFieldVest;
	private JTextField textFieldMask;
	private JTextField textFieldChristmasMask;
	private JTextField textFieldHalloweenMask;
	private JTextField textFieldHat;
	private JTextField textFieldChristmasGlasses;
	private JTextField textFieldChristmasHat;
	private JTextField textFieldHalloweenHat;
	private JTextField textFieldBackpack;
	private JTextField textFieldChristmasBackpack;
	private JTextField textFieldHalloweenBackpack;
	private JTextField textFieldGlasses;
	private JPanel panelFaceAndHair;
	private JButton buttonSelectFace;
	private JButton buttonSelectHair;
	private JButton buttonSelectBeard;
	private JPanel panelDisplaySelector;
	private FaceSelector faceSelector;
	private HairSelector hairSelector;
	private BeardSelector beardSelector;
	private JPanel panelFace;
	private JPanel panelColors;
	private JButton buttonSkinColor;
	private JButton buttonHairColor;
	private JPanel panelEquippedAndStance;
	private JPanel panelEquipped;
	private JPanel panelEquippedIDs;
	private JPanel panelHolding;
	private JTextField textFieldPrimary;
	private JPanel panelBottom;
	private JRadioButton radioButtonPrimary;
	private JRadioButton radioButtonSecondary;
	private JRadioButton radioButtonTertiary;
	private JRadioButton radioButtonNone;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Canvas canvasSkinColor;
	private Canvas canvasHairColor;
	private JPanel panel;
	private JPanel panelLoadSaveButtons;
	
	/**
	 * Create the panel.
	 */
	public CharacterPanel(Controller passedController, NPCCharacter passedCharacter) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				revalidate();
			}
			@Override
			public void componentShown(ComponentEvent e) {
				revalidate();
			}
		});
		
		this.character = passedCharacter;
		this.controller = passedController;
		
		if(character==null) {
			character = new NPCCharacter();
			controller.addCharacter(character);
		}
		
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panelBottom = new JPanel();
		panel.add(panelBottom, BorderLayout.SOUTH);
		panelBottom.setLayout(new BorderLayout(0, 0));
		
		panelFace = new JPanel();
		panelBottom.add(panelFace);
		panelFace.setLayout(new BorderLayout(0, 0));
		
		panelFaceAndHair = new JPanel();
		panelFace.add(panelFaceAndHair, BorderLayout.NORTH);
		panelFaceAndHair.setBorder(new TitledBorder(null, "Face & Hair", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFaceAndHair.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBrowseType = new JPanel();
		panelFaceAndHair.add(panelBrowseType, BorderLayout.CENTER);
		panelBrowseType.setLayout(new GridLayout(0, 3, 0, 0));
		
		buttonSelectFace = new JButton("Select face");
		panelBrowseType.add(buttonSelectFace);
		buttonSelectFace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				beardSelector.setVisible(false);
				hairSelector.setVisible(false);
				faceSelector.setVisible(!faceSelector.isVisible());
			}
		});
		
		buttonSelectHair = new JButton("Select hair");
		panelBrowseType.add(buttonSelectHair);
		buttonSelectHair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				faceSelector.setVisible(false);
				beardSelector.setVisible(false);
				hairSelector.setVisible(!hairSelector.isVisible());
			}
		});
		
		buttonSelectBeard = new JButton("Select beard");
		panelBrowseType.add(buttonSelectBeard);
		buttonSelectBeard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				faceSelector.setVisible(false);
				hairSelector.setVisible(false);
				beardSelector.setVisible(!beardSelector.isVisible());
			}
		});
		
		panelDisplaySelector = new JPanel();
		FlowLayout fl_panelDisplaySelector = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelDisplaySelector.setLayout(fl_panelDisplaySelector);
		
		faceSelector = new FaceSelector(character);
		panelDisplaySelector.add(faceSelector);
		faceSelector.setVisible(false);
		hairSelector = new HairSelector(character);
		panelDisplaySelector.add(hairSelector);
		hairSelector.setVisible(false);
		beardSelector = new BeardSelector(character);
		panelDisplaySelector.add(beardSelector);
		beardSelector.setVisible(false);
		panelFaceAndHair.add(panelDisplaySelector, BorderLayout.SOUTH);
		
		panelColors = new JPanel();
		panelFaceAndHair.add(panelColors, BorderLayout.NORTH);
		panelColors.setLayout(new GridLayout(0, 2, 0, 0));
		
		buttonSkinColor = new JButton("Skin color");
		buttonSkinColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ColorChooser(character.getSkinColor(), canvasSkinColor);
			}
		});
		panelColors.add(buttonSkinColor);
		
		buttonHairColor = new JButton("Hair color");
		buttonHairColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ColorChooser(character.getSkinColor(), canvasHairColor);
			}
		});
		panelColors.add(buttonHairColor);
		
		canvasSkinColor = new Canvas();
		canvasSkinColor.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				character.setSkinColor(canvasSkinColor.getBackground());
			}
		});
		panelColors.add(canvasSkinColor);
		
		canvasHairColor = new Canvas();
		canvasHairColor.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				character.setHairColor(canvasHairColor.getBackground());
			}
		});
		panelColors.add(canvasHairColor);
		
		JPanel panelMiddle = new JPanel();
		panel.add(panelMiddle, BorderLayout.CENTER);
		panelMiddle.setLayout(new BorderLayout(0, 0));
		
		JPanel panelClothing = new JPanel();
		panelMiddle.add(panelClothing, BorderLayout.NORTH);
		panelClothing.setBorder(new TitledBorder(null, "Clothing", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelClothing.setLayout(new GridLayout(8, 3, 20, 2));
		
		JLabel lblClothing = new JLabel("Clothing");
		lblClothing.setHorizontalAlignment(SwingConstants.CENTER);
		panelClothing.add(lblClothing);
		
		JLabel lblChristmasClothing = new JLabel("Christmas Clothing");
		lblChristmasClothing.setHorizontalAlignment(SwingConstants.CENTER);
		panelClothing.add(lblChristmasClothing);
		
		JLabel lblHalloweenClothing = new JLabel("Halloween Clothing");
		lblHalloweenClothing.setHorizontalAlignment(SwingConstants.CENTER);
		panelClothing.add(lblHalloweenClothing);
		
		textFieldShirt = new JTextField();
		textFieldShirt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				Controller.SaveCharacter(character);
			}
		});
		textPrompt = new TextPrompt("Shirt", textFieldShirt);
		textPrompt.changeAlpha(128);
		textFieldShirt.setColumns(10);
		panelClothing.add(textFieldShirt);
		
		textFieldChristmasShirt = new JTextField();
		textPrompt = new TextPrompt("Shirt", textFieldChristmasShirt);
		textPrompt.changeAlpha(128);
		textFieldChristmasShirt.setColumns(10);
		panelClothing.add(textFieldChristmasShirt);
		
		textFieldHalloweenShirt = new JTextField();
		textPrompt = new TextPrompt("Shirt", textFieldHalloweenShirt);
		textPrompt.changeAlpha(128);
		textFieldHalloweenShirt.setColumns(10);
		panelClothing.add(textFieldHalloweenShirt);
		
		textFieldPants = new JTextField();
		textPrompt = new TextPrompt("Pants", textFieldPants);
		textPrompt.changeAlpha(128);
		textFieldPants.setColumns(10);
		panelClothing.add(textFieldPants);
		
		textFieldChristmasPants = new JTextField();
		textPrompt = new TextPrompt("Pants", textFieldChristmasPants);
		textPrompt.changeAlpha(128);
		textFieldChristmasPants.setColumns(10);
		panelClothing.add(textFieldChristmasPants);
		
		textFieldHalloweenPants = new JTextField();
		textPrompt = new TextPrompt("Pants", textFieldHalloweenPants);
		textPrompt.changeAlpha(128);
		textFieldHalloweenPants.setColumns(10);
		panelClothing.add(textFieldHalloweenPants);
		
		textFieldVest = new JTextField();
		textPrompt = new TextPrompt("Vest", textFieldVest);
		textPrompt.changeAlpha(128);
		textFieldVest.setColumns(10);
		panelClothing.add(textFieldVest);
		
		textFieldChristmasVest = new JTextField();
		textPrompt = new TextPrompt("Vest", textFieldChristmasVest);
		textPrompt.changeAlpha(128);
		textFieldChristmasVest.setColumns(10);
		panelClothing.add(textFieldChristmasVest);
		
		textFieldHalloweenVest = new JTextField();
		textPrompt = new TextPrompt("Vest", textFieldHalloweenVest);
		textPrompt.changeAlpha(128);
		textFieldHalloweenVest.setColumns(10);
		panelClothing.add(textFieldHalloweenVest);
		
		textFieldMask = new JTextField();
		textPrompt = new TextPrompt("Mask", textFieldMask);
		textPrompt.changeAlpha(128);
		textFieldMask.setColumns(10);
		panelClothing.add(textFieldMask);
		
		textFieldChristmasMask = new JTextField();
		textPrompt = new TextPrompt("Mask", textFieldChristmasMask);
		textPrompt.changeAlpha(128);
		textFieldChristmasMask.setColumns(10);
		panelClothing.add(textFieldChristmasMask);
		
		textFieldHalloweenMask = new JTextField();
		textPrompt = new TextPrompt("Mask", textFieldHalloweenMask);
		textPrompt.changeAlpha(128);
		textFieldHalloweenMask.setColumns(10);
		panelClothing.add(textFieldHalloweenMask);
		
		textFieldHat = new JTextField();
		textPrompt = new TextPrompt("Hat", textFieldHat);
		textPrompt.changeAlpha(128);
		textFieldHat.setColumns(10);
		panelClothing.add(textFieldHat);
		
		textFieldChristmasHat = new JTextField();
		textPrompt = new TextPrompt("Hat", textFieldChristmasHat);
		textPrompt.changeAlpha(128);
		textFieldChristmasHat.setColumns(10);
		panelClothing.add(textFieldChristmasHat);
		
		textFieldHalloweenHat = new JTextField();
		textPrompt = new TextPrompt("Hat", textFieldHalloweenHat);
		textPrompt.changeAlpha(128);
		textFieldHalloweenHat.setColumns(10);
		panelClothing.add(textFieldHalloweenHat);
		
		textFieldBackpack = new JTextField();
		textPrompt = new TextPrompt("Backpack", textFieldBackpack);
		textPrompt.changeAlpha(128);
		textFieldBackpack.setColumns(10);
		panelClothing.add(textFieldBackpack);
		
		textFieldChristmasBackpack = new JTextField();
		textPrompt = new TextPrompt("Backpack", textFieldChristmasBackpack);
		textPrompt.changeAlpha(128);
		textFieldChristmasBackpack.setColumns(10);
		panelClothing.add(textFieldChristmasBackpack);
		
		textFieldHalloweenBackpack = new JTextField();
		textPrompt = new TextPrompt("Backpack", textFieldHalloweenBackpack);
		textPrompt.changeAlpha(128);
		textFieldHalloweenBackpack.setColumns(10);
		panelClothing.add(textFieldHalloweenBackpack);
		
		textFieldGlasses = new JTextField();
		textPrompt = new TextPrompt("Glasses", textFieldGlasses);
		textPrompt.changeAlpha(128);
		textFieldGlasses.setColumns(10);
		panelClothing.add(textFieldGlasses);
		
		textFieldChristmasGlasses = new JTextField();
		textPrompt = new TextPrompt("Glasses", textFieldChristmasGlasses);
		textPrompt.changeAlpha(128);
		textFieldChristmasGlasses.setColumns(10);
		panelClothing.add(textFieldChristmasGlasses);
		
		textFieldHalloweenGlasses = new JTextField();
		textPrompt = new TextPrompt("Glasses", textFieldHalloweenGlasses);
		textPrompt.changeAlpha(128);
		panelClothing.add(textFieldHalloweenGlasses);
		textFieldHalloweenGlasses.setColumns(10);
		
		panelEquippedAndStance = new JPanel();
		panelMiddle.add(panelEquippedAndStance, BorderLayout.CENTER);
		panelEquippedAndStance.setLayout(new BorderLayout(0, 0));
		
		panelEquipped = new JPanel();
		panelEquippedAndStance.add(panelEquipped, BorderLayout.NORTH);
		panelEquipped.setLayout(new BorderLayout(0, 0));
		
		panelEquippedIDs = new JPanel();
		panelEquipped.add(panelEquippedIDs, BorderLayout.NORTH);
		
		textFieldPrimary = new JTextField();
		panelEquippedIDs.add(textFieldPrimary);
		textFieldPrimary.setColumns(10);
		
		panelHolding = new JPanel();
		panelEquipped.add(panelHolding, BorderLayout.CENTER);
		
		radioButtonPrimary = new JRadioButton("Primary");
		radioButtonPrimary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				character.setEquipped(Equipped.Primary);
			}
		});
		buttonGroup.add(radioButtonPrimary);
		panelHolding.add(radioButtonPrimary);
		
		radioButtonSecondary = new JRadioButton("Secondary");
		radioButtonSecondary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				character.setEquipped(Equipped.Secondary);
			}
		});
		buttonGroup.add(radioButtonSecondary);
		panelHolding.add(radioButtonSecondary);
		
		radioButtonTertiary = new JRadioButton("Tertiary");
		radioButtonTertiary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				character.setEquipped(Equipped.Tertiary);
			}
		});
		buttonGroup.add(radioButtonTertiary);
		panelHolding.add(radioButtonTertiary);
		
		radioButtonNone = new JRadioButton("None");
		radioButtonNone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				character.setEquipped(Equipped.None);
			}
		});
		radioButtonNone.setSelected(true);
		buttonGroup.add(radioButtonNone);
		panelHolding.add(radioButtonNone);
		
		JPanel panelTop = new JPanel();
		panel.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGeneral = new JPanel();
		panelTop.add(panelGeneral);
		panelGeneral.setBorder(new TitledBorder(null, "General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textFieldGUID = new JTextField();
		textPrompt = new TextPrompt("GUID", textFieldGUID);
		textPrompt.changeAlpha(128);
		panelGeneral.setLayout(new GridLayout(0, 3, 0, 0));
		panelGeneral.add(textFieldGUID);
		textFieldGUID.setColumns(10);
		
		textFieldID = new JTextField();
		textPrompt = new TextPrompt("ID", textFieldID);
		textPrompt.changeAlpha(128);
		textFieldID.setColumns(10);
		panelGeneral.add(textFieldID);
		
		textFieldCharacterName = new JTextField();
		textPrompt = new TextPrompt("Character name", textFieldCharacterName);
		textPrompt.changeAlpha(128);
		textFieldCharacterName.setColumns(10);
		panelGeneral.add(textFieldCharacterName);
		
		panelLoadSaveButtons = new JPanel();
		add(panelLoadSaveButtons, BorderLayout.NORTH);
		panelLoadSaveButtons.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton buttonLoad = new JButton("Load");
		panelLoadSaveButtons.add(buttonLoad);
		buttonLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCurrentCharacter((NPCCharacter) controller.LoadFile(self, "npc"));
			}
		});
		
		JButton buttonSave = new JButton("Save");
		panelLoadSaveButtons.add(buttonSave);
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
		});
	}

	protected void setCurrentCharacter(NPCCharacter character) {
		this.character = character;
		
		textFieldGUID.setText(character.getGUID());
		textFieldCharacterName.setText(character.getCharacterName());
		textFieldID.setText(Integer.toString(character.getID()));
		
		//Clothes
		textFieldShirt.setText(character.getShirt());
		textFieldPants.setText(character.getPants());
		textFieldMask.setText(character.getMask());
		textFieldVest.setText(character.getVest());
		textFieldHat.setText(character.getHat());
		textFieldGlasses.setText(character.getGlasses());
		textFieldBackpack.setText(character.getBackpack());
		textFieldChristmasShirt.setText(character.getChristmasShirt());
		textFieldChristmasPants.setText(character.getChristmasPants());
		textFieldChristmasMask.setText(character.getChristmasMask());
		textFieldChristmasVest.setText(character.getChristmasVest());
		textFieldChristmasHat.setText(character.getChristmasHat());
		textFieldChristmasGlasses.setText(character.getChristmasGlasses());
		textFieldChristmasBackpack.setText(character.getChristmasBackpack());
		textFieldHalloweenShirt.setText(character.getHalloweenShirt());
		textFieldHalloweenPants.setText(character.getHalloweenPants());
		textFieldHalloweenMask.setText(character.getHalloweenMask());
		textFieldHalloweenVest.setText(character.getHalloweenVest());
		textFieldHalloweenHat.setText(character.getHalloweenHat());
		textFieldHalloweenGlasses.setText(character.getHalloweenGlasses());
		textFieldHalloweenBackpack.setText(character.getHalloweenBackpack());
		
		//Get colors
		canvasSkinColor.setBackground(character.getSkinColor());
		canvasHairColor.setBackground(character.getHairColor());
		
		//Get hair, face and beard.
		panelDisplaySelector.removeAll();
		faceSelector = new FaceSelector(character);
		panelDisplaySelector.add(faceSelector);
		faceSelector.setVisible(false);
		hairSelector = new HairSelector(character);
		panelDisplaySelector.add(hairSelector);
		hairSelector.setVisible(false);
		beardSelector = new BeardSelector(character);
		panelDisplaySelector.add(beardSelector);
		beardSelector.setVisible(false);
		
	}
}
