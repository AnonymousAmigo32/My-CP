package CodeForces;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int students = in.nextInt();
        int marks = in.nextInt();

        String[] answers = new String[students];
        for (int i=0;i<students;i++)answers[i] = in.next();
        int[] numbers;
        int score = 0;
        int[] markValue = new int[marks];
        for (int i=0;i<marks;i++)markValue[i] = in.nextInt();
        for (int i=0;i<marks;i++) {
            numbers = new int[5];
            for (int j=0;j<5;j++)numbers[j]=0;
            for (int j=0;j<students;j++) {
                numbers[answers[j].charAt(i)-'A']++;
            }
            int maxPos = 0;
            for (int j=0;j<5;j++) {
                if (numbers[j]>numbers[maxPos]){
                    maxPos = j;
                }
            }
            score += markValue[i] * numbers[maxPos];
        }
        out.println(score);
    }
}
