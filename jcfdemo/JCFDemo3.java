package jcfdemo;

import java.util.ArrayList;

public class JCFDemo3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        printValues(numbers);

        System.out.println("-------");

        ArrayList<Double> moreNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            moreNumbers.add(i / 2.0);
        }
        printValues(moreNumbers);
    }

    public static <T> void printValues(ArrayList<T> data) { // T is a generic type
        // T is a placeholder for a type
        // Upon compile, Java will create functions for each type
        for (T i : data) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
