package com.qp.accessControl;

public class AccessDeniedException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 5188167616201017971L;

    public AccessDeniedException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AccessDeniedException(String message, Throwable cause,
                                 boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public AccessDeniedException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}

