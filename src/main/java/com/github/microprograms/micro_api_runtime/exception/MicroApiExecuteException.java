package com.github.microprograms.micro_api_runtime.exception;

import org.apache.commons.lang3.StringUtils;

import com.github.microprograms.micro_api_runtime.model.ResponseCode;

public class MicroApiExecuteException extends Exception {
    private static final long serialVersionUID = 1L;
    private static final String format = "(%d) %s";
    private final ResponseCode responseCode;

    public MicroApiExecuteException(ResponseCode responseCode) {
        this(responseCode, null, null);
    }

    public MicroApiExecuteException(ResponseCode responseCode, String rewriteMessage) {
        this(responseCode, rewriteMessage, null);
    }

    public MicroApiExecuteException(ResponseCode responseCode, Throwable cause) {
        this(responseCode, null, cause);
    }

    public MicroApiExecuteException(ResponseCode responseCode, String rewriteMessage, Throwable cause) {
        super(String.format(format, responseCode.getCode(), StringUtils.isNotBlank(rewriteMessage) ? rewriteMessage : responseCode.getMessage()), cause);
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
