package windows;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import character.CharacterPanel;
import controller.Controller;
import dialogues.DialoguePanel;
import models.Settings;
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
	private final Action actionOpenIDList = new SwingActionOpenIDList();
	private final Action actionOpenDiscord = new SwingActionOpenDiscord();
	private final Action actionReadMeGuide = new SwingActionReadMeGuide();
	private final Action actionOpenDiscordBug = new SwingActionOpenDiscordBug();
	private static ExplorerPanel explorerPanel;
	private static CheckIDConflict checkConflictPanel;
	private static CharacterPanel characterPanel;
	private static DialoguePanel dialoguePanel;
	private static VendorPanel vendorPanel;
	public static JPanel panelEditors;
	
	public final static Color BACKGROUNDCOLOR = Color.decode("#252120");
	public final static Color BUTTONSELECTED = Color.decode("#1B1818");
	public final static Color REDCOLOR = Color.decode("#A92F41");
	public final static Color DARKERBACKGROUNDCOLOR = Color.decode("#1E1A1A");
	public final static Color FONTCOLOR = Color.decode("#E5DFC5");
	
//	public static MetalButtonUI mbui = new MetalButtonUI();

	/**
	 * Create the frame.
	 */
	public Window(Controller controller) {
        setTitle("Unturned NPC Creator");
		setBounds(100, 100, 828, 630);
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
		    	if(!Settings.ExitConfirmation()) {
		    		Settings.save();
		    		System.exit(0);
		    	}
		    	String ObjButtons[] = {"Yes", "No"};
		    	int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Are you sure?",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		        	Settings.save();
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
		menuItemSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPanel("Settings");
			}
		});
		menuFile.add(menuItemSettings);
		
		JMenuItem menuItemDiscord = new JMenuItem("Discord");
		menuItemDiscord.setAction(actionOpenDiscord);
		menuFile.add(menuItemDiscord);
		
		JMenuItem menuItemIDList = new JMenuItem("ID List");
		menuItemIDList.setAction(actionOpenIDList);
		menuFile.add(menuItemIDList);
		
		JMenuItem menuItemCredits = new JMenuItem("Credits");
		menuItemCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPanel("Explorer");
			}
		});
		menuFile.add(menuItemCredits);
		
		JMenuItem menuItemReportBug = new JMenuItem("Report bugs");
		menuItemReportBug.setAction(actionOpenDiscordBug);
		menuFile.add(menuItemReportBug);
		
		JMenuItem menuItemQuit = new JMenuItem("Exit");
		menuItemQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setWheelScrollingEnabled(true);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel selectorPanel = new JPanel();
		contentPane.add(selectorPanel, BorderLayout.WEST);
		
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
				showPanel("Explorer");
			}
		});
		selectorPanel.setLayout(new BorderLayout(0, 0));
		buttonIcon.setBorderPainted(false);
		buttonIcon.setFocusPainted(false);
		buttonIcon.setContentAreaFilled(false);
		buttonIcon.setBackground(Color.WHITE);
		buttonIcon.setIcon(new ImageIcon(Window.class.getResource("/Icons/UIIcons/BTWIcon.png")));
		buttonIcon.setSize(new Dimension(100,100));
		buttonIcon.setSize(new Dimension(100,100));
		selectorPanel.add(buttonIcon, BorderLayout.NORTH);
		
		JPanel panelButtons = new JPanel();
		selectorPanel.add(panelButtons);
		
		JButton buttonCharacters = new JButton("Characters");
		buttonCharacters.setIcon(new ImageIcon(Window.class.getResource("/Icons/ExplorerPanel/characterIcon.png")));
		buttonCharacters.setHorizontalAlignment(SwingConstants.LEADING);
		buttonCharacters.setAlignmentY(Component.TOP_ALIGNMENT);
		buttonCharacters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showPanel("Character");
			}
		});
		buttonCharacters.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		panelButtons.setLayout(new BorderLayout(0, 0));
		panelButtons.add(buttonCharacters, BorderLayout.NORTH);
		
		JPanel panelButtons2 = new JPanel();
		panelButtons.add(panelButtons2, BorderLayout.CENTER);
		panelButtons2.setLayout(new BorderLayout(0, 0));
				
		JPanel panelButtons3 = new JPanel();
		panelButtons2.add(panelButtons3, BorderLayout.CENTER);
		panelButtons3.setLayout(new BorderLayout(0, 0));
				
		JPanel panelButtons4 = new JPanel();
		panelButtons3.add(panelButtons4, BorderLayout.CENTER);
		panelButtons4.setLayout(new BorderLayout(0, 0));
		
		JButton buttonIDFinder = new JButton("Find ID");
		buttonIDFinder.setHorizontalAlignment(SwingConstants.LEADING);
		panelButtons4.add(buttonIDFinder, BorderLayout.NORTH);
		buttonIDFinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPanel("CheckConflict");
			}
		});
		buttonIDFinder.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
														
		JButton buttonDialogues = new JButton("Dialogues");
		buttonDialogues.setIcon(new ImageIcon(Window.class.getResource("/Icons/ExplorerPanel/dialogIcon.png")));
		buttonDialogues.setHorizontalAlignment(SwingConstants.LEADING);
		panelButtons3.add(buttonDialogues, BorderLayout.NORTH);
		buttonDialogues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showPanel("Dialogue");
			}
		});
		buttonDialogues.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
						
		JButton buttonVendors = new JButton("Vendors");
		buttonVendors.setIcon(new ImageIcon(Window.class.getResource("/Icons/ExplorerPanel/vendorIcon.png")));
		buttonVendors.setHorizontalAlignment(SwingConstants.LEADING);
		panelButtons2.add(buttonVendors, BorderLayout.NORTH);
		buttonVendors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showPanel("Vendor");
			}
		});
		buttonVendors.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 17));
		
		//Editor Panels
		panelEditors = new JPanel();

		scrollPane.setViewportView(panelEditors);
		panelEditors.setLayout(new CardLayout(0, 0));
		
		explorerPanel = new ExplorerPanel();
		panelEditors.add(explorerPanel);
		
		settingsPanel = new SettingsPanel();
		panelEditors.add(settingsPanel);
		
		checkConflictPanel = new CheckIDConflict();
		panelEditors.add(checkConflictPanel);
		
		vendorPanel = new VendorPanel(controller, null);
		panelEditors.add(vendorPanel);
		
		characterPanel = new CharacterPanel(controller, null);
		panelEditors.add(characterPanel);
		
		dialoguePanel = new DialoguePanel(controller, null);
		panelEditors.add(dialoguePanel);

		showPanel("Explorer");

		setVisible(true);
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
			OpenURL.openURL("https://unturneditems.com/");
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
			OpenURL.openURL("https://discord.gg/BhJM5ve");
		}
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
			OpenURL.openURL("https://discord.gg/9dUXMYG");
		}
	}
	public static void showPanel(String panel) {
		//Editor panel needs to have the panel added already
		for(Component component : panelEditors.getComponents()) {
			component.setVisible(false);
			component.setEnabled(false);
		}
		switch (panel) {
		case "Explorer":
			explorerPanel.setEnabled(true);
			explorerPanel.setVisible(true);	
			break;
		case "Character":
			characterPanel.setEnabled(true);
			characterPanel.setVisible(true);	
			break;
		case "Vendor":
			vendorPanel.setEnabled(true);
			vendorPanel.setVisible(true);	
			break;
		case "Dialogue":
			dialoguePanel.setEnabled(true);
			dialoguePanel.setVisible(true);	
			break;
		case "Quest":
			explorerPanel.setEnabled(true);
			explorerPanel.setVisible(true);	
			break;
		case "Settings":
			settingsPanel.setEnabled(true);
			settingsPanel.setVisible(true);	
			break;
		case "Credits":
			creditPanel.setEnabled(true);
			creditPanel.setVisible(true);	
			break;
		case "CheckConflict":
			checkConflictPanel.setEnabled(true);
			checkConflictPanel.setVisible(true);
			break;
		default:
			explorerPanel.setEnabled(true);
			explorerPanel.setVisible(true);			
			break;
		}
	}
}