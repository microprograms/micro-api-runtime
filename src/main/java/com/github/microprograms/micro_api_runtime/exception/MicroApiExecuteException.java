package com.github.microprograms.micro_api_runtime.exception;

import com.github.microprograms.micro_api_runtime.model.ResponseCode;

public class MicroApiExecuteException extends Exception {
    private static final long serialVersionUID = 1L;
    private static final String format = "(%d) %s";
    private final ResponseCode responseCode;

    public MicroApiExecuteException(ResponseCode responseCode, Throwable cause) {
        super(String.format(format, responseCode.getCode(), responseCode.getMessage()), cause);
        this.responseCode = responseCode;
    }

    public MicroApiExecuteException(ResponseCode responseCode) {
        this(responseCode, null);
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
