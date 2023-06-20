package project;

import java.util.Iterator;

public class MedicationCollectionLinkedList implements Iterable<Medication>{
	MedicationNode head;
	int manyNodes;

	public MedicationCollectionLinkedList() {
		super();
		head = null;
		manyNodes=0;
	}

	public void add(Medication med) {
		head = new MedicationNode(med, head);
		manyNodes++;

	}
	
	public void addMedication(Medication med) {
		if(head == null) {
			head = new MedicationNode(med, null);
		} else if(med.compareTo(head.getData()) > 0) {
			head = new MedicationNode(med, head);
		} else {
			MedicationNode previous = findPreviousNodeAdd(med);
			previous.setLink(new MedicationNode(med, previous.getLink()));
		}
		manyNodes++;
	}
	
	private MedicationNode findPreviousNodeAdd(Medication med) {
		MedicationNode cursor = head;
		while(cursor.getLink() != null && cursor.getLink().getData().compareTo(med) > 0) {
			cursor = cursor.getLink();
		}
		return cursor;
	}

	private MedicationNode findPreviousNodeRemove(Medication med) {
		MedicationNode cursor = head;
		while(cursor.getLink() != null && !cursor.getLink().getData().equals(med)){
			cursor = cursor.getLink();
		}
		return cursor;
	}
	
	public void delete(Medication med) {
		if(head != null && head.getData().equals(med)) {
			head = head.getLink();
			
		} else if(head != null) {
			MedicationNode previous = findPreviousNodeRemove(med);
			previous.setLink(previous.getLink().getLink());
			}
	}
	
	public int size() {
		return manyNodes;
	}
	
	public boolean isEmpty() {
		if(manyNodes == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int indexOf(Medication med) {
        int index = 1;
        MedicationNode curr = head;
        while (curr != null && !med.equals(curr.getData())) {
            index++;
            curr = curr.getLink();
        }
        if (curr == null) {
            return -1;
        }
        return index;
    }
	
	public Medication grab(int num) {
		if(num < 1 || num > manyNodes) {
			return null;
		}
		MedicationNode current = head;
		for(int i = 1; i<num; i++) {
			current = current.getLink();
		}
		return current.getData();
	}
	
	public boolean contains(Medication med) {
		MedicationNode current = head;
		while(current != null && med.compareTo(current.getData()) != 0 ) {
			current = current.getLink();
		}
		return current !=null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Generic Name: \t Number of Users \t Main Purpose \t Year Public \t\n");
		sb.append("-----\t-----\t-----\t-----\t\n");
		MedicationNode current = head;
		while(current != null) {
			sb.append(current.getData().toString());
			sb.append("\n");
			current = current.getLink();
		}
		return sb.toString();
	}
	
	 public int countOccurrences(Medication med) {
		 MedicationNode current = head;
	        int count = 0;
	        while (current != null) {
	            if (current.getData().equals(med)) {
	                count++;
	            }
	            current = current.getLink();
	        }
	        return count;
	 }
	 
	 public int lastIndexOf(Medication med) {
		 int index = 1;
	        MedicationNode curr = head;
	        while (curr != null && !med.equals(curr.getData())) {
	            index++;
	            curr = curr.getLink();
	        }
	        if (curr == null) {
	            return -1;
	        }
	        return index;
		}
	 @Override
		public Iterator<Medication> iterator() {

			return null;
		}
		
		private class MedicationIterator implements Iterator<Medication>{
			int manyNodes;
			public MedicationIterator() {
				super();
				MedicationNode current = head;
			}

			@Override
			public boolean hasNext() {
				MedicationNode current = head;
				if(current.getData() != null) {
					return true;
				} else 
					return false;
			}

			@Override
			public Medication next() {
				MedicationNode current = head;
				if(current != null) {
					 return current.getData();
				} else {
					return null;
				}
			}

		}
}