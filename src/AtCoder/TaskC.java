package AtCoder;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        int[] arr = new int[size];
        int sum =0;
        for (int i=0;i<size;i++){
            arr[i]=in.nextInt();
            sum+=arr[i];
        }
        sum=Math.round(sum/(float)size);
        int res =0;
        for (int i=0;i<size;i++){
            int diff = arr[i]-sum;
            res+=diff*diff;
        }
        out.println(res);
    }
}
