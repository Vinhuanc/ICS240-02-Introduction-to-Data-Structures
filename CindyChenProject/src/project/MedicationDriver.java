package project;


public class MedicationDriver {

	public static void main(String[] args) {

//		MedicationCollection mc = new MedicationCollection(6);
//		
//		Medication one = new Medication("Atorvastatin",24493971, "Cholesterol", 1996  );
//		Medication two = new Medication("Amoxicillin",20368921 , "Antibiotic", 1972);
//		Medication three = new Medication("Lisinopril", 19990170, "Blood Pressure", 1978);
//		Medication four = new Medication("Levothyroxine",19698087 , "Thyroid", 1927 );
//		Medication five = new Medication("Albuterol",19085418 , "Asthma", 1972);
//		Medication six = new Medication("Metformin",17430765 , "Diabetes", 1922);
//
//		mc.insert(one);
//		mc.insert(two);
//		mc.insert(three);
//		mc.insert(four);
//		mc.insert(five);
//		mc.insert(six);
//
//		System.out.println(mc.findMedication(four));
//		
//		mc.delete(two);
//		
//		System.out.println(mc.size());
//		System.out.println(mc.isEmpty());
//		System.out.println(mc.indexOf(two));
//		System.out.println(mc.lasIndexOf(three));
//		System.out.println(mc.grab(3));
//		System.out.println(mc.contains(four));
//		System.out.println(mc.toString());


		MedicationCollectionLinkedList mc = new MedicationCollectionLinkedList();
		Medication one = new Medication("Atorvastatin",24493971, "Cholesterol", 1996  );
		Medication two = new Medication("Amoxicillin",20368921 , "Antibiotic", 1972);
		Medication three = new Medication("Lisinopril", 19990170, "Blood Pressure", 1978);
		Medication four = new Medication("Levothyroxine",19698087 , "Thyroid", 1927 );
		Medication five = new Medication("Albuterol",19085418 , "Asthma", 1972);
		Medication six = new Medication("Metformin",17430765 , "Diabetes", 1922);
		
		mc.addMedication(one);
		mc.addMedication(two);
		mc.addMedication(three);
		mc.addMedication(four);
		mc.addMedication(five);
		mc.delete(five);
		System.out.println(mc.size());
		System.out.println(mc.isEmpty());
		System.out.println(mc.indexOf(four));
		System.out.println(mc.grab(3));
		System.out.println(mc.contains(three));
		System.out.println(mc.countOccurrences(three));
		System.out.println(mc.lastIndexOf(three));

		System.out.println(mc.toString());
	}

}
