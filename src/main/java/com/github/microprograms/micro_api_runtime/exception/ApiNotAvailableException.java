package com.github.microprograms.micro_api_runtime.exception;

public class ApiNotAvailableException extends Exception {
	private static final long serialVersionUID = 1L;
	private String name;

	public ApiNotAvailableException(String name) {
		super(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
