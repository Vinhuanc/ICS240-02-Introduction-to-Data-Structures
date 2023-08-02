package restaurant;

public class RestaurantDriver {

	public static void main(String[] args) {
		Order ord1 = new Order("12");
        Order ord2 = new Order("45");

        ord1.insert(new MenuItem("Chow Mein",2.5,1));
        ord1.insert(new MenuItem("Fried Wontons",1.5,3));
        ord1.insert(new MenuItem("Egg Foo Young",7.8,4));
        ord1.insert(new MenuItem("Kong Pao Chicken",18.25,2));
        ord1.insert(new MenuItem("Sushi",12.5,1));
        ord1.insert(new MenuItem("Chicken Fried Rice",13.5,3));
        ord1.insert(new MenuItem("Spring rolls ",5.8,4));
        ord1.insert(new MenuItem("Sweet and Sour Chicken",8.25,2));
        
        ord1.inOrder();
        System.out.println("\n\n");
        ord1.preOrder();
        System.out.println("\n\n");
        ord1.postOrder();
        System.out.println("\n\n");

        ord2.insert(new MenuItem("Chow Mein",2.5,1));
        ord2.insert(new MenuItem("Fried Wontons",1.5,3));
        ord2.insert(new MenuItem("Spring rolls ",5.8,4));
        ord2.insert(new MenuItem("Sweet and Sour Chicken",8.25,2));
        ord2.insert(new MenuItem("Sushi",12.5,1));
        ord2.insert(new MenuItem("Chicken Fried Rice",13.5,3));
        ord2.insert(new MenuItem("Egg Foo Young",7.8,4));
        ord2.insert(new MenuItem("Kong Pao Chicken",18.25,2));

        

        System.out.println(ord1);
        System.out.println( ord1.size());
        System.out.println(ord1.depth());
        System.out.println("quantity" + ord1.getTotalQty());
        System.out.println(ord1.search("Chow Mein"));
        System.out.println(ord1.getTotalBeforeTax());
        System.out.println(ord1.getTax(8));
        System.out.println(ord1.getTip(20));
        System.out.println(ord1.toString());
        System.out.println(ord1.size());
        System.out.println(ord1.size());


        
        
        System.out.println(ord2);
        
	}

}
