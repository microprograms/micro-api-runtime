package com.github.microprograms.micro_api_runtime.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface PrimaryKey {
    /**
     * @return 0表示不是主键,大于0表示是主键,数值为联合主键排序号
     */
    int value() default 0;
}
