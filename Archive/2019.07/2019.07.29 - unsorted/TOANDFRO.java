package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TOANDFRO {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        if (size==0){
            throw new UnknownError();
        }
        StringBuilder string = new StringBuilder(in.next()).reverse();
        StringBuilder[] matrix = new StringBuilder[string.length()/size];
//        for (int i=0;i<size;i++)matrix[i] = new StringBuilder();
        boolean evenRow = true;
        int arrI = 0;
        while (string.length() > 0) {
            StringBuilder line = new StringBuilder(string.substring(string.length()-size));
            string = string.delete(string.length() - size, string.length());
            if (evenRow) {
                matrix[arrI++] = line.reverse();
            } else {
                matrix[arrI++] = line;
            }
            evenRow = !evenRow;
        }
        for (int i=0;i<size;i++) {
            for (int j=0; j<matrix.length;j++){
                out.print(matrix[j].charAt(i));
            }
        }
        out.println();
    }
}
