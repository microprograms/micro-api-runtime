package com.github.microprograms.micro_api_runtime.model;

public abstract class Operator<T> {
    private final String uniqueId;
    private final String readableName;
    private final boolean permissionDenied;
    private final T raw;

    public Operator(String uniqueId, String readableName, boolean permissionDenied, T raw) {
        this.uniqueId = uniqueId;
        this.readableName = readableName;
        this.permissionDenied = permissionDenied;
        this.raw = raw;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getReadableName() {
        return readableName;
    }

    public boolean isPermissionDenied() {
        return permissionDenied;
    }

    public T getRaw() {
        return raw;
    }
}
