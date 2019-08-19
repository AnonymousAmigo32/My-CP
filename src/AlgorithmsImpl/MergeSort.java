package AlgorithmsImpl;

/**
 * @author kishore
 */
public class MergeSort {
	/**
	 * Sorts an entire array in Ascending fashion. O(n * log(n));
	 *
	 * @param array array to be sorted.
	 */
	public static void sortAscending(int[] array) {
		sortAscending(array, 0, array.length - 1);
	}

	/**
	 * Sorts given range of an array in Ascending fashion. O(n * log(n));
	 *
	 * @param array          array to be sorted.
	 * @param leftMostIndex  leftMostIndex of Range to be sorted.
	 * @param rightMostIndex rightMostIndex of Range to be sorted.
	 */
	public static void sortAscending(int[] array, int leftMostIndex, int rightMostIndex) {
		if (leftMostIndex < rightMostIndex) {
			int middleIndex = (leftMostIndex + rightMostIndex) / 2;
			sortAscending(array, leftMostIndex, middleIndex);
			sortAscending(array, middleIndex + 1, rightMostIndex);
			mergeAscending(array, leftMostIndex, middleIndex, rightMostIndex);
		}
	}

	/**
	 * Merges the sub-arrays in ascending order.
	 *
	 * @param array          array to be sorted.
	 * @param leftMostIndex  leftMostIndex of sub-array range.
	 * @param middleIndex    middleIndex of sub-array range.
	 * @param rightMostIndex rightMostIndex of sub-array range.
	 */
	private static void mergeAscending(int[] array, int leftMostIndex, int middleIndex, int rightMostIndex) {
		int leftArraySize = middleIndex - leftMostIndex + 1;
		int rightArraySize = rightMostIndex - middleIndex;
		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		for (int i = leftMostIndex; i <= middleIndex; i++) {
			leftArray[i - leftMostIndex] = array[i];
		}
		for (int i = middleIndex + 1; i <= rightMostIndex; i++) {
			rightArray[i - middleIndex - 1] = array[i];
		}

		int indexOfLeftArray = 0;
		int indexOfRightArray = 0;
		int indexInMainArray = leftMostIndex;

		while (indexOfLeftArray < leftArraySize && indexOfRightArray < rightArraySize) {
			if (leftArray[indexOfLeftArray] < rightArray[indexOfRightArray]) {
				array[indexInMainArray++] = leftArray[indexOfLeftArray++];
			} else {
				array[indexInMainArray++] = rightArray[indexOfRightArray++];
			}
		}

		while (indexOfLeftArray < leftArraySize) {
			array[indexInMainArray++] = leftArray[indexOfLeftArray++];
		}
		while (indexOfRightArray < rightArraySize) {
			array[indexInMainArray++] = rightArray[indexOfRightArray++];
		}
	}

	/**
	 * Sorts an entire array in Descending fashion. O(n * log(n));
	 *
	 * @param array array to be sorted.
	 */
	public static void sortDescending(int[] array) {
		sortDescending(array, 0, array.length - 1);
	}

	/**
	 * Sorts given range of an array in Descending fashion. O(n * log(n));
	 *
	 * @param array          array to be sorted.
	 * @param leftMostIndex  leftMostIndex of Range to be sorted.
	 * @param rightMostIndex rightMostIndex of Range to be sorted.
	 */
	public static void sortDescending(int[] array, int leftMostIndex, int rightMostIndex) {
		if (leftMostIndex < rightMostIndex) {
			int middleIndex = (leftMostIndex + rightMostIndex) / 2;
			sortDescending(array, leftMostIndex, middleIndex);
			sortDescending(array, middleIndex + 1, rightMostIndex);
			mergeDescending(array, leftMostIndex, middleIndex, rightMostIndex);
		}
	}

	/**
	 * Merges the sub-arrays in descending order.
	 *
	 * @param array          array to be sorted.
	 * @param leftMostIndex  leftMostIndex of sub-array range.
	 * @param middleIndex    middleIndex of sub-array range.
	 * @param rightMostIndex rightMostIndex of sub-array range.
	 */
	private static void mergeDescending(int[] array, int leftMostIndex, int middleIndex, int rightMostIndex) {
		int leftArraySize = middleIndex - leftMostIndex + 1;
		int rightArraySize = rightMostIndex - middleIndex;
		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		for (int i = leftMostIndex; i <= middleIndex; i++) {
			leftArray[i - leftMostIndex] = array[i];
		}
		for (int i = middleIndex + 1; i <= rightMostIndex; i++) {
			rightArray[i - middleIndex - 1] = array[i];
		}

		int indexOfLeftArray = 0;
		int indexOfRightArray = 0;
		int indexInMainArray = leftMostIndex;

		while (indexOfLeftArray < leftArraySize && indexOfRightArray < rightArraySize) {
			if (leftArray[indexOfLeftArray] > rightArray[indexOfRightArray]) {
				array[indexInMainArray++] = leftArray[indexOfLeftArray++];
			} else {
				array[indexInMainArray++] = rightArray[indexOfRightArray++];
			}
		}

		while (indexOfLeftArray < leftArraySize) {
			array[indexInMainArray++] = leftArray[indexOfLeftArray++];
		}
		while (indexOfRightArray < rightArraySize) {
			array[indexInMainArray++] = rightArray[indexOfRightArray++];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3, 3, 52, 26, 38, 57, 9, 49};
		sortDescending(arr);
		for (int i : arr)
			System.out.print(i + " ");
	}
}
