package project;

public class MedicationTree {
	MedicationBinaryNode root;
	
	public MedicationTree(){
		root = null;
	}
	
	public void inOrder() {
		inOrder(root);
	}

	// helper method, private method
	private void inOrder(MedicationBinaryNode current) {
		if(current != null) {
		inOrder(current.getLeftChild());
		System.out.println(current.getData());
		inOrder(current.getRightChild());
		}
	}
	
	public void add(Medication element) {
		if(root == null) {
			root = new MedicationBinaryNode(element, null, null);
		} else {
			add(root, element);
		}
	}

	private void add(MedicationBinaryNode current, Medication element) {
		if(element.compareTo(current.getData()) <= 0) {
			if(current.getLeftChild() == null) {
				current.setLeftChild(new MedicationBinaryNode(element, null, null));
			} else {
				add(current.getLeftChild(), element);
			}
		} else {
			if(current.getRightChild() == null) {
				current.setRightChild(new MedicationBinaryNode(element, null, null));
			} else {
				add(current.getRightChild(), element);
			}
		}
	}
	
	public boolean delete(Medication target) {
		
		
		MedicationBinaryNode parent = null;
		MedicationBinaryNode current = root;
		
		while(current != null && !current.getData().equals(target)) {
			parent = current;
			if(target.compareTo(current.getData()) <= 0) {
				current = current.getLeftChild();
			} else {
				current = current.getRightChild();
			}
		}
		if(current == null) {
			return false;
		}
		if(current.isLeaf()) {
			if(parent == null) {
				root = null;
			} else {
				if(parent.getLeftChild().getData().equals(target)) {
					parent.setLeftChild(null);
				} else {
					parent.setRightChild(null);
				}
			}
		} else if(current.getLeftChild() != null || current.getRightChild() != null) {
			MedicationBinaryNode child;
			if(current.getLeftChild() == null) {
				child = current.getRightChild();
			} else {
				child = current.getLeftChild();
			}
			if(parent == null) {
				root = child;
			} else {
				if(parent.getLeftChild().getData().equals(target)) {
					parent.setLeftChild(child);
				} else {
					parent.setRightChild(child);
				}
			}
			
		} else {
			Medication val = findMax(current.getLeftChild());
			delete(val);
			current.setData(val);
		}
		return true;
	}

	private Medication findMax(MedicationBinaryNode current) {
		if(current.getRightChild() == null) {
			return current.getData();
		} else {
			return findMax(current.getRightChild());
		}
	}
}
