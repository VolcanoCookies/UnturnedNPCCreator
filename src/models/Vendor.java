package models;

import java.util.ArrayList;
import java.util.List;

public class Vendor {
	
	String ID;
	String GUID;
	String path;
	String name;
	String type = "Vendor";
	String description;
	List<ItemBuying> buyingItems = new ArrayList<ItemBuying>();
	List<ItemSelling> sellingItems = new ArrayList<ItemSelling>();
	
	public Vendor() {
		
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getGUID() {
		return GUID;
	}
	public void setGUID(String GUID) {
		this.GUID = GUID;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public void addBuyingItem(ItemBuying item) {
		this.buyingItems.add(item);
	}
	public List<ItemSelling> getSellingItems() {
		return sellingItems;
	}
	public void setSellingItems(List<ItemSelling> sellingItems) {
		this.sellingItems = sellingItems;
	}
	public void addSellingItem(ItemSelling item) {
		this.sellingItems.add(item);
	}
}
