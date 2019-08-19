package CodeForces.Ladder13;

import FastIO.Reader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class TaskF2 {
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
				if (r+pair.add < 0) {
					continue;
				}
				r += pair.add;
				count++;
			}
		}
		out.println(count);
	}

	static class Pair {
		int req, add;

		Pair(int req, int add) {
			this.add = add;
			this.req = req;
		}

		@Override
		public String toString() {
			return req + " " + add;
		}
	}
}
