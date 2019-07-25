import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		LeadersInArray solver = new LeadersInArray();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class LeadersInArray {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int size = in.nextInt();
			List<Integer> list = new ArrayList<>();
			while (size-- > 0) {
				list.add(in.nextInt());
			}
			int max = Integer.MIN_VALUE;
			List<Integer> solList = new ArrayList<>();
			for (int i = list.size() - 1; i >= 0; i--) {
				if (list.get(i) >= max) {
					max = list.get(i);
					solList.add(list.get(i));
				}
			}
			for (int i = solList.size() - 1; i >= 0; i--) {
				out.println(solList.get(i));
			}
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

