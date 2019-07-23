package CodeForces;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.*;

public class ProblemSort {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int problems = in.nextInt();
        int subs = in.nextInt();
        int vals[] = new int[problems];
        for (int i=0;i<problems;i++){
            ArrayList<Subs> problem = new ArrayList<>();
            for (int j=0;j<subs;j++){
                problem.add(new Subs(in.nextInt()));
            }
            for (int j=0;j<subs;j++){
                problem.get(j).b = in.nextInt();
            }
            Collections.sort(problem,new subCompare());
            vals[i] = val(problem);
        }
        Map<Integer,Integer> ps = new HashMap<>();
        Map<Integer,Integer> sr = new HashMap<>();
        for (int i=0;i<problems;i++)
            ps.put(i,vals[i]);
        Arrays.sort(vals);
        for (int i=0;i<problems;i++)
            sr.put(vals[i],i);
        for (int i=0;i<problems;i++)
            out.println((sr.get(ps.get(i))+1));
    }

    private int val(ArrayList<Subs> problem) {
        int count =0;
        for (int i=0;i<problem.size()-1;i++){
            if(problem.get(i).b>problem.get(i+1).b)
                count++;
        }
        return count;
    }


    static class Subs{

        int a,b;

        public Subs(int a){
            this.a = a;
        }
    }
    static class subCompare implements Comparator<Subs>{

        @Override
        public int compare(Subs o1, Subs o2) {
            return o1.a-o2.a;
        }
    }
}
