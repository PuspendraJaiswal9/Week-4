package listinterface;

import java.util.ArrayList;
import java.util.List;

public class RotateElements {
       public static void main(String args[]){
           List<Integer> li=new ArrayList<>();
           li.add(10);
           li.add(20);
           li.add(30);
           li.add(40);
           li.add(50);
           int pos=2;
           System.out.println("Print List without rotate:");
           System.out.println(li);
           for(int i=0;i<pos;i++){
               int j=0;
               int temp=li.get(j);
               while(j<li.size()-1){
                   li.set(j,li.get(j+1));
                   j++;
               }
               li.set(j,temp);
           }
           System.out.println("Print list after rotate:");
           System.out.println(li);
       }
}
