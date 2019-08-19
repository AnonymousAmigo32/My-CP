package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class FASHION {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        int men[] = new int[size];
        int[] women = new int[size];
        for (int i=0; i<size; i++)men[i]=in.nextInt();
        for (int i=0; i<size; i++)women[i]=in.nextInt();
        Arrays.sort(men);
        Arrays.sort(women);
        int sum = 0;
        for (int i = 0; i< size; i++)sum += men[i]*women[i];
        out.println(sum);
    }
}
