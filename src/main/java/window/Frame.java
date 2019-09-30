package window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import bibliothek.gui.dock.common.CControl;
import bibliothek.gui.dock.common.CLocation;
import bibliothek.gui.dock.common.DefaultMultipleCDockable;
import bibliothek.gui.dock.common.EmptyMultipleCDockableFactory;
import bibliothek.gui.dock.common.MultipleCDockable;
import bibliothek.gui.dock.common.event.CDockableLocationEvent;
import bibliothek.gui.dock.common.event.CDockableLocationListener;
import bibliothek.gui.dock.common.event.CFocusListener;
import bibliothek.gui.dock.common.intern.CDockable;
import objects.Character;
import objects.ItemSelling;
import panels.PanelCharacter;
import panels.PanelPreview;
import panels.PanelVendor;
import utility.FileIO;

public class Frame extends JFrame {

	/**
	 * Author: Volcano
	 */
	private static final long serialVersionUID = 1L;
	public static ItemSelling clipboard;
	private JPanel contentPane;
	
	private PanelPreview panelPreview;
	
	Factory factory;
	private CControl control;
	
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set style
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addWindowListener(new WindowListener() {
			@Override
			public void windowClosing(WindowEvent e) {
				quit();
			}
			public void windowOpened(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
		});
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		setBounds(100, 100, 900, 600);
		
		control = new CControl(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(control.getContentArea());
		
		factory = new Factory();
		control.addMultipleDockableFactory("factory", factory);
		
//		ThemeMap themes = control.getThemes();
//		themes.add("custom", new ThemeFactory() {
//			
//			@Override
//			public ThemeMeta createMeta(DockController controller) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//			
//			@Override
//			public DockTheme create(DockController controller) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		});
//		themes.select("custom");
		
		/*
		 * Top menu bar
		 */
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuItemExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Exit the application
				quit();
			}
		});
		
		JMenuItem menuItemOpenProject = new JMenuItem("Open Project");
		menuFile.add(menuItemOpenProject);
		
		JMenuItem menuItemNewProject = new JMenuItem("New Project");
		menuFile.add(menuItemNewProject);
		
		JSeparator separator1 = new JSeparator();
		menuFile.add(separator1);
		
		JMenuItem menuItemOpen = new JMenuItem("Open");
		menuItemOpen.setToolTipText("Open a file in a new panel.");
		menuItemOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				File file = chooseFile(JFileChooser.DIRECTORIES_ONLY);
				
				switch (FileIO.getType(file)) {
				case Character:
					newCharacterPanel((Character) FileIO.loadFromFile(file));
					break;
				case Vendor:
					
					break;
				case  Dialogue:
					
					break;
				case Quest:
					
					break;
				default:
					break;
				}
			}
		});
		menuFile.add(menuItemOpen);
		
		JMenuItem menuItemLoad = new JMenuItem("Load");
		menuItemLoad.setToolTipText("Load a file into the selected panel.");
		menuItemLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
				JPanel panel = new JPanel();
				JTextField path = new JTextField();
				path.setColumns(100);
				JButton buttonOk = new JButton("OK");
				panel.setLayout(new BorderLayout());
				panel.add(path, BorderLayout.CENTER);
				panel.add(buttonOk, BorderLayout.SOUTH);
				dialog.getContentPane().add(panel);
				dialog.setVisible(true);
				dialog.pack();
				dialog.setLocationRelativeTo(null);
				buttonOk.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						DefaultMultipleCDockable dockable = (DefaultMultipleCDockable) control.getFocusedCDockable();
						((PanelCharacter) ((JScrollPane) dockable.getContentPane().getComponent(0)).getViewport().getComponent(0)).loadCharacter((Character) FileIO.loadFromFile(new File(path.getText())));
						dialog.dispose();
					}
				});
			}
		});
		menuFile.add(menuItemLoad);
		
		JMenuItem menuItemSave = new JMenuItem("Save");
		menuFile.add(menuItemSave);
		
		JMenuItem menuItemSaveAs = new JMenuItem("Save as");
		menuFile.add(menuItemSaveAs);
		
		JSeparator separator2 = new JSeparator();
		menuFile.add(separator2);
		menuFile.add(menuItemExit);
		
		JMenu mnEditor = new JMenu("Editor");
		menuBar.add(mnEditor);
		
		JMenu menuView = new JMenu("View");
		menuBar.add(menuView);
		
		JMenuItem menuItemCharacter = new JMenuItem("New Character");
		menuItemCharacter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newCharacterPanel(null);
			}
		});
		menuView.add(menuItemCharacter);
		
		JMenuItem menuItemVendor = new JMenuItem("New Vendor");
		menuItemVendor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newPanel(new PanelVendor(), "Vendor");
			}
		});
		menuView.add(menuItemVendor);
		
		JMenuItem menuItemDialogue = new JMenuItem("New Dialogue");
		menuView.add(menuItemDialogue);
		
		JMenuItem menuItemQuest = new JMenuItem("New Quest");
		menuView.add(menuItemQuest);
		
		JSeparator separator = new JSeparator();
		menuView.add(separator);
		
		JMenuItem menuItemLoadFromFile = new JMenuItem("Load file");
		menuView.add(menuItemLoadFromFile);
		
		JMenu menuBarWindow = new JMenu("Window");
		menuBar.add(menuBarWindow);
		
		JMenuItem menuItemOutputPreview = new JMenuItem("Preview");
		menuItemOutputPreview.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelPreview = new PanelPreview();
				control.addFocusListener(new CFocusListener() {
					@Override
					public void focusGained(CDockable dockable) {
						System.out.println("X");
						if(((JScrollPane) ((DefaultMultipleCDockable) dockable).getContentPane().getComponent(0)).getViewport().getComponent(0) instanceof PanelCharacter) {
							Character character = ((PanelCharacter) ((JScrollPane) ((DefaultMultipleCDockable) dockable).getContentPane().getComponent(0)).getViewport().getComponent(0)).getCharacter();
							String[] strings = FileIO.getCharacterText(character);
							panelPreview.setAssetText(strings[0]);
							panelPreview.setEnglishText(strings[1]);
							System.out.println("Accepted");
						}
					}
					public void focusLost(CDockable dockable) {}
				});
				
				DefaultMultipleCDockable dockable = new DefaultMultipleCDockable(factory);
				dockable.setTitleText("Preview");
				dockable.setRemoveOnClose(false);
				dockable.setCloseable(true);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.getVerticalScrollBar().setUnitIncrement(10);
				scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
				
				dockable.add(scrollPane);
				dockable.addCDockableLocationListener(new CDockableLocationListener() {
					
					@Override
					public void changed(CDockableLocationEvent event) {
						scrollPane.revalidate();
					}
				});
				
				scrollPane.setViewportView(panelPreview);
				control.addDockable(dockable);
				dockable.setLocation(CLocation.base().normalEast(0.4));
				dockable.setVisible(true);
				
			}
		});
		menuBarWindow.add(menuItemOutputPreview);
		
		JMenuItem menuItemClearWindow = new JMenuItem("Clear Window");
		menuItemClearWindow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.getCDockable(0).setVisible(!control.getCDockable(0).isVisible());
			}
		});
		menuBarWindow.add(menuItemClearWindow);
		setLocationRelativeTo(null);
		
		
	}
	
	private void newCharacterPanel(Character character) {
		DefaultMultipleCDockable dockable = new DefaultMultipleCDockable(factory);
		dockable.setTitleText("Character");
		dockable.setRemoveOnClose(false);
		dockable.setCloseable(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		
		dockable.add(scrollPane);
		dockable.addCDockableLocationListener(new CDockableLocationListener() {
			@Override
			public void changed(CDockableLocationEvent event) {
				scrollPane.revalidate();
			}
		});
		
		PanelCharacter panelCharacter = new PanelCharacter(dockable, character);
		scrollPane.setViewportView(panelCharacter);
		control.addDockable(dockable);
		dockable.setLocation(CLocation.base().normalEast(0.4));
		dockable.setVisible(true);
	}
	
	private void newPanel(JPanel panel, String title) {
		DefaultMultipleCDockable dockable = new DefaultMultipleCDockable(factory);
		dockable.setTitleText(title);
		dockable.setRemoveOnClose(false);
		dockable.setCloseable(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		
		dockable.add(scrollPane);
		dockable.addCDockableLocationListener(new CDockableLocationListener() {
			@Override
			public void changed(CDockableLocationEvent event) {
				scrollPane.revalidate();
			}
		});
		
		scrollPane.setViewportView(panel);
		control.addDockable(dockable);
		dockable.setLocation(CLocation.base().normalEast(0.4));
		dockable.setVisible(true);
	}
	
	private static MultipleCDockable newDockable(Factory factory, JPanel contentPane, String title) {
		DefaultMultipleCDockable dockable = new DefaultMultipleCDockable(factory);
		dockable.setTitleText(title);
		dockable.setRemoveOnClose(false);
		dockable.setCloseable(true);
		dockable.add(contentPane);
		return dockable;
	}
	
	private File chooseFile(int i) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choose directory");
		fileChooser.setFileSelectionMode(i);
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.showDialog(getParent(), "Select");
		return fileChooser.getSelectedFile();
	}
	
	private static class Factory extends EmptyMultipleCDockableFactory<MultipleCDockable>{
		@Override
		public MultipleCDockable createDockable() {
			return newDockable(this);
		}		
	}
	
	public void quit() {
		System.exit(0);
	}
}
