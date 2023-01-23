package jcfdemo;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class JCFDemo4 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 10; i >= 0; i--) {
            set.add(i);
        }

        for (int i = 0; i < 10; i++) {
            set.add(42);
        }
        // The set only contains one 42 because sets don't allow duplicates

        System.out.println(set);

        System.out.println("-------");

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(10, "Ten");
        map.put(100, "One Hundred");
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());
        // This is unordered because HashMaps don't guarantee order
        // TreeMap is the equivalent but it's ordered by default

        map.put(1, "ONE");
        map.put(10, "number");
        map.put(100, "number");
        System.out.println(map);
        // The keys are unique, but values are not

        for (Integer key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
