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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import util.FileManager;
import windows.Window;

public class ExplorerPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6161205750176973769L;
	private final Action actionLoadNode = new SwingActionLoadNode();
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
		gridBagLayout.rowHeights = new int[]{0, 373, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		gbc_panelTree.insets = new Insets(0, 0, 5, 5);
		gbc_panelTree.fill = GridBagConstraints.BOTH;
		gbc_panelTree.gridx = 0;
		gbc_panelTree.gridy = 1;
		add(panelTree, gbc_panelTree);
		
		panelTree.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTree.add(scrollPane);
		
//		fileRoot = new File(Window.runningPath);
//        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
//        treeModel = new DefaultTreeModel(root);
//        CreateChildNodes ccn = 
//                new CreateChildNodes(fileRoot, root);
//        new Thread(ccn).start();
		
		tree = new JTree(treeModel);
		tree.getSelectionModel().setSelectionMode(
                TreeSelectionModel.SINGLE_TREE_SELECTION);

		tree.setCellRenderer(new MyTreeCellRenderer());
		scrollPane.setViewportView(tree);
		
		JButton buttonLoadNode = new JButton("New button");
		buttonLoadNode.setAction(actionLoadNode);
		GridBagConstraints gbc_buttonLoadNode = new GridBagConstraints();
		gbc_buttonLoadNode.insets = new Insets(0, 0, 0, 5);
		gbc_buttonLoadNode.gridx = 0;
		gbc_buttonLoadNode.gridy = 2;
		add(buttonLoadNode, gbc_buttonLoadNode);
	}
	public class CreateChildNodes implements Runnable {

        private DefaultMutableTreeNode root;

        private File fileRoot;

        public CreateChildNodes(File fileRoot, 
                DefaultMutableTreeNode root) {
            this.fileRoot = fileRoot;
            this.root = root;
        } 

        @Override
        public void run() {
            createChildren(fileRoot, root);
        }

        private void createChildren(File fileRoot, 
                DefaultMutableTreeNode node) {
            File[] files = fileRoot.listFiles();
            if (files == null) return;

            for (File file : files) {
            	DefaultMutableTreeNode childNode = 
                        new DefaultMutableTreeNode(new FileNode(file));
                node.add(childNode);
                File assetFile = new File(file.getAbsolutePath()+"/Asset.dat");
                if (file.isDirectory()) {
                	if (!assetFile.exists()) {
                		createChildren(file, childNode);
                	} else {
                		childNode.setUserObject(new CustomNode(childNode.getUserObject().toString(), getType(assetFile)));
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
		public CustomNode(String name, String type) {
			this.Name = name;
			this.Type = type;
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
            	
            	if (type.equals("npc")) {
            		setIcon(new ImageIcon(ExplorerPanel.class.getResource("/Icons/ExplorerPanel/characterIcon.png")));
            	} else if (type.equals("vendor")) {
            		setIcon(new ImageIcon(ExplorerPanel.class.getResource("/Icons/ExplorerPanel/vendorIcon.png")));
            	} else if (type.equals("quest")) {
            		setIcon(new ImageIcon(ExplorerPanel.class.getResource("/Icons/ExplorerPanel/questIcon.png")));
            	} else if (type.equals("dialog")) {
            		setIcon(new ImageIcon(ExplorerPanel.class.getResource("/Icons/ExplorerPanel/dialogIcon.png")));
            	}
            }
            
            return n;
	        
//	        setForeground(Window.FONTCOLOR);
//	        setBackground(Window.BACKGROUNDCOLOR);
//	        setOpaque(true);
	    }
	}
	private class SwingActionLoadNode extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 9214689290829011201L;
		public SwingActionLoadNode() {
			putValue(NAME, "Load selected");
			putValue(SHORT_DESCRIPTION, "Load the selected file");
		}
		public void actionPerformed(ActionEvent e) {
			if(tree.getSelectionCount()==1) {
				String finalPath = "";
				TreePath path = tree.getSelectionPath();
				for(int i = 1; i < path.getPath().length; i++) {
					finalPath += "\\" + path.getPathComponent(i).toString();
				}
				System.out.println(finalPath);
				if(path.getPathComponent(path.getPathCount()-2).toString().toLowerCase().contains("characters")) {
					FileManager.LoadCharacter(fileRoot.getAbsolutePath().toString() + finalPath);
					for(Component panel : Window.panelEditors.getComponents())
					{
						panel.setVisible(false);
						panel.setEnabled(false);
					}
					Window.panelCharacters.setVisible(true);
					Window.panelCharacters.setEnabled(true);
				}
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
						return "npc";
					}
					if(line.toLowerCase().contains("vendor")) {
						reader.close();
						return "vendor";
					}
					if(line.toLowerCase().contains("quest")) {
						reader.close();
						return "quest";
					}
					if(line.toLowerCase().contains("dialogue")) {
						reader.close();
						return "dialog";
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
			        new Thread(ccn).start();
			        
			        tree.setModel(treeModel);
			        
			        treeModel.reload();
			        
			        tree.revalidate();
			        tree.repaint();
			        
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
