package AlgorithmsImpl;

/**
 * @author kishore
 */
public class BinarySearch {
	/**
	 * Searches for an element in a sorted array. O(log(n));
	 *
	 * @param array           array to search for the element.
	 * @param elementToSearch element to search in array.
	 * @return index of element if present in array else -1.
	 */
	public static int search(int[] array, int elementToSearch) {
		return search(array, 0, array.length - 1, elementToSearch);
	}

	/**
	 * Searches for an element in a sorted array and in given range. O(log(n));
	 *
	 * @param array           array to search for the element.
	 * @param leftBoundary    leftBoundary of range.
	 * @param rightBoundary   rightBoundary of range.
	 * @param elementToSearch element to search in array.
	 * @return index of element if present in array of given range else -1.
	 */
	private static int search(int[] array, int leftBoundary, int rightBoundary, int elementToSearch) {
		if (leftBoundary <= rightBoundary) {
			int mid = (leftBoundary + rightBoundary) / 2;
			if (array[mid] == elementToSearch) {
				return mid;
			} else if (array[mid] < elementToSearch) {
				return search(array, mid + 1, rightBoundary, elementToSearch);
			} else {
				return search(array, leftBoundary, mid - 1, elementToSearch);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{4, 5, 6, 7, 10};
		System.out.println(search(arr, 6));
	}
}
