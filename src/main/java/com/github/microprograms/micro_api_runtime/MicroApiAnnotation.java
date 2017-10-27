package com.github.microprograms.micro_api_runtime;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface MicroApiAnnotation {
    /**
     * @return 版本
     */
    String version() default "";
}
