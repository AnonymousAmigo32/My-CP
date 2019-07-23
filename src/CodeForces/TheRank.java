package CodeForces;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class TheRank {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int size = in.nextInt();
        Student[] arr = new Student[size];
        Student req = new Student(in.nextInt()+in.nextInt()+in.nextInt()+in.nextInt(),0);
        arr[0]=req;
        for (int i=1;i<size;i++)
            arr[i]=new Student(in.nextInt()+in.nextInt()+in.nextInt()+in.nextInt(),i);
        Arrays.sort(arr,new Comp());
        out.println(Arrays.binarySearch(arr,req)+1);
    }

    static class Student implements Comparable<Student>{
        int tot;
        int id;
        public Student(int tot,int id){
            this.id=id;
            this.tot=tot;
        }

        @Override
        public int compareTo(Student o) {
            if(o.tot==tot)
                return id-o.id;
            return o.tot-tot;
        }
    }
    static class Comp implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2){
            if(o1.tot==o2.tot)
                return o1.id-o2.id;
            return o2.tot-o1.tot;
        }
    }
}
