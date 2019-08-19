package SPOJ;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Stack;

public class ONP {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.nextLine();
        Stack<Character> symbols = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c=='('){
                continue;
            } else
            if (c == ')') {
                out.print(symbols.pop());
            } else
            if (c >= 'a' && c <= 'z') {
                out.print(c);
            } else {
                symbols.push(c);
            }
        }
        out.println();
    }
}
