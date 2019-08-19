package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class FCTRL2 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        byte val = in.nextByte();
        BigInteger sol = new BigInteger("1");
        for (byte i =2; i<=val;i++){
            sol= sol.multiply(new BigInteger(String.valueOf(i)));
        }
        out.println(sol.toString());
    }
}
