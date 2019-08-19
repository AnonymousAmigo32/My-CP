package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;

public class CANDY3 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        in.nextLine();
        long size = in.nextLong();
        long sum = 0;
        for (int i=0;i<size;i++){
            sum = (sum%(size) +  in.nextLong()%(size))%(size);
        }
        if (Math.ceil(sum/(double)size) == sum/size) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
}
