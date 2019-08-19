package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TMUL {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        out.println(in.nextBigInteger().multiply(in.nextBigInteger()));
    }
}
