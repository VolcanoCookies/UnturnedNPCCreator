package panels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

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
	/**
	 * Create the panel.
	 */
	public ExplorerPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{167, 0};
		gridBagLayout.rowHeights = new int[]{373, 32, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panelTree = new JPanel();
		panelTree.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panelTree = new GridBagConstraints();
		gbc_panelTree.insets = new Insets(0, 0, 5, 0);
		gbc_panelTree.fill = GridBagConstraints.BOTH;
		gbc_panelTree.gridx = 0;
		gbc_panelTree.gridy = 0;
		add(panelTree, gbc_panelTree);
		
		fileRoot = new File("C:\\Users\\frane\\Desktop\\Bundles");
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        CreateChildNodes ccn = 
                new CreateChildNodes(fileRoot, root);
        new Thread(ccn).start();
		panelTree.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTree.add(scrollPane);
		
		
		tree = new JTree(treeModel);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				
			}
		});
		tree.setCellRenderer(new MyTreeCellRenderer());
		scrollPane.setViewportView(tree);
		
		JButton buttonLoadNode = new JButton("New button");
		buttonLoadNode.setAction(actionLoadNode);
		GridBagConstraints gbc_buttonLoadNode = new GridBagConstraints();
		gbc_buttonLoadNode.gridx = 0;
		gbc_buttonLoadNode.gridy = 1;
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
                if (file.isDirectory()&&!assetFile.exists()) {
                    createChildren(file, childNode);
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
	public class MyTreeCellRenderer extends DefaultTreeCellRenderer {

	    /**
		 * 
		 */
		private static final long serialVersionUID = -7386783444232611418L;

		@Override
	    public Component getTreeCellRendererComponent(JTree tree, Object value,
	            boolean sel, boolean exp, boolean leaf, int row, boolean hasFocus) {
	        super.getTreeCellRendererComponent(tree, value, sel, exp, leaf, row, hasFocus);

//	        setForeground(Window.FONTCOLOR);
//	        setBackground(Window.BACKGROUNDCOLOR);
//	        setOpaque(true);

	        return this;
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
	public static void getType(String path)
	{
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(path + "/Asset.dat")));
			String line = reader.readLine();
			while(line!=null)
			{
				if(line.toLowerCase().contains("type")) {
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
