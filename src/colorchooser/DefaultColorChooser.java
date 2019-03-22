package colorchooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import models.Settings;

public class DefaultColorChooser extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4632186616287026075L;
	private final JPanel contentPanel = new JPanel();
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private final Action actionReset = new SwingActionReset();
	private final Action actionSave = new SwingActionSave();
	private final Action actionClose = new SwingActionCancel();
	private static JColorChooser cc;
	public Color oldColor;
	private DefaultColorChooser comp;
	private String type;

	/**
	 * Create the dialog.
	 * @param characterColor 
	 */
	public DefaultColorChooser(Color oldColor, String type) {
		setModalityType(ModalityType.APPLICATION_MODAL);
		requestFocus();
		toFront();
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    {
		    	try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
		        comp.dispose();
		    }
		});
		
		this.type = type;
		this.oldColor = oldColor;
		this.comp = this;
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		setBounds(100, 100, 570, 396);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 50, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		contentPanel.add(tabbedPane, gbc_tabbedPane);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPanel.add(panel, gbc_panel);
		
		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new GridLayout(0, 3, 0, 0));
	
		JButton buttonSave = new JButton("Save");
		buttonSave.setAction(actionSave);
		buttonSave.setActionCommand("OK");
		buttonPane.add(buttonSave);
		getRootPane().setDefaultButton(buttonSave);
		
		JButton buttonReset = new JButton("New button");
		buttonReset.setAction(actionReset);
		buttonPane.add(buttonReset);
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setAction(actionClose);
		buttonCancel.setActionCommand("Cancel");
		buttonPane.add(buttonCancel);
		
		cc = new JColorChooser(oldColor);
		
		final MyPreviewPanel prev = new MyPreviewPanel(cc);
		cc.setPreviewPanel(prev);
		
		ColorSelectionModel model = cc.getSelectionModel();
		model.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				ColorSelectionModel model = (ColorSelectionModel) evt.getSource();
				prev.curColor = model.getSelectedColor();
			}
		});
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.add(prev);
		
		for(int i = 1; i < cc.getChooserPanels().length; i++)
			tabbedPane.addTab(cc.getChooserPanels()[i].getDisplayName(), cc.getChooserPanels()[i]);
		
		setVisible(true);
	}

	private class SwingActionReset extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 9192276503258448882L;
		public SwingActionReset() {
			putValue(NAME, "Reset");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			cc.setColor(oldColor);
		}
	}
	private class SwingActionSave extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2919154210274232891L;
		public SwingActionSave() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			if(type.equals("conditions"))
				Settings.setConditionsPresentColor(cc.getColor());
			else if(type.equals("rewards"))
				Settings.setRewardsPresentColor(cc.getColor());
			else if(type.equals("both"))
				Settings.setMixedPresentColor(cc.getColor());
			
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
			comp.dispose();
		}
	}
	private class SwingActionCancel extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1291719610407041316L;
		public SwingActionCancel() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			};
			comp.dispose();
		}
	}
	public static JColorChooser getChooser() {
		return cc;
	}
}