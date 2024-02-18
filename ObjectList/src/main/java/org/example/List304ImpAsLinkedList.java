package org.example;

import java.util.EmptyStackException;

public class List304ImpAsLinkedList<T> implements List304<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size;
    public List304ImpAsLinkedList() {}
    @Override
    public void add(T element) throws EmptyElementException{
        Node<T> newNode = new Node<>(element);
        if (element == null) throw new EmptyElementException();
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        }
        else {
            Node<T> current = tail;
            current.next = newNode;
            tail = current.next;
            tail.prev = current;
            size++;
        }
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 | index > size - 1) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index > size - 1 || index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else if (index == size-1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<T> current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.prev = null;
            current.next = null;
        }
        size--;
    }

    @Override
    public T pop() throws EmptyArrayException {
        if (size == 0) throw new EmptyArrayException();
        Node<T> current = tail;
        delete(getSize()-1);
        return current.value;
    }


    public String toString() {
        if (size == 0) return "[]";
        Node<T> current = head;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(", ").append(current.value);
            } else {
                sb.append(current.value);
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

 /*   public void printF() {
        Node<T> current = head;
        while (current.next != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print(current.value);
    }

    public void printB() {
        Node<T> current = tail;
        while (current.prev != null) {
            System.out.print(current.value + " ");
            current = current.prev;
        }
        System.out.print(current.value);
    }


    private Node<T> findLastElement() {
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
*/

}


