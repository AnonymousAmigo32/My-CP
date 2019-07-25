import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
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
		MajorityElement solver = new MajorityElement();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class MajorityElement {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int size = in.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < size; j++) {
				int val = in.nextInt();
				if (map.containsKey(val)) {
					map.put(val, map.get(val) + 1);
				} else {
					map.put(val, 1);
				}
			}
			boolean printed = false;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() > size / 2) {
					out.println(entry.getKey());
					printed = true;
					break;
				}
			}
			if (!printed) {
				out.println(-1);
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

