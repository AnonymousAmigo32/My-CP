package CodeForces.CR578;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long n = in.nextLong();
        long m = in.nextLong();
        int q = in.nextInt();
        double lcm = lcm(360.0/n, 360.0/m);
        double ncount = 360.0/n;
        double mcount = 360.0/m;
        while (q-->0) {
            long sx = in.nextLong(), sy = in.nextLong();
            long ex = in.nextLong(), ey = in.nextLong();
            double start = 0;
            double stop = 0;
            if (sx == 1) {
                start = sy * ncount;
            } else {
                start = sy * mcount;
            }
            if (ex == 1) {
                stop = ey*ncount;
            } else {
                stop = ey* mcount;
            }
            out.println(Math.abs(start - stop) < lcm?"YES":"NO");
        }
    }

    static double gcd(double a, double b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static double lcm(double a, double b)
    {
        return (a*b)/gcd(a, b);
    }
}
