package queueinterface.reversequeue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void reverse(Queue<Integer>q){
        if(q.isEmpty()){
            return;
        }
        int front=q.peek();
        q.poll();
        reverse(q);
        q.add(front);
    }
    public static void main(String args[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        System.out.println("Print queue before reverse:");
        System.out.println(q);
        reverse(q);
        System.out.println("Print queue after reverse:");
        System.out.println(q);
    }
}
