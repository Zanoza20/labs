package com.company;

import com.company.entities.Phone;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Phone> phoneList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Додати абонента");
            System.out.println("2. Вивести абонентів з міжміськими розмовами більше 6 годин");
            System.out.println("3. Вивести абонентів з міжміськими розмовами");
            System.out.println("4. Вивести абонентів з номерами рахунку від 500 до 1000 грн");
            System.out.println("5. Видалити абонентів");
            System.out.println("6. Вивести всіх абонентів");
            System.out.println("7. Завершити");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addSubscriber(phoneList);
                    break;
                case 2:
                    displayIntercityCallTimeAboveSix(phoneList);
                    break;
                case 3:
                    displaySubscribersWithIntercityCalls(phoneList);
                    break;
                case 4:
                    displaySubscribersInAccountRange(phoneList);
                    break;
                case 5:
                    deleteSubscriber((ArrayList<Phone>) phoneList);
                    break;
                case 6:
                    displayAllSubscribers((ArrayList<Phone>) phoneList);
                    break;
                case 7:
                    saveToFile((ArrayList<Phone>) phoneList);
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Такого пункту немає, спробуйте ще раз. ");
            }
        }
    }

    private static void addSubscriber(List<Phone> phoneList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть Ім'я: ");
        String firstName = scanner.next();
        System.out.println("Введіть прізвище: ");
        String lastName = scanner.next();
        System.out.println("Введіть ім'я по-батькові: ");
        String patronymic = scanner.next();
        System.out.println("Введіть номер рахунку: ");
        String accountNumber = scanner.next();
        System.out.println("Введіть час міських розмов (години): ");
        int cityCallTime = scanner.nextInt();
        System.out.println("Введіть час міжміських розмов (години): ");
        int intercityCallTime = scanner.nextInt();
        Phone subscriber = new Phone(firstName, lastName, patronymic, accountNumber, cityCallTime, intercityCallTime);
        phoneList.add(subscriber);
        System.out.println("Абонент успішно доданий.");
    }


    private static void displaySubscribersWithIntercityCalls(List<Phone> phoneList){
        System.out.println("Абоненти, які користувались міжміським зв'язком");

        for (Phone subscriber : phoneList){
            if (subscriber.getIntercityCallTime()>0) {
                System.out.println(subscriber);
            }
        }
    }
    private static void displaySubscribersInAccountRange(List<Phone> phoneList){
        System.out.println("Абоненти чий номер рахунку в діапазоні від 500 до 1000 грн:");

        for (Phone subscriber : phoneList) {
            String accountNumber = subscriber.getAccountNumber();
            int accountBalance = Integer.parseInt(accountNumber);
            if (accountBalance >= 500 && accountBalance <1000) {
                System.out.println(subscriber.toString());
            }
        }
    }


    private static void displayIntercityCallTimeAboveSix(List<Phone> phoneList) {
        System.out.println("Абоненти чиї міжміські розмови тривали довше 6 годин:");
        for (Phone subscriber : phoneList) {
            if (subscriber.getIntercityCallTime() > 6) {
                System.out.println(subscriber);
            }
        }
    }

    private static void  deleteSubscriber(List<Phone> phoneList){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введіть номер рахунку абонента якого потрібно видалити");
    String accountNumberToDelete = scanner.nextLine();
    Iterator<Phone> iterator = phoneList.iterator();
    while (iterator.hasNext()) {
        Phone subscriber =iterator.next();
        if (subscriber.getAccountNumber().equals(accountNumberToDelete)){
            iterator.remove();
            System.out.println("Абонент було видалено");
            return;
        }
    }
    System.out.println("Абонента з таким номером не знайденою");
}
private static void displayAllSubscribers(List<Phone> phoneList){
    System.out.println("Всі абоненти:");

    for (Phone subscriber : phoneList){
        System.out.println(subscriber);
    }
}
private static void saveToFile(List<Phone> phoneList){
    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("phoneData.txt"))){
        objectOutputStream.writeObject(phoneList);
        System.out.println("Інформація збережена.");
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}
}