package com.javarush.task.pro.task15.task1504;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // String src = "/Users/denis/Downloads/file.txt";
        //String dest = "/Users/denis/Downloads/copy.txt";

        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        String dest = scanner.nextLine();
        InputStream input = Files.newInputStream(Path.of(src));
        OutputStream output = Files.newOutputStream(Path.of(dest));

        byte[] buffer = new byte[1];
        byte[] buffer_ = new byte[1];
        while (input.available() > 0) {
            int real_ = input.read(buffer_);

            int real = input.read(buffer);
            if (real > 0) {
                output.write(buffer, 0, real);
            }
            output.write(buffer_, 0, real_);


        }
        output.close();
        input.close();
    }

//    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in);
//             var inputStream = Files.newInputStream(Paths.get(scanner.nextLine()));
//             var outputStream = Files.newOutputStream(Paths.get(scanner.nextLine()))
//        ) {
//            byte[] bytesIn = inputStream.readAllBytes();
//            byte[] bytesOut = new byte[bytesIn.length];
//            for (int i = 0; i < bytesIn.length; i += 2) {
//                if (i < bytesIn.length - 1) {
//                    bytesOut[i] = bytesIn[i + 1];
//                    bytesOut[i + 1] = bytesIn[i];
//                } else {
//                    bytesOut[i] = bytesIn[i];
//                }
//            }
//            outputStream.write(bytesOut);
//        } catch (IOException e) {
//            System.out.println("Something went wrong : " + e);
//        }
//    }

}


