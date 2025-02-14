package listinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOfElements {
       public static void main(String args[]){
           List<String> li=new ArrayList<>();
           li.add("apple");
           li.add("mango");
           li.add("apple");
           li.add("banana");
           li.add("apple");
           li.add("mango");
           li.add("apple");
           li.add("banana");
           Map<String,Integer> m=new HashMap<>();
           for(int i=0;i<li.size();i++){
               m.put(li.get(i),m.getOrDefault(li.get(i),0)+1);
           }
           System.out.println("Print element and frequency");
           for(Map.Entry<String,Integer>entry:m.entrySet()){
               System.out.println(entry.getKey()+" "+entry.getValue());
           }
       }
}
