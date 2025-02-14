package queueinterface.circularbuffersimulation;

import java.util.*;

class CircularBuffer {
    int[] buffer;
    int size, front, rear, count;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        front = 0;
        rear = 0;
        count = 0;
    }

    public void insert(int value) {
        buffer[rear] = value;
        rear = (rear + 1) % size;
        if (count < size) {
            count++;
        } else {
            front = (front + 1) % size;
        }
    }

    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(buffer[(front + i) % size]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);
        System.out.println(cb.getBuffer());
    }
}

