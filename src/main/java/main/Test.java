package main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import objects.IdConflict;
import utility.IDFinder;

public class Test {
	
	public static void main(String[] args) {
		
		IDFinder finder = new IDFinder();
		
		HashMap<Integer, ArrayList<IdConflict>> map = finder.getIDs(new File("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Unturned"), new File("C:\\Program Files (x86)\\Steam\\steamapps\\workshop\\content\\304930"));
		
		for(ArrayList<IdConflict> lists : map.values()) {
			if(lists.size() > 1) {
				
				System.out.println("-----------------------------------------------------------------------------------");
				System.out.println("\t\t\tConflict");
				for(IdConflict conflict : lists) {
					System.out.println("ID: " + conflict.getId());
					System.out.println("Type: " + conflict.getType());
					System.out.println("Path: " + conflict.getFile().getPath());
				}
			}
		}
		
	}	
	
}
