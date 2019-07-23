package CSES;

import FastIO.InputReader;
import java.io.PrintWriter;

public class MissingNumbers {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        boolean[] arr = new boolean[size+1];
        for (int i=0;i<size-1;i++)arr[in.nextInt()]=true;
        for (int i=1;i<size+1;i++){
            if(!arr[i]){
                out.println(i);
                return;
            }
        }
    }
}
