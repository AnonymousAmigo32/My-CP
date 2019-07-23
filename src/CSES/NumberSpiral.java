package CSES;

import FastIO.InputReader;
import java.io.PrintWriter;

public class NumberSpiral {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int x =in.nextInt(), y =in.nextInt();
        if (x>y){
            long diagonal = (long)x*(x-1) + 1;
            if (x%2==0){
                out.println(diagonal+(x-y));
            }else {
                out.println(diagonal-(x-y));
            }
        }else {
            long diagonal = (long)y*(y-1) + 1;
            if (y%2==0){
                //-
                out.println(diagonal-(y-x));
            }else {
                //+
                out.println(diagonal+(y-x));
            }
        }
    }
}
