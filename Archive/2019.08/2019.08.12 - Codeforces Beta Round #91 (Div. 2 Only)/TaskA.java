package CodeForces.Ladder13;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int val = in.nextInt();
        for (int i = 4; i<=val;i++) {
            if (val%i==0&&isLucky(i)){
                out.print("YES");
                return;
            }
        }
        out.print("NO");
    }

    private boolean isLucky(int val) {
        String s = String.valueOf(val);
        for (char c : s.toCharArray()) {
            if (c=='4'||c=='7') {
                continue;
            }
            return false;
        }
        return true;
    }
}
