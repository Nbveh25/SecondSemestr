package org.example;

public class Main {
    public static void main(String[] args) throws EmptyElementException {
        List304ImplAsArray list = new List304ImplAsArray();

        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
    }
}