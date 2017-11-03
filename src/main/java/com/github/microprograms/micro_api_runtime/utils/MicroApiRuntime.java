package com.github.microprograms.micro_api_runtime.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.enums.MicroApiReserveResponseCodeEnum;
import com.github.microprograms.micro_api_runtime.exception.MicroApiExecuteException;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.matchprocessor.ClassAnnotationMatchProcessor;

public class MicroApiRuntime {
    private static final Map<String, Class<?>> apiClasses = new HashMap<>();

    public static void scan(String... javaPackageNames) {
        new FastClasspathScanner(javaPackageNames).matchClassesWithAnnotation(MicroApiAnnotation.class, new ClassAnnotationMatchProcessor() {
            @Override
            public void processMatch(Class<?> classWithAnnotation) {
                String javaClassName = classWithAnnotation.getSimpleName();
                apiClasses.put(javaClassName, classWithAnnotation);
            }
        }).scan();
    }

    public static Response execute(String apiName, Request request) {
        request.setExecuteByEngineTimestamp(System.currentTimeMillis());
        Response response = null;
        try {
            Class<?> apiClass = apiClasses.get(apiName);
            Method method = apiClass.getMethod("execute", Request.class);
            response = (Response) method.invoke(null, request);
            response.setOverByEngineTimestamp(System.currentTimeMillis());
            return response;
        } catch (Throwable e) {
            if (response == null) {
                response = new Response();
            }
            if (e instanceof MicroApiExecuteException) {
                MicroApiExecuteException passthrough = (MicroApiExecuteException) e;
                response.error(passthrough.getResponseCode(), passthrough.getCause());
            } else {
                response.error(MicroApiReserveResponseCodeEnum.api_execute_exception, e);
            }
            response.setOverByEngineTimestamp(System.currentTimeMillis());
            return response;
        }
    }
}
