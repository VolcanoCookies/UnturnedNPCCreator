package processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class CheckIDConflict extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7962574173043137504L;
	public static String[][] output = new String[1][3];
	private static int i;
	private static int ii;
	private JTextField textFieldDirectory;
	private static JTable table;
	private JButton buttonCheckDirectories;
	private final Action actionCheckDirectories = new SwingActionCheckDirectories();
	private static DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public CheckIDConflict() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 200, 0};
		gridBagLayout.rowHeights = new int[]{0, 86, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDirectory = new JLabel("Directory: ");
		GridBagConstraints gbc_lblDirectory = new GridBagConstraints();
		gbc_lblDirectory.insets = new Insets(0, 0, 5, 5);
		gbc_lblDirectory.gridx = 0;
		gbc_lblDirectory.gridy = 0;
		add(lblDirectory, gbc_lblDirectory);
		
		textFieldDirectory = new JTextField();
		GridBagConstraints gbc_textFieldDirectory = new GridBagConstraints();
		gbc_textFieldDirectory.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDirectory.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDirectory.gridx = 1;
		gbc_textFieldDirectory.gridy = 0;
		add(textFieldDirectory, gbc_textFieldDirectory);
		textFieldDirectory.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		model = new DefaultTableModel(
				new Object[][] {
					
				},
				new String[] {
					"Path", "Type", "ID"
				}
			);
		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scrollPane.setViewportView(table);
		
		buttonCheckDirectories = new JButton("New button");
		buttonCheckDirectories.setAction(actionCheckDirectories);
		GridBagConstraints gbc_buttonCheckDirectories = new GridBagConstraints();
		gbc_buttonCheckDirectories.gridwidth = 2;
		gbc_buttonCheckDirectories.insets = new Insets(0, 0, 0, 5);
		gbc_buttonCheckDirectories.gridx = 0;
		gbc_buttonCheckDirectories.gridy = 2;
		add(buttonCheckDirectories, gbc_buttonCheckDirectories);

	}
	public static void dive(File file)
	{
		if(!file.isDirectory()&&file.getName().toLowerCase().equals("asset.dat")) {
			try {
//				String[][] temp = output;
//				output = new String[temp.length + 1][3];
				Object[] obj = new Object[3];
				//System.out.println(temp.length);
				System.out.println("Reading " + file.getAbsolutePath());
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = reader.readLine();
				//output[i][0] = file.getAbsolutePath();
				obj[0] = file.getAbsolutePath();
				while(line!=null) {
					if(line.toLowerCase().contains("type") && line.split(" ").length>1) {
						obj[1] = line.split(" ")[1];
						//output[i][1] = line.split(" ")[1];
					}
					if(line.toLowerCase().contains("id")&& !line.toLowerCase().contains("guid") && line.split(" ").length>1) {
						obj[2] = line.split(" ")[1];
						//output[i][2] = line.split(" ")[1];
					}
					line = reader.readLine();
				}
				reader.close();
				i++;
				model.addRow(obj);
				model.fireTableStructureChanged();
				table.revalidate();
				table.repaint();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(file.isDirectory()) {
			for(File files : file.listFiles()) {
				System.out.println("Call #" + ii++);
				dive(files);
			}
		}
	}
	private class SwingActionCheckDirectories extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2306946350678387482L;
		public SwingActionCheckDirectories() {
			putValue(NAME, "Find ID's");
			putValue(SHORT_DESCRIPTION, "Find all ids in directory.");
		}
		public void actionPerformed(ActionEvent e) {
			dive(new File(textFieldDirectory.getText()));
			model.fireTableStructureChanged();
			table.revalidate();
			table.repaint();
			System.out.println(i);
		}
	}
}
