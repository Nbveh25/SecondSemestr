package org.example;

public class EmptyArrayException extends Exception{
    public EmptyArrayException() {
        super("Array is empty");
    }
}
