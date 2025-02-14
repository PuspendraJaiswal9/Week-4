package listinterface;

import java.util.*;

public class RemoveDublicate {
     public static void main(String args[]){
         List<Integer> li=new ArrayList<>();
         li.add(1);
         li.add(3);
         li.add(2);
         li.add(1);
         li.add(4);
         li.add(5);
         li.add(3);
         li.add(2);
         System.out.println("Print List:");
         System.out.println(li);
         Set<Integer> st=new LinkedHashSet<>(li);
         li.clear();
         li.addAll(st);
         System.out.println("Print List After remove dublicates:");
         System.out.println(li);
     }
}
