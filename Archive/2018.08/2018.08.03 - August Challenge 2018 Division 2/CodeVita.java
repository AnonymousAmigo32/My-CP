package CodeChef;

import FastIO.InputReader;
import java.io.PrintWriter;

public class CodeVita {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(),m = in.nextInt();
        int[][] arr = new int[n][m];
        int maxRate = -1,x=0,y=0;boolean duplicate = false;
        for (int i=0;i<n;i++)for (int j=0;j<m;j++)arr[i][j]=in.nextByte();
        arr[0][0]=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(arr[i][j]==0)
                    continue;
                int rate = rate(i,j,arr,n,m);
                if(rate>maxRate){
                    maxRate = rate;
                    x=i+1;y=j+1;duplicate=false;
                }else if(rate==maxRate){
                    int a = x+y, b = i+j+2;
                    if(a==b)
                    duplicate = true;
                    if(b<a){
                        x=i+1;y=j+1;
                    }
                }
            }
        }
        if(duplicate)
            out.println("Polygamy not allowed");
        else if(maxRate==-1)
            out.println("No suitable girl found");
        else
            out.println((x)+":"+(y)+":"+maxRate);
    }

    private int rate(int i, int j, int[][] arr,int n, int m) {
        int rate = 0;
        if(up(arr,i-1,j,n,m))rate++;
        if (bot(arr,i+1,j,n,m))rate++;
        if(left(arr,i,j-1,n,m))rate++;
        if (right(arr,i,j+1,n,m))rate++;
        if(topDL(arr,i-1,j-1,n,m))rate++;
        if(botDL(arr,i+1,j-1,n,m))rate++;
        if(topDR(arr,i-1,j+1,n,m))rate++;
        if(botDR(arr,i+1,j+1,n,m))rate++;
        return rate;
    }

    private boolean up(int[][] arr, int i, int j,int n,int m) {
        if(i<0||i>=n||j<0||j>=m)
            return false;
        if(arr[i][j]==1)
            return true;
        return false;
    }
    private boolean bot(int[][] arr, int i, int j,int n,int m) {
        if(i<0||i==n||j<0||j==m)
            return false;
        if(arr[i][j]==1)
            return true;
        return false;
    }
    private boolean left(int[][] arr, int i, int j,int n,int m) {
        if(i<0||i==n||j<0||j==m)
            return false;
        if(arr[i][j]==1)
            return true;
        return false;
    }
    private boolean right(int[][] arr, int i, int j,int n,int m) {
        if(i<0||i==n||j<0||j==m)
            return false;
        if(arr[i][j]==1)
            return true;
        return false;
    }
    private boolean topDL(int[][] arr, int i, int j,int n,int m) {
        if(i<0||i==n||j<0||j==m)
            return false;
        if(arr[i][j]==1)
            return true;
        return false;
    }
    private boolean botDL(int[][] arr, int i, int j,int n,int m) {
        if(i<0||i==n||j<0||j==m)
            return false;
        if(arr[i][j]==1)
            return true;
        return false;
    }
    private boolean topDR(int[][] arr, int i, int j,int n,int m) {
        if(i<0||i==n||j<0||j==m)
            return false;
        if(arr[i][j]==1)
            return true;
        return false;
    }
    private boolean botDR(int[][] arr, int i, int j,int n,int m) {
        if(i<0||i==n||j<0||j==m)
            return false;
        if(arr[i][j]==1)
            return true;
        return false;
    }

}
