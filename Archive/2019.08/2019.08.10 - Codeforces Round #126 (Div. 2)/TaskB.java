package CodeForces.Ladder13;

import FastIO.InputReader;

import java.io.PrintWriter;

public class TaskB {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int size = in.nextInt();
		int[][] arr = new int[2 * size + 1][2 * size + 1];
		for (int i = 0; i <= size; i++) {
			arr[size][i] = arr[size][2 * size - i] = i;
		}
		for (int i = 1; i <= size; i++) {
			for (int j = 0; j < 2 * size + 1; j++) {
				arr[size + i][j] = arr[size - i][j] = arr[size][j] - i;
			}
		}
		for (int i = 0; i < 2 * size + 1; i++) {
			if (arr[0][i] < 0) {
				out.print("  ");
			} else {
				out.print("0\n");
				break;
			}
		}
		for (int i = 1; i < 2 * size; i++) {
			boolean positive = false;
			for (int j = 0; j < 2 * size + 1; j++) {
				if (arr[i][j] < 0) {
					out.print("  ");
				} else if (arr[i][j] == 0) {
					if (positive) {
						out.println(0);
						break;
					} else {
						positive = true;
						out.print("0 ");
					}
				} else {
					out.print(arr[i][j] + " ");
				}
			}
		}
		for (int i = 0; i < 2 * size + 1; i++) {
			if (arr[0][i] < 0) {
				out.print("  ");
			} else {
				out.println("0");
			}
		}
	}
}
