package Timus;

import FastIO.InputReader;
import java.io.PrintWriter;

public class Numbers {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int pos = Integer.parseInt(in.nextLine()), count = 0, add=1;
        int sqr = (int)Math.ceil(Math.sqrt(pos));
        count = (sqr*(sqr+1))/2;
        add = sqr+1;
        while (count<pos){
            if (pos<=count){
                out.print(0+" ");
                return;
            }
            if (count+1==pos){
                out.print(1+" ");
                return;
            }
            count+=add++;
        }
        if (pos<=count){
            out.print(0+" ");
            return;
        }
        if (count+1==pos){
            out.print(1+" ");
            return;
        }
    }
}
