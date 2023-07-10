package Menu;

public class Driver {

	public static void main(String[] args) {
		ItemCollection ic = new ItemCollection("First Item Collection", 100);
		Item chickenEFY = new Item("Chicken Egg Foo Young", 4.40, 8.80, 13.20);
		Item porkEFY = new Item("Pork Egg Foo Young", 4.40, 8.80, 13.20);
		Item shrimpEFY = new Item("Shrimp Egg Foo Young", 4.95, 9.90, 14.85);

		Title EFY = new Title("Egg Foo Young");
		Title CM = new Title("Chow Mein");
		Title FR = new Title("Fried Rice");
		Title FI = new Title("Fried Items");
		Title MTO = new Title("Made To Order");

		TitleCollection tc = new TitleCollection("First Title Collection", 100);
		tc.addTitleIntoCollection(EFY);
		tc.addTitleIntoCollection(CM);
		tc.addTitleIntoCollection(FR);
		tc.addTitleIntoCollection(FI);
		tc.addTitleIntoCollection(MTO);



//	System.out.println(tc.getTitleInfo());

//		System.out.println(chickenEFY.toString());
//		System.out.println(porkEFY.toString());
//		System.out.println(shrimpEFY.toString());

		ic.addItemIntoCollection(chickenEFY);
		ic.addItemIntoCollection(porkEFY);
		ic.addItemIntoCollection(shrimpEFY);

		System.out.println(ic.getItemCollectionInfo());
		
		
		ItemIncreasedOptions regular = new ItemIncreasedOptions("Regular", 3.60, 7.20, 10.80, 14.40, 18.00, 21.60);
		ItemIncreasedOptions chicken = new ItemIncreasedOptions("Chicken", 3.95, 7.90, 11.65, 15.80, 19.75, 23.70);
		ItemIncreasedOptions mushroom = new ItemIncreasedOptions("Mushroom", 3.95, 7.90, 11.65, 15.80, 19.75, 23.70);
		ItemIncreasedOptions subgum = new ItemIncreasedOptions("Subgum", 3.95, 7.90, 11.65, 15.80, 19.75, 23.70);
		ItemIncreasedOptions cMushroom = new ItemIncreasedOptions("Ch.Mushroom", 4.35, 8.70, 13.05, 17.40, 21.75, 26.10);
		ItemIncreasedOptions cSubgum = new ItemIncreasedOptions("Ch.Subgum", 4.35, 8.70, 13.05, 17.40, 21.75, 26.10);
		ItemIncreasedOptions chopSuey = new ItemIncreasedOptions("Chop Suey C.M", 4.35, 8.70, 13.05, 17.40, 21.75, 26.10);

		ItemIncreasedOptionsCollection ioc = new ItemIncreasedOptionsCollection("Food Item", 100);
		ioc.addItemIncreasedOptionsIntoCollection(regular);
		ioc.addItemIncreasedOptionsIntoCollection(chicken);
		ioc.addItemIncreasedOptionsIntoCollection(mushroom);
		ioc.addItemIncreasedOptionsIntoCollection(subgum);
		ioc.addItemIncreasedOptionsIntoCollection(cMushroom);
		ioc.addItemIncreasedOptionsIntoCollection(cSubgum);
		ioc.addItemIncreasedOptionsIntoCollection(chopSuey);

		System.out.println(ioc.getItemIncreasedOptionsCollectionInfo());


	}

}
