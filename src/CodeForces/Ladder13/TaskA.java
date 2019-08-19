package CodeForces.Ladder13;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        int arr[] = new int[size];
        int pos = 0;
        for (int i = 0;i<size;i++) {
            arr[i]= in.nextInt();
            if (arr[i] == 1) pos = i;
        }
        if (clockwise(arr, pos) || ac(arr, pos)) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }

    private boolean ac(int[] arr, int pos) {
        int curr = 1;
        for (int i = pos; i>=0; i-- ){
            if (arr[i] != curr++) {
                return false;
            }
        }
        for (int i = arr.length-1; i>pos; i-- ){
            if (arr[i] != curr++) {
                return false;
            }
        }
        return true;
    }

    private boolean clockwise(int[] arr, int pos) {
        int curr = 1;
        for (int i=pos;i<arr.length;i++) {
            if (arr[i]!=curr++) {
                return false;
            }
        }
        for (int i=0;i<pos;i++) {
            if (arr[i]!=curr++) {
                return false;
            }
        }
        return true;
    }
}
