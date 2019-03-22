package popups;

import javax.swing.JFileChooser;

public class fileChooser {
	
	public static String FileChooser() {
		JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        	return chooser.getSelectedFile().getAbsolutePath();
        }
		return null;
	}
}
