package Menu;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ItemIncreasedOptionsCollection {
	private String name;
	private ItemIncreasedOptions[] itemIncreasedOptionsCollection;
	private int count;
	
	public ItemIncreasedOptionsCollection(String name, int count) {
		this.name = name;
		itemIncreasedOptionsCollection = new ItemIncreasedOptions[count];
		count = 0;
	}
	public void addItemIncreasedOptionsIntoCollection(ItemIncreasedOptions item) {
		itemIncreasedOptionsCollection[count++] = item;
	}
	public ItemIncreasedOptions[] getItemIncreasedOptionsCollection() {
		return itemIncreasedOptionsCollection;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setItemIncreasedOptionsCollection(ItemIncreasedOptions[] itemIncreasedOptionsCollection) {
		this.itemIncreasedOptionsCollection = itemIncreasedOptionsCollection;
	}
	public String getItemIncreasedOptionsCollectionInfo() {
		NumberFormat formatter = new DecimalFormat("#0.00");     
		String info = "---------------------------------\n";
		info += "Name: \t\t\t Price for One: \t Price for Two: \t Price for Three: \t Price for Four: \t Price for Five: \t Price for Six: \t \n";
		for (int i = 0; i < count; i++) {
			info += itemIncreasedOptionsCollection[i].getName() +"\t\t\t\t"+ formatter.format(itemIncreasedOptionsCollection[i].getPriceForOne()) +"\t\t\t"
					+ formatter.format(itemIncreasedOptionsCollection[i].getPriceForTwo()) + "\t\t\t"+ formatter.format(itemIncreasedOptionsCollection[i].getPriceForThree())  
					+ "\t\t\t"+ formatter.format(itemIncreasedOptionsCollection[i].getPriceForFour()) + "\t\t\t"+ formatter.format(itemIncreasedOptionsCollection[i].getPriceForFive()) + "\t\t\t"+ formatter.format(itemIncreasedOptionsCollection[i].getPriceForSix())+"\n";
		}
		return info;
	}
}
