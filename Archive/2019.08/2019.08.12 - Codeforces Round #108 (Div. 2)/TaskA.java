package CodeForces.Ladder13;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int students = in.nextInt();
        int subjects = in.nextInt();
        String[] marks = new String[students];
        for (int i=0;i<students;i++) {
            marks[i]= in.nextLine();
        }
        char[] maxArr = new char[subjects];
        Arrays.fill(maxArr, '0');
        for (int i=0;i<students;i++) {
            for (int j=0;j<subjects;j++) {
                if (marks[i].charAt(j) > maxArr[j]) {
                    maxArr[j] = marks[i].charAt(j);
                }
            }
        }
        int count = 0;
        for (int i=0;i<students;i++) {
            for (int j=0;j<subjects;j++) {
                if (marks[i].charAt(j) == maxArr[j]) {
                    count++;
                    break;
                }
            }
        }
        out.print(count);
    }
}
