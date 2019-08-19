package CodeForces.CR578;

import FastIO.Reader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class TaskE {
    public void solve(int testNumber, Reader in, PrintWriter out) {
        int size = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(size);
        for (int i=0;i<size;i++)arr.add(in.nextInt());
        Collections.sort(arr);
        boolean a[] = new boolean[150006];
        int count = 0;
        for (int i=0;i<arr.size();i++) {
            if (arr.get(i)-1>0&&!a[arr.get(i)-1]) {
                a[arr.get(i)-1]=true;
                count++;
                continue;
            }
            if (!a[arr.get(i)]) {
                a[arr.get(i)]=true;
                count++;
                continue;
            }
            if (!a[arr.get(i)+1]) {
                a[arr.get(i)+1] = true;
                count++;
            }
        }
        out.println(count);
    }
}
