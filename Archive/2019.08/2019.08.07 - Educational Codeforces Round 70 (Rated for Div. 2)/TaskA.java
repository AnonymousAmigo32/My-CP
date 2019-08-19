package CodeForces.ECR70;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int max = Integer.MIN_VALUE;
        while (n-->0) {
            int f = in.nextInt();
            int t = in.nextInt();
            if (t>k){
                f = f - (t-k);
            }
            if (f>max) max = f;
        }
        out.print(max);
    }
}
