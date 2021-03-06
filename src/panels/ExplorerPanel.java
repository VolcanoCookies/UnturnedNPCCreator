package panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import filemanagement.LoadDialogue;
import util.FileManager;
import windows.Window;

public class ExplorerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6161205750176973769L;
	private JTree tree;
	private File fileRoot;
	private JTextField textFieldDirectoryPath;
	private final Action actionLoadDirectory = new SwingActionLoadDirectory();
	private DefaultTreeModel treeModel;
	public DefaultMutableTreeNode root;
	private JPanel panelTree;
	
	/**
	 * Create the panel.
	 */
	public ExplorerPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{223, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 373, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDirectory = new JLabel("Directory");
		GridBagConstraints gbc_lblDirectory = new GridBagConstraints();
		gbc_lblDirectory.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirectory.gridx = 0;
		gbc_lblDirectory.gridy = 0;
		add(lblDirectory, gbc_lblDirectory);
		
		textFieldDirectoryPath = new JTextField();
		GridBagConstraints gbc_textFieldDirectoryPath = new GridBagConstraints();
		gbc_textFieldDirectoryPath.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDirectoryPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDirectoryPath.gridx = 1;
		gbc_textFieldDirectoryPath.gridy = 0;
		add(textFieldDirectoryPath, gbc_textFieldDirectoryPath);
		textFieldDirectoryPath.setColumns(10);
		
		JButton buttonLoadDirectory = new JButton("load directory");
		buttonLoadDirectory.setAction(actionLoadDirectory);
		GridBagConstraints gbc_buttonLoadDirectory = new GridBagConstraints();
		gbc_buttonLoadDirectory.insets = new Insets(0, 0, 5, 0);
		gbc_buttonLoadDirectory.gridx = 2;
		gbc_buttonLoadDirectory.gridy = 0;
		add(buttonLoadDirectory, gbc_buttonLoadDirectory);
		
		panelTree = new JPanel();
		panelTree.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panelTree = new GridBagConstraints();
		gbc_panelTree.insets = new Insets(0, 0, 0, 5);
		gbc_panelTree.fill = GridBagConstraints.BOTH;
		gbc_panelTree.gridx = 0;
		gbc_panelTree.gridy = 1;
		add(panelTree, gbc_panelTree);
		
		panelTree.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTree.add(scrollPane);
		
		tree = new JTree(treeModel);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				LoadDirectory();
			}
		});
		tree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);

		tree.setCellRenderer(new MyTreeCellRenderer());
		scrollPane.setViewportView(tree);
	}
	public class CreateChildNodes implements Runnable {

        private DefaultMutableTreeNode root;

        private File fileRoot;

		private DefaultMutableTreeNode characterNode;

		private DefaultMutableTreeNode dialogueNode;

		private DefaultMutableTreeNode vendorNode;

		private DefaultMutableTreeNode questNode;

        public CreateChildNodes(File fileRoot, 
                DefaultMutableTreeNode root) {
            this.fileRoot = fileRoot;
            this.root = root;
        } 

        @Override
        public void run() {
        	characterNode = 
                    new DefaultMutableTreeNode("Characters");
        	root.add(characterNode);
        	vendorNode = 
                    new DefaultMutableTreeNode("Vendors");
        	root.add(vendorNode);
        	dialogueNode = 
                    new DefaultMutableTreeNode("Dialogues");
        	root.add(dialogueNode);
        	questNode = 
                    new DefaultMutableTreeNode("Quests");
        	root.add(questNode);
            createChildren(fileRoot);
        }

        private void createChildren(File fileRoot) {
            File[] files = fileRoot.listFiles();
            if (files == null) return;

            for (File file : files) {
                File assetFile = new File(file.getAbsolutePath()+"/Asset.dat");
                if (file.isDirectory()) {
                	if (!assetFile.exists()) {
                		createChildren(file);
                	} else {
                		String type = getType(assetFile);
                		if(type.equals("character")) {
                			characterNode.add(new DefaultMutableTreeNode(new FileNode(file)) {
								private static final long serialVersionUID = -6791298804723351685L; {
                				setUserObject(new CustomNode(getUserObject().toString(), type, file.getAbsolutePath()));
                			}});
                		}
                		else if(type.equals("vendor")) {
                			vendorNode.add(new DefaultMutableTreeNode(new FileNode(file)) {
								private static final long serialVersionUID = -8364253211540347277L; {
                				setUserObject(new CustomNode(getUserObject().toString(), type, file.getAbsolutePath()));
                			}});
                		}
                		else if(type.equals("dialogue")) {
                			dialogueNode.add(new DefaultMutableTreeNode(new FileNode(file)) {
								private static final long serialVersionUID = 8459274802455662792L; {
                				setUserObject(new CustomNode(getUserObject().toString(), type, file.getAbsolutePath()));
                			}});
                		}
                		else if(type.equals("quest")) {
                			questNode.add(new DefaultMutableTreeNode(new FileNode(file)) {
                				private static final long serialVersionUID = 8229355329604894899L; {
                				setUserObject(new CustomNode(getUserObject().toString(), type, file.getAbsolutePath()));
                			}});
                		}
                	}
                }
            }
        }
    }
	public class FileNode {

        private File file;

        public FileNode(File file) {
            this.file = file;
        }

        @Override
        public String toString() {
            String name = file.getName();
            if (name.equals("")) {
                return file.getAbsolutePath();
            } else {
                return name;
            }
        }
    }
	//Custom node class
	//To contain name to display and type for icon
	class CustomNode extends Object {
		private String Name;
		private String Type;
		private String Path;
		public CustomNode(String name, String type, String path) {
			this.Name = name;
			this.Type = type;
			this.Path = path;
		}
		public String getName() {
			return this.Name;
		}
		public String getType() {
			return this.Type;
		}
		public String toString() {
			return this.Name;
		}
		public String getPath() {
			return this.Path;
		}
	}
	public class MyTreeCellRenderer extends DefaultTreeCellRenderer {

	    /**
		 * 
		 */
		private static final long serialVersionUID = -7386783444232611418L;
		
		@Override
		public Component getTreeCellRendererComponent(JTree tree,
                Object value, boolean selected, boolean expanded,
                boolean isLeaf, int row, boolean focused) {
            Component n = super.getTreeCellRendererComponent(tree, value,
                    selected, expanded, isLeaf, row, focused);
            
            Object nodeObject = ((DefaultMutableTreeNode) value).getUserObject();
            if (nodeObject instanceof CustomNode) {
            	//Get node type
            	String type = ((CustomNode) nodeObject).getType();
            	
            	if (type.equals("character")) {
            		setIcon(new ImageIcon(ExplorerPanel.class.getResource("/Icons/ExplorerPanel/characterIcon.png")));
            	} else if (type.equals("vendor")) {
            		setIcon(new ImageIcon(ExplorerPanel.class.getResource("/Icons/ExplorerPanel/vendorIcon.png")));
            	} else if (type.equals("quest")) {
            		setIcon(new ImageIcon(ExplorerPanel.class.getResource("/Icons/ExplorerPanel/questIcon.png")));
            	} else if (type.equals("dialogue")) {
            		setIcon(new ImageIcon(ExplorerPanel.class.getResource("/Icons/ExplorerPanel/dialogIcon.png")));
            	}
            }
            
            return n;
	    }
	}
	private void LoadDirectory() {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		if(selectedNode.getChildCount()>0)
			return;
		
		CustomNode node = (CustomNode) ((DefaultMutableTreeNode) tree.getLastSelectedPathComponent()).getUserObject();
		
		if(tree.getSelectionCount()==1) {
			if(node.getType().equals("character")) {
				FileManager.LoadCharacter(node.getPath());
				for(Component panel : Window.panelEditors.getComponents())
				{
					panel.setVisible(false);
					panel.setEnabled(false);
				}
				Window.panelCharacters.setVisible(true);
				Window.panelCharacters.setEnabled(true);
			}
			if(node.getType().equals("vendor")) {
				FileManager.LoadVendor(node.getPath());
				for(Component panel : Window.panelEditors.getComponents())
				{
					panel.setVisible(false);
					panel.setEnabled(false);
				}
				Window.panelVendors.setVisible(true);
				Window.panelVendors.setEnabled(true);
			}
			if(node.getType().equals("dialogue")) {
				LoadDialogue.loadDialogue(node.getPath());
				for(Component panel : Window.panelEditors.getComponents())
				{
					panel.setVisible(false);
					panel.setEnabled(false);
				}
				Window.panelDialogues.setVisible(true);
				Window.panelDialogues.setEnabled(true);
			}
		}
	}
	public static String getType(File file)
	{
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while(line!=null)
			{

				if(line.toLowerCase().contains("type")) {
					if(line.toLowerCase().contains("npc")) {
						reader.close();
						return "character";
					}
					if(line.toLowerCase().contains("vendor")) {
						reader.close();
						return "vendor";
					}
					if(line.toLowerCase().contains("quest")) {
						reader.close();
						return "quest";
					}
					if(line.toLowerCase().contains("dialog")) {
						reader.close();
						return "dialogue";
					}
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			return null;
		}
		return null;
		
	}
	private class SwingActionLoadDirectory extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3187132098401404411L;
		public SwingActionLoadDirectory() {
			putValue(NAME, "Load");
			putValue(SHORT_DESCRIPTION, "Load the directory");
		}
		public void actionPerformed(ActionEvent e) {
			if(new File(textFieldDirectoryPath.getText()).exists()) {
				if(new File(textFieldDirectoryPath.getText()).isDirectory()) {
					
					fileRoot = new File(textFieldDirectoryPath.getText());
			        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
			        treeModel = new DefaultTreeModel(root);
			        CreateChildNodes ccn = 
			                new CreateChildNodes(fileRoot, root);
			        Thread thread = new Thread(ccn);
			        thread.start();
			        tree.setModel(treeModel);
			        new Thread(new Runnable(){
			            public void run(){
			            try{thread.join();}
			            catch(Exception e){;}
			            finally{
			            	treeModel.reload();
					        tree.revalidate();
					        tree.repaint(); 
			            }
			        }}).start();
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "This path leads to a file, not a directory.", "",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "This directory doesn't exist.", "",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
