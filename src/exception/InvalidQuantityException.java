package exception;

public class InvalidQuantityException extends RuntimeException {
    String mesagge;

    public  InvalidQuantityException(String message){
        super(message);
    }
}
