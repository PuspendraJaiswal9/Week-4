package mapinterface.invertamap;

import java.util.*;

public class InvertMap {
    // Method to invert the map
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            invertedMap.putIfAbsent(value, new ArrayList<>());
            invertedMap.get(value).add(key);
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        // Input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        // Invert the map
        Map<Integer, List<String>> outputMap = invertMap(inputMap);

        // Print the output
        System.out.println(outputMap);
    }
}