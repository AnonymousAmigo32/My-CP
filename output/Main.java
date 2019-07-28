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
		CANDY solver = new CANDY();
		try {
			int testNumber = 1;
			while (true)
				solver.solve(testNumber++, in, out);
		} catch (UnknownError e) {
			out.close();
		}
	}

	static class CANDY {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int size = in.nextInt();
			if (size == -1) {
				throw new UnknownError();
			}
			int[] arr = new int[size];
			int sum = 0;
			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
				sum += arr[i];
			}
			double avg = sum / (double) size;
			if (avg != Math.floor(avg)) {
				out.println(-1);
				return;
			}
			int avgI = (int) avg;
			int ans = 0;
			for (int i = 0; i < size; i++) {
				if (arr[i] < avgI) {
					ans += avgI - arr[i];
				}
			}
			out.println(ans);
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

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}

