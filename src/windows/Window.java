package windows;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import character.CharacterPanel;
import dialogues.DialoguePanel;
import panels.CreditPanel;
import panels.ExplorerPanel;
import panels.SettingsPanel;
import processing.CheckIDConflict;
import util.Init;
import util.OpenURL;
import vendor.VendorPanel;

public class Window extends JFrame { 
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 351755526376897220L;
	private static JPanel contentPane;
	public static String currentPath;
	public static String runningPath;
	private static SettingsPanel settingsPanel;
	private static CreditPanel creditPanel;
	private final Action actionExit = new SwingActionExit();
	private final Action actionOpenTrello = new SwingActionOpenTrello();
	private final Action actionOpenIDList = new SwingActionOpenIDList();
	private final Action actionSettings = new SwingActionSettings();
	private final Action actionOpenDiscord = new SwingActionOpenDiscord();
	private final Action actionOpenCredits = new SwingActionOpenCredits();
	private final Action actionReadMeGuide = new SwingActionReadMeGuide();
	private final Action actionOpenDiscordBug = new SwingActionOpenDiscordBug();
	public static JPanel panelEditors;
	
	public final static Color BACKGROUNDCOLOR = Color.decode("#252120");
	public final static Color BUTTONSELECTED = Color.decode("#1B1818");
	public final static Color REDCOLOR = Color.decode("#A92F41");
	public final static Color DARKERBACKGROUNDCOLOR = Color.decode("#1E1A1A");
	public final static Color FONTCOLOR = Color.decode("#E5DFC5");
	protected JComponent panelExplorer;
	public static JPanel panelVendors;
	private JPanel panelFindID;
	private JPanel panelDialogues;
	public static JPanel panelCharacters;
	
//	public static MetalButtonUI mbui = new MetalButtonUI();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getBundlesPath();
					System.out.println(runningPath);
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
        setTitle("Unturned NPC Creator");
		setBounds(100, 100, 875, 600);
		setResizable(true);
		new Init();
		try {
			setIconImage(ImageIO.read(Window.class.getResource("/Icons/UIIcons/BTWIcon.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
//		    	JButton No = new JButton("No");
//		    	JButton Yes = new JButton("Yes");
//		    	No.setFocusPainted(false);
//		    	Yes.setFocusPainted(false);
//		    	JButton ObjButtons[] = {No, Yes};
		        
		    	String ObjButtons[] = {"Yes", "No"};
		    	int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Are you sure?",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});
		setLocationRelativeTo(null);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
//		UIManager.put("MenuBarUI", "javax.swing.plaf.metal.MetalMenuBarUI");
//		UIManager.put("MenuBar.background", DARKERBACKGROUNDCOLOR);
//		UIManager.put("MenuBar.BorderPainted", false);
//		UIManager.put("Menu.background", BACKGROUNDCOLOR);
//		UIManager.put("Menu.foreground", FONTCOLOR);
//		UIManager.put("Menu.opaque", true);
//		UIManager.put("MenuItem.background", BACKGROUNDCOLOR);
//		UIManager.put("MenuItem.opaque", true);
//		UIManager.put("MenuItem.foreground", FONTCOLOR);
//		UIManager.put("Panel.background", BACKGROUNDCOLOR);
//		UIManager.put("Label.foreground", FONTCOLOR);
//		UIManager.put("RadioButton.foreground", FONTCOLOR);
//		UIManager.put("Togglebutton.foreground", FONTCOLOR);
//		UIManager.put("Button.foreground", FONTCOLOR);
//		UIManager.put("RadioButton.background", BACKGROUNDCOLOR);
//		UIManager.put("Togglebutton.background", BACKGROUNDCOLOR);
//		UIManager.put("Button.background", DARKERBACKGROUNDCOLOR);
//		UIManager.put("Tree.background", BACKGROUNDCOLOR);
//		UIManager.put("Button.highlight", FONTCOLOR);
//		UIManager.put("RadioButton.opaque", true);
//		UIManager.put("Togglebutton.opaque", true);
//		UIManager.put("RadioButton.opaque", true);
//		UIManager.put("ButtonUI", "javax.swing.plaf.metal.MetalButtonUI");
//		UIManager.put("OptionPane.foreground", BACKGROUNDCOLOR);
//		UIManager.put("OptionPane.background", BACKGROUNDCOLOR);
//		UIManager.put("Button.select", DARKERBACKGROUNDCOLOR);
//		UIManager.put("label.foreground", FONTCOLOR);
//		UIManager.put("label.background", BACKGROUNDCOLOR);
//		UIManager.put("laber.opaque", true);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuItemSettings = new JMenuItem("Settings");
		menuItemSettings.setAction(actionSettings);
		menuFile.add(menuItemSettings);
		
		JMenuItem menuItemTrello = new JMenuItem("Trello Roadmap");
		menuItemTrello.setAction(actionOpenTrello);
		menuFile.add(menuItemTrello);
		
		JMenuItem menuItemDiscord = new JMenuItem("Discord");
		menuItemDiscord.setAction(actionOpenDiscord);
		menuFile.add(menuItemDiscord);
		
		JMenuItem menuItemIDList = new JMenuItem("ID List");
		menuItemIDList.setAction(actionOpenIDList);
		menuFile.add(menuItemIDList);
		
		JMenuItem menuItemCredits = new JMenuItem("Credits");
		menuItemCredits.setAction(actionOpenCredits);
		menuFile.add(menuItemCredits);
		
		JMenuItem menuItemReportBug = new JMenuItem("Report bugs");
		menuItemReportBug.setAction(actionOpenDiscordBug);
		menuFile.add(menuItemReportBug);
		
		JMenuItem menuItemQuit = new JMenuItem("Exit");
		menuItemQuit.setAction(actionExit);
		menuFile.add(menuItemQuit);
		
		JMenu menuGuide = new JMenu("Guide");
		menuBar.add(menuGuide);
		
		JLabel lblInProgress = new JLabel("In progress");
		lblInProgress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInProgress.setHorizontalAlignment(SwingConstants.CENTER);
		menuGuide.add(lblInProgress);
		
		JMenuItem menuItemGuide = new JMenuItem("text");
		menuItemGuide.setAction(actionReadMeGuide);
		menuGuide.add(menuItemGuide);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel selectorPanel = new JPanel();
		contentPane.add(selectorPanel, BorderLayout.WEST);
		GridBagLayout gbl_selectorPanel = new GridBagLayout();
		gbl_selectorPanel.columnWidths = new int[]{11, 0};
		gbl_selectorPanel.rowHeights = new int[]{116, 35, 35, 0, 35, 35, 0};
		gbl_selectorPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_selectorPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		selectorPanel.setLayout(gbl_selectorPanel);
		
		JButton buttonIcon = new JButton();
		buttonIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				buttonIcon.setIcon(new ImageIcon(Window.class.getResource("/Icons/UIIcons/BTWIconHover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buttonIcon.setIcon(new ImageIcon(Window.class.getResource("/Icons/UIIcons/BTWIcon.png")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Component panel : panelEditors.getComponents())
				{
					panel.setVisible(false);
					panel.setEnabled(false);
				}
				panelExplorer.setVisible(true);
				panelExplorer.setEnabled(true);
			}
		});
		buttonIcon.setBorderPainted(false);
		buttonIcon.setFocusPainted(false);
		buttonIcon.setContentAreaFilled(false);
		buttonIcon.setBackground(Color.WHITE);
		buttonIcon.setIcon(new ImageIcon(Window.class.getResource("/Icons/UIIcons/BTWIcon.png")));
		buttonIcon.setSize(new Dimension(100,100));
		GridBagConstraints gbc_buttonIcon = new GridBagConstraints();
		gbc_buttonIcon.insets = new Insets(0, 0, 5, 0);
		buttonIcon.setSize(new Dimension(100,100));
		gbc_buttonIcon.fill = GridBagConstraints.BOTH;
		gbc_buttonIcon.gridx = 0;
		gbc_buttonIcon.gridy = 0;
		selectorPanel.add(buttonIcon, gbc_buttonIcon);
		
		JButton buttonCharacters = new JButton("Characters");
//		buttonCharacters.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				buttonCharacters.setBackground(BUTTONSELECTED);
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				buttonCharacters.setBackground(DARKERBACKGROUNDCOLOR);
//			}
//		});
		buttonCharacters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Component panel : panelEditors.getComponents())
				{
					panel.setVisible(false);
					panel.setEnabled(false);
				}
				panelCharacters.setVisible(true);
				panelCharacters.setEnabled(true);
			}
		});
		buttonCharacters.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		GridBagConstraints gbc_buttonCharacters = new GridBagConstraints();
		gbc_buttonCharacters.insets = new Insets(0, 0, 5, 0);
		gbc_buttonCharacters.fill = GridBagConstraints.BOTH;
		gbc_buttonCharacters.gridx = 0;
		gbc_buttonCharacters.gridy = 1;
		selectorPanel.add(buttonCharacters, gbc_buttonCharacters);
		
