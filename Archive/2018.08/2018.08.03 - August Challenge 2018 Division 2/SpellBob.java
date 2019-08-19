package CodeChef;

import FastIO.InputReader;
import java.io.PrintWriter;

public class SpellBob {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        char[] first = in.next().toCharArray();
        char[] sec = in.next().toCharArray();
        byte[] sol = new byte[3];
        for (int i=0;i<3;i++){

            if (sec[i]=='o'&&first[i]!='b')
                sol[0]++;
            else if(first[i]=='o'&& sec[i]!='b')
                sol[0]++;
            else if(sec[i]=='b'&&first[i]!='o')
                sol[1]++;
            else if(first[i]=='b'&&sec[i]!='o')
                sol[1]++;
            else if (first[i]=='b'&&sec[i]=='o'||first[i]=='o'&&sec[i]=='b')
                sol[2]++;
        }
        if(sol[1]==2&&sol[0]==1){
            out.println("yes");
            return;
        }
        else if(sol[0]>1||sol[1]>2){
            out.println("no");
            return;
        }else {
            if (sol[2]+sol[1]+sol[0]==3){
                out.println("yes");
                return;
            }
            out.println("no");
        }
    }
}
