package mapinterface.wordfrequencycounter;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String args[]){
        String str[]={"Hello", "world" , "Hello", "Java!"};
        Map<String,Integer> m=new HashMap<>();
        for(int i=0;i<str.length;i++) {
            m.put(str[i],m.getOrDefault(str[i],0)+1);
        }
        for(Map.Entry<String,Integer>it:m.entrySet()){
            System.out.println(it.getKey()+" "+it.getValue());
        }
    }
}
