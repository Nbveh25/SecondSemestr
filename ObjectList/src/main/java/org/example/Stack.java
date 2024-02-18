package org.example;

import java.util.EmptyStackException;

public class Stack<T> {

    private int size = 0;
    private Node<T> head;
    public Stack() {}

    public void push(T value) throws EmptyElementException {
        if (value == null) throw new EmptyElementException();
        Node<T> newHead = new Node<>(value);
        if (head == null) {
            head = newHead;
        }
        else {
            newHead.next = head;
            head = newHead;
        }
        size++;
    }

    public T pop() {
        if (size == 0) throw new EmptyStackException();
        Node<T> current = head;
        head = head.next;
        size--;
        return current.value;
    }

    public int getSize() {
        return size;
    }



    /*public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }*/
}
