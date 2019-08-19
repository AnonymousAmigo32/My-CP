package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;

public class AE00 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        int sum =0;
        for (int i=1;i<=Math.sqrt(size); i++) {
            sum += size/i - i + 1;
        }
        out.println(sum);
    }
}
