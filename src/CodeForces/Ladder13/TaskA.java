package CodeForces.Ladder13;

import FastIO.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskA {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int maxa = in.nextInt();
		int maxb = in.nextInt();
		int mina = in.nextInt();
		int minb = in.nextInt();
		ArrayList<Pair> li = new ArrayList<>();
		for (int i = mina; i <= maxa; i++) {
			for (int j = minb; j <= maxb && j < i; j++) {
				li.add(new Pair(i,j));
			}
		}
		out.println(li.size());
		for (Pair pair : li) {
			out.println(pair.a + " " + pair.b);
		}
	}

	class Pair {
		int a, b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
