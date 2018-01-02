package com.github.microprograms.micro_api_runtime.enums;

import com.github.microprograms.micro_api_runtime.model.ResponseCode;

/**
 * 保留响应码枚举, 保留范围0~999
 */
public enum MicroApiReserveResponseCodeEnum implements ResponseCode {
    /**
     * 成功
     */
    success(0, "成功"),
    /**
     * 请求数据无法解析
     */
    request_data_cannot_be_resolved_exception(1, "请求数据无法解析"),
    /**
     * API未找到
     */
    api_not_found_exception(2, "API未找到"),
    /**
     * API未实现
     */
    api_not_implemented_exception(3, "API未实现"),
    /**
     * 缺少必填的参数
     */
    missing_required_parameters_exception(4, "缺少必填的参数"),
    /**
     * 无效的参数
     */
    invalid_parameters_exception(5, "无效的参数"),
    /**
     * 未登录
     */
    unknown_operator_exception(6, "未登录"),
    /**
     * 没有权限
     */
    permission_denied_exception(7, "没有权限"),
    /**
     * 资源不存在或已被删除
     */
    resource_not_exists_exception(8, "资源不存在或已被删除"),
    /**
     * 非法请求
     */
    illegal_request_exception(9, "非法请求"),
    /**
     * 数据已被修改，请重新操作
     */
    concurrency_modification_exception(10, "数据已被修改，请重新操作"),
    /**
     * API执行异常
     */
    api_execute_exception(11, "API执行异常"),
    /**
     * 未知异常
     */
    unknown_exception(12, "未知异常");

    private final int code;
    private final String message;

    private MicroApiReserveResponseCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override()
    public int getCode() {
        return code;
    }

    @Override()
    public String getMessage() {
        return message;
    }
}
