package filehandling.readandwriteatextfile;

import java.io.*;

public class ReadandWriteaTextFile {
    public static void main(String[] args) {
        String sourceFile = "fileone.txt";
        String destinationFile = "outputone.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("fileone file not found.");
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file.");
        }
    }
}

