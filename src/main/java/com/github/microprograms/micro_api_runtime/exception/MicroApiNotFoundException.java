package com.github.microprograms.micro_api_runtime.exception;

public class MicroApiNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    private String apiName;

    public MicroApiNotFoundException(String apiName) {
        super(apiName);
        this.apiName = apiName;
    }

    public String getApiName() {
        return apiName;
    }
}
