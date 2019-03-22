package dialogues;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.Controller;

public class ConfirmDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8293223106036048143L;
	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	public ConfirmDialog(Controller controller) {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfirmDialog.class.getResource("/Icons/UIIcons/Icon.png")));
		setBounds(100, 100, 588, 533);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Confirm");
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			contentPanel.add(tabbedPane);
			
			JPanel assetPanel = new JPanel();
			JPanel englishPanel = new JPanel();
			
			tabbedPane.addTab("Assets", assetPanel);
			assetPanel.setLayout(new BorderLayout(0, 0));
			{
				JTextArea textArea = new JTextArea();
				textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
				textArea.setEditable(false);
				assetPanel.add(textArea);
			}
			tabbedPane.addTab("English", englishPanel);
			englishPanel.setLayout(new BorderLayout(0, 0));
			{
				JTextArea textArea = new JTextArea();
				textArea.setFont(new Font("Tahoma", Font.PLAIN, 11));
				textArea.setEditable(false);
				englishPanel.add(textArea, BorderLayout.CENTER);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton confirmButton = new JButton("Confirm");
				confirmButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.save = true;
					}
				});
				confirmButton.setActionCommand("OK");
				buttonPane.add(confirmButton);
				getRootPane().setDefaultButton(confirmButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.save = false;
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}

}
