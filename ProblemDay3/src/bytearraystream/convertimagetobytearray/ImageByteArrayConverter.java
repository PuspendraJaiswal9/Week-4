package bytearraystream.convertimagetobytearray;

import java.io.*;
import java.util.Arrays;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String sourceImage = "phone.jpg";
        String destinationImage = "copied_image.jpg";

        byte[] imageData = convertImageToByteArray(sourceImage);
        if (imageData != null) {
            writeByteArrayToImage(imageData, destinationImage);
            verifyImages(sourceImage, destinationImage);
        }
    }

    private static byte[] convertImageToByteArray(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            System.out.println("Image converted to byte array successfully.");
            return baos.toByteArray();

        } catch (IOException e) {
            System.out.println("Error while converting image to byte array: " + e.getMessage());
            return null;
        }
    }

    private static void writeByteArrayToImage(byte[] imageData, String filePath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Byte array written back to image successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing byte array to image: " + e.getMessage());
        }
    }

    private static void verifyImages(String original, String copied) {
        try (FileInputStream fis1 = new FileInputStream(original);
             FileInputStream fis2 = new FileInputStream(copied)) {

            byte[] originalData = fis1.readAllBytes();
            byte[] copiedData = fis2.readAllBytes();

            if (Arrays.equals(originalData, copiedData)) {
                System.out.println("Verification successful: The copied image is identical to the original.");
            } else {
                System.out.println("Verification failed: The copied image is different from the original.");
            }

        } catch (IOException e) {
            System.out.println("Error while verifying images: " + e.getMessage());
        }
    }
}

