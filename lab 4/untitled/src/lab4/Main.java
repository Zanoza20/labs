package lab4;

import lab4.io.DoubleArrayReader;
import lab4.logic.ArrayProcessor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main implements DoubleArrayReader, ArrayProcessor {

    public static void main(String[] args) {
        Main main = new Main();
        double[] oneDimensionalArray = main.readOneDimensionalArray("lab41.txt");
        main.processArray(oneDimensionalArray);
        double minEven = main.calculate(oneDimensionalArray);
        System.out.println("Найменше значення серед елементів масиву з парними номерами: " + minEven);
    }

    @Override
    public double[] readOneDimensionalArray(File file) {
        // Читаємо дані з файлу та повертаємо одновимірний масив
        // Реалізацію читання з файлу можна додати тут
        return null;
    }

    @Override
    public double[] readOneDimensionalArray(String fileName) {
        // Читаємо дані з файлу та повертаємо одновимірний масив
        try {
            Scanner scanner = new Scanner(new File(fileName));
            int n = scanner.nextInt();
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextDouble();
            }
            scanner.close();
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public double[][] readTwoDimensionalArray(File file) {
        return new double[0][];
    }

    @Override
    public double[][] readTwoDimensionalArray(String fileName) {
        return new double[0][];
    }

    @Override
    public void processArray(double[] array) {
        // Виводимо масив у консоль
        System.out.print("Масив: ");
        for (double value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    @Override
    public void processArray(double[][] array) {

    }

    @Override
    public double calculate(double[] array) {
        // Знаходимо найменше значення серед елементів масиву з парними номерами
        double minEven = Double.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0 && array[i] < minEven) {
                minEven = array[i];
            }
        }
        return minEven;
    }

    @Override
    public double calculate(double[][] array) {
        // Реалізацію цього методу можна додати за потреби
        return 0.0;
    }
}