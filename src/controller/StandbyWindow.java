package controller;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class StandbyWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1007024542166279343L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StandbyWindow dialog = new StandbyWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StandbyWindow() {
		setBounds(100, 100, 271, 84);
		
		JLabel lblNewLabel = new JLabel("Loading...");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JProgressBar progressBar = new JProgressBar();
		panel.add(progressBar);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
