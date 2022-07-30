package com.javarush.task.task20.task2025;

public class MyNewTest {
    public static void main(String[] args) throws Exception {
//        InputStream inputStream = System.in;
//        Reader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String phrase = bufferedReader.readLine();
//
//        System.out.println(phrase);

//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        int digit = scanner.nextInt();
//
//
//      System.out.printf("Name: %s, age: %d", name, digit);
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " - " + fibonacciSequince(i));
        }


    }


    public static long fibonacciSequince(int n) {
        long result = 0L;
        long next = 1L;
        int currentIndex = 0;
        for (; currentIndex < n; ) {
            next = result + next;
            result = next - result;
            currentIndex++;
        }
        return result;

    }

}
