package filemanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dialogues.DialoguePanel;

public class LoadDialogue {

	static BufferedReader reader;
	
	public static String loadDialogue(String filepath)
	{
		String path = filepath.replace("\\", "/");
		
		//The file
		File file = new File(path);
		System.out.println(file.getAbsolutePath());
		
		//Check path is a directory and if it contains Asset.dat and English.dat
		if(!file.isDirectory()) {
			JOptionPane.showMessageDialog(new JFrame("Failed to load"), "Specified path is not a directory.", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return null;
		}
		if(!(new File(path + "/Asset.dat").exists())) {
			JOptionPane.showMessageDialog(new JFrame("Failed to load"), "Specified path does not contain a Asset.dat file.", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return null;
		}
		if(!(new File(path + "/English.dat").exists())) {
			JOptionPane.showMessageDialog(new JFrame("Failed to load"), "Specified path does not contain a English.dat file.", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return null;
		}
		
		try {
			//Create the Asset.dat reader
			reader = new BufferedReader(new FileReader(path + "/Asset.dat"));
			
			//Temporary variables
			String line = reader.readLine();
			String content = "";
			
			//Read the whole Asset.dat file
			while (line != null) {
				content += line + "\n";
				line = reader.readLine();
			}
			
			//Add regex to split Asset and English content
			content += ":";
			
			//Create the English.dat reader
			reader = new BufferedReader(new FileReader(new File(path + "/English.dat")));
			
			//Reset the line variable to the English first line
			line = reader.readLine();
			
			//Read the whole English.dat file
			while (line != null) {
				content += line + "\n";
				line = reader.readLine();
			}
			
			//Close the reader
			reader.close();

			//Output array, 0 for Asset, 1 for English
			String[] output = new String[2];
			output[0] = content.split(":")[0];
			output[1] = content.split(":")[1];
			
			DialoguePanel.LoadDialogue(output);
			return null;
		} catch (IOException e) {	
			JOptionPane.showMessageDialog(new JFrame("Failed to load"), "Failed to read files.\nStacktrace:\n" + e.getMessage(), "Warning",
					JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
}
