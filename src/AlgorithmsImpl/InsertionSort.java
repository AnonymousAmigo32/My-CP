package AlgorithmsImpl;

/**
 * @author kishore
 */
public class InsertionSort {
	/**
	 * Sorts elements in array in Ascending fashion. O(n^2);
	 *
	 * @param array array to be sorted.
	 */
	public static void sortAscending(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			while (j >= 0 && array[j] > array[j + 1]) {
				CPUtility.swap(j, j + 1, array);
				j--;
			}
		}
	}

	/**
	 * Sorts elements in array in Descending fashion. O(n^2);
	 *
	 * @param array array to be sorted.
	 */
	public static void sortDescending(int[] array) {
		for (int i = array.length - 2; i >= 0; i--) {
			int j = i + 1;
			while (j < array.length && array[j] > array[j - 1]) {
				CPUtility.swap(j, j - 1, array);
				j++;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{5, 4, 3, 2, 1};
		sortDescending(arr);
		System.out.print("Descending : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		sortAscending(arr);
		System.out.print("\nAscending  : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
