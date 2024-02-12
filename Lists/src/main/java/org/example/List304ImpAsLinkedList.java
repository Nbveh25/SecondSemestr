package org.example;

public class List304ImpAsLinkedList implements List304{

    private Node head;
    private int size;

    public List304ImpAsLinkedList() {
        size = 0;
        head = null;
    }


    @Override
    public void add(Integer element) throws EmptyElementException {
        if(element == null) throw new EmptyElementException();
        Node newNode = new Node(element, null, null);
        if(head == null) {
            head = newNode;
        }
        else {
            Node current = findLastElement();
            current.next = newNode;
            current.next.prev = current;
        }
        size++;
    }

    @Override
    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void delete(int index) {
        if (index > size - 1 || index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) {
            Node current = head;
            head = current.next;
            head.prev = null;
        } else if (index == size-1) {
            Node current = findLastElement();
            current.prev.next = null;
            current.prev = null;

        } else {
            Node current = head;
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    @Override
    public Integer pop() {
        Node current = findLastElement();
        delete(size - 1);
        size--;
        return current.value;
    }

    public void printForward() {
        Node current = head;
        while (current.next != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println(current.value);
    }

    public void printBackward() {
        Node current = findLastElement();
        while (current.prev != null) {
            System.out.println(current.value);
            current = current.prev;
        }
        System.out.println(current.value);
    }

    private Node findLastElement() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
}

class Node {
    Integer value;
    Node next;
    Node prev;

    public Node(Integer value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
