package com.github.microprograms.micro_api_runtime.model;

import java.util.UUID;

import com.alibaba.fastjson.JSONObject;

/**
 * API请求
 */
public class Request {
	/**
	 * API接口名字
	 */
	private String apiName;
	/**
	 * 请求唯一标识符
	 */
	private String requestId;
	/**
	 * 原始请求（JSON格式）
	 */
	private JSONObject rawRequest;

	public Request() {
	}

	public Request(String apiName, JSONObject rawRequest) {
		this(apiName, UUID.randomUUID().toString(), rawRequest);
	}

	public Request(String apiName, String requestId, JSONObject rawRequest) {
		this.apiName = apiName;
		this.requestId = requestId;
		this.rawRequest = rawRequest;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public JSONObject getRawRequest() {
		return rawRequest;
	}

	public void setRawRequest(JSONObject rawRequest) {
		this.rawRequest = rawRequest;
	}
}
