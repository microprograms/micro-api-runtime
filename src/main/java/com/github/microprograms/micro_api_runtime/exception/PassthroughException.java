package com.github.microprograms.micro_api_runtime.exception;

import org.apache.commons.lang3.StringUtils;

import com.github.microprograms.micro_api_runtime.model.ResponseCode;

public final class PassthroughException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final String format = "(%s) %s";
	private final ResponseCode responseCode;

	public PassthroughException(ResponseCode responseCode) {
		this(responseCode, null, null);
	}

	public PassthroughException(ResponseCode responseCode, String rewriteMessage) {
		this(responseCode, rewriteMessage, null);
	}

	public PassthroughException(ResponseCode responseCode, Throwable cause) {
		this(responseCode, null, cause);
	}

	public PassthroughException(ResponseCode responseCode, String rewriteMessage, Throwable cause) {
		super(String.format(format, responseCode.getCode(),
				StringUtils.isNotBlank(rewriteMessage) ? rewriteMessage : responseCode.getMessage()), cause);
		this.responseCode = responseCode;
	}

	public ResponseCode getResponseCode() {
		return responseCode;
	}
}
