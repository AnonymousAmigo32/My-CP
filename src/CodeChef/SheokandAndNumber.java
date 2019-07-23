package CodeChef;

import FastIO.InputReader;

import java.io.PrintWriter;

public class SheokandAndNumber {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long val = in.nextInt();
        long pos = 0;
        for (int i = 1; i < 31; i++) {
            if (1 << i == val) {
                out.println(1);
                return;
            }
            if (1 << i > val) {
                pos = i - 1;
                break;
            }
        }
        out.println(Math.min((1 << (pos + 1)) - val + 1, low(val - (1 << pos))));
    }

    private long low(long val) {
        long pos = 0;
        for (int i = 0; i < 31; i++) {
            if (1 << i > val) {
                pos = i - 1;
                break;
            }
        }
        return Math.min(val - (1 << pos), (1 << (pos + 1)) - val);
    }
}
