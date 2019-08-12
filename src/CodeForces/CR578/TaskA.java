package CodeForces.CR578;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        String order = in.nextLine();
        boolean[] arr = new boolean[10];
        Arrays.fill(arr, false);
        for (char c : order.toCharArray()) {
            if (c=='L') {
                for (int i=0;i<10;i++) {
                    if (!arr[i]) {
                        arr[i] = true;
                        break;
                    }
                }
            } else
            if (c=='R') {
                for (int i=9;i>=0;i--) {
                    if (!arr[i]) {
                        arr[i] = true;
                        break;
                    }
                }
            } else {
                int pos = Integer.parseInt(String.valueOf(c));
                arr[pos] = false;
            }
        }
        for (int i=0;i<10;i++) {
            if (arr[i]){
                out.print(1);
            } else {
                out.print(0);
            }
        }
    }
}
