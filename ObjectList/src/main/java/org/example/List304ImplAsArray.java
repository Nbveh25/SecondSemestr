package org.example;

import java.util.EmptyStackException;

public class List304ImplAsArray<T> implements List304<T>{

    private Object[] array;
    private int size = 0;

    private int capacity = 1;

    public List304ImplAsArray() {
        this.array = new Object[capacity];
    }


    @Override
    public void add(T element) throws EmptyElementException {
        if (element == null) throw new EmptyElementException();
        if(size == capacity) {
            capacity += 10;
            Object[] tmp_array = new Object[capacity];
            if (size >= 0) System.arraycopy(array, 0, tmp_array, 0, size);
            array = tmp_array;
        }
        array[size] = element;
        size++;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size-1) throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index > size-1) throw new IndexOutOfBoundsException();
        Object[] tmp_array = new Object[size-1];
        for (int i = 0; i < index; i++) {
            tmp_array[i] = array[i];
        }
        for (int i = index; i < size-1; i++) {
            tmp_array[i] = array[i+1];
        }
        array = tmp_array;
        size--;
    }

    @Override
    public T pop() throws EmptyArrayException {
        if (size == 0) throw new EmptyArrayException();
        Object res = array[getSize()-1];
        delete(size-1);
        return (T) res;
    }

    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if(i != 0) {
                sb.append(", ").append(array[i]);
            } else {
                sb.append(array[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /*public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }*/

}
