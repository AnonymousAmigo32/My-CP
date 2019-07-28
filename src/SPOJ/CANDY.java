package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;

public class CANDY {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        if (size == -1) {
            throw new UnknownError();
        }
        int[] arr = new int[size];
        int sum = 0;
        for (int i=0;i<size; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        double avg = sum/(double)size;
        if (avg != Math.floor(avg)) {
            out.println(-1);
            return;
        }
        int avgI = (int)avg;
        int ans = 0;
        for (int i=0; i<size;i++) {
            if (arr[i] < avgI) {
                ans += avgI-arr[i];
            }
        }
        out.println(ans);
    }
}