		JButton buttonVendors = new JButton("Vendors");
//		buttonVendors.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				buttonVendors.setBackground(BUTTONSELECTED);
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				buttonVendors.setBackground(DARKERBACKGROUNDCOLOR);
//			}
//		});
		buttonVendors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Component panel : panelEditors.getComponents())
				{
					panel.setVisible(false);
					panel.setEnabled(false);
				}
				panelVendors.setVisible(true);
				panelVendors.setEnabled(true);
			}
		});
		buttonVendors.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		GridBagConstraints gbc_buttonVendors = new GridBagConstraints();
		gbc_buttonVendors.insets = new Insets(0, 0, 5, 0);
		gbc_buttonVendors.fill = GridBagConstraints.BOTH;
		gbc_buttonVendors.gridx = 0;
		gbc_buttonVendors.gridy = 2;
		selectorPanel.add(buttonVendors, gbc_buttonVendors);
		
		JButton buttonDialogues = new JButton("Dialogues");
		buttonDialogues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(Component panel : panelEditors.getComponents())
				{
					panel.setVisible(false);
					panel.setEnabled(false);
				}
				panelDialogues.setVisible(true);
				panelDialogues.setEnabled(true);
			}
		});
		buttonDialogues.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		GridBagConstraints gbc_buttonDialogues = new GridBagConstraints();
		gbc_buttonDialogues.insets = new Insets(0, 0, 5, 0);
		gbc_buttonDialogues.fill = GridBagConstraints.BOTH;
		gbc_buttonDialogues.gridx = 0;
		gbc_buttonDialogues.gridy = 3;
		selectorPanel.add(buttonDialogues, gbc_buttonDialogues);
		
		JButton buttonIDFinder = new JButton("Find ID");
		buttonIDFinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component panel : panelEditors.getComponents())
				{
					panel.setVisible(false);
					panel.setEnabled(false);
				}
				panelFindID.setVisible(true);
				panelFindID.setEnabled(true);
			}
		});
		buttonIDFinder.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
		GridBagConstraints gbc_buttonIDFinder = new GridBagConstraints();
		gbc_buttonIDFinder.fill = GridBagConstraints.BOTH;
		gbc_buttonIDFinder.insets = new Insets(0, 0, 5, 0);
		gbc_buttonIDFinder.gridx = 0;
		gbc_buttonIDFinder.gridy = 4;
		selectorPanel.add(buttonIDFinder, gbc_buttonIDFinder);
		
