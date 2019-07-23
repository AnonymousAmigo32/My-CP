package CodeForces;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TheBits {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        String a = in.next(), b=in.next();
        while(a.length()<size){
            a="0"+a;
        }
        while (b.length()<size){
            b="0"+b;
        }
        int c0=0,n0=0,c1=0,n1=0;
        for (int i=0;i<size;i++){
            if(a.charAt(i)==b.charAt(i)&&a.charAt(i)=='1')
                n1++;
            else if (a.charAt(i)==b.charAt(i)&&a.charAt(i)=='0')
                c0++;
            else if (a.charAt(i)=='0'&&b.charAt(i)=='1')
                n0++;
            else if (a.charAt(i)=='1'&&b.charAt(i)=='0')
                c1++;
        }
        out.println(c0*c1+c0*n1+n0*c1);
    }
}
