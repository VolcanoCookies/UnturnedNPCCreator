package dialogues;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Controller;
import models.Dialogue;
import objects.TextPrompt;

public class DialoguePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2242788810946648643L;
	private JTextField textFieldDialogueID;
	private TextPrompt textPrompt;
	private JTabbedPane tabbedPane;
	private DialoguePanel self = this;
	
	/**
	 * Create the panel.
	 * @param object 
	 * @param controller 
	 */
	public DialoguePanel(Controller controller, Dialogue dialogue) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelTop = new JPanel();
		add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panelTop.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton buttonLoad = new JButton("Load");
		panel.add(buttonLoad);
		buttonLoad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonLoad.setFocusPainted(false);
		
		JButton buttonSave = new JButton("Save");
		panel.add(buttonSave);
		buttonSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonSave.setFocusPainted(false);
		
		JPanel panelMid = new JPanel();
		add(panelMid, BorderLayout.CENTER);
		panelMid.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Messages & Responses", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMid.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_1.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMid.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		textFieldDialogueID = new JTextField();
		textPrompt = new TextPrompt("Dialogue ID", textFieldDialogueID);
		textPrompt.changeAlpha(128);
		panel_2.add(textFieldDialogueID);
		textFieldDialogueID.setColumns(10);
		
		JPanel panelBot = new JPanel();
		add(panelBot, BorderLayout.SOUTH);
		panelBot.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton buttonAddMessage = new JButton("Add message");
		buttonAddMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.addTab("Message #" + (tabbedPane.getTabCount() + 1), new MessagePanel(controller, null, self));
			}
		});
		panelBot.add(buttonAddMessage);
		buttonAddMessage.setFocusPainted(false);
		buttonAddMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton buttonAddResponse = new JButton("Add response");
		buttonAddResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((MessagePanel) tabbedPane.getSelectedComponent()).addResponse(new ResponsePanel(controller, null, (JPanel) tabbedPane.getSelectedComponent()));
			}
		});
		panelBot.add(buttonAddResponse);
		buttonAddResponse.setFocusPainted(false);
		buttonAddResponse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton buttonAddGlobalResponse = new JButton("Add global response");
		buttonAddGlobalResponse.setEnabled(false);
		panelBot.add(buttonAddGlobalResponse);
		buttonAddGlobalResponse.setFocusPainted(false);
		buttonAddGlobalResponse.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}
	public void removeResponse(Component component) {
		tabbedPane.remove(component);
	}
	public void removeMessage(Component component) {
		tabbedPane.remove(component);
	}
}
