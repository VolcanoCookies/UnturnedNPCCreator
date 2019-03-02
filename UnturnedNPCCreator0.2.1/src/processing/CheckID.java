package processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckID {
	public static String[][] output;
	public static int i = 0;
	public static int ii = 0;
	public static void main(String[] args) {
		output = new String[1024][3];
		String dirPath = "C:\\Program Files (x86)\\Steam\\steamapps\\workshop\\content\\304930";
		File dir = new File(dirPath);
		
		dive(dir);
		
		for(String[] strings : output) {
			for(String string : strings) {
				if(string!=null)
					System.out.print(string + "\t\t");
			}
			System.out.println("\n");
		}
	}
	public static void dive(File file)
	{
		if(!file.isDirectory()&&file.getName().toLowerCase().equals("asset.dat")) {
			try {
				System.out.println("Reading " + file.getAbsolutePath());
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = reader.readLine();
				output[i][0] = file.getAbsolutePath();
				while(line!=null) {
					if(line.toLowerCase().contains("type") && line.split(" ").length>1) {
						output[i][1] = line.split(" ")[1];
					}
					if(line.toLowerCase().contains("id")&& !line.toLowerCase().contains("guid") && line.split(" ").length>1) {
						output[i][2] = line.split(" ")[1];
					}
					line = reader.readLine();
				}
				reader.close();
				i++;
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
}
