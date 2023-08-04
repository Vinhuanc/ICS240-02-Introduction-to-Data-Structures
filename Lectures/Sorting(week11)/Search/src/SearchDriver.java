

//Majority of code provided by GeeksForGeeks.org

public class SearchDriver {

	public static void main(String[] args) {
		timeMergeSort();
		timeQuickSort();
		timeShellSort();
	}

	public static void shellSort(int[] data) {
		int n = data.length;

		for (int gap = n/2; gap > 0; gap /= 2){
			for (int i = gap; i < n; i++){
				int temp = data[i];
				int j;
				for (j = i; j >= gap && data[j - gap] > temp; j -= gap)
					data[j] = data[j - gap];
				data[j] = temp;
			}
		}
	}

	public static void mergeSort(int[] data, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middleIndex = (rightIndex + leftIndex) / 2;
			// sort first half
			mergeSort(data, leftIndex, middleIndex);
			// sort second half
			mergeSort(data, middleIndex + 1, rightIndex);
			// merge the two sorted halves
			merge(data, leftIndex, middleIndex, rightIndex);
		}
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			// pi is partitioning index, arr[p]
			// is now at right place
			int pi = partition(arr, low, high);

			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private static int partition(int[] data, int low, int high) {
		// pivot
		int pivot = data[high];

		// Index of smaller element and
		// indicates the right position
		// of pivot found so far
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			// If current element is smaller
			// than the pivot
			if (data[j] < pivot) {

				// Increment index of
				// smaller element
				i++;
				swap(data, i, j);
			}
		}
		swap(data, i + 1, high);
		return (i + 1);
	}

	public static void merge(int[] data, int leftIndex, int middleIndex, int rightIndex) {
		int leftSize = middleIndex - leftIndex + 1;
		int rightSize = rightIndex - middleIndex;
		int[] leftTemp = new int[leftSize + 1]; // create temp arrays to store data so it doesn’t get pushed out back
		int[] rightTemp = new int[rightSize + 1];
		leftTemp[leftSize] = Integer.MAX_VALUE; // put huge value at the end of arrays
		rightTemp[rightSize] = Integer.MAX_VALUE;
		
		for (int i = 0; i < leftSize; i++) { // copy data to temp arrays
			leftTemp[i] = data[leftIndex + i];
		}
		
		for (int i = 0; i < rightSize; i++) {
			rightTemp[i] = data[middleIndex + 1 + i];
		}
		
		int tempLeftIndex = 0;
		int tempRightIndex = 0;
		for (int i = 0; i < leftSize + rightSize; i++) {
			if (leftTemp[tempLeftIndex] < rightTemp[tempRightIndex]) {
				data[leftIndex + i] = leftTemp[tempLeftIndex++];
			} else {
				data[leftIndex + i] = rightTemp[tempRightIndex++];
			}
		}
	}

	public static void timeQuickSort() {
		long timeNeeded;
		System.out.println("Sort results for Quick Sort\n");
		System.out.println("Size     Time ");
		for (int length = 100000; length < 200000; length += 10000) {
			int[] data = new int[length];
			for (int index = 0; index < length; index++) {
				data[index] = (int) (Math.random() * 100 * length);
			}
			long time1 = System.currentTimeMillis();
			quickSort(data, 0, length - 1);
			long time2 = System.currentTimeMillis();
			timeNeeded = time2 - time1;
			System.out.println(length + "   " + timeNeeded);
		}
		System.out.println();
	}
	
	public static void timeMergeSort() {
		long timeNeeded;
		System.out.println("Sort results for Merge Sort\n");
		System.out.println("Size     Time ");
		for (int length = 100000; length < 200000; length += 10000) {
			int[] data = new int[length];
			for (int index = 0; index < length; index++) {
				data[index] = (int) (Math.random() * 100 * length);
			}
			long time1 = System.currentTimeMillis();
			mergeSort(data, 0, length - 1);
			long time2 = System.currentTimeMillis();
			timeNeeded = time2 - time1;
			System.out.println(length + "   " + timeNeeded);
		}
		System.out.println();
	}
	
	public static void timeShellSort() {
		long timeNeeded;
		System.out.println("Sort results for Shell Sort\n");
		System.out.println("Size     Time ");
		for (int length = 100000; length < 200000; length += 10000) {
			int[] data = new int[length];
			for (int index = 0; index < length; index++) {
				data[index] = (int) (Math.random() * 100 * length);
			}
			long time1 = System.currentTimeMillis();
			shellSort(data);
			long time2 = System.currentTimeMillis();
			timeNeeded = time2 - time1;
			System.out.println(length + "   " + timeNeeded);
		}
		System.out.println();
	}

}
