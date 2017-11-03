package com.github.microprograms.micro_api_runtime.enums;

public enum MicroApiTypeEnum {
    /**
     * 只读
     */
    read,
    /**
     * 读写
     */
    write;

    public static MicroApiTypeEnum parse(String string) {
        for (MicroApiTypeEnum x : values()) {
            if (x.toString().equalsIgnoreCase(string)) {
                return x;
            }
        }
        return null;
    }
}
