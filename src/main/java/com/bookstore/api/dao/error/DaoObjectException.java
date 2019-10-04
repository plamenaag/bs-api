package com.bookstore.api.dao.error;
import com.bookstore.api.Constants;
public class DaoObjectException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * This code is used by the client to localize the exception/error
     * message. The value of this member is a name of ErrorEnum.
     */
    private final String errorCode;
    private final String internalMessage;
    /**
     * Low level exception contains information about the exception which is
     * the cause of the existence of the current object instance.
     */
    private final Exception lowLevelException;

    public DaoObjectException(String message) {
        super(message);
        this.errorCode = null;
        this.internalMessage = message;
        this.lowLevelException = null;
    }
    
    public DaoObjectException(ErrorEnum errorCode) {
        super(errorCode.name());
        this.errorCode = errorCode.name();
        this.internalMessage = null;
        this.lowLevelException = null;
    }
    
    public DaoObjectException(String message,ErrorEnum errorCode) {
        super(errorCode.name());
        this.errorCode = errorCode.name();
        this.internalMessage = message;
        this.lowLevelException = null;
    }

 
    public DaoObjectException(ErrorEnum errorCode, Exception lowLevelException) {
        super(errorCode.toString());
        this.errorCode = errorCode.name();
        this.internalMessage = errorCode.toString()
                + (lowLevelException != null ?
                (" - " + lowLevelException.getMessage()) : Constants.EMPTY_STRING);

        this.lowLevelException = lowLevelException;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getInternalMessage() {
        return this.internalMessage;
    }

    public final Exception getLowLevelException() {
        return this.lowLevelException;
    }
    @Override
    public String getMessage() {
        return this.internalMessage;
    }
}
