package HackerEarth;

import FastIO.InputReader;
import java.io.PrintWriter;

public class SplitHouses {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        String s = in.nextLine();
        boolean house = false;
        boolean yes = true;
        for (char c : s.toCharArray()) {
            if (house && c=='H') {
                yes = false;
                break;
            }
            if (c=='H') {
                house = true;
            } else {
                house = false;
            }
        }
        out.println(yes ? "YES" : "NO");
        if (yes) {
            for (char c : s.toCharArray()) {
                out.print(c=='.'?'B':'H');
            }
            out.println();
        }
    }
}
