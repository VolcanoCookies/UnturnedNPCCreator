package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import objects.IdConflict;

public class IDFinder {
	
	private HashMap<File, IdConflict> idMap;
	
	public IDFinder() {
		
		idMap = new HashMap<>();
		
	}
	
	public HashMap<File, IdConflict> getIDs(File... files) {
		idMap = new HashMap<>();
		
		for(File file : files) {
			lookThrough(file);
		}
		
		return idMap;
	}
	
	private void lookThrough(File dir) {
		for(File file : dir.listFiles()) {
			if(file.isDirectory()) {
				lookThrough(file);
			} else if(file.isFile() && file.getName().toLowerCase().endsWith("asset.dat")) {
				extractID(file);
			}
		}
	}
	
	private void extractID(File file) {
		
		IdConflict idConflict = new IdConflict();
		idConflict.setFile(file);
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String nextLine = reader.readLine().toLowerCase();
			while(nextLine != null) {
				if(nextLine.startsWith("id")) {
					idConflict.setId(Integer.valueOf(nextLine.split(" ")[1]));
				} else if (nextLine.startsWith("type")) {
					idConflict.setType(nextLine.split(" ")[1]);
				}
				nextLine = reader.readLine();
				if(nextLine != null) nextLine = nextLine.toLowerCase();
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(idConflict.getFile()!=null && idConflict.getId()!=0) {
			idMap.put(file, idConflict);
		}
		
	}
	
	public HashMap<File, IdConflict> getIdMap() {
		return idMap;
	}

	public void setIdMap(HashMap<File, IdConflict> idMap) {
		this.idMap = idMap;
	}
	
}