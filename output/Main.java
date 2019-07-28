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
		PCOINS solver = new PCOINS();
		solver.solve(1, in, out);
		out.close();
	}

	static class PCOINS {
		private final static int SIZE = 1000000;
		int[] arr = new int[SIZE];

		public void solve(int testNumber, InputReader in, PrintWriter out) {
			calc();
			while (in.hasNext()) {
				long val = in.nextLong();
				out.println(res(val));
			}
		}

		private void calc() {
			for (int i = 1; i < SIZE; i++) {
				arr[i] = Math.max(arr[i / 2] + arr[i / 3] + arr[i / 4], i);
			}
		}

		private long calc(long val) {
			if (val >= SIZE) {
				return Math.max(calc(val / 2) + calc(val / 3) + calc(val / 4), val);
			} else {
				return arr[(int) val];
			}
		}

		private long res(long val) {
			if (val >= SIZE) {
				return calc(val);
			}
			return arr[(int) val];
		}

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

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

		public long nextLong() {
			return Long.parseLong(next());
		}

		public boolean hasNext() {
			try {
				if (!reader.ready()) {
					if (tokenizer == null || !tokenizer.hasMoreTokens()) {
						tokenizer = new StringTokenizer(reader.readLine());
					}
					if (tokenizer != null && tokenizer.hasMoreTokens())
						return true;
					return false;
				}
			} catch (Exception e) {
				return false;
			}
			return true;
		}

	}
}

