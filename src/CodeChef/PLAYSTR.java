package CodeChef;

import FastIO.InputReader;
import java.io.PrintWriter;

public class PLAYSTR {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        String first = in.next();
        String second = in.next();
        int oneCountFirst = 0;
        int oneCountSecond = 0;
        for (char c : first.toCharArray()) {
            if (c=='1')oneCountFirst++;
        }
        for (char c: second.toCharArray()) {
            if (c=='1')oneCountSecond++;
        }
        out.println(oneCountFirst==oneCountSecond ? "YES" : "NO");
    }
}
