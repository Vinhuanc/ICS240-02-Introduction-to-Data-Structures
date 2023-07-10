package Menu;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Item {
	private String name;
	private double priceForOne;
	private double priceForTwo;
	private double priceForThree;

	public Item(String name, double priceForOne, double priceForTwo, double priceForThree) {
		this.name = name;
		this.priceForOne = priceForOne;
		this.priceForTwo = priceForTwo;
		this.priceForThree = priceForThree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPriceForOne() {
		return priceForOne;
	}

	public void setPriceForOne(double priceForOne) {
		this.priceForOne = priceForOne;
	}

	public double getPriceForTwo() {
		return priceForTwo;
	}

	public void setPriceForTwo(double priceForTwo) {
		this.priceForTwo = priceForTwo;
	}

	public double getPriceForThree() {
		return priceForThree;
	}

	public void setPriceForThree(double priceForThree) {
		this.priceForThree = priceForThree;
	}

	public String toString() {
		NumberFormat formatter = new DecimalFormat("#0.00");     
		return "Item name: " + this.getName() + "\tPrice for One:  $" + formatter.format(this.getPriceForOne()) + "\tPrice for Two: $"
				+ formatter.format(this.getPriceForTwo()) + "\tPrice for Three:  $" + formatter.format(this.getPriceForThree()) ;
	}

}
