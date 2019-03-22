package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import colorchooser.DefaultColorChooser;
import models.Settings;

public class SettingsPanel extends JPanel {
	private static final long serialVersionUID = -7339774826108372618L;

	JPanel self = this;
	/**
	 * Create the panel.
	 */
	public SettingsPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelOnStartup = new JPanel();
		panelOnStartup.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "On startup", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panelOnStartup, BorderLayout.NORTH);
		panelOnStartup.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblShouldTheProgram = new JLabel("Check for new updates");
		lblShouldTheProgram.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelOnStartup.add(lblShouldTheProgram);
		
		JButton buttonUpdateCheck = new JButton();
		if(Settings.checkForUpdates())
			buttonUpdateCheck.setText("True");
		else
			buttonUpdateCheck.setText("False");
		buttonUpdateCheck.setFocusPainted(false);
		buttonUpdateCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.checkForUpdates(!Settings.checkForUpdates());
				if(Settings.checkForUpdates())
					buttonUpdateCheck.setText("True");
				else
					buttonUpdateCheck.setText("False");
			}
		});
		panelOnStartup.add(buttonUpdateCheck);
		
		JButton buttonSave = new JButton("Save settings");
		buttonSave.setFocusPainted(false);
		buttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.save();
			}
		});
		add(buttonSave, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelGeneral = new JPanel();
		panelGeneral.setBorder(new TitledBorder(null, "General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panelGeneral, BorderLayout.NORTH);
		panelGeneral.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblConfirmationBeforeQuitting = new JLabel("Confirmation before quitting");
		lblConfirmationBeforeQuitting.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelGeneral.add(lblConfirmationBeforeQuitting);
		
		JButton buttonExitConfirmation = new JButton();
		if(Settings.ExitConfirmation())
			buttonExitConfirmation.setText("True");
		else
			buttonExitConfirmation.setText("False");
		buttonExitConfirmation.setFocusPainted(false);
		buttonExitConfirmation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Settings.ExitConfirmation(!Settings.ExitConfirmation());
				if(Settings.ExitConfirmation())
					buttonExitConfirmation.setText("True");
				else
					buttonExitConfirmation.setText("False");
			}
		});
		panelGeneral.add(buttonExitConfirmation);
		
		JLabel lblNewLabel = new JLabel("Color of a panel if conditions are present");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelGeneral.add(lblNewLabel);
		
		JButton buttonConditionColor = new JButton("Conditions color");
		buttonConditionColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DefaultColorChooser(Settings.getConditionsPresentColor(), "conditions");
			}
		});
		panelGeneral.add(buttonConditionColor);
		
		JLabel lblNewLabel_1 = new JLabel("Color of a panel if rewards are present");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelGeneral.add(lblNewLabel_1);
		
		JButton buttonRewardsColor = new JButton("Rewards color");
		buttonRewardsColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DefaultColorChooser(Settings.getConditionsPresentColor(), "rewards");
			}
		});
		panelGeneral.add(buttonRewardsColor);
		
		JLabel lblNewLabel_2 = new JLabel("Color of a panel if both are present");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelGeneral.add(lblNewLabel_2);
		
		JButton buttonBothColor = new JButton("Both color");
		buttonBothColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DefaultColorChooser(Settings.getConditionsPresentColor(), "both");
			}
		});
		panelGeneral.add(buttonBothColor);
	}
}
