package CodeForces.Ladder13;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int round = in.nextInt();
        int ins = in.nextInt();
        int prev = 1;
        long sum = 0;
        while (ins-->0) {
            int val = in.nextInt();
            if (val<prev) {
                sum+=round;
            }
            prev = val;
        }
        out.print(sum + prev - 1);
    }
}
