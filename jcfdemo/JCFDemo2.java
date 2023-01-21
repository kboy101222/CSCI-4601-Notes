package jcfdemo;

import java.util.ArrayList;

public class JCFDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        // new ArrayList<Integer>(); is the same as new ArrayList<>();

        int x = 5;
        data.add(x);
        // System.out.println(data.get(0));
        /*
         * int is different from an Integer
         * int is a primitive type
         * Integer is a class
         * - Integer is a wrapper class
         * Every primitive type has a wrapper class
         * - int has Integer
         * - double has Double
         * - boolean has Boolean
         * - char has Character
         * - They're mostly the same name with a capital letter
         * - except for char and int
         */

        // This is how it used to be done
        Integer y = new Integer(x);
        data.add(y);

        Integer tmp2 = (Integer) data.get(1);
        int z = tmp2.intValue();
        // System.out.println(z);

        /*
         * Boxing and unboxing
         * - Boxing is when you take a primitive type and wrap it in a wrapper class
         * - Unboxing is when you take a wrapper class and unwrap it to a primitive type
         * - Java 5 introduced autoboxing and autounboxing
         */

        for (int i = 0; i < 10; i++) {
            data.add(i * i);
        }

        /*
         * This causes a crash b/c the for loop is expecting an Integer
         * String s = "Ha!";
         * data.add(s);
         * Because we've now specified a data type for the ArrayList, we can't add a
         * String
         * This now causes a compile error instead of a runtime error
         */

        for (int i = 0; i < data.size(); i++) {
            // int tmp = (Integer) data.get(i);
            /* (Integer) is a cast */
            int tmp = data.get(i);
            // Because we've specified the type of the ArrayList, we don't need to cast

            if (tmp < 50) {
                System.out.println(tmp);
            }
        }

        ArrayList<Person> people = new ArrayList<>();
        Person p1 = new Person("Bob", 25);
        people.add(p1);
        Person p2 = new Student("Mary", 65, "Computer Science");
        people.add(p2);
        // You can add child classes to an ArrayList of parent classes
        // All child classes are also parent classes, so this is okay

        System.out.println(people.get(0));
        System.out.println(people.get(1));

        p1.setName("Bobby");
        System.out.println(p1);

        p2.setName("Maria");
        // p2.setFavoriteClass("CSCI 1010");
        // This doesn't work b/c the ArrayList only knows that it's a Person
        ((Student) p2).setFavoriteClass("CSCI 1010");
        // This is a cast
        // This is how you can access methods that are only in the child class
        System.out.println(p2);

        // This is a better way to do it
        // This makes sure that p2 is actually a Student before casting it
        // If it's not a Student, it won't cast it
        // This makes sure that you don't get a ClassCastException at runtime
        if (p2 instanceof Student) {
            ((Student) p2).setFavoriteClass("CSCI 3050");
            System.out.println(p2);
        }

        
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
        // You don't need "this." when you DON'T have a parameter and a field with the
        // same name
    }

    public void setName(String name) {
        this.name = name;
        // You need "this." when you have a parameter and a field with the same name
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Student extends Person {
    private String favoriteClass;

    public Student(String name, int age, String favoriteClass) {
        super(name, age);
        this.favoriteClass = favoriteClass;
    }

    public String getFavoriteClass() {
        return favoriteClass;
    }

    public void setFavoriteClass(String favoriteClass) {
        this.favoriteClass = favoriteClass;
    }

    public String toString() {
        return super.toString() + ", Favorite Class: " + favoriteClass;
    }
}