package AlgorithmsImpl;

/**
 * @author kishore-8626
 */
public class CPUtility {
	public static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
