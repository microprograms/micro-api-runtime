package com.github.microprograms.micro_api_runtime.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.github.microprograms.micro_api_runtime.enums.MicroApiTypeEnum;

@Retention(RUNTIME)
@Target(TYPE)
public @interface MicroApiAnnotation {
    /**
     * @return 类型
     */
    MicroApiTypeEnum type();

    /**
     * @return 版本
     */
    String version();
}
