package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;

public class LASTDIG {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        a %=10;
        if (b==0){
            out.println(1);
            return;
        }
        b %= 4;
        if (b==0)b=4;
        out.println((int)Math.pow(a,b)%10);
    }
}
