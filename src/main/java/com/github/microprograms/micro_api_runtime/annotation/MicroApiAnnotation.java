package com.github.microprograms.micro_api_runtime.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface MicroApiAnnotation {
    /**
     * @return 类型
     */
    String type();

    /**
     * @return 版本
     */
    String version();
}
