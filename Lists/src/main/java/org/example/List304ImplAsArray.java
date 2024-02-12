package org.example;

public class List304ImplAsArray implements List304{

    private Integer[] array;
    private int size = 0;

    private int capacity = 1;

    public List304ImplAsArray() {
        this.array = new Integer[capacity];
    }


    @Override
    public void add(Integer element) throws EmptyElementException {
        if (element == null) throw new EmptyElementException();
        if(size == capacity) {
            capacity += 10;
            Integer[] tmp_array = new Integer[capacity];
            if (size >= 0) System.arraycopy(array, 0, tmp_array, 0, size);
            array = tmp_array;
        }
        array[size] = element;
        size++;
    }

    @Override
    public Integer get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size-1) throw new IndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void delete(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index > size-1) throw new IndexOutOfBoundsException();
        Integer[] tmp_array = new Integer[size-1];
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
    public Integer pop() {
        Integer res = array[array.length-1];
        delete(size-1);
        return res;
    }

    public void print() {
        for (Integer integer : array) {
            System.out.print(integer + " ");
        }
    }

}
