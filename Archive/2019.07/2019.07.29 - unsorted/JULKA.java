package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class JULKA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        BigInteger val = in.nextBigInteger();
        BigInteger sub = in.nextBigInteger();
        val = val.subtract(sub);
        val = val.divide(new BigInteger("2"));
        out.println(val.add(sub));
        out.println(val);
        if (testNumber == 10) {
            throw new UnknownError();
        }
    }
}
