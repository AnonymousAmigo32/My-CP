package CSES;

import FastIO.InputReader;

import java.io.PrintWriter;

public class DistributeApples {
	private final static String YES = "YES";
	private final static String NO = "NO";

	public void solve(int testNumber, InputReader in, PrintWriter out) {
		long n = in.nextLong();
		long k = in.nextLong();
		if ((n / k) % k == 0) {
			out.println(NO);
		} else {
			out.println(YES);
		}
	}
}
