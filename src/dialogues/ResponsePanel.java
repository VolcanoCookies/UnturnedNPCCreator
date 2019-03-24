package dialogues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controller.Controller;
import models.Response;
import models.Settings;
import objects.TextPrompt;

public class ResponsePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3010487946578431869L;
	private JTextArea textAreaReply;
	public Component self = this;
	private JTextField textFieldDialogueID;
	private JTextField textFieldQuestID;
	private JTextField textFieldVendorID;
	private TextPrompt textPrompt;
	private Response response;
	private Controller controller;
	/**
	 * Create the panel.
	 * @param response 
	 */
	public ResponsePanel(Controller passedController, Response passedResponse, JPanel parentPanel) {
		setBorder(new TitledBorder(null, "Response", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		response = passedResponse;
		this.controller = passedController;
		if(response==null) {
			response = new Response();
		}
		setLayout(new BorderLayout(0, 0));
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setLabel("");
		add(popupMenu);
		
		JMenuItem menuItemCopyItem = new JMenuItem("Copy item");
		menuItemCopyItem.setEnabled(false);
		popupMenu.add(menuItemCopyItem);
		
		JMenuItem menuItemPasteItem = new JMenuItem("Paste item");
		menuItemPasteItem.setEnabled(false);
		popupMenu.add(menuItemPasteItem);
		
		JSeparator separator_2 = new JSeparator();
		popupMenu.add(separator_2);
		
		JMenuItem menuItemOpenConditions = new JMenuItem("Open conditons");
		menuItemOpenConditions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				response.setConditions(controller.OpenConditions(response.getConditions()));
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
		        	response.setConditions(null);
				changeColor();
			}
		});
		popupMenu.add(menuItemClearConditions);
		
		JSeparator separator = new JSeparator();
		popupMenu.add(separator);
		
		JMenuItem menuItemOpenRewards = new JMenuItem("Open rewards");
		menuItemOpenRewards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				response.setConditions(controller.OpenRewards(response.getRewards()));
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
		        	response.setRewards(null);
				changeColor();
			}
		});
		popupMenu.add(menuItemClearRewards);
		
		JSeparator separator_3 = new JSeparator();
		popupMenu.add(separator_3);
		
		JMenuItem menuItemRemoveResponse = new JMenuItem("Remove response");
		menuItemRemoveResponse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((MessagePanel) parentPanel).removeResponse(self);
			}
		});
		popupMenu.add(menuItemRemoveResponse);
		
		JMenuItem menuItemRemoveAll = new JMenuItem("Remove all");
		menuItemRemoveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ObjButtons[] = {"Yes", "No"};
		    	int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to remove all responses?","Are you sure?",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        	((MessagePanel) parentPanel).removeAllResponses();
			}
		});
		popupMenu.add(menuItemRemoveAll);
		
		JPanel panelOnClick = new JPanel();
		GridBagConstraints gbc_panelOnClick = new GridBagConstraints();
		gbc_panelOnClick.anchor = GridBagConstraints.NORTH;
		gbc_panelOnClick.insets = new Insets(0, 0, 5, 0);
		gbc_panelOnClick.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelOnClick.gridx = 0;
		gbc_panelOnClick.gridy = 1;
		
		textAreaReply = new JTextArea();
		textAreaReply.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				response.setText(textAreaReply.getText());
			}
		});
		textAreaReply.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPrompt = new TextPrompt("Text shown for this button.", textAreaReply);
		textPrompt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPrompt.changeAlpha(128);
		textAreaReply.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textAreaReply.setToolTipText("Separate pages with <p>");
		add(textAreaReply, BorderLayout.CENTER);
		add(panelOnClick, BorderLayout.SOUTH);
		panelOnClick.setLayout(new GridLayout(0, 3, 0, 0));
		
		textFieldDialogueID = new JTextField();
		textFieldDialogueID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				response.setDialogueID(textFieldDialogueID.getText());
			}
		});
		textPrompt = new TextPrompt("Dialogue ID", textFieldDialogueID);
		textPrompt.changeAlpha(128);
		panelOnClick.add(textFieldDialogueID);
		textFieldDialogueID.setColumns(1);
		
		textFieldQuestID = new JTextField();
		textFieldQuestID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				response.setQuestID(textFieldQuestID.getText());
			}
		});
		textPrompt = new TextPrompt("Quest ID", textFieldQuestID);
		textPrompt.changeAlpha(128);
		textFieldQuestID.setColumns(1);
		panelOnClick.add(textFieldQuestID);
		
		textFieldVendorID = new JTextField();
		textFieldVendorID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				response.setVendorID(textFieldVendorID.getText());
			}
		});
		textPrompt = new TextPrompt("Vendor ID", textFieldVendorID);
		textPrompt.changeAlpha(128);
		textFieldVendorID.setColumns(1);
		panelOnClick.add(textFieldVendorID);
		GridBagConstraints gbc_textAreaReply = new GridBagConstraints();
		gbc_textAreaReply.fill = GridBagConstraints.BOTH;
		gbc_textAreaReply.gridx = 0;
		gbc_textAreaReply.gridy = 2;
		
		reload(this.response);
	}
	private void reload(Response response) {
		textAreaReply.setText(response.getText());
		textFieldDialogueID.setText(response.getDialogueID());
		textFieldQuestID.setText(response.getQuestID());
		textFieldVendorID.setText(response.getVendorID());
		
		changeColor();
	}
	private void changeColor() {
		if(response.getConditions()!=null && response.getRewards()!=null) {
			Color color = Settings.getMixedPresentColor();
			textFieldDialogueID.setBackground(color);
			textFieldQuestID.setBackground(color);
			textFieldVendorID.setBackground(color);
			textAreaReply.setBackground(color);
		} else if(response.getConditions()!=null && response.getRewards()==null) {
			Color color = Settings.getConditionsPresentColor();
			textFieldDialogueID.setBackground(color);
			textFieldQuestID.setBackground(color);
			textFieldVendorID.setBackground(color);
			textAreaReply.setBackground(color);
		} else if(response.getConditions()==null && response.getRewards()!=null) {
			Color color = Settings.getRewardsPresentColor();
			textFieldDialogueID.setBackground(color);
			textFieldQuestID.setBackground(color);
			textFieldVendorID.setBackground(color);
			textAreaReply.setBackground(color);
		} else {
			Color color = new Color(255, 255, 255);
			textFieldDialogueID.setBackground(color);
			textFieldQuestID.setBackground(color);
			textFieldVendorID.setBackground(color);
			textAreaReply.setBackground(color);
		}
		revalidate();
	}
}
