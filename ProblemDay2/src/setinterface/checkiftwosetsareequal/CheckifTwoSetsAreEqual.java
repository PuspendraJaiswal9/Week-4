package setinterface.checkiftwosetsareequal;

import java.util.HashSet;
import java.util.Set;

public class CheckifTwoSetsAreEqual {
       public static void main(String args[]){
           Set<Integer> st1=new HashSet<>();
           Set<Integer> st2=new HashSet<>();
           st1.add(1);
           st1.add(2);
           st1.add(3);
           st2.add(3);
           st2.add(2);
           st2.add(1);
           if(st1.equals(st2)){
               System.out.println("true");
           }else{
               System.out.println("false");
           }
       }
}
