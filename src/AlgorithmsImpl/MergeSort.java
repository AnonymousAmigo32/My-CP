package AlgorithmsImpl;

/**
 * @author kishore
 */
public class MergeSort {
	public static void sortAscending(int[] arr) {
		sortAscending(arr, 0, arr.length - 1);
	}

	public static void sortAscending(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			sortAscending(arr, left, mid);
			sortAscending(arr, mid + 1, right);
			mergeAscending(arr, left, mid, right);
		}
	}

	private static void mergeAscending(int[] arr, int left, int mid, int right) {
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

	public static void sortDescending(int[] arr) {
		sortDescending(arr, 0, arr.length - 1);
	}

	public static void sortDescending(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			sortDescending(arr, left, mid);
			sortDescending(arr, mid + 1, right);
			mergeDescending(arr, left, mid, right);
		}
	}

	private static void mergeDescending(int[] arr, int left, int mid, int right) {
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
			if (leftArray[indexOfLeftArray] > rightArray[indexOfRightArray]) {
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
		sortDescending(arr);
		for (int i : arr)
			System.out.print(i + " ");
	}
}
