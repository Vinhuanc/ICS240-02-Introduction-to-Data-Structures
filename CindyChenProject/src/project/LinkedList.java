package project;

import java.util.Iterator;

public class LinkedList<E extends Comparable<E>> implements Iterable<E>{
	 Node<E> head;

	public LinkedList() {
		super();
		head = null;
		
	}

	public void add(E med) {
		head = new Node<E>(med, head);

	}
	
	public void addMedication(E med) {
		if(head == null) {
			head = new Node<E>(med, null);
		} else if(med.compareTo(head.getData()) > 0) {
			head = new Node<E>(med, head);
		} else {
			Node<E> previous = findPreviousNodeAdd(med);
			previous.setLink(new Node<E>(med, previous.getLink()));
		}
	}
	
	private Node<E> findPreviousNodeAdd(E med) {
		Node<E> cursor = head;
		while(cursor.getLink() != null && cursor.getLink().getData().compareTo(med) > 0) {
			cursor = cursor.getLink();
		}
		return cursor;
	}

	private Node<E> findPreviousNodeRemove(E med) {
		Node<E> cursor = head;
		while(cursor.getLink() != null && !cursor.getLink().getData().equals(med)){
			cursor = cursor.getLink();
		}
	
		return cursor;
	}
	
	public void delete(E med) {
		if(head != null && head.getData().equals(med)) {
			head = head.getLink();
			
		} else if(head != null) {
			Node<E> previous = findPreviousNodeRemove(med);
			previous.setLink(previous.getLink().getLink());
			}
	}
	
	public int size() {
		int num = 0;
		Node<E> cursor = head;
		while(cursor != null) {
			num++;
			cursor = cursor.getLink();
		}
		return num;
	}
	
	public boolean isEmpty() {
		if(head == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public int indexOf(Medication med) {
        int index = 1;
        Node<E> curr = head;
        while (curr != null && !med.equals(curr.getData())) {
            index++;
            curr = curr.getLink();
        }
        if (curr == null) {
            return -1;
        }
        return index;
    }
	
	public E grab(int num) {
		int count = 1;
		Node<E> cursor = head;
		while(cursor != null) {
			count++;
			cursor = cursor.getLink();
		}
		if(num < 1 || num > count) {
			return null;
		} else {
			int index = 1;
			cursor = head;
			while(index < num) {
				index++;
				cursor = cursor.getLink();
			}
			return cursor.getData();
		}
	}
	
	public boolean contains(E med) {
		Node<E> current = head;
		while(current != null && med.compareTo(current.getData()) != 0 ) {
			current = current.getLink();
		}
		return current !=null;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Generic Name: \t Number of Users \t Main Purpose \t Year Public \t\n");
		sb.append("-----\t-----\t-----\t-----\t\n");
		Node<E> current = head;
		while(current != null) {
			sb.append(current.getData().toString());
			sb.append("\n");
			current = current.getLink();
		}
		return sb.toString();
	}
	
	 public int countOccurrences(Medication med) {
		 Node<E> current = head;
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
		 Node<E> curr = head;
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
		public Iterator<E> iterator() {

			return null;
		}
		
		private class MedicationIterator implements Iterator<E>{
			int manyNodes;
			public MedicationIterator() {
				super();
				Node<E> current = head;
			}

			@Override
			public boolean hasNext() {
				Node<E> current = head;
				if(current.getData() != null) {
					return true;
				} else 
					return false;
			}

			@Override
			public E next() {
				Node<E> current = head;
				if(current != null) {
					 return current.getData();
				} else {
					return null;
				}
			}

		}

		
}