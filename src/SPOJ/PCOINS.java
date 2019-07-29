package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;

public class PCOINS {
    private final static int SIZE = 1000000;
    int[] arr = new int[SIZE];
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        calc();
        while (in.hasNext()) {
            long val = in.nextLong();
            out.println(res(val));
        }
    }

    private void calc() {
        for (int i=1;i<SIZE; i++) {
            arr[i] = Math.max(arr[i/2] + arr[i/3] + arr[i/4], i);
        }
    }

    private long calc(long val) {
        if (val>=SIZE) {
            return Math.max(calc(val/2) + calc(val/3) + calc(val/4), val);
        } else {
            return arr[(int)val];
        }
    }

    private long res(long val){
        if (val>=SIZE) {
            return calc(val);
        }
        return arr[(int)val];
    }
}
