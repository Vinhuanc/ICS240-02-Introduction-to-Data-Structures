package project;

import java.util.Arrays;

public class highBloodPressure extends Medication{
	private String drugClass;
	private boolean isCommon;
	
	public highBloodPressure(String genericName, int numOfUsers, String mainPurpose, int yearPublic, String drugClass, boolean isCommon) {
		super(genericName, numOfUsers, mainPurpose, yearPublic);
		this.drugClass = drugClass;
		this.isCommon = isCommon;
	}

	public String getDrugClass() {
		return drugClass;
	}

	public void setDrugClass(String drugClass) {
		this.drugClass = drugClass;
	}

	public boolean isCommon() {
		return isCommon;
	}

	public void setCommon(boolean isCommon) {
		this.isCommon = isCommon;
	}

	@Override
	public void greetings() {
		System.out.println("Hello from the high blood pressure class!");
	}
	
	@Override
	public String toString() {
		return super.getGenericName() + "\t " + super.getNumOfUsers() + "\t " + super.getMainPurpose() + "\t " + super.getYearPublic() + "\t" + this.drugClass + "\t" + this.isCommon + "\t" ;
	}
	

}
