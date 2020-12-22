package exceptions;

public class EmptyCollectionException extends Exception {

    public EmptyCollectionException(){
        super("The stack is empty");
    }
}
