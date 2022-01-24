package exception;

public class InvalidNumberException extends RuntimeException{
    private String message;

    public InvalidNumberException(String message){
        super(message);
    }
}
