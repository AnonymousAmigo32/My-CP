package AtCoder;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.nextLine();
        if (s.length()>=2) {
            for (int i=0;i<s.length()-1;i++) {
                if (s.charAt(i)==s.charAt(i+1)){
                    out.println((i+1)+" "+(i+2));
                    return;
                }
                if(i+2<s.length()&&s.charAt(i)==s.charAt(i+2)){
                    out.println((i+1)+" "+(i+3));
                    return;
                }
            }

        }
        out.println("-1 -1");
    }
}
