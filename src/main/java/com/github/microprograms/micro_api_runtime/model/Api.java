package com.github.microprograms.micro_api_runtime.model;

import com.github.microprograms.micro_api_runtime.exception.PassthroughException;

/**
 * API接口
 */
public interface Api {

	Response execute(Request request) throws PassthroughException;
}
