package com.github.microprograms.micro_api_runtime.model;

/**
 * API接口
 */
public interface Api {

	Response execute(Request request) throws Exception;
}
