package setinterface.unionandintersection;

import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {
       public static void main(String args[]){
           Set<Integer> s1=new HashSet<>();
           Set<Integer> s2=new HashSet<>();
           s1.add(1);
           s1.add(2);
           s1.add(3);
           s2.add(3);
           s2.add(4);
           s2.add(5);

           //Union
           System.out.println("Union Print:");
           for(int i:s1){
               System.out.print(i+" ");
           }
           for(int i:s2){
               if(!s1.contains(i)) {
                   System.out.print(i+" ");
               }
           }
           System.out.println();
           //intersection
           System.out.println("Print intersection:");
           for(int i:s2){
               if(s1.contains(i)){
                   System.out.print(i+" ");
               }
           }
       }
}
