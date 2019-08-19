package CodeChef;

import FastIO.InputReader;
import java.io.PrintWriter;

public class Football {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        int max = 0;
        int arr[] = new int[size];
        for (int i=0;i<size;i++) {
            arr[i] = in.nextInt() * 20;
        }
        for (int i=0;i<size;i++) {
            arr[i] = arr[i] - in.nextInt()*10;
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        out.println(max);
    }
}
