package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DIVSUM {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int val = in.nextInt();
        if(val==1){out.println(0);return;}
        long sum = 1;
        ArrayList<Long> list = new ArrayList<>();
        for(long i=2;i<=Math.sqrt(val);i++){
            if(val%i==0){
                list.add(i);
                sum+=i;
                if(val/(double)i!=(double) i)sum+=val/i;
            }
        }
        out.println(sum);
    }
}
