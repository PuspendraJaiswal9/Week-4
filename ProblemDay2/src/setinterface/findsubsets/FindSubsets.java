package setinterface.findsubsets;

import java.util.HashSet;
import java.util.Set;

public class FindSubsets {
       public static void main(String args[]){
           Set<Integer> s1=new HashSet<>();
           Set<Integer> s2=new HashSet<>();
           s1.add(2);
           s1.add(3);
           //s1.add(10);
           s2.add(1);
           s2.add(2);
           s2.add(3);
           s2.add(4);
           boolean flag=true;
           for(int i:s1){
               if(!s2.contains(i)){
                   flag=false;
                   break;
               }
           }
           if(flag==true) {
               System.out.println("true");
           }else{
               System.out.println("false");
           }
       }
}
