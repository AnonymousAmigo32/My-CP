package CodeForces;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        long sum = 0;
        int max = 0;
        while (size-->0){
            int val = in.nextInt();
            if (val>max)max=val;
            sum+=val;
        }
        if (max>(sum-max)) {
            out.println("NO");
            return;
        }
        out.println(sum%2==0 ? "YES" : "NO");
    }
}
