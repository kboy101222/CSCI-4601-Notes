package jcfdemo;

import java.util.ArrayList;

public class JCFDemo1 {
    public static void main(String[] args) {
        ArrayList data = new ArrayList();

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
         */

        for (int i = 0; i < data.size(); i++) {
            int tmp = (Integer) data.get(i); /* (Integer) is a cast */
            if (tmp < 50) {
                System.out.println(tmp);
            }
        }


    }
}
