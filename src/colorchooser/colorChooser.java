package colorchooser;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class colorChooser extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8900221144290226670L;
	private final JPanel contentPanel = new JPanel();
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private final Action actionReset = new SwingActionReset();
	private final Action actionSave = new SwingActionSave();
	private final Action actionClose = new SwingActionCancel();
	private static JColorChooser cc;
	public Color oldColor;
	private colorChooser comp;
	private JPanel colorPallet;
	private Canvas canvas;

	/**
	 * Create the dialog.
	 * @param characterColor 
	 */
	public colorChooser(Color oldColor, Canvas canvas) {
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
		
		this.oldColor = oldColor;
		this.comp = this;
		this.canvas = canvas;
		
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
		
		colorPallet = new JPanel();
		tabbedPane.add("Pallet", colorPallet);
		GridBagLayout gbl_colorPallet = new GridBagLayout();
		gbl_colorPallet.columnWidths = new int[]{539, 0};
		gbl_colorPallet.rowHeights = new int[]{20, 60, 0, 20, 60, 0};
		gbl_colorPallet.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_colorPallet.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		colorPallet.setLayout(gbl_colorPallet);
		
		JLabel lblSkinColor = new JLabel("Default skin colors");
		lblSkinColor.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblSkinColor = new GridBagConstraints();
		gbc_lblSkinColor.fill = GridBagConstraints.BOTH;
		gbc_lblSkinColor.gridx = 0;
		gbc_lblSkinColor.gridy = 0;
		colorPallet.add(lblSkinColor, gbc_lblSkinColor);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		colorPallet.add(separator, gbc_separator);
		
		JLabel lblDefaultHairColor = new JLabel("Default hair colors");
		lblDefaultHairColor.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDefaultHairColor = new GridBagConstraints();
		gbc_lblDefaultHairColor.fill = GridBagConstraints.BOTH;
		gbc_lblDefaultHairColor.gridx = 0;
		gbc_lblDefaultHairColor.gridy = 3;
		colorPallet.add(lblDefaultHairColor, gbc_lblDefaultHairColor);
		
		GridBagConstraints gbc_1 = new GridBagConstraints();
		gbc_1.fill = GridBagConstraints.BOTH;
		gbc_1.gridy = 1;
		gbc_1.gridx = 0;
		colorPallet.add(new DefaultSkinColor(), gbc_1);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 0;
		colorPallet.add(new DefaultHairColor(), gbc);
		
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
		private static final long serialVersionUID = 4513312730321620901L;
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
		private static final long serialVersionUID = 2352053126563686398L;
		public SwingActionSave() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			canvas.setBackground(cc.getColor());
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
		private static final long serialVersionUID = -5543086408244052127L;
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
class MyPreviewPanel extends JComponent {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 5886245894052585787L;
	Color curColor;
	  public MyPreviewPanel(JColorChooser chooser) {
	    curColor = chooser.getColor();
	    
	    setPreferredSize(new Dimension(50, 50));
	  }
	  public void paint(Graphics g) {
	    g.setColor(curColor);
	    g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
	  }
}
