package CodeForces;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        in.skip();in.skip();
        int q = in.nextInt();
//        out.print(q);
        String big = in.next(),small = in.next();
//        out.print(big+small);
        boolean[] arr = new boolean[big.length()];
        //
        for (int i=0;i<=big.length()-small.length();i++){
            if(big.substring(i,i+small.length()).equals(small))
                arr[i]=true;
        }
//        for (int i=0;i<big.length();i++)out.println(arr[i]);
        while (q-->0){
            int a = in.nextInt()-1,b=in.nextInt(),count=0;
            for (int i=a;i<=b-small.length();i++){
                if(arr[i])count++;
            }
            out.println(count);
        }
    }
}
