package ChapterOne.problemFour;

import java.util.HashSet;
import java.util.Vector;

public class Problem4Example {
    /**
     * @author Kyle George
     * @param args
     */
    public static void main(String[] args) {
        test_1();
        test_2();
        test_3();
        test_4();
        test_5();
    }

    // Nothing in the documentation said order matters, so while this passes, if we shuffle the order, it will fai!
    // You can check this by converting expected and actual into sets and comparing their sizes. If they are the same, then the sets are equal.
    public static void test_1() {
        System.out.println("---------------");
        System.out.println("Test 1");

        Vector<Integer> a = new Vector<>();
        for (int i : new int[]{1,2,3}) {
            a.add(i);
        }

        Vector<Integer> b = new Vector<>();
        for (int i : new int[]{3,4,5,6}) {
            b.add(i);
        }

        // Vector expected = new Vector<>();
        HashSet expected = new HashSet();
        for (int i : new int[]{1,2,3,4,5,6}) {
            expected.add(i);
        }

        Vector<Integer> actual = union(a, b);
        HashSet actualSet = new HashSet(actual);

        // boolean isValid = actual.equals(expected);
        boolean isValid = (actualSet.size() == actual.size() && actualSet.equals(expected));

        System.out.println("a         | " + a);
        System.out.println("b         | " + b);
        System.out.println("a union b | " + actual);
        System.out.println("expected  | " + expected);
        System.out.println("Is valid  | " + isValid);
    }

    public static void test_2() {
        System.out.println("---------------");
        System.out.println("Test 2");

        Vector<String> a = new Vector<>();
        for (String i : new String[]{"a","b","c"}) {
            a.add(i);
        }

        Vector<String> b = new Vector<>();
        for (String i : new String[]{"c","d","e","f"}) {
            b.add(i);
        }

        // Vector expected = new Vector<>();
        HashSet expected = new HashSet();
        for (String i : new String[]{"a", "b", "c", "d", "e", "f"}) {
            expected.add(i);
        }

        Vector<String> actual = union(a, b);
        HashSet actualSet = new HashSet(actual);

        // boolean isValid = actual.equals(expected);
        boolean isValid = (actualSet.size() == actual.size() && actualSet.equals(expected));

        System.out.println("a         | " + a);
        System.out.println("b         | " + b);
        System.out.println("a union b | " + actual);
        System.out.println("expected  | " + expected);
        System.out.println("Is valid  | " + isValid);
    }

    // a is empty, b is not
    public static void test_3() {
        System.out.println("---------------");
        System.out.println("Test 3");

        Vector<String> a = new Vector<>();

        Vector<String> b = new Vector<>();
        for (String i : new String[]{"c","d","e","f"}) {
            b.add(i);
        }

        // Vector expected = new Vector<>();
        HashSet expected = new HashSet(b);

        Vector<String> actual = union(a, b);
        HashSet actualSet = new HashSet(actual);

        // boolean isValid = actual.equals(expected);
        boolean isValid = (actualSet.size() == actual.size() && actualSet.equals(expected));

        System.out.println("a         | " + a);
        System.out.println("b         | " + b);
        System.out.println("a union b | " + actual);
        System.out.println("expected  | " + expected);
        System.out.println("Is valid  | " + isValid);
    }

    public static void test_4() {
        System.out.println("---------------");
        System.out.println("Test 4");

        Vector<String> a = new Vector<>();
        for (String i : new String[]{"a","b","c"}) {
            a.add(i);
        }

        Vector<String> b = new Vector<>();

        // Vector expected = new Vector<>();
        HashSet expected = new HashSet(a);

        Vector<Integer> actual = union(a, b);
        HashSet actualSet = new HashSet(actual);

        // boolean isValid = actual.equals(expected);
        boolean isValid = (actualSet.size() == actual.size() && actualSet.equals(expected));

        System.out.println("a         | " + a);
        System.out.println("b         | " + b);
        System.out.println("a union b | " + actual);
        System.out.println("expected  | " + expected);
        System.out.println("Is valid  | " + isValid);
    }

    public static void test_5() {
        System.out.println("---------------");
        System.out.println("Test 5");

        Vector a = null;

        Vector<String> b = new Vector<>();
        for (String i : new String[]{"c","d","e","f"}) {
            b.add(i);
        }

        // Vector expected = new Vector<>();
        HashSet expected = new HashSet();
        for (String i : new String[]{"c", "d", "e", "f"}) {
            expected.add(i);
        }

        Vector<Integer> actual = union(a, b);
        HashSet actualSet = new HashSet(actual);

        // boolean isValid = actual.equals(expected);
        boolean isValid = (actualSet.size() == actual.size() && actualSet.equals(expected));

        System.out.println("a         | " + a);
        System.out.println("b         | " + b);
        System.out.println("a union b | " + actual);
        System.out.println("expected  | " + expected);
        System.out.println("Is valid  | " + isValid);
    }

    // It's also a good idea to test for a is NULL, b is NULL, an element in a or b is NULL



    // This is JavaDoc notation. It autogenerates documentation for your code.
    /**
     * Creates a union between 2 vectors
     * @param a Vector of objects
     * @param b Vector of objects
     * @return a Vector of objects that are in either a or b
     */
    public static Vector union(Vector a, Vector b){
        Vector result = new Vector();
        for (Object item : a) {
            result.add(item);
        }
        for (Object item : b) {
            if(!result.contains(item)){
                result.add(item);
            }
        }
        return result;
    }
}
