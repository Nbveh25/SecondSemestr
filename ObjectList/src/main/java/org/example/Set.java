package org.example;

public class Set<T> {

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;
    public Set() {}
    public void add(T value) throws EmptyElementException {
        if (value == null) throw new EmptyElementException();
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        }
        else if (!contains(value)) {
            Node<T> current = tail;
            current.next = newNode;
            tail = current.next;
            tail.prev = current;
            size++;
        }
    }

    public List304ImplAsArray<T> asList(Set<T> set) throws EmptyElementException {
        List304ImplAsArray<T> list = new List304ImplAsArray<>();
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            list.add(current.value);
            current = current.next;
        }
        return list;
    }

    public void delete(T value) throws ElementDoesNotExistException {
        Node<T> current = head;
        boolean flag = false;
        while (current != null) {
            if (current.value == value) {
                if (current.prev == null) {
                    head = current.next;
                    head.prev = null;
                } else if (current.next == null) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current.prev = null;
                    current.next = null;
                }
                flag = true;
                size--;
            }
            current = current.next;
        }
        if (!flag) throw new ElementDoesNotExistException();
    }

    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if(i == 0) {
                sb.append("[").append(current.value);
            } else if (i == size-1) {
                sb.append(", ").append(current.value).append("]");
            }
            else {
                sb.append(", ").append(current.value);
            }
            current = current.next;
        }
        return sb.toString();
    }

/*    public void printF() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }

    public void printB() {
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.prev;
        }
    }*/
}
