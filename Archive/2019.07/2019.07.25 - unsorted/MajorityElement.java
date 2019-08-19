package gfg;

import FastIO.InputReader;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
			int size = in.nextInt();
			Map<Integer, Integer> map = new HashMap<>();
			for (int j = 0; j < size; j++) {
				int val = in.nextInt();
				if (map.containsKey(val)) {
					map.put(val, map.get(val) + 1);
				} else {
					map.put(val, 1);
				}
			}
			boolean printed = false;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() > size / 2) {
					out.println(entry.getKey());
					printed = true;
					break;
				}
			}
			if (!printed) {
				out.println(-1);
			}

	}
}
