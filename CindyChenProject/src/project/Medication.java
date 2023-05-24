package project;

public class Medication implements Comparable<Medication>{
	private String genericName;
	private int numOfUsers;
	private String mainPurpose;
	private int yearPublic;
	
	public Medication(String genericName, int numOfUsers, String mainPurpose, int yearPublic) {
		this.genericName = genericName;
		this.numOfUsers = numOfUsers;
		this.mainPurpose = mainPurpose;
		this.yearPublic = yearPublic;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public int getNumOfUsers() {
		return numOfUsers;
	}

	public void setNumOfUsers(int numOfUsers) {
		this.numOfUsers = numOfUsers;
	}

	public String getMainPurpose() {
		return mainPurpose;
	}

	public void setMainPurpose(String mainPurpose) {
		this.mainPurpose = mainPurpose;
	}

	public int getYearPublic() {
		return yearPublic;
	}

	public void setYearPublic(int yearPublic) {
		this.yearPublic = yearPublic;
	}
	
	public String toString() {
		return "Medication: \t" + this.genericName + ", num of users: \t #" + this.numOfUsers + "Main purpose: \t" + this.mainPurpose + "Year open to public: \t" + this.yearPublic;
	}

	public boolean equals(Medication med) {
		if(this.toString().equalsIgnoreCase(med.toString())) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Medication med) {
		if(this.getGenericName().compareTo(med.getGenericName()) >0) {
			return 1;
		} else if(this.getGenericName().compareTo(med.getGenericName()) < 0) {
			return -1;
		} else {
			return 1;
		}
	}
}	

