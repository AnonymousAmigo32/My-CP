package AlgorithmsImpl;

import static AlgorithmsImpl.CPUtility.swap;

/**
 * @author kishore
 */
public class SelectionSort {
	/**
	 * Sorts elements in array in Ascending fashion. O(n^2);
	 *
	 * @param array array to be sorted.
	 */
	public static void sortAscending(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int j = i;
			int minPosition = j;
			int minValue = array[j];
			while (j++ < array.length - 1) {
				if (array[j] < minValue) {
					minPosition = j;
					minValue = array[j];
				}
			}
			swap(i, minPosition, array);
		}
	}

	public static void sortDescending(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int j = i;
			int maxPosition = j;
			int maxValue = array[j];
			while (j++ < array.length - 1) {
				if (array[j] > maxValue) {
					maxPosition = j;
					maxValue = array[j];
				}
			}
			swap(i, maxPosition, array);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{-1, 100, 2, 3, 18, 1, -10000, 0};
		sortDescending(arr);
		for (int i : arr)
			System.out.print(i + " ");
	}
}
