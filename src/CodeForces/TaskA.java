package CodeForces;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt(), mod = in.nextInt(),borrow=0;
        while (size-->0){
            int input = in.nextInt()+borrow;
            out.print(input/mod+" ");
            borrow = input%mod;
        }
    }
}
