package queueinterface.generatebinarynumbersusingaqueue;

import java.util.*;

public class BinaryNumbersQueue {
    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String binary = queue.poll();
            result.add(binary);
            queue.add(binary + "0");
            queue.add(binary + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        List<String> binaryNumbers = generateBinaryNumbers(n);
        System.out.println(binaryNumbers);
    }
}

