package com.github.microprograms.micro_api_runtime.model;

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
	private String uuid;

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
