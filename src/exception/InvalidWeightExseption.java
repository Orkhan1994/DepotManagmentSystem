package exception;

public class InvalidWeightExseption extends RuntimeException{
    String message;

    public InvalidWeightExseption(String mesagge){
        super(mesagge);
    }
}
