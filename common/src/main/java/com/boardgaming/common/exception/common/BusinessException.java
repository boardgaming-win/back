package com.boardgaming.common.exception.common;

public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;

    public BusinessException(
        final String message,
        final ErrorCode errorCode
    ) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(final ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
