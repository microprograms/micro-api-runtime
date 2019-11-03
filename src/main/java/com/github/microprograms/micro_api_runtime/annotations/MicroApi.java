package com.github.microprograms.micro_api_runtime.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ TYPE })
public @interface MicroApi {

	/**
	 * @return 唯一标识符
	 */
	String name();

	/**
	 * @return 版本
	 */
	String version();
}
