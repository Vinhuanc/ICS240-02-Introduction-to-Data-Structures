package project;

public class MedicationBinaryNode {
	Medication data;
	MedicationBinaryNode leftChild;
	MedicationBinaryNode rightChild;
	
	public MedicationBinaryNode(Medication data, MedicationBinaryNode leftChild, MedicationBinaryNode rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public Medication getData() {
		return data;
	}

	public void setData(Medication data) {
		this.data = data;
	}

	public MedicationBinaryNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(MedicationBinaryNode leftChild) {
		this.leftChild = leftChild;
	}

	public MedicationBinaryNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(MedicationBinaryNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public boolean isLeaf() {
		return leftChild == null && rightChild == null;
	}
	
}
