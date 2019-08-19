package AlgorithmsImpl;

import static AlgorithmsImpl.CPUtility.swap;

/**
 * @author kishore
 */
public class BubbleSort {
	/**
	 * sorts an array in Ascending fashion. O(n^2);
	 *
	 * @param array array to sort.
	 */
	public static void sortAscending(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					swap(j, j - 1, array);
				}
			}
		}
	}

	public static void sortDescending(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] > array[j - 1]) {
					swap(j, j - 1, array);
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{-100, 44, 2, 1, 3, 42, -1, -1, -100};
		sortDescending(array);
		for (int i : array) System.out.print(i + " ");
	}
}
