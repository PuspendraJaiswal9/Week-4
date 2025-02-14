package bufferedstreams.efficientfilecopy;

import java.io.*;

public class EfficientFileCopy {
    public static void main(String[] args) {
        String sourceFile = "filetwo.txt";
        String destinationFile1 = "outputtwounbuffered.txt";
        String destinationFile2 = "outputtwobuffered.txt";

        long unbufferedTime = copyFileUnbuffered(sourceFile, destinationFile1);
        long bufferedTime = copyFileBuffered(sourceFile, destinationFile2);

        System.out.println("Unbuffered Stream Time: " + unbufferedTime + " ns");
        System.out.println("Buffered Stream Time: " + bufferedTime + " ns");
    }

    private static long copyFileUnbuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException e) {
            System.out.println("Error in unbuffered copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    private static long copyFileBuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error in buffered copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}

