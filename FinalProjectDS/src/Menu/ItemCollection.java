package Menu;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ItemCollection {
	private String name;
	private Item[] itemCollection;
	private int count;
	
	public ItemCollection(String name,int count ) {
		this.name = name;
		itemCollection = new Item[count];
		count = 0;
	}

	public void addItemIntoCollection(Item item) {
		itemCollection[count++] = item;
	}
	
	

	public Item[] getItemCollection() {
		return itemCollection;
	}

	public void setItemCollection(Item[] itemCollection) {
		this.itemCollection = itemCollection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getItemCollectionInfo() {
		NumberFormat formatter = new DecimalFormat("#0.00");     
		String info = "---------------------------------\n";
		info += "Name: \t\t\t Price for One: \t Price for Two: \t Price for Three: \t \n";
		for (int i = 0; i < count; i++) {
			info += itemCollection[i].getName() +"\t\t"+ formatter.format(itemCollection[i].getPriceForOne()) +"\t\t\t"
					+ formatter.format(itemCollection[i].getPriceForTwo()) + "\t\t\t"+ formatter.format(itemCollection[i].getPriceForThree()) + "\n";
		}
		return info;
	}
	

}
