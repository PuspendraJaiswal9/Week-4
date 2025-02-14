package setinterface.symmetricdifference;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
       public static void main(String args[]){
           Set<Integer> s1=new HashSet<>();
           s1.add(1);
           s1.add(2);
           s1.add(3);
           s1.add(8);
           s1.add(9);
           Set<Integer> s2=new HashSet<>();
           s2.add(2);
           s2.add(3);
           s2.add(4);
           s2.add(5);
           s2.add(6);
           Set<Integer>s3=new HashSet<>();
           for(int i:s1){
               s3.add(i);
           }
           for(int i:s2){
               if(s1.contains(i)){
                   s3.remove(i);
               }else {
                   s3.add(i);
               }
           }
           for(int i:s3){
               System.out.print(i+" ");
           }
       }
}
