package AtCoder;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskE {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long s = in.nextLong();
        long d = in.nextLong();
        if (d==1){
            out.println(s);
            return;
        }
        if (d>s){
            out.println(-1);
            return;
        }
        long sum=0;
        while (s>0){
            sum+=s%d;
            s=Math.floorDiv(s,d);
        }
        out.println(sum);
    }
}
