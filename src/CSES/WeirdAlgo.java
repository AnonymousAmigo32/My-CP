package CSES;

import FastIO.InputReader;
import java.io.PrintWriter;

public class WeirdAlgo {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long num = in.nextLong();
        out.print(num+" ");
        while (num!=1){
            if(num%2==0)
                num/=2;
            else num=num*3+1;
            out.print(num+" ");
        }
    }
}