//		JButton buttonQuests = new JButton("Quests");
//		buttonQuests.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				buttonQuests.setBackground(BUTTONSELECTED);
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				buttonQuests.setBackground(DARKERBACKGROUNDCOLOR);
//			}
//		});
//		buttonQuests.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		buttonQuests.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
//		GridBagConstraints gbc_buttonQuests = new GridBagConstraints();
//		gbc_buttonQuests.fill = GridBagConstraints.BOTH;
//		gbc_buttonQuests.gridx = 0;
//		gbc_buttonQuests.gridy = 4;
//		selectorPanel.add(buttonQuests, gbc_buttonQuests);
//		
		panelEditors = new JPanel();
		contentPane.add(panelEditors);
		panelEditors.setLayout(new CardLayout(0, 0));
		
		panelExplorer = new JPanel();
		panelExplorer.setLayout(new BorderLayout(0, 0));
		panelExplorer.add(new ExplorerPanel());
		panelEditors.add(panelExplorer, "name_264979666330042");
		
		panelFindID = new JPanel();
		panelFindID.setLayout(new BorderLayout(0, 0));
		panelFindID.add(new CheckIDConflict());
		panelEditors.add(panelFindID, "name_264847566330042");

		panelDialogues = new JPanel();
		panelDialogues.setLayout(new BorderLayout(0, 0));
		panelDialogues.add(new DialoguePanel());
		panelEditors.add(panelDialogues, "name_264847566937042");
		
		panelCharacters = new JPanel();
		panelEditors.add(panelCharacters, "name_263821186916050");
		panelCharacters.setLayout(new BorderLayout(0, 0));
		panelCharacters.add(new CharacterPanel());
		
		panelVendors = new JPanel();
		panelEditors.add(panelVendors, "name_263826406939550");
		panelVendors.setLayout(new BorderLayout(0, 0));
		panelVendors.add(new VendorPanel());
		settingsPanel = new SettingsPanel();
		panelEditors.add(settingsPanel, "name_261787332516570");
		creditPanel = new CreditPanel();
		panelEditors.add(creditPanel, "name_261787345179725");
	}
	private class SwingActionExit extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -469162033349655540L;
		public SwingActionExit() {
			putValue(NAME, "Quit");
			putValue(SHORT_DESCRIPTION, "Exit the program.");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	private class SwingActionOpenTrello extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2117469150096204951L;
		public SwingActionOpenTrello() {
			putValue(NAME, "Trello Roadmap");
			putValue(SHORT_DESCRIPTION, "Open the Trello roadmap.");
		}
		public void actionPerformed(ActionEvent e) {
			OpenURL.OpenURL("https://trello.com/b/ZMTN0JtW/unturned-npc-creator");
		}
	}
	private class SwingActionOpenIDList extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 6439517563189432980L;
		public SwingActionOpenIDList() {
			putValue(NAME, "ID List");
			putValue(SHORT_DESCRIPTION, "Open ID list in browser.");
		}
		public void actionPerformed(ActionEvent e) {
			OpenURL.OpenURL("https://unturneditems.com/");
		}
	}
	private static void getBundlesPath()
	{
		runningPath = Window.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		runningPath = System.getProperty("user.dir");
		//		if(runningPath.contains("bin"))
//			runningPath = runningPath.substring(1, runningPath.indexOf("UnturnedNPCCreator")+18);
//		else
//			runningPath = runningPath.substring(1, runningPath.length()-22);
	}
	private class SwingActionSettings extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 6116259081323481186L;
		public SwingActionSettings() {
			putValue(NAME, "Settings");
			putValue(SHORT_DESCRIPTION, "Open the settings.");
		}
		public void actionPerformed(ActionEvent e) {
			for(Component panel : panelEditors.getComponents())
			{
				panel.setVisible(false);
				panel.setEnabled(false);
			}
			settingsPanel.setVisible(true);
			settingsPanel.setEnabled(true);
			contentPane.revalidate();
			contentPane.repaint();
		}
	}
	private class SwingActionOpenDiscord extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2402886478978185026L;
		public SwingActionOpenDiscord() {
			putValue(NAME, "Discord");
			putValue(SHORT_DESCRIPTION, "Join the support discord server!");
		}
		public void actionPerformed(ActionEvent e) {
			OpenURL.OpenURL("https://discord.gg/BhJM5ve");
		}
	}
	private class SwingActionOpenCredits extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4752640338493622273L;
		public SwingActionOpenCredits() {
			putValue(NAME, "Credits");
			putValue(SHORT_DESCRIPTION, "Open the credits window.");
		}
		public void actionPerformed(ActionEvent e) {
			for(Component panel : panelEditors.getComponents())
			{
				panel.setVisible(false);
				panel.setEnabled(false);
			}
			creditPanel.setVisible(true);
			creditPanel.setEnabled(true);
			contentPane.revalidate();
			contentPane.repaint();
		}
	}
	public static void Back() {
		settingsPanel.setVisible(false);
		settingsPanel.setEnabled(false);
		creditPanel.setVisible(false);
		creditPanel.setEnabled(false);
		contentPane.revalidate();
		contentPane.repaint();
	}
	private class SwingActionReadMeGuide extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5314131916573984043L;
		public SwingActionReadMeGuide() {
			putValue(NAME, "Readme guide");
			putValue(SHORT_DESCRIPTION, "Open a very basic readme guide.");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Desktop.getDesktop().open(new File(Window.runningPath + "/readme.txt"));
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Failed to find readme.txt file next to the executable.\n#x4", "Warning",
						JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		}
	}
	private class SwingActionOpenDiscordBug extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -1657802258395530803L;
		public SwingActionOpenDiscordBug() {
			putValue(NAME, "Report bug");
			putValue(SHORT_DESCRIPTION, "Opens the discord channel for reporting bugs");
		}
		public void actionPerformed(ActionEvent e) {
			OpenURL.OpenURL("https://discord.gg/9dUXMYG");
		}
	}
}
