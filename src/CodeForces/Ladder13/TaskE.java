package CodeForces.Ladder13;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class TaskE {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        int[] arr = new int[size];
        for (int i=0;i<size;i++)arr[i] = in.nextInt();
        Arrays.sort(arr);
        boolean a[] = new boolean[150006];
        int count = 0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i]-1>0&&!a[arr[i]-1]) {
                a[arr[i]-1]=true;
                count++;
                continue;
            }
            if (!a[arr[i]]) {
                a[arr[i]]=true;
                count++;
                continue;
            }
            if (!a[arr[i]+1]) {
                a[arr[i]+1] = true;
                count++;
            }
        }
        out.println(count);
    }
}
