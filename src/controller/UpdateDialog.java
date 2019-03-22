package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import util.OpenURL;

public class UpdateDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4627130886794444353L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public UpdateDialog(String[] input) {
		setAlwaysOnTop(true);
		setModal(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		setResizable(false);
		setTitle("New update!");
		setBounds(100, 100, 275, 230);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    {
		    	dispose();
		    }
		});
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTextPane textPane = new JTextPane();
			textPane.setText("A new update has been found\n"
					+ "Current version: " + input[1]
					+ "\nUploaded: " + input[2]
					+ "\n\nLatest version: " + input[3]
					+ "\nUploaded: " + input[4]
					+ "\n\n\nWould you like to download the latest version?\n Restart will be required.");
			textPane.setEditable(false);
			contentPanel.add(textPane);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton buttonDownload = new JButton("Download");
				buttonDownload.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						OpenURL.openURL(input[0]);
						System.exit(3);
					}
				});
				buttonPane.add(buttonDownload);
				getRootPane().setDefaultButton(buttonDownload);
			}
			{
				JButton buttonSkip = new JButton("Skip");
				buttonSkip.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(buttonSkip);
			}
		}
		setVisible(true);
	}
}
