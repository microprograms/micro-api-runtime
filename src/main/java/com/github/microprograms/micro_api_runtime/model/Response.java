package com.github.microprograms.micro_api_runtime.model;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.github.microprograms.micro_api_runtime.enums.ReserveResponseCodeEnum;

/**
 * API响应, 默认状态码是成功
 */
public class Response {
	/**
	 * API接口名字
	 */
	private String apiName;
	/**
	 * 请求唯一标识符
	 */
	private String requestUuid;
	/**
	 * 错误码
	 */
	private String code = ReserveResponseCodeEnum.success.getCode();
	/**
	 * 错误提示
	 */
	private String message = ReserveResponseCodeEnum.success.getMessage();
	/**
	 * 错误堆栈
	 */
	private String stackTrace;

	private void error(String code, String message, String stackTrace) {
		if (ReserveResponseCodeEnum.success.getCode().equals(code)) {
			code = ReserveResponseCodeEnum.unknown_exception.getCode();
		}
		this.code = code;
		this.message = message;
		this.stackTrace = stackTrace;
	}

	public void error(ResponseCode responseCode) {
		error(responseCode.getCode(), responseCode.getMessage(), null);
	}

	public void error(ResponseCode responseCode, Throwable cause) {
		error(responseCode.getCode(), responseCode.getMessage(),
				cause == null ? null : ExceptionUtils.getStackTrace(cause));
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getRequestUuid() {
		return requestUuid;
	}

	public void setRequestUuid(String requestUuid) {
		this.requestUuid = requestUuid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
}
