import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Comparator;
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
		Reader in = new Reader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskF2 solver = new TaskF2();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskF2 {
		public void solve(int testNumber, Reader in, PrintWriter out) {
			int size = in.nextInt();
			int r = in.nextInt();
			ArrayList<TaskF1.Pair> positives = new ArrayList<>();
			ArrayList<TaskF1.Pair> zeros = new ArrayList<>();
			ArrayList<TaskF1.Pair> negatives = new ArrayList<>();
			int count = 0;
			for (int i = 0; i < size; i++) {
				int req = in.nextInt();
				int add = in.nextInt();
				if (add == 0) {
					zeros.add(new TaskF1.Pair(req, add));
					continue;
				}
				if (add < 0) {
					negatives.add(new TaskF1.Pair(req, add));
					continue;
				}
				if (add > 0) {
					positives.add(new TaskF1.Pair(req, add));
				}
			}
			positives.sort(new Comparator<TaskF1.Pair>() {

				public int compare(TaskF1.Pair o1, TaskF1.Pair o2) {
					return o1.req - o2.req;
				}
			});
			negatives.sort(new Comparator<TaskF1.Pair>() {

				public int compare(TaskF1.Pair o1, TaskF1.Pair o2) {
					return o2.add + o2.req - o1.add - o1.req;
				}
			});
			for (TaskF1.Pair pair : positives) {
				if (r >= pair.req) {
					r += pair.add;
					count++;
				}
			}
			for (TaskF1.Pair pair : zeros) {
				if (r >= pair.req) {
					count++;
				}
			}
			for (TaskF1.Pair pair : negatives) {
				if (r >= pair.req) {
					if (r + pair.add < 0) {
						continue;
					}
					r += pair.add;
					count++;
				}
			}
			out.println(count);
		}

	}

	static class TaskF1 {
		static class Pair {
			int req;
			int add;

			Pair(int req, int add) {
				this.add = add;
				this.req = req;
			}

			public String toString() {
				return req + " " + add;
			}

		}

	}

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer;
		private int bytesRead;

		public Reader(InputStream inputStream) {
			din = new DataInputStream(inputStream);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) {
			try {
				din = new DataInputStream(new FileInputStream(file_name));
				buffer = new byte[BUFFER_SIZE];
				bufferPointer = bytesRead = 0;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public int nextInt() {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() {
			try {
				bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
				if (bytesRead == -1)
					buffer[0] = -1;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private byte read() {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

	}
}

