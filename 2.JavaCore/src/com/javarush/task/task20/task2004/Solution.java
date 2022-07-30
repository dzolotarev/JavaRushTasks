package com.javarush.task.task20.task2004;

import java.io.*;
import java.nio.ByteBuffer;

/* 
Читаем и пишем в файл статики
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            //File yourFile = File.createTempFile("your_file_name", null);
            String yourFile = "/Users/denis/Downloads/test6.txt";
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //here check that the classWithStatic object is equal to the loadedObject object - проверьте тут, что classWithStatic и loadedObject равны

            System.out.println(classWithStatic.equals(loadedObject));
//            System.out.println(classWithStatic.hashCode());
//            System.out.println(loadedObject.hashCode());
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            int isStaticStringPresent = ClassWithStatic.staticString != null ? 1:0;
            outputStream.write(isStaticStringPresent);
            outputStream.flush();
            if (ClassWithStatic.staticString != null) {
                outputStream.write(ClassWithStatic.staticString.getBytes());
                outputStream.write(31);
            }
            outputStream.flush();
            byte[] bytes = new byte[4];
            ByteBuffer.wrap(bytes).putInt(this.i);
            outputStream.write(bytes);
            ByteBuffer.wrap(bytes).putInt(this.j);
            outputStream.write(bytes);
            outputStream.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            int isStaticStringPresent = inputStream.read();
            if (isStaticStringPresent == 1) {
                int b;
                StringBuilder sb = new StringBuilder();
                while ((b = inputStream.read()) != 31) {
                    sb.append((char) b);
                }
                ClassWithStatic.staticString = sb.toString();
            }
            byte[] bytes = new byte[4];
            inputStream.read(bytes);
            this.i = ByteBuffer.wrap(bytes).getInt();
            inputStream.read(bytes);
            this.j = ByteBuffer.wrap(bytes).getInt();
            inputStream.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
