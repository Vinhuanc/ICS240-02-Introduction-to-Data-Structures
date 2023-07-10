package Menu;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ItemIncreasedOptions extends Item {
	private double priceForFour;
	private double priceForFive;
	private double priceForSix;
	
	public ItemIncreasedOptions(String name, double priceForOne, double priceForTwo, double priceForThree,double priceForFour, double priceForFive, double priceForSix) {
		super(name, priceForOne, priceForTwo, priceForThree);
		this.priceForFour = priceForFour;
		this.priceForFive = priceForFive;
		this.priceForSix = priceForSix;
	}

	public double getPriceForFour() {
		return priceForFour;
	}

	public void setPriceForFour(double priceForFour) {
		this.priceForFour = priceForFour;
	}

	public double getPriceForFive() {
		return priceForFive;
	}

	public void setPriceForFive(double priceForFive) {
		this.priceForFive = priceForFive;
	}

	public double getPriceForSix() {
		return priceForSix;
	}

	public void setPriceForSix(double priceForSix) {
		this.priceForSix = priceForSix;
	}

	@Override
	public String toString() {
		NumberFormat formatter = new DecimalFormat("#0.00");     
		return "Item name: " + this.getName() + "\tPrice for One:  $" + formatter.format(this.getPriceForOne()) + "\tPrice for Two: $"
				+ formatter.format(this.getPriceForTwo()) + "\tPrice for Three:  $" + formatter.format(this.getPriceForThree()) + "\tPrice for Four:  $" + formatter.format(this.getPriceForFour())
				+ "\tPrice for Five:  $" + formatter.format(this.getPriceForFive()) + "\tPrice for Six:  $" + formatter.format(this.getPriceForSix());
	}

}
