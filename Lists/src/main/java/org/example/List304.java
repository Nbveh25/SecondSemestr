package org.example;

public interface List304 {

    void add(Integer element) throws EmptyElementException;

    Integer get(int index) throws IndexOutOfBoundsException;

    int size();
    void delete(int index) throws IndexOutOfBoundsException;

    Integer pop();

}
