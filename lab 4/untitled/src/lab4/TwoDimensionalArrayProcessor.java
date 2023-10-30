package lab4;

import lab4.io.DoubleArrayReader;
import lab4.logic.ArrayProcessor;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwoDimensionalArrayProcessor implements DoubleArrayReader, ArrayProcessor {

    private double[][] twoDimensionalArray;

    @Override
    public double[] readOneDimensionalArray(File file) {
        return new double[0];
    }

    @Override
    public double[] readOneDimensionalArray(String fileName) {
        return new double[0];
    }

    @Override
    public double[][] readTwoDimensionalArray(File file) {
        try {
            Scanner scanner = new Scanner(file);
            int n = scanner.nextInt();
            twoDimensionalArray = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    twoDimensionalArray[i][j] = scanner.nextDouble();
                }
            }
            scanner.close();
            return twoDimensionalArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public double[][] readTwoDimensionalArray(String fileName) {
        File file = new File(fileName);
        return readTwoDimensionalArray(file);
    }

    @Override
    public void processArray(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public double calculate(double[] array) {
        return 0;
    }

    @Override
    public double calculate(double[][] array) {
        double sum = 0.0;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Перевіряємо, чи поточний елемент знаходиться у верхньому трикутнику
                if (i <= j && i + j < n) {
                    // Перевіряємо, чи значення за модулем менше 100
                    if (Math.abs(array[i][j]) < 100) {
                        sum += array[i][j];
                    }
                }
            }
        }

        return sum;
    }

    @Override
    public void processArray(double[] array) {

    }

    public static void main(String[] args) {
        TwoDimensionalArrayProcessor processor = new TwoDimensionalArrayProcessor();
        double[][] twoDimensionalArray = processor.readTwoDimensionalArray("lab42.txt");
        processor.processArray(twoDimensionalArray);
        double sum = processor.calculate(twoDimensionalArray);
        System.out.println("Сума елементів верхнього трикутника, які за модулем менші 100: " + sum);
    }
}
