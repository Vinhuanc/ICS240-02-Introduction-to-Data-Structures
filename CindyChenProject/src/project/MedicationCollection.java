package project;

import java.util.Iterator;

public class MedicationCollection implements Iterable<Medication> {
	private Medication[] medications;
	private int count;

	public MedicationCollection(int maxCount) {
		medications = new Medication[maxCount];
		count = 0;
	}

	public boolean insert(Medication med) {
		if (count < medications.length) {
			int i;
			for (i = count - 1; i >= 0 && medications[i].compareTo(med) > 0; i--) {
				medications[i + 1] = medications[i];
			}
			medications[i + 1] = med;
			count++;
			return true;
		} else {
			return false;
		}
	}

	public int findMedication(Medication med) {
		for (int i = 0; i < count; i++) {
			if (medications[i].equals(med)) {
				return i;
			}
		}
		return -1;
	}

	public void delete(Medication med) {
		int index = findMedication(med);
	
		for (int i = index + 1; i < count; i++) {
			medications[i - 1] = medications[i];
		}
		count--;
	}

	public int size() {
		int size = 0;
		for (int i = 0; i < medications.length; i++) {
			if (medications[i] != null) {
				size++;
			}
		}
		return size;
	}

	public boolean isEmpty() {
		for (int i = 0; i < medications.length; i++) {
			if (medications[i] == null) {
				return true;
			}
		}
		return false;
	}

	public int indexOf(Medication med) {
		int index = 0;
		for (int i = 0; i < medications.length; i++) {
			if (medications[i].toString() == med.toString()) {
				index = i;
			} 
		}
		return index;
	}

	public int lasIndexOf(Medication med) {
		int index = 0;
		for (int i = 0; i < medications.length; i++) {
			if (medications[i].toString() == med.toString()) {
				index = i;
			} 
		}
		return index;
	}

	public Medication grab(int num) {
		if (medications[num] != null) {
			return medications[num];

		} else {
			return null;
		}
	}

	public boolean contains(Medication med) {
		for (int i = 0; i < medications.length; i++) {
			if (medications[i].equals(med)) {
				return true;
			}

		}
		return false;
	}

	public String toString() {
		String data = "Generic Name: \t Main Purpose: \t Population: \t Year of Public: \t \n";
		data += "--------------------------------------\n";
		for (int i = 0; i < count; i++) {
			data += medications[i].getGenericName() + " \t" + medications[i].getMainPurpose() + "\t"
					+ medications[i].getNumOfUsers() + " \t\t" + medications[i].getYearPublic() + "\n";
		}
		return data;
	}
	
	public int countOccurrences(Medication med) {
		int count = 0;
		for (int i = 0; i < count; i++) {
			if(medications[i].equals(med)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public Iterator<Medication> iterator() {

		return null;
	}
	
	private class MedicationIterator implements Iterator<Medication>{
		int cursor = 0;
		
		public MedicationIterator(int cursor) {
			super();
			this.cursor = cursor;
		}

		@Override
		public boolean hasNext() {
			if(cursor < count) {
				return true;
			} else 
				return false;
		}

		@Override
		public Medication next() {
			return medications[cursor];
		}

	}
	
	
	
	
	
	

}
