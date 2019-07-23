package CodeForces;

import FastIO.InputReader;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        int arr[][] = new int[2][size];
        for (int i=0;i<size;i++)arr[0][i]=in.nextInt();
        for (int j=0;j<size;j++)arr[1][j]=in.nextInt();
        out.println(Math.max(st(arr,1,size,0,1),flow(arr,0,0,size,true)));
    }

    private int flow(int[][] arr, int i,int pos,int size,boolean bool) {
        if(size==pos)
            return 0;
        if(bool)
        return arr[0][pos]*i+arr[1][pos]*(i+1)+flow(arr,i+2,pos+1,size,!bool);
        else return arr[1][pos]*i+arr[0][pos]*(i+1)+flow(arr,i+2,pos+1,size,!bool);
    }

    private int st(int[][] arr, int i,int size,int j,int val) {
        if(i==size){
            j=1;
            i--;
        }
        if(i==-1)return 0;
        int alt = +1;
        if(j==1)alt=-1;
        return val*arr[j][i] + st(arr,i+alt,size,j,val+1);
    }
}
