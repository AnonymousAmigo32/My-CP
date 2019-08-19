package AlgorithmsImpl;

/**
 * @author kishore
 */
public class MergeSort {
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}

	public static void sort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(arr, left, mid);
			sort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int leftArraySize = mid - left + 1;
		int rightArraySize = right - mid;
		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		for (int i = left; i <= mid; i++) {
			leftArray[i - left] = arr[i];
		}
		for (int i = mid + 1; i <= right; i++) {
			rightArray[i - mid - 1] = arr[i];
		}

		int indexOfLeftArray = 0;
		int indexOfRightArray = 0;
		int indexInMainArray = left;

		while (indexOfLeftArray < leftArraySize && indexOfRightArray < rightArraySize) {
			if (leftArray[indexOfLeftArray] < rightArray[indexOfRightArray]) {
				arr[indexInMainArray++] = leftArray[indexOfLeftArray++];
			} else {
				arr[indexInMainArray++] = rightArray[indexOfRightArray++];
			}
		}

		while (indexOfLeftArray < leftArraySize) {
			arr[indexInMainArray++] = leftArray[indexOfLeftArray++];
		}
		while (indexOfRightArray < rightArraySize) {
			arr[indexInMainArray++] = rightArray[indexOfRightArray++];
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3, 3, 52, 26, 38, 57, 9, 49};
		sort(arr);
		for (int i : arr)
			System.out.print(i + " ");
	}
}
