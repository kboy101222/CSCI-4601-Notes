package jcfdemo;

import java.util.ArrayList;

public class JCFDemo3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        printValues(numbers);
        findValue(numbers, 5);
        findValue(numbers, 12);
        outputSum(numbers);

        System.out.println("-------");

        ArrayList<Double> moreNumbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            moreNumbers.add(i / 2.0);
        }
        printValues(moreNumbers);
        findValue(moreNumbers, 4.5);
        findValue(moreNumbers, 12.0);
        // findValue(moreNumbers, 10);
        // ^ This won't compile because 10 is an int and 10.0 is a double
        // We can't pass an int to a function that expects a double before compile time - the compiler doesn't know if it's safe
        outputSum(moreNumbers);


        System.out.println("-------");

        ArrayList<String> words = new ArrayList<>();
        words.add("Hello");
        words.add("World");
        words.add("!");
        words.add("How are you?");
        printValues(words);
        findValue(words, "Hello");
        findValue(words, "Goodbye");
        findValue(words, new String("Hello"));
        // outputSum(words);
        // ^ This won't compile because we specified that T must be a subclass of Number            
    }

    public static <T> void findValue(ArrayList<T> data, T value) {
        // We're searching an array list of type T for a value of type T
        // T is a placeholder for a type
        // Upon compile, Java will create functions for each type
        for (T item : data) {
            // See below for the reason we use .equals() instead of ==
            if (item.equals(value)) {
                System.out.println("Found " + value);
                return;
            }
            // T.equals and "Found " + value work because all the classes override .equals() and toString()
        }
        System.out.println("Did not find " + value);

        /* 
        If I wrote findValue() to use == instead of .equals(), it would return false
        * == :
            * Primitive = Primitive: compares the value
            * Object = Object: compares the memory address
                * Checks if they are the same object
                * If they are the same object, they are equal
                * If they are not the same object, they are not equal
        * .equals() : compares the states of the objects UNLESS the class overrides .equals()
            * by default, if not overridden, .equals() compares the memory address (like ==)
            * String class overrides .equals() to compare the value of the string
            * If you want to compare the value of two objects, use .equals()
            * If you want to compare the memory address of two objects (to see if they're the same object), use ==
        * String is not a primitive type, it's a class
            * It had been built into Java since the beginning
            * The devs needed it to be as efficient as possible, so they made it so that if two strings contain the same value, they are the same object
            * If you create two strings with the same value, they are the same object
            * If you use new String(value) to make a new string, it's a different object even if the value is the same
        */
    }

    public static <T> void printValues(ArrayList<T> data) { // T is a generic type
        // T is a placeholder for a type
        // Upon compile, Java will create functions for each type
        for (T i : data) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    // public static <T> void outputSum(ArrayList<T> data) {
    //     // T sum = 0; 
    //     // ^ This won't compile because we don't know what type T is
    //     // You can't initialize a non-numerical variable to 0
    // }

    public static <T extends Number> void outputSum(ArrayList<T> data) {
        // T extends Number means that T is a subclass of Number
        // This makes sure T can only be called for classes that are children of Number
        double sum = 0;
        // This is set to double because doubles work for both ints and doubles
        for (T item : data) {
            sum += item.doubleValue();
        }

        System.out.println("Sum: " + sum);
    }

    // There's a Vector class that's similar to JCF Classes but it isn't one

    
}
