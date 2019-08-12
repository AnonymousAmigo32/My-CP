package CSES;

import FastIO.InputReader;

import java.io.PrintWriter;
import java.util.HashMap;

public class ZombieAndTheCaves {
	private final static String YES = "YES";
	private final static String NO = "NO";

	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int size = in.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) arr[i] = 0;
		for (int i = 0; i < size; i++) {
			int pow = in.nextInt();
			if (pow > 0) arr[i]++;
			else continue;
			for (int j = 1; j <= pow; j++) {
				if (i - j < 0 && i + j >= size) break;
				if (i - j >= 0) arr[i - j]++;
				if (i + j < size) arr[i + j]++;
			}
		}
		HashMap<Integer, Integer> map = new HashMap<>(size);
		for (int i = 0; i < size; i++) {
			map.putIfAbsent(arr[i], 0);
			map.put(arr[i], map.get(arr[i]) + 1);
		}
		boolean error = false;
		for (int i = 0; i < size; i++) {
			int val = in.nextInt();
			if (map.containsKey(val) && map.get(val) > 0) {
				map.put(val, map.get(val) - 1);
			} else {
				error = true;
			}
		}
		out.println(error ? NO : YES);
	}
}
