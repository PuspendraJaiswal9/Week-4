package listinterface;

import java.util.ArrayList;
import java.util.List;

public class ReverseAList {
    public static void reverseArrayList(List<Integer>li){
        int i=0;
        int j=li.size()-1;
        while(i<j){
            int temp=li.get(i);
            li.set(i,li.get(j));
            li.set(j,temp);
            i++;
            j--;
        }
    }

    public static void reverseLinkedList(List<Integer>li){
        int i=0;
        int j=li.size()-1;
        while(i<j){
            int temp=li.get(i);
            li.set(i,li.get(j));
            li.set(j,temp);
            i++;
            j--;
        }
    }
    public static void main(String args[]){
        List<Integer> li=new ArrayList<>();

       li.add(1);
       li.add(2);
       li.add(3);
       li.add(4);
       li.add(5);
       System.out.println("Print List Without reverse:");
       for(int i:li){
           System.out.print(i+" ");
       }
       System.out.println();
       reverseArrayList(li);
       System.out.println("Print ArrayList without reverse method:");
       for(int i=0;i<li.size();i++){
           System.out.print(li.get(i)+" ");
       }

        System.out.println();
        reverseLinkedList(li);
        System.out.println("Print LinkedList without reverse method:");
        for(int i=0;i<li.size();i++){
            System.out.print(li.get(i)+" ");
        }
    }
}
