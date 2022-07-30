package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
           // File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("/Users/denis/Downloads/test6.txt");
            InputStream inputStream = new FileInputStream("/Users/denis/Downloads/test6.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Ivan");
            user.setLastName("Ivanov");
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            user.setBirthDate(new Date(1117876500000L));
            User user1 = new User();
            user1.setFirstName("Ivana");
            user1.setLastName("Ivanova");
            user1.setMale(false);
            user1.setCountry(User.Country.UKRAINE);
            user1.setBirthDate(new Date(1103876300000L));
            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
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

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String isUserPresent = this.users.isEmpty() ? "no" : "yes";
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(isUserPresent);
            if (!this.users.isEmpty()) {
                for (User user : this.users) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(user.isMale());
                    printWriter.println(user.getCountry().getDisplayName());
                    printWriter.println(user.getBirthDate().getTime());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            {
                if ((reader.readLine()).equals("yes")) {
                    while (reader.ready()) {

                        User user = new User();
                        user.setFirstName(reader.readLine());
                        user.setLastName(reader.readLine());
                        user.setMale(Boolean.parseBoolean(reader.readLine()));
                        String country = reader.readLine();
                        switch (country.toUpperCase(Locale.ROOT)) {
                            case "RUSSIA":
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            case "UKRAINE":
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            default:
                                user.setCountry(User.Country.OTHER);
                        }
                        user.setBirthDate(new Date((Long.parseLong(reader.readLine()))));
                        this.users.add(user);
                    }
                }
            }
            reader.close();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
