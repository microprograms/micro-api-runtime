package com.github.microprograms.micro_api_runtime.exception;

public class ModuleNotAvailableException extends Exception {
	private static final long serialVersionUID = 1L;
	private String name;

	public ModuleNotAvailableException(String name) {
		super(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
