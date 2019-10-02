package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import objects.IdConflict;

public class IDFinder {
	
	private HashMap<Integer, ArrayList<IdConflict>> idMap;
	private HashMap<Integer, ArrayList<IdConflict>> conflictMap;
	
	public IDFinder() {
		
		idMap = new HashMap<>();
		conflictMap = new HashMap<>();
		
	}
	
	public HashMap<Integer, ArrayList<IdConflict>> getIDs(File... files) {
		idMap = new HashMap<>();
		
		for(File file : files) {
			lookThrough(file);
		}
		
		calculateConflicts();
		
		return idMap;
	}
	
	private void calculateConflicts() {
		
		idMap.forEach((k, v) -> {
			if(v.size()>1) {
				conflictMap.put(k, v);
			}
		});
		
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
			if(idMap.containsKey(idConflict.getId())) {
				idMap.get(idConflict.getId()).add(idConflict);
			} else {
				idMap.put(idConflict.getId(), new ArrayList<>());
				idMap.get(idConflict.getId()).add(idConflict);
			}
		}
		
	}
	
	public HashMap<Integer, ArrayList<IdConflict>> getIdMap() {
		return idMap;
	}

	public HashMap<Integer, ArrayList<IdConflict>> getConflictMap() {
		return conflictMap;
	}
	
	public void setIdMap(HashMap<Integer, ArrayList<IdConflict>> idMap) {
		this.idMap = idMap;
	}
	
}