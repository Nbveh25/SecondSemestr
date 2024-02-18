package org.example;

public class ElementDoesNotExistException extends Exception {
    public ElementDoesNotExistException(){
        super("The element does not exist");
    }
}
