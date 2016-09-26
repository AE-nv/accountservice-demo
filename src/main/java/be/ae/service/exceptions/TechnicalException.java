package be.ae.service.exceptions;


public class TechnicalException extends ServiceException {

    public TechnicalException(ErrorCode errorCode) {
        super(errorCode);
    }
}
