package com.github.microprograms.micro_api_runtime.model;

public class Request {
	/**
	 * API接口名字
	 */
	private String apiName;
	/**
	 * 请求唯一标识符
	 */
	private String uuid;
	/**
	 * 请求发送时间
	 */
	private long sendToEngineTimestamp;
	/**
	 * 请求被服务器开始处理的时间戳
	 */
	private long executeByEngineTimestamp;

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

	public long getSendToEngineTimestamp() {
		return sendToEngineTimestamp;
	}

	public void setSendToEngineTimestamp(long sendToEngineTimestamp) {
		this.sendToEngineTimestamp = sendToEngineTimestamp;
	}

	public long getExecuteByEngineTimestamp() {
		return executeByEngineTimestamp;
	}

	public void setExecuteByEngineTimestamp(long executeByEngineTimestamp) {
		this.executeByEngineTimestamp = executeByEngineTimestamp;
	}
}
