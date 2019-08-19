package CSES;

import FastIO.InputReader;
import java.io.PrintWriter;

public class IncreasingArray {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        long count =0;
        int[] arr = new int[size];
        for (int i=0;i<size;i++)arr[i]=in.nextInt();
        for (int i=1;i<size;i++)if (arr[i]<arr[i-1]){count+=arr[i-1]-arr[i];arr[i]=arr[i-1];}
        out.println(count);
    }
}
