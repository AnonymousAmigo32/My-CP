package CodeChef;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CHFM {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        List<Integer> array = new ArrayList<>();
        long sum = 0;
        for (int i=0;i<size;i++) {
            int value = in.nextInt();
            array.add(value);
            sum+=value;
        }
        double mean = sum/(double)size;
        if (Math.ceil(mean) == mean) {
            boolean found = false;
            for (int i=0;i<size;i++) {
                if (array.get(i) == (long)mean) {
                    out.println(i+1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                out.println("Impossible");
            }
        } else {
            out.println("Impossible");
        }
    }
}
