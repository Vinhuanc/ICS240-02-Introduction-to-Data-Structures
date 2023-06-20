package project;

public class MedicationNode {
	MedicationNode link;
	Medication data;
	
	public MedicationNode(Medication med, MedicationNode objectBehind) {
		data = med;
		link = objectBehind;
	}

	public MedicationNode getLink() {
		return link;
	}

	public void setLink(MedicationNode link) {
		this.link = link;
	}

	public Medication getData() {
		return data;
	}

	public void setData(Medication data) {
		this.data = data;
	}
	
	
}
