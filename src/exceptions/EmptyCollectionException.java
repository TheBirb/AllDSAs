package exceptions;

public class EmptyCollectionException extends Exception {

    public EmptyCollectionException(String mess){
        super("The "+mess+" is empty");
    }
}
