package dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Controller;
import models.Message;
import models.Settings;
import objects.TextPrompt;

public class MessagePanel extends JPanel {
	
	String index;
	String conditions;
	String rewards;
	
	//Indexes in dialogue file for the responses for this message.
	List<Integer> responseIndexes = new ArrayList<Integer>();
	
	//Array is for pages.
	List<String> text = new ArrayList<String>();
	
	//Index of message to go back to
	int returnMessageIndex = 0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2705985586487282881L;
	private JPanel panelResponses;
	public Component self = this;
	private TextPrompt textPrompt;
	private JTextArea textArea;
	private JTextField textFieldPrevID;
	private Message message;

	/**
	 * Create the panel.
	 * @param messageAsset 
	 * @param messageResponses 
	 * @param messageResponsesEnglish 
	 */
	public MessagePanel(Controller controller, Message passedMessage, DialoguePanel parentPanel) {
		setLayout(new BorderLayout());
		
		message = passedMessage;
		if(message==null)
			message = new Message();
		
		JPopupMenu popupMenu = new JPopupMenu();
		add(popupMenu);
		
		JPanel panelDialogueType = new JPanel();
		add(panelDialogueType, BorderLayout.CENTER);
		panelDialogueType.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		textArea.setMinimumSize(new Dimension(0, 100));
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				message.setText(textArea.getText());
			}
		});
		textArea.setComponentPopupMenu(popupMenu);
		textPrompt = new TextPrompt("Text shown for this message. Separate pages with <p>", textArea);
		textPrompt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPrompt.changeAlpha(128);
		textArea.setLineWrap(true);
		textArea.setToolTipText("Separate pages with <p>");
		panelDialogueType.add(textArea, BorderLayout.CENTER);
		
		JMenuItem menuItemCopyMessage = new JMenuItem("Copy message");
		menuItemCopyMessage.setEnabled(false);
		popupMenu.add(menuItemCopyMessage);
		
		JMenuItem menuItemPasteMessage = new JMenuItem("Paste message");
		menuItemPasteMessage.setEnabled(false);
		popupMenu.add(menuItemPasteMessage);
		
		JSeparator separator_1 = new JSeparator();
		popupMenu.add(separator_1);
		
		JMenuItem menuItemOpenConditions = new JMenuItem("Open conditons");
		menuItemOpenConditions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message.setConditions(controller.OpenConditions(message.getConditions()));
				changeColor();
			}
		});
		popupMenu.add(menuItemOpenConditions);
		
		JMenuItem menuItemClearConditions = new JMenuItem("Clear conditions");
		menuItemClearConditions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ObjButtons[] = {"Yes", "No"};
		    	int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to clear conditions?","Are you sure?",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        	message.setConditions(null);
				changeColor();
			}
		});
		popupMenu.add(menuItemClearConditions);
		
		JSeparator separator = new JSeparator();
		popupMenu.add(separator);
		
		JMenuItem menuItemOpenRewards = new JMenuItem("Open rewards");
		menuItemOpenRewards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message.setConditions(controller.OpenRewards(message.getRewards()));
				changeColor();	
			}
		});
		popupMenu.add(menuItemOpenRewards);
		
		JMenuItem menuItemClearRewards = new JMenuItem("Clear rewards");
		menuItemClearRewards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ObjButtons[] = {"Yes", "No"};
		    	int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to clear rewards?","Are you sure?",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        	message.setRewards(null);
				changeColor();
			}
		});
		popupMenu.add(menuItemClearRewards);
		popupMenu.add(separator);
		
		JMenuItem menuItemRemoveMessage = new JMenuItem("Remove message");
		menuItemRemoveMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentPanel.removeMessage(self);
			}
		});
		popupMenu.add(menuItemRemoveMessage);
		
		JMenuItem menuItemRemoveAll = new JMenuItem("Remove all");
		popupMenu.add(menuItemRemoveAll);
		
		textFieldPrevID = new JTextField();
		textFieldPrevID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				message.setPreviousMessageID(textFieldPrevID.getText());
			}
		});
		textFieldPrevID.setComponentPopupMenu(popupMenu);
		textPrompt = new TextPrompt("Message ID to go back to, usualy doesnt have to be set", textFieldPrevID);
		textPrompt.changeAlpha(128);
		panelDialogueType.add(textFieldPrevID, BorderLayout.SOUTH);
		textFieldPrevID.setColumns(10);
		
		panelResponses = new JPanel();
		panelResponses.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentAdded(ContainerEvent arg0) {
				panelResponses.revalidate();
			}
			@Override
			public void componentRemoved(ContainerEvent e) {
				panelResponses.revalidate();
			}
		});
		panelResponses.setComponentPopupMenu(popupMenu);
		panelResponses.setLayout(new GridLayout(0, 1, 0, 0));
		add(panelResponses, BorderLayout.SOUTH);
		
		reload(message);
	}
	private void reload(Message message) {
		textFieldPrevID.setText(message.getPreviousMessageID());
		
		textArea.setText(message.getText());
		
		changeColor();
	}
	private void changeColor() {
		if(message.getConditions()!=null && message.getRewards()!=null) {
			Color color = Settings.getMixedPresentColor();
			textFieldPrevID.setBackground(color);
			textArea.setBackground(color);
		} else if(message.getConditions()!=null && message.getRewards()==null) {
			Color color = Settings.getConditionsPresentColor();
			textFieldPrevID.setBackground(color);
			textArea.setBackground(color);
		} else if(message.getConditions()==null && message.getRewards()!=null) {
			Color color = Settings.getRewardsPresentColor();
			textFieldPrevID.setBackground(color);
			textArea.setBackground(color);
		} else {
			Color color = new Color(255, 255, 255);
			textFieldPrevID.setBackground(color);
			textArea.setBackground(color);
		}
	}
	public void removeResponse(Component component) {
		panelResponses.remove(component);
	}
	public void removeAllResponses() {
		panelResponses.removeAll();
	}
	public void addResponse(ResponsePanel responsePanel) {
		panelResponses.add(responsePanel);
	}
}
