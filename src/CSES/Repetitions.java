package CSES;

import FastIO.InputReader;
import java.io.PrintWriter;

public class Repetitions {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.nextLine();
        int max =0;
        int count =1;
        for (int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1))count++;
            else {
                max = Math.max(max,count);
                count=1;
            }
        }
        max = Math.max(max,count);
        out.println(max);
    }
}
