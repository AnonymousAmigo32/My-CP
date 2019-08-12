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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskB {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int size = in.nextInt();
			int[][] arr = new int[2 * size + 1][2 * size + 1];
			for (int i = 0; i <= size; i++) {
				arr[size][i] = arr[size][2 * size - i] = i;
			}
			for (int i = 1; i <= size; i++) {
				for (int j = 0; j < 2 * size + 1; j++) {
					arr[size + i][j] = arr[size - i][j] = arr[size][j] - i;
				}
			}
			for (int i = 0; i < 2 * size + 1; i++) {
				if (arr[0][i] < 0) {
					out.print("  ");
				} else {
					out.print("0\n");
					break;
				}
			}
			for (int i = 1; i < 2 * size; i++) {
				boolean positive = false;
				for (int j = 0; j < 2 * size + 1; j++) {
					if (arr[i][j] < 0) {
						out.print("  ");
					} else if (arr[i][j] == 0) {
						if (positive) {
							out.println(0);
							break;
						} else {
							positive = true;
							out.print("0 ");
						}
					} else {
						out.print(arr[i][j] + " ");
					}
				}
			}
			for (int i = 0; i < 2 * size + 1; i++) {
				if (arr[0][i] < 0) {
					out.print("  ");
				} else {
					out.println("0");
				}
			}
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
}

