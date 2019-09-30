package main;

import java.io.File;
import java.lang.reflect.Field;
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
		
		HashMap<File, IdConflict> map = finder.getIDs(new File("C:\\Users\\frane\\Desktop\\NPCs"));
		
		for(IdConflict conflict : map.values()) {
			System.out.println("-------------------------------------------------------------------------------------------------------------------");
			System.out.print("ID: " + conflict.getId() + "\nType: " + conflict.getType() + "\nPath: " + conflict.getFile().getPath() +"\n");
		}
		
	}	
	
}
