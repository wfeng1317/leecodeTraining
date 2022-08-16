package com.leetcode.test;

import java.util.*;
import java.io.*;
public class test {
    static FastReader sc=new FastReader();
    static PrintWriter out=new PrintWriter(System.out);
    static int dx[]={0,0,-1,1},dy[]={-1,1,0,0};
    static final double pi=3.1415926536;
    static long mod=1000000007;
    // static long mod=998244353;
    static int MAX=Integer.MAX_VALUE;
    static int MIN=Integer.MIN_VALUE;
    static long MAXL=Long.MAX_VALUE;
    static long MINL=Long.MIN_VALUE;
    static ArrayList<Integer> graph[];
    static long fact[];
    static long seg[];
    // static int dp[][];
    static long dp[][];
    public static void main (String[] args) throws java.lang.Exception {
        // code goes here
        int n = I();
        long[] paths = IL(n);
        boolean flag = false;
        long start = paths[0] - 1;
        for(int i = 0; i < n; i++){
            paths[i] -= start;
        }
        long colRight = 1;
        long colLeft = 1;
        long rowUp = 1;
        long rowDown = 1;
        long kuadu = -1;
        long curRow = 1;
        long curCol = 1;
        for(int i = 1; i < n; i++){
            long span = paths[i] - paths[i - 1];
            if(Math.abs(span) == 1){
                if(span > 0){
                    curCol++;
                    colRight = Math.max(colRight, curCol);
                }else{
                    curCol--;
                    colLeft = Math.min(colLeft, curCol);
                }
                continue;
            }
            if(span > 0){
                curRow++;
                rowDown = Math.max(rowDown, curRow);
            }else{
                curRow--;
                rowUp = Math.min(rowUp, curRow);
            }
            if(kuadu != -1 && Math.abs(span) != kuadu){
                out.print("NO");
                flag = true;
                break;
            }
            kuadu = Math.abs(span);
        }
        if(!flag){
            rowUp += start / kuadu;
            rowDown += start / kuadu;
            colLeft += start % kuadu;
            colRight += start % kuadu;
            if(rowUp < 0 || rowDown > 1000000000 || colLeft < 0 || colRight > 1000000000 || (colRight != 1 && colLeft != 1 && colRight - colLeft + 1 != kuadu)){
                out.print("NO");
            }else{
                if(colRight == 1 && colLeft == 1){
                    colRight = kuadu;
                }
                out.println("YES");
                out.println(rowDown + " " + colRight);
            }
        }
        out.close();
    }

    public static int[] I(int n){int a[]=new int[n];for(int i=0;i<n;i++){a[i]=I();}return a;}
    public static long[] IL(int n){long a[]=new long[n];for(int i=0;i<n;i++){a[i]=L();}return a;}
    public static long[] prefix(int a[]){int n=a.length;long pre[]=new long[n];pre[0]=a[0];for(int i=1;i<n;i++){pre[i]=pre[i-1]+a[i];}return pre;}
    public static long[] prefix(long a[]){int n=a.length;long pre[]=new long[n];pre[0]=a[0];for(int i=1;i<n;i++){pre[i]=pre[i-1]+a[i];}return pre;}

    public static int I(){return sc.I();}
    public static long L(){return sc.L();}
    public static String S(){return sc.S();}
    public static double D(){return sc.D();}
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next(){
        while (st == null || !st.hasMoreElements()){
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int I(){ return Integer.parseInt(next());}
    long L(){ return Long.parseLong(next());}
    double D(){return Double.parseDouble(next());}
    String S(){
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return str;
    }
}
