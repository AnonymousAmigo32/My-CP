package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;

public class SAMER08F {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        if (size == 0){
            throw new UnknownError();
        }
        out.println(size*(size+1)*(2*size +1)/6);
    }
}
