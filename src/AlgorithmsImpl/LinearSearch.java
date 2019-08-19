package AlgorithmsImpl;

/**
 * @author kishore-8626
 */
public class LinearSearch {
	/**
	 * Linearly searches for the element in array O(n).
	 *
	 * @param array   the array from which the index of element to be found.
	 * @param element the element to find index of.
	 * @return index if element exist in array or null.
	 */
	public static Integer search(int[] array, int element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return i;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[]{1, 2, 3}, -1));
	}
}
