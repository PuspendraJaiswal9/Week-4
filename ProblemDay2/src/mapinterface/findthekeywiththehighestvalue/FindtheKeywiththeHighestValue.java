package mapinterface.findthekeywiththehighestvalue;

import java.util.HashMap;
import java.util.Map;

public class FindtheKeywiththeHighestValue {
       public static void main(String args[]){
           Map<String,Integer> m=new HashMap<>();
           m.put("A",10);
           m.put("B",20);
           m.put("C",15);
           m.put("D",40);
           m.put("E",25);
           m.put("C",55);
           int max=-1;
           for(Map.Entry<String,Integer>it:m.entrySet()){
               if(it.getValue()>max){
                   max=it.getValue();
               }
           }
           System.out.println("Maximum Value: "+max);
       }
}
