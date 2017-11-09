package com.github.microprograms.micro_api_runtime.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.microprograms.micro_api_runtime.annotation.MicroApiAnnotation;
import com.github.microprograms.micro_api_runtime.model.Request;
import com.github.microprograms.micro_api_runtime.model.Response;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.matchprocessor.ClassAnnotationMatchProcessor;

public class MicroApiRuntime {
    private static final Logger log = LoggerFactory.getLogger(MicroApiRuntime.class);
    private static final Map<String, ApiWrapper> apis = new HashMap<>();

    public static void scan(String... javaPackageNames) {
        new FastClasspathScanner(javaPackageNames).matchClassesWithAnnotation(MicroApiAnnotation.class, new ClassAnnotationMatchProcessor() {
            @Override
            @SuppressWarnings("unchecked")
            public void processMatch(Class<?> apiClass) {
                String apiName = apiClass.getSimpleName();
                if (contains(apiName)) {
                    log.error("duplicate api, apiName={}, class={}", apiName, apiClass.getName());
                }
                ApiWrapper apiWrapper = new ApiWrapper();
                apiWrapper.setApiClass(apiClass);
                for (Class<?> subClass : apiClass.getDeclaredClasses()) {
                    if (Request.class.isAssignableFrom(subClass)) {
                        apiWrapper.setRequestClass((Class<? extends Request>) subClass);
                    }
                    if (Response.class.isAssignableFrom(subClass)) {
                        apiWrapper.setResponseClass((Class<? extends Response>) subClass);
                    }
                }
                apis.put(apiName, apiWrapper);
                log.info("api loaded, apiName={}, class={}", apiName, apiClass.getName());
            }
        }).scan();
    }

    public static boolean contains(String apiName) {
        return apis.containsKey(apiName);
    }

    public static ApiWrapper get(String apiName) {
        return apis.get(apiName);
    }

    public static class ApiWrapper {
        private Class<?> apiClass;
        private Class<? extends Request> requestClass = Request.class;
        private Class<? extends Response> responseClass = Response.class;

        public Response execute(Request request) throws Exception {
            request.setExecuteByEngineTimestamp(System.currentTimeMillis());
            Method method = apiClass.getMethod("execute", Request.class);
            Response response = (Response) method.invoke(null, request);
            response.setOverByEngineTimestamp(System.currentTimeMillis());
            return response;
        }

        public Class<?> getApiClass() {
            return apiClass;
        }

        public void setApiClass(Class<?> apiClass) {
            this.apiClass = apiClass;
        }

        public Class<? extends Request> getRequestClass() {
            return requestClass;
        }

        public void setRequestClass(Class<? extends Request> requestClass) {
            this.requestClass = requestClass;
        }

        public Class<? extends Response> getResponseClass() {
            return responseClass;
        }

        public void setResponseClass(Class<? extends Response> responseClass) {
            this.responseClass = responseClass;
        }
    }
}
