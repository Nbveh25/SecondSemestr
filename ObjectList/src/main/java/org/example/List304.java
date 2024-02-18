package org.example;

public interface List304<T> {

    void add(T element) throws EmptyElementException;

    T get(int index) throws IndexOutOfBoundsException;

    int getSize();
    void delete(int index) throws IndexOutOfBoundsException;

    T pop() throws EmptyArrayException;

}
