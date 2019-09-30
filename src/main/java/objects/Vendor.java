package objects;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Vendor {
	
	private int ID;
	private String GUID;
	private File file;
	private String name;
	private String description;
	
	List<ItemBuying> buyingItems = new ArrayList<ItemBuying>();
	List<ItemSelling> sellingItems = new ArrayList<ItemSelling>();
	
	/*
	 * Getters & Setters
	 */
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getGUID() {
		return GUID;
	}
	public void setGUID(String gUID) {
		GUID = gUID;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ItemBuying> getBuyingItems() {
		return buyingItems;
	}
	public void setBuyingItems(List<ItemBuying> buyingItems) {
		this.buyingItems = buyingItems;
	}
	public List<ItemSelling> getSellingItems() {
		return sellingItems;
	}
	public void setSellingItems(List<ItemSelling> sellingItems) {
		this.sellingItems = sellingItems;
	}
	public void addSellingItem(ItemSelling item) {
		sellingItems.add(item);
	}
	public void addBuyingItem(ItemBuying item) {
		buyingItems.add(item);
	}
	
}
