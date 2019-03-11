package panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import util.OpenURL;
import windows.Window;

public class CreditPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 414615431930729674L;
	private final Action actionBack = new SwingActionBack();

	/**
	 * Create the panel.
	 */
	public CreditPanel() {
		setVisible(false);
		setEnabled(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{111, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 55, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton buttonBack = new JButton("New button");
		buttonBack.setAction(actionBack);
		GridBagConstraints gbc_buttonBack = new GridBagConstraints();
		gbc_buttonBack.anchor = GridBagConstraints.WEST;
		gbc_buttonBack.insets = new Insets(0, 0, 5, 0);
		gbc_buttonBack.gridx = 0;
		gbc_buttonBack.gridy = 0;
		add(buttonBack, gbc_buttonBack);
		
		JLabel lblNewLabel = new JLabel("Credit & Special thanks");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JEditorPane textAppIcon = new JEditorPane();
		textAppIcon.setBackground(new Color(240, 240, 240));
		textAppIcon.setEditable(false);
		textAppIcon.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
		textAppIcon.setAlignmentX(Component.CENTER_ALIGNMENT);
		textAppIcon.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		textAppIcon.setText("Icons used created by\r\n<a href=\"http://www.freepik.com/:C\">Freepik</a>,\r\n<a href=\"https://www.flaticon.com/authors/google\">Google</a>,\r\n<a href=\"https://www.flaticon.com/authors/dave-gandy\">Dave Grandy</a>,\r\n<a href=\"https://www.flaticon.com/authors/bogdan-rosu\">Bogdan Rosu</a>\r\n on www.flaticon.com");
		textAppIcon.addHyperlinkListener(new HyperlinkListener() {
		    public void hyperlinkUpdate(HyperlinkEvent e) {
		        if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
		           OpenURL.openURL(e.getURL().toString());
		        }
		    }
		});
		GridBagConstraints gbc_textAppIcon = new GridBagConstraints();
		gbc_textAppIcon.anchor = GridBagConstraints.NORTH;
		gbc_textAppIcon.gridx = 0;
		gbc_textAppIcon.gridy = 2;
		add(textAppIcon, gbc_textAppIcon);

	}

	private class SwingActionBack extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7920526356264067197L;
		public SwingActionBack() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "Go back to the previous panel.");
		}
		public void actionPerformed(ActionEvent e) {
			Window.Back();
		}
	}
}
