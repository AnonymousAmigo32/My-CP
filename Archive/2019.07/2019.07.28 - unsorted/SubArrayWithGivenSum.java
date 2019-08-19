package gfg;

import FastIO.InputReader;
import java.io.PrintWriter;

public class SubArrayWithGivenSum {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        long reqSum = in.nextLong();
        int arr[] = new int[size];
        long sum = 0;
        int left = -1;
        int right = 0;
        for (int i=0; i<size; i++) {
            arr[i] = in.nextInt();
        }
        for (int i=0; i<size; i++) {
            if (sum + arr[i] < reqSum) {
                if (left <= -1) {
                    left = i;
                }
                sum += arr[i];
                right = i;
            } else if (sum + arr[i] == reqSum) {
                if (left <= -1) {
                    left = i;
                }
                right = i;
                sum += arr[i];
                break;
            } else {
                if (left >= 0){
                    sum -= arr[left];
                    left++;
                    i--;
                }
            }
        }
        if (sum == reqSum){
            out.println(left + 1 + " " + (right + 1));
        } else {
            out.println(-1);
        }
    }
}
