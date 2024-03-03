package org.example.MapV1;

public class Main {
    public static void main(String[] args) {
        MapInf304impl<Integer, String> map = new MapInf304impl<>();

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
        map.print();
        System.out.println(map.keySet());
    }
}