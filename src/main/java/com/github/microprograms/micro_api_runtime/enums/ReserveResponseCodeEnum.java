package com.github.microprograms.micro_api_runtime.enums;

import com.github.microprograms.micro_api_runtime.model.ResponseCode;

/**
 * 保留响应码枚举
 */
public enum ReserveResponseCodeEnum implements ResponseCode {
	/**
	 * 成功
	 */
	success("success", "成功"),
	/**
	 * 请求数据无法解析
	 */
	request_data_cannot_be_resolved_exception("request_data_cannot_be_resolved_exception", "请求数据无法解析"),
	/**
	 * 模块不可用
	 */
	module_not_available_exception("module_not_available_exception", "模块不可用"),
	/**
	 * API不可用
	 */
	api_not_available_exception("api_not_available_exception", "API不可用"),
	/**
	 * API未实现
	 */
	api_not_implemented_exception("api_not_implemented_exception", "API未实现"),
	/**
	 * 缺少必填的参数
	 */
	missing_required_parameters_exception("missing_required_parameters_exception", "缺少必填的参数"),
	/**
	 * 无效的参数
	 */
	invalid_parameters_exception("invalid_parameters_exception", "无效的参数"),
	/**
	 * 未登录
	 */
	unknown_operator_exception("unknown_operator_exception", "未登录"),
	/**
	 * 没有权限
	 */
	permission_denied_exception("permission_denied_exception", "没有权限"),
	/**
	 * 非法请求
	 */
	illegal_request_exception("illegal_request_exception", "非法请求"),
	/**
	 * 资源不存在或已被删除
	 */
	resource_not_exists_exception("resource_not_exists_exception", "资源不存在或已被删除"),
	/**
	 * 数据已被修改，请重新操作
	 */
	concurrency_modification_exception("concurrency_modification_exception", "数据已被修改，请重新操作"),
	/**
	 * API执行异常
	 */
	api_execute_exception("api_execute_exception", "API执行异常"),
	/**
	 * 未知异常
	 */
	unknown_exception("unknown_exception", "未知异常");

	private final String code;
	private final String message;

	private ReserveResponseCodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
