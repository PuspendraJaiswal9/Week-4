package auto_closing;

import java.io.*;

public class TryWithResource {
    public static void main(String[] args) {
        // Try-with-resources to ensure automatic resource management
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            // Read and print the first line of the file
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
