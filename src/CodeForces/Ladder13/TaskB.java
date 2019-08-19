package CodeForces.Ladder13;

import FastIO.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TaskB {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int size = in.nextInt() * 4;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			int val = in.nextInt();
			map.putIfAbsent(val, 0);
			map.put(val, map.get(val) + 1);
		}
		int arr[] = new int[size / 2];
		int pos = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				for (int i = 0; i < entry.getValue() / 2; i++) {
					arr[pos++] = entry.getKey();
				}
			} else {
				out.println("NO");
				return;
			}
		}
		Arrays.sort(arr);
		int area = arr[0]*arr[size/2-1];
		for (int i=1;i<size/4;i++) {
			int a = size/2-1-i;
			if (arr[i]*arr[size/2-1-i] != area) {
				out.println("NO");
				return;
			}
		}
		out.println("YES");
	}
}
