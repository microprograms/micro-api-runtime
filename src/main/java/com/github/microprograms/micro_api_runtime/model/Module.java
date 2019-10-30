package com.github.microprograms.micro_api_runtime.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 模块
 */
public class Module {
	private Map<String, Api> apis = new HashMap<>();

	public boolean contains(String apiName) {
		return apis.containsKey(apiName);
	}

	public void putApi(String apiName, Api api) {
		apis.put(apiName, api);
	}

	public Api getApi(String apiName) {
		return apis.get(apiName);
	}

	public Map<String, Api> getApis() {
		return apis;
	}
}
