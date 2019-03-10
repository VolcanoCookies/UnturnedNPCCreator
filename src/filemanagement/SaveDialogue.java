package filemanagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveDialogue {
	
	public static void Save(String[] values, String path) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path + "/Asset.dat")));
			writer.write(values[0]);
			writer.close();
			writer = new BufferedWriter(new FileWriter(new File(path + "/English.dat")));
			writer.write(values[1]);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
