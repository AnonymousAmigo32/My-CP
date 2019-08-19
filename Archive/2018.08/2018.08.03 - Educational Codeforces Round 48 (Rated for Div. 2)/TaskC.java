package CodeForces;

import FastIO.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;

public class TaskC {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int size = in.nextInt();
		int moves = in.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) arr[i] = in.nextInt();
		Arrays.sort(arr);
		int mid = size / 2;
		int mReq = 1;
		for (int i = mid + 1; i < size; i++) {
			long nowMoves = ((long)(arr[i] - arr[mid])) * mReq++;
			if (nowMoves <= moves) {
				moves -= nowMoves;
				arr[mid] = arr[i];
			} else {
				arr[mid] += moves / (mReq - 1);
				out.println(arr[mid]);
				return;
			}
		}
		arr[mid] += moves / (mReq);
		out.println(arr[mid]);
	}
}
