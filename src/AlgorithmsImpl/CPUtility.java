package AlgorithmsImpl;

/**
 * @author kishore-8626
 */
public class CPUtility {
	/**
	 * Swaps two elements in an array.
	 *
	 * @param index1 index of an element.
	 * @param index2 index of another element.
	 * @param array  array in which the elements are to be swapped.
	 */
	public static void swap(int index1, int index2, int[] array) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
