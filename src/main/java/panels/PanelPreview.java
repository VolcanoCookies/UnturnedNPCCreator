package panels;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTabbedPane;

public class PanelPreview extends JPanel {

	private JTextArea textAreaPreviewAsset;
	private JTextArea textAreaPreviewEnglish;
	
	/**
	 * Create the panel.
	 */
	public PanelPreview() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		textAreaPreviewAsset = new JTextArea();
		textAreaPreviewAsset.setEditable(false);
		textAreaPreviewAsset.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		tabbedPane.addTab("Asset.dat", null, textAreaPreviewAsset, null);
		
		textAreaPreviewEnglish = new JTextArea();
		textAreaPreviewEnglish.setEditable(false);
		textAreaPreviewEnglish.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		tabbedPane.addTab("English.dat", null, textAreaPreviewEnglish, null);
		
	}
	
	public void setAssetText(String string) {
		textAreaPreviewAsset.setText(string);
	}

	public void setEnglishText(String string) {
		textAreaPreviewEnglish.setText(string);
	}

}
