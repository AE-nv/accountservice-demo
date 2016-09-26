package be.ae.service.exceptions;

public class BusinessException extends ServiceException {
    public BusinessException(ErrorCode errorCode) {
        super(errorCode);
    }
}
