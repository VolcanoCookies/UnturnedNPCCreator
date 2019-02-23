package panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

import windows.Window;

public class ExplorerPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ExplorerPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{167, 0};
		gridBagLayout.rowHeights = new int[]{373, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panelTree = new JPanel();
		panelTree.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panelTree = new GridBagConstraints();
		gbc_panelTree.fill = GridBagConstraints.BOTH;
		gbc_panelTree.gridx = 0;
		gbc_panelTree.gridy = 0;
		add(panelTree, gbc_panelTree);
		
		File fileRoot = new File("C:\\Users\\frane\\Desktop\\Bundles");
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        CreateChildNodes ccn = 
                new CreateChildNodes(fileRoot, root);
        new Thread(ccn).start();
		panelTree.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTree.add(scrollPane);
		
		
		JTree tree = new JTree(treeModel);
		tree.setCellRenderer(new MyTreeCellRenderer());
		scrollPane.setViewportView(tree);
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
}
