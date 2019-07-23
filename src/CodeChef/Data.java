package CodeChef;

import FastIO.InputReader;
import java.io.PrintWriter;

public class Data {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int arr[] = {23,30,31,25,35,31,40,32,33,27,37,38,19,36,26,20,14,29,34,27,38,29,26,26,30,34,18,30,36,36,35,16,38,29,36,22,37,41,47,30,30,36,28,39,28,33,31,32,33,28,33,39,20,30,13,35,26,37,31,35,34,28,32,29,22,19,23,36,30,23,20,23,34,30,35,22,45,23,28,44,39,25,41,30,28,32,38,39,35,27,33,24,34,33,32,27,18,33,33,12};
        int sol[] = new int[55];
        int size = in.nextInt();
        for (int i=0;i<55;i++){
            sol[i]=size;
        }
        long i =0,o=0,empty=49*size;
        for (int j=0;j<arr.length;j++){
            if(sol[arr[j]]>arr[j]){
                i+=arr[j];
                empty-=arr[j];
                sol[arr[j]]-=arr[j];
            }else {
                empty-=sol[arr[j]];
                i+=sol[arr[j]];
                o+=arr[j]-sol[arr[j]];
                sol[arr[j]]=0;
            }
        }
        out.println(i+"\n"+o+"\n"+empty);
    }
}
