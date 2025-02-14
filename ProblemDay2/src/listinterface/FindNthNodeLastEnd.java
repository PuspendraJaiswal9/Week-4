package listinterface;

import java.util.LinkedList;
import java.util.List;

public class FindNthNodeLastEnd {
    public static void main(String args[]){
        List<Character> li=new LinkedList<>();
        li.add('A');
        li.add('B');
        li.add('C');
        li.add('D');
        li.add('E');
        int N=2;
        int j=li.size()-1;
        for(int i=N;i>1;i--){
            j--;
        }
        System.out.println("Nth Node of Linked List is:"+li.get(j));
    }
}
