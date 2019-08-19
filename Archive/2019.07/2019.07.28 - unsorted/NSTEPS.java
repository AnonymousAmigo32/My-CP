package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;

public class NSTEPS {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int x = in.nextInt();
        int y = in.nextInt();
        if (x>=0 && y>=0 && (x==y || x==y+2)) {
            if (x%2==0 && y%2==0) {
                out.println(x+y);
            } else if (x%2==1 && y%2==1) {
                out.println(x+y-1);
            } else {
                out.println("No Number");
            }
        }else {
            out.println("No Number");
        }
    }
}
