package HackerEarth;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collector;

public class MonkAndSortingAlgorithm {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        Pair[] arr = new Pair[size];
        int max  = 0;
        for (int i=0;i<size;i++){arr[i]=new Pair(new StringBuilder(in.next()).reverse().toString());max=(max<arr[i].val.length())?arr[i].val.length():max;}
        max+=(max%5==0)?0:5-(max%5);
        for (int i=0;i<max;i+=5){
            for (int j=0;j<size;j++){
                if(i<arr[j].val.length()&&i+5<arr[j].val.length())
                arr[j].curr=Integer.parseInt(new StringBuilder(arr[j].val.substring(i,i+5)).reverse().toString());
                else if(i<arr[j].val.length())
                    arr[j].curr=Integer.parseInt(new StringBuilder(arr[j].val.substring(i)).reverse().toString());
                else arr[j].curr=-1;
            }
            Arrays.sort(arr,new comp());
            for (int j=0;j<size;j++)
                if(arr[j].curr!=-1)
                    out.print(new StringBuilder(arr[j].val).reverse()+" ");
            out.println();
        }
    }

    static class Pair{
        String val = null;
        int curr = 0;
        public Pair(String val){
            this.val = val;
        }
    }
    static class comp implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.curr-o2.curr;
        }
    }
}
