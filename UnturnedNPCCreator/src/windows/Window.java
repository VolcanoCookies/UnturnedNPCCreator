package windows;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import panels.CharacterPanel;
import panels.CreditPanel;
import panels.SettingsPanel;
import panels.VendorPanel;
import util.Init;
import util.OpenURL;
import javax.swing.JInternalFrame;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 351755526376897220L;
	private static JPanel contentPane;
	public static String currentPath;
	public static String runningPath;
	private static JTabbedPane tabbedPane;
	private static SettingsPanel settingsPanel;
	private static CreditPanel creditPanel;
	private final Action actionExit = new SwingActionExit();
	private final Action actionOpenTrello = new SwingActionOpenTrello();
	private final Action actionOpenIDList = new SwingActionOpenIDList();
	private final Action actionSettings = new SwingActionSettings();
	private final Action actionOpenDiscord = new SwingActionOpenDiscord();
	private final Action actionOpenCredits = new SwingActionOpenCredits();
	private final Action actionReadMeGuide = new SwingActionReadMeGuide();

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
		setBounds(100, 100, 783, 924);
		setResizable(false);
		new Init();
		setIconImage(Init.icon);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Yes","No"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Are you sure?",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JMenuBar menuBar = new JMenuBar();
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
		contentPane.setLayout(new CardLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "name_1271071497657");
		settingsPanel = new SettingsPanel();
		contentPane.add(settingsPanel, "name_1271089145855");
		creditPanel = new CreditPanel();
		contentPane.add(creditPanel, "name_123912694789");
		
		JPanel panelCharacters = new JPanel();
		tabbedPane.addTab("Character", null, panelCharacters, null);
		panelCharacters.setLayout(new BorderLayout(0, 0));
		panelCharacters.add(new CharacterPanel());
		
		JPanel panelVendors = new JPanel();
		tabbedPane.addTab("Vendor", null, panelVendors, null);
		panelVendors.setLayout(new BorderLayout(0, 0));
		panelVendors.add(new VendorPanel());
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
		if(runningPath.contains("bin"))
			runningPath = runningPath.substring(1, runningPath.indexOf("UnturnedNPCCreator")+18);
		else
			runningPath = runningPath.substring(1, runningPath.length()-22);
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
			tabbedPane.setVisible(false);
			tabbedPane.setEnabled(false);
			creditPanel.setVisible(false);
			creditPanel.setEnabled(false);
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
			tabbedPane.setVisible(false);
			tabbedPane.setEnabled(false);
			settingsPanel.setVisible(false);
			settingsPanel.setEnabled(false);
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
		tabbedPane.setEnabled(true);
		tabbedPane.setVisible(true);
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
}
