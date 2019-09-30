package utility;

import objects.ItemBuying;
import objects.ItemSelling;

public class ItemMorph {
	
	public ItemSelling buyingToSelling(ItemBuying item) {
		ItemSelling returnItem = new ItemSelling();
		
		returnItem.setAmount(item.getAmount());
		returnItem.setCost(item.getCost());
		returnItem.setItemID(item.getItemID());
		returnItem.setItemName(item.getItemName());
		returnItem.setVehicle(false);
		returnItem.setConditions(item.getConditions());
		
		return returnItem;
	}
	
	public ItemBuying sellingToBuying(ItemSelling item) {
		ItemBuying returnItem = new ItemBuying();
		
		returnItem.setAmount(item.getAmount());
		returnItem.setCost(item.getCost());
		returnItem.setItemID(item.getItemID());
		returnItem.setItemName(item.getItemName());
		returnItem.setConditions(item.getConditions());
		
		return returnItem;
	}
	
}
