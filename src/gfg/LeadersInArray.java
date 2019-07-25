package gfg;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        List<Integer> list = new ArrayList<>(size);
        while (size-- > 0) {
            list.add(in.nextInt());
        }
        int max = Integer.MIN_VALUE;
        List<Integer> solList = new ArrayList<>();
        for (int i=list.size()-1; i>=0; i--) {
            if (list.get(i) >= max) {
                max = list.get(i);
                solList.add(list.get(i));
            }
        }
        for (int i=solList.size()-1; i>=0; i--) {
            out.print(solList.get(i) + " ");
        }
        out.println();
    }
}
