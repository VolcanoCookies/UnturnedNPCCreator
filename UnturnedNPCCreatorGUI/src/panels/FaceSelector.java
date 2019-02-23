package panels;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class FaceSelector extends JPanel {
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
	private JToggleButton button24; 
	private JToggleButton button25;
	private JToggleButton button26;
	private JToggleButton button27;
	private JToggleButton button28;
	private JToggleButton button29;
	private JToggleButton button30;
	private JToggleButton button31;
	
	private String selected;

	/**
	 * Create the panel.
	 */
	public FaceSelector() {
		setLayout(new GridLayout(6, 1, 0, 0));
		
		button0 = new JToggleButton("");
		button0.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "0";
			}
		});
		buttonGroup.add(button0);
		button0.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face0.png")));
		button0.setSelected(true);
		add(button0);
		
		button1 = new JToggleButton("");
		button1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "1";
			}
		});
		buttonGroup.add(button1);
		button1.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face1.png")));
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
		button2.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face2.png")));
		add(button2);
		
		button3 = new JToggleButton("");
		button3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "3";
			}
		});
		buttonGroup.add(button3);
		button3.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face3.png")));
		add(button3);
		
		button4 = new JToggleButton("");
		button4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "4";
			}
		});
		buttonGroup.add(button4);
		button4.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face4.png")));
		add(button4);
		
		button5 = new JToggleButton("");
		button5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "5";
			}
		});
		buttonGroup.add(button5);
		button5.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face5.png")));
		add(button5);
		
		button6 = new JToggleButton("");
		button6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "6";
			}
		});
		buttonGroup.add(button6);
		button6.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face6.png")));
		add(button6);
		
		button7 = new JToggleButton("");
		button7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "7";
			}
		});
		buttonGroup.add(button7);
		button7.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face7.png")));
		add(button7);
		
		button8 = new JToggleButton("");
		button8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "8";
			}
		});
		buttonGroup.add(button8);
		button8.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face8.png")));
		add(button8);
		
		button9 = new JToggleButton("");
		button9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "9";
			}
		});
		buttonGroup.add(button9);
		button9.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face9.png")));
		add(button9);
		
		button10 = new JToggleButton("");
		button10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "10";
			}
		});
		buttonGroup.add(button10);
		button10.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face10.png")));
		add(button10);
		
		button11 = new JToggleButton("");
		button11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "11";
			}
		});
		buttonGroup.add(button11);
		button11.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face11.png")));
		add(button11);
		
		button12 = new JToggleButton("");
		button12.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "12";
			}
		});
		buttonGroup.add(button12);
		button12.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face12.png")));
		add(button12);
		
		button13 = new JToggleButton("");
		button13.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "13";
			}
		});
		buttonGroup.add(button13);
		button13.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face13.png")));
		add(button13);
		
		button14 = new JToggleButton("");
		button14.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "14";
			}
		});
		buttonGroup.add(button14);
		button14.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face14.png")));
		add(button14);
		
		button15 = new JToggleButton("");
		button15.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "15";
			}
		});
		buttonGroup.add(button15);
		button15.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face15.png")));
		add(button15);
		
		button16 = new JToggleButton("");
		button16.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "16";
			}
		});
		buttonGroup.add(button16);
		button16.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face16.png")));
		add(button16);
		
		button17 = new JToggleButton("");
		button17.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "17";
			}
		});
		buttonGroup.add(button17);
		button17.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face17.png")));
		add(button17);
		
		button18 = new JToggleButton("");
		button18.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "18";
			}
		});
		buttonGroup.add(button18);
		button18.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face18.png")));
		add(button18);
		
		button19 = new JToggleButton("");
		button19.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "19";
			}
		});
		buttonGroup.add(button19);
		button19.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face19.png")));
		add(button19);
		
		button20 = new JToggleButton("");
		button20.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "20";
			}
		});
		buttonGroup.add(button20);
		button20.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face20.png")));
		add(button20);
		
		button21 = new JToggleButton("");
		button21.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "21";
			}
		});
		buttonGroup.add(button21);
		button21.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face21.png")));
		add(button21);
		
		button22 = new JToggleButton("");
		button22.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "22";
			}
		});
		buttonGroup.add(button22);
		button22.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face22.png")));
		add(button22);
		
		button23 = new JToggleButton("");
		button23.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "23";
			}
		});
		buttonGroup.add(button23);
		button23.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face23.png")));
		add(button23);
		
		button24 = new JToggleButton("");
		button24.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "24";
			}
		});
		buttonGroup.add(button24);
		button24.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face24.png")));
		add(button24);
		
		button25 = new JToggleButton("");
		button25.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "25";
			}
		});
		buttonGroup.add(button25);
		button25.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face25.png")));
		add(button25);
		
		button26 = new JToggleButton("");
		button26.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "26";
			}
		});
		buttonGroup.add(button26);
		button26.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face26.png")));
		add(button26);
		
		button27 = new JToggleButton("");
		button27.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "27";
			}
		});
		buttonGroup.add(button27);
		button27.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face27.png")));
		add(button27);
		
		button28 = new JToggleButton("");
		button28.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "28";
			}
		});
		buttonGroup.add(button28);
		button28.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face28.png")));
		add(button28);
		
		button29 = new JToggleButton("");
		button29.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "29";
			}
		});
		buttonGroup.add(button29);
		button29.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face29.png")));
		add(button29);
		
		button30 = new JToggleButton("");
		button30.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "30";
			}
		});
		buttonGroup.add(button30);
		button30.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face30.png")));
		add(button30);
		
		button31 = new JToggleButton("");
		button31.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED)
					selected = "31";
			}
		});
		buttonGroup.add(button31);
		button31.setIcon(new ImageIcon(FaceSelector.class.getResource("/Icons/Faces/face31.png")));
		add(button31);
		
		JToggleButton toggleButton_29 = new JToggleButton("");
		toggleButton_29.setEnabled(false);
		buttonGroup.add(toggleButton_29);
		add(toggleButton_29);
		
		JToggleButton toggleButton_30 = new JToggleButton("");
		toggleButton_30.setEnabled(false);
		add(toggleButton_30);
		
		JToggleButton toggleButton_31 = new JToggleButton("");
		toggleButton_31.setEnabled(false);
		add(toggleButton_31);
		
		JToggleButton toggleButton_32 = new JToggleButton("");
		toggleButton_32.setEnabled(false);
		add(toggleButton_32);

	}
	String getFaceID()
	{
		return selected;
	}
	void setFaceID(String id)
	{
		((AbstractButton) getComponents()[Integer.valueOf(id)]).setSelected(true);
	}
}
