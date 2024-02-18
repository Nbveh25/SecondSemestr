package org.example;

import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) throws ElementDoesNotExistException, EmptyElementException, EmptyStackException, EmptyArrayException {

        //List304ImpAsLinkedList<Integer> list = new List304ImpAsLinkedList<>();
        List304ImplAsArray<Integer> list = new List304ImplAsArray<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


    }
}