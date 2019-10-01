package main;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import objects.Equipped;
import objects.IdConflict;
import objects.Type;
import objects.Vendor;
import utility.FileIO;
import utility.IDFinder;

public class Test {
	
	public static void main(String[] args) {
		
		IDFinder finder = new IDFinder();
		
		HashMap<Integer, ArrayList<IdConflict>> map = finder.getIDs(new File("C:\\Users\\frane\\Desktop\\NPCs"));
		
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
