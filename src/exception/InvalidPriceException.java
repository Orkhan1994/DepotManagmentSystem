package exception;

public class InvalidPriceException extends RuntimeException{
    private String message;

    public InvalidPriceException(String message){
        super(message);

    }
}
