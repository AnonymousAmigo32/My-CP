package gfg;

import FastIO.InputReader;

import java.io.PrintWriter;

public class EquilibriumPoint {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int size = in.nextInt();
		int[] arr = new int[size];
		long sum = 0;
		for (int i = 0; i < size; i++) {
			int var = in.nextInt();
			arr[i] = var;
			sum += var;
		}
		int pos = -1;
		long left = 0;
		for (int i = 0; i < size; i++) {
			sum -= arr[i];
			if (left == sum) {
				pos = i + 1;
			}
			left += arr[i];
		}
		out.println(pos);
	}
}
