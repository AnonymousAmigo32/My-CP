package CodeForces.CR578;

import FastIO.InputReader;

import java.io.PrintWriter;

public class TaskB {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = in.nextInt();
//		for (int i = 1; i < n; i++) {
//			if (arr[i-1] == 0) {
//				if (Math.abs(arr[i-1]-arr[i])<=k) {
//					continue;
//				}
//			}
//			int extra = k + arr[i - 1] - arr[i];
//			m += extra;
//			arr[i - 1] -= extra;
//			if (m<0 || arr[i-1]<0){
//				out.println("NO");
//				return;
//			}
//
//		}
//		out.println("YES");
		for (int i=0;i<n-1;i++) {
				int diff = arr[i] - arr[i+1] + k;
				if (arr[i]-diff>=0) {
					m += diff;
					arr[i] -= diff;
				}
				else {
					m += arr[i];
					arr[i]=0;
				}

			if (m<0){
				out.println("NO");
				return;
			}
		}
		out.println("YES");
	}
}
