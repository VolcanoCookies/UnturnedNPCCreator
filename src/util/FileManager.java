package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import character.CharacterPanel;
import vendor.VendorPanel;
import windows.Window;

public class FileManager 
{
	public static void SaveCharacter(String[] assets, String[][] values, String fileName)
	{
//		assets = LoadTemplate("CharacterTemplate.txt");
		String assetOutput = "";
		String englishOutput = "";
//		String[] assetsLine;
//		String[] valuesLine;
//		String lastLine = null;
//		int x = 0;
//		int y = 0;
		for(String string : values[0])
		{
			if(string!=null) {
				if(string.toLowerCase().contains("guid"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("type"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("id") && !string.toLowerCase().contains("guid"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("shirt"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("pants"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("vest"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("mask"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("glasses"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("hat"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("backpack"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("primary"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("secondary"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("tertiary") && !string.toLowerCase().contains("primary") && !string.toLowerCase().contains("secondary") && !string.toLowerCase().contains("tertiary"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("equipped"))
					assetOutput += string + "\n";
				
				if(string.toLowerCase().contains("pose"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("backwards true"))
					assetOutput += string + "\n";
				
				if(string.toLowerCase().contains("face"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("hair") && !string.toLowerCase().contains("color"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("beard") && !string.toLowerCase().contains("color"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("color_skin"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("color_hair"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("color_beard"))
					assetOutput += string + "\n";
				if(string.toLowerCase().contains("dialogue"))
					assetOutput += string + "\n";
			}
		}
		
//		for(String assetsString : assets)
//		{
//			//x++;
//			y = 0;
//			for(String valuesString : values[0])
//			{
//				y++;
//				if(valuesString!=null && assetsString!=null)
//				{
//					assetsLine = assetsString.split(" ");
//					valuesLine = valuesString.split(" ");
//					if(assetsLine[0].equalsIgnoreCase(valuesLine[0]) && valuesLine.length > 1)
//					{
//						if(values[0][y]!=null)
//						{
//							//assets[x] = values[y];
//						}
//						assetsString = valuesString;
//					}	
//				}
//			}
//			if(assetsString.split(" ").length>1 || assetsString.equals("") || assetsString.equalsIgnoreCase("\n"))
//				if(!assetsString.equals("") || !(lastLine.length()<2))
//				{
//					lastLine = assetsString;
//					assetOutput += assetsString + "\n";
//				}
//		}
		if(values[1][0] == null)
			englishOutput = "Name " + fileName + "\n";
		else
			englishOutput = "Name " + values[1][0] + "\n";
		if(values[1][1] == null)
			englishOutput += "Character " + fileName;
		else
			englishOutput += "Character " + values[1][1];
		assetOutput = assetOutput.substring(0, assetOutput.lastIndexOf("\n"));
		
		int reply = JOptionPane.showConfirmDialog(null, assetOutput, "Confirm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (reply == JOptionPane.OK_OPTION) {
        	BufferedWriter assetWriter;
        	BufferedWriter englishWriter;
			try {
				assetWriter = new BufferedWriter(new FileWriter(new File(Window.runningPath + "/Bundles/NPCs/Characters/" + fileName + "/Asset.dat")));
				assetWriter.write(assetOutput);
	        	assetWriter.close();
	        	englishWriter = new BufferedWriter(new FileWriter(new File(Window.runningPath + "/Bundles/NPCs/Characters/" + fileName + "/English.dat")));
	        	englishWriter.write(englishOutput);
	        	englishWriter.close();
			} catch (IOException e) {
				int reply2 = JOptionPane.showConfirmDialog(null, assetOutput, "Failed to find file, would you like to create a new character?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (reply2 == JOptionPane.OK_OPTION)
				{
					CreateEmpty(fileName, "Characters");
					SaveCharacter(assets, values, fileName);
				}
			}
        }
	}
	public static void SaveVendor(String[] assets, String[][] basic, String[] buying, String[] selling, String fileName)
	{
		String outputAsset = "";
		String outputEnglish = "";
		if (basic[0][0]!=null)
			outputAsset += basic[0][0] + "\n";
		outputAsset += "Type Vendor\n";
		if(basic[0][1]!=null)
			outputAsset += basic[0][1] + "\n\n";
		else
			outputAsset += "ID\n\n";
		for(String string : buying)
		{
			if(string!=null)
				outputAsset += string + "\n";
		}
		outputAsset += "\n";
		for(String string : selling)
		{
			if(string!=null)
				outputAsset += string + "\n";
		}
		for(String string : basic[1])
		{
			if(string!=null)
				outputEnglish += string + "\n";
		}
		
		BufferedWriter assetWriter;
    	BufferedWriter englishWriter;
    	try {
			assetWriter = new BufferedWriter(new FileWriter(new File(Window.runningPath + "/Bundles/NPCs/Vendors/" + fileName + "/Asset.dat")));
			assetWriter.write(outputAsset);
        	assetWriter.close();
        	englishWriter = new BufferedWriter(new FileWriter(new File(Window.runningPath + "/Bundles/NPCs/Vendors/" + fileName + "/English.dat")));
        	englishWriter.write(outputEnglish);
        	englishWriter.close();
		} catch (IOException e) {
			int reply3 = JOptionPane.showConfirmDialog(null, "Failed to find file, would you like to create a new vendor?", "File not found.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (reply3 == JOptionPane.OK_OPTION)
			{
				CreateEmpty(fileName, "Vendors");
				SaveVendor(assets, basic, buying, selling, fileName);
			}
		}
	}
	public static void CreateEmpty(String name, String type) 
	{
		//BufferedWriter writer;
		File dirs = new File(Window.runningPath + "/Bundles/NPCs/" + type + "/" + name);
		File fileAsset = new File(Window.runningPath + "/Bundles/NPCs/" + type + "/" + name + "/Asset.dat");
		File fileEnglish = new File(Window.runningPath + "/Bundles/NPCs/" + type + "/" + name + "/English.dat");
		if (! fileAsset.exists())
		{
			dirs.mkdirs();
			try {
				fileAsset.createNewFile();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Failed to create fileAsset\n#x1", "Warning",
						JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		}
		if (! fileEnglish.exists())
		{
			dirs.mkdirs();
			try {
				fileEnglish.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(new JFrame(), "Failed to create fileEnglish\n#x1", "Warning",
						JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		}
		System.out.println(fileAsset.getAbsolutePath());
//		String output = "";
//		if(!type.equalsIgnoreCase("Vendors"))
//		{
//			try {
//				String[] template = LoadTemplate("CharacterTemplate.txt");
//				writer = new BufferedWriter(new FileWriter(fileAsset));
//				for(String string : template)
//				{
//					output += string + "\n";
//				}
//				output = output.substring(0, output.lastIndexOf("\n"));
//				writer.write(output);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			
//		} else {
//			try {
//				writer = new BufferedWriter(new FileWriter(fileAsset));
//				writer.write(output);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
	}
	public static String[] LoadTemplate(String name)
	{
		String[] template = null;
		String temp = "";
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(Window.runningPath + "/src/util/" + name)));
			String line = reader.readLine();
			while(line!=null)
			{
				temp += line + "\n";
				line = reader.readLine();
			}
			template = temp.split("\n");
		} catch (IOException e) {
			try {
				reader = new BufferedReader(new FileReader(new File(Window.runningPath + "/Templates/" + name)));
				String line = reader.readLine();
				while(line!=null)
				{
					temp += line + "\n";
					line = reader.readLine();
				}
				template = temp.split("\n");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Failed to find template\n#x2", "Warning",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		return template;
	}
	public static void LoadCharacter(String name)
	{
		name = name.replace("\\", "/");
		BufferedReader reader;
		Window.currentPath = Window.runningPath + "/Bundles/NPCs/Characters/" + name + "/Asset.dat";
		System.out.println(Window.currentPath);
		if(!new File(Window.currentPath).exists())
			Window.currentPath = name + "/Asset.dat";
		System.out.println(Window.currentPath);
		try {
			reader = new BufferedReader(new FileReader(new File(Window.currentPath)));
			String line = reader.readLine();
			String temp = "";
			while (line != null) {
				temp += line + ";";
				line = reader.readLine();
			}
			if(!temp.contains("Pose"))
				temp += "Pose Stand;";
			System.out.println(Window.currentPath.substring(0, Window.currentPath.lastIndexOf("/")) + "/English.dat");
			reader = new BufferedReader(new FileReader(new File(Window.currentPath.substring(0, Window.currentPath.lastIndexOf("/")) + "/English.dat")));
			line = reader.readLine();
			while (line != null) {
				if(line.contains("Character ") && line.contains("color"))
				{
					System.out.println(line);
					System.out.println("CharacterColor " + line.substring(line.indexOf("=")+1, line.indexOf(">")));
					System.out.println("Character " + line.substring(line.indexOf(">")+1, line.lastIndexOf("<")));
					temp += "CharacterColor " + line.substring(line.indexOf("=")+1, line.indexOf(">")) + ";";
					temp += "Character " + line.substring(line.indexOf(">")+1, line.lastIndexOf("<")) + ";";
				} else
					temp += line + ";";
				line = reader.readLine();
			}
			reader.close();
			CharacterPanel.assets = temp.split(";");
			
			CharacterPanel.clearFields();
			CharacterPanel.FillFields(temp.split(";"));
			
		} catch (IOException e2) {	
			int reply = JOptionPane.showConfirmDialog(null, "Failed to load character, would you like to make a new one", 
					"Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (reply == JOptionPane.OK_OPTION)
			{
				CreateEmpty(name, "Characters");
			}
		}
	}
	public static void LoadVendor(String fileName) {
		BufferedReader reader;
		String[] output;
		Window.currentPath = Window.runningPath + "/Bundles/NPCs/Vendors/" + fileName + "/Asset.dat";
		System.out.println(Window.currentPath);
		try {
			reader = new BufferedReader(new FileReader(new File(Window.currentPath)));
			String line = reader.readLine();
			String temp = "";
			while (line != null) {
				temp += line + ";";
				line = reader.readLine();
			}
			reader = new BufferedReader(new FileReader(new File(Window.currentPath.substring(0, Window.currentPath.lastIndexOf("/")) + "/English.dat")));
			line = reader.readLine();
			while (line!=null)
			{
				temp += line + ";";
				line = reader.readLine();
			}
			reader.close();
			output = temp.split(";");
			
			VendorPanel.clearFields();
			VendorPanel.FillFields(output);
			
		} catch (IOException e2) {
			if(fileName.contains("\\")) {
				if(fileName.substring(fileName.lastIndexOf("\\"), fileName.length()-1).toLowerCase().contains("asset"))
					Window.currentPath = fileName;
				else
					Window.currentPath = fileName + "/Asset.dat";
			}
			System.out.println(Window.currentPath);
			try {
				reader = new BufferedReader(new FileReader(new File(Window.currentPath)));
				String line = reader.readLine();
				String temp = "";
				while (line != null) {
					temp += line + ";";
					line = reader.readLine();
				}
				reader = new BufferedReader(new FileReader(new File(Window.currentPath.substring(0, Window.currentPath.lastIndexOf("/")) + "/English.dat")));
				line = reader.readLine();
				while (line!=null)
				{
					temp += line + ";";
					line = reader.readLine();
				}
				reader.close();
				output = temp.split(";");
				
				VendorPanel.clearFields();
				VendorPanel.FillFields(output);
				
			} catch (IOException e3) {		
				
				int reply = JOptionPane.showConfirmDialog(null, "Failed to load vendor, would you like to make a new one", 
						"Warning", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (reply == JOptionPane.OK_OPTION)
				{
					CreateEmpty(fileName, "Vendors");
				}
			}
		}
	}
	public static ImageIcon LoadIcon(String path)
	{
		ImageIcon icon = new ImageIcon(path);
		
		return icon;
	}
}