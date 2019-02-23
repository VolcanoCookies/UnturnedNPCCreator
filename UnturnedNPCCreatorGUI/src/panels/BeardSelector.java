package panels;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class BeardSelector extends JPanel {
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
	
	private String selected;

	/**
	 * Create the panel.
	 */
	public BeardSelector() {
		setLayout(new GridLayout(3, 1, 0, 0));
		
		button0 = new JToggleButton("");
		button0.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "0";
			}
		});
		buttonGroup.add(button0);
		button0.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard0.png")));
		add(button0);
		button0.setSelected(true);
		
		button1 = new JToggleButton("");
		button1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "1";
			}
		});
		buttonGroup.add(button1);
		button1.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard1.png")));
		add(button1);
		
		button2 = new JToggleButton("");
		button2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					if(e.getStateChange()==ItemEvent.SELECTED)
						selected = "2";
			}
		});
		buttonGroup.add(button2);
		button2.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard2.png")));
		add(button2);
		
		button3 = new JToggleButton("");
		button3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "3";
			}
		});
		buttonGroup.add(button3);
		button3.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard3.png")));
		add(button3);
		
		button4 = new JToggleButton("");
		button4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "4";
			}
		});
		buttonGroup.add(button4);
		button4.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard4.png")));
		add(button4);
		
		button5 = new JToggleButton("");
		button5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "5";
			}
		});
		buttonGroup.add(button5);
		button5.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard5.png")));
		add(button5);
		
		button6 = new JToggleButton("");
		button6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "6";
			}
		});
		buttonGroup.add(button6);
		button6.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard6.png")));
		add(button6);
		
		button7 = new JToggleButton("");
		button7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "7";
			}
		});
		buttonGroup.add(button7);
		button7.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard7.png")));
		add(button7);
		
		button8 = new JToggleButton("");
		button8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "8";
			}
		});
		buttonGroup.add(button8);
		button8.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard8.png")));
		add(button8);
		
		button9 = new JToggleButton("");
		button9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "9";
			}
		});
		buttonGroup.add(button9);
		button9.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard9.png")));
		add(button9);
		
		button10 = new JToggleButton("");
		button10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "10";
			}
		});
		buttonGroup.add(button10);
		button10.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard10.png")));
		add(button10);
		
		button11 = new JToggleButton("");
		button11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "11";
			}
		});
		buttonGroup.add(button11);
		button11.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard11.png")));
		add(button11);
		
		button12 = new JToggleButton("");
		button12.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "12";
			}
		});
		buttonGroup.add(button12);
		button12.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard12.png")));
		add(button12);
		
		button13 = new JToggleButton("");
		button13.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "13";
			}
		});
		buttonGroup.add(button13);
		button13.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard13.png")));
		add(button13);
		
		button14 = new JToggleButton("");
		button14.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "14";
			}
		});
		buttonGroup.add(button14);
		button14.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard14.png")));
		add(button14);
		
		button15 = new JToggleButton("");
		button15.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "15";
			}
		});
		buttonGroup.add(button15);
		button15.setIcon(new ImageIcon(BeardSelector.class.getResource("/Icons/Beards/beard15.png")));
		add(button15);
		
		button16 = new JToggleButton("");
		button16.setEnabled(false);
		add(button16);
		
		button17 = new JToggleButton("");
		button17.setEnabled(false);
		add(button17);

	}
	String getBeardID()
	{
		return selected;
	}
	void setBeardID(String id)
	{
		((AbstractButton) getComponents()[Integer.valueOf(id)]).setSelected(true);
	}
}
