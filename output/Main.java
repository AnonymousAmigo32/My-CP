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
		TOANDFRO solver = new TOANDFRO();
		try {
			int testNumber = 1;
			while (true)
				solver.solve(testNumber++, in, out);
		} catch (UnknownError e) {
			out.close();
		}
	}

	static class TOANDFRO {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int size = in.nextInt();
			if (size == 0) {
				throw new UnknownError();
			}
			StringBuilder string = new StringBuilder(in.next()).reverse();
			StringBuilder[] matrix = new StringBuilder[string.length() / size];
//        for (int i=0;i<size;i++)matrix[i] = new StringBuilder();
			boolean evenRow = true;
			int arrI = 0;
			while (string.length() > 0) {
				StringBuilder line = new StringBuilder(string.substring(string.length() - size));
				string = string.delete(string.length() - size, string.length());
				if (evenRow) {
					matrix[arrI++] = line.reverse();
				} else {
					matrix[arrI++] = line;
				}
				evenRow = !evenRow;
			}
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < matrix.length; j++) {
					out.print(matrix[j].charAt(i));
				}
			}
			out.println();
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

