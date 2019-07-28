package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;

public class ACPC10A {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt(), b= in.nextInt(), c = in.nextInt();
        if (a==b&&b==c&&c==0) {
            throw new UnknownError();
        }
        if (b-a==c-b){
            out.println("AP " + (c + c - b));
        } else {
            out.println("GP "+ (c*(c/b)));
        }
    }
}
