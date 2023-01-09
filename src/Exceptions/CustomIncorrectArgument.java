package Exceptions;

public class CustomIncorrectArgument extends Exception{
    /**
     * custom exception
     * @param message
     */
    public CustomIncorrectArgument(String message){
        super(message);
    }
}
