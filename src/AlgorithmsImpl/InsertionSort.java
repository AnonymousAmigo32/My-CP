package AlgorithmsImpl;

/**
 * @author kishore-8626
 */
public class InsertionSort {
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			while (j >= 0 && arr[j] > arr[j + 1]) {
				CPUtility.swap(j, j + 1, arr);
				j--;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{100, -1, 300, 2, -10};
		sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
