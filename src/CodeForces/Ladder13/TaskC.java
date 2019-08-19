package CodeForces.Ladder13;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        long arr[] = new long[n];
        for (int i=0;i<n;i++) {
            arr[i] = in.nextLong();
        }
        long gcd = findGCD(arr, n);
        int count =0;
        double sq = Math.sqrt(gcd);
        for (int i=1;i<=(int)sq;i++) {
            if (gcd%i==0) {
                count += 2;
            }
        }
        if (Math.floor(sq) == sq && gcd%(int)sq == 0) {
            count--;
        }
        out.println(count);
    }

    private long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private long findGCD(long arr[], int n)
    {
        long result = arr[0];
        for (int i = 1; i < n; i++)
            result = gcd(arr[i], result);
        return result;
    }
}
