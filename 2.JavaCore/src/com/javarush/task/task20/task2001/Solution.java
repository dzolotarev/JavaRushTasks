package com.javarush.task.task20.task2001;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("/Users/denis/Downloads/test6.txt");
            InputStream inputStream = new FileInputStream("/Users/denis/Downloads/test6.txt");
            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99), new Asset("boing", 1005002999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

            System.out.println(ivanov.hashCode());
            System.out.println(somePerson.hashCode());

            ivanov.equals(somePerson);
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            int isNamePresent = this.name != null ? 1 : 0;
            outputStream.write(isNamePresent);
            outputStream.flush();
            if (this.name != null) {
                outputStream.write(this.name.getBytes());
                outputStream.write(31);
            }
            outputStream.flush();
            int isAssetPresent = this.assets != null ? 1 : 0;
            outputStream.write(isAssetPresent);
            outputStream.flush();
            if (this.assets != null){
                for (int i = 0; i < this.assets.size(); i++) {
                    outputStream.write(this.assets.get(i).getName().getBytes());
                    outputStream.write(31);
                    byte[] bytes = new byte[8];
                    ByteBuffer.wrap(bytes).putDouble(this.assets.get(i).getPrice());
                    outputStream.write(bytes);
                }
            }
            outputStream.flush();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            int isNamePresent = inputStream.read();
            if (isNamePresent == 1) {
                int b;
                StringBuilder sb = new StringBuilder();
                while ((b = inputStream.read()) != 31) {
                    sb.append((char) b);
                }
                this.name = sb.toString();
            }
            int isAssetPresent = inputStream.read();
            if (isAssetPresent ==1){
                int b;
                while (inputStream.available()>0){
                    StringBuilder sb = new StringBuilder();
                    while ((b = inputStream.read()) != 31){
                        sb.append((char) b);
                    }
                    byte[] bytes = new byte[8];
                    inputStream.read(bytes);
                    double d = ByteBuffer.wrap(bytes).getDouble();
                    this.assets.add(new Asset(sb.toString(),d));
                }
            }

            inputStream.close();
        }
    }
}
