package filterstreams.convertuppercasetolowercase;

import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "converted.txt";

        convertUppercaseToLowercase(sourceFile, destinationFile);
    }

    private static void convertUppercaseToLowercase(String source, String destination) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {

            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(Character.toLowerCase(ch));
            }
            System.out.println("Conversion completed successfully.");

        } catch (IOException e) {
            System.out.println("Error while processing the file: " + e.getMessage());
        }
    }
}

