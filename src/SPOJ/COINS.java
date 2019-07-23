package SPOJ;

import java.util.Scanner;
import java.io.PrintWriter;

public class COINS {
    int[] arr = new int[1000009];
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        while (in.hasNext()){
            int val = in.nextInt();
            out.println(Math.max(res(val),val));
        }
    }
    private long res(int val){
        if(val<1000009&&arr[val]!=0)
            return arr[val];
        int a = (int)(Math.floor(val/2.0f)),b = (int)Math.floor(val/3.0f),c = (int)Math.floor(val/4.0f);
        int gat = a+b+c;
        if(gat>val){

            return res((int)Math.floor(val/2.0f)) + res((int)Math.floor(val/3.0f))+res((int)Math.floor(val/4.0f));
        }
        return val;
    }
}
