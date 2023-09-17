package pl.RemigiuszInstalacje.domain.exception;

public class ResourceNotExistException extends RuntimeException{
    public ResourceNotExistException(String message){
        super(message);
    }
}
