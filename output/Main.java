import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author kishore
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Puzzles solver = new Puzzles();
		solver.solve(1, in, out);
		out.close();
	}

	static class Puzzles {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[] arr = new int[m];
			for (int i = 0; i < m; i++) arr[i] = in.nextInt();
			MergeSort.sortAscending(arr);
			int min = Integer.MAX_VALUE;
			for (int i = 0; i <= m - n; i++) {
				min = Math.min(min, arr[i + n - 1] - arr[i]);
			}
			out.print(min);
		}

	}

	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}

	static class MergeSort {
		public static void sortAscending(int[] array) {
			sortAscending(array, 0, array.length - 1);
		}

		public static void sortAscending(int[] array, int leftMostIndex, int rightMostIndex) {
			if (leftMostIndex < rightMostIndex) {
				int middleIndex = (leftMostIndex + rightMostIndex) / 2;
				sortAscending(array, leftMostIndex, middleIndex);
				sortAscending(array, middleIndex + 1, rightMostIndex);
				mergeAscending(array, leftMostIndex, middleIndex, rightMostIndex);
			}
		}

		private static void mergeAscending(int[] array, int leftMostIndex, int middleIndex, int rightMostIndex) {
			int leftArraySize = middleIndex - leftMostIndex + 1;
			int rightArraySize = rightMostIndex - middleIndex;
			int[] leftArray = new int[leftArraySize];
			int[] rightArray = new int[rightArraySize];

			for (int i = leftMostIndex; i <= middleIndex; i++) {
				leftArray[i - leftMostIndex] = array[i];
			}
			for (int i = middleIndex + 1; i <= rightMostIndex; i++) {
				rightArray[i - middleIndex - 1] = array[i];
			}

			int indexOfLeftArray = 0;
			int indexOfRightArray = 0;
			int indexInMainArray = leftMostIndex;

			while (indexOfLeftArray < leftArraySize && indexOfRightArray < rightArraySize) {
				if (leftArray[indexOfLeftArray] < rightArray[indexOfRightArray]) {
					array[indexInMainArray++] = leftArray[indexOfLeftArray++];
				} else {
					array[indexInMainArray++] = rightArray[indexOfRightArray++];
				}
			}

			while (indexOfLeftArray < leftArraySize) {
				array[indexInMainArray++] = leftArray[indexOfLeftArray++];
			}
			while (indexOfRightArray < rightArraySize) {
				array[indexInMainArray++] = rightArray[indexOfRightArray++];
			}
		}

	}
}

