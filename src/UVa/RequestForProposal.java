package UVa;

import FastIO.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class RequestForProposal {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int num =1;
        while (true) {
            int reqs = in.nextInt();
            int proposals = in.nextInt();
            if (reqs == 0 && proposals == 0)
                return;
            if(num>1)out.println();
            Set<String> req = new HashSet<>();
            for (int i = 0; i < reqs; i++) {
                req.add(in.nextLine());
            }
            String neededProposal = "";
            double neededRate = 0;
            int satisfied = -1;
            for (int i = 0; i < proposals; i++) {
                String name = in.nextLine();
                double rate = in.nextDouble();
                int sends = in.nextInt();
                int count = 0;
                while (sends-->0){
                    if(req.contains(in.nextLine()))++count;
                }
                if (count>satisfied){
                    satisfied=count;
                    neededProposal = name;
                    neededRate = rate;
                }else if (count==satisfied&&neededRate>rate){
                    neededProposal = name;
                    neededRate = rate;
                }
            }
            if (satisfied>-1){
                out.println("RFP #"+num++);
                out.println(neededProposal);
            }
        }
    }
}
