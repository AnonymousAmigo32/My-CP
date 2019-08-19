package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;

public class HEADSHOT {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next();
        int one=0,zero=0;
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'&&i+1<s.length())
                if (s.charAt(i+1)=='0')zero++;
                else one++;
        }
        if(s.charAt(s.length()-1)=='0')
            if (s.charAt(0)=='0')zero++;
            else one++;

        if (one==0)
            out.println("EQUAL");
        else if(one>zero)
            out.println("ROTATE");
        else if (zero>one)
            out.println("SHOOT");
        else
            out.println("EQUAL");
    }
}
