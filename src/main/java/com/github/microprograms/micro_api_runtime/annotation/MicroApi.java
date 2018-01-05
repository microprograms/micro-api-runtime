package com.github.microprograms.micro_api_runtime.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface MicroApi {
    /**
     * @return 备注
     */
    String comment() default "";

    /**
     * @return 详情
     */
    String description() default "";

    /**
     * @return 类型
     */
    String type() default "";

    /**
     * @return 版本
     */
    String version();
}
