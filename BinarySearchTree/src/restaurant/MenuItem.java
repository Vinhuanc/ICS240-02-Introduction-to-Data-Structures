package restaurant;

import java.text.DecimalFormat;

public class MenuItem implements Comparable<MenuItem>{
	private String name;
	private double price;
	private int quantity;
	
	public MenuItem(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return this.getName() + "\t$" + df.format(this.getPrice()) + "\t" + this.getQuantity() + "\t$" + df.format(this.quantity*this.price);
	}
	
	public boolean equals(MenuItem item) {
		if(this.getName().compareToIgnoreCase(item.getName()) == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(MenuItem item) {
		if(this.name.compareTo(item.name) == 0) {
			return 0;
		} else if(this.name.compareTo(this.name) > 0) {
			return 1;
		} else {
			return -1;
		}
	}
	
	
}
