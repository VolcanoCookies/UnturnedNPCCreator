package windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class InformationDialog extends JDialog {
	static JTextPane textPanelDialog;

	private final JPanel contentPanel = new JPanel();
	private final Action actionExit = new SwingActionExit();
	private static InformationDialog dialog;

	public InformationDialog() {
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			textPanelDialog = new JTextPane();
			textPanelDialog.setEditable(false);
			contentPanel.add(textPanelDialog, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setAction(actionExit);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	public void setText(String string) {
		textPanelDialog.setText(string);
	}
	private class SwingActionExit extends AbstractAction {
		public SwingActionExit() {
			putValue(NAME, "Ok");
			putValue(SHORT_DESCRIPTION, "Boi what should I put here");
		}
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
	}
}
