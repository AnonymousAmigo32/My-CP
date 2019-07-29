package SPOJ;

import java.util.Scanner;
import java.io.PrintWriter;

public class COINS {
    int[] arr = new int[1000000001];
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        while (in.hasNext()){
            int val = in.nextInt();
            calc();
            out.println(Math.max(res(val),val));
        }
    }

    private void calc() {
        for (int i=1;i<1000000001; i++) {
            arr[i] = Math.max(arr[(int)Math.floor(i/2.0)] + arr[(int)Math.floor(i/3.0)] + arr[(int)Math.floor(i/4.0)], i);
        }
    }

    private long res(int val){
        return arr[val];
    }
}
