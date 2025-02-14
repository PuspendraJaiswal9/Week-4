package mapinterface.mergetwomaps;

import java.util.*;

public class MergeMaps {
    // Method to merge two maps
    public static <K> Map<K, Integer> mergeMaps(Map<K, Integer> map1, Map<K, Integer> map2) {
        Map<K, Integer> result = new HashMap<>(map1);

        for (Map.Entry<K, Integer> entry : map2.entrySet()) {
            result.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return result;
    }

    public static void main(String[] args) {
        // Input Maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the maps
        Map<String, Integer> outputMap = mergeMaps(map1, map2);

        // Print the output
        System.out.println(outputMap);
    }
}