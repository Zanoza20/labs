package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

    System.out.print("Введіть текст ");
    String text = scanner.nextLine();

        System.out.print("Введіть символ який хочите видалити ");
       char charToRemove = scanner.next().charAt(0);

       System.out.print("Введіть k ");
       int k = scanner.nextInt();

       String[] words =text.split(" ");
       StringBuilder resultBefore = new StringBuilder();
        StringBuilder resultAfter = new StringBuilder();

        for (String word : words) {
            StringBuilder modifiedWord = new StringBuilder(word);

            
            resultBefore.append(word).append(" ");
        }

        for (String word : words) {
            if (word.length() > k) {
                word = word.replace(String.valueOf(charToRemove), "");
            }
            resultAfter.append(word).append(" ");
        }

        System.out.println("Рядок до обробки  " + resultBefore.toString().trim());
        System.out.println("Після обробки  " + resultAfter.toString().trim());

        scanner.close();
    }
}
