package character;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import models.NPCCharacter;

public class HairSelector extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton button0;
	private JToggleButton button1;
	private JToggleButton button2;
	private JToggleButton button3;
	private JToggleButton button4;
	private JToggleButton button5;
	private JToggleButton button6;
	private JToggleButton button7;
	private JToggleButton button8;
	private JToggleButton button9;
	private JToggleButton button10;
	private JToggleButton button11;
	private JToggleButton button12;
	private JToggleButton button13;
	private JToggleButton button14;
	private JToggleButton button15;
	private JToggleButton button16;
	private JToggleButton button17;
	private JToggleButton button18;
	private JToggleButton button19;
	private JToggleButton button20;
	private JToggleButton button21;
	private JToggleButton button22;
	private JToggleButton button23;

	/**
	 * Create the panel.
	 */
	public HairSelector(NPCCharacter character) {
		setLayout(new GridLayout(4, 1, 0, 0));
		
		button0 = new JToggleButton("");
		button0.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("0");
			}
		});
		buttonGroup.add(button0);
		button0.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair0.png")));
		add(button0);
		button0.setSelected(true);
		
		button1 = new JToggleButton("");
		button1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("1");
			}
		});
		buttonGroup.add(button1);
		button1.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair1.png")));
		add(button1);
		
		button2 = new JToggleButton("");
		button2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					if(e.getStateChange()==ItemEvent.SELECTED)
						character.setHair("2");
			}
		});
		buttonGroup.add(button2);
		button2.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair2.png")));
		add(button2);
		
		button3 = new JToggleButton("");
		button3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("3");
			}
		});
		buttonGroup.add(button3);
		button3.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair3.png")));
		add(button3);
		
		button4 = new JToggleButton("");
		button4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("4");
			}
		});
		buttonGroup.add(button4);
		button4.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair4.png")));
		add(button4);
		
		button5 = new JToggleButton("");
		button5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("5");
			}
		});
		buttonGroup.add(button5);
		button5.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair5.png")));
		add(button5);
		
		button6 = new JToggleButton("");
		button6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("6");
			}
		});
		buttonGroup.add(button6);
		button6.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair6.png")));
		add(button6);
		
		button7 = new JToggleButton("");
		button7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("7");
			}
		});
		buttonGroup.add(button7);
		button7.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair7.png")));
		add(button7);
		
		button8 = new JToggleButton("");
		button8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("8");
			}
		});
		buttonGroup.add(button8);
		button8.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair8.png")));
		add(button8);
		
		button9 = new JToggleButton("");
		button9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("9");
			}
		});
		buttonGroup.add(button9);
		button9.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair9.png")));
		add(button9);
		
		button10 = new JToggleButton("");
		button10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("10");
			}
		});
		buttonGroup.add(button10);
		button10.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair10.png")));
		add(button10);
		
		button11 = new JToggleButton("");
		button11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("11");
			}
		});
		buttonGroup.add(button11);
		button11.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair11.png")));
		add(button11);
		
		button12 = new JToggleButton("");
		button12.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("12");
			}
		});
		buttonGroup.add(button12);
		button12.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair12.png")));
		add(button12);
		
		button13 = new JToggleButton("");
		button13.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("13");
			}
		});
		buttonGroup.add(button13);
		button13.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair13.png")));
		add(button13);
		
		button14 = new JToggleButton("");
		button14.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("14");
			}
		});
		buttonGroup.add(button14);
		button14.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair14.png")));
		add(button14);
		
		button15 = new JToggleButton("");
		button15.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("15");
			}
		});
		buttonGroup.add(button15);
		button15.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair15.png")));
		add(button15);
		
		button16 = new JToggleButton("");
		button16.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("16");
			}
		});
		buttonGroup.add(button16);
		button16.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair16.png")));
		add(button16);
		
		button17 = new JToggleButton("");
		button17.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("17");
			}
		});
		buttonGroup.add(button17);
		button17.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair17.png")));
		add(button17);
		
		button18 = new JToggleButton("");
		button18.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("18");
			}
		});
		buttonGroup.add(button18);
		button18.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair18.png")));
		add(button18);
		
		button19 = new JToggleButton("");
		button19.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("19");
			}
		});
		buttonGroup.add(button19);
		button19.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair19.png")));
		add(button19);
		
		button20 = new JToggleButton("");
		button20.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("20");
			}
		});
		buttonGroup.add(button20);
		button20.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair20.png")));
		add(button20);
		
		button21 = new JToggleButton("");
		button21.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("21");
			}
		});
		buttonGroup.add(button21);
		button21.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair21.png")));
		add(button21);
		
		button22 = new JToggleButton("");
		button22.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					character.setHair("22");
			}
		});
		buttonGroup.add(button22);
		button22.setIcon(new ImageIcon(HairSelector.class.getResource("/Icons/Hairs/hair22.png")));
		add(button22);
		
		button23 = new JToggleButton("");
		button23.setEnabled(false);
		add(button23);
		
		((AbstractButton) getComponents()[Integer.valueOf(character.getHair())]).setSelected(true);
	}
}
