package CodeForces.Ladder13;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TaskF1 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        int r = in.nextInt();
        ArrayList<Pair> positives = new ArrayList<>();
        ArrayList<Pair> zeros = new ArrayList<>();
        ArrayList<Pair> negatives = new ArrayList<>();
        int count = 0;
        for (int i=0;i<size;i++) {
            int req = in.nextInt();
            int add = in.nextInt();
            if (add == 0) {
                zeros.add(new Pair(req,add));
                continue;
            }
            if (add<0) {
                negatives.add(new Pair(req,add));
                continue;
            }
            if (add>0) {
                positives.add(new Pair(req, add));
            }
        }
        positives.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.req-o2.req;
            }
        });
        negatives.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.add+o2.req-o1.add-o1.req;
            }
        });
        for (Pair pair : positives) {
            if (r>=pair.req) {
                r+=pair.add;
                count++;
            } else {
                out.println(count);
                return;
            }
        }
        for (Pair pair : zeros) {
            if (r>=pair.req) {
                count++;
            } else {
                out.println(count);
                return;
            }
        }
        for (Pair pair : negatives) {
            if (r>=pair.req) {
                r+=pair.add;
                if (r<0){
                    out.println(count);
                    return;
                }
                count++;
            } else {
                out.println(count);
                return;
            }
        }
        if (r<0){
            out.println(count);
            return;
        }
        out.println(count);
    }

    static class Pair {
        int req,add;
        Pair(int req, int add){
            this.add=add;
            this.req = req;
        }

        @Override
        public String toString() {
            return req + " " + add;
        }
    }
}
