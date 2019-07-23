package CodeChef;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class DistinctAlphabets {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        boolean[] arr = new boolean[10];
        for (int  i=0;i<10;i++)arr[i]=false;
        Set<String> set = new HashSet<>();
        String input = in.next();
        byte[] num = new byte[5];
        for (int i=0;i<input.length();i++){
            int pos = input.charAt(i)-'0';
            arr[pos]=true;
            set.add(Integer.toString(pos)+"0");
            if(pos<5)num[pos]++;
        }
        if(num[2]>1)set.add(Integer.toString(2)+"1");
        if(num[3]>1)set.add(Integer.toString(3)+"2");
        if(arr[2]&&arr[3]){set.add(Integer.toString(2)+"2");set.add(Integer.toString(3)+"1");}
        for (int i=4;i<10;i++){
            if((i==7&&arr[7])||(i==9)&&arr[9]){
                if(arr[2])set.add(Integer.toString(i)+"1");
                if(arr[3])set.add(Integer.toString(i)+"2");
                if (arr[4])set.add(Integer.toString(i)+"3");
            }
            else if(arr[i]){
                if(arr[2])set.add(Integer.toString(i)+"1");
                if(arr[3])set.add(Integer.toString(i)+"2");
            }
        }
        out.println(set);
    }
}
